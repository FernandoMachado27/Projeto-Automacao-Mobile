package br.com.fernando.appium.page;

import org.openqa.selenium.By;

import br.com.fernando.appium.core.BasePage;
import br.com.fernando.appium.core.DriverFactor;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage{
	
	public void escreverNome(String nome) {
		escreverNomeFormulario(nome);
	}
	
	public void checarNome(String nome) {
		checarNomeFormulario(nome);
	}
	
	public void selecionarCombo(String valor) {
		selecionarComboFormulario(valor);
	}
	
	public void checarComboSelecionado(String valor) {
		checarComboSelecionadoFormulario(valor);
	}
	
	public void clicarCheck() {
		clicarNoCheck();
	}
	
	public void clicarSwitch() {
		clicarNoSwitch();
	}
	
	public boolean isCheckMarcado() {
		return isCheckMarcado(By.className("android.widget.CheckBox")); // método que é apenas alterar o By 
	}
	
	public boolean isSwitchMarcado() {
		return isCheckMarcado(MobileBy.AccessibilityId("switch")); // método que é apenas alterar o By 
	}

	public void clicarSalvar() {
		clicarPorTexto("SALVAR");
	}
	
	public void clicarSalvarDemorado() {
		clicarPorTexto("SALVAR DEMORADO");
	}

	public String checarNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Nome:')]"));
	}
	
	public String checarConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Console:')]"));
	}
	
	public String checarSwitchCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Switch:')]"));
	}
	
	public String checarCheckCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text, 'Checkbox:')]"));
	}
	
	public void clicarSeekBar(double posicao) { // arrastar volume
		MobileElement seek = DriverFactor.getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int y = seek.getLocation().y + (seek.getSize().height / 2); // localização do y nas coordenadas
		System.out.println(y); 
		
		int x = (int) (seek.getLocation().x + (seek.getSize().width * posicao));
		System.out.println(x);
		
		tap(x, y);
	}

}
