package ss7_abstract_class_and_interface.bai_tap.colorable;

import ss7_abstract_class_and_interface.bai_tap.colorable.model.Square;
import ss7_abstract_class_and_interface.bai_tap.colorable.model.Circle;
import ss7_abstract_class_and_interface.bai_tap.colorable.model.Rectangle;
import ss7_abstract_class_and_interface.bai_tap.colorable.model.Shape;

public class Run {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new Circle(3.5, "indigo", false);
        shapes[1] = new Square(6.7, "orange", true);
        shapes[2] = new Rectangle(2.5, 3.8, "orange", true);
        shapes[3] = new Square(2.5, "orange", true);

        for (Shape shape : shapes) {
            System.out.println("Diện tích và độ dài của các hình là: " + shape);
            if (shape instanceof Square) {
                ((Square) shape).howToColor();
            }
        }
    }
}
