package com.deviget.challenge.minesweeper.domain.game;

public abstract class Cell {
    private static final String NOT_REVELED_CELL = " ";
    private static final String FLAGGED_CELL = "f";

    private boolean flagged;
    private boolean reveled;
    private final boolean empty;

    private final int row;
    private final int column;

    Cell(int row, int column, boolean flagged, boolean reveled, boolean empty) {
        this.flagged = flagged;
        this.reveled = reveled;
        this.row = row;
        this.column = column;
        this.empty = empty;
    }

    Cell(int row, int column) {
        this(row, column, false, false, false);
    }

    Cell(int row, int column, boolean empty) {
        this(row, column, false, false, empty);
    }

    void reveal() throws MineExplosionException {
        if (!this.isFlagged()) {
            this.doReveal();
        }
    }

    void flag() {
        if (!this.isReveled()) {
            this.setFlagged(true);
        }
    }

    abstract boolean isMine();

    public String print() {
        if (this.isReveled()) {
            return doPrint();
        }

        if (this.isFlagged()) {
            return FLAGGED_CELL;
        }
        return NOT_REVELED_CELL;
    }

    boolean isFlagged() {
        return flagged;
    }

    protected void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    boolean isReveled() {
        return reveled;
    }

    boolean isEmpty() {
        return empty;
    }

    protected void setReveled(boolean reveled) {
        this.reveled = reveled;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    protected abstract String doPrint();

    protected abstract void doReveal() throws MineExplosionException;
}
