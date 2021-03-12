package com.example.retrofit;

import java.io.Serializable;
import java.util.List;

public class UserResponse{
    public List<Contact> contacts;
}
class Phone{
    public String mobile;
    public String home;
    public String office;
}

class Contact{
    public String id;
    public String name;
    public String email;
    public String address;
    public String gender;
    public Phone phone;
}


