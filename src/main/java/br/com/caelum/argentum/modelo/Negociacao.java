package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public final class Negociacao {

	private final double preco;
	private final int quantidade;
	private final Calendar data;
	
	
	public Negociacao(double preco, int quantidade, Calendar data) {
		if(data==null){
			throw new IllegalArgumentException("Data n�o pode ser nula");
		}
		
		this.preco = preco;
		this.quantidade = quantidade;
		this.data = data;
	}


	public double getVolume(){
		return preco*quantidade;
	}
	
	
	public double getPreco() {
		return preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Calendar getData() {
		  return (Calendar) this.data.clone();
		}


	public boolean isMesmoDia(Calendar outraData) {
		return    data.get(Calendar.DAY_OF_MONTH) == outraData.get(Calendar.DAY_OF_MONTH);
	}


	public boolean mesmoDiaMasMesesDiferentesNaoSaoDoMesmoDia(Calendar mesmoMomento) {
		
		return data.get(Calendar.MONTH) == mesmoMomento.get(Calendar.MONTH);
	}
	
	
	
}
