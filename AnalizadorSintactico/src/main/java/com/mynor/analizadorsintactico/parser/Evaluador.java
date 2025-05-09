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
public class Evaluador {

    private final TablaSimbolos tablaSimbolos;

    public Evaluador(TablaSimbolos tablaSimbolos) {
        this.tablaSimbolos = tablaSimbolos;
    }

    public void evaluar(NodoArbol nodo) {
        if (nodo.getValor().equals("NT_ASIGNACION")) {
            procesarAsignacion(nodo);
        }

        for (NodoArbol hijo : nodo.getHijos()) {
            evaluar(hijo);
        }
    }

    private void procesarAsignacion(NodoArbol nodo) { // NT_ASIGNACION
        List<NodoArbol> hijos = nodo.getHijos();
        if (hijos.size() < 3) return;

        String identificador = hijos.get(0).getValor(); // IDENTIFICADOR
        NodoArbol nodoExp = hijos.get(2); // NT_EXP

        double valor = evaluarExpresion(nodoExp);
        tablaSimbolos.asignar(identificador, valor);
    }

    public double evaluarExpresion(NodoArbol ntExp) {
        return evaluarNT_EXP(ntExp);
    }

    // NT_EXP ::= NT_T NT_EXP'
    //          | + NT_T NT_EXP'
    //          | - NT_T NT_EXP'
    private double evaluarNT_EXP(NodoArbol nodo) {
        List<NodoArbol> hijos = nodo.getHijos(); // +|- NT_T NT_EXP'

        switch (hijos.size()) {
            case 2 -> {
                // Caso: NT_EXP ::= NT_T NT_EXP'
                double valorT = evaluarNT_T(hijos.get(0));
                return evaluarNT_EXP_PRIMA(hijos.get(1), valorT);
            }
            case 3 -> {
                // Caso: + NT_T NT_EXP'  o  - NT_T NT_EXP'
                String operador = hijos.get(0).getValor();
                double valorT = evaluarNT_T(hijos.get(1));
                double valorInicial = operador.equals("-") ? -valorT : valorT;
                return evaluarNT_EXP_PRIMA(hijos.get(2), valorInicial);
            }
            default -> throw new RuntimeException("NT_EXP mal formado");
        }
    }


    // NT_EXP' ::= + NT_T NT_EXP' | - NT_T NT_EXP' | NT_T NT_EXP' | ''
    private double evaluarNT_EXP_PRIMA(NodoArbol nodo, double acumulado) {
        if (nodo.getHijos().isEmpty()) return acumulado;

        List<NodoArbol> hijos = nodo.getHijos();
        if (hijos.size() == 2) {
            // Caso: NT_EXP' ::= NT_T NT_EXP'
            double valorT = evaluarNT_T(hijos.get(0));
            return evaluarNT_EXP_PRIMA(hijos.get(1), acumulado + valorT);
        } else if (hijos.size() == 3) {
            // Caso: NT_EXP' ::= + NT_T NT_EXP' | - NT_T NT_EXP'
            String operador = hijos.get(0).getValor();
            double valorT = evaluarNT_T(hijos.get(1));
            double nuevoAcumulado = operador.equals("+") ? acumulado + valorT : acumulado - valorT;
            return evaluarNT_EXP_PRIMA(hijos.get(2), nuevoAcumulado);
        }

        throw new RuntimeException("NT_EXP' mal formado");
    }

    // NT_T ::= NT_F NT_T'
    private double evaluarNT_T(NodoArbol nodo) {
        if (nodo.getHijos().size() < 2) {
            throw new RuntimeException("NT_T mal formado");
        }

        double valorF = evaluarNT_F(nodo.getHijos().get(0));
        return evaluarNT_T_PRIMA(nodo.getHijos().get(1), valorF);
    }

    // NT_T' ::= * NT_F NT_T' | / NT_F NT_T' | ^ NT_F NT_T' | ''
    private double evaluarNT_T_PRIMA(NodoArbol nodo, double acumulado) {
        if (nodo.getHijos().isEmpty()) return acumulado;

        List<NodoArbol> hijos = nodo.getHijos();
        if (hijos.size() < 3) {
            throw new RuntimeException("NT_T' mal formado");
        }

        String operador = hijos.get(0).getValor();
        double valorF = evaluarNT_F(hijos.get(1));
        double nuevoAcumulado;

        switch (operador) {
            case "*" -> nuevoAcumulado = acumulado * valorF;
            case "/" -> nuevoAcumulado = acumulado / valorF;
            case "^" -> nuevoAcumulado = Math.pow(acumulado, valorF);
            default -> throw new RuntimeException("Operador no reconocido: " + operador);
        }

        return evaluarNT_T_PRIMA(hijos.get(2), nuevoAcumulado);
    }

    // NT_F ::= ( NT_EXP ) | NUMERO_ENTERO | DECIMAL | IDENTIFICADOR
    private double evaluarNT_F(NodoArbol nodo) {
        List<NodoArbol> hijos = nodo.getHijos();

        if (hijos.isEmpty()) {
            throw new RuntimeException("NT_F vacío");
        }

        // Caso: ( EXP )
        if (hijos.size() == 3 && hijos.get(0).getValor().equals("(")) {
            return evaluarNT_EXP(hijos.get(1));
        }

        NodoArbol hijo = hijos.get(0);
        String tipo = hijo.getValor();

        // Si es un numero
        if (esNumero(tipo)) {
            return Double.parseDouble(tipo);
        }

        // Si es un identificador
        if (tablaSimbolos.contiene(tipo)) {
            return tablaSimbolos.obtener(tipo);
        }

        throw new RuntimeException("No se pudo evaluar NT_F. Valor inesperado: " + tipo);
    }

    private boolean esNumero(String texto) {
        try {
            Double.valueOf(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}

