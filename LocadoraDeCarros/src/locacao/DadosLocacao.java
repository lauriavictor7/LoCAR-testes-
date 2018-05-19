package locacao;

import dados.Dados;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import veiculo.Veiculo;

public class DadosLocacao extends Dados implements InterfaceLocacao {

    @Override
    public Locacao pesquisarLocacao(int loc_codigo) throws Exception {

        conectar();
        Locacao l = new Locacao();
        String sql;
        sql = "Select loc_codigo, loc_valor, loc_data_locacao, loc_data_entrega, vei_placa, cli_num_doc ";
        sql += " From Locacao where loc_codigo = ?";

        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, loc_codigo);
            ResultSet leitor = cmd.executeQuery();
            if (leitor.next()) {
                l.setLoc_codigo(loc_codigo);
                l.setLoc_valor(leitor.getDouble("loc_valor"));
                l.setLoc_data_entrega("loc_data_entrega");
                l.setLoc_data_locacao("loc_data_locacao");
                l.getVeiculo().setVei_placa(leitor.getString("vei_placa"));
                l.getCliente().setCli_num_doc(leitor.getString("cli_num_doc"));
            }
        } catch (SQLException e) {
            throw new Exception("Problemas ao pesquisar o NLV:" + e.getMessage());
        }
        desconectar();
        return l;

    }

    @Override
    public ArrayList<Locacao> listar(Locacao filtro) throws Exception {
        int posPar = 1;
        ArrayList<Locacao> retorno = new ArrayList<>();
        //abrindo a conex√£o
        conectar();
        //instruÁ„oo sql correspondente a inser√ß√£o do aluno
        String sql = " select l.loc_codigo, l.loc_valor, l.loc_data_locacao, l.loc_data_entrega, v.vei_placa, c.cli_num_doc ";
        sql += " from Locacao as l "
                + " inner join Veiculo as v on V.Vei_placa = l.vei_placa "
                + " inner join Cliente as c on l.cli_codigo = c.cli_codigo "
                + " where l.loc_codigo > 0 ";

        if (filtro.getLoc_codigo() > 0) {
            sql += " and l.loc_codigo = ?";
        }

        try {
            //executando a instruÁ„o sql
            PreparedStatement cmd = conn.prepareStatement(sql);

            if (filtro.getLoc_codigo() > 0) {
                cmd.setInt(posPar, filtro.getLoc_codigo());
                posPar++;
            }

            //
            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {
                Locacao l = new Locacao();
                l.setLoc_codigo(leitor.getInt("loc_codigo"));
                l.setLoc_valor(leitor.getDouble("loc_valor"));
                l.setLoc_data_entrega(leitor.getString("loc_data_entrega"));
                l.setLoc_data_locacao(leitor.getString("loc_data_locacao"));
                l.getCliente().setCli_num_doc(leitor.getString("cli_num_doc"));
                l.getVeiculo().setVei_placa(leitor.getString("Vei_placa"));
                retorno.add(l);
            }
        } catch (SQLException e) {
            //caso haja algum erro neste m√©todo ser√° levantada esta exece√ß√£o
            throw new Exception("Erro ao executar inserÁ„o: " + e.getMessage());
        }
        //fechando a conex√£o com o banco de dados
        desconectar();
        return retorno;
    }

    @Override
    public void cadastrarLocacao(Locacao l) throws Exception {

        conectar();
        String sql = "Insert into Locacao (loc_valor, loc_data_locacao, loc_data_entrega, vei_placa, cli_codigo)";
        sql += "Values (?,?,?,?,?)";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);

            cmd.setDouble(1, l.getLoc_valor());
            cmd.setString(2, l.getLoc_data_locacao());
            cmd.setString(3, l.getLoc_data_entrega());
            cmd.setString(4, l.getVeiculo().getVei_placa());
            cmd.setInt(5, l.getCliente().getCli_codigo());
            cmd.execute();
        } catch (SQLException e) {
            throw new Exception("Erro ao Executar a InserÁ„o: " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public void remover(Locacao l) throws Exception {
        conectar();
        //instruÁ„oo sql correspondente a inser√ß√£o do aluno
        String sql = "delete from Locacao where loc_codigo = ? ;";
        try {
            //executando a instruÁ„o sql
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, l.getLoc_codigo());
    

            cmd.execute();
        } catch (SQLException e) {
            //caso haja algum erro neste m√©todo ser√° levantada esta exece√ß√£o
            throw new Exception("Erro ao executar inserÁ„o: " + e.getMessage());
        }
        //fechando a conex√£o com o banco de dados
        desconectar();
    }

    @Override
    public Locacao buscarLocacao(Locacao filtro) throws Exception {
        Locacao retorno = new Locacao();
        //abrindo a conex√£o
        conectar();
        //instruÁ„oo sql correspondente a inser√ß√£o 
        String sql;
        sql = "select vei_placa, vei_modelo, vei_cor, vei_tipo, vei_situacao from Veiculo where vei_placa = ?";

        try {
            //executando a instruÁ„o sql
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setString(1, filtro.getVeiculo().getVei_placa());

            //
            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {

                retorno.getVeiculo().setVei_placa(leitor.getString("vei_placa"));
                retorno.getVeiculo().setVei_modelo(leitor.getString("vei_modelo"));
                retorno.getVeiculo().setVei_cor(leitor.getString("vei_cor"));
                retorno.getVeiculo().setVei_tipo(leitor.getString("vei_Tipo"));
                retorno.getVeiculo().setVei_situacao(leitor.getString("vei_situacao"));
            }
        } catch (SQLException e) {
            //caso haja algum erro neste m√©todo ser√° levantada esta exece√ß√£o
            throw new Exception("Erro ao executar inserÁ„o: " + e.getMessage());
        }
        //fechando a conex√£o com o banco de dados
        desconectar();
        return retorno;

    }

    @Override
    public void atualizarLocacao(Locacao l) throws Exception {
        Statement conex = conectar();
        String sql = "Update Locacao set loc_valor = ?, loc_data_entrega = ?, vei_placa = ?  where loc_codigo = ? ";
        try {
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setDouble(1, l.getLoc_valor());
            cmd.setString(2, l.getLoc_data_entrega());
            cmd.setString(3, l.getVeiculo().getVei_placa());
            cmd.setInt(4, l.getLoc_codigo());
            
            cmd.execute();
        } catch (Exception e) {
            throw new Exception("Erro ao executar atualizaÁ„o: " + e.getMessage());
        }
        desconectar();
    }

    @Override
    public Locacao buscarLocacaoCom(Locacao filtro) throws Exception {
         Locacao retorno = new Locacao();
        //abrindo a conex√£o
        conectar();
        //instruÁ„oo sql correspondente a inser√ß√£o 
        String sql;
        sql = "select c.cli_num_doc, l.vei_placa, l.loc_data_entrega, l.loc_data_locacao, l.loc_valor, c.cli_tipo, v.vei_situacao from Locacao as l inner join Cliente as c on l.Cli_codigo = c.cli_codigo inner join Veiculo as v on l.vei_placa = v.vei_placa where l.loc_codigo = ?";

        try {
            //executando a instruÁ„o sql
            PreparedStatement cmd = conn.prepareStatement(sql);
            cmd.setInt(1, filtro.getLoc_codigo());

            //
            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {

                retorno.getCliente().setCli_num_doc(leitor.getString("cli_num_doc"));
                retorno.getVeiculo().setVei_placa(leitor.getString("vei_placa"));
                retorno.setLoc_data_entrega(leitor.getString("loc_data_entrega"));
                retorno.setLoc_data_locacao(leitor.getString("loc_data_locacao"));
                retorno.setLoc_valor(leitor.getDouble("loc_valor"));
                retorno.getCliente().setCli_tipo(leitor.getString("cli_tipo"));
                retorno.getVeiculo().setVei_situacao(leitor.getString("vei_situacao"));
                

            }
            
        } catch (SQLException e) {
            //caso haja algum erro neste m√©todo ser√° levantada esta exece√ß√£o
            throw new Exception("Erro ao executar inserÁ„o: " + e.getMessage());
        }
        //fechando a conex√£o com o banco de dados
        desconectar();
        return retorno;
    }

}
