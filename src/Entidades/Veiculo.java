/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import javafx.scene.paint.Color;

/**
 *
 * @author Aluno
 */
public class Veiculo 
{
    private Integer codigo;
    private Integer ano;
    private String modelo;
    private String placa;
    private Color cor;

    public Veiculo()
    {
    }

    public Veiculo(Integer codigo, Integer ano, String modelo, String placa, Color cor)
    {
        this.codigo = codigo;
        this.ano = ano;
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
    }

    public Veiculo(Integer ano, String modelo, String placa, Color cor)
    {
        this.ano = ano;
        this.modelo = modelo;
        this.placa = placa;
        this.cor = cor;
    }

    public Integer getCodigo()
    {
        return codigo;
    }

    public void setCodigo(Integer codigo)
    {
        this.codigo = codigo;
    }

    public Integer getAno()
    {
        return ano;
    }

    public void setAno(Integer ano)
    {
        this.ano = ano;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }

    public String getPlaca()
    {
        return placa;
    }

    public void setPlaca(String placa)
    {
        this.placa = placa;
    }

    public Color getCor()
    {
        return cor;
    }

    public void setCor(Color cor)
    {
        this.cor = cor;
    }
    
}
