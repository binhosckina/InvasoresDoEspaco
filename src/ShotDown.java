
/**
 *
 * @author Bernardo
 */
public class ShotDown extends Shot{
    public ShotDown(int px, int py) {
        super(px, py);
    }
    
    @Override
    public void start(){
        setDirV(1);
        setSpeed(2);
    }
    
     @Override
    public void testaColisao(Character outro){
       
        if (outro instanceof Shot || outro instanceof Invader){
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
            setPosY(getY() + getDirV() * getSpeed());
            // Se chegou na parte inferior da tela ...
            if (getY() >= getLMaxV()){
                // Desaparece
                deactivate();
            }
        }
    }    


    
}
