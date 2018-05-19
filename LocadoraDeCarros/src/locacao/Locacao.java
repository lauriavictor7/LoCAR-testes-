package locacao;

import cliente.Cliente;
import veiculo.Veiculo;

public class Locacao {
    private int loc_codigo;
    private String  loc_data_locacao, loc_data_entrega;
    private double loc_valor;
    private Cliente cliente;
    private Veiculo veiculo;

    public Locacao(){
        this.cliente = new Cliente();
        this.veiculo = new Veiculo();
    }
    
    public int getLoc_codigo() {
        return loc_codigo;
    }

    
    public void setLoc_codigo(int loc_codigo) {
        this.loc_codigo = loc_codigo;
    }

    
    public String getLoc_data_locacao() {
        return loc_data_locacao;
    }

    
    public void setLoc_data_locacao(String loc_data_locacao) {
        this.loc_data_locacao = loc_data_locacao;
    }

    
    public String getLoc_data_entrega() {
        return loc_data_entrega;
    }

    
    public void setLoc_data_entrega(String loc_data_entrega) {
        this.loc_data_entrega = loc_data_entrega;
    }


    public double getLoc_valor() {
        return loc_valor;
    }

    
    public void setLoc_valor(double loc_valor) {
        this.loc_valor = loc_valor;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    public Veiculo getVeiculo() {
        return veiculo;
    }

    
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

}