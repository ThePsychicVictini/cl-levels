package com.azdevelopergamer.Levels;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class Levels {
    List<Object> levelList;
    public Levels(List<Integer> starts, List<Integer> ends, List<String> descs){
        levelList=new ArrayList<Object>();
        if(starts.size()==ends.size()&&starts.size()==descs.size()){
            for (int i = 0; i<starts.size(); i++){
                Level levelToBeAdded = new Level(starts.get(i),ends.get(i),descs.get(i));
                levelList.add(levelToBeAdded);
            }
        }
    }
    public Bundle generateBundleForFragment(Player player, boolean displayMax){
        Bundle toBeReturned = new Bundle();
        int levelMaxProgress;
        if(player.getCurrentLevel(levelList)!=levelList.size()+1) {
            toBeReturned.putInt("playerCurrentLevel", player.getCurrentLevel(levelList) + 1);
            levelMaxProgress= ((Level)(levelList.get(player.getCurrentLevel(levelList)))).end-((Level)(levelList.get(player.getCurrentLevel(levelList)))).start;
        } else {
            levelMaxProgress= ((Level)(levelList.get(player.getCurrentLevel(levelList)-2))).end-((Level)(levelList.get(player.getCurrentLevel(levelList)-2))).start;
            toBeReturned.putInt("playerCurrentLevel", player.getCurrentLevel(levelList)-1);

        }
        toBeReturned.putBoolean("displayMaxLevel",displayMax);
        toBeReturned.putInt("maxLevel", levelList.size());
        toBeReturned.putInt("playerLevelProgress", player.getLevelProgress(levelList));

        toBeReturned.putInt("levelMaxProgress",levelMaxProgress);
        return toBeReturned;
    }
}
