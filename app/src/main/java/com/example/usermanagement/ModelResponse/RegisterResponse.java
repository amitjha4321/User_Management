package com.example.usermanagement.ModelResponse;

import com.google.gson.annotations.SerializedName;

//{
//        "id": 15,
//        "userName": "Amit",
//        "emailId": "qwertwe@ytyd.vin",
//        "password": "0988787",
//        "fileName": "download.jpg"
//        }
public class RegisterResponse {
    @SerializedName("userName")
    String userName;
    @SerializedName("emailId")
    String emailId;
    @SerializedName(("password"))
    String password;
    //String fileName;

    public RegisterResponse(String userName, String emailId, String password, String fileName) {
        this.userName = userName;
        this.emailId = emailId;
        this.password = password;
        //this.fileName=fileName;
    }

    public RegisterResponse() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getFileName() {
//        return fileName;
//    }
//
//    public void setFileName(String fileName) {
//        this.fileName = fileName;
//    }
}
