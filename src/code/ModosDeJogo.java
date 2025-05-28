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

Efeitos visuais e sonoros para tornar a experiência mais imersiva.*/

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
    
    JTextField enunciado;
    List<JButton> opcoes;
    JProgressBar progressBar;

    public ModosDeJogo(String texto, List<String> temas){
        
        Font fontePadrao = null;
        try{
        fontePadrao = CarregarFonte.carregarFonte("/font/Minecraft.ttf",14f);
        }
        catch (FontFormatException e) {
            System.out.println("Erro ao carregar a fonte: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro de I/O: " + e.getMessage());
        }
        perguntas = BancoDePerguntas.getPerguntas();
        
        this.backgroundImage = new ImageIcon(Main.class.getResource("/images/WpAa5DjgQIWRiDafdfVu-_Qwz0E0ajlea0NxvgcbjepRMJo-Z1G5Tlsf3ZWfSQnsr1BIDOpO1SZpoI2seM8HQLARBmHYpgfEtkjT.gif")).getImage();


        this.backgroundsImages.add(new ImageIcon(Main.class.getResource("/images/WpAa5DjgQIWRiDafdfVu-_Qwz0E0ajlea0NxvgcbjepRMJo-Z1G5Tlsf3ZWfSQnsr1BIDOpO1SZpoI2seM8HQLARBmHYpgfEtkjT.gif")).getImage());
        this.backgroundsImages.add(new ImageIcon(Main.class.getResource("/images/ckp5gcuzv7581.gif")).getImage());
        this.backgroundsImages.add(new ImageIcon(Main.class.getResource("/images/download.gif")).getImage());
        this.backgroundsImages.add(new ImageIcon(Main.class.getResource("/images/ffa96ede4039820cdac1185df70b8dc7.gif")).getImage());
        this.backgroundsImages.add(new ImageIcon(Main.class.getResource("/images/giphy.gif")).getImage());
        this.backgroundsImages.add(new ImageIcon(Main.class.getResource("/images/quiz-background.jpg")).getImage());

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
        
        this.enunciado = new JTextField();
        enunciado.setBounds(90, 30, 400, 60); // centralizado horizontalmente
        enunciado.setHorizontalAlignment(JTextField.CENTER);
        enunciado.setFont(fontePadrao);
        enunciado.setEditable(false);
        
        this.tempoRestante.setBounds(10, 10, 80, 80);
        Font currentFont = tempoRestante.getFont();
        Font newFont = currentFont.deriveFont(24f); // Tamanho 24
        tempoRestante.setFont(newFont);
        tempoRestante.setVisible(true);
        
        tempoRestante.setForeground(Color.WHITE);
        System.out.println(tempoRestante.getLocation());
        
        add(tempoRestante);
        
        this.opcoes = new ArrayList<>();
        for(int i = 0; i<4; i++){
        	opcoes.add(Main.criarBotao("", fontePadrao, null));
        }
        
        for (JButton botao : opcoes) {
            botao.setFont(fontePadrao.deriveFont(20f)); 
        }

        opcoes.get(0).setBounds(30, 140, 250, 80);  
        opcoes.get(1).setBounds(300, 140, 250, 80);
        opcoes.get(2).setBounds(30, 230, 250, 80);
        opcoes.get(3).setBounds(300, 230, 250, 80);

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

            perguntasFiltradas.sort(Comparator.comparing(p -> p.getNivel()));
        }
            
        
        final Timer[] swingTimerRef = new Timer[1];
        
        ActionListener bananuchi = e -> {

            perguntaRespondida = true;

            JButton botaoClicado = (JButton) e.getSource();
            Pergunta pergunta = perguntaDaVez(false);
            
            int indiceCorreto = pergunta.getIndiceRespostaCorreta();
            String respostaCorreta = pergunta.getAlternativas().get(indiceCorreto).trim();

            boolean acertou = false;
            if(pergunta.getTipo() != Tipo.TRUE_FALSE) {
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
            }else{
                botaoClicado.setBackground(Color.RED);
                System.out.println("Resposta Selecionada: " + botaoClicado.getText().trim() + " Resposta Certa: " + respostaCorreta);
            }

            for (JButton botao : opcoes) {
	            	botao.setEnabled(false);
	        }
            
            perguntasRespondidas++;
            progressBar.setValue(perguntasRespondidas);
            
            if(perguntasRespondidas%3 == 0){
                backgroundImage = backgroundsImages.get(new Random().nextInt(backgroundsImages.size()));
                repaint();
            }
            
            if(valorTempoRestante>5)valorTempoRestante = 5;
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
        progressBar.setBounds( 110, 95, 360, 15);  
        progressBar.setMaximum(perguntasFiltradas.size()); 
        progressBar.setForeground(Color.GREEN);
        progressBar.setValue(0); 
        progressBar.setStringPainted(true);
        //progressBar.setString(perguntasRespondidas + "/" + perguntasFiltradas.size());
        add(progressBar);
        
        swingTimerRef[0] = new Timer(15000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(perguntasRespondidas < perguntasFiltradas.size()) {
            		valorTempoRestante = 15;
            		
            		new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            tempoRestante.setText(String.valueOf(valorTempoRestante));
                            if (valorTempoRestante == 0) {
                            	((Timer) evt.getSource()).stop(); 
                            }
                            else {
                            	valorTempoRestante--;
                            }
                        }
                    }).start();
            		
            		attPerguntas();
                    /* 
                    if (!perguntaRespondida) {
                        Pergunta xl = perguntaDaVez(false);
                        for (JButton botao : opcoes) {
                            String resposta = botao.getText().trim();
                            String correta = xl.getAlternativas().get(xl.getIndiceRespostaCorreta()).trim();
                    
                            if (resposta.equalsIgnoreCase(correta)) {
                                botao.setBackground(Color.GREEN);
                            } else {
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
            		JOptionPane.showMessageDialog(null, "Quiz concluído!");
            		System.exit(1);            	
            		}
            }
        });

        swingTimerRef[0].start();
        swingTimerRef[0].getActionListeners()[0].actionPerformed(null);

    this.add(enunciado);
    for(JButton z: opcoes) {
    	this.add(z);
    	}
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Desenha a imagem no fundo
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

    	for (JButton botao : opcoes) {
    		botao.setEnabled(true);
    		botao.setFocusPainted(false);
    		botao.setForeground(Color.WHITE);
    		botao.setBackground(Color.BLACK);
		botao.setOpaque(true);
    		botao.setBackground(new Color(30, 30, 30));
    	}
    	
    	Pergunta pergunta = perguntaDaVez(true);
    	enunciado.setText(pergunta.getEnunciado());
    	
    	opcoes.get(0).setVisible(true);
    	opcoes.get(1).setVisible(true);
    	
    	if (pergunta.getTipo() == Tipo.TRUE_FALSE){
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
    }
    
    public int returnAction() {
    	return 0;
    }
/*
    private void construirLayoutBase(Font fontePadrao) {
        // Cria enunciado
        enunciado = new JTextField();
        enunciado.setBounds(90, 30, 400, 60);
        enunciado.setHorizontalAlignment(JTextField.CENTER);
        enunciado.setFont(fontePadrao);
        enunciado.setEditable(false);
        this.add(enunciado);
    
        // Cria botões
        for (int i = 0; i < 4; i++) {
            JButton botao = Main.criarBotao("", fontePadrao, null);
            botao.setFont(fontePadrao.deriveFont(20f));
            opcoes.add(botao);
            this.add(botao);
        }
    
        opcoes.get(0).setBounds(100, 120, 200, 50);
        opcoes.get(1).setBounds(320, 120, 200, 50);
        opcoes.get(2).setBounds(100, 180, 200, 50);
        opcoes.get(3).setBounds(320, 180, 200, 50);
    
        // Barra de progresso
        progressBar = new JProgressBar();
        progressBar.setBounds(90, 300, 400, 20);
        progressBar.setStringPainted(true);
        this.add(progressBar);
    }
*/
}
