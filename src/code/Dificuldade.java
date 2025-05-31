package code;

public enum Dificuldade{
    FACIL(2.0),
    MEDIO(5.0),
    DIFICIL(8.0),
	EXTREMA(10.0);
	
    private final double valor;

    Dificuldade(double valor){
        this.valor = valor;
    }

    public double getValor(){
        return valor;
    }
    
    @Override
    public String toString(){
        switch(this){
            case FACIL: return "Fácil";
            case MEDIO: return "Médio";
            case DIFICIL: return "Dificil";
            case EXTREMA: return "Extremo";
            default: return "";
        }
    }
}
