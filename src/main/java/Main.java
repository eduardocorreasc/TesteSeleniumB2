import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	private WebDriver driver;
	private DSL DSL;
	private RelatarProblemaPage page;
	
	public void start(){
		System.setProperty("webdriver.chromedriver.driver", System.getProperty("user.dir") + "SeleniumB2\\src\\test\\chromedriver.exe");
		driver = new ChromeDriver();
		DSL = new DSL(driver);
		page = new RelatarProblemaPage(driver);
		
		driver.manage().window().maximize();
		driver.get("http://mantis-prova.base2.com.br");
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Eduardo_Perkowsky");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("jogabonito1");
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/input[3]")).click();
	}
	
	//Given que sou um usuário logado
	//When eu crio um novo problema
	//Then o problema deve ser criado com as informações que eu informei
	
	@Test
	public void TesteCriaProblema() throws InterruptedException {
		start();
		Thread.sleep(5000);
		
		//Cria o problema
		DSL.AbreRelatarProblema();
		page.SelecionaComboCategoria("[Todos os Projetos] categoria teste");
		page.SelecionaComboFrequencia("sempre");
		page.SelecionaComboGravidade("grande");
		page.SelecionaComboPrioridade("alta");
		page.SetResumo("Problema nos testes encontrado automaticamente");
		page.SetDescricao("Problema grave encontrado quando se faz cadastro");
		page.SetPassoReproduzir("Login no sistema, faz um cadastro e valida");
		page.SetInfoAdicional("Problema encontrado no teste regressivo");
		page.SelecionaComboMarcadores("teste");
		page.ButtonCriaTarefa();
		Thread.sleep(5000);
		
		//Valida se o problema foi criado com as informações corretamente
		assertEquals("[Todos os Projetos] categoria teste", page.ValidaComboCategoria());
		assertEquals("sempre", page.ValidaComboFrequencia());
		assertEquals("grande", page.ValidaComboGravidade());
		assertEquals("alta", page.ValidaComboPrioridade());
		assertEquals(page.GetNum() + ": Problema nos testes encontrado automaticamente", page.ValidaResumo()); 
		assertEquals("Problema grave encontrado quando se faz cadastro", page.ValidaDescricao());
		assertEquals("Login no sistema, faz um cadastro e valida", page.ValidaPassoReproduzir());
		assertEquals("Problema encontrado no teste regressivo", page.ValidaInfoAdicional());
		assertEquals("teste", page.ValidaComboMarcadores());
		driver.quit();
	}
	
	//Given sou um usuário logado
	//When eu retiro um marcado do problema
	//Then o problema não deve mais ter um marcador
	
	@Test
	public void TestTiraMarcadores() throws InterruptedException {
		start();
		Thread.sleep(5000);
		
		//Cria o problema
		DSL.AbreRelatarProblema();
		page.SelecionaComboCategoria("[Todos os Projetos] categoria teste");
		page.SelecionaComboFrequencia("sempre");
		page.SelecionaComboGravidade("grande");
		page.SelecionaComboPrioridade("alta");
		page.SetResumo("Problema nos testes encontrado automaticamente");
		page.SetDescricao("Problema grave encontrado quando se faz cadastro");
		page.SetPassoReproduzir("Login no sistema, faz um cadastro e valida");
		page.SetInfoAdicional("Problema encontrado no teste regressivo");
		page.SelecionaComboMarcadores("teste");
		page.ButtonCriaTarefa();
		Thread.sleep(5000);
		
		//Valida que foi criado com marcador
		assertEquals("teste", page.ValidaComboMarcadores());
		//Retira o marcador e valida que foi retirado corretamente
		page.RetiraMarcador();
		assertEquals("Nenhum marcador aplicado.", page.ValidaTextoMarcadores());
		driver.quit();
	}
	
	//Given sou um usuário logado
	//When eu monitoro um problema
	//Then o problema deve aparecer nos monitorados por mim
		
	@Test
	public void TesteMonitorarProblema() throws InterruptedException {
		start();
		Thread.sleep(5000);
		
		//Cria o problema
		DSL.AbreRelatarProblema();
		page.SelecionaComboCategoria("[Todos os Projetos] categoria teste");
		page.SelecionaComboFrequencia("sempre");
		page.SelecionaComboGravidade("grande");
		page.SelecionaComboPrioridade("alta");
		page.SetResumo("Problema nos testes encontrado automaticamente");
		page.SetDescricao("Problema grave encontrado quando se faz cadastro");
		page.SetPassoReproduzir("Login no sistema, faz um cadastro e valida");
		page.SetInfoAdicional("Problema encontrado no teste regressivo");
		page.SelecionaComboMarcadores("teste");
		page.ButtonCriaTarefa();
		Thread.sleep(5000);
		page.ClickaMonitorarTask();
		String valorCampo = page.GetNum();
		page.AbreMinhaVisao();		
		page.AbreMonitoradosPorMim();
		//Valida que foi a task que foi adicionada como monitorada
		assertEquals(valorCampo, page.GetNum());
		driver.quit();
	}
	
	//Given sou um usuário logado
	//When eu retiro um item monitorado por mim
	//Then o problema não deve mais ser monitorado por mim
	@Test
	public void TesteRetirarMonitorarProblema() throws InterruptedException {
		start();
		Thread.sleep(5000);
		
		//Cria o problema
		DSL.AbreRelatarProblema();
		page.SelecionaComboCategoria("[Todos os Projetos] categoria teste");
		page.SelecionaComboFrequencia("sempre");
		page.SelecionaComboGravidade("grande");
		page.SelecionaComboPrioridade("alta");
		page.SetResumo("Problema nos testes encontrado automaticamente");
		page.SetDescricao("Problema grave encontrado quando se faz cadastro");
		page.SetPassoReproduzir("Login no sistema, faz um cadastro e valida");
		page.SetInfoAdicional("Problema encontrado no teste regressivo");
		page.SelecionaComboMarcadores("teste");
		page.ButtonCriaTarefa();
		Thread.sleep(5000);
		page.ClickaMonitorarTask();
		//String valorCampo = page.GetNum();
		page.AbreMinhaVisao();		
		page.AbreMonitoradosPorMim();
		page.PararDeMonitorar();
		Thread.sleep(2000);
		//Valida que o botão voltou a ser "Monitorar"
		assertEquals("Monitorar", page.ValorBotaoMonitorar());
		driver.quit();
	}
	
		//Given sou um usuário logado
		//When eu clono um problema
		//Then o problema deve ser criado com as informações corretamente
		@Test
		public void CloneProblema() throws InterruptedException {
			start();
			Thread.sleep(5000);
			
			//Cria o problema
			DSL.AbreRelatarProblema();
			page.SelecionaComboCategoria("[Todos os Projetos] categoria teste");
			page.SelecionaComboFrequencia("sempre");
			page.SelecionaComboGravidade("grande");
			page.SelecionaComboPrioridade("alta");
			page.SetResumo("Defeito encontrado por testes manuais");
			page.SetDescricao("Defeito encontrado ao logar no sisema");
			page.SetPassoReproduzir("Tentar logar no sistema");
			page.SetInfoAdicional("Problema encontrado nos testes manuais");
			page.SelecionaComboMarcadores("teste");
			page.ButtonCriaTarefa();
			Thread.sleep(5000);
			
			//Cria um clone desse problema
			page.CriarClone();
			page.ButtonCriaTarefa();
			
			Thread.sleep(5000);
			//Valida se o clone foi criado com as informações corretamente
			assertEquals("[Todos os Projetos] categoria teste", page.ValidaComboCategoria());
			assertEquals("sempre", page.ValidaComboFrequencia());
			assertEquals("grande", page.ValidaComboGravidade());
			assertEquals("alta", page.ValidaComboPrioridade());
			assertEquals(page.GetNum() + ": Defeito encontrado por testes manuais", page.ValidaResumo()); 
			assertEquals("Defeito encontrado ao logar no sisema", page.ValidaDescricao());
			assertEquals("Tentar logar no sistema", page.ValidaPassoReproduzir());
			assertEquals("Problema encontrado nos testes manuais", page.ValidaInfoAdicional());	
			driver.quit();
		}		
}
