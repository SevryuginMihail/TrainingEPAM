package Sevryugin;

import java.util.*;

import static java.lang.Math.random;

public class Service {
    public static void main(String[] args) {
        Service service = new Service();
        Human humans[] = service.task0(service);
        // 1.заполнение ArrayList этими объектами
        ArrayList<Human> arrayList = new ArrayList<>();
        arrayList.addAll(Arrays.asList(humans));
        // 2. Найти дубли в коллекции и вывести их в консоль
        HashMap<Human, Integer> hm1 = new HashMap<>();
        for (Human human : arrayList) {
            hm1.put(human, hm1.get(human) == null ? 1 : hm1.get(human) + 1);
        }
        System.out.println("2.Вывод дублей в консоль");
        for (Human human : arrayList) {
            if ((hm1.get(human) == 1)) {
                hm1.remove(human);
            } else {
                System.out.println(human);
            }
        }
        System.out.println("3.Удаление дублей из коллекции");
        for (int i = 0; i < arrayList.size(); i++) {
            if (hm1.get(arrayList.get(i)) != null) {
                arrayList.remove(i);
                hm1.remove(arrayList.get(i));
            }
        }
        for (int i = 0; i < arrayList.size(); i++)
            System.out.println(arrayList.get(i));

        service.task4(arrayList);
        service.task5(arrayList);
        service.task6(arrayList);
        service.task7_8();
        HashMap<String, Integer> hashMap9 = service.task9();
        service.task10(hashMap9);
        service.task11();
    }
    public Human[] task0(Service service){
        Human humans[] = new Human[10];
        for (int i = 0; i < humans.length; i++) {
            humans[i] = service.createHuman();
        }
        // создание дублей
        humans[0] = humans[1];
        humans[2] = humans[3];
        humans[4] = humans[5];
        System.out.println("0.Вывод сгенерированного массива в консоль");
        for (Human human : humans) {
            System.out.println(human);
        }
        return humans;
    }

    public void task4(ArrayList<Human> arrayList) {
        System.out.println("4.Сортировка людей по ФИО");
        Collections.sort(arrayList, new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getFio().toString().compareTo(o2.getFio().toString());
            }
        });
        for (Human human : arrayList) {
            System.out.println(human);
        }
    }

    public void task5(ArrayList<Human> arrayList) {
        System.out.println("5.Сортировка людей по возрасту");
        Collections.sort(arrayList, new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        for (Human human : arrayList) {
            System.out.println(human);
        }
    }

    public void task6(ArrayList<Human> arrayList) {
        System.out.println("6.Лексикографическая сортировка полного адреса");
        Collections.sort(arrayList, new Comparator<Human>() {
            @Override
            public int compare(Human o1, Human o2) {
                String address1 = o1.getAddress().getTown() + o1.getAddress().getStreet() + o1.getAddress().getHouse() + o1.getAddress().getFlat();
                String address2 = o2.getAddress().getTown() + o2.getAddress().getStreet() + o2.getAddress().getHouse() + o2.getAddress().getFlat();
                return address1.compareTo(address2);
            }
        });
        for (Human human : arrayList) {
            System.out.println(human);
        }
    }

    public void task7_8() {
        System.out.println("7,8.Приветствие");
        User admin = new User("Вася", Rule.ADMIN);
        User moderator = new User("Петя", Rule.MODERATOR);
        User user = new User("Коля", Rule.USER);
        hello(admin);
        hello(moderator);
        hello(user);
    }

    public HashMap<String, Integer> task9() {
        System.out.println("9.Сортировка HashMap по ключу");
        HashMap<String, Integer> hashMap9 = new HashMap<>();
        ArrayList<String> keyList = new ArrayList<>();
        keyList.add("Три");
        keyList.add("Три");
        keyList.add("Два");
        keyList.add("Один");
        keyList.add("Два");
        keyList.add("Три");
        for (String string : keyList) {
            hashMap9.put(string, hashMap9.get(string) == null ? 1 : hashMap9.get(string) + 1);
        }
        Map<String, Integer> treeMap = new TreeMap<>(hashMap9);
        System.out.println(treeMap);
        return hashMap9;
    }

    public void task10(HashMap<String, Integer> hashMap) {
        System.out.println("10.Сортировка HashMap по значению");
        hashMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue())
                .forEach(System.out::println);
    }

    public void task11() {
        System.out.println("11.Вывод значения и индекса LinkedList");
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            linkedList.add((int) (random() * 100));
        for (Integer integer : linkedList) {
            System.out.println(linkedList.indexOf(integer) + " " + integer);
        }
    }

    /**
     * Метод создает уникальный объект класса Human
     *
     * @return
     */
    public Human createHuman() {
        String fioRandom[] = {"Клювин Василий Олегович", "Крылов Петр Бенедиктович", "Романов Кирилл Федорович",
                "Будько Алексей Васильевич", "Петренко Роман Ништяков", "Тихон Асклепий Валаамов", "Курочка Настасья Петровна"};
        Integer ageRandom = 1 + (int) (random() * 100);
        String townRandom[] = {"Москва", "Челябинск", "Северодвинск", "Одесса", "Екатеринбург", "Новосибирск", "Караганда"};
        String streetRandom[] = {"Арбат", "Фонтанка", "Центральная", "Молодежная", "Школьная", "Лесная", "Садовая", "Безымянная"};
        Integer houseRandom = 1 + (int) (random() * 1000);
        Integer flat = 1 + (int) (random() * 210);
        Human human = new Human(fioRandom[(int) (random() * fioRandom.length)], ageRandom, townRandom[(int) (random() * townRandom.length)],
                streetRandom[(int) (random() * streetRandom.length)], houseRandom, flat);
        return human;
    }

    /**
     * Метод выводит в консоль строку с приветствием
     *
     * @param user - пользователь с которым здороваются
     */
    public static void hello(User user) {
        HashMap<Rule, String> description = new HashMap<>();
        description.put(Rule.ADMIN, "администратор");
        description.put(Rule.MODERATOR, "модератор");
        description.put(Rule.USER, "пользователь");
        System.out.println("Приветствуем " + user.getFio() + " с ролью " + description.get(user.getRule()));
    }
}
