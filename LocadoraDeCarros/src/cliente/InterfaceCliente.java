package cliente;

import java.util.ArrayList;

public interface InterfaceCliente {
    //Cadastrar cliente.
    void cadastrar(Cliente c) throws Exception;
    
    //Remover Cliente.
    void remover(Cliente c) throws Exception;
   
    //Atualizar cadastro de Cliente.
    void atualizar(Cliente c) throws Exception;
   
    //Listar Clientes.
    ArrayList<Cliente> listar (Cliente filtro) throws Exception;
  
    //Verificar a existência de um cliente no banco.
    boolean existencia (Cliente c) throws Exception;
    
    //Buscar Clientes.
    Cliente buscarCliente (Cliente filtro) throws Exception;

    
}
