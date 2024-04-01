package core;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Enseignant extends Contact{
    private String statut;
    public Enseignant(String code, String nom, String date, String address, String email, String telNumber, String statut) {
        super(code, nom, date, address, email, telNumber);
        this.statut = statut;
    }


    @Override
    public void insertContact(Connection connection) {
        try{
            super.Contact(connection);
            String query_enseignant = "INSERT INTO enseignants (code_enseignant,statut) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query_enseignant);
            preparedStatement.setString(1, super.getCode());
            preparedStatement.setString(2,getStatut());
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

}
