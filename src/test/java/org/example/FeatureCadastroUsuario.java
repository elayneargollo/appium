package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.example.PageObjects.CadastroPageObject;
import org.example.PageObjects.LoginPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class FeatureCadastroUsuario
{
    AppiumDriver driver = AppiumDriverConfigSingleton.Instance().driver;
    LoginPageObject telaLogin = new LoginPageObject(driver);

    @Test
    public void cadastro_com_senha_que_nao_conferem() {
        telaLogin.IrParaTelaCadastro();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);
        telaCadastro.StepsCadastroUsuario("elayne", "A1b2C3d4", "A1b2C3d4!");

        Assert.assertEquals("Senhas não conferem", telaCadastro.VerificarMensagemErro());

        driver.navigate().back();
    }

    @Test
    public void cadastro_novo_usuario_com_senhas_que_conferem() {
        telaLogin.IrParaTelaCadastro();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);
        telaCadastro.StepsCadastroUsuario("elayne", "A1b2C3d4!", "A1b2C3d4!");

        MobileElement loginButton = (MobileElement) driver.findElement(By.id("br.com.alura.aluraesporte:id/login_botao_logar"));
        Assert.assertEquals("LOGAR", loginButton.getText());
    }

    @Test
    public void cadastro_usuario_ja_cadastrado() {
        telaLogin.IrParaTelaCadastro();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);
        telaCadastro.StepsCadastroUsuario("elayne", "A1b2C3d4!", "A1b2C3d4!");

        driver.navigate().back();

        telaLogin.IrParaTelaCadastro();
        telaCadastro.StepsCadastroUsuario("elayne", "A1b2C3d5!", "A1b2C3d5!");

        Assert.assertEquals("Usuario já Cadastrado", telaCadastro.VerificarMensagemErro());
    }

    @Test
    public void cadastro_com_senha_curta() {
        telaLogin.IrParaTelaCadastro();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);
        telaCadastro.StepsCadastroUsuario("elayne", "12", "12");

        Assert.assertEquals("Senha muito curta", telaCadastro.VerificarMensagemErro());
    }

    @Test
    public void cadastro_com_campos_vazios() {
        telaLogin.IrParaTelaCadastro();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);
        telaCadastro.StepsCadastroUsuario("", "", "");

        Assert.assertEquals("Campos obrigatórios vazios", telaCadastro.VerificarMensagemErro());
    }

    @Test
    public void cadastro_com_senha_muito_longa() {
        telaLogin.IrParaTelaCadastro();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);

        // Supondo que a senha não possa ter mais de 8 caracteres
        String senhaMuitoLonga = "1234567891011";
        telaCadastro.StepsCadastroUsuario("elayne", senhaMuitoLonga, senhaMuitoLonga);

        Assert.assertEquals("Senha muito longa", telaCadastro.VerificarMensagemErro());
    }

    @Test
    public void cadastro_com_senha_fraca() {
        telaLogin.IrParaTelaCadastro();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);

        // Supondo que a senha fraca não atende aos critérios de uma senha forte
        String senhaFraca = "senha123";
        telaCadastro.StepsCadastroUsuario("elayne", senhaFraca, senhaFraca);

        Assert.assertEquals("Senha muito fraca", telaCadastro.VerificarMensagemErro());
    }
}