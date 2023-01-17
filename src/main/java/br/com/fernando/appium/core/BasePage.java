package br.com.fernando.appium.core;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	
	public void escreverNomeFormulario(String nome) {
		MobileElement campoNome = (MobileElement) DriverFactor.getDriver().findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys(nome);
	}
	
	public void checarNomeFormulario(String nome) {
		MobileElement campoNome = (MobileElement) DriverFactor.getDriver().findElement(MobileBy.AccessibilityId("nome"));
		Assert.assertEquals(nome, campoNome.getText());
	}
	
	public void clicarPorTexto(String texto) {
		DriverFactor.getDriver().findElement(By.xpath("//*[@text='"+texto+"']")).click();
	}

	public void selecionarComboFormulario(String valor) {
		MobileElement combo = (MobileElement) DriverFactor.getDriver().findElement(MobileBy.AccessibilityId("console"));
		combo.click();
		clicarPorTexto(valor); // seleciona o texto que você quer
	}

	public void checarComboSelecionadoFormulario(String combo) {
		String text = DriverFactor.getDriver().findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText(); // uma vez que localizei o Spinner, continue a busca dele pela classe abaixo
		Assert.assertEquals(combo, text);
	}

	public boolean isCheckMarcado(By by) { // método que é apenas alterar o By 
		return DriverFactor.getDriver().findElement(by).getAttribute("checked").equals("true");
	}

	public void clicarNoCheck() {
		MobileElement check = (MobileElement) DriverFactor.getDriver().findElement(By.className("android.widget.CheckBox"));
		check.click();
	}

	public void clicarNoSwitch() {
		MobileElement switc =  (MobileElement) DriverFactor.getDriver().findElement(MobileBy.AccessibilityId("switch")); // por content-desc
		switc.click();
	}

	public String obterTexto(By by) {
		return DriverFactor.getDriver().findElement(by).getText();
	}
	
	public boolean existeUmElementoPorTexto(String texto) {
		List<MobileElement> list = DriverFactor.getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return list.size()>0; // se tiver um elemento quer dizer que ele encontrou alguma coisa na tela
	}
	
	public void tap(int x, int y) { // método por coordenada
		TouchAction action = new TouchAction(DriverFactor.getDriver());
		action.tap(PointOption.point(x,y)).perform();
	}
	
	public void scroll(double inicio, double fim) { 
		Dimension size = DriverFactor.getDriver().manage().window().getSize(); // pegar a dimensão da tela
		
		int x = size.width / 2; // metade da largura
		
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		
		TouchAction action = new TouchAction(DriverFactor.getDriver());
		action.press(PointOption.point(x, start_y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(x, end_y)).release().perform();
		// release() -> solta a tela  perform() -> executa a ação
	}
	
	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}

	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
	}
	
	public void swipe(double inicio, double fim) {
		Dimension size = DriverFactor.getDriver().manage().window().getSize();
		
		int y = size.height / 2; // metade da altura
		
		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);
		
		TouchAction action = new TouchAction(DriverFactor.getDriver());
		action.press(PointOption.point(start_x, y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(end_x,y)).release().perform();
	}
	
	public void scrollDown() {
		scroll(0.9, 0.1);
	}
	
	public void scrollUp() {
		scroll(0.1, 0.9);
	}
	
	public void swipeLeft() {
		swipe(0.1, 0.9);
	}

	public void swipeRight() {
		swipe(0.1, 0.9);
	}
	
	public void clicarDragNDrop() {
		WebDriverWait wait = new WebDriverWait(DriverFactor.getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
		scrollDown();
		clicarPorTexto("Drag and drop");
	}
	
	public void cliqueLongo(By by) {
		new TouchAction <> (DriverFactor.getDriver()).longPress(PointOption.point(DriverFactor.getDriver().findElement(by).getCenter()));
	}
}
