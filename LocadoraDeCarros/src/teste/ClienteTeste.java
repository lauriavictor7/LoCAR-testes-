package teste;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.dbunit.Assertion;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;

import locacao.Locacao;

import java.sql.Statement;

import veiculo.DadosVeiculo;

public class ClienteTeste extends DatabaseTestCase {
    
    private FlatXmlDataSet carregarBanco;
	private Connection conn;

	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		Class driverClass = Class.forName("com.mysql.jdbc.Driver");
		Connection jdbcConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/locadora", "root", "");
		
		return new DatabaseConnection(jdbcConn);
	}
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		carregarBanco = new FlatXmlDataSetBuilder().build(new FileInputStream("xml/DataSet.xml"));
		
		return carregarBanco;
	}
	
	public void testarQtdRegistros() throws Exception {
		IDataSet dados = getConnection().createDataSet();
		int qtd = dados.getTable("cliente").getRowCount();
		
		assertEquals(4, qtd);
	}
        
        public void testeCadastrarCliente() throws Exception {
            ITable atual = getConnection().createQueryTable("s", "INSERT nome FROM cliente");
            
            assertEquals("", atual.getValue(0, "nome"));
        }
	
	public void testeAtualizarCliente() throws Exception {
		ITable atual = getConnection().createQueryTable("s", "SELECT nome FROM cliente WHERE ID = 01");
		
		assertEquals("", atual.getValue(0, "nome"));		
	}
	
  /*  public void situacaoCliente() throws Exception {
   	 	DadosCliente dc = new DadosCliente();
   	 	dc.getConnection();
   	 
        String sql = "UPDATE cliente SET nome = '*' WHERE nome = '*' ";
        ITable atual = getConnection().createQueryTable("s", sql);
        
        assertEquals("*", atual.getValue(0, "cliente.nome"));
    }*/
    
	public void testarBanco() throws Exception {
		IDataSet dados = getConnection().createDataSet();
		ITable tabela = dados.getTable("cliente");
		
		IDataSet dadosSetEsperados = new FlatXmlDataSetBuilder().build(new FileInputStream("xml/DataSet.xml"));
		ITable dadosEsperados = dadosSetEsperados.getTable("cliente");
		
		Assertion.assertEquals(dadosEsperados, tabela);
	}
}
