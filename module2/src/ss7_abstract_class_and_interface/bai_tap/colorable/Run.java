package ss7_abstract_class_and_interface.bai_tap.colorable;

import ss7_abstract_class_and_interface.bai_tap.colorable.model.Square;
import ss7_abstract_class_and_interface.bai_tap.colorable.model.Circle;
import ss7_abstract_class_and_interface.bai_tap.colorable.model.Rectangle;
import ss7_abstract_class_and_interface.bai_tap.colorable.model.Shape;

public class Run {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Square square=new Square();
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.5, "indigo", false);
        shapes[1] = new Rectangle(2.5, 3.8, "orange", true);
        shapes[2] = new Square(2.5, "orange", true);

        for (Shape shape : shapes) {
            if (shape instanceof Square) {
                System.out.println(shape);
                square.howToColor();
            }
            if (shape instanceof Circle) {
                System.out.println(shape);
            }
            if (shape instanceof Rectangle) {
                System.out.println(shape);
            }
        }
    }
}
