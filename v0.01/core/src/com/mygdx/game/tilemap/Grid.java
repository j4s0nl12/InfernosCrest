package com.mygdx.game.tilemap;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Utility;

public class Grid{

    private int rows;
    private int cols;
    private int gridSize;
    private Color gridColor;

    private boolean displayGrid;

    private Array<Array<Tile>> gridmap;//(col, row)

    public Grid(){
        this.displayGrid = true;
        this.gridColor = Color.WHITE;
    }

    public void render(Matrix4 camCombined, float delta){
        if(this.gridmap != null){
            if(this.displayGrid){
                Utility.setSRColor(this.gridColor);
                Utility.getSR().setProjectionMatrix(camCombined);
                Utility.getSR().begin();
                Utility.setShapeTypeLine();
                for(int c = 0; c <= this.cols; c++){
                    Utility.getSR().line(c*this.gridSize,0, c*this.gridSize,this.gridSize*this.cols);
                    for(int r = 0; r <= this.rows; r++){
                        Utility.getSR().line(0,r*this.gridSize, this.gridSize*this.rows,r*this.gridSize);
                    }
                }
                Utility.getSR().end();
            }
        }
    }

    public void createGrid(int numRows, int numCols){
        this.gridSize = 64;
        this.makeGrid(numRows, numCols);
    }

    public void createGrid(int numRows, int numCols, int size){
        this.gridSize = size;
        this.makeGrid(numRows, numCols);
    }

    private void makeGrid(int numRows, int numCols){
        this.cols = numCols;
        this.rows = numRows;
        this.gridmap = new Array();
        for(int c = 0; c < numCols; c++){
            Array<Tile> tmp = new Array();
            for(int r = 0; r < numRows; r++){
                tmp.add(new Tile(c,r,this.gridSize));
            }
            this.gridmap.add(tmp);
        }
    }

    /*TODO
    public void loadGrid(){

    }*/

    public Tile getTile(int col, int row){
        return this.gridmap.get(col).get(row);
    }

    public void toggleGrid(){
        this.displayGrid = !this.displayGrid;
    }
}
