package code;

import java.util.*;

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
            "Geografia",
            null,
            Dificuldade.FACIL,
            "Qual é o maior oceano do mundo?",
            Arrays.asList("Atlântico", "Índico", "Ártico", "Pacífico"),
            3,
            null,
            Tipo.NORMAL
        ));

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

        lista.add(new Pergunta(
            "Cultura Geral",
            null,
            Dificuldade.FACIL,
            "O sol é uma estrela",
            Arrays.asList("Sim", "Não"),
            0,
            null,
            Tipo.TRUE_FALSE
        ));

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
            "Entretenimento",
            null,
            Dificuldade.MEDIO,
            "Qual atriz interpretou Hermione em 'Harry Potter'?",
            Arrays.asList("Emma Watson", "Emma Stone", "Emma Roberts", "Emilia Clarke"),
            0,
            null,
            Tipo.NORMAL
        ));

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

        lista.add(new Pergunta(
            "Matemática",
            null,
            Dificuldade.MEDIO,
            "Qual é a raiz quadrada de 144?",
            Arrays.asList("11", "12", "13", "14"),
            1,
            null,
            Tipo.NORMAL
        ));

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

        lista.add(new Pergunta(
            "História",
            null,
            Dificuldade.DIFICIL,
            "Quem foi o primeiro presidente do Brasil?",
            Arrays.asList("Deodoro da Fonseca", "Getúlio Vargas", "Dom Pedro II", "Prudente de Morais"),
            0,
            null,
            Tipo.NORMAL
        ));

        lista.add(new Pergunta(
            "Matemática",
            null,
            Dificuldade.DIFICIL,
            "Existem 5 regras de Integração",
            Arrays.asList("Sim", "Não"),
            0,
            null,
            Tipo.TRUE_FALSE
        ));

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

        lista.add(new Pergunta(
            "Ciência",
            null,
            Dificuldade.MEDIO,
            "Qual é a velocidade da luz no vácuo?",
            Arrays.asList("300.000 km/s", "150.000 km/s", "450.000 km/s", "600.000 km/s"),
            0,
            null,
            Tipo.NORMAL
        ));

        lista.add(new Pergunta(
            "Tecnologia",
            null,
            Dificuldade.MEDIO,
            "Qual linguagem de programação foi criada por James Gosling?",
            Arrays.asList("Python", "Java", "C++", "JavaScript"),
            1,
            null,
            Tipo.NORMAL
        ));

        lista.add(new Pergunta(
            "Geografia",
            null,
            Dificuldade.DIFICIL,
            "Qual é o menor país do mundo?",
            Arrays.asList("Mônaco", "Nauru", "Vaticano", "San Marino"),
            2,
            null,
            Tipo.NORMAL
        ));

        lista.add(new Pergunta(
            "História",
            null,
            Dificuldade.DIFICIL,
            "Em que ano o homem pisou na Lua pela primeira vez?",
            Arrays.asList("1965", "1969", "1972", "1958"),
            1,
            null,
            Tipo.NORMAL
        ));

        lista.add(new Pergunta(
            "Games",
            null,
            Dificuldade.MEDIO,
            "Qual empresa desenvolveu o jogo Fortnite?",
            Arrays.asList("EA Games", "Ubisoft", "Epic Games", "Activision"),
            2,
            null,
            Tipo.NORMAL
        ));

        lista.add(new Pergunta(
            "Esportes",
            null,
            Dificuldade.MEDIO,
            "Quantas vezes o Brasil ganhou a Copa do Mundo?",
            Arrays.asList("4", "5", "6", "7"),
            1,
            null,
            Tipo.NORMAL
        ));

        lista.add(new Pergunta(
            "Literatura",
            null,
            Dificuldade.DIFICIL,
            "Qual destes NÃO é um livro de Machado de Assis?",
            Arrays.asList("Dom Casmurro", "Memórias Póstumas", "O Alienista", "Iracema"),
            3,
            null,
            Tipo.NORMAL
        ));

        lista.add(new Pergunta(
            "Ciência",
            null,
            Dificuldade.EXTREMA,
            "Qual é a fórmula química da água oxigenada?",
            Arrays.asList("H2O", "HO2", "H2O2", "HO"),
            2,
            null,
            Tipo.NORMAL
        ));

        lista.add(new Pergunta(
            "Cultura Geral",
            null,
            Dificuldade.MEDIO,
            "Qual é a capital da Austrália?",
            Arrays.asList("Sydney", "Melbourne", "Canberra", "Brisbane"),
            2,
            null,
            Tipo.NORMAL
        ));

        lista.add(new Pergunta(
            "Tecnologia",
            null,
            Dificuldade.DIFICIL,
            "Qual foi o primeiro smartphone com sistema Android?",
            Arrays.asList("HTC Dream", "Samsung Galaxy S", "Motorola Droid", "Google Nexus One"),
            0,
            null,
            Tipo.NORMAL
        ));
        
        lista.add(new Pergunta(
        	    "Ciência",
        	    null,
        	    Dificuldade.MEDIO,
        	    "Qual é o órgão responsável pela produção de insulina no corpo humano?",
        	    Arrays.asList("Fígado", "Pâncreas", "Rim", "Estômago"),
        	    1,
        	    null,
        	    Tipo.NORMAL
        	));

        	lista.add(new Pergunta(
        	    "Geografia",
        	    null,
        	    Dificuldade.FACIL,
        	    "Qual é a capital do Japão?",
        	    Arrays.asList("Seul", "Pequim", "Tóquio", "Bangkok"),
        	    2,
        	    null,
        	    Tipo.NORMAL
        	));

        	lista.add(new Pergunta(
        	    "Literatura",
        	    null,
        	    Dificuldade.MEDIO,
        	    "Quem é o autor do livro 'O Pequeno Príncipe'?",
        	    Arrays.asList("Antoine de Saint-Exupéry", "Jules Verne", "Victor Hugo", "Albert Camus"),
        	    0,
        	    null,
        	    Tipo.NORMAL
        	));

        	lista.add(new Pergunta(
        	    "História",
        	    null,
        	    Dificuldade.DIFICIL,
        	    "Qual foi o nome da nave que levou o homem à Lua em 1969?",
        	    Arrays.asList("Apollo 11", "Sputnik", "Challenger", "Columbia"),
        	    0,
        	    null,
        	    Tipo.NORMAL
        	));

        	lista.add(new Pergunta(
        	    "Matemática",
        	    null,
        	    Dificuldade.EXTREMA,
        	    "Qual é o valor de Euler (e) arredondado para três casas decimais?",
        	    Arrays.asList("2.718", "3.141", "1.618", "2.414"),
        	    0,
        	    null,
        	    Tipo.NORMAL
        	));

        	lista.add(new Pergunta(
        	    "Tecnologia",
        	    null,
        	    Dificuldade.MEDIO,
        	    "Qual dessas empresas é conhecida por criar o processador Ryzen?",
        	    Arrays.asList("Intel", "AMD", "NVIDIA", "Qualcomm"),
        	    1,
        	    null,
        	    Tipo.NORMAL
        	));
        	
        	lista.add(new Pergunta(
        		    "Astronomia",
        		    null,
        		    Dificuldade.MEDIO,
        		    "Qual é o maior planeta do sistema solar?",
        		    Arrays.asList("Júpiter", "Saturno", "Netuno", "Marte"),
        		    0,
        		    null,
        		    Tipo.NORMAL
        		));

        		lista.add(new Pergunta(
        		    "Literatura",
        		    null,
        		    Dificuldade.DIFICIL,
        		    "Quem escreveu 'Cem Anos de Solidão'?",
        		    Arrays.asList("Gabriel García Márquez", "Pablo Neruda", "Mario Vargas Llosa", "Jorge Luis Borges"),
        		    0,
        		    null,
        		    Tipo.NORMAL
        		));

        		lista.add(new Pergunta(
        		    "Ciência",
        		    null,
        		    Dificuldade.FACIL,
        		    "Qual é o símbolo químico do ouro?",
        		    Arrays.asList("Au", "Ag", "Fe", "Pb"),
        		    0,
        		    null,
        		    Tipo.NORMAL
        		));

        		lista.add(new Pergunta(
        		    "Esportes",
        		    null,
        		    Dificuldade.MEDIO,
        		    "Em que país foram realizados os Jogos Olímpicos de 2016?",
        		    Arrays.asList("China", "Reino Unido", "Brasil", "Rússia"),
        		    2,
        		    null,
        		    Tipo.NORMAL
        		));

        		lista.add(new Pergunta(
        		    "Tecnologia",
        		    null,
        		    Dificuldade.DIFICIL,
        		    "Qual linguagem é mais usada para desenvolvimento de apps iOS?",
        		    Arrays.asList("Java", "Swift", "Kotlin", "Python"),
        		    1,
        		    null,
        		    Tipo.NORMAL
        		));

        		lista.add(new Pergunta(
        		    "Cultura Geral",
        		    null,
        		    Dificuldade.FACIL,
        		    "O que significa a sigla UNESCO?",
        		    Arrays.asList(
        		    	    "<html><div style='font-family: \"Minecraftia 2.0\"; font-size:10pt;'>Organização das Nações Unidas para a<br>Educação, Ciência e Cultura</div></html>",
        		    	    "<html><div style='font-family: \"Minecraftia 2.0\"; font-size:10pt;'>União Nacional dos Estudantes Sociais e Científicos</div></html>",
        		    	    "<html><div style='font-family: \"Minecraftia 2.0\"; font-size:10pt;'>União das Nações para a Educação e Cultura</div></html>",
        		    	    "<html><div style='font-family: \"Minecraftia 2.0\"; font-size:10pt;'>Organização das Nações Unidas para a Segurança e Comércio</div></html>"
        		    	),
        		    0,
        		    null,
        		    Tipo.NORMAL
        		));

        		lista.add(new Pergunta(
        		    "Matemática",
        		    null,
        		    Dificuldade.MEDIO,
        		    "Qual é o resultado da operação 7!?",
        		    Arrays.asList("5040", "720", "120", "40320"),
        		    0,
        		    null,
        		    Tipo.NORMAL
        		));

        		lista.add(new Pergunta(
        		    "Biologia",
        		    null,
        		    Dificuldade.FACIL,
        		    "O corpo humano tem 4 pulmões.",
        		    Arrays.asList("Sim", "Não"),
        		    1,
        		    null,
        		    Tipo.TRUE_FALSE
        		));

        		lista.add(new Pergunta(
        		    "História",
        		    null,
        		    Dificuldade.DIFICIL,
        		    "Quem liderou a Revolução Russa de 1917?",
        		    Arrays.asList("Joseph Stalin", "Vladimir Lenin", "Leon Trotsky", "Nicolau II"),
        		    1,
        		    null,
        		    Tipo.NORMAL
        		));

        		lista.add(new Pergunta(
        		    "Filmes",
        		    null,
        		    Dificuldade.MEDIO,
        		    "Qual filme apresenta o personagem 'Forrest Gump'?",
        		    Arrays.asList("A Espera de um Milagre", "Forrest Gump", "Clube da Luta", "O Resgate do Soldado Ryan"),
        		    1,
        		    null,
        		    Tipo.NORMAL
        		));

        return lista;
    }
    
    public static List<Pergunta> getPerguntas() {
        return perguntas;
    }

    public static void adicionarPergunta(Pergunta nova) {
        perguntas.add(nova);
    }
}