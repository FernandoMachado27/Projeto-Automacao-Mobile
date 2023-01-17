package br.com.fernando.appium.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class BaseTest { // comportamentos reproduzidos em varios testes
	
	@Rule
	public TestName testName = new TestName();
	
	@AfterClass // executa uma vez ao final de todos os metodos da classe
	public static void finalizaClasse() {
		DriverFactor.killDriver();
	}
	
	@After
	public void after() { // executar depois de cada teste
//		gerarScreenShot();
//		DriverFactor.getDriver().resetApp();
	}
	
	public void gerarScreenShot(){
		try {
			File imagem = ((TakesScreenshot)DriverFactor.getDriver()).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(imagem, new File("target/screenshots/"+testName.getMethodName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void esperar(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
