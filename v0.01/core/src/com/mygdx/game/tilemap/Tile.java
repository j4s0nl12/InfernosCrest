package com.mygdx.game.tilemap;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.gameobject.units.BaseUnit;

public class Tile {

    //Bottom left coordinate
    private int col;
    private int row;
    private int size;
    private BaseUnit unit;
    //private 'Image' oriTileImg;
    //private 'Image' curTileImg;
    private boolean isPassable;

    public Tile(int c, int r, int size){
        this.col = c;
        this.row = r;
        this.size = size;
        this.unit = null;
        this.isPassable = true;
    }

    public void render(float delta){
        /*if(this.curTileImg != null){
            this.curTileImg.render(delta);
        }*/

        if(this.unit != null){
            this.unit.render(delta);
        }
    }

    public void setUnit(BaseUnit u){
        this.unit = u;
    }

    public int getCol(){
        return this.col;
    }

    public int getRow(){
        return this.row;
    }

    public int getPosX(){
        return this.row * this.size;
    }

    public int getPosY(){
        return this.col * this.size;
    }

    public Vector2 getPos(){
        return new Vector2(this.getPosX(), this.getPosY());
    }

    public Vector2 getCenter(){
        return getPos().add(this.size/2,this.size/2);
    }

    public BaseUnit getUnit(){
        return this.unit;
    }

    public boolean getIsPassable(){
        return this.isPassable;
    }

    public void setIsPassable(boolean isPassable){
        this.isPassable = isPassable;
    }
}
