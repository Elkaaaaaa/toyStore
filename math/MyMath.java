package math;

import java.io.IOException;
import java.util.Collections;

import model.Toy;
import model.ToyStorage;

public class MyMath {

    public static double chance(Toy toy) {
        int sumChances = 0;
        for (Toy toys : ToyStorage.toyStorage) {
            sumChances = sumChances + toys.wheight;
        }
        double chance = Math.ceil(toy.wheight * 1000f / sumChances) / 10;
        return chance;
    }

    public static void getPrise(Double num) throws IOException {
        double value = 0;
        Collections.sort(ToyStorage.toyStorage);
        for (int i = 0; i < ToyStorage.toyStorage.size(); i++) {
            if ((num >= value) & (num <= chance(ToyStorage.toyStorage.get(i)) + value)) {
                ToyStorage.getToy(i + 1);
                break;
            } else {
                value = value + chance(ToyStorage.toyStorage.get(i));
            }
        }
    }
}
