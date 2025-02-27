public class Vec<T extends Number> implements IStack<T> {
    private T[] pila;
    private int size;

    public Vec(int capacity){
        if (capacity > 0){
            this.pila = (T[])new Number[capacity];
            this.size = 0;
        }
    }

    @Override
    public void add(T value) {
        if (size< pila.length){
            pila[size] = value;
            size++; 
        }
    }

    @Override
    public void clear() {
        pila = (T[])new Number[pila.length];
        size = 0;
    }

    @Override
    public T pop() {
        if (size <= 0){
            return null;
        }
        T value = pila[size];
        pila[size] = null;
        size--;
        return value;
    }

    @Override
    public int size() {
    return size;
    }

    public T[] getPila() {
        return pila;
    }

    public void setPila(T[] pila) {
        this.pila = pila;
    }
    
    

}
