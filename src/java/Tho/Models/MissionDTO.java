/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tho.Models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Vector;

/**
 *
 * @author ThoDT
 */
public class MissionDTO implements Serializable {

    private String id, name, description, status = "Base on real time", urlImage = "src/img/default.png";
    private Date dateStart, dateEnd;

    public MissionDTO(Date dateStart, Date dateEnd) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }
    
    public MissionDTO(String id, String name, String description, String status, Date dateStart, Date dateEnd) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
    }

    public MissionDTO(String id, String name, String description, String status, Date dateStart, Date dateEnd, String urlImage) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        if (urlImage != null) {
            this.urlImage = urlImage;
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getRealStatus(Date currentDate) {
        String result = "";

        if (status.equals("Base on real time")) {
            if (currentDate.before(dateStart)) {
                result = "Waiting to start";
            } else if (dateEnd != null && currentDate.after(dateEnd)) {
                result = "Waiting to update result";
            } else {
                result = "Started";
            }
        } else {
            result = status;
        }

        return result;
    }
    
    public Vector<String> getChooseFromRealStatus(Date currentDate) {
        Vector<String> result = new Vector<>();
        result.add(getRealStatus(currentDate));
        switch (status) {
            case "Cancelled":
                result.add("Reopen"); break;
            case "Completed":
                result.add("Reopen");
                result.add("Failed");
                break;
            case "Failed":
                result.add("Reopen");
                result.add("Completed");
                break;
            case "Base on real time":
                if (currentDate.before(dateStart)) {
                    result.add("Cancelled");
                } else {
                    result.add("Completed");
                    result.add("Failed");
                }
                break;
        }
        
        return result;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
