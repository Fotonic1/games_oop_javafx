package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException();
        }
        int size = source.getX() > dest.getX() ? source.getX() - dest.getX() : dest.getX() - source.getX();
        Cell[] steps = new Cell[size];
        int deltaX = source.getX() > dest.getX() ? -1 : 1;
        int deltaY = source.getY() > dest.getY() ? -1 : 1;
        for (int index = 1; index <= size; index++) {
            steps[index - 1] = Cell.findBy(source.getX() + (deltaX * index), source.getY() + (deltaY * index));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int x = source.getX() > dest.getX() ? source.getX() - dest.getX() : dest.getX() - source.getX();
        int y = source.getY() > dest.getY() ? source.getY() - dest.getY() : dest.getY() - source.getY();
        return x == y;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
