package com.dj;

import java.util.Map;

/**
 * Created by idnsrp on 6/8/2018.
 */
public class Dj {

    private static final String NO_SONG_AVAILABLE = "No Song Available";
    private final Map<String,String> placeSongMap;
    private String nextSong;
    private String currentSong;
    private boolean isRunning;

    public Dj(Map<String, String> placeSongMap) {
        this.placeSongMap = placeSongMap;
    }

    private void playTrack(String song) {
        currentSong = song;
        isRunning = true;
        nextSong = NO_SONG_AVAILABLE;
    }

    public String movedTo(String location){
        nextSong = placeSongMap.get(location);
        if(nextSong.equalsIgnoreCase(currentSong)){
            nextSong = NO_SONG_AVAILABLE;
        }
        if(!isRunning){
            playTrack(nextSong);
        }
        return currentSong;
    }

    public String songFinished(){
        isRunning = false;
        playTrack(nextSong);
        return currentSong;
    }
}
