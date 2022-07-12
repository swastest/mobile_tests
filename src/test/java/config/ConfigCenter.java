package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigCenter {
    public static BrowserstackInterface browserStackConfig = ConfigFactory.create(BrowserstackInterface.class,
            System.getProperties());
    public static LocalMobileInterface configLocal = ConfigFactory.create(LocalMobileInterface.class,
            System.getProperties());
}
