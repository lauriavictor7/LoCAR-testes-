package locacao;

import java.util.ArrayList;
import veiculo.Veiculo;

public class NegocioLocacao implements InterfaceLocacao {

    @Override
    public Locacao pesquisarLocacao(int loc_codigo) throws Exception {

        DadosLocacao dl = new DadosLocacao();
        Locacao l = dl.pesquisarLocacao(loc_codigo);
        return l;

    }

    @Override
    public ArrayList<Locacao> listar(Locacao filtro) throws Exception {

        DadosLocacao dl = new DadosLocacao();
        return dl.listar(filtro);

    }

    @Override
    public void cadastrarLocacao(Locacao l) throws Exception {
        if (l.getLoc_valor() <= 0) {
            throw new Exception("É necessário informar um valor");
        }

        DadosLocacao dl = new DadosLocacao();
        dl.cadastrarLocacao(l);
    }

    @Override
    public void remover(Locacao l) throws Exception {
        DadosLocacao dl = new DadosLocacao();
        dl.remover(l);
    }

    @Override
    public Locacao buscarLocacao(Locacao filtro) throws Exception {
        DadosLocacao dl = new DadosLocacao();
        return dl.buscarLocacao(filtro);

    }

    @Override
    public void atualizarLocacao(Locacao l) throws Exception {
        DadosLocacao dl = new DadosLocacao();
        dl.atualizarLocacao(l);
    }

    @Override
    public Locacao buscarLocacaoCom(Locacao filtro) throws Exception {
        DadosLocacao dl = new DadosLocacao();
        return dl.buscarLocacaoCom(filtro);
    }

}
