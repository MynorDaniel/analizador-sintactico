/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.analizadorsintactico.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mynordma
 */
public class TablaAnalisis {
    
    private final Map<String, Map<String, List<String>>> tabla;
    
    public TablaAnalisis(){
        tabla = new HashMap<>();
        llenarTabla();
    }
    
    private void llenarTabla(){
        
        // agregarProduccion(tabla, no terminal, terminal, produccion...)
        
        agregarProduccion(tabla, "NT_INICIO", "PRINT", "NT_INSTRUCCION", "NT_INICIO'");
        agregarProduccion(tabla, "NT_INICIO", "IDENTIFICADOR", "NT_INSTRUCCION", "NT_INICIO'");
        agregarProduccion(tabla, "NT_INICIO", "REPEAT", "NT_INSTRUCCION", "NT_INICIO'");
        agregarProduccion(tabla, "NT_INICIO", "IF", "NT_INSTRUCCION", "NT_INICIO'");

        agregarProduccion(tabla, "NT_INICIO'", "EOF", "ε");
        agregarProduccion(tabla, "NT_INICIO'", "PRINT", "NT_INSTRUCCION", "NT_INICIO'");
        agregarProduccion(tabla, "NT_INICIO'", "IDENTIFICADOR", "NT_INSTRUCCION", "NT_INICIO'");
        agregarProduccion(tabla, "NT_INICIO'", "REPEAT", "NT_INSTRUCCION", "NT_INICIO'");
        agregarProduccion(tabla, "NT_INICIO'", "IF", "NT_INSTRUCCION", "NT_INICIO'");

        agregarProduccion(tabla, "NT_INSTRUCCION", "PRINT", "NT_PRINT");
        agregarProduccion(tabla, "NT_INSTRUCCION", "IDENTIFICADOR", "NT_ASIGNACION");
        agregarProduccion(tabla, "NT_INSTRUCCION", "REPEAT", "NT_REPEAT");
        agregarProduccion(tabla, "NT_INSTRUCCION", "IF", "NT_CONDICIONAL");

        agregarProduccion(tabla, "NT_PRINT", "PRINT", "PRINT", "NT_VALOR", "END");

        agregarProduccion(tabla, "NT_VALOR", "LITERAL", "LITERAL");
        agregarProduccion(tabla, "NT_VALOR", "NUMERO_ENTERO", "NUMERO_ENTERO");
        agregarProduccion(tabla, "NT_VALOR", "IDENTIFICADOR", "IDENTIFICADOR");
        agregarProduccion(tabla, "NT_VALOR", "DECIMAL", "DECIMAL");

        agregarProduccion(tabla, "NT_REPEAT", "REPEAT", "REPEAT", "NT_VALOR", "INIT", "NT_CONTENIDO_REPEAT", "END");

        agregarProduccion(tabla, "NT_CONTENIDO_REPEAT", "PRINT", "NT_PRINT", "NT_CONTENIDO_REPEAT'");

        agregarProduccion(tabla, "NT_CONTENIDO_REPEAT'", "PRINT", "NT_PRINT", "NT_CONTENIDO_REPEAT'");
        agregarProduccion(tabla, "NT_CONTENIDO_REPEAT'", "END", "ε");

        agregarProduccion(tabla, "NT_CONDICIONAL", "IF", "IF", "NT_BOOLEANO", "THEN", "NT_CONTENIDO_COND", "END");

        agregarProduccion(tabla, "NT_BOOLEANO", "TRUE", "TRUE");
        agregarProduccion(tabla, "NT_BOOLEANO", "FALSE", "FALSE");

        agregarProduccion(tabla, "NT_CONTENIDO_COND", "PRINT", "NT_PRINT");
        agregarProduccion(tabla, "NT_CONTENIDO_COND", "END", "ε");

        agregarProduccion(tabla, "NT_ASIGNACION", "IDENTIFICADOR", "IDENTIFICADOR", "ASIGNACION", "NT_EXP", "END");

        agregarProduccion(tabla, "NT_EXP", "NUMERO_ENTERO", "NT_T", "NT_EXP'");
        agregarProduccion(tabla, "NT_EXP", "IDENTIFICADOR", "NT_T", "NT_EXP'");
        agregarProduccion(tabla, "NT_EXP", "DECIMAL", "NT_T", "NT_EXP'");
        agregarProduccion(tabla, "NT_EXP", "PARENTESIS_APERTURA", "NT_T", "NT_EXP'");
        agregarProduccion(tabla, "NT_EXP", "SUMA", "SUMA", "NT_T", "NT_EXP'");
        agregarProduccion(tabla, "NT_EXP", "RESTA", "RESTA", "NT_T", "NT_EXP'");

        agregarProduccion(tabla, "NT_EXP'", "END", "ε");
        agregarProduccion(tabla, "NT_EXP'", "SUMA", "SUMA", "NT_T", "NT_EXP'");
        agregarProduccion(tabla, "NT_EXP'", "RESTA", "RESTA", "NT_T", "NT_EXP'");
        agregarProduccion(tabla, "NT_EXP'", "PARENTESIS_CIERRE", "ε");

        agregarProduccion(tabla, "NT_T", "NUMERO_ENTERO", "NT_F", "NT_T'");
        agregarProduccion(tabla, "NT_T", "IDENTIFICADOR", "NT_F", "NT_T'");
        agregarProduccion(tabla, "NT_T", "DECIMAL", "NT_F", "NT_T'");
        agregarProduccion(tabla, "NT_T", "PARENTESIS_APERTURA", "NT_F", "NT_T'");

        agregarProduccion(tabla, "NT_T'", "END", "ε");
        agregarProduccion(tabla, "NT_T'", "SUMA", "ε");
        agregarProduccion(tabla, "NT_T'", "RESTA", "ε");
        agregarProduccion(tabla, "NT_T'", "MULTIPLICACION", "MULTIPLICACION", "NT_F", "NT_T'");
        agregarProduccion(tabla, "NT_T'", "DIVISION", "DIVISION", "NT_F", "NT_T'");
        agregarProduccion(tabla, "NT_T'", "POTENCIA", "POTENCIA", "NT_F", "NT_T'");
        agregarProduccion(tabla, "NT_T'", "PARENTESIS_CIERRE", "ε");

        agregarProduccion(tabla, "NT_F", "NUMERO_ENTERO", "NUMERO_ENTERO");
        agregarProduccion(tabla, "NT_F", "IDENTIFICADOR", "IDENTIFICADOR");
        agregarProduccion(tabla, "NT_F", "DECIMAL", "DECIMAL");
        agregarProduccion(tabla, "NT_F", "PARENTESIS_APERTURA", "PARENTESIS_APERTURA", "NT_EXP", "PARENTESIS_CIERRE");
    }
    
