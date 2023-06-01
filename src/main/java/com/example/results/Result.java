package com.example.results;

/***
 * Classe responsável por representar o resultado de uma operação 
 * realizada. 
 */


public abstract class Result {
    private String msg;

    public Result(String msg){
        this.msg = msg;
    }

    public static Result sucess(String msg,Object obj){
        return new Sucess(msg,obj);
    }

    public static Result error(String msg){
        return new Error(msg);
    }

    public boolean wasError(){
        return this instanceof Error;
    }

    public boolean wasSucess(){
        return this instanceof Sucess;
    }

    public Error asError(){
        return (Error)this;
    }

    public Sucess asSucess(){
        return (Sucess)this;
    }

    public String getMsg(){
        return msg;
    }
}
