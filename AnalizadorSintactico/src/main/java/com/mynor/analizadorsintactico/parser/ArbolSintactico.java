/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.analizadorsintactico.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mynordma
 */
public class ArbolSintactico {
    private final NodoArbol raiz;
    private final StringBuilder imprimible;

    public ArbolSintactico(NodoArbol raiz) {
        this.raiz = raiz;
        imprimible = new StringBuilder();
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void imprimir() {
        imprimible.setLength(0);
        imprimirArbol(raiz, "", true);
        System.out.println(imprimible.toString());
    }
    private void imprimirArbol(NodoArbol nodo, String prefijo, boolean esUltimo) {
        imprimible.append(prefijo);
        imprimible.append(esUltimo ? "└── " : "├── ");
        imprimible.append(nodo.getValor() != null ? nodo.getValor() : "");
        imprimible.append("\n");

        List<NodoArbol> hijos = nodo.getHijos();
        for (int i = 0; i < hijos.size(); i++) {
            boolean esUltimoHijo = (i == hijos.size() - 1);
            imprimirArbol(hijos.get(i), prefijo + (esUltimo ? "    " : "│   "), esUltimoHijo);
        }
    }

    public String obtenerImprimible() {
        return imprimible.toString();
    }
    
    public ArrayList<String> obtenerPrintsDelArbol(NodoArbol raiz, Map<String, Double> tablaSimbolos) {
        ArrayList<String> prints = new ArrayList<>();
        recorrerArbolParaPrints(raiz, tablaSimbolos, prints, true);
        return prints;
    }

    private void recorrerArbolParaPrints(NodoArbol nodo, Map<String, Double> tablaSimbolos, ArrayList<String> prints, boolean ejecutar) {
        if (nodo.getValor().equals("NT_CONDICIONAL")) {
            for (NodoArbol hijo : nodo.getHijos()) {
                if (hijo.getValor().equals("NT_BOOLEANO") && !hijo.getHijos().isEmpty()) {
                    String boolVal = hijo.getHijos().get(0).getValor();
                    if ("FALSE".equals(boolVal)) {
                        ejecutar = false;
                    } else if ("TRUE".equals(boolVal)) {
                        ejecutar = true;
                    }
                    break;
                }
            }
        }

        if (nodo.getValor().equals("NT_PRINT") && ejecutar && nodo.isValido()) {
            for (NodoArbol hijo : nodo.getHijos()) {
                if (hijo.getValor().equals("NT_VALOR") && !hijo.getHijos().isEmpty()) {
                    NodoArbol valor = hijo.getHijos().get(0);
                    String num = valor.getValor();

                    if (num == null) continue;

                    if (num.startsWith("\"") && num.endsWith("\"")) {
                        // Literal
                        prints.add(num.substring(1, num.length() - 1));
                    } else if (num.startsWith("$")) {
                        // Identificador
                        Double val = tablaSimbolos.get(num);
                        prints.add(val != null ? val.toString() : "");
                    } else {
                        // Número entero
                        prints.add(num);
                    }
                }
            }
        }

        for (NodoArbol hijo : nodo.getHijos()) {
            recorrerArbolParaPrints(hijo, tablaSimbolos, prints, ejecutar);
        }
    }


}

