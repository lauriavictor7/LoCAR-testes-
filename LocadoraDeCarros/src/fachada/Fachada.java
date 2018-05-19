package fachada;

import cliente.Cliente;
import cliente.InterfaceCliente;
import cliente.NegocioCliente;
import filial.Filial;
import filial.InterfaceFilial;
import filial.NegocioFilial;
import java.util.ArrayList;
import locacao.InterfaceLocacao;
import locacao.Locacao;
import locacao.NegocioLocacao;
import veiculo.InterfaceVeiculo;
import veiculo.NegocioVeiculo;
import veiculo.Veiculo;


public class Fachada implements InterfaceCliente, InterfaceFilial, InterfaceLocacao, InterfaceVeiculo {
    // Cliente //

    @Override
    public void cadastrar(Cliente c) throws Exception {
        NegocioCliente nc = new NegocioCliente();
        nc.cadastrar(c);
    }

    @Override
    public void remover(Cliente c) throws Exception {
        NegocioCliente nc = new NegocioCliente();
        nc.remover(c);
    }

    @Override
    public void atualizar(Cliente c) throws Exception {
        NegocioCliente nc = new NegocioCliente();
        nc.atualizar(c);
    }

    @Override
    public ArrayList<Cliente> listar(Cliente filtro) throws Exception {
        NegocioCliente nc = new NegocioCliente();
        return nc.listar(filtro);
    }

    @Override
    public boolean existencia(Cliente c) throws Exception {
        NegocioCliente nc = new NegocioCliente();
        return nc.existencia(c);
    }

    // Filial // 
    @Override
    public ArrayList<Filial> listar(Filial filtro) throws Exception {
        NegocioFilial nf = new NegocioFilial();
        return nf.listar(filtro);
    }

    // Locacao // 
    @Override
    public Locacao pesquisarLocacao(int loc_codigo) throws Exception {
        NegocioLocacao nl = new NegocioLocacao();
        return nl.pesquisarLocacao(loc_codigo);
    }

    @Override
    public ArrayList<Locacao> listar(Locacao filtro) throws Exception {
        NegocioLocacao nl = new NegocioLocacao();
        return nl.listar(filtro);
    }

    @Override
    public void cadastrarLocacao(Locacao l) throws Exception {
        NegocioLocacao nl = new NegocioLocacao();
        nl.cadastrarLocacao(l);
    }

    @Override
    public void remover(Locacao l) throws Exception {
        NegocioLocacao nl = new NegocioLocacao();
        nl.remover(l);
    }
    
    @Override
    public Locacao buscarLocacao(Locacao filtro) throws Exception {
        NegocioLocacao nl = new NegocioLocacao();
        return nl.buscarLocacao(filtro);
    }

    @Override
    public void atualizarLocacao(Locacao l) throws Exception {
        NegocioLocacao nl = new NegocioLocacao();
        nl.atualizarLocacao(l);
    }

    // Veiculo //
    @Override
    public Cliente buscarCliente(Cliente filtro) throws Exception {
        NegocioCliente dc = new NegocioCliente();
        return dc.buscarCliente(filtro);
    }

    @Override
    public Locacao buscarLocacaoCom(Locacao filtro) throws Exception {
        NegocioLocacao nl = new NegocioLocacao();
        return nl.buscarLocacaoCom(filtro);
    }

    @Override
    public void situacaoVeiculoOc (Locacao v) throws Exception {
      NegocioVeiculo nv = new NegocioVeiculo();
      nv.situacaoVeiculoOc(v);
    }

    @Override
    public void situacaoVeiculoLi(Locacao v) throws Exception {
      NegocioVeiculo nv = new NegocioVeiculo();
      nv.situacaoVeiculoLi(v);    
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
