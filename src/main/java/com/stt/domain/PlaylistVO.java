package com.stt.domain;

public class PlaylistVO {
	private int id;
	private int owner;
	private String title;
	private String songslist;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOwner() {
		return owner;
	}
	public void setOwner(int owner) {
		this.owner = owner;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSongslist() {
		return songslist;
	}
	public void setSongslist(String songslist) {
		this.songslist = songslist;
	}
	@Override
	public String toString() {
		return "PlaylistVO [id=" + id + ", owner=" + owner + ", title=" + title + ", songslist=" + songslist + "]";
	}
}
