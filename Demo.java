import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class ControllRoom extends JFrame{
    JSlider slider;
    ControllRoom(){
        setSize(300,300);
        setTitle("Controll Room");
        setLocationRelativeTo(null);
        JLabel label1=new JLabel("WaterLevel Detector",JLabel.CENTER);
        add("North",label1);
        JPanel panel=new JPanel();
        slider=new JSlider(JSlider.VERTICAL,0,100,50);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        panel.add(slider);
        add("Center",panel);
        
        
        String x="0";
        slider.addChangeListener(event -> {
                if( ! slider.getValueIsAdjusting()){
                    addWaterLevel(slider.getValue());
                }
            
        });
        JLabel label2=new JLabel(x);
        add("South",label2);
        
        setVisible(true);
        
    }
    public void addWaterLevel(int waterLevel){
        System.out.println(waterLevel);
    }
    
    
}

class Demo{
    public static void main(String args[]){
        ControllRoom c1=new ControllRoom();
    }
}
