package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BishopBlackTest {

    @Test
    public void position() {
        Figure bishop = new BishopBlack(Cell.A3);
        Assert.assertThat(bishop.position(), is(Cell.A3));
    }

    @Test
    public void copy() {
        Figure bishop = new BishopBlack(Cell.A3);
        bishop = bishop.copy(Cell.D6);
        Assert.assertThat(bishop.position(), is(Cell.D6));
    }

    @Test
    public void way() throws ImpossibleMoveException {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] way = bishop.way(bishop.position(),Cell.G5);
        Cell[] expected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertArrayEquals(expected, way);
    }

    @Test(expected = IllegalStateException.class)
    public void wrongWay() throws ImpossibleMoveException {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] way = bishop.way(bishop.position(), Cell.G8);
    }
}