/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.analizadorsintactico.lexer;

/**
 *
 * @author mynordma
 */
public class Token {
    
    private final String valor;
    private final int linea;
    private final int columna;
    private final TipoToken tipo;

    public Token(String valor, int linea, int columna, TipoToken tipo) {
        this.valor = valor;
        this.linea = linea;
        this.columna = columna;
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public TipoToken getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return String.format("%s: '%s', ln=%d, col=%d", tipo, valor, linea, columna);
    }
}
