public class ListaDoble<T extends Number> implements IStack<T>{
    private Node<T> cabeza;
    private Node<T> cola;
    private int size;

    public ListaDoble() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    @Override
    public void add(T value) {
        Node<T> nuevo = new Node<>(value);
        if (this.cabeza == null) {
            cabeza = cola = nuevo;
            } else {
                cola.setNext(nuevo);
                nuevo.setPrevious(cola);
                cola = nuevo;
            }
        size++;
    }

    @Override
    public void clear() {
        cabeza = cola = null;
        size = 0;
    }

    @Override
    public T pop() {
        if (cola == null) {
            return null;
        }
        T value = cola.getValue();
        if (cabeza == cola) {
            cabeza = cola = null;
        } else {
            cola = cola.getPrevious();
            cola.setNext(null);
        }
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }
    
}
