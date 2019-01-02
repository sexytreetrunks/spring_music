package com.stt.domain;

public class PlaylistVO {
	private int id;
	private int owner;
	private String title;
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
	@Override
	public String toString() {
		return "PlaylistVO [id=" + id + ", owner=" + owner + ", title=" + title + "]";
	}
}
