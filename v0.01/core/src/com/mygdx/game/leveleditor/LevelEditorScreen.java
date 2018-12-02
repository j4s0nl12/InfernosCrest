package com.mygdx.game.leveleditor;

import com.mygdx.game.InfernosCrest;
import com.mygdx.game.screens.BaseScreen;
import com.mygdx.game.tilemap.Grid;

public class LevelEditorScreen extends BaseScreen {

    private Grid grid;

    public LevelEditorScreen(InfernosCrest gam) {
        super(gam);
        this.grid = new Grid();
        this.grid.createGrid(20,20);
    }

    @Override
    public void render(float delta){
        super.render(delta);
        this.grid.render(game.getGameCamera().combined, delta);
    }
}
