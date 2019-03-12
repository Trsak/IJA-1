package ija.ija2018.homework1.board;

public class Board {
    private int size;
    private BoardField[][] boardField;

    public Board(int size) {
        this.size = size;
        this.boardField = new BoardField[size][size];

        for (int x = 0; x < size; x++) {
            for (int i = 0; i < size; i++) {
                this.boardField[x][i] = new BoardField(x, i);
                this.boardField[x][i].setBoard(this);
            }
        }

        for (int x = 0; x < size; x++) {
            for (int i = 0; i < size; i++) {
                for (Field.Direction direction : Field.Direction.values()) {
                    int col = x;
                    int row = i;

                    switch (direction) {
                        case D:
                            row -= 1;
                            break;
                        case L:
                            col -= 1;
                            break;
                        case LD:
                            col -= 1;
                            row -= 1;
                            break;
                        case LU:
                            col -= 1;
                            row += 1;
                            break;
                        case R:
                            col += 1;
                            break;
                        case RD:
                            col += 1;
                            row -= 1;
                            break;
                        case RU:
                            col += 1;
                            row += 1;
                            break;
                        case U:
                            row += 1;
                            break;
                    }

                    if ((row >= 0 && row < size) && (col >= 0 && col < size)) {
                        this.boardField[x][i].addNextField(direction, this.boardField[col][row]);
                    }
                }
            }
        }
    }

    Field getField(int col, int row) {
        return boardField[col - 1][row - 1];
    }

    int getSize() {
        return this.size;
    }
}
