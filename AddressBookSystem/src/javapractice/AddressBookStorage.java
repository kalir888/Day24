package javapractice;

import java.util.HashMap;

public class AddressBookStorage {
    private static AddressBookStorage instance;
    private HashMap<String,AddressBook> addressBookLibrary = new HashMap<>();

    private AddressBookStorage() {
    }

    public static AddressBookStorage getInstance() {
        if(instance == null)
            instance = new AddressBookStorage();
        return instance;
    }

    public boolean addressBookNameValidCheck(String name) {
        return !addressBookLibrary.containsKey(name);
    }

    public boolean contactNameDuplicateCheck(String name) {
        return addressBookLibrary.values().stream().anyMatch(addressBook -> addressBook.contactNameValidCheck(name));
    }

    public void addAddressBook(String key, AddressBook addressBook) {
        addressBookLibrary.put(key, addressBook);
    }

    public void removeAddressBook(String key) {
        addressBookLibrary.remove(key);
    }

    public AddressBook getAddressBook(String key) {
        return addressBookLibrary.get(key);
    }

    public HashMap<String, AddressBook> getAddressBookLibrary() {
        return addressBookLibrary;
    }
}
