public class main {
    public static void main(String[] args) {
        Shape square = ShapeFactory.createShape("square");
        square.draw();
        
        Shape rectangle = ShapeFactory.createShape("rectangle");
        rectangle.draw();
        
        Shape circle = ShapeFactory.createShape("circle");
        circle.draw();
    }
    
}
