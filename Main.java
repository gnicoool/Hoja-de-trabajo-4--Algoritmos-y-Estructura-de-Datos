/*
 * Tarea: Hoja de trabajo 4
    Curso: Algoritmos y estructuras de datos
    Alumnos: Avilés, Alejandra (24722); Girón, Jackelyn (24737); Tan, Sergio (24759)
    Fecha de creación: 21/02/2025
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    //Arrays con los tipos de estrucutras y de operaciones admitidas. Límita las opciones a usar del usuario, reduciendo los errores
    static String[] estructuras = {"arraylist", "vector", "listaSimple", "listaDoble"};
    static char[] operadores = {'+', '-', '/', '*', '%'};
    //Nombre del archivo donde estarán las operaciones
    static String archivo = "datos.txt";
    //Creacion de la factory para crear distintos tipos de estructuras
    static StackFactory factory = new StackFactory();
    static Calculadora<Double> c = Calculadora.getInstance();

    
    public static void main(String[] args) throws ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        boolean menu = true;
        //Mensaje de bienvenida e instrucciones para el usuario
        System.out.println("Calculo de expresiones postfix");
        while(menu == true){
            System.out.println("Seleccione el tipo de estructura a usar");
            for(int i = 0; i<estructuras.length; i++){
                System.out.println(i+ ") " + estructuras[i]);
            }
            System.out.println("4) Salir");
            int opcion = sc.nextInt();
            //Llamada a la funcion operaciones para la realización de calculos
            if(opcion == 4)
                menu = false;
            else
                operaciones(archivo, estructuras[opcion]);
        }
        sc.close();
    }
            
            //Método para la lectura del archivo txt y calcular las operaciones postfix. Se necesita el nombre del archivo y tipo de estructura de datos a usar
            @SuppressWarnings("unchecked")
            public static void operaciones (String fileName, String tipoEstructura) throws ClassNotFoundException{
            //Lectura del archivo
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
                String line;
                //Ciclo para recorrer las filas con datos dentro del txt
                while ((line = bufferedReader.readLine()) != null){
                    //Guarda los datos en un array luego de separarlos cuando encuentra espacios
                    String[] data = line.split(" ");
                    //Contador de valores positivos para usarlo como paramentro en create stack
                    int count = 0;
                    for(String value: data){
                        if(value.matches("\\d+"))
                            count++;
                    }
                    //Creacion de estructura en base a la seleccion del usuario
                    IStack pila = factory.CreateStack(tipoEstructura, count);
                    boolean error = false;
                    //Revisa dato por dato dentro de la linea a evaluar
                    for(String value : data){
                        //Revisa si el dato es un número es positivo
                        if(value.matches("\\d+")){
                            pila.add(Double.valueOf(value));
                        }else if(value.length() == 1 && c.isOperator(value.charAt(0))){ //Es operador
                            //Verifica si hay suficientes operandos en la pila
                            if(pila.size() < 2){
                                System.out.println("Error: There are not enough operands in line: " + line);
                                error = true;
                                pila.clear();
                                break;
                            }
                            //Obtiene los últimos 2 valores agregados a la pila y el operador a usar
                            double b = (double) pila.pop();
                            double a = (double) pila.pop();
                            char operator = value.charAt(0);
                            if ((operator == '/') && (a == 0 || b == 0 || a == 0 && b == 0)){
                                System.out.println("Error: Division by zero in line: " + line);
                                error = true;
                                pila.clear();
                                break;
                                }
    
                                // Manejo de modulo por 0
                                if ((operator == '%') && (a == 0 || b == 0 || a == 0 && b == 0)){
                                    System.out.println("Error: Modulo by zero in line: " + line);
                                error = true;
                                pila.clear();
                                break;
                            }
                            //En base al operador realiza la operación aritmética requerida
                            double result;
                            switch (operator) {
                                case '+':
                                    result = c.suma(a, b);
                                    break;
                                    case '-':
                                    result = c.resta(a, b);
                                    break;
                                    case '*':
                                    result = c.multiplicacion(a, b);
                                    break;
                                    case '/':
                                    result = c.division(a, b);
                                    break;
                                    case '%':
                                    result = c.modulo(a, b);
                                    break;
                                    default:
                                    throw new AssertionError();
                                }
                                //Agrega de nuevo el valor a la pila/arraylist/vector
                                pila.add(result);
                        }else{
                            //Si el dato no puede ser operado limpia la pila y no regresa un resultado
                            System.out.println("Error: Invalid value '" + value + "' in line: " + line);
                            error = true;
                            pila.clear();
                            break;
                        }
                    }
                    if (!error){    //La operación fue ser efectuada sin problemas
                        if (pila.size() == 1) {
                            System.out.println("The result of the line (" + line + ") is: " + pila.pop());
                        } else { // Hay más de un elemento en la stack y no hay más operadores
                            System.out.println("Error: There is no single final result on the stack for the line: " + line);
                        }
                    }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } 
    
    }
}