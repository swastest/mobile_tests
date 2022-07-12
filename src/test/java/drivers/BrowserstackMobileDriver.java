package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.ConfigCenter;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    @Override
    public WebDriver createDriver(Capabilities capabilities) {

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        mutableCapabilities.setCapability("browserstack.user", ConfigCenter.browserStackConfig.username());
        mutableCapabilities.setCapability("browserstack.key", ConfigCenter.browserStackConfig.accessKey());
        mutableCapabilities.setCapability("app", ConfigCenter.browserStackConfig.app());

        mutableCapabilities.setCapability("device", ConfigCenter.browserStackConfig.device());
        mutableCapabilities.setCapability("os_version", ConfigCenter.browserStackConfig.osVersion());

        mutableCapabilities.setCapability("project", ConfigCenter.browserStackConfig.project());
        mutableCapabilities.setCapability("build", ConfigCenter.browserStackConfig.build());
        mutableCapabilities.setCapability("name", ConfigCenter.browserStackConfig.name());
        return new RemoteWebDriver(getBrowserstackUrl(), mutableCapabilities);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(ConfigCenter.browserStackConfig.bsUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}