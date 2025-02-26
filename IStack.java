public interface IStack<T extends Comparable<T>> {
    public void add(T value);
    public T delete();
}
