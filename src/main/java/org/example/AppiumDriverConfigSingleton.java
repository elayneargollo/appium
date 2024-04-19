package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverConfigSingleton
{
    public final AppiumDriver driver;
    private static AppiumDriverConfigSingleton _instance;

    public static AppiumDriverConfigSingleton Instance(){
        if(AppiumDriverConfigSingleton._instance == null){
            AppiumDriverConfigSingleton._instance = new AppiumDriverConfigSingleton();
        }
        return AppiumDriverConfigSingleton._instance;
    }

    private AppiumDriverConfigSingleton() {
        File apk = new File("C:\\Users\\elayne.argollo\\Documents\\appium_test\\appium\\src\\main\\resources\\alura_esporte.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);

        String uiAutomator2Driver = "UiAutomator2";
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, uiAutomator2Driver);

        String urlServerAppium = "http://127.0.0.1:4723";

        URL urlConexao = null;
        try {
            urlConexao = new URL(urlServerAppium);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AppiumDriver<>(urlConexao,capabilities);
    }
}
