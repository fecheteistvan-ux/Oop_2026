package oop.labor06.lab6_2;

import java.util.Random;

public class Matrix {
    private double[][] data;
    private int rows;
    private int columns;

    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.data = new double[rows][columns];
    }

    public Matrix(double[][] data) {
        this.rows = data.length;
        this.columns = data[0].length;
        this.data = new double[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            System.arraycopy(data[i], 0, this.data[i], 0, this.columns);
        }
    }

    public Matrix(Matrix other) {
        this(other.data);
    }

    public void fillRandom(double min, double max) {
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                data[i][j] = min + (max - min) * rand.nextDouble();
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.printf("%8.3f ", data[i][j]);
            }
            System.out.println();
        }
    }

    public static Matrix add(Matrix m1, Matrix m2) {
        if (m1.rows != m2.rows || m1.columns != m2.columns) {
            System.out.println("Mátrixok mérete nem egyezik!");
            return null;
        }
        Matrix result = new Matrix(m1.rows, m1.columns);
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m1.columns; j++) {
                result.data[i][j] = m1.data[i][j] + m2.data[i][j];
            }
        }
        return result;
    }

    public static Matrix multiply(Matrix m1, Matrix m2) {
        if (m1.columns != m2.rows) {
            System.out.println("A mátrixok nem szorozhatók össze!");
            return null;
        }
        Matrix result = new Matrix(m1.rows, m2.columns);
        for (int i = 0; i < m1.rows; i++) {
            for (int j = 0; j < m2.columns; j++) {
                for (int k = 0; k < m1.columns; k++) {
                    result.data[i][j] += m1.data[i][k] * m2.data[k][j];
                }
            }
        }
        return result;
    }

    public static Matrix transpose(Matrix m) {
        Matrix result = new Matrix(m.columns, m.rows);
        for (int i = 0; i < m.rows; i++) {
            for (int j = 0; j < m.columns; j++) {
                result.data[j][i] = m.data[i][j];
            }
        }
        return result;
    }
}