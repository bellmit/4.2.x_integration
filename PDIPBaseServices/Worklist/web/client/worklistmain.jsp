<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> New Document </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
</HEAD>
<BODY>

<BR>
<BR>
<H1> <b> WorkList User Logon   </b> </H1>
<HR>
<br>
<form method="post" action="<%=request.getContextPath()%>/GWFWorkListServlet" name="myfrm">
<br>
<TABLE>
<TR>
	<TD>UserName</TD>
	<TD><input type = "text" name="user"></TD>
</TR>
<TR>
	<TD>Password</TD>
	<TD><input type = "password" name="password"</TD>
</TR>
</TABLE>
<br>
<br>
&nbsp;&nbsp;
<input type = "Submit" name="Submit" value="Login">
&nbsp;&nbsp;
<input type = "reset"  name ="reset" value="Cancel">

</form>
</BODY>
</HTML>
