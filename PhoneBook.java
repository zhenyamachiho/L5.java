import java.util.*;

public class PhoneBook {
    private final Map<String, List<String>> phoneBook = new HashMap<>();

    public void addContact(String name, String phoneNumber) {
        if (!phoneBook.containsKey(name)) {
            phoneBook.put(name, new ArrayList<>());
        }
        phoneBook.get(name).add(phoneNumber);
    }

    public void printPhoneBook() {
        phoneBook.entrySet().stream()
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparingInt(List::size)).reversed())
                .forEach(entry -> {
                    System.out.println("Имя: " + entry.getKey() + ", Телефоны: " + entry.getValue());
                });
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите имя:");
            String name = scanner.nextLine();

            System.out.println("Введите номер телефона:");
            String phoneNumber = scanner.nextLine();

            phoneBook.addContact(name, phoneNumber);

            System.out.println("Хотите добавить еще один контакт? (да/нет)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("нет")) {
                break;
            }
        }

        phoneBook.printPhoneBook();
    }
}
