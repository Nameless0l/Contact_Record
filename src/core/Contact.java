package core;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract   class Contact {
    private String code;
    private String nom;
    private String date;
    private String address;
    private String email;
    private String telNumber;


    public Contact(String code, String nom, String date, String address, String email, String telNumber) {
        this.code = code;
        this.nom = nom;
        this.date = date;
        this.address = address;
        this.email = email;
        this.telNumber = telNumber;
    }
    public abstract void insertContact(Connection connection) throws SQLException;
    public void Contact(Connection connection) throws SQLException {
        try {
            // Insérer les données communes dans la table "contacts"
            String queryContacts = "INSERT INTO contacts (code, nom, date_naissance, address, telNumber, email) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatementContacts = connection.prepareStatement(queryContacts);
            preparedStatementContacts.setString(1, getCode());
            preparedStatementContacts.setString(2, getNom());
            preparedStatementContacts.setString(3, getDate());
            preparedStatementContacts.setString(4, getAddress());
            preparedStatementContacts.setString(5, getTelNumber());
            preparedStatementContacts.setString(6, getEmail());
            preparedStatementContacts.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }
}
