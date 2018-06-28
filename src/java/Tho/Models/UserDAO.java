/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tho.Models;

import Tho.Utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ThoDT
 */
public class UserDAO implements Serializable {
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    private void closeConnection() throws SQLException {
        if (rs != null) rs.close();
        if (preStm != null) preStm.close();
        if (conn != null) conn.close();
    }
    
    public String checkLogin(String username, String password) throws SQLException, ClassNotFoundException {
        String result = "failed";
        try {
            String sql = "SELECT role FROM [User] WHERE username = ? and password = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getString("role");
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public List<UserDTO> findByLikeFullname(String search) throws ClassNotFoundException, SQLException {
        List<UserDTO> result = null;
        String username, role, fullname, abilities, powers, height, weight, urlAvatar;
        Date dateJoined;
        try {
            String sql = "SELECT username, role, fullname, abilities, powers, height, weight, dateJoined, urlAvatar FROM [User] WHERE fullname LIKE ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()) {
                username = rs.getString("username");
                role = rs.getString("role");
                fullname = rs.getString("fullname");
                abilities = rs.getString("abilities");
                powers = rs.getString("powers");
                height = rs.getString("height");
                weight = rs.getString("weight");
                dateJoined = rs.getDate("dateJoined");
                urlAvatar = rs.getString("urlAvatar");
                result.add(new UserDTO(username, role, fullname, abilities, powers, height, weight, dateJoined, urlAvatar));
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public UserDTO findByUsername(String search) throws ClassNotFoundException, SQLException {
        UserDTO result = null;
        String username, role, fullname, abilities, powers, height, weight;
        Date dateJoined;
        try {
            String sql = "SELECT username, role, fullname, abilities, powers, height, weight, dateJoined FROM [User] WHERE username = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, search);
            rs = preStm.executeQuery();
            if (rs.next()) {
                username = rs.getString("username");
                role = rs.getString("role");
                fullname = rs.getString("fullname");
                abilities = rs.getString("abilities");
                powers = rs.getString("powers");
                height = rs.getString("height");
                weight = rs.getString("weight");
                dateJoined = rs.getDate("dateJoined");
                result = new UserDTO(username, role, fullname, abilities, powers, height, weight, dateJoined);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean updateUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;
        
        try {
            String sql = "UPDATE [User] " +
                    "SET fullname = ?, role = ?, abilities = ?, powers = ?, weight = ?, height = ?, dateJoined = ? " +
                    "WHERE username = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getFullname());
            preStm.setString(2, dto.getRole());
            preStm.setString(3, dto.getAbilities());
            preStm.setString(4, dto.getPowers());
            preStm.setString(5, dto.getWeight());
            preStm.setString(6, dto.getHeight());
            preStm.setDate(7, dto.getDateJoined());
            preStm.setString(8, dto.getUsername());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        
        return check;
    }
    
    public boolean updatePasswordUser(String username, String password) throws SQLException, ClassNotFoundException {
        boolean check = false;
        try {
            String sql = "UPDATE [User] SET password = ? WHERE username = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, password);
            preStm.setString(2, username);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
     
    public boolean addUser(UserDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;
        
        try {
            String sql = "INSERT INTO [User](username, password, role, fullname, abilities, powers, height, weight, dateJoined) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getRole());
            preStm.setString(4, dto.getFullname());
            preStm.setString(5, dto.getAbilities());
            preStm.setString(6, dto.getPowers());
            preStm.setString(7, dto.getHeight());
            preStm.setString(8, dto.getWeight());
            preStm.setDate(9, dto.getDateJoined());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        
        return check;
    }

    public boolean updateAvatarUser(String username, String urlAvatar) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            String sql = "UPDATE [User] SET urlAvatar = ? WHERE username = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, urlAvatar);
            preStm.setString(2, username);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
