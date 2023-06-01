package com.example.results;


/***
 * Classe responsável por representar um resultado
 * falho de uma operação. 
 */

public class Error extends Result {

    /**
     * Cria um objeto que representa um resultado falho de uma
     * operação.
     * 
     * @param msg Mensagem de falha.
     */
    public Error(String msg) {
        super(msg);
    }
    
}
