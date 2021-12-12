package log4jshell;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

class Log4J_Version1_Behavior extends Log4JBehavior {
    
    private static final Logger LOGGER = LogManager.getLogger("log4j");
    
    @Override
    void log(String param) {
        LOGGER.info(param);
    }
    
    @Override
    void log(Parameter param) {
        LOGGER.info(param.toString());
    }
}
