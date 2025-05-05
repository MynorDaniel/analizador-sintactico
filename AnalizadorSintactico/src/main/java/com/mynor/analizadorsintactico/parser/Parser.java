/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.analizadorsintactico.parser;

import com.mynor.analizadorsintactico.lexer.*;
import java.util.*;

/**
 *
 * @author mynordma
 */
public class Parser {
    private final Automata automata;
    private final TablaAnalisis tablaAnalisis;
    
    public Parser(){
        automata = new Automata();
        tablaAnalisis = new TablaAnalisis();
    }
    
    public ArbolSintactico evaluar(ArrayList<Token> tokens) {
        int apuntador = 0;
        String P = "";
        String E = "";

        Stack<String> pila = automata.getPila();
        
        NodoArbol raiz = new NodoArbol("NT_INICIO");
        
        Stack<NodoArbol> pilaNodos = new Stack<>();
        pilaNodos.push(raiz);


        do {
            
            if(pilaNodos.isEmpty()) break;
            
            P = pila.peek();
            E = tokens.get(apuntador).getTipo().toString();
            
            NodoArbol nodoActual = pilaNodos.peek();
           
            

            if (esTerminal(P) || P.equals("EOF")) {
                if (P.equals(E)) {
                    // Consumir terminales - desapilar y mover el apuntador
                    pila.pop();
                    
                    pilaNodos.pop();
                    nodoActual.setValor(tokens.get(apuntador).getValor());
                    
                    apuntador++;
                } else {
                    System.out.println("Error de sintaxis: se esperaba '" + P + "' pero se encontró '" + E + "'");
                    return null;
                }
            } else {
                if (tablaAnalisis.existeEnLaTabla(P, E)) {
                    // Desapilar y apilar la produccion actual
                    pila.pop();
                    pilaNodos.pop();
                    
                    ArrayList<String> produccion = tablaAnalisis.obtenerProduccion(P, E);

                    // Crear nodos hijos
                    ArrayList<NodoArbol> hijos = new ArrayList<>();
                    for (String simbolo : produccion) {
                        if (!simbolo.equals("ε")) {
                            NodoArbol hijo = new NodoArbol(simbolo);
                            hijos.add(hijo);
                        }
                    }

                    // Agregar hijos al nodo actual
                    for (NodoArbol hijo : hijos) {
                        nodoActual.agregarHijo(hijo);
                    }
                    
                    Collections.reverse(hijos);
                    for (NodoArbol hijo : hijos) {
                        pilaNodos.push(hijo);
                    }
                    
                    // Apilar en orden inverso
                    Collections.reverse(produccion);
                    for (String p : produccion) {
                        // Ignorar epsilon
                        if(!p.equals("ε")){
                            pila.push(p);
                        }
                    }
                } else {
                    System.out.println("Error: no existe entrada en la tabla para (" + P + ", " + E + ")");
                    return null;
                }
            }
        } while (!pila.isEmpty());
        System.out.println("Cadena aceptada");
        return new ArbolSintactico(raiz);
    }


    private boolean esTerminal(String P) {
        return switch (P) {
            case "NUMERO_ENTERO",
                 "IDENTIFICADOR",
                 "PRINT",
                 "END",
                 "REPEAT",
                 "INIT",
                 "IF",
                 "TRUE",
                 "FALSE",
                 "THEN",
                 "LITERAL",
                 "SUMA",
                 "RESTA",
                 "MULTIPLICACION",
                 "DIVISION",
                 "POTENCIA",
                 "ASIGNACION",
                 "COMENTARIO_LINEA",
                 "COMENTARIO_BLOQUE",
                 "PARENTESIS_APERTURA",
                 "PARENTESIS_CIERRE",
                 "EOF" -> true;
            default -> false;
        };
    }

    public TablaAnalisis getTablaAnalisis() {
        return tablaAnalisis;
    }
    
    
}
