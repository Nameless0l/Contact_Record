package core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
public class Repertoire {
    Connection connection;
    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    private List<Contact> contacts;

    public Repertoire() {
        
        contacts = new ArrayList<Contact>();
    }
    public Repertoire(Connection connection) {
        this.connection = connection;
        contacts = new ArrayList<Contact>();
    }
    public void ajouterContact(Contact contact) {
        contacts.add(contact);
    }
    public void supprimerContact(Contact contact) {
        contacts.remove(contact);
    }
    public int modifierContact(Contact contact) {
        int index = contacts.indexOf(contact);
        if (index != -1) {
            contacts.set(index, contact);
            return 200;
        }else {
            return 404;
        }
    }
    public Contact rechercherContact(String nom) {
        for (Contact contact : contacts) {
            if (contact.getNom().equalsIgnoreCase(nom)){
                return contact;
            }
        }
        return null;
    }
    public int getNombreContacts() {
        return this.contacts.size();
    }
    
     public void chargerContactsDepuisBD() {
        if (connection == null) {
            System.err.println("La connexion à la base de données n'est pas initialisée.");
            return;
        }

        try {
            String sqlQuery = "SELECT * FROM contacts";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sqlQuery)) {
                while (resultSet.next()) {
                    String code = resultSet.getString("code");
                    String nom = resultSet.getString("nom");
                    String email = resultSet.getString("email");
                    String date = resultSet.getString("date_naissance");
                    String address = resultSet.getString("address");
                    String telNumber = resultSet.getString("telNumber");
                    // Ajouter le contact à la liste
                    contacts.add( Contacts(code,nom,date,address, email,telNumber));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
