package Controladoras;

import Entidades.Cliente;
import Entidades.Funcionario;
import Entidades.NovaEntidades.Orcamento;
import Entidades.NovaEntidades.OrdemServico;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class CtrOrdemServico
{

    public static boolean Adiciona(int cli_cod, Object funcionario, String parcelas, double total, LocalDate dtos, LocalDate dtfechamento, Object orcamento)
    {
        OrdemServico os = new OrdemServico((Orcamento)orcamento, new Cliente(cli_cod), (Funcionario) funcionario, Date.valueOf(dtos), Date.valueOf(dtfechamento), Integer.parseInt(parcelas), total);
        return os.add();
    }

    public static void AtulizaPArcelas(JFXComboBox<String> cbparcelas, Label lblValorParcelas, Object orcamento)
    {
        Orcamento oc= (Orcamento)orcamento;
        if(cbparcelas.getSelectionModel().getSelectedItem() != null)
        {
            Double totd= oc.getTotal() / Integer.parseInt(cbparcelas.getSelectionModel().getSelectedItem()); 
            lblValorParcelas.setText(totd.toString().substring(0, totd.toString().indexOf(".")+2));
        }
    }

    public static void AtualizaTotal(Label lblTotalOS, Object orcamento)
    {
        Orcamento oc= (Orcamento)orcamento;
        lblTotalOS.setText(oc.getTotal().toString());
    }

    public static void AtualizaClienteANDFuncionario(JFXTextField txcodigocliente, JFXTextField txcpf, JFXTextField txnomecliente, JFXTextField txrgcliente, JFXComboBox<Object> cbfuncionario, Object orcamento)
    {
        Orcamento o = (Orcamento)orcamento;
        txcpf.setText(o.getCliente().getCpf());
        txcodigocliente.setText(o.getCliente().getCodigo().toString());
        txnomecliente.setText(o.getCliente().getNome());
        txrgcliente.setText(o.getCliente().getRg());
        cbfuncionario.getItems().clear();
        cbfuncionario.getItems().add(o.getUsuarioid());
        cbfuncionario.getSelectionModel().select(o.getUsuarioid());
    }

    public static void GetInfoTabela(TableView<Object> tabela, String string)
    {
        ObservableList<Object> o = FXCollections.observableArrayList(OrdemServico.getAll(""));
        tabela.setItems(o);
    }

   
    
}
