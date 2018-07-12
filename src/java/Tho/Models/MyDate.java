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
public class MyDate implements Serializable {

    public static Date getDate(String txtDate) {
        Date result = null;
        String arr[] = txtDate.split("-");
        if (arr.length == 3) {
            int year = Integer.parseInt(arr[0]) - 1900;
            int month = Integer.parseInt(arr[1]) - 1;
            int day = Integer.parseInt(arr[2]);
            result = new Date(year, month, day);
        }
        return result;
    }
}
