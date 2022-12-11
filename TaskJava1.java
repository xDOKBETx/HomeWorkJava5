/*
1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TaskJava1 {
    public static void main(String[] args) {
        Map<String, ArrayList<Long>> PhoneBook = new HashMap<>(); //телефонная книга
        ArrayList<Long> phones = new ArrayList<>();
        phones.add(89359022784L);
        phones.add(89188748822L);
        phones.add(89189034651L);
        phones.add(89708044097L);
        PhoneBook.put("Вицин".toLowerCase(), phones);
        phones = new ArrayList<>();
        phones.add(89938186476L);
        phones.add(89568145454L);
        PhoneBook.put("Никулин".toLowerCase(), phones);
        phones = new ArrayList<>();
        phones.add(89444026168L);
        PhoneBook.put("Моргунов".toLowerCase(), phones);
        for (String name : PhoneBook.keySet()) {
            System.out.printf("За гражданином(кой) %s закреплены следующие телефонные номера %s \n", name, PhoneBook.get(name.toLowerCase()).toString());
        }
    }
}





