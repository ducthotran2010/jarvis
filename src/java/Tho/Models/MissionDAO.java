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
public class MissionDAO implements Serializable {
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    private void closeConnection() throws SQLException {
        if (rs != null) rs.close();
        if (preStm != null) preStm.close();
        if (conn != null) conn.close();
    }
    
    public List<MissionDTO> findByLikeMissionName(String search) throws ClassNotFoundException, SQLException {
        List<MissionDTO> result = null;
        String id, name, status, description, urlImage;
        Date dateStart, dateEnd;
        try {
            String sql = "SELECT id, name, status, description, dateStart, dateEnd, urlImage FROM [Mission] WHERE name LIKE ? AND isRemoved <> 1";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                status = rs.getString("status");
                dateStart = rs.getDate("dateStart");
                dateEnd = rs.getDate("dateEnd");
                description = rs.getString("description");
                urlImage = rs.getString("urlImage");
                result.add(new MissionDTO(id, name, description, status, dateStart, dateEnd, urlImage));
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public List<MissionDTO> getAllMission() throws ClassNotFoundException, SQLException {
        List<MissionDTO> result = null;
        String id, name, status, description, urlImage;
        Date dateStart, dateEnd;
        try {
            String sql = "SELECT id, name, status, description, dateStart, dateEnd, urlImage FROM [Mission] WHERE isRemoved <> 1";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                status = rs.getString("status");
                dateStart = rs.getDate("dateStart");
                dateEnd = rs.getDate("dateEnd");
                description = rs.getString("description");
                urlImage = rs.getString("urlImage");
                result.add(new MissionDTO(id, name, description, status, dateStart, dateEnd, urlImage));
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public MissionDTO findByMissionId(String search) throws SQLException, ClassNotFoundException {
        MissionDTO result = null;
        String id, name, status, description, urlImage;
        Date dateStart, dateEnd;
        
        try {
            String sql = "SELECT id, name, status, dateStart, dateEnd, description, urlImage FROM [Mission] WHERE id = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, search);
            rs = preStm.executeQuery();
            if (rs.next()) {
                id = rs.getString("id");
                name = rs.getString("name");
                status = rs.getString("status");
                dateStart = rs.getDate("dateStart");
                dateEnd = rs.getDate("dateEnd");
                description = rs.getString("description");
                urlImage = rs.getString("urlImage");
                result = new MissionDTO(id, name, description, status, dateStart, dateEnd, urlImage);
            }
        } finally {
            closeConnection();
        }
        
        return result;
    }
    
    public boolean updateMission(MissionDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;
        
        try {
            String sql = "UPDATE [Mission] SET name = ?, dateStart = ?, dateEnd = ?, status = ?, description = ? WHERE id = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getName());
            preStm.setDate(2, dto.getDateStart());
            preStm.setDate(3, dto.getDateEnd());
            preStm.setString(4, dto.getStatus());
            preStm.setString(5, dto.getDescription());
            preStm.setString(6, dto.getId());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        
        return check;
    }
    
    public boolean addMission(MissionDTO dto) throws SQLException, ClassNotFoundException {
        boolean check = false;
        
        try {
            String sql = "INSERT INTO [Mission](id, name, description, status, dateStart, dateEnd, isRemoved) VALUES(?, ?, ?, ?, ?, ?, 0)";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getId());
            preStm.setString(2, dto.getName());
            preStm.setString(3, dto.getDescription());
            preStm.setString(4, dto.getStatus());
            preStm.setDate(5, dto.getDateStart());
            preStm.setDate(6, dto.getDateEnd());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        
        return check;
    }
    
    public boolean removeMission(String id) throws ClassNotFoundException, SQLException {
        boolean check = false;
        
        try {
            String sql = "UPDATE [Mission] SET isRemoved = 1 WHERE id = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        
        return check;
    }
    
    public boolean updateImage(String id, String urlImage) throws ClassNotFoundException, SQLException {
        boolean check = false;
        
        try {
            String sql = "UPDATE [Mission] SET urlImage = ? WHERE id = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, urlImage);
            preStm.setString(2, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        
        return check;
    }
}
