package com.example.repositories;

import com.example.model.User;
import com.example.results.Result;

public interface IUserRepository {
    Result add(String nome, String email);
    Result findByEmail(String email);
}
