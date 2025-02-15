/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fabiola
 */
public class OpenClosed {
  ArrayList
  public OpenClosed() {
    // doIncorrectImplementation();
    doCorrectImplementation();
  }

  /*
   * public void doIncorrectImplementation(){
   * openclosed.incorrect.Rectangle rectangle = new
   * openclosed.incorrect.Rectangle(4,3);
   * openclosed.incorrect.Circle circle = new openclosed.incorrect.Circle(5);
   * 
   * openclosed.incorrect.GeometryOperation op = new
   * openclosed.incorrect.GeometryOperation();
   * System.out.println("Area do retangulo -> " + op.getArea(rectangle));
   * System.out.println("Area do circulo -> " + op.getArea(circle));
   * }
   */

  public void doCorrectImplementation() {
    Shape rectangle = new Rectangle(4, 3);
    Shape circle = new Circle(5);
    Shape triangle = new Triangle(10, 4.3);

    /**
     * Toda vez que uma nova forma geometrica eh adicionada, precisaremos de uma
     * nova logica para calculo da area
     * Como precisaremos mudar o codigo existente (GeometryOperation), essa
     * abordagem fere o Principio do Aberto-Fechado
     */

    System.out.println("Area do retangulo -> " + rectangle.getArea());
    System.out.println("Area do circulo -> " + circle.getArea());
    System.out.println("Area do triangulo -> " + triangle.getArea());

  }

  public static void main(String[] args) {
    OpenClosed opClo = new OpenClosed();
  }
}