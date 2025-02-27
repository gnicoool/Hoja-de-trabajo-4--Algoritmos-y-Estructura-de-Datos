import java.util.ArrayList;

public class AL<T extends Number> implements IStack<T> {
    private ArrayList<T> pila = new ArrayList<T>();

    @Override
    public void add(T value) { 
    getPila().add(value);   
    }

    @Override
    public void clear() { 
        getPila().clear();
    }

    @Override
    public T pop() {
    T value = getPila().get(getPila().size()-1);
    getPila().remove(getPila().size()-1);
    return value;
    }

    @Override
    public int size() {
        return getPila().size();
    }

    public ArrayList<T> getPila(){
        return pila;
    }

    public void setPila(ArrayList<T> pila){
        this.pila = pila;
    }
    
}
