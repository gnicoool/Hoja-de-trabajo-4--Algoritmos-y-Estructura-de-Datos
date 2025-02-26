import java.util.ArrayList;

public class AL<T extends Comparable<T>> implements IStack<T> {
    private ArrayList<T> pila = new ArrayList<T>();

    @Override
    public void add(T value) { 
    getPila().add(value);   
    }

    @Override
    public T delete() {
    T value = getPila().get(getPila().size()-1);
    getPila().remove(getPila().size()-1);
    return value; 
    }

    public ArrayList<T> getPila(){
        return pila;
    }

    public void setPila(ArrayList<T> pila){
        this.pila = pila;
    }
    
}
