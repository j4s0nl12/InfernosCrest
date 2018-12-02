package com.mygdx.game.screens;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.InfernosCrest;
import com.mygdx.game.Utility;

public class BaseScreen extends InputAdapter implements Screen {

    public final InfernosCrest game;
    final String TAG = this.getClass().getSimpleName();

    private InputMultiplexer iM;
    private Stage stage;

    private Color bgColor;

    public BaseScreen(final InfernosCrest gam){
        this.game = gam;

        this.bgColor = Color.NAVY;

        this.iM = new InputMultiplexer();
        this.stage = new Stage(game.getViewport());
    }

    @Override
    public void show(){
        this.iM.addProcessor(this.stage);
        this.iM.addProcessor(this);
        Gdx.input.setInputProcessor(this.iM);
    }

    @Override
    public void render(float delta){
        //TEMPORARY
        if(Gdx.app.getType().equals(Application.ApplicationType.Desktop) && Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            Gdx.app.exit();
        }
        //^TEMPORARY

        Gdx.graphics.setTitle("[FPS:" + Gdx.graphics.getFramesPerSecond() + "] Inferno's Crest");

        Gdx.gl.glClearColor(this.bgColor.r, this.bgColor.g, this.bgColor.b, this.bgColor.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.getGameCamera().update();

        //TEMPORARY
        Utility.setSRColor(Color.BLACK);
        //Utility.getSR().setProjectionMatrix(game.getGameCamera().combined);
        Utility.getSR().begin();
        Utility.setShapeTypeLine();
        Utility.getSR().rect(-1,-1,Utility.getVirtualWidth()+1,Utility.getVirtualHeight()+1);
        Utility.getSR().end();
        //^TEMPORARY
    }

    @Override
    public void resize(int width, int height) {
        this.game.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide(){
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button){
        if(Utility.getDebug()){
            Vector2 tmp = Utility.getUnprojectAt(game.getGameCamera(), screenX, screenY, 0);
            Gdx.app.log(this.TAG, "TouchDown at (" + tmp.x + "," + tmp.y + ").");
        }
        return true;
    }
}
