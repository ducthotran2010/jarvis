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

/**
 *
 * @author ThoDT
 */
public class StatisticDAO implements Serializable {

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

    public int getAmountOfActiveUser() throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(isDeactive) as result FROM [User] where isDeactive = 0";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getAmountOfDeactiveUser() throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(isDeactive) as result FROM [User] where isDeactive = 1";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getAmountOfAdmin() throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(role) as result FROM [user] WHERE role = 'Admin'";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getAmountOfUser() throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(role) as result FROM [user] WHERE role <> 'Admin'";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getAmountOfCompletedMission() throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(status) as result FROM [Mission] WHERE status='Completed'";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getAmountOfJoinedMissionOfUser(String username) throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(isQuitted) as result FROM [MissionDetail]  WHERE username = ? AND isQuitted = 0";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }
    
    public int getAmountOfQuittedMissionOfUser(String username) throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(isQuitted) as result FROM [MissionDetail]  WHERE username = ? AND isQuitted = 1";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getAmountOfFailedMission() throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(status) as result FROM [Mission] WHERE status='Failed'";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getAmountOfCancelledMission() throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(status) as result FROM [Mission] WHERE status='Cancelled'";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getAmountOfOtherMission() throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(status) as result FROM [Mission] WHERE status='Base on real time'";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getAmountOfWeapon() throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(type) as result FROM [Equipment] WHERE type='Weapon' AND isRemoved <> 1";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getAmountOfWeaponOfUser(String username) throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(type) as result FROM [Equipment] WHERE type='Weapon' AND isRemoved <> 1 AND username = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getAmountOfSuit() throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(type) as result FROM [Equipment] WHERE type<>'Weapon' AND isRemoved <> 1";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getAmountOfSuitOfUser(String username) throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(type) as result FROM [Equipment] WHERE type<>'Weapon' AND isRemoved <> 1 AND username = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getAmountOfRemovedEquipment() throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(isRemoved) as result FROM [Equipment] WHERE isRemoved = 1";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public int getAmountOfRemovedEquipmentOfUser(String username) throws SQLException, ClassNotFoundException {
        int result = 0;

        try {
            String sql = "SELECT count(isRemoved) as result FROM [Equipment] WHERE isRemoved = 1 AND username = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("result");
            }
        } finally {
            closeConnection();
        }

        return result;
    }
}
