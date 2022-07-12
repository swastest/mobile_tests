package config;
import org.aeonbits.owner.Config;

@Config.Sources("classpath:properties/bStackDriver.properties")
public interface BrowserstackInterface extends Config {
    String username();
    String accessKey();
    String project();
    String build();
    String name();
    String app();
    String device();
    String osVersion();
    String bsUrl();

}
