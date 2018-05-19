package locadoraprincipal;

import javax.swing.JOptionPane;
import dados.Dados;
import veiculo.DadosVeiculo;
import veiculo.Veiculo;

/**
 *
 * @author aunio
 */
public class LocadoraTesteConex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Dados d = new Dados();
            d.conectar();
            Veiculo v = new Veiculo();
            
            v.setVei_placa("ddd4444");
            v.setVei_cor("azul");
            v.setVei_situacao("livre");
            v.setVei_modelo("corsa");
            v.setVei_tipo("hatch");
            
            
            DadosVeiculo dv = new DadosVeiculo();
            //dv.cadastrarVeiculo(v);
            
            System.out.println(">> Dados do veículo << \n" + dv.buscarVeiculo(v.getVei_placa().toString()));
            
            
            d.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
        }
    }
}
