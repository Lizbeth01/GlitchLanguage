/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glitchlanguage;
import java.io.FileReader;

/**
 *
 * @author Abraham Castelan
 */
public class GlitchLanguage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        try {
            // Creamos un objeto de tipo FileReader para leer el archivo de texto
            FileReader fr =  new FileReader("C:\\Users\\Abraham Castelan\\Documents\\NetBeansProjects\\GlitchLanguage\\src\\glitchlanguage\\program.txt");
            // Creo un objeto de mi clase FileInfo y le envio como parámetro el objeto de FileReader que contiene mi archivo txt
            FileInfo fi = new FileInfo(fr);
            // Declaración e inicialización de variable lexer de tipo Lexer que recibe el archivo txt en forma de String
            var lexer = new Lexer(fi.getText());
            while (true){
                // Declaración e inicialización de variable token la cual almacenará el Token o palabra
                var token = lexer.Token();
                // Si el tipo del token corresponde con fin de archivo el while finalizará
                if (token.getTipo() == SyntaxKind.TokenFinDeArchivo){
                    break;
                // en dado caso de que el token sea diferente de TokenEspacioBlanco entonces...
                }else if (token.getTipo() != SyntaxKind.TokenEspacioEnBlanco){                    
                    // Se imprimira la linea en la cual está la palabra segudo de la Palabra.
                    System.out.print(token.getLinea()+" --> "+token.getTipo()+": "+ " '"+token.getTexto()+"' ");
                    if (token.getValor() != null){
                        System.out.print(token.getValor());
                    }
                    System.out.println();   
                }
            }           
        } catch (Exception e) {
        }
        
    }
    
}
