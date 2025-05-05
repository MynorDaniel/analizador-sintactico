/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.analizadorsintactico.parser;

import java.util.List;

/**
 *
 * @author mynordma
 */
public class ArbolSintactico {
    private final NodoArbol raiz;

    public ArbolSintactico(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void imprimir() {
        imprimirArbol(raiz, "", true);
    }

    private void imprimirArbol(NodoArbol nodo, String prefijo, boolean esUltimo) {
        System.out.print(prefijo);
        System.out.print(esUltimo ? "└── " : "├── ");
        System.out.println(nodo.getValor() != null ? nodo.getValor() : "");

        List<NodoArbol> hijos = nodo.getHijos();
        for (int i = 0; i < hijos.size(); i++) {
            boolean esUltimoHijo = (i == hijos.size() - 1);
            imprimirArbol(hijos.get(i), prefijo + (esUltimo ? "    " : "│   "), esUltimoHijo);
        }
    }


}

