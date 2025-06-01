package code;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

public class CarregarFonte {

    private static boolean fonteRegistrada = false;

    public static void registrarFonte(String caminhoDaFonte) throws FontFormatException, IOException {
        
            Font fonte = Font.createFont(Font.TRUETYPE_FONT,
            		Main.class.getResourceAsStream(caminhoDaFonte));
            
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(fonte);
            fonteRegistrada = true;
        
    }

    public static Font obterFonte(String nomeDaFonte, float tamanho) {
        return new Font(nomeDaFonte, Font.PLAIN, (int)tamanho);
    }
}
