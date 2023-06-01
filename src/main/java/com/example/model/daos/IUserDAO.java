package com.example.model.daos;

import com.example.model.User;
import com.example.results.Result;

public interface IUserDAO {
    Result add(User user);
    Result getByEmail(String email);
}
