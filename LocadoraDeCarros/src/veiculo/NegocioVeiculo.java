package veiculo;

import locacao.Locacao;



public class NegocioVeiculo implements InterfaceVeiculo {

    @Override
    public void situacaoVeiculoOc(Locacao v) throws Exception {
       DadosVeiculo dv = new DadosVeiculo();
        dv.situacaoVeiculoOc(v);
    }

    @Override
    public void situacaoVeiculoLi(Locacao v) throws Exception {
        DadosVeiculo dv = new DadosVeiculo();
        dv.situacaoVeiculoLi(v);
    }

	@Override
	public void cadastrarVeiculo(Veiculo v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizarVeiculo(Veiculo v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removerVeiculo(Veiculo v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Veiculo buscarVeiculo(String placa) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

   

    

}
