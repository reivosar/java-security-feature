package log4jshell;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

class Log4J_1_2_17_Behavior extends Log4JBehavior {
    
    private static final Logger LOGGER = LogManager.getLogger("VERSION_1_2_17");
    
    @Override
    void log(String param) {
        LOGGER.info(param);
    }
    
    @Override
    void log(Parameter param) {
        LOGGER.info(param.toString());
    }
}
