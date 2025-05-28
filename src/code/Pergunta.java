package code;

import java.util.List;

public class Pergunta {
    private String tema;
    private String subtema;
    private Dificuldade nivel;
    private String enunciado;
    private List<String> alternativas;
    private int indiceRespostaCorreta;
    private String personalidade;
    private Tipo tipo;

    public Pergunta(String tema, String subtema, Dificuldade nivel, String enunciado, List<String> alternativas, int indiceRespostaCorreta) {
        this.tema = tema;
        this.subtema = subtema;
        this.nivel = nivel;
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.indiceRespostaCorreta = indiceRespostaCorreta;
        this.personalidade = "";
        this.tipo = null;
    }
    
    public Pergunta(String tema, String subtema, Dificuldade nivel, String enunciado, List<String> alternativas, int indiceRespostaCorreta, String personalidade, Tipo tipo) {
        this.tema = tema;
        this.subtema = subtema;
        this.nivel = nivel;
        this.enunciado = enunciado;
        this.alternativas = alternativas;
        this.indiceRespostaCorreta = indiceRespostaCorreta;
        this.personalidade = personalidade;
        this.tipo = tipo;
    }

    public String getTema() {
        return tema;
    }
    
    public String getSubtema() {
    	return subtema;
    }
    
    public Dificuldade getNivel() {
    	return nivel;
    }
    
    public String getEnunciado() {
        return enunciado;
    }

    public List<String> getAlternativas() {
        return alternativas;
    }

    public int getIndiceRespostaCorreta() {
        return indiceRespostaCorreta;
    }

    public String getPersonalidade() {
    	return personalidade;
    }
    
    public Tipo getTipo() {
    	return tipo;
    }
    
    public boolean isRespostaCorreta(int indiceEscolhido) {
        return indiceEscolhido == indiceRespostaCorreta;
    }

	@Override
	public String toString() {
		return "Pergunta [tema=" + tema + ", subtema=" + subtema + ", nivel=" + nivel + ", enunciado=" + enunciado
				+ ", alternativas=" + alternativas + ", indiceRespostaCorreta=" + indiceRespostaCorreta
				+ ", personalidade=" + personalidade + ", tipo=" + tipo + "]";
	}
    
}

