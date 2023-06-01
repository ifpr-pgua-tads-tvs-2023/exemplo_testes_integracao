package com.example.repositories;

import com.example.model.User;
import com.example.model.daos.IUserDAO;
import com.example.results.Result;

public class UserRepositoryImpl implements IUserRepository {
    
    private IUserDAO userDAO;

    public UserRepositoryImpl(IUserDAO userDAO){
        this.userDAO = userDAO;
    }

    public Result add(String nome, String email){
        User user = new User(-1,nome,email);
        return userDAO.add(user);
    }

    @Override
    public Result findByEmail(String email) {
        return userDAO.getByEmail(email);
    }

}
