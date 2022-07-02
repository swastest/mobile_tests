package configs;
import org.aeonbits.owner.Config;


@Config.Sources(
        "classpath:properties/bStackDriver.properties")

public interface StackInterface extends Config {
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
