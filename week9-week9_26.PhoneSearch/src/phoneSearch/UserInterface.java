/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phoneSearch;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author teruaki
 */
public class UserInterface {

    private Scanner reader;
    private phoneSearch search = new phoneSearch();

    public UserInterface(Scanner reader) {
        this.reader = reader;
    }

    public void start() {
        printCommand();

        while (true) {
            System.out.println();
            System.out.print("command: ");
            String command = reader.nextLine();

            if (command.equals("1")) {
                addNumber();

            } else if (command.equals("2")) {
                searchNumber();

            } else if (command.equals("3")) {
                searchPersonByNumber();

            } else if (command.equals("4")) {
                addAddress();

            } else if (command.equals("5")) {
                searchPersonInfo();

            } else if (command.equals("6")) {
                deleteInfo();

            } else if (command.equals("7")) {
                filterList();

            } else {
                break;
            }
        }
    }

    public void addNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();
        System.out.print("number: ");
        String number = reader.nextLine();
        Person person = new Person(name, number);
        search.addPhone(name, number);
    }

    public void searchNumber() {
        System.out.print("whose number: ");
        String name = reader.nextLine();

        if (search.getPhoneBook().containsKey(name)) {
            printNumber(name);
        } else {
            System.out.println("  not found");
        }
    }

    private void printNumber(String name) {
        List numbers = search.searchNumbers(name);
        for (Object number : numbers) {
            System.out.print(" ");
            System.out.println(number);
        }
    }

    public void searchPersonByNumber() {
        System.out.println("number: ");
        String number = reader.nextLine();

        if (search.searchName(number).isEmpty()) {
            System.out.println("  not found");
        } else {
            System.out.println(" " + search.searchName(number));;
        }
    }

    public void addAddress() {
        System.out.println("whose address: ");
        String name = reader.nextLine();
        System.out.println("street: ");
        String street = reader.nextLine();
        System.out.println("city: ");
        String city = reader.nextLine();
        String address = street + " " + city;

        search.addAddress(name, address);
    }

    public void searchPersonInfo() {
        System.out.println("whose information: ");
        String name = reader.nextLine();

        if (search.isContainInfo(name)) {
            printPersonInfo(name);
        } else {
            System.out.println("  not found");
        }
    }

    private void printPersonInfo(String name) {
        if (search.isOnAddressBook(name)) {

            System.out.println("  address: " + search.getAddress(name));

        } else {
            System.out.println("  address unknown");
        }
        if (search.getPhoneBook().containsKey(name)) {
            System.out.println("  phone numbers:");
            printNumberForInfo(name);
        } else {
            System.out.println("  phone number not found");
        }
    }

    private void printNumberForInfo(String name) {
        List numbers = search.searchNumbers(name);
        for (Object number : numbers) {
            System.out.print("   ");
            System.out.println(number);
        }
    }

    public void deleteInfo() {
        System.out.println("whose information: ");
        String name = reader.nextLine();

        search.deleteInfo(name);
    }

    public void filterList() {
        System.out.println("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        List<String> nameList = search.filter(keyword);
        if (nameList.isEmpty()) {
            System.out.println(" keyword not found");

        } else {
            for (String name : nameList) {
                System.out.println();
                System.out.println(" " + name);
                printPersonInfo(name);
            }
        }
    }

    public void printCommand() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
    }
}
