import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class BigRectLister {
    public static void main(String[] args) {
        // Create an ArrayList of Rectangle objects
        List<Rectangle> rectangles = new ArrayList<>();

        // Add Rectangle objects with different perimeters
        rectangles.add(new Rectangle(2, 3));   // Perimeter = 10
        rectangles.add(new Rectangle(5, 1));   // Perimeter = 12
        rectangles.add(new Rectangle(4, 3));   // Perimeter = 14
        rectangles.add(new Rectangle(3, 4));   // Perimeter = 14
        rectangles.add(new Rectangle(6, 2));   // Perimeter = 16
        rectangles.add(new Rectangle(1, 5));   // Perimeter = 12
        rectangles.add(new Rectangle(2, 1));   // Perimeter = 6
        rectangles.add(new Rectangle(3, 2));   // Perimeter = 10
        rectangles.add(new Rectangle(1, 1));   // Perimeter = 4
        rectangles.add(new Rectangle(2, 2));   // Perimeter = 8

        // Create a BigRectangleFilter instance
        BigRectangleFilter bigRectangleFilter = new BigRectangleFilter();

        // Collect all rectangles with big perimeters
        List<Object> bigRectangles = Filter.collectAll(rectangles.toArray(), bigRectangleFilter);

        // Print the collected big rectangles
        System.out.println("Rectangles with big perimeters: ");
        for (Object rectangle : bigRectangles) {
            System.out.println(rectangle);
        }
    }
}
