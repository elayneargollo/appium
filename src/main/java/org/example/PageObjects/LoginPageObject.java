package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject extends PageObjectBase {
    public String idUsuario;
    public String senha;

    public LoginPageObject(AppiumDriver driver){
        super(driver);
    }

    public void StepsLogin(String idUsuario, String senha){
        PreencherFormulario(idUsuario, senha);
        BuscarElementos();
        FinalizarLogin();
    }

    public void PreencherFormulario(String idUsuario, String senha){
        this.idUsuario = idUsuario;
        this.senha = senha;
    }

    @Override
    public void BuscarElementos(){
        driver.findElementById("br.com.alura.aluraesporte:id/input_usuario").sendKeys(idUsuario);
        driver.findElementById("br.com.alura.aluraesporte:id/input_senha").sendKeys(senha);
    }

    @Override
    public String VerificarMensagemErro(){
        By erroId = By.id("br.com.alura.aluraesporte:id/mensagem_erro_login");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(erroId));

        return driver.findElement(erroId).getText();
    }

    public void FinalizarLogin(){
        driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar").click();
    }

    public void IrParaTelaCadastro(){
        driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario").click();
    }
}