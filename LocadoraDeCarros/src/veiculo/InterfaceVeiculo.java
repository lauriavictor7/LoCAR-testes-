package veiculo;


import locacao.Locacao;


public interface InterfaceVeiculo {
   
      
     public void situacaoVeiculoOc (Locacao v) throws Exception;
    
     public void situacaoVeiculoLi (Locacao v) throws Exception;
     
     public void cadastrarVeiculo(Veiculo v) throws Exception;
     
     public void atualizarVeiculo(Veiculo v) throws Exception;
    
     public void removerVeiculo(Veiculo v) throws Exception;
     
     public Veiculo buscarVeiculo(String placa) throws Exception;
}
