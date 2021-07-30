import iterator.CustomArrayIterator;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Задание 1:
        Integer[][] arr = new Integer[][] { {0, 1},
                                            {2},
                                            {},
                                            {},
                                            {3, 4, 5},
                                            {} };

        CustomArrayIterator<Integer> iterator = new CustomArrayIterator<>(arr);

        while (iterator.hasNext())
            System.out.print(iterator.next());

        System.out.println();

        // Задание 2:
        Collection<String> strings = Arrays.asList("", "Vlad", "123", null);
        Collection<Object> objects = Arrays.asList(new Object(), "Vlad", null, "");

        if (haveDuplicate(strings, objects))
            System.out.println("В коллекциях есть дубликаты");
        else
            System.out.println("Дубликатов нет");

        int count = countDuplicates(strings, objects);
        System.out.println("Количество дубликатов в коллекциях: " + count);

        HashSet<Object> duplicates = searchDuplicates(strings, objects);
        System.out.println("Дубликаты: " + duplicates);
    }

    /**
     * Метод проверяет 2 коллекции на наличие дубликатов
     * @return Возвращает true, если есть одинаковые элементы в обеих коллекциях
     */
    public static <T> boolean haveDuplicate(Collection<? extends T> collection1, Collection<? extends T> collection2) {
        if (collection1.isEmpty() || collection2.isEmpty())
            return false;

        for (T item : collection2) {
            if (collection1.contains(item))
                return true;
        }

        return false;
    }

    /**
     * Метод находит дублирующиеся элементы в двух коллекциях и возвращаает их
     * @return Возвращает набор дублирующихся элементов. Если дубликатов нет, возвращается пустой набор
     */
    public static <T> HashSet<T> searchDuplicates(Collection<? extends T> collection1, Collection<? extends T> collection2) {
        HashSet<T> duplicates = new HashSet<>();

        for (T item : collection2) {
            if (collection1.contains(item))
                duplicates.add(item);
        }

        return duplicates;
    }

    /**
     * Метод определяет количество дубликатов в 2-х коллекциях
     * @return Возвращает количество дублирующихся элементов в обеих коллекциях
     */
    public static <T> int countDuplicates(Collection<? extends T> collection1, Collection<? extends T> collection2) {
        LinkedHashSet<T> set = new LinkedHashSet<>();
        set.addAll(collection1);
        set.addAll(collection2);

        return collection1.size() + collection2.size() - set.size();
    }
}
