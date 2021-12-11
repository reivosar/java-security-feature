package log4jshell;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class Log4J_2_6_1_Behavior extends Log4JBehavior {
    
    private static final Logger LOGGER = LogManager.getLogger("VERSION_2_6_1");
    
    @Override
    void log(String param) {
        LOGGER.info(param);
    }
    
    @Override
    void log(Parameter param) {
        LOGGER.info(param.toString());
    }
}
