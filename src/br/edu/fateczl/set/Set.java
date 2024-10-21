package br.edu.fateczl.set;

public class Set <T> implements ISet<T>{

	No<T> primeiro;
	
	public Set () {
		primeiro=null;
	}
	@Override
	public boolean isEmpty() {
		if(primeiro==null) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		int cont =0;
		if(!isEmpty()) {
			No<T>auxiliar=primeiro;
			while(auxiliar!=null) {
				cont++;
				auxiliar=auxiliar.proximo;
			}
		}
		return cont;
	}

	@Override
	public void addFirst(T dado) {
		try {
			if(!contains(dado)) {
				No<T> elemento=new No<>();
				elemento.dado=dado;
				elemento.proximo=primeiro;
				primeiro=elemento;
			}
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}

	@Override
	public void addLast(T dado) throws Exception {
		if(!contains(dado)) {
			if(isEmpty()) {
				addFirst(dado);
			}else {
				No<T>elemento=new No<>();
				elemento.dado=dado;
				elemento.proximo=null;
				No<T>ultimo=getNo(size()-1);
				ultimo.proximo=elemento;
			}
		}
	}

	@Override
	public void add(T dado, int posicao) throws Exception {
		if (!contains(dado)) {
			if (posicao < 0 || posicao > size()) {
				throw new Exception("Posição inválida");
			}
			if (posicao == 0) {
				addFirst(dado);
			} else if (posicao == size()) {
				addLast(dado);
			} else {
				No<T> elemento = new No<>();
				elemento.dado = dado;
				No<T> anterior = getNo(posicao - 1);
				elemento.proximo = anterior.proximo;
				anterior.proximo = elemento;
			}
		}
	}

	@Override
	public void removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		primeiro = primeiro.proximo;
	}

	@Override
	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (tamanho == 1) {
			removeFirst();
		} else {
			No<T> penultimo = getNo(tamanho - 2);
			penultimo.proximo = null;
		}
		
	}

	@Override
	public void remove(int posicao) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
	
		if (posicao < 0 || posicao > size() - 1) {
			throw new Exception("Posição inválida");
		}
		if (posicao == 0) {
			removeFirst();
		} else if (posicao == size() - 1) {
			removeLast();
		} else {
			No<T> anterior = getNo(posicao - 1);
			No<T> atual = getNo(posicao);
			anterior.proximo = atual.proximo;
		}
		
	}

	@Override
	public T get(int posicao) throws Exception {
		No<T> elemento=getNo(posicao);
		return elemento.dado;
	}
	private No<T> getNo(int posicao) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia");
		}
		if (posicao < 0 || posicao > size() - 1) {
			throw new Exception("Posição inválida");
		}

		No<T> auxiliar = primeiro;
		int cont = 0;
		while (cont < posicao) {
			auxiliar = auxiliar.proximo;
			cont++;
		}

		return auxiliar;
	}

	@Override
	public void clean() {
		No<T>aux=primeiro;
		while(aux!=null) {
			No<T>prox=aux.proximo;
			aux.dado=null;
			aux.proximo=null;
			aux=prox;
		}
	}
	public boolean contains(T valor)throws Exception {
		
		try {
			for(int i=0;i<size();i++) {
				if(valor.equals(get(i))) {
					return true;
				}
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

}
