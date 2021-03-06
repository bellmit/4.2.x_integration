APPSERVER_HOME="$GRIDTALK_HOME/jboss-4.2.3.GA"
#
JAVA_HOME="$GRIDTALK_HOME/jre150_20"
#
ANT_HOME="$GRIDTALK_HOME/../jakarta-ant-1.5.1-bin"
#
DB_HOME="$GRIDTALK_HOME/pgsql"
#
DATA_HOME="$GRIDTALK_HOME/data"
#
# set path to Ant and Java
PATH="$ANT_HOME/bin:$JAVA_HOME/bin:$PATH"
#
# application specific environment settings
APPLICATION="GT(GridTalk)"
#
# database specific environment settings
DB_STARTUP_CMD="startPostgres.sh"
DB_SHUTDOWN_CMD="stopPostgres.sh"
#
# application server specific environment settings
APPSERVER_LOG_DIR="$APPSERVER_HOME/logs/server/"
APPSERVER_LOG_EXT=log
APPSERVER_CMD_DIR="$APPSERVER_HOME/bin"
APPSERVER_STARTUP_CMD="run.sh"
APPSERVER_STARTUP_MSG="Started in"
APPSERVER_SHUTDOWN_CMD="shutdown.sh --server=localhost:31099"
APPSERVER_SHUTDOWN_MSG="Shutdown complete"
#
export APPSERVER_HOME JAVA_HOME ANT_HOME DB_HOME DATA_HOME PATH 
export APPLICATION DB_STARTUP_CMD DB_SHUTDOWN_CMD 
export APPSERVER_LOG_DIR APPSERVER_LOG_EXT APPSERVER_CMD_DIR 
export APPSERVER_STARTUP_CMD APPSERVER_STARTUP_MSG APPSERVER_SHUTDOWN_CMD APPSERVER_SHUTDOWN_MSG
