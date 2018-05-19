package teste;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;

import org.dbunit.Assertion;
import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import veiculo.DadosVeiculo;
import veiculo.Veiculo;

public class TestVeicle extends DatabaseTestCase {
	
	private FlatXmlDataSet loadDataBase;
	
	Veiculo v = new Veiculo();
	DadosVeiculo dv = new DadosVeiculo();
	
	public void utilAdd() throws Exception {
		v.setVei_placa("ccc3333");
		v.setVei_cor("amarelo");
		v.setVei_situacao("ocupado");
		v.setVei_modelo("fox");
		v.setVei_tipo("hatch");
		
		dv.cadastrarVeiculo(v);
	}
	
	@Override
	protected IDatabaseConnection getConnection() throws Exception {
		Class driverClass = Class.forName("com.mysql.jdbc.Driver");
		Connection jdbcConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/locadora", "root", "");
		
		return new DatabaseConnection(jdbcConn);
	}
	
	@Override
	protected IDataSet getDataSet() throws Exception {
		loadDataBase = new FlatXmlDataSetBuilder().build(new FileInputStream("xml/DataSet.xml"));
		
		return loadDataBase;
	}
	
	protected DatabaseOperation getSetUpOperation()
			throws Exception {
				return  DatabaseOperation.REFRESH;
			}
	
	protected DatabaseOperation getTearDownOperation()
			throws Exception {
				return DatabaseOperation.NONE;
		}
	
	//This test return the quantity of registries on table 'veiculo'.
	public void testOfQuantity() throws Exception {
		IDataSet data = getConnection().createDataSet();
		int quantity = data.getTable("veiculo").getRowCount();
		
		assertEquals(3, quantity);
	}
	
	//This test returns the veicle with the color reported.
	public void testFindByColor() throws Exception {
		ITable table = getConnection().createQueryTable("s", "SELECT vei_cor FROM veiculo WHERE vei_placa = 'aaa1111'");
		
		assertEquals("lilas", table.getValue(0, "vei_cor"));		
	}
	
	//This test refers to the registration of a new user with a same pk already saved.
	public void testAddSamePK() throws Exception {
		utilAdd();

		IDataSet data = getConnection().createDataSet();
		ITable table = data.getTable("veiculo");
		
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("xml/DataSet.xml"));
		ITable result = dataSet.getTable("veiculo");
		
		Assertion.assertEquals(result,table);
	}
	
	//This test refers to the registration of a new user on database.
	public void testAdd() throws Exception {
		IDataSet data = getConnection().createDataSet();
		ITable table = data.getTable("veiculo");
		
		IDataSet dataSet = new FlatXmlDataSetBuilder().build(new FileInputStream("xml/Verify.xml"));
		ITable result = dataSet.getTable("veiculo");
		
		Assertion.assertEquals(result, table);
	}
}
