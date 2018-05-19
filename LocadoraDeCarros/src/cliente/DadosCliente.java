package cliente;

import dados.Dados;
import veiculo.Veiculo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DadosCliente extends Dados implements InterfaceCliente {

	public void cadastrar(Cliente c) throws Exception {

        conectar();
        String sql = "INSERT INTO Cliente (cli_num_doc ,cli_sexo, cli_nome, cli_dt_nascimento, cli_telefone, cli_email, cli_numero, cli_rua, cli_cidade, cli_estado, cli_cep, cli_bairro, cli_tipo) ";
        sql += "Values (? , ?, ?, ? ,? ,? ,? ,? ,? ,? ,? ,?, ?)";
        try {
            //executando a instru??o sql
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, c.getCli_num_doc());
            cmd.setString(2, c.getCli_sexo());
            cmd.setString(3, c.getCli_nome());
            cmd.setString(4, c.getCli_dt_nascimento());
            cmd.setString(5, c.getCli_telefone());
            cmd.setString(6, c.getCli_email());
            cmd.setString(7, c.getCli_numero());
            cmd.setString(8, c.getCli_rua());
            cmd.setString(9, c.getCli_cidade());
            cmd.setString(10, c.getCli_estado());
            cmd.setString(11, c.getCli_cep());
            cmd.setString(12, c.getCli_bairro());
            cmd.setString(13, c.getCli_tipo());
            cmd.execute();
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao executar inser??o: " + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();

    }
    

    @Override
    public void remover(Cliente c) throws Exception {
        conectar();
        //instru��oo sql correspondente a inserção do aluno
        String sql = "delete from Cliente where cli_num_doc = ? ;";
        try {
            //executando a instru��o sql
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, c.getCli_num_doc());

            cmd.execute();
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao executar inser��o: " + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
    }

    @Override
    public void atualizar(Cliente c) throws Exception {
        //abrindo a conexão
        Statement conex = conectar();
        //instru��oo sql correspondente a inserção do aluno
        String sql = "update Cliente set cli_nome = ?, cli_telefone = ?, cli_email = ?, cli_numero = ?, cli_rua = ?, cli_estado = ?, cli_cep = ?, cli_bairro = ?, cli_cidade = ? where cli_codigo = ? ;";
        try {
            //executando a instru��o sql
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, c.getCli_nome());
            cmd.setString(2, c.getCli_telefone());
            cmd.setString(3, c.getCli_email());
            cmd.setString(4, c.getCli_numero());
            cmd.setString(5, c.getCli_rua());
            cmd.setString(6, c.getCli_estado());
            cmd.setString(7, c.getCli_cep());
            cmd.setString(8, c.getCli_bairro());
            cmd.setString(9, c.getCli_cidade());
            cmd.setInt(10, c.getCli_codigo());
            cmd.execute();
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao executar atualiza��o: " + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();

    }

    @Override
    public ArrayList<Cliente> listar(Cliente filtro) throws Exception {
        int posPar = 1;
        ArrayList<Cliente> retorno = new ArrayList<>();
        //abrindo a conexão
        conectar();
        //instru��oo sql correspondente a inserção do aluno
        String sql = " select cli_codigo, cli_num_doc, cli_nome, cli_sexo, cli_dt_nascimento, cli_telefone,"
                + " cli_email, cli_estado, cli_cep, cli_cidade, cli_bairro, cli_rua, cli_numero ";
        sql += " from Cliente where cli_codigo > 0 ";

        if (filtro.getCli_codigo() > 0) {
            sql += " and cli_codigo = ?";
        }
        if (filtro.getCli_num_doc() != null && filtro.getCli_num_doc().trim().equals("") == false) {
            sql += " and cli_num_doc like ?";
        }

        try {
            //executando a instru��o sql
            PreparedStatement cmd = conn.prepareStatement(sql);

            if (filtro.getCli_num_doc() != null && filtro.getCli_num_doc().trim().equals("") == false) {
                cmd.setString(posPar, filtro.getCli_num_doc());
                posPar++;
            }
            //
            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {
                Cliente c = new Cliente();
                c.setCli_codigo(leitor.getInt("cli_codigo"));
                c.setCli_num_doc(leitor.getString("cli_num_doc"));
                c.setCli_nome(leitor.getString("cli_nome"));
                c.setCli_sexo(leitor.getString("cli_sexo"));
                c.setCli_dt_nascimento(leitor.getString("cli_dt_nascimento"));
                c.setCli_telefone(leitor.getString("cli_telefone"));
                c.setCli_email(leitor.getString("cli_email"));
                c.setCli_estado(leitor.getString("cli_estado"));
                c.setCli_cep(leitor.getString("cli_cep"));
                c.setCli_cidade(leitor.getString("cli_cidade"));
                c.setCli_bairro(leitor.getString("cli_bairro"));
                c.setCli_rua(leitor.getString("cli_rua"));
                c.setCli_numero(leitor.getString("cli_numero"));
                retorno.add(c);
            }
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao executar inser��o: " + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
        return retorno;
    }

    @Override
    public boolean existencia(Cliente c) throws Exception {
        boolean retorno = false;
        //abrindo a conexão
        conectar();
        //instru��oo sql correspondente a inserção do aluno
        String sql = " select Cli_num_doc, Cli_nome ";
        sql += " from Locadora where Cli_num_doc = ? ";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, c.getCli_num_doc());
            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {
                retorno = true;
                break;
            }
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao executar inser��o: " + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
        return retorno;
    }

    @Override
    public Cliente buscarCliente(Cliente filtro) throws Exception {
        Cliente retorno = new Cliente();
        //abrindo a conexão
        conectar();
        //instru��oo sql correspondente a inserção 
        String sql = " select cli_codigo, cli_num_doc, cli_nome, cli_sexo, cli_dt_nascimento, cli_telefone,"
                + " cli_email, cli_estado, cli_cep, cli_cidade, cli_bairro, cli_rua, cli_numero, cli_tipo ";
        sql += " from Cliente where cli_codigo = ? ";

        try {
            //executando a instru��o sql
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, filtro.getCli_codigo());
            

            //
            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {

                retorno.setCli_codigo(leitor.getInt("cli_codigo"));
                retorno.setCli_num_doc(leitor.getString("cli_num_doc"));
                retorno.setCli_nome(leitor.getString("cli_nome"));
                retorno.setCli_sexo(leitor.getString("cli_sexo"));
                retorno.setCli_dt_nascimento(leitor.getString("cli_dt_nascimento"));
                retorno.setCli_telefone(leitor.getString("cli_telefone"));
                retorno.setCli_email(leitor.getString("cli_email"));
                retorno.setCli_estado(leitor.getString("cli_estado"));
                retorno.setCli_cep(leitor.getString("cli_cep"));
                retorno.setCli_cidade(leitor.getString("cli_cidade"));
                retorno.setCli_bairro(leitor.getString("cli_bairro"));
                retorno.setCli_rua(leitor.getString("cli_rua"));
                retorno.setCli_numero(leitor.getString("cli_numero"));
                retorno.setCli_tipo(leitor.getString("cli_tipo"));
            }
        } catch (SQLException e) {
            //caso haja algum erro neste método será levantada esta execeção
            throw new Exception("Erro ao executar inser��o: " + e.getMessage());
        }
        //fechando a conexão com o banco de dados
        desconectar();
        return retorno;
    }

}
