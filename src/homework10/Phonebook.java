package homework10;

import java.util.ArrayList;
import java.util.HashMap;

public class Phonebook {
    private HashMap<String, ArrayList<String>> phoneNumbersTable = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        ArrayList<String> list = new ArrayList<>();

        if (phoneNumbersTable.containsKey(lastName)) {
            phoneNumbersTable.get(lastName).add(phoneNumber);
        }
        else {
            list.add(phoneNumber);
            phoneNumbersTable.put(lastName, list);
        }
    }

    public void get(String lastName) {
        System.out.println(phoneNumbersTable.get(lastName));
    }
}
