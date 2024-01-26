import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static List<Animals> animalsList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Меню:");
            System.out.println("1. Добавить новое животное");
            System.out.println("2. Список команд животного");
            System.out.println("3. Обучение новым командам");
            System.out.println("4. Вывести список животных по дате рождения");
            System.out.println("5. Вывести общее количество животных");
            System.out.println("0. Выход");

            System.out.print("Выберите пункт меню: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addNewAnimal();
                    break;
                case 2:
                    listCommands();
                    break;
                case 3:
                    trainAnimal();
                    break;
                case 4:
                    sortAnimalsByBirthDate();
                    break;
                case 5:
                    printTotalAnimalsCount();
                    break;
                case 0:
                    System.out.println("Выход");
                    break;
                default:
                    System.out.println("Неправильный выбор");
                    break;
            }

            System.out.println();
        } while (choice != 0);
    }

    public static void addNewAnimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        System.out.print("Введите дату рождения животного: ");
        String birthDate = scanner.nextLine();

        System.out.print("Выберите тип животного: 1 - Собака, 2 - Кошка, 3 - Хомяк, 4 - Лошадь, 5 - Верблюд, 6 - Осел: ");
        int type = scanner.nextInt();

        Animals animal;

        switch (type) {
            case 1:
                animal = new Dogs(name, birthDate, new String[]{});
                break;
            case 2:
                animal = new Cats(name, birthDate, new String[]{});
                break;
            case 3:
                animal = new Hamsters(name, birthDate, new String[]{});
                break;
            case 4:
                animal = new Horses(name, birthDate);
                break;
            case 5:
                animal = new Camels(name, birthDate);
                break;
            case 6:
                animal = new Donkeys(name, birthDate);
                break;
            default:
                System.out.println("Неправильный выбор");
                return;
        }

        animalsList.add(animal);
    }

    public static void listCommands() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        for (Animals animal : animalsList) {
            if (animal.getName().equals(name)) {
                if (animal instanceof Pets) {
                    String[] commands = ((Pets) animal).getCommands();
                    System.out.println("Список команд для животного " + name + ":");
                    for (String command : commands) {
                        System.out.println(command);
                    }
                } else {
                    System.out.println("У животного " + name + " нет команд");
                }
                return;
            }
        }

        System.out.println("Животное с именем " + name + " не найдено");
    }

    public static void trainAnimal() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();

        for (Animals animal : animalsList) {
            if (animal.getName().equals(name)) {
                if (animal instanceof Pets) {
                    System.out.print("Введите новую команду для животного " + name + ": ");
                    String newCommand = scanner.nextLine();

                    String[] oldCommands = ((Pets) animal).getCommands();
                    String[] newCommands = new String[oldCommands.length + 1];
                    System.arraycopy(oldCommands, 0, newCommands, 0, oldCommands.length);
                    newCommands[oldCommands.length] = newCommand;

                    ((Pets) animal).setCommands(newCommands);
                    System.out.println("Животное " + name + " успешно обучено новой команде");
                } else {
                    System.out.println("Нельзя обучить команде животное " + name);
                }
                return;
            }
        }

        System.out.println("Животное с именем " + name + " не найдено");
    }

    public static void sortAnimalsByBirthDate() {
        animalsList.sort((animal1, animal2) -> animal1.getBirthDate().compareTo(animal2.getBirthDate()));

        System.out.println("Список животных отсортирован по дате рождения:");

        for (Animals animal : animalsList) {
            System.out.println("Имя: " + animal.getName() + ", Дата рождения: " + animal.getBirthDate());
        }
    }

    public static void printTotalAnimalsCount() {
        System.out.println("Общее количество животных: " + animalsList.size());
    }
}