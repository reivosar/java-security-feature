package log4jshell;

import java.util.Arrays;

enum Log4JVersion {
    VERSION_1_2_17("1.2.17", new Log4J_1_2_17_Behavior()),
    VERSION_2_6_1("2.6.1", new Log4J_2_6_1_Behavior()),
    NONE(null, new Log4J_2_6_1_Behavior());
    
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
                .findFirst().orElse(NONE);
    }
    
    @Override
    public String toString() {
        return "log4J version: " + version;
    }
}
