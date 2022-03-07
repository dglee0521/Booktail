package org.booktail.domain;

public class ItemDTO {
	private int gdsNum;
	private String title;
	private String isbn; //국제표준 도서번호
	private String datetime;
	private String thumbnail;
	private String authors;
	private String translators;
	private String contents;
	private String publisher;
	private int price;
	private int salePrice;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getTranslators() {
		return translators;
	}
	public void setTranslators(String translators) {
		this.translators = translators;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(int salePrice) {
		this.salePrice = salePrice;
	}
	public int getGdsNum() {
		return gdsNum;
	}
	public void setGdsNum(int gdsNum) {
		this.gdsNum = gdsNum;
	}
	@Override
	public String toString() {
		return "ItemDTO [gdsNum=" + gdsNum + ", title=" + title + ", isbn=" + isbn + ", datetime=" + datetime
				+ ", thumbnail=" + thumbnail + ", authors=" + authors + ", translators=" + translators + ", contents="
				+ contents + ", publisher=" + publisher + ", price=" + price + ", salePrice=" + salePrice + "]";
	}

}
