package br.edu.fateczl.set;

public interface ISet<T> {

	public boolean isEmpty();
	public int size();
	public void addFirst(T dado);
	public void addLast(T dado) throws Exception;
	public void add(T dado, int posicao) throws Exception;
	public void removeFirst() throws Exception;
	public void removeLast() throws Exception;
	public void remove(int posicao) throws Exception;
	public T get(int posicao) throws Exception;
	public void clean();
}