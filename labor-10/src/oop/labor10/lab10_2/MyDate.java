package oop.labor10.lab10_2;

public class MyDate implements Comparable<MyDate> {
    private int year, month, day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public int compareTo(MyDate other) {
        if (this.year != other.year) return this.year - other.year;
        if (this.month != other.month) return this.month - other.month;
        return this.day - other.day;
    }

    @Override
    public String toString() {
        return String.format("%04d.%02d.%02d", year, month, day);
    }


    public int getYear() { return year; }
}