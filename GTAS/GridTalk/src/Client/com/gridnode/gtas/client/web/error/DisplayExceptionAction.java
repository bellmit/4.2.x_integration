/**
 * This software is the proprietary information of GridNode Pte Ltd.
 * Use is subjected to license terms.
 *
 * Copyright 2001-2002 (C) GridNode Pte Ltd. All Rights Reserved.
 *
 * File: DisplayExceptionAction.java
 *
 ****************************************************************************
 * Date           Author              Changes
 ****************************************************************************
 * 2002-10-28     Andrew Hill         Created
 * 2002-10-29     Andrew Hill         Render view directly from action for 'safety'
 * 2003-02-19     Andrew Hill         Enhancements and bugfix to fallback error rendering
 * 2003-02-20     Andrew Hill         Use different navgroup if not logged in
 * 2003-03-25     Andrew Hill         Dont add PWL renderer to pipe
 * 2003-05-17     Andrew Hill         Make colours for fallback error less shocking (darn it - its SUPPOSED to be shocking! grrr)
 */
package com.gridnode.gtas.client.web.error;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.gridnode.gtas.client.GTClientException;
import com.gridnode.gtas.client.web.IGlobals;
import com.gridnode.gtas.client.web.IRequestKeys;
import com.gridnode.gtas.client.web.StaticWebUtils;
import com.gridnode.gtas.client.web.navigation.NavigationRenderer;
import com.gridnode.gtas.client.web.renderers.*;
import com.gridnode.gtas.client.web.strutsbase.ActionContext;
import com.gridnode.gtas.client.web.strutsbase.GTActionBase;
import com.gridnode.gtas.client.web.xml.IDocumentKeys;
import com.gridnode.gtas.client.web.xml.IDocumentManager;

public class DisplayExceptionAction extends GTActionBase
{
  /*protected String getNavgroup(ActionContext actionContext)
    throws com.gridnode.gtas.client.GTClientException
  { //20030220AH - Return diffent navgroup if not logged in so dont get default header
    return loggedIn(actionContext) ? "navgroup_error" : "navgroup_error_noLogin";
  }*/
	/*
  private boolean loggedIn(ActionContext actionContext)
    throws GTClientException
  { //20030220AH - Check to see if user is logged into gtas or not
    //@todo - consider moving this method to GTActionBase
    try
    {
      IGTSession gtasSession = getGridTalkSession(actionContext);
      return gtasSession.isLoggedIn();
    }
    catch(NoSessionException nse)
    {
      return false;
    }
  }*/

