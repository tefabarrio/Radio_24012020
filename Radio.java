/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Estefania Barrio
 */
public class Radio implements NewInterface{
    boolean estado=false;
    String[] estacion={"0"};
    boolean amFm=true;
    String[] arrayFM={"","","","","","","","","","","",""};
    String[] arrayAM={"","","","","","","","","","","",""};
    @Override
    public boolean estado(){
        return estado;
    }
    @Override
    public void onOff(){
        if(estado==true){
            estado=false;
        }
        else{
            estado=true;
        }
    } 
    public void setEstacion(String radio){
        estacion[0]=radio;
    }
    public void setFrecuencia(boolean x){
        amFm=x;
    }
    
    @Override
    public String estacionActual(){
        String nradio=estacion[0];
        return nradio;
    }
    public boolean getFrecuencia(){
        return amFm;
    }
    @Override
    public void avanzar(){
        //am is true
        if(amFm==true){
            int r;
            r=Integer.parseInt(estacion[0]);
            if(r<1610){
                r=r+10;    
            }
            else{
                r=530;
            }
            estacion[0]=Integer.toString(r);
        }
        else if(amFm==false) {
            float r;
            r=Float.parseFloat(estacion[0]);
            double l=107.9;
            if(r<l){
                r=r+(float)0.2;    
            }
            else{
                r=(float)87.9;
            }
            estacion[0]=Float.toString(r);
            
        }
     
    }
    public void cambiarFrecuencia(){
        if(amFm==true){
            amFm=false;   
        }
        else if(amFm==false){
            amFm=true;
        } 
    }
    @Override
    public void guardar(int boton){
        if(amFm==true){
            arrayAM[(boton-1)]=estacion[0];
        }
        else{
            arrayFM[(boton-1)]=estacion[0];
        }
    }
    public void seleccionarEmisora(int boton){
        if(amFm==true){
            estacion[0]=arrayAM[(boton-1)];
        }
        else{
            estacion[0]=arrayFM[(boton-1)];
        }
    }    
    
}
    
    
    

