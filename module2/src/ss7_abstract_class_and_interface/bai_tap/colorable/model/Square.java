package ss7_abstract_class_and_interface.bai_tap.colorable.model;

import ss7_abstract_class_and_interface.bai_tap.colorable.Colorable;

public class Square extends Rectangle implements Colorable {
    public Square() {
    }

    public Square(double edge) {
        super(edge, edge);
    }

    public Square(double edge, String color, boolean filled) {
        super(edge, edge, color, filled);
    }

    public double getEdge() {
        return getWidth();
    }

    public void setEdge(double edge) {
        setWidth(edge);
        setLength(edge);
    }

    @Override
    public void setWidth(double width) {
        setEdge(width);
    }

    @Override
    public void setLength(double length) {
        setEdge(length);
    }
    @Override
    public String toString() {
        return "Square: " +
                "edge: " + getEdge() +
                "Area:  " + getArea() +
                "Perimeter:  " + getPerimeter() ;
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides..");
    }
}