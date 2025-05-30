package code;
 
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
     // História
        lista.add(new Pergunta(
            "História",
            null,
            Dificuldade.MEDIO,
            "Quem foi o primeiro presidente do Brasil?",
            Arrays.asList("Deodoro da Fonseca", "Getúlio Vargas", "Dom Pedro II", "Prudente de Morais"),
            0,
            null,
            Tipo.NORMAL
        ));

        // Ciência
        lista.add(new Pergunta(
            "Ciência",
            null,
            Dificuldade.DIFICIL,
            "Quantos elementos químicos a tabela periódica possui atualmente?",
            Arrays.asList("92", "118", "103", "87"),
            1,
            null,
            Tipo.NORMAL
        ));

        // Geografia
        lista.add(new Pergunta(
            "Geografia",
            null,
            Dificuldade.FACIL,
            "Qual é o maior oceano do mundo?",
            Arrays.asList("Atlântico", "Índico", "Ártico", "Pacífico"),
            3,
            null,
            Tipo.NORMAL
        ));

        // Entretenimento
        lista.add(new Pergunta(
            "Entretenimento",
            null,
            Dificuldade.MEDIO,
            "Qual atriz interpretou Hermione em 'Harry Potter'?",
            Arrays.asList("Emma Watson", "Emma Stone", "Emma Roberts", "Emilia Clarke"),
            0,
            null,
            Tipo.NORMAL
        ));

        // Esportes
        lista.add(new Pergunta(
            "Esportes",
            null,
            Dificuldade.FACIL,
            "Quantos jogadores formam um time de futebol em campo?",
            Arrays.asList("10", "11", "9", "12"),
            1,
            null,
            Tipo.NORMAL
        ));

        // Tecnologia
        lista.add(new Pergunta(
            "Tecnologia",
            null,
            Dificuldade.MEDIO,
            "Qual empresa desenvolveu o sistema operacional Android?",
            Arrays.asList("Microsoft", "Apple", "Google", "Amazon"),
            2,
            null,
            Tipo.NORMAL
        ));

        // True/False - Cultura Geral
        lista.add(new Pergunta(
            "Cultura Geral",
            null,
            Dificuldade.FACIL,
            "O sol é uma estrela",
            Arrays.asList("True", "False"),
            0,
            null,
            Tipo.TRUE_FALSE
        ));

        // Matemática
        lista.add(new Pergunta(
            "Matemática",
            null,
            Dificuldade.DIFICIL,
            "Qual é a raiz quadrada de 144?",
            Arrays.asList("11", "12", "13", "14"),
            1,
            null,
            Tipo.NORMAL
        ));

        // Literatura
        lista.add(new Pergunta(
            "Literatura",
            null,
            Dificuldade.MEDIO,
            "Quem escreveu 'Dom Quixote'?",
            Arrays.asList("Miguel de Cervantes", "William Shakespeare", "Machado de Assis", "Luís de Camões"),
            0,
            null,
            Tipo.NORMAL
        ));

        // Biologia
        lista.add(new Pergunta(
            "Biologia",
            null,
            Dificuldade.FACIL,
            "Quantos ossos tem o corpo humano adulto?",
            Arrays.asList("206", "156", "256", "306"),
            0,
            null,
            Tipo.NORMAL
        ));
     // Cinema
        lista.add(new Pergunta(
            "Cinema",
            null,
            Dificuldade.EXTREMA,
            "Qual filme ganhou o primeiro Oscar de Melhor Filme?",
            Arrays.asList("Asas", "Cidadão Kane", "Casablanca", "E o Vento Levou"),
            0,
            null,
            Tipo.NORMAL
        ));

        // Música
        lista.add(new Pergunta(
            "Música",
            null,
            Dificuldade.EXTREMA,
            "Qual álbum da Beatles é conhecido como 'Álbum Branco'?",
            Arrays.asList("Abbey Road", "Sgt. Pepper's", "The Beatles", "Revolver"),
            2,
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
