package resizeable_interface;

import comparator_interface_for_shape.system_of_shape.Square;

public class SquareResizeableTest {
    public static void main(String[] args) {
        Square[] squares = new Square[5];
        System.out.println("Before resize: ");
        for(int i = 0; i < squares.length; i++) {
            squares[i] = new Square(Math.ceil(Math.random() * 10));
            System.out.println(squares[i]);
        }
        System.out.println("After resize: ");
        for (Square square: squares) {
            double percent = Math.ceil(Math.random() * 10) * 10;
            square.resize(percent);
            System.out.println("Side increase " + percent + "%:");
            System.out.println(square);
        }
//        squares[0].se
//        squares[0].resize(10);
//        System.out.println(squares[0]);
    }
}
