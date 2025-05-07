package quizz;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class CarregarFonte {
    
    // Método para carregar uma fonte
    public static Font carregarFonte(String caminhoDaFonte, float tamanho) throws FontFormatException, IOException {
        Font fontePadrao = Font.createFont(Font.TRUETYPE_FONT, 
        Main.class.getResourceAsStream(caminhoDaFonte))
        .deriveFont(Font.PLAIN, tamanho);

        return fontePadrao;  // Retorna a fonte carregada
    }
}