package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ProductListPageObject extends PageObjectBase {

    public ProductListPageObject(AppiumDriver driver){
        super(driver);
    }

    @Override
    public void BuscarElementos(){
        driver.findElementById("br.com.alura.aluraesporte:id/item_produto_nome").getText();
    }

    public void NavigateToProductDetails(String nomeProduto){
        driver.findElement(By.id("br.com.alura.aluraesporte:id/item_produto_nome" + nomeProduto)).click();
    }

    @Override
    public String VerificarMensagemErro() {
        return "";
    }
}