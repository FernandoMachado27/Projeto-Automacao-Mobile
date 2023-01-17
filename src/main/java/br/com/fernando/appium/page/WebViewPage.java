package br.com.fernando.appium.page;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import br.com.fernando.appium.core.BasePage;
import br.com.fernando.appium.core.DriverFactor;

public class WebViewPage extends BasePage{
	
	public void entrarContextoWeb() {
		Set<String> contextHandles = DriverFactor.getDriver().getContextHandles();
		for(String valor:contextHandles) {
			System.out.println(valor);
		}
		DriverFactor.getDriver().context((String)contextHandles.toArray()[1]);
	}
	
	public void setEmail(String valor) {
		DriverFactor.getDriver().findElement(By.id("email")).sendKeys(valor);
	}
	
	public void setSenha(String valor) {
		DriverFactor.getDriver().findElement(By.id("senha")).sendKeys(valor);
	}
	
	public void entrarConta() {
		DriverFactor.getDriver().findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public String getMensagem() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public void sairContextoWeb() {
		DriverFactor.getDriver().context((String)DriverFactor.getDriver().getContextHandles().toArray()[0]);
	}

}