    private void agregarProduccion(Map<String, Map<String, List<String>>> tabla, String noTerminal, String terminal, String... produccion) {
        tabla.computeIfAbsent(noTerminal, k -> new HashMap<>()).put(terminal, Arrays.asList(produccion));
    }
    
    public boolean existeEnLaTabla(String P, String E) {
        if (tabla.containsKey(P)) {
            Map<String, List<String>> subTabla = tabla.get(P);
            return subTabla.containsKey(E);
        }
        return false;
    }
    
    public ArrayList<String> obtenerProduccion(String P, String E){
        Map<String, List<String>> fila = tabla.get(P);
        if (fila != null) {
            List<String> produccion = fila.get(E);
            if (produccion != null) {
                return new ArrayList<>(produccion);
            }
        }
        return null;
    }
    
    public void imprimirTabla() {
        System.out.println("Tabla de Análisis Sintáctico:\n");
        for (Map.Entry<String, Map<String, List<String>>> entradaFila : tabla.entrySet()) {
            String noTerminal = entradaFila.getKey();
            Map<String, List<String>> fila = entradaFila.getValue();

            for (Map.Entry<String, List<String>> entradaColumna : fila.entrySet()) {
                String terminal = entradaColumna.getKey();
                List<String> produccion = entradaColumna.getValue();
                System.out.println("[" + noTerminal + ", " + terminal + "] -> " + String.join(" ", produccion));
            }
        }
    }

}
