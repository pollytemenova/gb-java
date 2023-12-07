import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Notebook> notebooks = createNotebooks();
        System.out.println("Введите цифру, соответствующую необходимому критерию:\n" +
                "1 - ОЗУ\n" +
                "2 - Объем ЖД\n" +
                "3 - Операционная система\n" +
                "4 - Цвет\n" +
                "5 - Поиск");
        Scanner scanner = new Scanner(System.in);
        String option;
        Map<Integer, String> filter = new HashMap<>();
        do {
            option = scanner.nextLine();
            switch (option) {
                case "1" -> {
                    System.out.println("Введите желаемый объем ОЗУ");
                    scanner = new Scanner(System.in);
                    filter.put(1, scanner.nextLine());
                }
                case "2" -> {
                    System.out.println("Введите желаемый объем ЖД");
                    scanner = new Scanner(System.in);
                    filter.put(2, scanner.nextLine());
                }
                case "3" -> {
                    System.out.println("Введите желаемую операционную систему");
                    scanner = new Scanner(System.in);
                    filter.put(3, scanner.nextLine());
                }
                case "4" -> {
                    System.out.println("Введите желаемый цвет");
                    scanner = new Scanner(System.in);
                    filter.put(4, scanner.nextLine());
                }
            }
        } while (!option.equals("5"));
        System.out.println("filter = " + filter);
        List<Notebook> found = notebooks.stream().filter(notebook -> {
                    String ramFilter = filter.get(1);
                    if (ramFilter != null) {
                        int ram = Integer.parseInt(ramFilter);
                        return notebook.ram >= ram;
                    } else return true;
                })
                .filter(notebook -> {
                            String hddFilter = filter.get(2);
                            if (hddFilter != null) {
                                int hdd = Integer.parseInt(hddFilter);
                                return notebook.hdd >= hdd;
                            } else return true;
                        }
                )
                .filter(notebook -> {
                            String osFilter = filter.get(3);
                            if (osFilter != null) {
                                return notebook.OS.equals(osFilter);
                            } else return true;
                        }
                )
                .filter(notebook -> {
                            String colorFilter = filter.get(4);
                            if (colorFilter != null) {
                                return notebook.color.equals(colorFilter);
                            } else return true;
                        }
                )
                .toList();
        System.out.println("found = " + found);
    }

    private static List<Notebook> createNotebooks() {
        List<Notebook> notebooks = new ArrayList<>();

        Notebook note1 = new Notebook();
        note1.ram = 8;
        note1.hdd = 100;
        note1.OS = "windows";
        note1.color = "black";
        notebooks.add(note1);

        Notebook note2 = new Notebook();
        note2.ram = 16;
        note2.hdd = 200;
        note2.OS = "macos";
        note2.color = "white";
        notebooks.add(note2);

        Notebook note3 = new Notebook();
        note3.ram = 16;
        note3.hdd = 500;
        note3.OS = "windows";
        note3.color = "black";
        notebooks.add(note3);

        Notebook note4 = new Notebook();
        note4.ram = 32;
        note4.hdd = 1000;
        note4.OS = "windows";
        note4.color = "grey";
        notebooks.add(note4);

        return notebooks;
    }
}
