package viewer;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import math.MyMath;
import model.ToyStorage;

public class ui {
    static Random random = new Random();

    public static void mainMenu() throws IOException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("""
                    Выберете список действий:
                    1. Испытать удачу
                    2. Показать список игрушек
                    3. Добавить игрушку
                    0. Выход
                    --->
                    """);
            if (scanner.hasNextInt()) {
                int key = scanner.nextInt();
                if (key == 0) {
                    break;
                } else if (key == 1) {
                    if (ToyStorage.toyStorage.size() != 0) {
                        Double num = random.nextDouble(0, 100);
                        MyMath.getPrise(num);
                    } else {
                        System.out.println("Игрушек нет");
                    }
                } else if (key == 2) {
                    if (ToyStorage.toyStorage.size() != 0) {
                        ToyStorage.print();
                        System.out.print("""
                                Выберете список действий:
                                1. Редактировать вес игрушки
                                2. Удалить игрушку
                                3. Редактировать количество
                                0. Выход
                                --->
                                """);
                        if (scanner.hasNextInt()) {
                            key = scanner.nextInt();
                            if (key == 0) {

                            } else if (key == 1) {
                                System.out.println("Выберете игрушку: ");
                                if (scanner.hasNextInt()) {
                                    int index = scanner.nextInt();
                                    if ((index <= ToyStorage.toyStorage.size()) & index > 0) {
                                        System.out.println("Введите новый вес игрушки: ");
                                        if (scanner.hasNextInt()) {
                                            int wheight = scanner.nextInt();
                                            ToyStorage.wheightEdit(index, wheight);
                                            System.out.println("\nВес успешно изменен!\n");
                                        } else {
                                            System.out.println("\nНекорректные данные\n");
                                        }
                                    } else {
                                        System.out.println("\nТакой игрушки нет\n");
                                    }
                                } else {
                                    System.out.println("\nНекорректные данные\n");
                                }
                            } else if (key == 2) {
                                System.out.println("Выберете игрушку: ");
                                if (scanner.hasNextInt()) {
                                    int index = scanner.nextInt();
                                    if ((index <= ToyStorage.toyStorage.size()) & index > 0) {
                                        System.out.println("\nИгрушка успешно удалена\n");
                                        ToyStorage.del(index);
                                    } else {
                                        System.out.println("\nТакой игрушки нет\n");
                                    }
                                } else {
                                    System.out.println("\nНекорректные данные\n");
                                }
                            } else if (key == 3) {
                                System.out.println("Выберете игрушку: ");
                                if (scanner.hasNextInt()) {
                                    int index = scanner.nextInt();
                                    if ((index <= ToyStorage.toyStorage.size()) & index > 0) {
                                        System.out.println("Введите новое количество: ");
                                        if (scanner.hasNextInt()) {
                                            int count = scanner.nextInt();
                                            ToyStorage.countEdit(index, count);
                                        }
                                    } else {
                                        System.out.println("\nТакой игрушки нет\n");
                                    }
                                } else {
                                    System.out.println("\nНекорректные данные\n");
                                }
                            }
                        } else {
                            System.out.println("\nНекорректные данные\n");
                        }
                    } else {
                        System.out.println("\nИгрушек нет\n");
                    }
                } else if (key == 3) {
                    System.out.println("Введите имя игрушки(без пробелов): ");
                    String name = scanner.next();
                    System.out.println("Введите количество: ");
                    if (scanner.hasNextInt()) {
                        int count = scanner.nextInt();
                        System.out.println("Введите вес игрушки: ");
                        if (scanner.hasNextInt()) {
                            int wheight = scanner.nextInt();
                            ToyStorage.add(name, count, wheight);
                        } else {
                            System.out.println("Некорректные данные\n");
                        }
                    } else {
                        System.out.println("Некорректные данные\n");
                    }
                }
            } else {
                System.out.println("Некорректные данные\n");
            }
        }
    }
}
