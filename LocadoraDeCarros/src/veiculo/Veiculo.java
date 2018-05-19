package veiculo;

import filial.Filial;

public class Veiculo {
    private String Vei_placa;
    private String Vei_modelo;
    private String Vei_cor;
    private String Vei_tipo;
    private String Vei_situacao;
    private Filial Filial;
    
    public Veiculo(){
        this.Filial = new Filial();
    }
   
    public String getVei_placa() {
        return Vei_placa;
    }

    
    public void setVei_placa(String Vei_placa) {
        this.Vei_placa = Vei_placa;
    }

    
    public String getVei_modelo() {
        return Vei_modelo;
    }

   
    public void setVei_modelo(String Vei_modelo) {
        this.Vei_modelo = Vei_modelo;
    }

    
    public String getVei_cor() {
        return Vei_cor;
    }

   
    public void setVei_cor(String Vei_cor) {
        this.Vei_cor = Vei_cor;
    }

   
    public String getVei_tipo() {
        return Vei_tipo;
    }

   
    public void setVei_tipo(String Vei_tipo) {
        this.Vei_tipo = Vei_tipo;
    }

  
    public Filial getFilial() {
        return Filial;
    }

    
    public void setFilial(Filial Filial) {
        this.Filial = Filial;
    }

    /**
     * @return the Vei_situacao
     */
    public String getVei_situacao() {
        return Vei_situacao;
    }

    /**
     * @param Vei_situacao the Vei_situacao to set
     */
    public void setVei_situacao(String Vei_situacao) {
        this.Vei_situacao = Vei_situacao;
    }
   
    public String toString() {
    	String retorno = "";
    	
    	retorno += "Placa: " + this.Vei_placa + "\n";
    	retorno += "Cor: " + this.Vei_cor + "\n";
    	retorno += "Situação: " + this.Vei_situacao + "\n";
    	retorno += "Modelo: " + this.Vei_modelo + "\n";
    	retorno += "Tipo: " + this.Vei_tipo + "\n";
    	
    	return retorno;
    }
}
