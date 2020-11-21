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
public class SyntaxToken {
    private final SyntaxKind tipo;
    private final int posicion;
    private final String texto;
    private final Object valor;
    private final int linea;

    public SyntaxToken(SyntaxKind tipo, int posicion, String texto, Object valor, int linea) {
        this.tipo = tipo;
        this.posicion = posicion;
        this.texto = texto;
        this.valor = valor;
        this.linea = linea;
    }

    public SyntaxKind getTipo() {
        return tipo;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getTexto() {
        return texto;
    }

    public Object getValor() {
        return valor;
    }

    public int getLinea() {
        return linea;
    }  
}
