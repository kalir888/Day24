package javapractice;

import java.util.Scanner;

public class Main {
    AddressBookStorage addressBookStorage = AddressBookStorage.getInstance();

    public void handleUserMenuOption(int choice) {
        Scanner get = new Scanner(System.in);

        switch(choice) {
            case 1:
                create();
                break;
            case 2:
                System.out.println("Enter the name of an Address Book");
                String bookName = get.next();
                if(!addressBookStorage.addressBookNameValidCheck(bookName)) {
                    AddressBook addressBook = addressBookStorage.getAddressBook(bookName);
                    UserInterface userInterface = UserInterface.getInstance();
                    userInterface.print(addressBook.getContactList());
                }else
                    System.out.println("Address Book name not found");
                break;
            case 3:
                System.out.println("Enter the name of an Address Book");
                String bookNameToEdit = get.next();
                if(!addressBookStorage.addressBookNameValidCheck(bookNameToEdit)) {
                    AddressBook addressBook = addressBookStorage.getAddressBook(bookNameToEdit);
                    System.out.println("Enter First Name of the Contact to edit");
                    Contact contactToEdit = addressBook.getContact(get.next());
                    if(contactToEdit != null)
                        edit(contactToEdit);
                    else
                        System.out.println("Contact Name not found in this Address Book");
                }else
                    System.out.println("Address Book name not found");
                break;
            case 4:
                System.out.println("Enter the name of an Address Book");
                String bookNameToRemoveContact = get.next();
                if(!addressBookStorage.addressBookNameValidCheck(bookNameToRemoveContact)) {
                    AddressBook addressBook = addressBookStorage.getAddressBook(bookNameToRemoveContact);
                    System.out.println("Enter First Name of the Contact to remove");
                    Contact contactToRemove = addressBook.getContact(get.next());
                    if(contactToRemove != null)
                        addressBook.remove(contactToRemove);
                    else
                        System.out.println("Contact Name not found in this AddressBook");
                }else
                    System.out.println("Address Book name not found");
                break;
            case 5:
                System.out.println("Exiting from menu");
                break;
            default:
                System.out.println("Invalid Menu option");
                break;
        }
    }

    private void edit(Contact contact) {
        int updateChoice = 0;
        UserInterface userInterface = UserInterface.getInstance();
        while(updateChoice <= 8) {
            if(updateChoice == 8) {
                System.out.println("Returning to Menu");
                break;
            }
            updateChoice = userInterface.showEditMenu();
            handleUserEditOption(updateChoice,contact);
        }
    }

    private void handleUserEditOption(int updateChoice, Contact contact) {
        Scanner get = new Scanner(System.in);
        switch(updateChoice) {
            case 1:
                System.out.println("Enter the new Last Name");
                contact.lastName = get.next();
                break;
            case 2:
                System.out.println("Enter the new Address");
                contact.address = get.next();
                break;
            case 3:
                System.out.println("Enter the new City");
                contact.city = get.next();
                break;
            case 4:
                System.out.println("Enter the new State");
                contact.state = get.next();
                break;
            case 5:
                System.out.println("Enter the new Pin-code");
                contact.pinCode = get.next();
                break;
            case 6:
                System.out.println("Enter the new PhoneNumber");
                contact.phoneNumber = get.next();
                break;
            case 7:
                System.out.println("Enter the new Email Id");
                contact.emailId = get.next();
                break;
            default:
                System.out.println("Invalid Option");
                break;
        }
    }

    private void create() {
        Scanner get = new Scanner(System.in);
        System.out.println("Select to create new\n1.AddressBook\n2.Contact");
        int userChoice = get.nextInt();
        switch(userChoice) {
            case 1:
                System.out.println("Enter the Name of Address Book\nnote: don't give space in name");
                String name = get.next();
                if(addressBookStorage.addressBookNameValidCheck(name)) {
                    AddressBook addressBook = new AddressBook();
                    addressBookStorage.addAddressBook(name, addressBook);
                }else
                    System.out.println("Address book name already exist");
                break;
            case 2:
                System.out.println("Enter the name of an Address Book");
                String bookName = get.next();
                if (!addressBookStorage.addressBookNameValidCheck(bookName)) {
                    AddressBook addressBook = addressBookStorage.getAddressBook(bookName);
                    System.out.println("Enter the First Name");
                    String nameToAdd = get.next();
                    if(!addressBookStorage.contactNameDuplicateCheck(nameToAdd)) {
                        Contact contact = new Contact(nameToAdd);
                        String SKIP = "1";
                        System.out.println("Enter the Last Name\n to skip the step press 1");
                        String temp = get.next();
                        if (!temp.equals(SKIP))
                            contact.lastName = temp;
                        System.out.println("Enter the Address\n to skip the step press 1");
                        temp = get.next();
                        if (!temp.equals(SKIP))
                            contact.address = temp;
                        System.out.println("Enter the city\n to skip the step press 1");
                        temp = get.next();
                        if (!temp.equals(SKIP))
                            contact.city = temp;
                        System.out.println("Enter the state\n to skip the step press 1");
                        temp = get.next();
                        if (!temp.equals(SKIP))
                            contact.state = temp;
                        System.out.println("Enter the pin-code\n to skip the step press 1");
                        temp = get.next();
                        if (!temp.equals(SKIP))
                            contact.pinCode = temp;
                        System.out.println("Enter the phone number");
                        contact.phoneNumber = get.next();
                        System.out.println("Enter the email id\n to skip the step press 1");
                        temp = get.next();
                        if (!temp.equals(SKIP))
                            contact.emailId = temp;
                        addressBook.add(contact);
                    }else
                        System.out.println("Contact name already exist");
                }else
                    System.out.println("Address Book name not found");
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Address Book System");

        UserInterface userInterface = UserInterface.getInstance();
        Main main = new Main();

        int choice = 0;
        while(choice < 5) {
            choice = userInterface.showMenu();
            main.handleUserMenuOption(choice);
        }
    }
}
