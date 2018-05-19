package cliente;

import java.util.ArrayList;
import validacao.EmailValidacao;

public class NegocioCliente implements InterfaceCliente {

    public void validarCamposBasicos(Cliente c) throws Exception {

        if (c.getCli_nome() == null && c.getCli_nome().trim().equals("") == true && c.getCli_email() == null && c.getCli_email().trim().equals("") == true && c.getCli_numero() == null && c.getCli_numero().trim().equals("") == true && c.getCli_rua() == null && c.getCli_rua().trim().equals("") == true && c.getCli_bairro() == null && c.getCli_bairro().trim().equals("") == true && c.getCli_cidade() == null && c.getCli_cidade().trim().equals("") == true && c.getCli_estado() == null && c.getCli_estado().trim().equals("") == true && c.getCli_cep() == null && c.getCli_cep().trim().equals("") == true && c.getCli_num_doc() == null && c.getCli_num_doc().trim().equals("") == true && c.getCli_telefone() == null && c.getCli_telefone().trim().equals("") == true) {
            throw new Exception("Inserir todos campos obrigat�rio");
        }
        //valida��o nome
        if (c.getCli_nome() == null && c.getCli_nome().trim().equals("") == true) {
            throw new Exception("� necess�rio informar um nome.");
        } else if (c.getCli_nome().trim().length() > 100) {
            throw new Exception("O nome do cliente n�o poder� ter mais de 100 caracteres");
        }

        //valida��o email
        //1� campo v�zio
        if (c.getCli_email() == null && c.getCli_email().trim().equals("") == true) {
            throw new Exception("� necess�rio informar um E-mail.");
        }

        //2� Inserindo corretamente
        EmailValidacao ev = new EmailValidacao();
        if (!ev.validate(c.getCli_email().trim())) {
            throw new Exception("Campo \"Email\" est� Inv�lido");
        }
        //valida��o n�mero
        if (c.getCli_numero() == null && c.getCli_numero().trim().equals("") == true) {
            throw new Exception("� necess�rio informar um n�mero.");
        }

        //valida��o rua
        if (c.getCli_rua() == null && c.getCli_rua().trim().equals("") == true) {
            throw new Exception("� necess�rio informar uma rua.");
        }

        //valid��o bairro
        if (c.getCli_bairro() == null && c.getCli_bairro().trim().equals("") == true) {
            throw new Exception("� necess�rio informar um bairro.");
        }

        //valida��o cidade
        if (c.getCli_cidade() == null && c.getCli_cidade().trim().equals("") == true) {
            throw new Exception("� necess�rio informar uma cidade.");
        }

        //valida��o estado
        if (c.getCli_estado() == null && c.getCli_estado().trim().equals("") == true) {
            throw new Exception("� necess�rio informar um estado.");
        }

        //valida��o cep
        if (c.getCli_cep() == null && c.getCli_cep().trim().equals("") == true) {
            throw new Exception("� necess�rio informar um CEP.");
        }

        //valida��o CPF e CNPJ
        if (c.getCli_num_doc().replace(".", "").replace("-", "").replace("/", "").equals("")) {
            throw new Exception("� necess�rio informar um CPF ou CNPJ v�lido.");
        }

        //valida��o telefone
        if (c.getCli_telefone().replace("()", "").replace("-", "").equals("")) {
            throw new Exception("� necess�rio informar um telefone v�lido.");
        }

    }

    @Override

    public void cadastrar(Cliente c) throws Exception {

        validarCamposBasicos(c);
        DadosCliente dc = new DadosCliente();
        dc.cadastrar(c);
    }

    @Override
    public void remover(Cliente c) throws Exception {

        DadosCliente dc = new DadosCliente();
        dc.remover(c);

    }

    @Override
    public void atualizar(Cliente c) throws Exception {

        DadosCliente dc = new DadosCliente();
        dc.atualizar(c);

    }

    @Override
    public ArrayList<Cliente> listar(Cliente filtro) throws Exception {

        DadosCliente dc = new DadosCliente();
        return dc.listar(filtro);

    }

    @Override
    public boolean existencia(Cliente c) throws Exception {

        DadosCliente dc = new DadosCliente();
        return dc.existencia(c);

    }

    @Override
    public Cliente buscarCliente(Cliente filtro) throws Exception {
        DadosCliente dc = new DadosCliente();
        return dc.buscarCliente(filtro);
    }
}
