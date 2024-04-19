package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.example.PageObjects.CadastroPageObject;
import org.example.PageObjects.LoginPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class FeatureLoginUsuario {
    AppiumDriver driver = AppiumDriverConfigSingleton.Instance().driver;

    @Test
    public void usuario_ou_senha_invalidos(){
        driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar").click();

        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.StepsLogin("", "");

        Assert.assertEquals("Usuário ou senha inválidos", telaLogin.VerificarMensagemErro());
    }

    @Test
    public void usuario_com_senha_id_valido(){
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.IrParaTelaCadastro();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);
        telaCadastro.StepsCadastroUsuario("elayne", "A1b2C3d4!", "A1b2C3d4!");

        telaLogin.StepsLogin("elayne", "A1b2C3d4!");

        MobileElement icons = (MobileElement) driver.findElement(By.id("br.com.alura.aluraesporte:id/icon"));
        Assert.assertTrue(icons.isDisplayed());

        driver.navigate().back();
    }
}