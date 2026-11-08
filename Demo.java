import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
interface WaterLevelDetector{
    public void update(int waterLevel);
}
class Alarm implements WaterLevelDetector{
    public void update(int waterLevel){
        
    }
}
class Display implements WaterLevelDetector{
    public void update(int waterLevel){
        
    }
}
class Splitter implements WaterLevelDetector{
    public void update(int waterLevel){
        
    }
}
class  SmsSender implements WaterLevelDetector{
    public void update(int waterLevel){
        
    }
}
class ControllRoom extends JFrame{
    JSlider slider;
    private WaterLevelDetector[] devicesArray={new Alarm(),new Splitter(),new Display(),new SmsSender()};
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
        for(WaterLevelDetector device : devicesArray){
            device.update(waterLevel);
        }
    }

    
    
}

class Demo{
    public static void main(String args[]){
        ControllRoom c1=new ControllRoom();
    }
}
