package filial;

import java.util.ArrayList;


public class NegocioFilial implements InterfaceFilial{

    @Override
    public ArrayList<Filial> listar(Filial filtro) throws Exception {
        DadosFilial f = new DadosFilial();
         return f.listar(filtro);
    }
    
}
