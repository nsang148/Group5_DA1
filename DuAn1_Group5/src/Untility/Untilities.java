/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Untility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sangh
 */
public class Untilities {
    public static boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(Constant.EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches() ;
    }
    
    public static boolean validatePhoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile(Constant.PHONENUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public static boolean validateName(String name){
        Pattern pattern = Pattern.compile(Constant.NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
