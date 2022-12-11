/* 2. Пусть дан список сотрудников:Иван Иванов Светлана Петрова Кристина Белова Анна Мусина Анна Крутова Иван Юрин
Петр Лыков Павел Чернов Петр Чернышов Мария Федорова Марина Светлова Мария Савина Мария Рыкова Марина Лугова
Анна Владимирова Иван Мечников Петр Петин Иван Ежов

Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности.
*/

import java.util.*;

public class TaskJava2 {
    public static void main(String[] args) {
        String[] inData = new String[]{"Иван Иванов",
                "Светлана Петрова",
                "Кристина Белова",
                "Анна Мусина",
                "Анна Крутова",
                "Иван Юрин",
                "Петр Лыков",
                "Павел Чернов",
                "Петр Чернышов",
                "Мария Федорова",
                "Марина Светлова",
                "Мария Савина",
                "Мария Рыкова",
                "Марина Лугова",
                "Анна Владимирова",
                "Иван Мечников",
                "Петр Петин",
                "Иван Ежов"};
        Map<Integer, String[]> humans = new HashMap<>();
        Map<String, Integer> humansAnalyze = new HashMap<>();
        Map<Integer, String[]> humansSorted = new LinkedHashMap<>();

        int index = 0;
        for (String name : inData) {
            String[] humanData;
            humanData = name.split(" ");
            humans.put(index, humanData);
            index++;
        }
        for (Integer id : humans.keySet()) {
            String[] humanData = humans.get(id);
            if (!humansAnalyze.containsKey(humanData[0])) {
                humansAnalyze.put(humanData[0], 1);
            } else {
                humansAnalyze.put(humanData[0], humansAnalyze.get(humanData[0]) + 1);
            }
        }

        Map<String, Integer> temp = mySortingDescent(humansAnalyze);

        int newId = 0;
        for (Map.Entry<String, Integer> t : temp.entrySet()) {
            for (Integer id : humans.keySet()) {
                if (humans.get(id)[0].equals(t.getKey())) {
                    humansSorted.put(newId, humans.get(id));
                    newId++;
                }
            }
        }

        for (String id : temp.keySet()) {
            System.out.printf("Имя %s повторяется %d раз(а) \n", id, (temp.get(id)));
        }

        for (Integer id : humansSorted.keySet()) {
            System.out.printf("Данные %d по популярности %s \n", id, Arrays.toString(humansSorted.get(id)));
        }
    }

    public static Map<String, Integer> mySortingDescent(Map<String, Integer> arg) {
        Map<String, Integer> out = new LinkedHashMap<>();
        ArrayList<Map.Entry<String, Integer>> temp = new ArrayList<>(arg.entrySet());
        temp.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (Map.Entry<String, Integer> t : temp) {
            out.put(t.getKey(), t.getValue());
        }
        return out;
    }
}
