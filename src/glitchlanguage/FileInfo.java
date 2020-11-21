/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glitchlanguage;

import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Abraham Castelan
 */
public class FileInfo {
    private final FileReader fl;
    
    // Constructor donde asignamos el valor a fl
    public FileInfo(FileReader file) {
        this.fl = file;
    }
    
    /*  Método encargado de extraer caracter por caracter del 
        archivo de texto lo que esta ocurriendo es que estamos 
        extrayendo el codigo ascii del char por lo cual es 
        necesario antes de concatenarlo al String hacer un cast
        de tipo char.
    */
    public String getText(){
        String text ="";
        try {
            int ascii;            
            while ((ascii = this.fl.read()) != -1) {
                text += (char) ascii;
            }
        } catch (IOException e) {
        }
        return text;
    }
}
