package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;

public class ToyStorage {
    public static ArrayList<Toy> toyStorage = new ArrayList<>();

    public static void add(String name, int count, int chance) {
        toyStorage.add(new Toy(name, count, chance));
    }

    public static void getToy(int index) throws IOException {
        if (!Files.exists(Path.of("MyWinnings.txt"))) {
            Files.createFile(Path.of("MyWinnings.txt"));
        }
        String sting = Files.readString(Path.of("MyWinnings.txt"));
        Files.writeString(Path.of("MyWinnings.txt"), sting + toyStorage.get(index - 1).name + ": " + new Date() + "\n");
        toyStorage.get(index - 1).count -= 1;
        if (toyStorage.get(index - 1).count == 0) {
            del(index);
        }
    }

    public static void countEdit(int index, int newCount) {
        toyStorage.get(index - 1).count = newCount;
    }

    public static void wheightEdit(int index, int newWeight) {
        toyStorage.get(index - 1).wheight = newWeight;
    }

    public static void del(int index) {
        toyStorage.remove(index - 1);
    }

    public static void print() {
        for (Toy toy : toyStorage) {
            System.out.println(toyStorage.indexOf(toy) + 1 + ". \n" + toy);
        }
    }
}
