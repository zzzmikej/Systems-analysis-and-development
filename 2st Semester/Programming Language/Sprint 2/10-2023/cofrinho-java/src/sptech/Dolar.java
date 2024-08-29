package sptech;

public class Dolar extends Moeda{
	
	public Dolar(double valorInicial) {
		this.valor = valorInicial;
	}

	public void info() {
		
		System.out.println("Dólar - " + valor);
		
	}

	public double converter() {
		
		return this.valor * 4.82;
	}

}
