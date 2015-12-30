package com.azdevelopergamer.Levels;

import java.util.List;

/**
 * Created by Tfel on 12/29/2015.
 */
public class Player {
    public int rawlevel;
    public Player(int level){
        this.rawlevel=level;
    }
    public int getCurrentLevel(List<Object> levelList){
        for (Object o:levelList
             ) {
            Level level = (Level)o;
            if(level.start<=rawlevel&&rawlevel<=level.end){
                return levelList.indexOf(o);
            }
        }
        return levelList.size()+1;
    }
    public int getLevelProgress(List<Object> levelList){
        if(getCurrentLevel(levelList)!=levelList.size()+1){
            return rawlevel-((Level)levelList.get(getCurrentLevel(levelList))).start;
        }else{
            return ((Level)levelList.get(levelList.size()-1)).end-((Level)levelList.get(levelList.size()-1)).start;
        }
    }
}
