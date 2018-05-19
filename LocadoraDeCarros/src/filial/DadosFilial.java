package filial;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import dados.Dados;


public class DadosFilial extends Dados implements InterfaceFilial{

    @Override
    public ArrayList<Filial> listar(Filial filtro) throws Exception {
      int posPar = 1;
        ArrayList<Filial> retorno = new ArrayList<>();
        //abrindo a conex√£o
        conectar();
        //instruÁ„oo sql correspondente a inser√ß√£o do aluno
        String sql = " select fil_cnpj, fil_telefone, fil_email, fil_numero, fil_rua, fil_bairro, fil_cidade, fil_estado, fil_cep ";
        sql += " from Filial where fil_cnpj is not null ";
        if (filtro.getFil_cnpj() != null && filtro.getFil_cnpj().trim().equals("") == false) {
            sql += " and fil_cnpj = ?";
        }
        if (filtro.getFil_telefone() != null && filtro.getFil_telefone().trim().equals("") == false) {
            sql += " and fil_telefone like ? ";
        }
        if (filtro.getFil_email() != null && filtro.getFil_email().trim().equals("") == false) {
            sql += " and fil_email like ? ";
        }
         if (filtro.getFil_numero() != null && filtro.getFil_numero().trim().equals("") == false) {
            sql += " and Fil_numero like ? ";
        }
         if (filtro.getFil_rua() != null && filtro.getFil_rua().trim().equals("") == false) {
            sql += " and Fil_rua like ? ";
        }
         if (filtro.getFil_bairro() != null && filtro.getFil_bairro().trim().equals("") == false) {
            sql += " and Fil_bairro like ? ";
        } 
         if (filtro.getFil_cidade() != null && filtro.getFil_cidade().trim().equals("") == false) {
            sql += " and Fil_cidade like ? ";
        }
         if (filtro.getFil_estado() != null && filtro.getFil_estado().trim().equals("") == false) {
            sql += " and Fil_estado like ? ";
        }
         if (filtro.getFil_cep() != null && filtro.getFil_cep().trim().equals("") == false) {
            sql += " and Fil_cep like ? ";
        }
        
        try {
            //executando a instruÁ„o sql
            PreparedStatement cmd = conn.prepareStatement(sql);
            if (filtro.getFil_cnpj() != null && filtro.getFil_cnpj().trim().equals("") == false) {
                cmd.setString(posPar, filtro.getFil_cnpj());
                posPar++;
            }
            if (filtro.getFil_telefone() != null && filtro.getFil_telefone().trim().equals("") == false) {
                cmd.setString(posPar, filtro.getFil_telefone());
                posPar++;
            }
            if (filtro.getFil_email() != null && filtro.getFil_email().trim().equals("") == false) {
                cmd.setString(posPar, filtro.getFil_email());
                posPar++;
            }
            if (filtro.getFil_numero() != null && filtro.getFil_numero().trim().equals("") == false) {
                cmd.setString(posPar, filtro.getFil_numero());
                posPar++;
            }
            if (filtro.getFil_rua() != null && filtro.getFil_rua().trim().equals("") == false) {
                cmd.setString(posPar, filtro.getFil_rua());
                posPar++;
            }
            if (filtro.getFil_bairro() != null && filtro.getFil_bairro().trim().equals("") == false) {
                cmd.setString(posPar, filtro.getFil_bairro());
                posPar++;
            }
            if (filtro.getFil_cidade() != null && filtro.getFil_cidade().trim().equals("") == false) {
                cmd.setString(posPar, filtro.getFil_cidade());
                posPar++;
            }
            if (filtro.getFil_estado() != null && filtro.getFil_estado().trim().equals("") == false) {
                cmd.setString(posPar, filtro.getFil_estado());
                posPar++;
            }
            if (filtro.getFil_cep() != null && filtro.getFil_cep().trim().equals("") == false) {
                cmd.setString(posPar, filtro.getFil_cep());
                posPar++;
            }
            //
            ResultSet leitor = cmd.executeQuery();
            while (leitor.next()) {
                Filial f = new Filial();
                f.setFil_cnpj(leitor.getString("Cnpj"));
                f.setFil_telefone(leitor.getString("Telefone"));
                f.setFil_email(leitor.getString("Email"));
                f.setFil_rua(leitor.getString("Rua"));
                f.setFil_numero(leitor.getString("Numero"));
                f.setFil_bairro(leitor.getString("Bairro"));
                f.setFil_cidade(leitor.getString("Cidade"));
                f.setFil_estado(leitor.getString("Estado"));
                f.setFil_cep(leitor.getString("CEP"));
                retorno.add(f);
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
