
import java.sql.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RelatarProblemaPage {	
	private DSL DSL;

	public RelatarProblemaPage(WebDriver driver) {
		DSL = new DSL(driver);
	}
	
	public void SetResumo(String text) {
		DSL.Escreve("//*[@id=\"summary\"]", text);
	}
	
	public String ValidaResumo(){
		return DSL.obterValorCampo("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[10]/td");
	}
	
	public String GetNum(){
		return DSL.obterValorCampo("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[2]/td[1]");
	}
	
	public void SetDescricao(String text) {
		DSL.Escreve("//*[@id=\"description\"]", text);
	}
	
	public String ValidaDescricao(){
		return DSL.obterValorCampo("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[11]/td");
	}
	
	public void SelecionaComboCategoria(String text) {
		DSL.SelecionaCombo("//*[@id=\"category_id\"]", text);
	}
	
	public String ValidaComboCategoria(){
		return DSL.obterValorCampo("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[2]/td[3]");
	}
	
	public void SelecionaComboFrequencia(String text) {
		DSL.SelecionaCombo("//*[@id=\"reproducibility\"]", text);
	}
	
	public String ValidaComboFrequencia(){
		return DSL.obterValorCampo("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[6]/td[3]");
	}
	
	public void SelecionaComboGravidade(String text) {
		DSL.SelecionaCombo("//*[@id=\"severity\"]", text);
	}
	
	public String ValidaComboGravidade(){
		return DSL.obterValorCampo("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[6]/td[2]");
	}
	
	public void SelecionaComboPrioridade(String text) {
		DSL.SelecionaCombo("//*[@id=\"priority\"]", text);
	}
	
	public String ValidaComboPrioridade(){
		return DSL.obterValorCampo("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[6]/td[1]");
	}
	
	public void SetPassoReproduzir(String text) {
		DSL.Escreve("//*[@id=\"steps_to_reproduce\"]", text);
	}
	
	public String ValidaPassoReproduzir(){
		return DSL.obterValorCampo("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[12]/td");
	}
	
	public void SetInfoAdicional(String text) {
		DSL.Escreve("//*[@id=\"additional_info\"]", text);
	}
	
	public String ValidaInfoAdicional(){
		return DSL.obterValorCampo("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[13]/td");
	}
	
	
	public void SelecionaComboMarcadores(String text) {
		DSL.SelecionaCombo("//*[@id=\"tag_select\"]", text);
	}
	
	public String ValidaComboMarcadores(){
		return DSL.obterValorCampo("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[14]/td/a[1]");
	}
	
	public String ValidaTextoMarcadores(){
		return DSL.obterValorCampo("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[14]/td");
	}
	
	public void ButtonCriaTarefa() {
		DSL.ClickaButton("//*[@id=\"report_bug_form\"]/div/div[2]/div[2]/input");
	}	
	
	public void RetiraMarcador() {
		DSL.ClickaButton("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tbody/tr[14]/td/a[2]");
	}
	
	public void ClickaMonitorarTask() {
		DSL.ClickaButton("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tfoot/tr/td/div/div[4]/form/fieldset/input[3]");
	}
	
	public void AbreMinhaVisao() {
		DSL.ClickaButton("//*[@id=\"sidebar\"]/ul/li[1]/a");
	}
	
	public void AbreMonitoradosPorMim() {
		DSL.ClickaButton("//*[@id=\"monitored\"]/div[2]/div/div/table/tbody/tr/td[2]/span[1]");
	}
	
	public void PararDeMonitorar() {
		DSL.ClickaButton("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tfoot/tr/td/div/div[4]/form/fieldset/input[3]");
	}
	
	public String ValorBotaoMonitorar(){
		return DSL.obterValueCampo("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tfoot/tr/td/div/div[4]/form/fieldset/input[3]");
	}
	
	public void CriarClone() {
		DSL.ClickaButton("//*[@id=\"main-container\"]/div[2]/div[2]/div/div[1]/div/div[2]/div[2]/div/table/tfoot/tr/td/div/div[5]/form/fieldset/input[3]");
	}
	
	
}
