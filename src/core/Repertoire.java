package core;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Repertoire {
    Connection connection;
    public List<Contact> getContacts() {
        return contacts;
    }
    public List<Contact> getContactsBd(String typeContact) {

        // Déclaration des variables de connexion

        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
            // Charger le driver JDBC
            Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact_record_project","root","root");

            // Connexion à la base de données

            // Requête SQL pour extraire les contacts en fonction du type spécifié
            String sqlQuery = "";
            if (typeContact.equals("Etudiant")) {
                sqlQuery = "SELECT e.code_etudiant,e.niveau,e.cycle,address, nom, date_naissance, telNumber, email FROM contacts c JOIN etudiants e ON c.code = e.code_etudiant";
            } else if (typeContact.equals("Agent")) {
                sqlQuery = "SELECT a.code_agent, salaire, statut, categorie, indice_salaire, occupation,address, nom, date_naissance, telNumber, email FROM contacts c JOIN agents a ON c.code = a.code_agent\n";
            } else if (typeContact.equals("Enseignant")) {
                sqlQuery = "SELECT e.code_enseignant,e.statut,address, nom, date_naissance, telNumber, email FROM contacts c JOIN enseignants e ON c.code = e.code_enseignant\n";
            }

            // Préparer la requête SQL
            stmt = connection1.prepareStatement(sqlQuery);

            // Exécuter la requête
            rs = stmt.executeQuery();

            // Parcourir les résultats et créer les objets de contact correspondants
            while (rs.next()) {
                if (typeContact.equals("Etudiant")){
                    Etudiant etudiant = new Etudiant(rs.getString("code_etudiant"), rs.getString("nom"), rs.getString("date_naissance"), rs.getString("address"),rs.getString("email"),rs.getString("telNumber"),rs.getString("nom"),rs.getString("niveau"));
                    contacts.add(etudiant);
                } else if (typeContact.equals("Agent")) {
                    Agent agent = new Agent(rs.getString("code_agent"), rs.getString("nom"), rs.getString("date_naissance"), rs.getString("address"),rs.getString("email"),rs.getString("telNumber"),rs.getString("statut"),rs.getString("categorie"),rs.getString("indice_salaire"),rs.getString("occupation"),rs.getDouble("salaire"));
                    contacts.add(agent);
                } else if (typeContact.equals("Enseignant")) {
                    Enseignant enseignant = new Enseignant(rs.getString("code_enseignant"), rs.getString("nom"), rs.getString("date_naissance"), rs.getString("address"),rs.getString("email"),rs.getString("telNumber"),rs.getString("statut"));
                    contacts.add(enseignant);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermer les ressources JDBC
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (this.connection != null) this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

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
    
//     public void chargerContactsDepuisBD() {
//        if (connection == null) {
//            System.err.println("La connexion à la base de données n'est pas initialisée.");
//            return;
//        }
//
//        try {
//            String sqlQuery = "SELECT * FROM contacts";
//            try (Statement statement = connection.createStatement();
//                 ResultSet resultSet = statement.executeQuery(sqlQuery)) {
//                while (resultSet.next()) {
//                    String code = resultSet.getString("code");
//                    String nom = resultSet.getString("nom");
//                    String email = resultSet.getString("email");
//                    String date = resultSet.getString("date_naissance");
//                    String address = resultSet.getString("address");
//                    String telNumber = resultSet.getString("telNumber");
//                    // Ajouter le contact à la liste
//                    contacts.add( Contact(code,nom,date,address, email,telNumber));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}
