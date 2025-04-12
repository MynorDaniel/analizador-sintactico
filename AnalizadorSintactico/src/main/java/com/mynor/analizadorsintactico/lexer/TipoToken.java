/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mynor.analizadorsintactico.lexer;

/**
 *
 * @author mynordma
 */
public enum TipoToken {
    NUMERO_ENTERO,
    IDENTIFICADOR,
    PALABRA_RESERVADA,
    LITERAL,
    OPERADOR_ARITMETICO,
    OPERADOR_ASIGNACION,
    COMENTARIO_LINEA,
    COMENTARIO_BLOQUE,
    ERROR
}
