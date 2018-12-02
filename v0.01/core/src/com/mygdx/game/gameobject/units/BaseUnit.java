package com.mygdx.game.gameobject.units;

public class BaseUnit {

    private int hp;//Health Points, unit dies when this hits 0.
    private int str;//Strength, determines how much a unit's physical damage does.
    private int mag;//Magic, determines how much a unit's magical damage does.
    private int def;//Defence, determines how much physical damage a unit takes.
    private int spr;//Spirit, determines how much magical damage a unit takes.
    private int skl;//Skill, adds critical and accuracy.
    private int spd;//Speed, determines number of attacks (i.e. if unit speed is doubled the enemy, attack twice).
    private int luk;//Luck, increases unit's chance of critical and lower's enemy's chance to crit.

    public BaseUnit(){

    }

    public void render(float delta){

    }
}
