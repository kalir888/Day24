package javapractice;

import java.util.HashSet;
import java.util.Set;

public class AddressBook {
    private Set<Contact> contactList = new HashSet<>();

    public void add(Contact contact) {
        contactList.add(contact);
    }

    public void remove(Contact contact){
        contactList.remove(contact);
    }

    public Contact getContact(String name) {
        for(Contact contact: contactList) {
            if(contact.firstName.equals(name))
                return contact;
        }
        return null;
    }
    public Set<Contact> getContactList() {
        return contactList;
    }
}
