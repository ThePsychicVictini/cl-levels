package com.azdevelopergamer.Levels;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class CurrentLevelDisplay extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.current_level_display, container, false);
    }
    public void updateView(Bundle arguments){
        int playerCurrentLevel = arguments.getInt("playerCurrentLevel",1);
        boolean displayMaxLevel = arguments.getBoolean("displayMaxLevel", true);
        TextView textView = (TextView) getView().findViewById(R.id.levelCount);
        if(displayMaxLevel) {
            int maxLevel = arguments.getInt("maxLevel", 1);
            textView.setText("Level " + Integer.toString(playerCurrentLevel) + "/" + Integer.toString(maxLevel));
        } else {
            textView.setText("Level " + Integer.toString(playerCurrentLevel));
        }
        int playerLevelProgress = arguments.getInt("playerLevelProgress",0);
        int levelMaxProgress= arguments.getInt("levelMaxProgress");
        textView = (TextView) getView().findViewById(R.id.levelProgress);
        textView.setText(Integer.toString(playerLevelProgress)+"/"+Integer.toString(levelMaxProgress));
        ProgressBar progressBar = (ProgressBar) getView().findViewById(R.id.progressBar);
        progressBar.setMax(levelMaxProgress);
        progressBar.setProgress(playerLevelProgress);
    }
}