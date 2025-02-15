public class BookPrinter {
  Book book; 

  public BookPrinter(Book book) {
    this.book = book;
  }

  public void printAuthorName() {
    System.out.println("Nome do autor -> " + book.getAuthor());
  }
}
