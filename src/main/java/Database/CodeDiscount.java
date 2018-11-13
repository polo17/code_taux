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
    
    private String code;
    private float rate;
    
    public CodeDiscount(String code, float rate){
        
        this.code=code;
        this.rate=rate;
        
    }
    
    public String getCode() {
        return this.code;
    }
    
    public float getRate() {
        return this.rate;
    }
    
}
