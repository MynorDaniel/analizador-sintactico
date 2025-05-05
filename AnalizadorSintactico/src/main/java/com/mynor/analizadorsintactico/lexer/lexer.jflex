
%%
/* ==== Opciones ==== */
%public
%class Lexer
%unicode
%line
%column
%char

%{
import java.util.ArrayList;

private final ArrayList<Token> tokens = new ArrayList<>();

public ArrayList<Token> analizar() throws java.io.IOException {
    while (yylex() != null) {
    }
    return tokens;
}
%}

/* ==== Expresiones regulares ==== */

NUMERO                  = [1-9][0-9]* | 0
IDENTIFICADOR           = \$[a-zA-Z0-9_-][a-zA-Z0-9_-]*
LITERAL                 = \"([^\"\n]|\\.)*\"
SUMA                    = "+"
RESTA                   = "-"
MULTIPLICACION          = "*"
DIVISION                = "/"
ASIGNACION              = "="
POTENCIA                = "^"
COMENTARIO_LINEA        = \#.*
COMENTARIO_BLOQUE       = "/*"([^*]|\r|\n|\*+[^*/])*\*+"/"
ESPACIOS                = [\ \t\r\n]+

%%

/* ==== Reglas de Tokens ==== */

"PRINT"                    { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.PRINT)); }

"END"                      { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.END)); }

"REPEAT"                   { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.REPEAT)); }

"INIT"                     { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.INIT)); }

"IF"                       { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.IF)); }

"TRUE"                     { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.TRUE)); }

"FALSE"                    { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.FALSE)); }

"THEN"                     { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.THEN)); }

{NUMERO}                   { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.NUMERO_ENTERO)); }

{IDENTIFICADOR}            { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.IDENTIFICADOR)); }

{LITERAL}                  { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.LITERAL)); }

{SUMA}                     { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.SUMA)); }

{RESTA}                    { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.RESTA)); }

{MULTIPLICACION}           { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.MULTIPLICACION)); }

{DIVISION}                 { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.DIVISION)); }

{POTENCIA}                 { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.POTENCIA)); }

{ASIGNACION}      { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.ASIGNACION)); }

{COMENTARIO_LINEA}         { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.COMENTARIO_LINEA)); }

{COMENTARIO_BLOQUE}        { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.COMENTARIO_BLOQUE)); }

"("                        { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.PARENTESIS_APERTURA)); }

")"                        { tokens.add(Token(yytext(), yyline+1, yycolumn+1, TipoToken.PARENTESIS_CIERRE)); }

{ESPACIOS}                 { /* Ignorar */ }   

<<EOF>>                    { tokens.add(Token("EOF", yyline+1, yycolumn+1, TipoToken.EOF)); }

.                          { tokens.add(Token(yytext(), yyline + 1, yycolumn + 1, TipoToken.ERROR)); }

