package com.tdd.demo;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;

import org.junit.Test;

public class DJTest {
	private PlayListService playListService = mock(PlayListService.class);
	private MediaPlayer mediaPlayer = mock(MediaPlayer.class);
	private DJ dj = new DJ(playListService, mediaPlayer);

	@Test
	public void playsSongWhenNewLocationIsDetected() throws Exception {
		stub(playListService.songFor("Jayanagar")).toReturn("Rock n Roll");
		dj.locationChangedTo("Jayanagar");
		verify(mediaPlayer).play("Rock n Roll");
	}

	@Test
	public void keepQuiteWhenNoSongIsAssociatedForCurrentLocation() {
		stub(playListService.songFor("BTM Layout")).toReturn(null);
		dj.locationChangedTo("BTM Layout");
		verify(mediaPlayer, never()).play(anyString());
	}

	@Test
	public void doesNotInteruptTheCurrentSongEvenIfLocationChanges() {
		stub(playListService.songFor("Jayanagar")).toReturn("Rock n Roll");
		stub(playListService.songFor("Kormangala")).toReturn("Rock On");
		dj.locationChangedTo("Jayanagar");
		dj.locationChangedTo("Kormangala");
		verify(mediaPlayer).play("Rock n Roll");
		verify(mediaPlayer, never()).play("Rock On");

		dj.currentSongFinished();

		verify(mediaPlayer).play("Rock On");
	}
}
