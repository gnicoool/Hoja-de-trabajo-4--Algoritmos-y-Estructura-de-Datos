public class StackFactory {
    //Método estático para crear clases que implementen la interfaz de IStack
    @SuppressWarnings("rawtypes")
    public IStack CreateStack(String pila, int capacity) throws ClassNotFoundException{
        //Dependiendo el string enviado, crea estructura de datos lineal distinta
        switch (pila) {
            case "arraylist":
                return new AL<Double>();
            case "vector":
                return new Vec(capacity);
            case "listaSimple":
                return new ListaSimple();
            case "listaDoble":
                return new ListaDoble();
            default:
                throw new ClassNotFoundException("No se encontró una clase con este nombre");
        }
    }
}
