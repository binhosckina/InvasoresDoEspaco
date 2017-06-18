/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 17180512
 */
public class SelecionaInvader {
    
    private static SelecionaInvader si = null;
    
    private SelecionaInvader(){
    }
    
    public static SelecionaInvader getInstance(){
        if(si == null){
            si = new SelecionaInvader();
        }
        return si;
    }
    
    public Invader criaInvader(int n){
        switch(n){
            case 1:
                return new Invader1(100, 300);
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                break;
        }
        return null;
    }
}
