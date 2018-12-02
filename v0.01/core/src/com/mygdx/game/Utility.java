package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.gameobject.MyCamera;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utility {

    private static boolean isDebug = true;
   // private static boolean isDebug = false;

    private static int virtualWidth = 1920;
    private static int virtualHeight = 1080;

    private static ShapeRenderer sr = new ShapeRenderer();

    public static boolean getDebug(){
        return isDebug;
    }

    public static int getVirtualWidth(){
        return virtualWidth;
    }

    public static int getVirtualHeight(){
        return virtualHeight;
    }

    public static Vector2 getUnprojectAt(MyCamera cam, int x, int y, int z){
        Vector3 tmp = cam.unproject(new Vector3(x,y,z));
        return new Vector2(tmp.x, tmp.y);
    }

    public static void print(String tag, String msg){
        long t = System.currentTimeMillis();
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(t);
        SimpleDateFormat sdf = new SimpleDateFormat("ss");
        String curTime = sdf.format(cal.getTime());
        Gdx.app.log(tag, msg + "[" + curTime + "]");
    }

    public static ShapeRenderer getSR(){
        return sr;
    }
    public static void SRSetAuto(){
        sr.setAutoShapeType(true);
    }
    public static void setShapeTypeLine(){
        sr.set(ShapeRenderer.ShapeType.Line);
    }
    public static void setShapeTypeFill(){
        sr.set(ShapeRenderer.ShapeType.Filled);
    }
    public static void setSRColor(Color c){
        sr.setColor(c.r, c.g, c.b, c.a);
    }
}
