package ss7_abstract_class_and_interface.bai_tap.colorable;

import ss7_abstract_class_and_interface.bai_tap.colorable.model.Circle;
import ss7_abstract_class_and_interface.bai_tap.colorable.model.Rectangle;
import ss7_abstract_class_and_interface.bai_tap.colorable.model.Shape;

public class Run {
    public static void main(String[] args) {
        Circle circle = new Circle();
        Rectangle rectangle = new Rectangle();
        Shape[] shapes = new Shape[2];
        shapes[0] = new Circle(3.5, "indigo", false);
        shapes[1] = new Rectangle(2.5, 3.8, "orange", true);
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                System.out.println(shape);
                System.out.println("After: ");
                circle.resize(((Circle) shape).getRadius());
            }
            if (shape instanceof Rectangle) {
                System.out.println(shape);
                System.out.println("After: ");
                rectangle.resize(((Rectangle) shape).getWidth(), ((Rectangle) shape).getWidth());
            }
        }
    }
}
