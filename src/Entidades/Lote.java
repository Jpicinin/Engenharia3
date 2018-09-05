/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;

/**
 *
 * @author Aluno
 */
public class Lote
{
    private Integer codigo;
    private String tipo;
    private String descricao;
    private Integer qt_unidades;
    private Date dt_validade;
    private Date dt_entrega;

    public Lote()
    {
    }

    public Lote(Integer codigo, String tipo, String descricao, Integer qt_unidades, Date dt_validade, Date dt_entrega)
    {
        this.codigo = codigo;
        this.tipo = tipo;
        this.descricao = descricao;
        this.qt_unidades = qt_unidades;
        this.dt_validade = dt_validade;
        this.dt_entrega = dt_entrega;
    }

    public Lote(String tipo, String descricao, Integer qt_unidades, Date dt_validade, Date dt_entrega)
    {
        this.tipo = tipo;
        this.descricao = descricao;
        this.qt_unidades = qt_unidades;
        this.dt_validade = dt_validade;
        this.dt_entrega = dt_entrega;
    }

    public Integer getCodigo()
    {
        return codigo;
    }

    public void setCodigo(Integer codigo)
    {
        this.codigo = codigo;
    }

    public String getTipo()
    {
        return tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
    }

    public String getDescricao()
    {
        return descricao;
    }

    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public Integer getQt_unidades()
    {
        return qt_unidades;
    }

    public void setQt_unidades(Integer qt_unidades)
    {
        this.qt_unidades = qt_unidades;
    }

    public Date getDt_validade()
    {
        return dt_validade;
    }

    public void setDt_validade(Date dt_validade)
    {
        this.dt_validade = dt_validade;
    }

    public Date getDt_entrega()
    {
        return dt_entrega;
    }

    public void setDt_entrega(Date dt_entrega)
    {
        this.dt_entrega = dt_entrega;
    }
    
}
