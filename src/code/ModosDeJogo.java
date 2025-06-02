package code;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.stream.Collectors;
import java.util.*;
import javax.swing.Timer;
import java.io.IOException;

/*
sugestões do chat

botaoDica.setBounds(500, 345, 70, 25);
progressBar.setBounds(90, 95, 400, 15);
botaoProxima.setBounds(220, 240, 140, 40);
temaLabel.setBounds(90, 80, 400, 15);
botaoProxima.setBounds(220, 240, 140, 40);
acertosLabel.setBounds(100, 20, 80, 30);  // Acertos
errosLabel.setBounds(100, 55, 80, 30);   // Erros

coisas pra add:
Tela pra escolher os temas, no modo tema fixo
e o mesmo pra escolher qual personalidade no modo personalidade

Pontuação (exibição dos pontos acumulados).

Imagem/Avatar do jogador para personalização.

Nível de dificuldade mostrado dinamicamente.
*/

public class ModosDeJogo extends JPanel{
    private List<Pergunta> perguntas = new ArrayList<>();
    private List<Pergunta> perguntasFiltradas = new ArrayList<>();
    private static int cont = 0;
    private Image backgroundImage;
    private int perguntasRespondidas;
    static int valorTempoRestante = 15;
    static JLabel tempoRestante = new JLabel("");
    static boolean perguntaRespondida;
    private List<Image> backgroundsImages = new ArrayList<>();
    //private Image[] hearts = new Image[2];
    
    JLabel h1, h2,h3;
    JLabel areaTitulo, frase;
    //JLabel acertos, erros,placar;
    int numAcertos, numErros, vidas = 3;
    JTextArea enunciado;
    List<JButton> opcoes;
    JProgressBar progressBar;
    ImageIcon fullHeartIcon, unFullHeartIcon;

