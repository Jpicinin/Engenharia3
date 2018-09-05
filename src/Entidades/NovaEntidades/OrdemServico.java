/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades.NovaEntidades;

import Entidades.Cliente;
import Entidades.Funcionario;
import java.sql.Date;
import Banco.Banco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Luish
 */
public class OrdemServico
{
    private Integer codigo;
    private Orcamento orcamento;
    private Cliente cliente;
    private Funcionario funcionario;
    private Date data_os;
    private Date data_fechamento;
    private Integer qtdParcelas;
    private Double valor_total;

    public OrdemServico()
    {
    }

    public OrdemServico(Integer codigo, Orcamento orcamento, Cliente cliente, Funcionario funcionario, Date data_os, Date data_fechamento, Integer qtdParcelas, Double valor_total)
    {
        this.codigo = codigo;
        this.orcamento = orcamento;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.data_os = data_os;
        this.data_fechamento = data_fechamento;
        this.qtdParcelas = qtdParcelas;
        this.valor_total = valor_total;
    }

    public OrdemServico(Orcamento orcamento, Cliente cliente, Funcionario funcionario, Date data_os, Date data_fechamento, Integer qtdParcelas, Double valor_total)
    {
        this.orcamento = orcamento;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.data_os = data_os;
        this.data_fechamento = data_fechamento;
        this.qtdParcelas = qtdParcelas;
        this.valor_total = valor_total;
    }

    public Integer getCodigo()
    {
        return codigo;
    }

    public void setCodigo(Integer codigo)
    {
        this.codigo = codigo;
    }

    public Orcamento getOrcamento()
    {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento)
    {
        this.orcamento = orcamento;
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario()
    {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario)
    {
        this.funcionario = funcionario;
    }

    public Date getData_os()
    {
        return data_os;
    }

    public void setData_os(Date data_os)
    {
        this.data_os = data_os;
    }

    public Date getData_fechamento()
    {
        return data_fechamento;
    }

    public void setData_fechamento(Date data_fechamento)
    {
        this.data_fechamento = data_fechamento;
    }

    public Integer getQtdParcelas()
    {
        return qtdParcelas;
    }

    public void setQtdParcelas(Integer qtdParcelas)
    {
        this.qtdParcelas = qtdParcelas;
    }

    public Double getValor_total()
    {
        return valor_total;
    }

    public void setValor_total(Double valor_total)
    {
        this.valor_total = valor_total;
    }

    public boolean add()
    {
        boolean flag = false;
        String sql = "insert into ordemservico(orc_cod, cli_cod, dt_os, dt_fechamento, qtd_parcelas, valor_tot, usr_id) VALUES($1, $2, '$3', '$4', $5, $6, $7)";
        sql = sql.replace("$1", orcamento.getCodigo().toString())
                .replace("$2", cliente.getCodigo().toString())
                .replace("$3", data_os.toString())
                .replace("$4", data_fechamento.toString())
                .replace("$5", qtdParcelas.toString())
                .replace("$6", valor_total.toString())
                .replace("$7", funcionario.getCodigo().toString());
        System.out.println(sql);
        return Banco.con.manipular(sql);
    }
    public static ArrayList<OrdemServico> getAll(String filtro)
    {
        ArrayList<OrdemServico> a = new ArrayList<>();
        String sql = "select * from ordemservico";
        ResultSet rs = null;
        rs = Banco.con.consultar(sql);
        try
        {
            while(rs.next())            
            {
                a.add(new OrdemServico(rs.getInt("os_cod"), 
                        new Orcamento(rs.getInt("orc_cod")), 
                            new Cliente(rs.getInt("cli_cod")), 
                                new Funcionario(rs.getInt("usr_id")), 
                                    rs.getDate("dt_os"), 
                                        rs.getDate("dt_fechamento"), 
                                            rs.getInt("qtd_parcelas"), rs.getDouble("valor_tot")));
            }
        } catch (SQLException ex)
        {
            a = null;
        }
        return a;
    }
}
