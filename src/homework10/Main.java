package homework10;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        repeatWords();
        Phonebook phonebook = new Phonebook();
    }

    private static void repeatWords() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String[] words = {
                "Coffee", "Potato", "Alpha",
                "Cheese", "Beta", "Humster",
                "Dog", "Cat", "Java",
                "Yava", "Kent", "Coffee",
                "Dog", "Beta", "Humster",
                "Cat", "Java", "Yava", "Dog"
        };

        for (String word : words) {
            if (hashMap.containsKey(word)) {
                hashMap.put(word, hashMap.get(word) + 1);
            } else {
                hashMap.put(word, 1);
            }
        }
        System.out.println(hashMap);
    }
}
