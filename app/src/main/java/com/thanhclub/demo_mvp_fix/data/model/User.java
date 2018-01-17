package com.thanhclub.demo_mvp_fix.data.model;


public class User {
    private String urlImage;
    private String idUser;
    private String nameUser;

    public User(String urlImage, String idUser, String nameUser) {
        this.urlImage = urlImage;
        this.idUser = idUser;
        this.nameUser = nameUser;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }
}
