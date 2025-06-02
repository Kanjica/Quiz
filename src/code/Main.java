package code;
// primeiro commit
import javax.swing.*;

import java.awt.*;
import java.io.IOException;
import java.util.stream.Collectors;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FontFormatException, IOException {
        //Font fonteTitulo = CarregarFonte.carregarFonte("/font/Perfect Delight 1992.otf", 64f);
        //Font fonteClose = CarregarFonte.carregarFonte("/font/SpecialExit.ttf", 12f);
        //Font fontePadrao = CarregarFonte.carregarFonte("/font/Minecraftia-Regular.ttf", 12f);
	    
        //Usar UIManager.put("");
	    
        CarregarFonte.registrarFonte("/font/Perfect Delight 1992.otf");//64
        CarregarFonte.registrarFonte("/font/SpecialExit.ttf");//12
        CarregarFonte.registrarFonte("/font/Minecraftia-Regular.ttf");//12
        //Perfect Delight 1992 SpecialExit
        Font fonteTitulo = CarregarFonte.obterFonte("Perfect Delight 1992", 64f);
        Font fonteClose = CarregarFonte.obterFonte("SpecialExit", 20f);
        Font fontePadrao = CarregarFonte.obterFonte("Minecraftia 2.0", 20f);
        fonteTitulo = fontePadrao;

        JFrame window = new JFrame();
        window.setSize(580, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.setResizable(false);
        window.setTitle("Quiz Game");
        window.setUndecorated(true);
        // Ícone da janela
        window.setIconImage(new ImageIcon(Main.class.getResource("/images/8-bit-graphics-pixels-scene-with-nature.jpg")).getImage());
        
        JButton close = new JButton("X");
        close.setFont(fonteClose);
        close.setMargin(new Insets(1,1,1,1));
        close.setFocusPainted(false);
        close.setBorderPainted(false);
        close.setContentAreaFilled(false);
        close.setBorderPainted(false);
        close.setOpaque(false);
        close.setForeground(Color.WHITE);
        close.setBounds(540, 5, 30, 30);
        close.addActionListener(e -> System.exit(0));   
        close.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent evt){
                close.setForeground(Color.RED);
            }

            public void mouseExited(MouseEvent evt){
                close.setForeground(Color.WHITE);
            }
        });

        // Painel principal
        Image backgroundImage = new ImageIcon(Main.class.getResource("/images/8-bit-graphics-pixels-scene-with-nature.jpg")).getImage();
        BackgroundPanel quiz = new BackgroundPanel(backgroundImage);
        quiz.setPreferredSize(new Dimension(580, 400));
        quiz.setLayout(null);

        JLabel quizDoMariz = new JLabel("<html><center>"
        	    + "<b>Quiz do Mariz</b><br>"
        	    + "<span style='font-size:36pt;'>Mariz do Quiz</span>"
        	    + "</center></html>");
        
                quizDoMariz.setFont(fontePadrao);
        JLabel bordaQuizDoMariz = adicionarTituloComBorda(quiz, quizDoMariz, Color.black);
        
        System.out.println(quizDoMariz.getLocation() + "\n" + bordaQuizDoMariz.getLocation());

        quizDoMariz.setHorizontalAlignment(SwingConstants.CENTER);
        quizDoMariz.setFont(fonteTitulo);
        
        int larguraPainel = 580;
        int larguraTitulo = 300;
        int posX = (larguraPainel - larguraTitulo) / 2;
        
        quizDoMariz.setBounds(posX, 40, larguraTitulo, 100);
        quizDoMariz.setForeground(Color.WHITE);
        
        //setas
        
        ImageIcon setaIcon = new ImageIcon(Main.class.getResource("/images/seta.png.png"));
        Image setaRedimensionada = setaIcon.getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);
        setaIcon = new ImageIcon(setaRedimensionada);
        
        JLabel setaLabel = new JLabel(setaIcon);

        ImageIcon setaIconOriginal = new ImageIcon(Main.class.getResource("/images/setaVoltar.png"));
        Image setaRedimensionadaa = setaIconOriginal.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon setaIconm = new ImageIcon(setaRedimensionadaa);

        JButton setaButton = new JButton(setaIconm);
        setaButton.setVisible(false);

        //jbutons
        
        JButton start_tradicional = criarBotao (" Iniciar ",fontePadrao, setaLabel);
        JButton instructions_sobrevivencia = criarBotao(" Dicas ", fontePadrao, setaLabel);
        JButton settings_trueFalse = criarBotao(" Ajustes ", fontePadrao, setaLabel);
        JButton exit_mix = criarBotao(" Sair ", fontePadrao, setaLabel);
        
        //ButtonGroup botoesIniciais = new ButtonGroup();
       
        start_tradicional.setLocation(220,180);
        instructions_sobrevivencia.setLocation(220,225);
        settings_trueFalse.setLocation(220,270);
        exit_mix.setLocation(220,315);
        
        ActionListener modoDeJogoListener = e -> {
            JButton botaoClicado = (JButton) e.getSource();

            if (botaoClicado.getText().trim().equals("Iniciar")) {
                Timer timer = new Timer(5, null);
                final int[] x = {220, posX}; 
                final boolean[] cont = {true};
                setaLabel.setVisible(false);

                timer.addActionListener(ev -> {
                    x[0] += 5;
                    x[1] += 5;

                    quizDoMariz.setLocation(x[1], 40);

                    botaoClicado.setLocation(x[0], 180);
                    instructions_sobrevivencia.setLocation(x[0], 225);
                    settings_trueFalse.setLocation(x[0], 270);
                    exit_mix.setLocation(x[0], 315);

                    if (x[0] >= 580 && cont[0]) {
                        x[0] = -120;
                        cont[0] = false;

                        botaoClicado.setText(" Desafio ");
                        instructions_sobrevivencia.setText(" Tema Especifico");
                        settings_trueFalse.setText(" Personalidade ");
                        exit_mix.setVisible(false);
                    }

                    if (x[0] == 220 && !cont[0]) {
                        setaLabel.setVisible(true);
                        setaButton.setVisible(true);
                        timer.stop();
                        window.revalidate();
                    }

                    if (x[1] >= 500) {
                        x[1] = -180;
                        quizDoMariz.setText("Modos de Jogo");
                    }
                });

                timer.start();
            } else {
                trocarPraModoDeJogo(window, botaoClicado, fontePadrao, quizDoMariz,
                                    start_tradicional, instructions_sobrevivencia,
                                    settings_trueFalse, exit_mix);
                window.revalidate();
                window.repaint();
            }
        };

        start_tradicional.addActionListener(modoDeJogoListener);
        instructions_sobrevivencia.addActionListener(modoDeJogoListener);
        settings_trueFalse.addActionListener(modoDeJogoListener);
        
        exit_mix.addActionListener(e -> {
        	
        	if(exit_mix.getText().equals(" Sair ")) System.exit(1);
        });
        
        //setaVoltar 

        setaButton.setBorderPainted(false);
        setaButton.setContentAreaFilled(false);
        setaButton.setFocusPainted(false);
        setaButton.setOpaque(false);
        setaButton.setBounds(-25, -25, 100, 100); 
        
        setaButton.addActionListener(e -> {
            Timer timer = new Timer(5, null); 
            final int[] x = {220, posX}; 
            final boolean[] cont = {true};
            setaLabel.setVisible(false);
            
            timer.addActionListener(ev -> {
                x[0] -= 5;
                x[1] -= 5;
                
                quizDoMariz.setLocation(x[1], 40);
                bordaQuizDoMariz.setLocation(x[1]+2, 40+2);
                
                start_tradicional.setLocation(x[0], 180); 
                instructions_sobrevivencia.setLocation(x[0],225);
                settings_trueFalse.setLocation(x[0],270);
                exit_mix.setLocation(x[0],315);
                
                if (x[0] <= -240 && cont[0]) {
                	x[0]= 580;
                    cont[0] = false;
                	
                	start_tradicional.setText(" Iniciar ");
                	instructions_sobrevivencia.setText(" Dicas ");
                	settings_trueFalse.setText(" Ajustes ");
                	exit_mix.setText(" Sair ");
                    exit_mix.setVisible(true);
                    setaButton.setVisible(false);
                }
                
                if(x[0] == 220 && cont[0]==false ) {
                	setaLabel.setVisible(true);
                	timer.stop();
                	window.revalidate();
                }
                
                if(x[1] <= -240 ) {
                	x[1]= 580;
                	quizDoMariz.setText("Quiz do Mariz");
                	bordaQuizDoMariz.setText("Mariz do Quiz");
                    quizDoMariz.setLocation(x[1], 40);
                }
                
                
            });

            timer.start();
        });

        quiz.add(quizDoMariz);
        quiz.add(start_tradicional);
        quiz.add(close);
        quiz.add(setaButton);
        quiz.add(instructions_sobrevivencia);
        quiz.add(settings_trueFalse);
        quiz.add(exit_mix);
        
        quiz.add(setaLabel);
        
        window.setContentPane(quiz);
        window.pack(); // ajusta a janela ao tamanho preferido do painel
        window.setVisible(true);
        
    }
    
    
    public static JLabel adicionarTituloComBorda(JPanel painel, JLabel titulo, Color corBorda){
        JLabel borda = new JLabel(titulo.getText());
        borda.setFont(titulo.getFont());
        borda.setBounds(titulo.getX() + 2, titulo.getY() + 2, titulo.getWidth(), titulo.getHeight());
        
        borda.setForeground(corBorda);
        borda.setHorizontalAlignment(titulo.getHorizontalAlignment());
        
        titulo.setForeground(Color.black);
        borda.setForeground(Color.black);
        painel.add(borda);   // borda vem antes
        painel.add(titulo);  // título por cima
        
        titulo.setVisible(true);
        borda.setVisible(true);
        return borda;
    }


    public static JButton criarBotao(String texto, Font fontePadrao, JLabel setaLabel){
    	JButton botao = new JButton(texto);
        botao.setFont(fontePadrao.deriveFont(16f));
        botao.setSize(150,40);
        botao.setBackground(new Color(30, 30, 30));
        botao.setFocusPainted(false);
        botao.setForeground(Color.WHITE);
        botao.setOpaque(false);
        botao.setMargin(new Insets(1,1,1,1));
        
        botao.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent evt){
            	botao.setForeground(Color.RED);
            	if(setaLabel!=null) {setaLabel.setVisible(true);
            	setaLabel.setBounds(80, botao.getY()-30, 120, 100);
            	}
            }

            public void mouseExited(MouseEvent evt){
            	botao.setForeground(Color.WHITE);
            	if(setaLabel!=null)setaLabel.setVisible(false);
            }
        });
		return botao;
    }

    public static void trocarPraModoDeJogo(JFrame window, JButton botao, Font fontPadrao, JLabel quizDoMariz, 
    									JButton btnA, JButton btnB, JButton btnC, JButton btnD) {
    	
    	
    	if(!botao.getText().trim().equals("Desafio")) {
    	
            //JPanel x = new JPanel ();
            Image backgroundImageX = new ImageIcon(Main.class.getResource("/images/wallpapersden.com_stargazing-hd-pixel-art_1920x1080.jpg")).getImage();
            BackgroundPanel x = new BackgroundPanel(backgroundImageX);

            x.setPreferredSize(new Dimension(510, 350));
            x.setLayout(null);
            x.setVisible(true);
            x.setOpaque(false);
            //x.setBounds(30,30, 510, 350);
            x.setBounds(0,0, 580, 400);
         // x.setBackground(new Color(0,0,0,0));
            List<String> temas = BancoDePerguntas.carregarPerguntasPadrao()
                    .stream()
                    .map(Pergunta::getTema)
                    .distinct()
                    .collect(Collectors.toList());

            int larguraPainel = 580;
            int larguraTitulo = 300;
            int posX = (larguraPainel - larguraTitulo) / 2;
        
            JLabel novoTitulo = new JLabel();
            novoTitulo.setHorizontalAlignment(SwingConstants.CENTER);
            //novoTitulo.setFont(new Font("Perfect Delight 1992",Font.PLAIN, 64));
            novoTitulo.setFont(new Font("Minecraftia 2.0",Font.PLAIN, 20));
            novoTitulo.setBounds(posX, 10, larguraTitulo, 100);
            novoTitulo.setForeground(Color.WHITE);
            //novoTitulo.setForeground(Color.BLACK);
            novoTitulo.setText("Escolha os temas");
            novoTitulo.setVisible(true);
            x.add(novoTitulo);
            x.revalidate();
            x.repaint();

            System.out.println("novo titulo bounds: " + novoTitulo.getLocation());
            System.out.println("titulo original bounds: " + quizDoMariz.getLocation());
            
            List<JCheckBox> temaCheckBox = new ArrayList<>();
            JButton prosseguir;
            prosseguir = criarBotao(" Prosseguir ", fontPadrao, null);
            
            moverPraDireita(botao, window, null, null, 
            null, btnA, btnB, btnC, btnD, quizDoMariz, x);
            
            Timer removeBotao = new Timer(660, new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    quizDoMariz.setBounds(posX, 60, larguraTitulo, 100);
                    
                    quizDoMariz.setVisible(true);
                    novoTitulo.setVisible(true);

                    quizDoMariz.setText(" Temas Disponíveis ");
                    /*window.remove(btnA);
                    window.remove(btnB);
                    window.remove(btnC);
                    window.remove(btnD);*/
                    btnA.setVisible(false);
                    btnB.setVisible(false);
                    btnC.setVisible(false);
                    btnD.setVisible(false);


                    ((Timer) e.getSource()).stop();
                }
            });
            removeBotao.start();


            int coordenadaX = 50;
            int coordenadaY = 80;
            Font fontePadrao = CarregarFonte.obterFonte("Minecraftia 2.0", 20f);
            for(int i=0; i<temas.size(); i++) {

                temaCheckBox.add(new JCheckBox(temas.get(i)));
                x.add(temaCheckBox.get(i));
                temaCheckBox.get(i).setFont(fontePadrao.deriveFont(12f));
                temaCheckBox.get(i).setMargin(new Insets(2, 2, 2, 2));
                temaCheckBox.get(i).setFocusPainted(false);
                temaCheckBox.get(i).setContentAreaFilled(true); // pinta o fundo
                //temaCheckBox.get(i).setBackground(Color.DARK_GRAY);
                temaCheckBox.get(i).setOpaque(false);
                temaCheckBox.get(i).setForeground(Color.WHITE);
                //temaCheckBox.get(i).setForeground(Color.BLACK);
                temaCheckBox.get(i).setVisible(true);
                temaCheckBox.get(i).setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.GRAY),                // borda visível
                        BorderFactory.createEmptyBorder(0, 10, 0, 0)               // padding interno (margem da esquerda)
                    ));
                temaCheckBox.get(i).setHorizontalTextPosition(SwingConstants.RIGHT);
                temaCheckBox.get(i).setHorizontalAlignment(SwingConstants.LEFT); 

                int coluna = i % 3;
                int linha = i / 3;
                int baseX = 60; 
                int baseY = 150; 
                int espacamentoX = 160;
                int espacamentoY = 30;

                coordenadaX = baseX + coluna * espacamentoX;
                coordenadaY = baseY + linha * espacamentoY;

                temaCheckBox.get(i).setBounds(coordenadaX, coordenadaY, 150, 20);
            }
            
            
            prosseguir.setForeground(Color.WHITE);
            prosseguir.setBounds(230,320,150,60);
            prosseguir.setVisible(true);
            x.add(prosseguir);
            x.revalidate();
            x.repaint();
            
            window.getContentPane().add(x);
            window.getContentPane().setComponentZOrder(x, 0); // 0 = frente

            //window.setContentPane(x);
            window.revalidate();
            window.repaint();
            
            temas.clear();
            
            prosseguir.addActionListener(e -> {
                for(int i=0; i<temaCheckBox.size();i++) {
                    if(temaCheckBox.get(i).isSelected()) {
                        temas.add(temaCheckBox.get(i).getText());
                        System.out.println(temaCheckBox.get(i).getText());
                    }
                    else {
                        System.out.println(temaCheckBox.get(i).getText() + " n selecionada");
                    }
                }
                
                System.out.println(temas.size()); 
                if(!temas.isEmpty()) {
                
                    JPanel sldf = new ModosDeJogo(botao.getText().trim(), temas);
                    
                    //if(botao.getText().trim().equals("Desafio"))
                        moverPraDireita(botao, window, sldf, null, null,
                            btnA,btnB,btnC,btnD, quizDoMariz, null);
                    //window.setContentPane(sldf);
                    window.revalidate();
                    window.repaint();		
                }
                else {
                    JOptionPane.showMessageDialog(null, "Você precisa selecionar pelo menos 1 tema, seu Adotado do krl.");
                    return;
                }
                
            });
		
    	}
    	else {
    		JPanel sldf = new ModosDeJogo(botao.getText().trim(), null);
    		moverPraDireita(botao, window, sldf, null, null,
					btnA,btnB,btnC,btnD, quizDoMariz, null);
			//window.setContentPane(sldf);
			window.revalidate();
			window.repaint();
    	}
    }
    
    public static void moverPraDireita(JButton botaoQueAtivou, JFrame window, JPanel sldf, JLabel setaLabel,JButton setaButton, 
    									JButton btnA, JButton btnB, JButton btnC, JButton btnD, JLabel quizDoMariz,JPanel xx) {
		 int larguraPainel = 580;
		 int larguraTitulo = 300;
		 int posX = (larguraPainel - larguraTitulo) / 2;
		 
		 String textoTitulo = "", 
				textoA = "", 
				textoB = "",  
				textoC = "",  
				textoD = "";
		 
		 String[] a = {"Desafio", "Temas Especificos", "Personalidade"};
		 
    	if(botaoQueAtivou.getText().trim().equals("Iniciar")) {
    		textoTitulo = " Modos de Jogo ";
    		textoA = " Desafio ";
    		textoB = " Temas Especificos ";
    		textoC = " Personalidade "; 
    	}
    	
    	else if(botaoQueAtivou.getText().trim().equals("Dicas")) {
    		
    	}
    	
    	else if(botaoQueAtivou.getText().trim().equals("Ajustes")) {
    		
    	}
    	
    	else if(botaoQueAtivou.getText().trim().equals("Temas Especificos")) {
    		textoTitulo = " Temas Disponiveis ";
    	}
    	
    	else if(botaoQueAtivou.getText().trim().equals("Personalidade")) {
    		textoTitulo = " Personalidades ";
    	}
    	final String[] textos = {textoTitulo, textoA, textoB, textoC, textoD}; // [titulo, A, B, C, D]

    	if (sldf != null) {
    	    sldf.setLocation(-580, 0); // começa fora da tela à esquerda
    	    sldf.setSize(580, window.getHeight()); // ajusta o tamanho pra cobrir a tela toda
    	    sldf.setOpaque(true);
    	    
    	    window.getLayeredPane().add(sldf, JLayeredPane.POPUP_LAYER); // camada sobreposta
    	}

    	Timer timer = new Timer(5, null); 
        final int[] x = {220, posX}; 
        final boolean[] cont = {true};
        if(setaLabel!=null)setaLabel.setVisible(false);
        
        timer.addActionListener(ev -> {
            x[0] += 5;
            x[1] += 5;
            
            quizDoMariz.setLocation(x[1], 40);
            //bordaQuizDoMariz.setLocation(x[1]+2, 40+2);
            if(sldf!=null)if(sldf.getX()!=0 )sldf.setLocation((sldf.getX()+5), 0);
            
            btnA.setLocation(x[0], 180); // desliza pra direita
            btnB.setLocation(x[0],225);
            btnC.setLocation(x[0],270);
            btnD.setLocation(x[0],315);
            
            if (x[0] >= 580 && cont[0]) {
            	x[0]= -120;
            	cont[0] = false;
            	
            	SwingUtilities.invokeLater(() -> {
                    btnA.setText(textos[1]);
                    btnB.setText(textos[2]);
                    btnC.setText(textos[3]);
                    btnD.setText(textos[4]);
                    
                    if(botaoQueAtivou.getText().trim().equals("Iniciar")) {
                		btnD.setVisible(false);
                	}
                	
                	else if(botaoQueAtivou.getText().trim().equals("Dicas")) {
                		
                	}
                	
                	else if(botaoQueAtivou.getText().trim().equals("Ajustes")) {
                		
                	}
                	
                	else if(botaoQueAtivou.getText().trim().equals("Desafio")) {
                	
                	}
                    
                	else if(botaoQueAtivou.getText().trim().equals("Temas Especificos")) {
                		btnA.setVisible(false);
                		btnB.setVisible(false); 
                		btnC.setVisible(false);
                		btnD.setVisible(false);
                	}
                	
                	else if(botaoQueAtivou.getText().trim().equals("Personalidade")) {
                		btnA.setVisible(false);
                		btnB.setVisible(false); 
                		btnC.setVisible(false);
                		btnD.setVisible(false);
                	}
                    
                    if (xx != null) {
                    	xx.setVisible(true);                    
                    }

                });
            }
            
            if(x[0] == 220 && cont[0]==false ) {
            	if(setaLabel!=null) {
	            	setaLabel.setVisible(true);
	                setaButton.setVisible(true);
            	}
            	timer.stop();
            	window.revalidate();
            }
            
            if(x[1] >= 500) {
            	x[1]= -180;
            	
            	SwingUtilities.invokeLater(() ->{
                    quizDoMariz.setVisible(true);
            		quizDoMariz.setText(textos[0]);
                    System.out.println(quizDoMariz.isVisible());
                    System.out.println(quizDoMariz.getLocation());
                    System.out.println(textos[0]);
            	});
            	//bordaQuizDoMariz.setText("Modos de Jogo");
            }
            
            
        });

        timer.start();
        
	       /* if(sldf!=null) {
	        	window.getContentPane().add(sldf);
	        	//window.setContentPane(sldf);
	        }*/
		window.revalidate();
		window.repaint();
	//}
    
    }


	public static JButton getClose() {
		Font fonteClose = null;
		
			fonteClose = CarregarFonte.obterFonte("Minecraftia 2.0", 20f);
			
		JButton close = new JButton("X");
        close.setFont(fonteClose);
        close.setMargin(new Insets(1,1,1,1));
        close.setFocusPainted(false);
        close.setBorderPainted(false);
        close.setContentAreaFilled(false);
        close.setBorderPainted(false);
        close.setOpaque(false);
        close.setForeground(Color.WHITE);
        close.setBounds(540, 5, 30, 30);
        close.addActionListener(e -> System.exit(0));   
        close.addMouseListener(new MouseAdapter(){
            public void mouseEntered(MouseEvent evt){
                close.setForeground(Color.RED);
            }

            public void mouseExited(MouseEvent evt){
                close.setForeground(Color.WHITE);
            }
        });
		return close;
	}
}
