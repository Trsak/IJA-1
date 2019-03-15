package ija.ija2018.homework1.board;

import java.util.EnumMap;

public class BoardField implements Field {
    private int col;
    private int row;
    private EnumMap<Field.Direction, Field> nextFieldsMap;
    private Disk disk;
    private Board board;

    public BoardField(int col, int row) {
        this.col = col;
        this.row = row;
        this.disk = null;
        this.board = null;
        this.nextFieldsMap = new EnumMap<>(Field.Direction.class);
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return this.board;
    }

    int getCol() {
        return this.col;
    }

    int getRow() {
        return this.row;
    }

    public void addNextField(Field.Direction dirs, Field field) {
        this.nextFieldsMap.put(dirs, field);
    }

    public Field nextField(Field.Direction dirs) {
        return this.nextFieldsMap.get(dirs);
    }

    public boolean put(Disk disk) {
        if (this.disk == null) {
            disk.setField(this);
            this.disk = disk;
            return true;
        }

        return false;
    }

    public boolean remove(Disk disk) {
        if (this.disk == null || this.disk != disk) {
            return false;
        }

        this.disk = null;
        return true;
    }

    public Disk get() {
        return this.disk;
    }

    public boolean isEmpty() {
        return this.disk == null;
    }
}
