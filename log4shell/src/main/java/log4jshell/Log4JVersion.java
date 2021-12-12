package log4jshell;

import java.util.Arrays;

enum Log4JVersion {
    VERSION_1("1", new Log4J_Version1_Behavior()),
    VERSION_2("2", new Log4J_Version2_Behavior()),
    ;
    
    private final String version;
    
    private final Log4JBehavior log4JBehavior;
    
    Log4JVersion(String version, Log4JBehavior log4JBehavior) {
        this.version = version;
        this.log4JBehavior = log4JBehavior;
    }
    
    void behavior(String param) {
        log4JBehavior.log(param);
        log4JBehavior.log(new Parameter(param));
    }
    
    static Log4JVersion versionOf(String version) {
        return Arrays.stream(values())
                .filter(e -> e.version.equals(version))
                .findFirst().orElse(VERSION_2);
    }
    
    @Override
    public String toString() {
        return "log4J version: " + version;
    }
}
