package br.com.fernando.appium.page;

import java.util.List;

import org.openqa.selenium.By;

import br.com.fernando.appium.core.BasePage;
import br.com.fernando.appium.core.DriverFactor;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.PointOption;

public class DragDropPage extends BasePage {
	
	public void arrastar(String origem, String destino) {
		MobileElement inicio = DriverFactor.getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
		MobileElement fim = DriverFactor.getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));
		
		TouchAction action = new TouchAction(DriverFactor.getDriver());
//		action.longPress(inicio).moveTo(fim).release().perform();
	}
	
	public String[]obterLista(){
		List<MobileElement> elements = DriverFactor.getDriver().findElements(By.className("android.widget.TextView"));
		String [] retorno = new String [elements.size()]; // lista de elementos 
		for(int i = 0; i < elements.size(); i++) { // imprimir elementos da lista
			retorno [i] = elements.get(i).getText(); // pega apenas o texto dos elementos
			System.out.println("\"" + retorno[i] + "\", ");
		}
		return retorno;
	}

}
