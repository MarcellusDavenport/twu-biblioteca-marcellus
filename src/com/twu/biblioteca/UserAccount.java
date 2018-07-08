package com.twu.biblioteca;

public class UserAccount {

    private String name;
    private String emailAddress;
    private String phoneNumber;
    private String libraryNumber;
    private String password;

    public UserAccount(String name, String emailAddress, String phoneNumber, String libraryNumber, String password) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLibraryNumber() {
        return libraryNumber;
    }

}
