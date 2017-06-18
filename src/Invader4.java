
import java.util.Random;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;


public class Invader4 extends BasicElement implements Invader {
    private boolean visivel;
    private int pisca;
    private int atira;
    private Random r;

    public Invader4(int px, int py) {
        super(px, py);
    }

    @Override
    public void start() {
        setDirH(1);
        pisca = 0;
        visivel = true;
        atira = 0;
        r = new Random();
    }
    
    @Override
    public void testaColisao(Character outro){
        // Não verifica colisão de um tiro com outro tiro
        if (outro instanceof Invader || outro instanceof ShotDown){
            return;
        }else{
            super.testaColisao(outro);
        }
    }

    @Override
    public void Update() {
        if (jaColidiu()) {
            deactivate();
        } else {
            // Logica do teleporte
            pisca++;
            if (pisca == 30){
                setPosX(r.nextInt(getLMaxH()));
                setPosY(r.nextInt(getLMaxV()));
                visivel = !visivel;
                pisca = 0;
            }
          
            // Logica do tiro
            atira++;
            if (atira == 100){
                Game.getInstance().addChar(new ShotDown(getX()+16,getY()+40));            
                atira = 0;
            }
        }
    }

    public void Draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(Paint.valueOf("#BB00FF"));
        graphicsContext.fillRect(getX(), getY() + 16, 32, 16);
        graphicsContext.setFill(Paint.valueOf("#FF00EE"));
        graphicsContext.fillOval(getX(), getY(), 16, 16);
        graphicsContext.fillOval(getX() + 16, getY(), 16, 16);
        if (visivel) {
            graphicsContext.setFill(Paint.valueOf("#000000"));
            graphicsContext.fillOval(getX(), getY(), 8, 8);
            graphicsContext.fillOval(getX() + 16, getY(), 8, 8);
        }
    }
}
