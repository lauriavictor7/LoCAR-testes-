package veiculo;

import dados.Dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;

import cliente.Cliente;
import locacao.Locacao;


public class DadosVeiculo extends Dados implements InterfaceVeiculo{

   
    @Override
    public void situacaoVeiculoOc(Locacao v) throws Exception {
       Statement conex = conectar();
        String sql = "Update Veiculo set vei_situacao = 'Ocupado' where vei_placa = ? ";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, v.getVeiculo().getVei_placa());
            cmd.execute();
        } catch (Exception e) {
            throw new Exception("Erro ao executar atualiza��o: " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public void situacaoVeiculoLi(Locacao v) throws Exception {
       Statement conex = conectar();
        String sql = "update Veiculo set vei_situacao = 'Livre' from Veiculo as v inner join Locacao as l on v.vei_placa = l.vei_placa where l.loc_codigo = ?";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, v.getLoc_codigo());
            cmd.execute();
        } catch (Exception e) {
            throw new Exception("Erro ao executar atualiza��o: " + e.getMessage());
        }
        desconectar();
     
    }
    
	public IDatabaseConnection getConnection() throws Exception {
		Class driverClass = Class.forName("com.mysql.jdbc.Driver");
		Connection jdbcConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/locadora", "root", "");
		
		return new DatabaseConnection(jdbcConn);
	}

	@Override
		public void cadastrarVeiculo(Veiculo v) throws Exception {
			conectar();
	        String sql = "INSERT INTO veiculo (vei_placa, vei_cor, vei_situacao, vei_modelo, vei_tipo) ";
	        sql += "Values (?, ?, ?, ? ,?) ";
	        try {
	            //executando a instru��o sql
	            PreparedStatement cmd = conn.prepareStatement(sql);
	            cmd.setString(1, v.getVei_placa());
	            cmd.setString(2, v.getVei_cor());
	            cmd.setString(3, v.getVei_situacao());
	            cmd.setString(4, v.getVei_modelo());
	            cmd.setString(5, v.getVei_tipo());
	
	            cmd.execute();
	        } catch (SQLException e) {
	            //caso haja algum erro neste método será levantada esta execeção
	            throw new Exception("Erro ao executar inser��o: " + e.getMessage());
	        }
	        //fechando a conexão com o banco de dados
	        desconectar();
		}

	@Override
	public void atualizarVeiculo(Veiculo v) throws Exception {
        //abrindo a conexão
        Statement conex = conectar();
        //instru��oo sql correspondente a inserção do aluno
        String sql = "update veiculo set vei_placa = ?, vei_cor = ?, vei_situacao = ?, vei_modelo = ?, vei_tipo = ? ;";
        try {
            //executando a instru��o sql
            PreparedStatement cmd = conn.prepareStatement(sql);

            cmd.setString(1, v.getVei_placa());
            cmd.setString(2, v.getVei_cor());
            cmd.setString(3, v.getVei_situacao());
            cmd.setString(4, v.getVei_modelo());
            cmd.setString(5, v.getVei_tipo());

            cmd.execute();
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao executar atualiza��o: " + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();		
		
	}

	@Override
	public void removerVeiculo(Veiculo v) throws Exception {
	        conectar();
	        //instru��oo sql correspondente a inserção do aluno
	        String sql = "delete from veiculo where vei_placa = ? ;";
	        try {
	            //executando a instru��o sql
	            PreparedStatement cmd = conn.prepareStatement(sql);
	            cmd.setString(1, v.getVei_placa());

	            cmd.execute();
	        } catch (SQLException e) {
	            //caso haja algum erro neste método será levantada esta execeção
	            throw new Exception("Erro ao executar inser��o: " + e.getMessage());
	        }
	        //fechando a conexão com o banco de dados
	        desconectar();
		
	}
	
	public Veiculo buscarVeiculo(String placa) throws Exception {
        Veiculo retorno = new Veiculo();
        //abrindo a conexão
        conectar();
        
        Veiculo v = new Veiculo();
        
        //instru��oo sql correspondente a inserção 
        String sql = "select vei_placa, vei_cor, vei_situacao, vei_modelo, vei_tipo";
        sql += " from veiculo where vei_placa = ? ";

        try {
            //executando a instru��o sql
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, placa);
            
            //
            ResultSet leitor = cmd.executeQuery();
            if (leitor.next()) {
            	
            	v.setVei_placa(placa);
            	v.setVei_placa(leitor.getString("vei_placa"));
                v.setVei_cor(leitor.getString("vei_cor"));
                v.setVei_situacao(leitor.getString("vei_situacao"));
                v.setVei_modelo(leitor.getString("vei_modelo"));
                v.setVei_tipo(leitor.getString("vei_tipo"));
            }
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao executar inser��o: " + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
        return v;
    }
	
}
