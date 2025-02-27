public interface IStack<T extends Number> {
    public void add(T value);
    public void clear();
    public T pop();
    public int size();
}
