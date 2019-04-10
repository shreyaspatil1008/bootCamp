package com.dj;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by idnsrp on 6/8/2018.
 */
public class DjTest {

    private Map<String,String> placeSongMap;
    private Dj dj;

    @Before
    public void setUp(){
        placeSongMap = new HashMap<>();
        placeSongMap.put("Baner","Halla re");
        placeSongMap.put("Hinjewadi","Sanam re");
        placeSongMap.put("Aundh","Piya re");
        placeSongMap.put("Sanghavi","Sajan re");
        dj = new Dj(placeSongMap);
    }

    @Test
    public void playNewTrackAndMoveToAnotherLocation(){
        Assert.assertEquals("Halla re",dj.movedTo("Baner"));
        Assert.assertEquals("Halla re",dj.movedTo("Aundh"));
        Assert.assertEquals("Piya re",dj.songFinished());
    }

    @Test
    public void playNewTrackMoveToAnotherLocationComeBackToOrigionalLocationAndFisishSong(){
        Assert.assertEquals("Halla re",dj.movedTo("Baner"));
        Assert.assertEquals("Halla re",dj.movedTo("Aundh"));
        Assert.assertEquals("Halla re",dj.movedTo("Baner"));
        Assert.assertEquals("No Song Available",dj.songFinished());
    }

    @Test
    public void playNewTrackMoveToAnotherLocationComeBackToOrigionalLocationGoAgainToAnotherLocationFinishTheSong(){
        Assert.assertEquals("Halla re",dj.movedTo("Baner"));
        Assert.assertEquals("Halla re",dj.movedTo("Aundh"));
        Assert.assertEquals("Halla re",dj.movedTo("Baner"));
        Assert.assertEquals("Halla re",dj.movedTo("Aundh"));
        Assert.assertEquals("Piya re",dj.songFinished());
    }

    @Test
    public void playNewTrackMoveToAnotherLocationFinishTheSongAgainFinishTheSong(){
        Assert.assertEquals("Halla re",dj.movedTo("Baner"));
        Assert.assertEquals("Halla re",dj.movedTo("Aundh"));
        Assert.assertEquals("Piya re",dj.songFinished());
        Assert.assertEquals("No Song Available",dj.songFinished());
    }
}
