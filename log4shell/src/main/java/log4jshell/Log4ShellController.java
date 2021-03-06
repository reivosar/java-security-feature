package log4jshell;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/log4shell")
public class Log4ShellController {
    
    @PostMapping("/v1")
    public String version_1(@RequestParam("p") String param) {
        return handleRequest(Log4JVersion.VERSION_1, param);
    }
    
    @PostMapping("/v2")
    public String version_2(@RequestParam("p") String param) {
        return handleRequest(Log4JVersion.VERSION_2, param);
    }
    
    private String handleRequest(Log4JVersion log4JVersion, String param) {
        log4JVersion.behavior(param);
        return log4JVersion.toString();
    }
}
