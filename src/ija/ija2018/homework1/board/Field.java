package ija.ija2018.homework1.board;

public interface Field {
    void addNextField(Field.Direction dirs, Field field);

    Field nextField(Field.Direction dirs);

    Disk get();

    boolean put(Disk disk);

    boolean remove(Disk disk);

    boolean isEmpty();

    int getCol();

    int getRow();

    Board getBoard();

    enum Direction {
        D, L, LD, LU, R, RD, RU, U
    }
}
