package com.example.results;

public class Sucess extends Result {


    private Object obj;

    /**
     * Cria um objeto que representa um resultado
     * com sucesso.
     * 
     * @param msg Mensagem de sucesso.
     */ 
    public Sucess(String msg,Object obj) {
        super(msg);
        this.obj = obj;
    }

    public Object getObj(){
        return obj;
    }
    
    
}
