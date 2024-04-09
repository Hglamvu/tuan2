//interface đại diện cho các đối tượng hình học
interface Shape{
    void draw();
}

class Square implements Shape{
    @Override
    public void draw(){
        System.out.println("Vẽ hình vuông");
    }
}
class Rectangle implements Shape{
    @Override
    public void draw(){
        System.out.println("Vẽ hình tam giác");
    }
}
class Circle implements Shape{
    @Override
    public void draw(){
        System.out.println("Vẽ hình tròn");
    }
}
//Factory để tạo đối tượng hình học 
class ShapeFactory {
    public static Shape createShape(String type) {
        if (type.equalsIgnoreCase("square")) {
            return new Square();
        } else if (type.equalsIgnoreCase("rectangle")) {
            return new Rectangle();
        } else if (type.equalsIgnoreCase("circle")) {
            return new Circle();
        } else {
            throw new IllegalArgumentException("Loại hình học không hợp lệ");
        }
    }
}   
