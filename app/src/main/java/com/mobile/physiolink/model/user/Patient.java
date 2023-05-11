package com.mobile.physiolink.model.user;

public class Patient extends User
{
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String address;
    private long doctorId;
    private String amka;

    public Patient(long id,
                  String username,
                  String type,
                  String name,
                  String surname,
                  String email,
                  String phoneNumber,
                  String amka,
                  String address, long doctorId)
    {
        super(id, username, type);

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.amka = amka;
        this.address = address;
        this.doctorId = doctorId;
    }

    public Patient(long id,
                   String username,
                   String type)
    {
        super(id, username, type);
    }

    public Patient(){super();}

    public String getName()
    {
        return name;
    }

    public String getSurname()
    {
        return surname;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getAmka()
    {
        return amka;
    }
}
