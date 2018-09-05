package Controladoras;

import Entidades.Fornecedor;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author armando
 */
public class CtrFornecedor
{

    private static String sql;

    private CtrFornecedor()
    {
    }


    //codigo, nome, cnpf, email, fone, site, contato, celular
    public static boolean Salvar(String nome, String cnpj, String email, String fone, String site, String contato, String celular) throws SQLException
    {
        Fornecedor fornecedor = new Fornecedor(nome, cnpj, email, fone, site, contato, celular);
        return fornecedor.Salvar(sql);
    }

    public static  boolean Alterar(String cod, String nome, String cnpj, String email, String fone, String site, String contato, String celular) throws SQLException
    {
        Fornecedor fornecedor = new Fornecedor(Integer.parseInt(cod), nome, cnpj, email, fone, site, contato, celular);
        return fornecedor.Alterar(sql);
    }

    public static  boolean Apagar(int cod)
    {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCodigo(cod);
        return fornecedor.Apagar(sql);
    }

    public static  ObservableList<Fornecedor> Buscar(String filtro, String busca)
    {
        Fornecedor fornecedor = new Fornecedor();
        return fornecedor.Buscar(filtro, busca);
    }

    public static  ObservableList<Fornecedor> BuscarTodos()
    {
        Fornecedor fornecedor = new Fornecedor();
        return fornecedor.BuscarTodos();
    }
}
