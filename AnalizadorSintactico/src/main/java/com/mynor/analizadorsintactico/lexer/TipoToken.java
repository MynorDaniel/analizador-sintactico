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
    PRINT,
    END,
    REPEAT,
    INIT,
    IF,
    TRUE,
    FALSE,
    THEN,
    LITERAL,
    SUMA,
    RESTA,
    MULTIPLICACION,
    DIVISION,
    POTENCIA,
    ASIGNACION,
    COMENTARIO_LINEA,
    COMENTARIO_BLOQUE,
    PARENTESIS_APERTURA,
    PARENTESIS_CIERRE,
    EOF,
    ERROR
}
