package com.stt.domain;

import java.sql.Time;

public class SongVO {
	private int id;
	private String title;
	private int artistid;
	private Time length;
	private int albumid;
	private int count;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getArtistid() {
		return artistid;
	}
	public void setArtistid(int artistid) {
		this.artistid = artistid;
	}
	public Time getLength() {
		return length;
	}
	public void setLength(Time length) {
		this.length = length;
	}
	public int getAlbumid() {
		return albumid;
	}
	public void setAlbumid(int albumid) {
		this.albumid = albumid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "SongVO [id=" + id + ", title=" + title + ", artistid=" + artistid + ", length=" + length + ", albumid="
				+ albumid + ", count=" + count + "]";
	}
}