  public ActionForward execute(ActionMapping mapping,
                                ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
                                throws Exception
  {
    //this code could be better...
    ActionContext actionContext = new ActionContext(mapping,form,request,response);
    Throwable t = getThrowable(actionContext);
    try
    {
      actionContext.getRequest().setAttribute(IRequestKeys.REQUEST_EXCEPTION,t);
      Throwable rootEx = StaticWebUtils.getRootException(t);
      actionContext.getRequest().setAttribute(IRequestKeys.REQUEST_ROOT_EXCEPTION,rootEx);
      ActionErrors actionErrors = new ActionErrors();
      actionErrors.add( IGlobals.EXCEPTION_ERROR_PROPERTY, getActionErrorForThrowable(t) );
      saveErrors(actionContext.getRequest(), actionErrors);
      IRenderingPipeline rPipe = getRenderingPipeline(actionContext);
      try
      {
        //We try to render the view directly from the action so if something is wrong in this
        //action our fallback below will be used and we wont enter an endless loop! (An error
        //in the RenderingAction would bring us back here...)
        RenderingUtils.renderPipeline(response.getWriter(), rPipe);
        return null; // Response has been written in the action. No forward to return.
      }
      catch(Throwable t2)
      {
        throw new ExceptionRenderingExceptionException("Error rendering error screen to response",
                  t2,t); //20030219AH
      }
    }
    catch(Throwable t3)
    { // Fall back to display the error!
      // Yes. This has been invoked and IS useful! (for example on 20021210...)
      renderFallbackReport(actionContext, t3, t); //20030219AH
      return null;
    }
  }

  protected void renderFallbackReport(ActionContext actionContext,
                                      Throwable errorRenderingError,
                                      Throwable originalError)
    throws ExceptionRenderingExceptionException
  { //20030219AH
    try
    { //This is a last resort error reporting mechanism. Users should never see a screen
      //in production generated by this method...
      //(...of course they probably will :-< )
      //20030517AH - and they did, and the colours shocked them so now I have to
      //change it. I mean really.... this is like the the 'mother of all errors'
      //its supposed to shock them! This fallback screen is only supposed to show if something
      // has really
      //stuffed up (and so even the normal error screen cant work). When things are that
      //bad they should be on the phone to tech support right away with a category A complaint!
      //We dont want them to feel comfortable about it - we want them to scream about it to us 
      // so we know about it asap and
      //can fix it asap - and until then the user should be scared to touch anything more! (cos
      //when its this bad doing anything could cause who knows what problems!)
      PrintWriter w = actionContext.getResponse().getWriter();
      w.write("<html><head><title>Error displaying error</title>"
      + "</head><body text=\"black\" bgcolor=\"white\"><pre>");
      w.write("<h2>Error when attempting to render error</h2>");
      //Provide detail on the error that stopped us rendering an error
      w.write("An error occured - and while attempting to render the details"
            + " for that error another error occured that prevented the normal error display"
            + " screen being used.<br/>"
            + " Please print or copy the contents of this screen"
            + " and contact technical support with the following details:\n");
      w.write("<hr/><h3>Error that occured when rendering error:<h3/>");
      w.write("<font color=\"black\" size=\"2\">");
      StaticWebUtils.printStackTrace(errorRenderingError, w);
      w.write("</font>");
      //Provide detail on the error we were trying to render
      w.write("<hr/><h3>Error being rendered:</h3>");
      w.write("<font color=\"black\" size=\"2\">");
      if(originalError == null)
      {
        w.write("null");
      }
      else
      {
        originalError.printStackTrace(w);
      }
      w.write("</font>");
      //20021210 - Add code to ensure root exception is shown:
      //(ServletException is notorious for not including it when writing its stack trace for example)
      w.write("<hr/><h3>Root exception of error being rendered:</h3>");
      Throwable root = StaticWebUtils.getRootException(originalError);
      w.write("<font color=\"black\" size=\"2\">");
      if(root == null)
      {
        w.write("null");
      }
      else
      {
        root.printStackTrace(w);
      }
      w.write("</font>");
      w.write("</pre></body></html>");
    }
    catch(Throwable t4)
    {
      // Getting a bit ridiculous ;-)
      throw new ExceptionRenderingExceptionException(
                "Error when rendering error thrown while rendering error",
                t4,
                originalError);
    }
  }

  protected Throwable getThrowable(ActionContext actionContext)
  {
    try
    {
      return (Throwable)actionContext.getRequest().getAttribute(IRequestKeys.REQUEST_EXCEPTION);
    }
    catch(Throwable t)
    {
      t.printStackTrace();
      return null;
    }
  }

  protected IRenderingPipeline getRenderingPipeline(ActionContext actionContext)
    throws GTClientException
  {
    RenderingContext rContext = createRenderingContext(actionContext);
    ArrayList insertions = new ArrayList(1);
    insertions.add( new InsertionDef("page_content", "insert_page", true, false, IDocumentKeys.BLANK, false) );
    MultiNodeInsertionRenderer templateRenderer = new MultiNodeInsertionRenderer(rContext,insertions);
    BaseTagRenderer baseTagRenderer = new BaseTagRenderer(actionContext.getRequest(), "base_tag");
    NavigationRenderer navRenderer = new NavigationRenderer(rContext,
                                                            getProcessedPath(actionContext),
                                                            actionContext.getMapping()); //20030310AH
    RenderingPipelineImpl rPipe = new RenderingPipelineImpl(IDocumentKeys.TEMPLATE,rContext.getDocumentManager());

    rPipe.addRenderer(templateRenderer);
    rPipe.addRenderer(baseTagRenderer);
    rPipe.addRenderer(navRenderer);
    /*20030325AH - addPartnerWatchListRenderer(actionContext, rContext, rPipe); //20030219AH */
    addCommonContentRenderer(actionContext, rContext, rPipe);
    return rPipe;
  }

  /*20030325AH - protected void addPartnerWatchListRenderer(ActionContext actionContext,
                              RenderingContext rContext,
                              RenderingPipelineImpl rPipe)
    throws GTClientException
  { //20030219AH - Make addition of PWL conditional on having an IGTSession
    try
    {
      try
      {
        IGTSession gtasSession = this.getGridTalkSession(actionContext);
      }
      catch(NoSessionException nse)
      {
        return;
      }
      //20021214AH - Give error screen a PWL
      String wlUrl = actionContext.getMapping().findForward(IGlobals.WATCHLIST_MAPPING).getPath();
      long pwlInterval = ((GTActionMapping)actionContext.getMapping()).getPwlRefreshInterval();
      PartnerWatchListRenderer  partnerWatchListRenderer
                              = new PartnerWatchListRenderer(rContext,wlUrl,pwlInterval);
      //...
      rPipe.addRenderer(partnerWatchListRenderer); //20021214AH

    }
    catch(Throwable t)
    {
      throw new GTClientException("Error adding PartnerWatchListRenderer to rendering pipeline",t);
    }
  }*/

  protected RenderingContext createRenderingContext(ActionContext actionContext)
    throws GTClientException
  {
    ISimpleResourceLookup rLookup = createResourceLookup(actionContext);
    ActionErrors actionErrors = getActionErrors(actionContext.getRequest());
    IDocumentManager docMgr = getDocumentManager();
    IURLRewriter urlRewriter = new URLRewriterImpl( actionContext.getResponse(),
                                                    actionContext.getRequest().getContextPath(),
                                                    null);
    RenderingContext rContext = new RenderingContext( null,
                                                      docMgr,
                                                      rLookup,
                                                      urlRewriter,
                                                      actionErrors,
                                                      actionContext.getRequest(),
                                                      getServlet().getServletContext());
    return rContext;
  }
}

