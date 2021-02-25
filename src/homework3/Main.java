package homework3;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] words =
                {
                        "apple", "orange", "lemon", "banana",
                        "apricot", "avocado", "broccoli", "carrot",
                        "cherry", "garlic", "grape", "melon",
                        "leak", "kiwi", "mango", "mushroom",
                        "nut", "olive", "pea", "peanut",
                        "pear", "pepper", "pineapple", "pumpkin",
                        "potato"
                };

        showGameRules();
        String hiddenWord = makeWord(words);

        boolean inGame = true;
        while (inGame) {
            String userWord = getUserWord();
            boolean isCorrectAnswer = checkAnswer(hiddenWord, userWord);

            if (isCorrectAnswer) {
                userWon();
                inGame = false;
            } else
                hint(hiddenWord, userWord);

            if (!inGame) {
                inGame = suggestToRepeat();
                if (inGame)
                    hiddenWord = makeWord(words);
            }
        }
    }

    private static int getRandomNumber(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    private static void showGameRules() {
        System.out.println("Привет! Давай сыграем в игру - Угадай слово");
        System.out.println("Я загадываю слово, а вы пытаетесь его отгадать.");
        System.out.println("Все слова на английском!");
        System.out.println("Если слово не угадано, то я покажу буквы, которые стоят на своих местах.");
        System.out.println();
    }

    private static String makeWord(String[] words) {
        System.out.println("Слово загадано");
        final int randomIndex = getRandomNumber(words.length - 1);
        return words[randomIndex];
    }

    private static String getUserWord() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ваша догатка: ");
        return scanner.nextLine().toLowerCase();
    }

    private static boolean checkAnswer(String hiddenWord, String userWord) {
        return userWord.equals(hiddenWord);
    }

    private static void userWon() {
        switch (getRandomNumber(3)) {
            case 0 -> System.out.println("Да. Вы отгадали!");
            case 1 -> System.out.println("Все правильно!");
            case 2 -> System.out.println("Вы выиграли!");
            case 3 -> System.out.println("Да вы телепат!");
        }
        System.out.println();
    }

    private static void hint(String hiddenWord, String userWord) {
        int shorterWordLen = Math.min(hiddenWord.length(), userWord.length());

        for (int i = 0; i < shorterWordLen; i++) {
            char letter = hiddenWord.charAt(i) == userWord.charAt(i) ? userWord.charAt(i) : '#';
            System.out.print(letter);
        }
        confuseUser(shorterWordLen);
        System.out.println();
    }

    private static void confuseUser(int shorterWordLen) {
        for (int i = shorterWordLen; i < 15; i++) {
            System.out.print('#');
        }
    }

    private static boolean suggestToRepeat() {
        Scanner scanner = new Scanner(System.in);
        int userChoice = -1;

        System.out.println("Хотите сыграть снова?");

        do {
            System.out.println("0 - Хватит.");
            System.out.println("1 - Еще раз.");
            if (scanner.hasNextInt())
                userChoice = scanner.nextInt();
            else
                scanner.next();
        } while (userChoice < 0 || userChoice > 1);

        System.out.println();
        return userChoice == 1;
    }
}