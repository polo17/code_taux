/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author pedago
 */
public class CodeDiscount {
    
    private char code;
    private float rate;
    
    public CodeDiscount(char code, float rate){
        
        this.code=code;
        this.rate=rate;
        
    }
    
    public char getCode() {
        return this.code;
    }
    
    public float getRate() {
        return this.rate;
    }
    
}
