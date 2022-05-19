package ss7_abstract_class_and_interface.bai_tap.resizeable;

import ss7_abstract_class_and_interface.bai_tap.resizeable.model.Circle;
import ss7_abstract_class_and_interface.bai_tap.resizeable.model.Rectangle;
import ss7_abstract_class_and_interface.bai_tap.resizeable.model.Shape;

public class Run {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(3.5, "indigo", false);
        shapes[1] = new Rectangle(2.5, 3.8, "orange", true);
        shapes[2] = new Rectangle(4, 7, "orange", true);
        shapes[3] = new Rectangle(5, 5, "orange", true);

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println(shape);
                System.out.println("After: ");
                circle.resize(40);
                System.out.println("----------------");
            }
            if (shape instanceof Rectangle) {
                System.out.println(shape);
                System.out.println("After: ");
                rectangle.resize(30);
                System.out.println("----------------");
            }
        }
    }
}
