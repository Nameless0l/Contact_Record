package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 */
public class Etudiant extends Contact{
    private String cycle;
    private String niveau;

    public Etudiant(String code, String nom, String date, String address, String email, String telNumber) {
        super(code, nom, date, address, email, telNumber);
    }

    public Etudiant(String code, String nom, String date, String address, String email, String telNumber, String cycle, String niveau) {
        super(code, nom, date, address, email, telNumber);
        this.cycle = cycle;
        this.niveau = niveau;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    @Override
    public void insertContact(Connection connection) throws SQLException {
        try{
            super.Contact(connection);
            String query_etudiant = "INSERT INTO etudiants (code_etudiant,cycle,niveau) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query_etudiant);
            preparedStatement.setString(1, super.getCode());
            preparedStatement.setString(2,getCycle());
            preparedStatement.setString(3,getNiveau());
            preparedStatement.executeUpdate();
    }catch (SQLException e){
            e.printStackTrace();
        }
}
}
