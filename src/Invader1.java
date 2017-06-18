import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;

/**
 * 
 * @author Marc Herrmann
 */
public class Invader1 extends BasicElement implements Invader{
    private int vida;
    public Invader1(int px,int py){
        super(px,py);
        this.vida = 10;
    }
    
    @Override
    public void start(){
        setDirH(1);
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
    public void Update(){
        if (jaColidiu()){
            vida--;
            if(vida == 0){
                deactivate();
            }
        }else{
            setPosX(getX() + getDirH() * getSpeed());
            // Se chegou no lado direito da tela ...
            if (getX() >= getLMaxH()){
                // anda para a esquerda ...
                setPosX(getLMaxH());
                setDirH(-1);
                // Sorteia o passo de avanço [1,5]
                setSpeed(Params.getInstance().nextInt(5)+1);
            } // se chegou no lado esquerdo ....
            if(getX() <= getLMinH()){
                // anda para a direita
                setPosX(getLMinH());
                setDirH(1);
                setSpeed(Params.getInstance().nextInt(5)+1);
            }    
            
        }
    }    
    
    public void Draw(GraphicsContext graphicsContext){
        graphicsContext.setFill(Paint.valueOf("#0000FF"));
        graphicsContext.fillOval(getX(), getY(), 32, 32);
    }    
}


