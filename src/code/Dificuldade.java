package quizz;

public enum Dificuldade {
    FACIL(2.0),
    MEDIO(5.0),
    DIFICIL(8.0),
	EXTREMA(10.0);
	
    private final double valor;

    Dificuldade(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
