
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Marc Herrmann
 */
public class CompositeCharacter extends BasicElement{

    private List<Character> filhos;
    
    public CompositeCharacter() {
        this.filhos = new ArrayList<>();
    }

    @Override
    public void start() {
        for(Character c: filhos){
            c.start();
        }
    }

    @Override
    public void Update() {
        for(Character c: filhos){
            c.Update();
        }
    }
  
   

    @Override
    public void Draw(GraphicsContext graphicsContext) {
        for(Character c: filhos){
            c.Draw(graphicsContext);
        }
    }
    
    public void add(Character c){
        filhos.add(c);
    }
    
    public void remove(Character c){
        filhos.remove(c);
    }
    
    

}