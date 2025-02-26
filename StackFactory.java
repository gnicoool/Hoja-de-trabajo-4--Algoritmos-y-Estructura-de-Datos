public class StackFactory {
    //Método estático para crear clases que implementen la interfaz de IStack
    @SuppressWarnings("rawtypes")
    public static IStack CreateStack(String pila) throws ClassNotFoundException{
        //Dependiendo el string enviado, crea estructura de datos lineal distinta
        switch (pila) {
            case "arraylist":
                return new AL<Integer>();
            //Casos de las demás pilas AÚN SIN IMPLEMENTAR
            /* case "vector":
                return new Vec();
            case "listaSimple":
                return new listaSimple();
            case "listaDoble":
                return new listaDoble(); */
            default:
                throw new ClassNotFoundException("No se encontró una clase con este nombre");
        }
    }
}
