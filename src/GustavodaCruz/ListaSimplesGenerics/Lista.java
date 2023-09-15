package GustavodaCruz.ListaSimplesGenerics;

public class Lista<T> {

	No primeiro;

	public Lista() {
		primeiro = null;
	}

	public boolean isEmpty() {
		if (primeiro == null) {
			return true;
		} else {
			return false;
		}
	}

	public int size() {
		int cont = 0;
		if (!isEmpty()) {
			No auxiliar = primeiro;
			while (auxiliar != null) {
				cont++;
				auxiliar = auxiliar.proximo;
			}
		}
		return cont;
	}

	private No getNo(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista vazia");
		}
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição inválida");
		}
		No auxiliar = primeiro;
		int cont = 0;
		while (cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		return auxiliar;
	}

	public void addFirst(T valor) {
		No elemento = new No();
		elemento.dado = valor;
		elemento.proximo = primeiro;
		primeiro = elemento;
	}

	public void addLast(T valor) throws Exception {
		int tamanho = size();

		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}

		No elemento = new No();
		elemento.dado = valor;
		elemento.proximo = null;

		No ultimo = getNo(tamanho - 1);
		ultimo.proximo = elemento;
	}

	public void add(T valor, int posicao) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (posicao < 0 || posicao > tamanho) {
			throw new Exception("Posição inválida");
		}
		if (posicao == 0) {
			addFirst(valor);
		} else if (posicao == tamanho) {
			addLast(valor);
		} else {
			No elemento = new No();
			elemento.dado = valor;
			No anterior = getNo(posicao - 1);
			elemento.proximo = anterior.proximo;
			anterior.proximo = elemento;
		}
	}

	public void removeFirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		primeiro = primeiro.proximo;
	}

	public void removeLast() throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (tamanho == 1) {
			removeFirst();
		} else {
			No penultimo = getNo(tamanho - 2);
			penultimo.proximo = null;
		}
	}

	public void remove(int pos) throws Exception {
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Invalida");
		}
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		if (pos == 0) {
			removeFirst();
		} else if (pos == tamanho - 1) {
			removeLast();
		} else {
			No anterior = getNo(pos - 1);
			No atual = getNo(pos);
			anterior.proximo = atual.proximo;
		}
	}

	public T get(int pos) throws Exception {
		if (isEmpty()) {
			throw new Exception("Lista Vazia");
		}
		int tamanho = size();
		if (pos < 0 || pos > tamanho - 1) {
			throw new Exception("Posição Invalida");
		}
		No auxiliar = primeiro;
		int cont = 0;
		while (cont < pos) {
			auxiliar = auxiliar.proximo;
			cont++;
		}
		T valor = (T) auxiliar.dado;
		return valor;
	}
	
	public void mostraLista() {
		
	}
}
