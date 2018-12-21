package com.stt.domain;

public class SongVO {
	private String uuid;
	private String title;
	private String artist;
	private String length;
	private String tags;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	@Override
	public String toString() {
		return "SongVO [uuid=" + uuid + ", title=" + title + ", artist=" + artist + ", length=" + length + ", tags="
				+ tags + "]";
	}
}
