package quizz;
 
import java.util.*;

/*
 * sobrevivencia(tempo + desafio progessivo + aleatorio || resposta em numeros. ex: acertou 5/10), 
 * temafixo(escolha do usuario + tempo + desafio progressivo || resposta em numeros)
    personalidade(escolha do usuario || resposta em string e numeros, ex: você seria o bachira em blue lock )
*/
public class BancoDePerguntas {
	private static final List<Pergunta> perguntas = new ArrayList<>();
	private static Map<String, List<Pergunta>> perguntasPersonalidade = new HashMap<>();
	
    static {
        perguntas.addAll(carregarPerguntasPadrao());
    }

    static List<Pergunta> carregarPerguntasPadrao() {
        List<Pergunta> lista = new ArrayList<>();

        lista.add(new Pergunta(
            "Ciência",
            null,
            Dificuldade.FACIL,
            "Qual é o planeta mais próximo do Sol?",
            Arrays.asList("Terra", "Vênus", "Mercúrio", "Marte"),
            2,
            null,
            Tipo.NORMAL
            ));

        lista.add(new Pergunta(
            "Games",
            null,
            Dificuldade.FACIL,
            "Qual personagem é conhecido como o encanador da Nintendo?",
            Arrays.asList("Luigi", "Sonic", "Link", "Mario"),
            3,
            null,
            Tipo.NORMAL
            ));

        lista.add(new Pergunta(
            "Filmes",
            null,
            Dificuldade.MEDIO,
            "Quem dirigiu 'A Origem' (Inception)?",
            Arrays.asList("Steven Spielberg", "Christopher Nolan", "James Cameron", "Quentin Tarantino"),
            1,
            null,
            Tipo.NORMAL
            ));

        lista.add(new Pergunta(
            "Matemática",
            null,
            Dificuldade.FACIL,
            "Qual é o valor de π (pi) arredondado para duas casas decimais?",
            Arrays.asList("3.12", "3.14", "3.16", "3.18"),
            1,
            null,
            Tipo.NORMAL
            ));

        lista.add(new Pergunta(
            "História",
            null,
            Dificuldade.MEDIO,
            "Em que ano ocorreu a Revolução Francesa?",
            Arrays.asList("1789", "1804", "1812", "1776"),
            0,
            null,
            Tipo.NORMAL
            ));
        
        lista.add(new Pergunta(
                "Matemática",
                null,
                Dificuldade.MEDIO,
                "Existem 5 regras de Integração",
                Arrays.asList("True", "False"),
                0,
                null,
                Tipo.TRUE_FALSE
                ));
        lista.add(new Pergunta(
        		"nigga",
        		null,
        		Dificuldade.FACIL,
        		"Bombardiro",
        		Arrays.asList("Crocodiro", "Tung tung tung tung tung tung", "Guzzini", "Liriri Larira"),
        		0,
        		null,
        		Tipo.NORMAL
        		));
        return lista;
    }
    
    static Map<String, List<Pergunta>> carregarPerguntasPersonalidade() {
    	perguntasPersonalidade.put("Qual membro do BTS você é", Arrays.asList(
    			new Pergunta(null,
    					null,
    					null,
    					null,
    					null,
    					0,
    					null,
    					null
    			),
    			new Pergunta(null, null, null, null, null, 0)));
		return null;
    }
    
    public static List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public static void adicionarPergunta(Pergunta nova) {
        perguntas.add(nova);
    }
}
