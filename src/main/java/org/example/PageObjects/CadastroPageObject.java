package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObject extends PageObjectBase{

    public String nome;
    public String senha;
    public String confirmarSenha;

    public CadastroPageObject(AppiumDriver driver){
        super(driver);
    }

    @Override
    public void BuscarElementos(){
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_nome")).sendKeys(nome);
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_senha")).sendKeys(senha);
        driver.findElement(By.id("br.com.alura.aluraesporte:id/input_confirmar_senha")).sendKeys(confirmarSenha);
    }

    @Override
    public String VerificarMensagemErro(){
        By erroId = By.id("br.com.alura.aluraesporte:id/erro_cadastro");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(erroId));

        return driver.findElement(erroId).getText();
    }

    public void StepsCadastroUsuario(String nome, String senha, String confirmarSenha){
        PreencherFormulario(nome,senha,confirmarSenha);
        BuscarElementos();
        FinalizarCadastro();
    }

    public void PreencherFormulario(String nome, String senha, String confirmarSenha){
        this.nome = nome;
        this.senha = senha;
        this.confirmarSenha = confirmarSenha;
    }

    public void FinalizarCadastro(){
        driver.findElement(By.id("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar")).click();
    }

}