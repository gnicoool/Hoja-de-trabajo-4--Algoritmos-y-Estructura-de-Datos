public class StackFactory {
    //Método estático para crear clases que implementen la interfaz de IStack
    @SuppressWarnings("rawtypes")
    public IStack CreateStack(String pila, int capacity) throws ClassNotFoundException{
        //Dependiendo el string enviado, crea estructura de datos lineal distinta
        switch (pila) {
            case "arraylist":
                return new AL<Integer>();
            case "vector":
                return new Vec(capacity);
            //Casos de las demás pilas AÚN SIN IMPLEMENTAR
            /*case "listaSimple":
                return new listaSimple();
            case "listaDoble":
                return new listaDoble(); */
            default:
                throw new ClassNotFoundException("No se encontró una clase con este nombre");
        }
    }
}
