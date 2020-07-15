package com.deviget.challenge.minesweeper.domain;

public abstract class Cell {
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

    abstract String print();

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

    protected abstract void doReveal() throws MineExplosionException;
}
