import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Paint;

/**
 * 
 * @author Marc Herrmann
 */
public class Invader2 extends BasicElement implements Invader{
    public Invader2(int px,int py){
        super(px,py);
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
            deactivate();
        }else{
            setPosX(getX() + getDirH() * getSpeed());
            // Se chegou no lado direito da tela ...
            if (getX() >= getLMaxH()){
                // desce uma linha e
                // anda para a esquerda ...
                setPosX(getLMaxH());
                setLargAlt(0,getAltura()+ 80);
                setPosY(getAltura());
                setDirH(-1);
                
            } // se chegou no lado esquerdo ....
            if(getX() <= getLMinH()){
                // desce uma linha e 
                // anda para a direita
                setPosX(getLMinH());
                setLargAlt(0,getAltura()+ 50);
                setPosY(getAltura());
                setDirH(1);
               
            }    
            
        }
    }    
    
    public void Draw(GraphicsContext graphicsContext){
        graphicsContext.setFill(Paint.valueOf("#0000FF"));
        graphicsContext.fillOval(getX(), getY(), 32, 32);
    }    
}



