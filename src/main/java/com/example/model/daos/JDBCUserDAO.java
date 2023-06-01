package com.example.model.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.model.User;
import com.example.results.Result;

public class JDBCUserDAO implements IUserDAO {

    private Connection con;

    public JDBCUserDAO(Connection con) {
        this.con = con;

    }

    public Result add(User user) {
        try {
            PreparedStatement pstm = con.prepareStatement("INSERT INTO users(name,email) VALUES (?,?)",
                    Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, user.getNome());
            pstm.setString(2, user.getEmail());

            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();
            rs.next();
            int id = rs.getInt(1);
            user.setId(id);

            rs.close();
            pstm.close();

            return Result.sucess("ok", user);
        } catch (SQLException e) {
            return Result.error(e.getMessage());
        }

    }

    public Result getByEmail(String email) {
        User user = null;

        try {
            PreparedStatement pstm = con.prepareStatement("SELECT * FROM users WHERE email=?");

            pstm.setString(1, email);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("name");

                user = new User(id, nome, email);
            }

            rs.close();
            pstm.close();
            return Result.sucess("ok", user);
        } catch (SQLException e) {
            return Result.error(e.getMessage());
        }

        

    }

}
