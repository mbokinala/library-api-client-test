package objects;

public class Book {
	public String title;
	public String callNumber;
	public int barcode;
	public Author author;
	
	@Override
	public String toString() {
		return "Book [title=" + title + ", callNumber=" + callNumber + ", barcode=" + barcode + ", author=" + author.toString()
				+ "]";
	}
	
	public class Author {
		public String first;
		public String last;
		@Override
		
		public String toString() {
			return "Author [first=" + first + ", last=" + last + "]";
		}
		
		
	}
	
}