    public ModosDeJogo(String texto, List<String> temas){
        
        Font fontePadrao = null;
       // try{
        	// Registra a fonte uma vez no início do programa
        	//CarregarFonte.registrarFonte("/font/Minecraftia-Regular.ttf");

        	fontePadrao = CarregarFonte.obterFonte("Minecraftia 2.0", 20f);
       // }
       // catch (FontFormatException e){
        //    System.out.println("Erro ao carregar a fonte: " + e.getMessage());
       // } catch (IOException e){
      //      System.out.println("Erro de I/O: " + e.getMessage());
      //  }
        perguntas = BancoDePerguntas.getPerguntas();
        
        this.backgroundImage = new ImageIcon(Main.class.getResource("/images/WpAa5DjgQIWRiDafdfVu-_Qwz0E0ajlea0NxvgcbjepRMJo-Z1G5Tlsf3ZWfSQnsr1BIDOpO1SZpoI2seM8HQLARBmHYpgfEtkjT.gif")).getImage();

        this.backgroundsImages.add(new ImageIcon(Main.class.getResource("/images/WpAa5DjgQIWRiDafdfVu-_Qwz0E0ajlea0NxvgcbjepRMJo-Z1G5Tlsf3ZWfSQnsr1BIDOpO1SZpoI2seM8HQLARBmHYpgfEtkjT.gif")).getImage());
        this.backgroundsImages.add(new ImageIcon(Main.class.getResource("/images/ckp5gcuzv7581.gif")).getImage());
        this.backgroundsImages.add(new ImageIcon(Main.class.getResource("/images/download.gif")).getImage());
        this.backgroundsImages.add(new ImageIcon(Main.class.getResource("/images/ffa96ede4039820cdac1185df70b8dc7.gif")).getImage());
        this.backgroundsImages.add(new ImageIcon(Main.class.getResource("/images/giphy.gif")).getImage());
        this.backgroundsImages.add(new ImageIcon(Main.class.getResource("/images/quiz-background.jpg")).getImage());

        //this.hearts[0] = new ImageIcon(Main.class.getResource("/images/coracaoCheio.jpg")).getImage();
        //this.hearts[1] = new ImageIcon(Main.class.getResource("/images/coracaoVazio.jpg")).getImage();
        /* 
        Timer trocaFundo = new Timer(10000, new ActionListener() {
            private int indexImagem = 0;
        
            @Override
            public void actionPerformed(ActionEvent e) {
                indexImagem = (indexImagem + 1) % backgroundsImages.size();
                backgroundImage = backgroundsImages.get(indexImagem);
                repaint(); // Redesenha o painel com a nova imagem
            }
        });
        trocaFundo.start();
        */
        this.areaTitulo = new JLabel("Tema: - Nível:", SwingConstants.CENTER);
        areaTitulo.setFont(fontePadrao.deriveFont(14f));
        areaTitulo.setBounds(270/2, 3, 300, 20);
        areaTitulo.setForeground(Color.WHITE);
        areaTitulo.setVisible(true);
        add(areaTitulo);
        
        this.frase = new JLabel("");
        frase.setBounds(330/2, 480, 250, 40);
        frase.setText("Bananas são azuis");
        frase.setVisible(true);
        add(frase);
        
        System.out.println("Local Frase" + frase.getLocation() + "Is visible" + frase.isVisible());
        
        this.enunciado = new JTextArea();
        enunciado.setBounds(90, 30, 400, 90); // centralizado horizontalmente
        //enunciado.setHorizontalAlignment(JTextField.CENTER);
        enunciado.setLineWrap(true); 
        enunciado.setWrapStyleWord(true);
        enunciado.setFont(fontePadrao.deriveFont(14f));
        enunciado.setEditable(false);
        enunciado.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        enunciado.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        enunciado.setMargin(new Insets(15,15,15,15));
        
        this.tempoRestante.setBounds(10, 10, 80, 80);
        Font currentFont = tempoRestante.getFont();
        Font newFont = currentFont.deriveFont(24f); // Tamanho 24
        tempoRestante.setFont(newFont);
        tempoRestante.setVisible(true);
        tempoRestante.setForeground(Color.WHITE);
        //System.out.println(tempoRestante.getLocation());
        
        add(tempoRestante);
        
        this.fullHeartIcon = new ImageIcon(Main.class.getResource("/images/coracaoCheio.png"));
        Image fullHeartRedimensionada = fullHeartIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        fullHeartIcon = new ImageIcon(fullHeartRedimensionada);
        
        this.unFullHeartIcon = new ImageIcon(Main.class.getResource("/images/coracaoVazio.png"));
        Image unFullHeartRedimensionada = unFullHeartIcon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        unFullHeartIcon = new ImageIcon(unFullHeartRedimensionada);
        
        this.h1 = new JLabel(fullHeartIcon);
        this.h2 = new JLabel(fullHeartIcon);
        this.h3 = new JLabel(fullHeartIcon);
        
        h1.setBounds(506, 35, 20, 20);
        h2.setBounds(526, 35, 20, 20);
        h3.setBounds(546, 35, 20, 20);
        
        add(h1);
        add(h2);
        add(h3);
        
        add(Main.getClose());
        /*
        this.numAcertos = 0;
        
        this.acertos = new JLabel(String.valueOf(numAcertos));
        acertos.setBounds(520, 10, 80, 80);
        acertos.setFont(newFont);
        acertos.setVisible(true);
        acertos.setForeground(Color.GREEN);
        //add(acertos);
        
        this.numErros = 0;
        
        this.erros = new JLabel(String.valueOf(numErros));
        erros.setBounds(540, 10, 80, 80);
        erros.setFont(newFont);
        erros.setVisible(true);
        erros.setForeground(Color.RED);
        add(erros);
        */
        
        this.opcoes = new ArrayList<>();
        for(int i = 0; i<4; i++){
        	opcoes.add(Main.criarBotao("", fontePadrao, null));
        }
        
        for (JButton botao : opcoes) {
            botao.setFont(fontePadrao.deriveFont(14f)); 
            botao.setMargin(opcoes.get(0).getInsets());
        }

        opcoes.get(0).setBounds(30, 170, 250, 80);  
        opcoes.get(1).setBounds(300, 170, 250, 80);
        opcoes.get(2).setBounds(30, 260, 250, 80);
        opcoes.get(3).setBounds(300, 260, 250, 80);

        this.setPreferredSize(new Dimension(580, 400));
        this.setLayout(null);
        this.setVisible(true);
        
            //perguntas.stream().forEach(System.out::println);
        if(temas!=null) {
        	perguntasFiltradas = perguntas.stream()
        			.filter(n -> n.getTipo() != Tipo.PERSONALIDADE)
        			.filter(n -> temas.contains(n.getTema()))
        			.collect(Collectors.toList());
                    Collections.shuffle(perguntasFiltradas);
        }
        else {/* 
        	perguntasFiltradas = perguntas.stream().filter(n -> n.getNivel() == Dificuldade.FACIL)
        			.filter(n -> n.getTipo() != Tipo.PERSONALIDADE)
        			.collect(Collectors.toList())
                    */
            perguntasFiltradas = perguntas.stream()
                    .filter(n -> n.getTipo() != Tipo.PERSONALIDADE)
                    .collect(Collectors.toList());

            Collections.shuffle(perguntasFiltradas);
        }
        perguntasFiltradas.sort(Comparator.comparing(p -> p.getNivel()));
            
        
        final Timer[] swingTimerRef = new Timer[1];
        
        ActionListener bananuchi = e -> {
            perguntaRespondida = true;

            JButton botaoClicado = (JButton) e.getSource();
            Pergunta pergunta = perguntaDaVez(false);
            
            int indiceCorreto = pergunta.getIndiceRespostaCorreta();
            String respostaCorreta = pergunta.getAlternativas().get(indiceCorreto).trim();

            boolean acertou = false;
            if(pergunta.getTipo() != Tipo.TRUE_FALSE){
            	acertou = botaoClicado.getText().trim().equalsIgnoreCase(respostaCorreta);
            }
            else{
            	if((botaoClicado.getText().trim().equalsIgnoreCase("Sim") && indiceCorreto == 0) || botaoClicado.getText().trim().equalsIgnoreCase("Nao") && indiceCorreto == 1){
            		acertou = true;
            	}
            }
            botaoClicado.setFocusPainted(true);
            botaoClicado.setOpaque(true);
            
            if(acertou){
                botaoClicado.setBackground(Color.GREEN);
                System.out.println("Resposta Certa: " + respostaCorreta);
                numAcertos++;
                //acertos.setText(String.valueOf(numAcertos));
            }
            else{
            	vidas--;
                botaoClicado.setBackground(Color.RED);
                System.out.println("Resposta Selecionada: " + botaoClicado.getText().trim() + " Resposta Certa: " + respostaCorreta);
                //numErros++;
                //erros.setText(String.valueOf(numErros));
                opcoes.get(indiceCorreto).setBackground(Color.GREEN);
            }
            
            atualizarVidas();
            for (JButton botao : opcoes){
	            	botao.setEnabled(false);
	        }
            
            perguntasRespondidas++;
            progressBar.setValue(perguntasRespondidas);
            
            if(perguntasRespondidas%3 == 0){
                backgroundImage = backgroundsImages.get(new Random().nextInt(backgroundsImages.size()));
                repaint();
            }
            
            if(valorTempoRestante>5)valorTempoRestante = 3;
            new Timer(5000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    ((Timer) evt.getSource()).stop(); 
                    swingTimerRef[0].restart();       
                    swingTimerRef[0].getActionListeners()[0].actionPerformed(null); 
                }
            }).start();
        };
        
        for (JButton botao : opcoes) {
            botao.addActionListener(bananuchi);
        } 
        
        this.progressBar = new JProgressBar();
        progressBar.setBounds( 110, 125, 360, 15);  
        progressBar.setMaximum(perguntasFiltradas.size()); 
        progressBar.setForeground(Color.GREEN);
        progressBar.setValue(0); 
        progressBar.setStringPainted(true);
        //progressBar.setString(perguntasRespondidas + "/" + perguntasFiltradas.size());
        add(progressBar);
        
        swingTimerRef[0] = new Timer(17000, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
            	if(perguntasRespondidas < perguntasFiltradas.size() && vidas != 0){
            		valorTempoRestante = 15;
            		
            		
            		new Timer(1000, new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent evt){
                            tempoRestante.setText(String.valueOf(valorTempoRestante));
                            if(valorTempoRestante == 0 && perguntaRespondida==false){
                    			vidas--;
                    			atualizarVidas();
                    			System.out.println("Vidas: " + vidas );
                    		}
                    		
                    		System.out.println("Valor tempo restante: " + valorTempoRestante + "\n Estado da pergunta: " + (perguntaRespondida == true? "Respondida" : "Não Respondida"));
                            if(valorTempoRestante == 0){
                            	((Timer) evt.getSource()).stop(); 
                            }
                            else {
                            	valorTempoRestante--;
                            }
                        }
                    }).start();
            		
            		
            		attPerguntas();
                    /*
                    if(!perguntaRespondida){
                    	valorTempoRestante = 5;
                        new Timer(5000, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                ((Timer) evt.getSource()).stop(); 
                                swingTimerRef[0].restart();       
                                swingTimerRef[0].getActionListeners()[0].actionPerformed(null); 
                            }
                        }).start();
                        Pergunta xl = perguntaDaVez(false);
                        for (JButton botao : opcoes) {
                            String resposta = botao.getText().trim();
                            String correta = xl.getAlternativas().get(xl.getIndiceRespostaCorreta()).trim();
                    
                            if (resposta.equalsIgnoreCase(correta)) {
                                botao.setBackground(Color.GREEN);
                            } 
                            else {
                                botao.setBackground(Color.RED);
                            }
                    
                            botao.setEnabled(false);
                        }
                    
                        perguntasRespondidas++;
                        progressBar.setValue(perguntasRespondidas);
                    }                    
                    */ 
            	}
            	else {
            		swingTimerRef[0].stop();
            		int porcentagem = cont>3?(numAcertos * 100) / cont: (numAcertos * 100) / perguntasFiltradas.size();

            		// Cria mensagem fácil de entender
            		String mensagem = 
            		    "Fim do Quiz!\n\n" +
            		    "Você acertou: " + numAcertos + " de " + (cont>3? cont: perguntasFiltradas.size())  + "\n" +
            		    "Porcentagem: " + porcentagem + "%";
            		
            		Object[] opcoes = {"Jogar Novamente", "Voltar ao Menu", "Sair"};

            		int escolha = JOptionPane.showOptionDialog(
            		    null,
            		    mensagem,
            		    "Resultado Final",
            		    JOptionPane.DEFAULT_OPTION,
            		    JOptionPane.PLAIN_MESSAGE,
            		    new ImageIcon(fullHeartRedimensionada), 
            		    opcoes,
            		    opcoes[0]
            		);   
            		
            		
            		if(escolha == 0){
            		    //reiniciarQuiz(); 
            			System.exit(0);
            		} 
            		else if(escolha == 1){
            		   // voltarAoMenu();
            			System.exit(0);
            		} 
            		else{
            		    System.exit(0); // Sair
            		}
            	}
            }
        });

        swingTimerRef[0].start();
        swingTimerRef[0].getActionListeners()[0].actionPerformed(null);

    this.add(enunciado);
    for(JButton z: opcoes){
    	this.add(z);
    	}
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

    }
    
    public Pergunta perguntaDaVez(boolean a){
    	if(a){
    		if(cont >= perguntasFiltradas.size()){
    			cont = 0;
    		}
    		return perguntasFiltradas.get(cont++);
    	}
    	else{
    		return perguntasFiltradas.get(cont - 1);
    	}
    }
    
    public void attPerguntas(){
        valorTempoRestante = 15;
    	perguntaRespondida=false;

    	for(JButton botao : opcoes){
    		botao.setEnabled(true);
    		botao.setFocusPainted(false);
    		botao.setForeground(Color.WHITE);
    		botao.setBackground(Color.BLACK);
    		botao.setOpaque(true);
    		botao.setBackground(new Color(30, 30, 30));
    	}
    	
    	Pergunta pergunta = perguntaDaVez(true);
    	Dificuldade n = pergunta.getNivel();
    	areaTitulo.setText("Tema: " + pergunta.getTema() + " - Nível: " + n.toString());
    	enunciado.setText(pergunta.getEnunciado());
    	progressBar.setForeground(n == Dificuldade.FACIL? Color.GREEN: 
    								n == Dificuldade.MEDIO? Color.YELLOW:
    									n == Dificuldade.DIFICIL? Color.RED : 
    										Color.decode("#8B0000"));
    	opcoes.get(0).setVisible(true);
    	opcoes.get(1).setVisible(true);
    	
    	if(pergunta.getTipo() == Tipo.TRUE_FALSE){
    		opcoes.get(0).setText(" Sim ");
    		opcoes.get(1).setText(" Não ");
    		opcoes.get(2).setVisible(false);
    		opcoes.get(3).setVisible(false);
    	} 
    	else{
    		opcoes.get(2).setVisible(true);
    		opcoes.get(3).setVisible(true);
    		
    		opcoes.get(0).setText(pergunta.getAlternativas().get(0));
    		opcoes.get(1).setText(pergunta.getAlternativas().get(1));
    		opcoes.get(2).setText(pergunta.getAlternativas().get(2));
    		opcoes.get(3).setText(pergunta.getAlternativas().get(3));
    		
    	}
    	for(JButton a: opcoes){
    		if(a.getText().length()>22){
    			//a.setFont(a.getFont().deriveFont(8f));
    		}
    		else {
    			a.setFont(a.getFont().deriveFont(14f));
    		}
    	}
    }
    
    public void atualizarVidas(){
        this.h1.setIcon(vidas >= 1 ? fullHeartIcon : unFullHeartIcon);
        this.h2.setIcon(vidas >= 2 ? fullHeartIcon : unFullHeartIcon);
        this.h3.setIcon(vidas >= 3 ? fullHeartIcon : unFullHeartIcon);
        
        repaint();
    }
    
    public int returnAction() {
    	return 0;
    }

}
