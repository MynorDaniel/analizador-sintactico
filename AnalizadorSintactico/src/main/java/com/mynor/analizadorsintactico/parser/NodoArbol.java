/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.analizadorsintactico.parser;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mynordma
 */
public class NodoArbol {
    private String valor;
    private final List<NodoArbol> hijos;
    private boolean valido = true;

    public NodoArbol(String valor) {
        this.valor = valor;
        this.hijos = new ArrayList<>();
    }

    public void agregarHijo(NodoArbol hijo) {
        hijos.add(hijo);
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public List<NodoArbol> getHijos() {
        return hijos;
    }

    public String getValor() {
        return valor;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
    
    
}



