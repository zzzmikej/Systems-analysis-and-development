package sptech;

public class Euro extends Moeda {
	
	public Euro(double valorInicial) {
		this.valor = valorInicial;
	}

	public void info() {
		System.out.println("Euro - " + valor);		
	}

	public double converter() {
		return this.valor * 5.36;
	}
}
