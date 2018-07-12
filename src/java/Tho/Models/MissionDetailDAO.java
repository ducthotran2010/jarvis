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
public class MissionDetailDAO implements Serializable {

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

    public boolean addUserToMission(String username, String id) throws ClassNotFoundException, SQLException {
        boolean check = false;

        try {
            String sql = "INSERT INTO [MissionDetail](username, missionID, isQuitted) VALUES(?, ?, 0)";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }

        return check;
    }

    public boolean quitMission(String username, String missionID) throws ClassNotFoundException, SQLException {
        boolean check = false;

        try {
            String sql = "UPDATE [MissionDetail] SET isQuitted = 1 WHERE username = ? AND missionID = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, missionID);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<UserDTO> getAllUserInMission(String missionID) throws ClassNotFoundException, SQLException {
        List<UserDTO> result = null;
        String username, fullname, urlAvatar;
        try {
            String sql = "SELECT DISTINCT [User].username, [User].fullname, [User].urlAvatar\n"
                    + "FROM MissionDetail JOIN [User] ON MissionDetail.username = [User].username\n"
                    + "WHERE MissionDetail.isQuitted = 0 AND [User].isDeactive = 0 AND MissionDetail.missionID = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, missionID);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("username");
                fullname = rs.getString("fullname");
                urlAvatar = rs.getString("urlAvatar");
                result.add(new UserDTO(username, fullname, urlAvatar));
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public List<MissionDTO> getAllMissionOfUser(String username) throws ClassNotFoundException, SQLException {
        List<MissionDTO> result = null;
        String id, name, status, description, urlImage;
        Date dateStart, dateEnd;
        try {
            String sql = "SELECT DISTINCT Mission.id, Mission.name, Mission.status, Mission.description, Mission.dateStart, Mission.dateEnd, Mission.urlImage \n"
                    + "FROM MissionDetail JOIN Mission ON MissionDetail.missionID = Mission.id \n"
                    + "WHERE MissionDetail.isQuitted = 0 AND Mission.isRemoved = 0 AND MissionDetail.username = ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
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

    public List<MissionDTO> findByLikeMissionNameOfUser(String username, String search) throws ClassNotFoundException, SQLException {
        List<MissionDTO> result = null;
        String id, name, status, description, urlImage;
        Date dateStart, dateEnd;
        try {
            String sql = "SELECT DISTINCT Mission.id, Mission.name, Mission.status, Mission.description, Mission.dateStart, Mission.dateEnd, Mission.urlImage \n"
                    + "FROM MissionDetail JOIN Mission ON MissionDetail.missionID = Mission.id \n"
                    + "WHERE MissionDetail.isQuitted = 0 AND Mission.isRemoved = 0 AND MissionDetail.username = ? AND Mission.name LIKE ?";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, '%' + search + '%');
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
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

    public boolean isUserInMission(String username, String missionID) throws ClassNotFoundException, SQLException {
        boolean result = false;

        try {
            String sql = "SELECT COUNT(id) as AmountOfMission\n"
                    + "  FROM [avengers].[dbo].[MissionDetail]\n"
                    + "  WHERE username=? AND missionID=? AND isQuitted = 0";
            conn = DBConnection.getConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, missionID);
            rs = preStm.executeQuery();
            if (rs.next()) {
                result = rs.getInt("AmountOfMission") > 0;
            }
        } finally {
            closeConnection();
        }

        return result;
    }
}
