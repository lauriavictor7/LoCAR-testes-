package locacao;

import java.util.ArrayList;



public interface InterfaceLocacao {
    
    //Remover
    void remover(Locacao l) throws Exception;
    
    //Buscar
    Locacao pesquisarLocacao(int loc_codigo) throws Exception;
    Locacao buscarLocacao (Locacao filtro) throws Exception;
     Locacao buscarLocacaoCom (Locacao filtro) throws Exception;
    //Listar
    ArrayList<Locacao> listar (Locacao filtro) throws Exception;
    
    //Locar
    void cadastrarLocacao (Locacao l) throws Exception;
    
    //Atualizar
    void atualizarLocacao(Locacao l) throws Exception;
    
}
