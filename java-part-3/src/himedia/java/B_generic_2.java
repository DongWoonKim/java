package himedia.java;

public class B_generic_2<T extends Number> {

    // 덧셈
    public T add(T num1, T num2) {
        if ( num1 instanceof Integer ) {
            return (T) Integer.valueOf(num1.intValue() + num2.intValue()) ;
        } else if ( num1 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() + num2.doubleValue()) ;
        }

        throw new UnsupportedOperationException("지원되지 않는 타입입니다.");
    }

    // 뺄셈
    public T subtract(T num1, T num2) {
        if ( num1 instanceof Integer ) {
            return (T) Integer.valueOf(num1.intValue() - num2.intValue()) ;
        } else if ( num1 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() - num2.doubleValue()) ;
        }

        throw new UnsupportedOperationException("지원되지 않는 타입입니다.");
    }

    // 곱셈
    public T multiply(T num1, T num2) {
        if ( num1 instanceof Integer ) {
            return (T) Integer.valueOf(num1.intValue() * num2.intValue()) ;
        } else if ( num1 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() * num2.doubleValue()) ;
        }

        throw new UnsupportedOperationException("지원되지 않는 타입입니다.");
    }

    // 나눗셈
    public T divide(T num1, T num2) {
        if ( num1 instanceof Integer ) {
            return (T) Integer.valueOf(num1.intValue() / num2.intValue()) ;
        } else if ( num1 instanceof Double) {
            return (T) Double.valueOf(num1.doubleValue() / num2.doubleValue()) ;
        }

        throw new UnsupportedOperationException("지원되지 않는 타입입니다.");
    }

    public static void main(String[] args) {
        B_generic_2<Integer> intCalculator = new B_generic_2<>();
        System.out.println("Integer Addition: " + intCalculator.add(10, 20));
        System.out.println("Integer Subtraction: " + intCalculator.subtract(20, 10));
        System.out.println("Integer Multiplication: " + intCalculator.multiply(10, 20));
        System.out.println("Integer Division: " + intCalculator.divide(20, 10));

        B_generic_2<Double> doubleCalculator = new B_generic_2<>();
        System.out.println("Double Addition: " + doubleCalculator.add(10.5, 20.3));
        System.out.println("Double Subtraction: " + doubleCalculator.subtract(20.5, 10.2));
        System.out.println("Double Multiplication: " + doubleCalculator.multiply(10.0, 20.0));
        System.out.println("Double Division: " + doubleCalculator.divide(20.0, 10.0));
    }
}
