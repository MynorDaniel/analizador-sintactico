/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.analizadorsintactico.parser;

import java.util.Stack;

/**
 *
 * @author mynordma
 */
public class Automata {
    
    private final Stack<String> pila;
    
    public Automata(){
        pila = new Stack<>();
        pila.push("EOF");
        pila.push("NT_INICIO");
    }

    public Stack<String> getPila() {
        return pila;
    }
}
