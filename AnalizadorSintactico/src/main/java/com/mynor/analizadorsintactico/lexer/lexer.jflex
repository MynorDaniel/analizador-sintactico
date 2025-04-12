
%%
/* ==== Opciones ==== */
%public
%class Lexer
%unicode
%line
%column
%char

/* ==== Expresiones regulares ==== */

NUMERO                  = [+-]?[1-9][0-9]* | 0
IDENTIFICADOR           = \$[a-zA-Z0-9_-][a-zA-Z0-9_-]*
PALABRAS_RESERVADAS     = "PRINT" | "END" | "REPEAT" | "INIT" | "IF" | "TRUE" | "FALSE" | "THEN"
LITERAL                 = \"([^\"\n]|\\.)*\"
OPERADORES_ARITMETICOS  = "+" | "-" | "*" | "/" | "^"
OPERADOR_ASIGNACION     = "="
COMENTARIO_LINEA        = \#.*
COMENTARIO_BLOQUE       = "/*"([^*]|\r|\n|\*+[^*/])*\*+"/"
ESPACIOS                = [\ \t\r\n]+
SECUENCIA_ERROR = ([^a-zA-Z0-9_\"\' \t\r\n\(\)\{\};,\+\-\*/=<>\#\$])+
SECUENCIA_ERROR2 = ([a-zA-Z0-9_\"\'\(\)\{\};,\+\-\*/=<>\#\$])+




%%

/* ==== Reglas de Tokens ==== */

{NUMERO}                   { return new Token(yytext(), yyline+1, yycolumn+1, TipoToken.NUMERO_ENTERO); }

{IDENTIFICADOR}            { return new Token(yytext(), yyline+1, yycolumn+1, TipoToken.IDENTIFICADOR); }

{PALABRAS_RESERVADAS}      { return new Token(yytext(), yyline+1, yycolumn+1, TipoToken.PALABRA_RESERVADA); }

{LITERAL}                  { return new Token(yytext(), yyline+1, yycolumn+1, TipoToken.LITERAL); }

{OPERADORES_ARITMETICOS}   { return new Token(yytext(), yyline+1, yycolumn+1, TipoToken.OPERADOR_ARITMETICO); }

{OPERADOR_ASIGNACION}      { return new Token(yytext(), yyline+1, yycolumn+1, TipoToken.OPERADOR_ASIGNACION); }

{COMENTARIO_LINEA}         { return new Token(yytext(), yyline+1, yycolumn+1, TipoToken.COMENTARIO_LINEA); }

{COMENTARIO_BLOQUE}        { return new Token(yytext(), yyline+1, yycolumn+1, TipoToken.COMENTARIO_BLOQUE); }

{ESPACIOS}                 { /* Ignorar */ }

{SECUENCIA_ERROR}          { return new Token(yytext(), yyline + 1, yycolumn + 1, TipoToken.ERROR); }

{SECUENCIA_ERROR2}          { return new Token(yytext(), yyline + 1, yycolumn + 1, TipoToken.ERROR); }

.                          { return new Token(yytext(), yyline + 1, yycolumn + 1, TipoToken.ERROR); }

