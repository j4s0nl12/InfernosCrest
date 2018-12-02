package com.mygdx.game.managers;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.InfernosCrest;
import com.mygdx.game.screens.BaseScreen;
import com.mygdx.game.leveleditor.LevelEditorScreen;

public class ScreenManager {

    final InfernosCrest game;

    private Array<BaseScreen> screenList;

    public ScreenManager(final InfernosCrest gam){
        game = gam;

        screenList = new Array();

        //BaseScreen bs = new BaseScreen(gam);
        LevelEditorScreen le = new LevelEditorScreen(gam);

        screenList.add(le);
        game.setScreen(le);
    }
}
