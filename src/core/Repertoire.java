package core;

import java.util.ArrayList;
import java.util.List;

public class Repertoire {
    private int repertoire;
    private List<Contact> contacts;

    public Repertoire() {
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
}
