package IF;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Couple<T> implements Serializable {
	private T first, second;

	public Couple(T first, T second) {
		super();
		this.first = first;
		this.second = second;
	}
	public T getFirst() {
		return first;
	}
	public T getSecond() {
		return second;
	}
	public String toString() {
		return "(" + first + "," + second + ")";
	}
}
