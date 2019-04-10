package com.tdd.demo;

public class DJ implements LocationAware, MediaTracker {

	private final PlayListService playListService;
	private final MediaPlayer mediaPlayer;
	private boolean playing;
	private String nextSong;

	public DJ(PlayListService playListService, MediaPlayer mediaPlayer) {
		this.playListService = playListService;
		this.mediaPlayer = mediaPlayer;
	}

	public void locationChangedTo(String location) {
		String song = playListService.songFor(location);
		if (!playing)
			playNow(song);
		else
			nextSong = song;
	}

	public void currentSongFinished() {
		playing = false;
		playNow(nextSong);
	}

	private void playNow(String song) {
		if (song != null) {
			playing = true;
			mediaPlayer.play(song);
		}
	}

}
