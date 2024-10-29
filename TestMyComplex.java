public class TestMyComplex {
    public static void main(String[] args) {

        MyComplex c1 = new MyComplex(3, 4);
        MyComplex c2 = new MyComplex(1, 2);

        System.out.println("Complex number c1: " + c1);
        System.out.println("Complex number c2: " + c2);

        c1.setReal(5);
        c1.setImag(6);
        System.out.println("Updated c1: " + c1);


        System.out.println("c1 is real: " + c1.isReal());
        System.out.println("c1 is imaginary: " + c1.isImaginary());

        System.out.println("c1 equals c2: " + c1.equals(c2));

        MyComplex c4 = c1.subtract(c2);
        System.out.println("c1 - c2 = " + c4);

        MyComplex c5 = c1.multiply(c2);
        System.out.println("c1 * c2 = " + c5);
    }
}
