/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.analizadorsintactico.parser;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author mynordma
 */
public class TablaSimbolos {
    private final Map<String, Double> tabla;

    public TablaSimbolos() {
        tabla = new LinkedHashMap<>();
    }

    public void asignar(String identificador, Double valor) {
        tabla.put(identificador, valor);
    }

    public Double obtener(String identificador) {
        return tabla.get(identificador);
    }

    public boolean contiene(String identificador) {
        return tabla.containsKey(identificador);
    }

    public void imprimir() {
        tabla.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    public Map<String, Double> getTabla() {
        return tabla;
    }
}
