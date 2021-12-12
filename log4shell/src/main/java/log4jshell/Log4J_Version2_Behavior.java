package log4jshell;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Log4J_Version2_Behavior extends Log4JBehavior {
    
    private static final Logger LOGGER = LogManager.getLogger("log4j2");
    
    @Override
    void log(String param) {
        LOGGER.info(param);
    }
    
    @Override
    void log(Parameter param) {
        LOGGER.info(param.toString());
    }
}
