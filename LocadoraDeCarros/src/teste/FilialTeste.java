package teste;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;


public class FilialTeste extends DatabaseTestCase {
    
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
		int qtd = dados.getTable("filial").getRowCount();
		
		assertEquals(4, qtd);
	} 
        public void testeCadastrarCliente() throws Exception {
            ITable atual = getConnection().createQueryTable("i", "INSERT fil_cnpj FROM filial");
            
            assertEquals("", atual.getValue(0, "fil_cnpj"));
        }
	
	public void testeAtualizarCliente() throws Exception {
		ITable atual = getConnection().createQueryTable("s", "SELECT fil_cnpj FROM filial WHERE ID = 01");
		
		assertEquals("", atual.getValue(0, "fil_cnpj"));		
	}
    
}
