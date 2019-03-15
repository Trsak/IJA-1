package ija.ija2018.homework1.board;

public class Disk {
    private boolean isWhite;
    private BoardField field;

    public Disk(boolean isWhite) {
        this.isWhite = isWhite;
        this.field = null;
    }

    public void setField(BoardField field) {
        this.field = field;
    }

    public boolean isWhite() {
        return this.isWhite;
    }

    public boolean move(Field moveTo) {
        int col = this.field.getCol();
        int row = this.field.getRow();
        int[] coordsTo = getCoords(moveTo);
        int colTo = coordsTo[0] - 1;
        int rowTo = coordsTo[1] - 1;
        Board board = this.field.getBoard();

        if ((col == colTo) || (row == rowTo)) {
            int value = 0;
            int valueTo = 0;
            boolean isHorizontally = true;

            if (col != colTo) {
                value = col;
                valueTo = colTo;
            } else if (row != rowTo) {
                value = row;
                valueTo = rowTo;
                isHorizontally = false;
            }

            int helper = value - valueTo;
            while (value - helper != value) {
                if (isHorizontally) {
                    if (!board.getField(value - helper + 1, row + 1).isEmpty()) {
                        return false;
                    }
                } else {
                    if (!board.getField(col + 1, value - helper + 1).isEmpty()) {
                        return false;
                    }
                }

                ++helper;
            }

            this.field.remove(this);
            board.getField(colTo + 1, rowTo + 1).put(this);
            return true;
        }

        return false;
    }

    private int[] getCoords(Field field) {
        Board board = this.field.getBoard();

        for (int i = 1; i <= board.getSize(); i++) {
            for (int x = 1; x <= board.getSize(); x++) {
                if (board.getField(i, x).equals(field)) {
                    int[] coords = new int[2];
                    coords[0] = i;
                    coords[1] = x;
                    return coords;
                }
            }
        }

        return null;
    }
}
