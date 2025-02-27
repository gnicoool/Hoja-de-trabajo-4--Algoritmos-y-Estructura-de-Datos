public class Calculadora<T extends Number> {
    //Creación de variables
    char[] operadores = {'+', '-', '/', '*', '%'};
    public static Calculadora miCalculadora = null;
    
    //Método para instanciar una única calculadora
    @SuppressWarnings("rawtypes")
    public static Calculadora getInstance(){
        if(miCalculadora == null){
            miCalculadora = new Calculadora();
        }
        return miCalculadora;
    }

    //Revisa si es un operador admitido por el programa
    public boolean isOperator(char operator){
        for(char operador: operadores)
            if(operator == operador) return true;
        return false;
    }
    //Operaciones aritmeticas básicas
    public double suma(T value1, T value2){
        return value1.doubleValue() + value2.doubleValue();
    }

    public double resta(T value1, T value2){
        return value1.doubleValue() - value2.doubleValue();
    }

    public double multiplicacion(T value1, T value2){
        return value1.doubleValue() * value2.doubleValue();
    }

    public double division(T value1, T value2){
        if(value2.doubleValue() != 0)
            return value1.doubleValue() * value2.doubleValue();
        throw new ArithmeticException("No se puede realizar una división entre 0");
    }

    public double modulo(T value1, T value2){
        if(value2.doubleValue() != 0)
            return value1.doubleValue() % value2.doubleValue();
        throw new ArithmeticException("No se puede realizar módulo con 0");
    }
}
