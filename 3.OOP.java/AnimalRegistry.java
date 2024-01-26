// Пример использования

import java.util.Arrays;

public class AnimalRegistry {
    public static void main(String[] args) {
        Dogs dog = new Dogs("Бобик", "01.01.2010", new String[] {"Сидеть", "Лежать"});
        Cats cat = new Cats("Мурзик", "01.02.2012", new String[] {"Присесть", "Крутиться"});
        
        System.out.println("Имя собаки: " + dog.getName());
        System.out.println("Дата рождения собаки: " + dog.getBirthDate());
        System.out.println("Команды собаки: " + Arrays.toString(dog.getCommands()));
        
        System.out.println("Имя кошки: " + cat.getName());
        System.out.println("Дата рождения кошки: " + cat.getBirthDate());
        System.out.println("Команды кошки: " + Arrays.toString(cat.getCommands()));
    }
}