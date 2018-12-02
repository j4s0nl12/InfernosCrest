package com.mygdx.game.gameobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class MyCamera extends OrthographicCamera{

    private int upKey = Input.Keys.W;
    private int downKey = Input.Keys.S;
    private int leftKey = Input.Keys.A;
    private int rightKey = Input.Keys.D;
    private int zoomIn = Input.Keys.E;
    private int zoomOut = Input.Keys.Q;

    private float camSpd = 0.2f;
    private float zoomSpd = 0.0005f;

    private float zoomMin = .5f;
    private float zoomMax = 1.25f;

    public MyCamera(){
    }

    @Override
    public void update(){
        Vector3 vel = new Vector3();
        if(Gdx.input.isKeyPressed(upKey)){
            vel.add(0,1,0);
        }
        else if(Gdx.input.isKeyPressed(downKey)){
            vel.add(0,-1,0);
        }
        if(Gdx.input.isKeyPressed(leftKey)){
            vel.add(-1,0,0);
        }
        else if(Gdx.input.isKeyPressed(rightKey)){
            vel.add(1,0,0);
        }

        this.position.add(vel.nor().scl(camSpd*Gdx.graphics.getFramesPerSecond()));

        if(Gdx.input.isKeyPressed(zoomIn)) {
            if(this.zoom > zoomMin) {
                this.zoom -= zoomSpd * Gdx.graphics.getFramesPerSecond();
                if(this.zoom < zoomMin)
                    this.zoom = zoomMin;
            }
        }
        else if(Gdx.input.isKeyPressed(zoomOut)){
            if(this.zoom < zoomMax) {
                this.zoom += zoomSpd * Gdx.graphics.getFramesPerSecond();
                if(this.zoom > zoomMax)
                    this.zoom = zoomMax;
            }
        }

        super.update();
    }

    public void resetPos() {
        this.position.set(new Vector3());
    }
}
