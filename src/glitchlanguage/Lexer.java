/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package glitchlanguage;

/**
 *
 * @author Abraham Castelan
 */
public class Lexer {
    private final String text;
    private int position;
    private int line = 1;

    // Constructor que Asigna a text el valor correspondiente con el texto
    // del archivo txt
    public Lexer(String text) {
        this.text = text;
    }
    
    /*  Método que nos devolverá el caracter en la posición n
        del string en dado caso de que la posición sea mayor 
        que la longitud del archivo quiere decir que el archivo
        termno de leerse por lo cual retornamos '/0'
    */
    private char Current(){
        if(this.position >= this.text.length()){
            return '\0';
        }
        return this.text.charAt(this.position);
    }
    
    // Metodo que incrementa la variable linea
    private int NextLine(){
        return this.line++;
    }
    
    // Método que incrementa la variable posición
    private int Next(){
        return this.position++;
    }
    
    // Metodo de tipo SyntaxToken encargado del funconamiento del analizador léxico
    public SyntaxToken Token(){
        
        // si el caracter en la posición n es mayor que la longitud del archivo
        if(this.position >= this.text.length()){
            // retorna un token llamado fin de archivo
            return new SyntaxToken(SyntaxKind.TokenFinDeArchivo, this.position, "\0", null, this.line);
        }
        
        // si el caracter en la posición n corresponde con un espacio, tabulador
        // vuelta de carro entonces quiere decir que es un token de espacio en blanco
        // finalmente se retorna dicho token
        if(Current() == ' ' || Current() == '\t' || Current() == '\r'){
            int inicio = this.position;

            while(Current() == ' ' || Current() == '\t' || Current() == '\r'){
                Next();
            }

            int longitud = this.position ;
            String texto = this.text.substring(inicio,longitud);
            return new SyntaxToken(SyntaxKind.TokenEspacioEnBlanco, inicio, texto, null, this.line);
        }
        
        // Si el caracter es '/n' corresponde con un salto de línea con lo cual
        // debemos incrementar el contador de nuestra linea
        if(Current() == '\n'){
            NextLine();
            int inicio = this.position;

            while(Current() == '\n'){
                Next();
            }

            int longitud = this.position ;
            String texto = this.text.substring(inicio,longitud);
            return new SyntaxToken(SyntaxKind.TokenEspacioEnBlanco, inicio, texto, null, this.line);
        }
        
        // Mientras que el caracter en la posicion n sea una letra
        // seguiremos recorriendo el string concatenando el caracter
        // de esta forma podemos tener si es una variable o es algun token más
        if(Character.isAlphabetic(Current())){
            int inicio = this.position;

            while(Character.isAlphabetic(Current())){
                Next();
            }

            int longitud = this.position ;
            String texto = this.text.substring(inicio,longitud);
            
            if (texto.equals("true")){
                return new SyntaxToken(SyntaxKind.TokenPalabraTrue, inicio, texto, null, this.line);
            }if (texto.equals("false")){
                return new SyntaxToken(SyntaxKind.TokenPalabraFalse, inicio, texto, null, this.line);
            }else{
                return new SyntaxToken(SyntaxKind.TokenIdentificador, inicio, texto, null, this.line);
            }
        }
        
        // Mientras que el caracter en la posicion n sea un dígito
        // seguiremos recorriendo el string concatenando el caracter
        // de esta forma podemos tener numeros. 
        if(Character.isDigit(Current())){
            int inicio = this.position;

            while(Character.isDigit(Current())){
                Next();
            }

            int longitud = this.position ;
            String texto = this.text.substring(inicio,longitud);
            int valor = Integer.parseInt(texto);
            return new SyntaxToken(SyntaxKind.TokenNumerico, inicio, texto, valor, this.line);
        }
        
        // SI el char en n corresponde con alguno de los siguientes simbolos podemos obtener
        // que son una palabra o token
        if(Current() == '+'){
            return new SyntaxToken(SyntaxKind.TokenMas, this.position++, "+", null, this.line);
        }else if(Current() == '-'){
            return new SyntaxToken(SyntaxKind.TokenMenos, this.position++, "-", null, this.line);
        }else if(Current() == '*'){
            return new SyntaxToken(SyntaxKind.TokenAsterisco, this.position++, "*", null, this.line);
        }else if(Current() == '/'){
            return new SyntaxToken(SyntaxKind.TokenSlash, this.position++, "/", null, this.line);
        }else if(Current() == '%'){
            return new SyntaxToken(SyntaxKind.TokenPorcentaje, this.position++, "%", null, this.line);
        }else if(Current() == '('){
            return new SyntaxToken(SyntaxKind.TokenAbreParentesis, this.position++, "(", null, this.line);
        }else if(Current() == ')'){
            return new SyntaxToken(SyntaxKind.TokenCierraParentesis, this.position++, ")", null, this.line);
        }else if(Current() == '{'){
            return new SyntaxToken(SyntaxKind.TokenAbreLlave, this.position++, "(", null, this.line);
        }else if(Current() == '}'){
            return new SyntaxToken(SyntaxKind.TokenCierraLlave, this.position++, "(", null, this.line);
        }else if(Current() == '['){
            return new SyntaxToken(SyntaxKind.TokenAbreCorchete, this.position++, "[", null, this.line);
        }
        else{
            return new SyntaxToken(SyntaxKind.TokenErroneo, this.position++, this.text.substring(this.position-1,this.position), null, this.line);
        }
    }
    
}
