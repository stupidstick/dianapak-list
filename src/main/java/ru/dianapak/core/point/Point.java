package ru.dianapak.core.point;

import java.io.Serializable;

public record Point(int x, int y) implements Comparable<Point>, Serializable {

    @Override
    public int compareTo(Point point) {
        return this.x * this.x + this.y * this.y - point.x * point.x - point.y * point.y;
    }

    @Override
    public String toString() {
        return "x=" + x + ", y=" + y;
    }
}
