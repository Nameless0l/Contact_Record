package contact_record;

import core.Agent;
import core.Contact;
import core.Enseignant;
import core.Etudiant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainApplication {
    public static void main(String[] args) {
        Etudiant etudiant = new Etudiant("code_et4","mbassi","12/20/2001","melen","wwwmbassiloic@gmail.com","656820591","Ingenieur","3GI");
        Agent agent = new Agent("code_ag4","mbassi","12/20/2001","melen","wwwmbassiloic@gmail.com","656820591","Ingenieur","A","0.2","Free",1233.23);
        Enseignant enseignant = new Enseignant("code_en4","mbassi","12/20/2001","melen","wwwmbassiloic@gmail.com","656820591","celibataire");
        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact_record_project","root","root");
            etudiant.insertContact(connection);
            agent.insertContact(connection);
            enseignant.insertContact(connection);
    }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
