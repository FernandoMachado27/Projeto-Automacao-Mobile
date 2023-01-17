package br.com.fernando.appium.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.fernando.appium.core.BasePage;
import br.com.fernando.appium.core.DriverFactor;

public class SplashPage extends BasePage{
	
	public boolean isTelaSplashVisivel() {
		return existeUmElementoPorTexto("Splash!");
	}

	public void aguardarSplashSumir() {
		DriverFactor.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(DriverFactor.getDriver(), 10);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@text='Splash!']")));
	}

}
