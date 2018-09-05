/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Controladoras.CtrProduto;
import Entidades.NovaEntidades.ItemOrcamentoProduto;
import Entidades.Produto;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.text.MaskFormatter;
import util.MaskFieldUtil;

/**
 * FXML Controller class
 *
 * @author Luish
 */
public class TelaAddProdutoController implements Initializable
{

    @FXML
    private JFXTextField txquantidade;
    @FXML
    private Text lbltotal;
    @FXML
    private JFXTextField txbusca;
    @FXML
    private JFXComboBox<String> cbchave;
    @FXML
    private TableView<Object> tabela;
    @FXML
    private TableColumn<Object, String> colnome;
    @FXML
    private TableColumn<Object, Double> colpreco;
    @FXML
    private TableColumn<Object, Object> coltipo;

    
    @FXML
    private AnchorPane pnadd;
    @FXML
    private TableColumn<Object, Integer> colqtd;
    
    private static Stage stage;
    public static Object itemP;
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        itemP = null;
        cbchave.getItems().addAll("Nome", "Tipo");
        cbchave.getSelectionModel().select("Nome");
        colnome.setCellValueFactory(new PropertyValueFactory<Object, String>("nome"));
        colpreco.setCellValueFactory(new PropertyValueFactory<Object, Double>("preco"));
        coltipo.setCellValueFactory(new PropertyValueFactory<Object, Object>("tipo"));
        colqtd.setCellValueFactory(new PropertyValueFactory<Object, Integer>("quantidade"));
        MaskFieldUtil.numericField(txquantidade);
        stage = TelaGenOrcamentoController.stage;
        txquantidade.setText("0");
        CarregaTabela("");
        
    }    

    @FXML
    private void evtbusca(ActionEvent event)
    {
        CarregaTabela(txbusca.getText());
    }

    @FXML
    private void evtClickinTable(MouseEvent event)
    {
        Produto p;
        try
        {
            p = (Produto) tabela.getSelectionModel().getSelectedItem();
            if(p != null)
                itemP = new ItemOrcamentoProduto(p);
            else
                itemP = null;
            if(itemP != null)
                pnadd.setDisable(false);
        }catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    private void CarregaTabela(String string)
    {
        tabela.getItems().clear();
        ObservableList<Object> ob;
        try
        {
            ob = FXCollections.observableArrayList(CtrProduto.GetListaProdutos(string, cbchave.getSelectionModel().getSelectedItem()));
        }
        catch(Exception ex)
        {
            ob = null;
        }
        tabela.setItems(ob);
    }

    @FXML
    private void evtConfirma(ActionEvent event) throws Throwable
    {
        if(txquantidade.getText().isEmpty())
        {
            txquantidade.setText("0");
        }
        if(Integer.parseInt(txquantidade.getText()) > ((Produto)tabela.getSelectionModel().getSelectedItem()).getQuantidade())
        {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Quantidade Insuficiente no estoque!!!");
            a.show();
        }
        else if(Integer.parseInt(txquantidade.getText()) <= 0)
        {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Quantidade deve Ser Maior que 0!!!");
            a.show();
        }
        else
        {
            itemP = new ItemOrcamentoProduto((Produto) tabela.getSelectionModel().getSelectedItem(), Double.parseDouble(lbltotal.getText()), Integer.parseInt(txquantidade.getText()));
            stage.close();
        }
            
    }

    @FXML
    private void atualizaPrecoR(KeyEvent event)
    {
        if(txquantidade.getText().isEmpty())
        {
            lbltotal.setText("0");
        }
        else
        {
            lbltotal.setText(Double.toString(Integer.parseInt(txquantidade.getText())*((Produto)(tabela.getSelectionModel().getSelectedItem())).getPreco()));
        }
    }

    @FXML
    private void evtCancelar(ActionEvent event)
    {
        itemP = null;
        stage.close();
    }
    
}
