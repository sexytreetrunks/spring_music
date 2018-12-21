package com.stt.domain;

import org.springframework.web.multipart.MultipartFile;

public class UploadDTO {
	MultipartFile songfile;
	String title;
	String artist;
	String tags;
	MultipartFile cover;
	String length;
	
	public MultipartFile getSongfile() {
		return songfile;
	}
	public void setSongfile(MultipartFile songfile) {
		this.songfile = songfile;
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
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public MultipartFile getCover() {
		return cover;
	}
	public void setCover(MultipartFile cover) {
		this.cover = cover;
	}
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return "UploadDTO [songfile=" + songfile.getOriginalFilename() + ", title=" + title + ", artist=" + artist + ", tags=" + tags
				+ ", cover=" + cover.getOriginalFilename() + ", length=" + length + "]";
	}
	
}
