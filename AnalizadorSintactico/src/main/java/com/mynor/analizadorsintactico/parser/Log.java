/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.analizadorsintactico.parser;

import java.util.ArrayList;

/**
 *
 * @author mynordma
 */
public class Log {
    
    private final ArrayList<String> logs;
    
    public Log(){
        logs = new ArrayList<>();
    }
    
    public void agregar(String log){
        logs.add(log);
    }
    
    public String obtenerLogs(){
        StringBuilder txt = new StringBuilder();
        for (String log : logs) {
            txt.append("\n").append("Error de sintaxis - ").append(log).append("\n");
        }
        return txt.toString();
    }
    
    public boolean hayLogs(){
        return !logs.isEmpty();
    }
}
