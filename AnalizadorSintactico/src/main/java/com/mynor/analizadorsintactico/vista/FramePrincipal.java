/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mynor.analizadorsintactico.vista;

import com.mynor.analizadorsintactico.lexer.*;
import com.mynor.analizadorsintactico.parser.*;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.BadLocationException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author mynordma
 */
public class FramePrincipal extends javax.swing.JFrame {

    private String rutaActual = "";
    private String rutaAbsolutaActual = "";
    private boolean cambiosSinGuardar = false;
    private UndoManager undoManager;
    private ArrayList<Token> tokens;
    private final ArrayList<Token> errores;
    private boolean hayErrores = false;
    
    public FramePrincipal() {
        initComponents();
        setTitle("Analizador Sintáctico");
        setLocationRelativeTo(null);
        outputTextArea.setEditable(false);
        undoManager = new UndoManager();
        inputTextArea.getDocument().addUndoableEditListener(e -> undoManager.addEdit(e.getEdit()));
        tokens = new ArrayList<>();
        errores = new ArrayList<>();
        
        inputTextArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textoModificado();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textoModificado();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                textoModificado();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        inputTextArea = new javax.swing.JTextArea();
        infoLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputTextArea = new javax.swing.JTextArea();
        outputLabel = new javax.swing.JLabel();
        analizarBtn = new javax.swing.JButton();
        tokensBtn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        abrir = new javax.swing.JMenu();
        guardar = new javax.swing.JMenu();
        guardarComo = new javax.swing.JMenu();
        nuevo = new javax.swing.JMenu();
        copiar = new javax.swing.JMenu();
        pegar = new javax.swing.JMenu();
        deshacer = new javax.swing.JMenu();
        rehacer = new javax.swing.JMenu();
        acercaDe = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputTextArea.setColumns(20);
        inputTextArea.setRows(5);
        inputTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inputTextAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(inputTextArea);

        infoLabel.setText("Ln 1 Col 1");

        outputTextArea.setColumns(20);
        outputTextArea.setRows(5);
        jScrollPane2.setViewportView(outputTextArea);

        outputLabel.setText("Output");

        analizarBtn.setText("Analizador Sintáctico");
        analizarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                analizarBtnMouseClicked(evt);
            }
        });

        tokensBtn.setText("Tokens");
        tokensBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tokensBtnMouseClicked(evt);
            }
        });

        abrir.setText("Abrir");
        abrir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                abrirMouseClicked(evt);
            }
        });
        jMenuBar1.add(abrir);

        guardar.setText("Guardar");
        guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarMouseClicked(evt);
            }
        });
        jMenuBar1.add(guardar);

        guardarComo.setText("Guardar como");
        guardarComo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                guardarComoMouseClicked(evt);
            }
        });
        jMenuBar1.add(guardarComo);

        nuevo.setText("Nuevo");
        nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuevoMouseClicked(evt);
            }
        });
        jMenuBar1.add(nuevo);

        copiar.setText("Copiar");
        copiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                copiarMouseClicked(evt);
            }
        });
        jMenuBar1.add(copiar);

        pegar.setText("Pegar");
        pegar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pegarMouseClicked(evt);
            }
        });
        jMenuBar1.add(pegar);

        deshacer.setText("Deshacer");
        deshacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deshacerMouseClicked(evt);
            }
        });
        jMenuBar1.add(deshacer);

        rehacer.setText("Rehacer");
        rehacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rehacerMouseClicked(evt);
            }
        });
        jMenuBar1.add(rehacer);

        acercaDe.setText("Acerca de");
        acercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acercaDeMouseClicked(evt);
            }
        });
        jMenuBar1.add(acercaDe);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(outputLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(infoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 383, Short.MAX_VALUE)
                        .addComponent(tokensBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(analizarBtn)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(infoLabel)
                    .addComponent(analizarBtn)
                    .addComponent(tokensBtn))
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_abrirMouseClicked
        if (cambiosSinGuardar) {
            int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Guardar cambios?",
                "Cambios no guardados",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            if (opcion == JOptionPane.CANCEL_OPTION || opcion == JOptionPane.CLOSED_OPTION) {
                return;
            }

            if (opcion == JOptionPane.YES_OPTION) {
                guardarMouseClicked(evt);
            }
        }
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona un archivo de texto");
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter(
            "Archivos de texto (*.txt, *.csv, *.log)", "txt", "csv", "log"
        );
        fileChooser.setFileFilter(filtro);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int resultado = fileChooser.showOpenDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            rutaAbsolutaActual = archivoSeleccionado.getAbsolutePath();
            rutaActual = archivoSeleccionado.getPath();
            setTitle("Analizador Sintáctico - " + rutaActual);

            try (BufferedReader br = new BufferedReader(new FileReader(archivoSeleccionado))) {
                StringBuilder contenido = new StringBuilder();
                String linea;
                while ((linea = br.readLine()) != null) {
                    contenido.append(linea).append("\n");
                }
                inputTextArea.setText(contenido.toString());
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage(),
                                              "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_abrirMouseClicked

    private void guardarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarMouseClicked
        if (!rutaAbsolutaActual.isEmpty()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaAbsolutaActual))) {
                writer.write(inputTextArea.getText());
                setTitle("Analizador Sintáctico - " + rutaActual + " (Guardado)");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            cambiosSinGuardar = false;
        } else {
            guardarComoMouseClicked(evt);
        }
    }//GEN-LAST:event_guardarMouseClicked

    private void guardarComoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarComoMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar archivo como...");

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de texto (*.txt)", "txt");
        fileChooser.setFileFilter(filtro);
        fileChooser.setAcceptAllFileFilterUsed(false);

        int resultado = fileChooser.showSaveDialog(this);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            String rutaNuevoArchivo = archivoSeleccionado.getAbsolutePath();

            if (!rutaNuevoArchivo.toLowerCase().endsWith(".txt")) {
                archivoSeleccionado = new File(rutaNuevoArchivo + ".txt");
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoSeleccionado))) {
                writer.write(inputTextArea.getText());
                if(rutaAbsolutaActual.isEmpty()){
                    rutaAbsolutaActual = archivoSeleccionado.getAbsolutePath();
                    rutaActual = archivoSeleccionado.getPath(); 
                }
                setTitle("Analizador Sintáctico - " + rutaActual);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error al guardar el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_guardarComoMouseClicked

    private void nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseClicked
        if (cambiosSinGuardar) {
            int opcion = JOptionPane.showConfirmDialog(
                this,
                "¿Guardar cambios?",
                "Cambios no guardados",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE
            );

            if (opcion == JOptionPane.CANCEL_OPTION  || opcion == JOptionPane.CLOSED_OPTION) {
                return;
            }

            if (opcion == JOptionPane.YES_OPTION) {
                guardarMouseClicked(evt);
            }
        }

        inputTextArea.setText("");
        rutaAbsolutaActual = "";
        rutaActual = "";
        setTitle("Analizador Sintáctico - Nuevo Documento");
        cambiosSinGuardar = false;
    }//GEN-LAST:event_nuevoMouseClicked

    private void acercaDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acercaDeMouseClicked
        String mensaje = """
                         ------------------------------------------------------
                         Nombre: Analizador Sintáctico
                         Descripción: Aplicación que permite 
                         analizar la estructura sintáctica 
                         de un texto a partir de los tokens 
                         generados por el lexer.
                         
                         Desarrollador:
                           - Mynor Daniel Morales (202331039)
                         
                         Fecha: 11/04/2025
                         ------------------------------------------------------""";

        JOptionPane.showMessageDialog(this, mensaje, "Acerca de", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_acercaDeMouseClicked

    private void copiarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copiarMouseClicked
        String textoSeleccionado = inputTextArea.getSelectedText();
        
        if (textoSeleccionado != null && !textoSeleccionado.isEmpty()) {
            StringSelection selection = new StringSelection(textoSeleccionado);
            Clipboard portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();
            portapapeles.setContents(selection, null);
        } 
    }//GEN-LAST:event_copiarMouseClicked

    private void pegarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pegarMouseClicked
        Clipboard portapapeles = Toolkit.getDefaultToolkit().getSystemClipboard();

        try {
            String textoPegado = (String) portapapeles.getData(DataFlavor.stringFlavor);
            int posicionCursor = inputTextArea.getCaretPosition();
            if (inputTextArea.getSelectedText() != null) {
                inputTextArea.replaceSelection(textoPegado);
            } else {
                inputTextArea.insert(textoPegado, posicionCursor);
            }
        } catch (UnsupportedFlavorException | IOException e) {
            JOptionPane.showMessageDialog(this, "Error al pegar el texto: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_pegarMouseClicked

    private void deshacerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deshacerMouseClicked
        if (undoManager.canUndo()) {
            undoManager.undo();
        }
    }//GEN-LAST:event_deshacerMouseClicked

    private void rehacerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rehacerMouseClicked
        if (undoManager.canRedo()) {
            undoManager.redo();
        }
    }//GEN-LAST:event_rehacerMouseClicked

    private void tokensBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tokensBtnMouseClicked
        if (!hayErrores) {
            JDialog dialogo = new JDialog(this, "Tokens", true);
            dialogo.setSize(1000, 800);
            dialogo.setLocationRelativeTo(this);

            String[] columnas = {"Lexema", "Línea", "Columna", "Tipo"};

            String[][] datos = new String[tokens.size()][4];
            for (int i = 0; i < tokens.size(); i++) {
                Token t = tokens.get(i);
                datos[i][0] = t.getValor();
                datos[i][1] = String.valueOf(t.getLinea());
                datos[i][2] = String.valueOf(t.getColumna());
                datos[i][3] = t.getTipo().toString();
            }

            JTable tablaTokens = new JTable(datos, columnas);
            JScrollPane scrollPane = new JScrollPane(tablaTokens);
            
            dialogo.add(scrollPane);
            dialogo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Hay errores en el texto.", 
                                          "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_tokensBtnMouseClicked

    private void inputTextAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inputTextAreaMouseClicked
        actualizarLabelInfo();
    }//GEN-LAST:event_inputTextAreaMouseClicked

    private void analizarBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_analizarBtnMouseClicked
        // preguntar archivo de salida
        // implementar modo panico
        
        
        if (!hayErrores) {
            String rutaSalida = seleccionarRuta();
            
            Parser parser = new Parser();
            parser.getTablaAnalisis().imprimirTabla();
            ArbolSintactico arbol = parser.evaluar(filtrar(tokens));
            if(arbol != null){
                arbol.imprimir(); 
                TablaSimbolos tablaSimbolos = new TablaSimbolos();
                Evaluador evaluador = new Evaluador(tablaSimbolos);
                evaluador.evaluar(arbol.getRaiz());
                tablaSimbolos.imprimir();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hay errores de sintaxis en el texto.", 
                                          "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
        
    }//GEN-LAST:event_analizarBtnMouseClicked

    private String seleccionarRuta(){
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Seleccionar carpeta");

        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File carpetaSeleccionada = fileChooser.getSelectedFile();
            return carpetaSeleccionada.getAbsolutePath();
        } else {
            return null;
        }
    }
    
    private void textoModificado() {
        setTitle("Analizador Sintáctico - " + rutaActual + " (Sin guardar)");
        cambiosSinGuardar = true;
        actualizarLabelInfo();
        tokenizar(inputTextArea.getText());
        verificarErrores();
        mostrarErrores();
    }
    
    private void actualizarLabelInfo(){
        int caretPosition = inputTextArea.getCaretPosition();
        try {
            int linea = inputTextArea.getLineOfOffset(caretPosition);
            int columna = caretPosition - inputTextArea.getLineStartOffset(linea);

            infoLabel.setText("Ln " + (linea + 1) + " Col: " + (columna + 1));
        } catch (BadLocationException e) {
        }
    }
    
    private void tokenizar(String input){
        tokens.clear();
        errores.clear();
        Lexer lexer = new Lexer(new StringReader(input));
        tokens = lexer.analizar();
    }

    private void verificarErrores(){
        boolean errorEnTokens = false;
        for (Token token : tokens) {
            if(token.getTipo() == TipoToken.ERROR){
                errorEnTokens = true;
                errores.add(token);
            }
        }
        
        hayErrores = errorEnTokens;
    }
    
    private void mostrarErrores(){
        StringBuilder erroresTexto = new StringBuilder();
        for (Token error : errores) {
            erroresTexto.append(error.toString()).append("\n");
        }
        outputTextArea.setText(erroresTexto.toString());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu abrir;
    private javax.swing.JMenu acercaDe;
    private javax.swing.JButton analizarBtn;
    private javax.swing.JMenu copiar;
    private javax.swing.JMenu deshacer;
    private javax.swing.JMenu guardar;
    private javax.swing.JMenu guardarComo;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JTextArea inputTextArea;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu nuevo;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JTextArea outputTextArea;
    private javax.swing.JMenu pegar;
    private javax.swing.JMenu rehacer;
    private javax.swing.JButton tokensBtn;
    // End of variables declaration//GEN-END:variables

    private ArrayList<Token> filtrar(ArrayList<Token> tokens) {
        tokens.removeIf(token -> token.getTipo() == TipoToken.COMENTARIO_LINEA || token.getTipo() == TipoToken.COMENTARIO_BLOQUE);
        return tokens;
    }

}
