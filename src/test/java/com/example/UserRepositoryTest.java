package com.example;


import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.model.User;
import com.example.model.daos.IUserDAO;
import com.example.model.daos.JDBCUserDAO;
import com.example.repositories.UserRepositoryImpl;
import com.example.results.Result;


public class UserRepositoryTest {
    

    private Connection con;
    
    @BeforeEach
    public void antes() throws Exception{
        con = DriverManager.getConnection("jdbc:mysql://localhost/testing","root","");
        con.setAutoCommit(false);
    }


    @Test
    public void consegueCriarUsuario(){
        IUserDAO userDao = new JDBCUserDAO(con);
        UserRepositoryImpl userRepository = new UserRepositoryImpl(userDao);

        Result resultado = userRepository.add("Zé", "zé@teste.com");

        User criado = (User)resultado.asSucess().getObj();

        assertNotEquals(-1, criado.getId());

    }

    @AfterEach
    public void depois() throws Exception{
        con.rollback();
        con.close();
    }


}
