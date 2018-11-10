/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tho.Models;

import Tho.Utils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ThoDT
 */
public class EquipmentDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    public List<EquipmentDTO> findByLikeEquipmentName(String search) throws ClassNotFoundException, SQLException {
        List<EquipmentDTO> result = null;
        String code, username, fullname, name, type, description, urlImage;

        try {
            String sql = "SELECT code, [User].username, [User].fullname, name, type, description, urlImage "
                    + "FROM [Equipment] JOIN [User] ON [Equipment].username = [User].username "
                    + "WHERE name LIKE ? AND isRemoved <> 1";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                code = rs.getString("code");
                username = rs.getString("username");
                fullname = rs.getString("fullname");
                name = rs.getString("name");
                type = rs.getString("type");
                description = rs.getString("description");
                urlImage = rs.getString("urlImage");
                result.add(new EquipmentDTO(code, username, fullname, name, type, description, urlImage));
            }
        } finally {
            closeConnection();
        }

        return result;
    }
    
    public List<EquipmentDTO> findByLikeEquipmentNameOfUser(String search, String username) throws ClassNotFoundException, SQLException {
        List<EquipmentDTO> result = null;
        String code, name, type, description, urlImage;

        try {
            String sql = "SELECT code, name, type, description, urlImage "
                    + "FROM [Equipment] "
                    + "WHERE name LIKE ? AND isRemoved <> 1 AND username = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            preStm.setString(2, username);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                code = rs.getString("code");
                name = rs.getString("name");
                type = rs.getString("type");
                description = rs.getString("description");
                urlImage = rs.getString("urlImage");
                result.add(new EquipmentDTO(code, username, "", name, type, description, urlImage));
            }
        } finally {
            closeConnection();
        }

        return result;
    }
    
    public List<EquipmentDTO> getAllEquipment() throws ClassNotFoundException, SQLException {
        List<EquipmentDTO> result = null;
        String code, username, fullname, name, type, description, urlImage;

        try {
            String sql = "SELECT code, [User].username, [User].fullname, name, type, description, urlImage "
                    + "FROM [Equipment] JOIN [User] ON [Equipment].username = [User].username "
                    + "WHERE isRemoved <> 1";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                code = rs.getString("code");
                username = rs.getString("username");
                fullname = rs.getString("fullname");
                name = rs.getString("name");
                type = rs.getString("type");
                description = rs.getString("description");
                urlImage = rs.getString("urlImage");
                result.add(new EquipmentDTO(code, username, fullname, name, type, description, urlImage));
            }
        } finally {
            closeConnection();
        }

        return result;
    }
    
    public List<EquipmentDTO> getAllEquipmentOfUser(String username) throws ClassNotFoundException, SQLException {
        List<EquipmentDTO> result = null;
        String code, name, type, description, urlImage;

        try {
            String sql = "SELECT code, name, type, description, urlImage "
                    + "FROM [Equipment] "
                    + "WHERE isRemoved <> 1 AND username = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                code = rs.getString("code");
                name = rs.getString("name");
                type = rs.getString("type");
                description = rs.getString("description");
                urlImage = rs.getString("urlImage");
                result.add(new EquipmentDTO(code, username, "", name, type, description, urlImage));
            }
        } finally {
            closeConnection();
        }

        return result;
    }
    
    public EquipmentDTO findByEquipmentCode(String search) throws SQLException, ClassNotFoundException {
        EquipmentDTO result = null;
        String code, username, fullname, name, type, description, urlImage;
        
        try {
            String sql = "SELECT code, [User].username, [User].fullname, name, type, description, urlImage "
                    + "FROM [Equipment] JOIN [User] ON [Equipment].username = [User].username "
                    + "WHERE code = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, search);
            rs = preStm.executeQuery();
            if (rs.next()) {
                code = rs.getString("code");
                username = rs.getString("username");
                fullname = rs.getString("fullname");
                name = rs.getString("name");
                type = rs.getString("type");
                description = rs.getString("description");
                urlImage = rs.getString("urlImage");
                result = new EquipmentDTO(code, username, fullname, name, type, description, urlImage);
            }
        } finally {
            closeConnection();
        }
        
        return result;
    }

    public boolean addEquipment(EquipmentDTO dto) throws ClassNotFoundException, SQLException {
        boolean check = false;

        try {
            String sql = "INSERT INTO [Equipment](code, username, name, type, description, isRemoved) VALUES(?, ?, ?, ?, ?, 0)";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getCode());
            preStm.setString(2, dto.getUsername());
            preStm.setString(3, dto.getName());
            preStm.setString(4, dto.getType());
            preStm.setString(5, dto.getDescription());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean removeEquipment(String code) throws ClassNotFoundException, SQLException {
        boolean check = false;
        try {
            String sql = "UPDATE [Equipment] SET isRemoved = 1 WHERE code = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, code);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean updateImage(String code, String urlImage) throws ClassNotFoundException, SQLException {
        boolean check = false;

        try {
            String sql = "UPDATE [Equipment] SET urlImage = ? WHERE code = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, urlImage);
            preStm.setString(2, code);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }
    
    public boolean updateEquipment(EquipmentDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;
        
        try {
            String sql = "UPDATE [Equipment] SET username = ?, name = ?, type = ?, description = ? WHERE code = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getName());
            preStm.setString(3, dto.getType());
            preStm.setString(4, dto.getDescription());
            preStm.setString(5, dto.getCode());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        
        return check;
    }
}
