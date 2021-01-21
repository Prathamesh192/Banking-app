package com.example.tsf_bank;

public class MemberImport {
    Integer id ;
    String name ;
    String email ;

    String currentbal ;
    String AccountNo ;

    public MemberImport(String name, String email, String currentbal, String accountNo) {
        this.name = name;
        this.email = email;
        this.currentbal = currentbal;
        AccountNo = accountNo;
    }

    public MemberImport(Integer id, String name, String email, String currentbal, String accountNo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.currentbal = currentbal;
        AccountNo = accountNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCurrentbal() {
        return currentbal;
    }

    public void setCurrentbal(String currentbal) {
        this.currentbal = currentbal;
    }

    public String getAccountNo() {
        return AccountNo;
    }

    public void setAccountNo(String accountNo) {
        AccountNo = accountNo;
    }
}


