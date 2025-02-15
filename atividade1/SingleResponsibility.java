public class SingleResponsibility {

  public SingleResponsibility() {
    doIncorrectImplementation();
    doCorrectImplementation();
  }

  public void doIncorrectImplementation() {
    /**
     * Considere uma classe que contenha informações sobre um livro.
     * A única função dessa classe deve ser conter dados relacionados a livros e
     * operações relacionadas a livros.
     */
    Book book = new Book("Clean Architecture", "Robert Martin", "Science");

    /**
     * Ter um método que imprime o nome do autor nessa classe viola o Princípio da
     * Responsabilidade Única
     */
    // Removido para respeitar o Princípio da Responsabilidade Única
    // book.printAuthorName();

    BookPrinter bookPrinter = new BookPrinter(book);
    bookPrinter.printAuthorName();
  }

  public void doCorrectImplementation() {

    /**
     * Adicione aqui seu código refatorado com referências a métodos e classes
     * contidas no pacote correct
     */

  }

  public static void main(String[] args) {
    SingleResponsibility sr = new SingleResponsibility();
  }
}