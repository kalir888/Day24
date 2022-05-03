package javapractice;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

    public boolean contactNameValidCheck(String name) {
        return contactList.stream().anyMatch(contact -> contact.firstName.equals(name));
    }

    public void printSortedContactsByName() {
        contactList.stream().sorted((c1, c2) -> c1.firstName.compareTo(c2.firstName)).forEach(System.out::println);
    }

    public void printSortedContactsByCity() {
        contactList.stream().sorted((c1, c2) -> c1.city.compareTo(c2.city)).forEach(System.out::println);
    }

    public void printSortedContactsByState() {
        contactList.stream().sorted((c1, c2) -> c1.state.compareTo(c2.state)).forEach(System.out::println);
    }

    public void printSortedContactsByPin() {
        contactList.stream().sorted((c1, c2) -> c1.pinCode.compareTo(c2.pinCode)).forEach(System.out::println);
    }

    public List<Contact> getContactBelongToAState(String state) {
        return contactList.stream().filter(contact -> contact.state.equals(state)).collect(Collectors.toList());
    }

    public List<Contact> getContactBelongToACity(String city) {
        return contactList.stream().filter(contact -> contact.city.equals(city)).collect(Collectors.toList());
    }

    public Set<Contact> getContactList() {
        return contactList;
    }
}
