
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;


public class Invader3 extends BasicElement implements Invader {
    private boolean olhoAberto;
    private int pisca;
    private int atira;

    public Invader3(int px, int py) {
        super(px, py);
    }

    @Override
    public void start() {
        setDirH(1);
        pisca = 0;
        olhoAberto = true;
        atira = 0;
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
            // Logica dos olhos
            pisca++;
            if (pisca == 30){
                olhoAberto = !olhoAberto;
                pisca = 0;
            }
            // Logica da posicao
            setPosX(getX() + getDirH() * getSpeed());
            // Se chegou no lado direito da tela ...
            if (getX() >= getLMaxH()) {
                // Reposiciona no lado esquerdo e ...
                setPosX(getLMaxH() - 1);
                setDirH(-1);
                int oldY = getY();
                setPosY(oldY + 20);
            } else if (getX() <= getLMinH()) {
                setPosX(getLMinH() + 1);
                setDirH(1);
                int oldY = getY();
                setPosY(oldY + 20);
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
        graphicsContext.setFill(Paint.valueOf("#0000FF"));
        graphicsContext.fillRect(getX(), getY() + 16, 32, 16);
        graphicsContext.setFill(Paint.valueOf("#FF00FF"));
        graphicsContext.fillOval(getX(), getY(), 16, 16);
        graphicsContext.fillOval(getX() + 16, getY(), 16, 16);
        if (olhoAberto) {
            graphicsContext.setFill(Paint.valueOf("#000000"));
            graphicsContext.fillOval(getX(), getY(), 8, 8);
            graphicsContext.fillOval(getX() + 16, getY(), 8, 8);
        }
    }
}
