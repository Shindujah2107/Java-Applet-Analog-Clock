/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.




/**
 *
 * @author ahari
 */
import java.applet.Applet; 
import java.awt.*; 

  
public class analogClock extends Applet implements Runnable { 
  int cx=475,cy=350,k=0,min=0,hr=0;
  
    @Override
    public void init() 
    { 
        Thread t=new Thread (this);
 t.start();
     setFont(new Font("Arial",Font.BOLD,50));
     setBackground(Color.WHITE);
    } 
  
   
    
    public void paint(Graphics g) 
    { 
       g.setColor(Color.blue);
       g.fillRect(900,500,20,20);
       g.drawRect(900,500,20,20);
       g.drawString("SECONDS",950,510);
       g.setColor(Color.black);
       g.fillRect(900, 570, 20, 20);
       g.drawRect(900, 570, 20, 20);
       g.drawString("MINUTES",950,600);
       
       g.setColor(Color.green);
       g.fillRect(900, 630, 20, 20);
       g.drawRect(900,630 , 20, 20);
       g.drawString("HOUR",950,670);
          
          g.setColor(Color.black);
          g.drawString("ANALOG CLOCK",100,100);
          g.drawOval(250,250,500,500);
          g.setColor(Color.red);
          g.drawString("12", 475, 300);
          g.drawString("7", 475, 745);
          g.drawString("3", 695, 520);
          g.drawString("9", 275, 520);
          g.drawString("10", 290-5, 410+15);
          g.drawString("11", 360+5, 340-5);
          g.drawString("2", 670, 410+15);
          g.drawString("1", 600, 340-5);
          g.drawString("5", 580, 700);
          g.drawString("4", 675, 625);
          g.drawString("6", 355, 700);
          g.drawString("8", 285, 625);
          g.setColor(Color.blue);
          g.drawArc(360,360,250,250,90,-k);
          g.setColor(Color.black);
           g.fillArc(415,415,170,170,90,-min);
            g.drawArc(415,415,170,170,90,-min); 

           g.setColor(Color.green);
           g.fillArc(445,445,110,110,90,-hr);
            g.drawArc(445,445,110,110,90,-hr); 
    } 

    @Override
    public void run() {
    while(true)
    {if(k>=360){
            k=0;
            min=min+6; }
            else
            k=k+6;
            if(min>=360)
            {
                min=0;
                hr=hr+6;
            }
            if(hr>=360)
                hr=0;
            
            try{
                Thread.sleep(30);
                
            }
            catch(Exception e)
            {}
            repaint();
        } 
        }
} 