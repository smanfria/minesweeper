package com.deviget.challenge.minesweeper.domain;

public abstract class Cell {
    private static final String NOT_REVELED_CELL = " ";
    private static final String FLAGGED_CELL = "f";

    private boolean flagged;
    private boolean reveled;

    Cell(boolean flagged, boolean reveled) {
        this.flagged = flagged;
        this.reveled = reveled;
    }

    Cell() {
        this(false, false);
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

    String print() {
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

    protected void setReveled(boolean reveled) {
        this.reveled = reveled;
    }

    protected abstract String doPrint();

    protected abstract void doReveal() throws MineExplosionException;
}
