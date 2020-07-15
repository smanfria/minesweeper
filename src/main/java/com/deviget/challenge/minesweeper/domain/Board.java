package com.deviget.challenge.minesweeper.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Board {
    private final int rows;
    private final int columns;
    private final int mines;
    private final int cellsCount;
    private final Cell[][] cells;
    private int reveledCount;

    private Board(int rows, int columns, int mines) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        this.cells = new Cell[rows][columns];
        this.reveledCount = 0;
        this.cellsCount = rows * columns;
    }

    static Board create(int rows, int columns, int mines) {
        Validator.validateGraterThanZero(rows, "rows");
        Validator.validateGraterThanZero(columns, "columns");
        Validator.validateGraterThanZero(mines, "mines");

        Board board = new Board(rows, columns, mines);
        board.init();

        return board;
    }

    public boolean isCompleted() {
        return cellsCount - mines == reveledCount;
    }

    void print() {
        for (Cell[] row : cells) {
            System.out.println(Arrays.toString(row));
        }
    }

    int getRows() {
        return rows;
    }

    int getColumns() {
        return columns;
    }

    int getMines() {
        return mines;
    }

    void reveal(int row, int column) throws MineExplosionException {
        isValidCell(row, column);

        boolean[][] visited = new boolean[cells.length][cells[0].length];

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{row, column});

        while (!queue.isEmpty()) {
            final Integer[] cellIdx = queue.poll();
            final Integer currentRow = cellIdx[0];
            final Integer currentColumn = cellIdx[1];

            if (!visited[currentRow][currentColumn]) {
                visited[currentRow][currentColumn] = true;
                revealCell(currentRow, currentColumn);
                List<Integer[]> unvisitedNotMineNeighbors = getUnvisitedNotMineNeighbors(currentRow, currentColumn, cells, visited);
                queue.addAll(unvisitedNotMineNeighbors);
            }
        }
    }

    void flag(int row, int column) {
        isValidCell(row, column);
        Cell cell = cells[row][column];
        cell.flag();
    }

    private void revealCell(Integer row, Integer column) throws MineExplosionException {
        Cell cell = cells[row][column];
        reveledCount = reveledCount + 1;
        cell.reveal();
    }

    private List<Integer[]> getUnvisitedNotMineNeighbors(Integer currentRow, Integer currentColumn, Cell[][] cells,
                                                         boolean[][] visited) {
        final List<Integer[]> neighbors = this.getNeighbors(currentRow, currentColumn, cells);
        return neighbors.stream().filter(cell -> {
            final Integer row = cell[0];
            final Integer column = cell[1];
            final Cell currentCell = cells[row][column];
            return !visited[row][column] && !currentCell.isMine() && !currentCell.isReveled() && !currentCell.isFlagged();
        }).collect(Collectors.toList());
    }

    private void init() {
        this.initMines();
        this.initCells();
    }

    private void initCells() {
        boolean[][] visited = new boolean[cells.length][cells[0].length];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (!visited[row][column]) {
                    initCells(row, column, cells, visited);
                }
            }
        }
    }

    private void initCells(int row, int column, Cell[][] cells, boolean[][] visited) {
        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[]{row, column});

        while (!queue.isEmpty()) {
            final Integer[] cell = queue.poll();
            final Integer currentRow = cell[0];
            final Integer currentColumn = cell[1];

            if (!visited[currentRow][currentColumn]) {
                visited[currentRow][currentColumn] = true;
                final Cell currentCell = cells[currentRow][currentColumn];
                if (currentCell == null || !currentCell.isMine()) {
                    int totalMines = getNeighborsMines(currentRow, currentColumn, cells);
                    cells[currentRow][currentColumn] = new NumCell(totalMines);
                    List<Integer[]> unvisitedNeighbors = getUnvisitedNeighbors(currentRow, currentColumn, cells, visited);
                    queue.addAll(unvisitedNeighbors);
                }
            }
        }
    }

    private int getNeighborsMines(Integer currentRow, Integer currentColumn, Cell[][] cells) {
        final List<Integer[]> neighbors = this.getNeighbors(currentRow, currentColumn, cells);
        return neighbors.stream().filter(cell -> cells[cell[0]][cell[1]] != null && cells[cell[0]][cell[1]].isMine()).mapToInt(i -> 1).sum();
    }

    private List<Integer[]> getUnvisitedNeighbors(Integer currentRow, Integer currentColumn, Cell[][] cells, boolean[][] visited) {
        final List<Integer[]> neighbors = this.getNeighbors(currentRow, currentColumn, cells);
        return neighbors.stream().filter(cell -> !visited[cell[0]][cell[1]]).collect(Collectors.toList());
    }

    private List<Integer[]> getNeighbors(int row, int column, Cell[][] cells) {
        List<Integer[]> neighbors = new ArrayList<>();

        for (int rowIdx = -1; rowIdx <= 1; rowIdx++) {
            for (int columnIdx = -1; columnIdx <= 1; columnIdx++) {
                final int currentRow = row + rowIdx;
                final int currentColumn = column + columnIdx;
                if (currentRow >= 0 && currentRow < rows &&
                        currentColumn >= 0 && currentColumn < columns &&
                        (currentRow != row || currentColumn != column)) {
                    neighbors.add(new Integer[]{currentRow, currentColumn});
                }
            }
        }
        return neighbors;
    }

    private void initMines() {
        Random r = new Random();
        for (int i = 0; i < mines; i++) {
            int row = r.nextInt(rows);
            int column = r.nextInt(columns);
            cells[row][column] = new MineCell();
        }
    }

    private void isValidCell(int row, int column) {
        Validator.validate(row, rows);
        Validator.validate(column, columns);
    }
}
