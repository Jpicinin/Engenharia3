/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Banco.Banco;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luish
 */
public class Fabricante
{

    private Integer codigo;
    private String nome;

    public Fabricante()
    {
    }

    /*public Fabricante(Integer codigo, String nome, Date dtCadastro)
    {
        this.codigo = codigo;
        this.nome = nome;
        this.dtCadastro = dtCadastro;
    }*/
    public Fabricante(Integer codigo, String nome)
    {
        this.codigo = codigo;
        this.nome = nome;
    }

    public Fabricante(Integer codigo)
    {
        this.codigo = codigo;
        getDadosFabricante();
    }
    public Integer getCodigo()
    {
        return codigo;
    }

    public void setCodigo(Integer codigo)
    {
        this.codigo = codigo;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public ArrayList<Object> get()
    {
        String sql = "select *from fabricante";
        ResultSet rs = null;
        ArrayList<Object> a = new ArrayList<>();
        if (codigo != null)
        {
            sql += " fab_cod = " + codigo;
        }
        rs = Banco.getConexao().consultar(sql);
        try
        {
            while (rs.next())
            {
                a.add(new Fabricante(rs.getInt("fab_cod"), rs.getString("fab_nome")));
            }
        } catch (SQLException ex)
        {
            a = null;
        }
        return a;
    }

    public void getDadosFabricante()
    {
        String sql = "select *from fabricante";
        ResultSet rs = null;
        Fabricante fa = null;
        if (codigo != null)
        {
            sql += " where fab_cod = " + codigo;
        }
        rs = Banco.getConexao().consultar(sql);
        try
        {
            while (rs.next())
            {
                fa = new Fabricante(rs.getInt("fab_cod"), rs.getString("fab_nome"));
            }
        } catch (SQLException ex)
        {
            fa = null;
        }
        if (fa != null)
        {
            nome = fa.getNome();
            //dtCadastro = fa.getDtCadastro();
        } else
        {
            nome = "Fabricante Não Cadastrado";
        }
    }

    @Override
    public String toString()
    {
        return nome;
    }

}
