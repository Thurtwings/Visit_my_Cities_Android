package com.example.visit_my_cities_android.models;

public class User
{
    private int userId;
    private String userPseudo;

    private String userMail;
    private String userPassword;

    private String userPicture;

    private String userRole;


    public User(int userId, String userPseudo, String userMail, String userPassword, String userPicture, String userRole) {
        this.userId = userId;
        this.userPseudo = userPseudo;
        this.userMail = userMail;
        this.userPassword = userPassword;
        this.userPicture = userPicture;
        this.userRole = userRole;
    }

    public User() {
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserPseudo() {
        return userPseudo;
    }

    public void setUserPseudo(String userPseudo) {
        this.userPseudo = userPseudo;
    }

    public String getUserMail() {return userMail; }

    public void setUserMail(String userMail) {this.userMail = userMail; }

    public String getUserPassword() {return userPassword; }

    public void setUserPassword(String userPassword) {this.userPassword = userPassword; }

    public String getUserPicture() {return userPicture; }

    public void setUserPicture(String userPicture) {this.userPicture = userPicture; }

    public String getUserRole() {return userRole; }

    public void setUserRole(String userRole) {this.userRole = userRole; }
}
