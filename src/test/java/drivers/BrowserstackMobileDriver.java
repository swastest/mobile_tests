package drivers;

import com.codeborne.selenide.WebDriverProvider;
import configs.BrowserstackInterface;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    static BrowserstackInterface browserStackConfig = ConfigFactory.create(BrowserstackInterface.class);

    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", browserStackConfig.username());
        mutableCapabilities.setCapability("browserstack.key", browserStackConfig.accessKey());
        mutableCapabilities.setCapability("app", browserStackConfig.app());

        mutableCapabilities.setCapability("device", browserStackConfig.device());
        mutableCapabilities.setCapability("os_version", browserStackConfig.osVersion());

        mutableCapabilities.setCapability("project", browserStackConfig.project());
        mutableCapabilities.setCapability("build", browserStackConfig.build());
        mutableCapabilities.setCapability("name", browserStackConfig.name());
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(browserStackConfig.bsUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}