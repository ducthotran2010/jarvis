/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tho.Models;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author ThoDT
 */
public class UserDTO implements Serializable {
    private String username, password, role, fullname, abilities, powers, height, weight, urlAvatar = "src/img/default.png"; 
    private Date dateJoined;

    public UserDTO(String username, String role, String fullname, String abilities, String powers, String height, String weight, Date dateJoined) {
        this.username = username;
        this.role = role;
        this.fullname = fullname;
        this.abilities = abilities;
        this.powers = powers;
        this.height = height;
        this.weight = weight;
        this.dateJoined = dateJoined;
    }

    public UserDTO(String username, String password, String role, String fullname, String abilities, String powers, String height, String weight, Date dateJoined) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.fullname = fullname;
        this.abilities = abilities;
        this.powers = powers;
        this.height = height;
        this.weight = weight;
        this.dateJoined = dateJoined;
    }

    public UserDTO(String username, String role, String fullname, String abilities, String powers, String height, String weight, Date dateJoined, String urlAvatar) {
        this.username = username;
        this.role = role;
        this.fullname = fullname;
        this.abilities = abilities;
        this.powers = powers;
        this.height = height;
        this.weight = weight;
        if (urlAvatar != null)
            this.urlAvatar = urlAvatar;
        this.dateJoined = dateJoined;
    }
    
    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getFullname() {
        return fullname;
    }

    public String getAbilities() {
        return abilities;
    }

    public String getPowers() {
        return powers;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public String getPassword() {
        return password;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }    
}
