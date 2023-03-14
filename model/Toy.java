package model;

public class Toy implements Comparable<Toy> {
    String name;
    protected Integer id;
    int count;
    public int wheight;
    static protected Integer n = 1;

    public Toy(String name, int count, int wheight) {
        this.name = name;
        this.count = count;
        this.wheight = wheight;
        this.id = n;
        n++;
    }

    @Override
    public String toString() {
        String result = "\tНазвание игрушки: " + name + "\n\tКоличество: " + Integer.toString(count) + "\n\tШанс выпадения: "
                + Integer.toString(wheight) + "\n\tId: " + Integer.toString(id);
        return result;
    }

    @Override
    public int compareTo(Toy toy) {
        return this.wheight - toy.wheight;
    }

}
