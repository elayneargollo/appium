package org.example;

import io.appium.java_client.AppiumDriver;
import org.example.PageObjects.CadastroPageObject;
import org.example.PageObjects.LoginPageObject;
import org.example.PageObjects.ProductListPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class FeatureListaProduto {
    AppiumDriver driver = AppiumDriverConfigSingleton.Instance().driver;

    @Test
    public void mostra_listar_de_produtos(){
        LoginPageObject telaLogin = new LoginPageObject(driver);
        telaLogin.IrParaTelaCadastro();

        CadastroPageObject telaCadastro = new CadastroPageObject(driver);
        telaCadastro.StepsCadastroUsuario("elayne", "A1b2C3d4!", "A1b2C3d4!");

        telaLogin.StepsLogin("elayne", "A1b2C3d4!");

        ProductListPageObject telaListaProdutos = new ProductListPageObject(driver);
        telaListaProdutos.BuscarElementos();

        //String textoElemento = driver.findElement(By.name("Lista de produtos")).getText();
        //Assert.assertTrue("Texto não contém 'Lista de produtos'", textoElemento.contains("Lista de produtos"));
    }
}
