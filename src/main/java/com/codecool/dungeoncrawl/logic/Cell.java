package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actors.Actor;
import com.codecool.dungeoncrawl.logic.items.Item;

public class Cell implements Drawable {
    private CellType type;
    private String tileName;
    private char symbol = (char) -1;
    private Actor actor;
    private Item item;
    private final GameMap gameMap;
    private final int x, y;

    Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
        if (symbol == (char) -1) {
            symbol = type.getSymbol();
        }
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Actor getActor() {
        return actor;
    }

    public Item getItem() {
        return item;
    }

    public Cell getNeighbor(int dx, int dy) {
        return gameMap.getCell(x + dx, y + dy);
    }

    public void setTile(String tileName, char symbol) {
        if(this.tileName==null) {
            this.tileName = tileName;
            this.symbol = symbol;
        }
    }

    @Override
    public String getTileName() {
        if (tileName != null) {
            return tileName;
        }
        return type.getTileName();
    }

    @Override
    public char getSymbol() {
        if (symbol != (char) -1) {
            return symbol;
        }
        return type.getSymbol();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
