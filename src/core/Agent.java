package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Agent extends Contact{
    private String statut;
    private String categorie;
    private String indice_salaire;
    private String occupation;
    private double salaire;
    public Agent(String code, String nom, String date, String address, String email, String telNumber, String statut, String categorie, String indiceSalaire, String occupation, double salaire) {
        super(code, nom, date, address, email, telNumber);
        this.statut = statut;
        this.categorie = categorie;
        indice_salaire = indiceSalaire;
        this.occupation = occupation;
        this.salaire = salaire;
    }

    @Override
    public void insertContact(Connection connection) {
        try{
            super.Contact(connection);
            String query_agent = "INSERT INTO agents (code_agent,statut,categorie,occupation,indice_salaire,salaire) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query_agent);
            preparedStatement.setString(1, super.getCode());
            preparedStatement.setString(2,getStatut());
            preparedStatement.setString(3,getCategorie());
            preparedStatement.setString(4,getOccupation());
            preparedStatement.setString(5,getIndice_salaire());
            preparedStatement.setDouble(6,getSalaire());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getIndice_salaire() {
        return indice_salaire;
    }

    public void setIndice_salaire(String indice_salaire) {
        this.indice_salaire = indice_salaire;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
}
