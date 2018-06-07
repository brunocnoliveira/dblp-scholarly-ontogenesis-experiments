package br.ufsc.inf.lapesd.dblppublication.dataservice.model;

import java.util.List;

public class Publication {

	private List<String> author;
	private List<String> editor;
	private String address;
	private String title;
	private String booktitle;
	private String year;
	private String journal;
	private String school;
	private List<String> publisher;
	private List<String> series;
	
	
	public List<String> getAuthor() {
		return author;
	}
	public void setAuthor(List<String> author) {
		this.author = author;
	}
	public List<String> getEditor() {
		return editor;
	}
	public void setEditor(List<String> editor) {
		this.editor = editor;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public List<String> getPublisher() {
		return publisher;
	}
	public void setPublisher(List<String> publisher) {
		this.publisher = publisher;
	}
	public List<String> getSeries() {
		return series;
	}
	public void setSeries(List<String> series) {
		this.series = series;
	}
	
	@Override
	public String toString() {
		return "author: "+this.author+" | title: "+this.title+" | year: "+this.year;
	}
	
	
}
