package log4jshell;

abstract class Log4JBehavior {
    
    protected Log4JBehavior() {
    }
    
    abstract void log(String param);
    
    abstract void log(Parameter param);
}
