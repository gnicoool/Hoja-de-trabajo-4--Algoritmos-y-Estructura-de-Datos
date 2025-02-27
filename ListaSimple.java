public class ListaSimple<T extends Number> implements IStack<T>{
    private Node<T> cabeza;
    private int size;

    public ListaSimple() {
        this.cabeza = null;
        this.size = 0;
    }

    @Override
    public void add(T value) {
        Node<T> nuevo = new Node<>(value);
        if (this.cabeza == null) {
            cabeza = nuevo;
        } else {
            Node<T> temp = cabeza;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(nuevo);
        }
    size++;
    }

    @Override
    public void clear() {
        cabeza = null;
        size = 0;
    }

    @Override
    public T pop() {
        if (cabeza == null) {
            return null;
        }
        if (cabeza.getNext() == null){
            T value = cabeza.getValue();
            cabeza = null;
            size--;
            return value;
        }
        Node<T> temp = cabeza;
        while (temp.getNext().getNext() != null) {
            temp = temp.getNext();
        }
        T value = temp.getNext().getValue();   
        temp.setNext(null);
        size--;
        return value;
    }

    @Override
    public int size() {
        return size;
    }
    
}
