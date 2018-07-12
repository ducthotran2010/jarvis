/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tho.Models;

import java.io.Serializable;

/**
 *
 * @author ThoDT
 */
public class EquipmentDTO implements Serializable {
    private String code, username, fullname, name, type, description, urlImage = "src/img/default.png";

    public EquipmentDTO(String code, String username, String name, String type, String description) {
        this.code = code;
        this.username = username;
        this.name = name;
        this.type = type;
        this.description = description;
    }
    
    public EquipmentDTO(String code, String username, String fullname, String name, String type, String description, String urlImage) {
        this.code = code;
        this.username = username;
        this.fullname = fullname;
        this.name = name;
        this.type = type;
        this.description = description;
        if (urlImage != null) {
            this.urlImage = urlImage;
        }
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getUsername() {
        return username;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getFullname() {
        return fullname;
    }
}
