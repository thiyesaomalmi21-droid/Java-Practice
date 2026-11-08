import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
interface WaterLevelDetector{
    public void update(int waterLevel);
}
class Alarm extends JFrame implements WaterLevelDetector{
    JPanel centerPanel;
    JLabel label1;
    Alarm(){
        setSize(300,100);
        setLocationRelativeTo(null);
        centerPanel=new JPanel();
        label1=new JLabel("",JLabel.CENTER);
        centerPanel.add(label1);
        add("Center",centerPanel);
        setVisible(true);
        
    }
    public void update(int waterLevel){
        if(waterLevel >=50){
            label1.setText("Alarm On");
            centerPanel.setBackground(Color.RED);
        }else if(waterLevel<50){
            label1.setText("Alarm OFF");
            centerPanel.setBackground(Color.GREEN);
        }
        
    }
}
class Display extends JFrame implements WaterLevelDetector{
    JLabel label1;
    Display(){
        setSize(300,100);
        setLocationRelativeTo(null);
        JPanel centerPanel=new JPanel();
        label1=new JLabel("",JLabel.CENTER);
        centerPanel.add(label1);
        add("Center",centerPanel);
        setVisible(true);
        
    }
    public void update(int waterLevel){
        label1.setText("Current Water Level : "+waterLevel);
    }
}
class Splitter extends JFrame implements WaterLevelDetector{
    JPanel centerPanel;
    JLabel label1;
    Splitter(){
        setSize(300,100);
        setLocationRelativeTo(null);
        centerPanel=new JPanel();
        label1=new JLabel("",JLabel.CENTER);
        centerPanel.add(label1);
        add("Center",centerPanel);
        setVisible(true);
        
    }
    public void update(int waterLevel){
        if(waterLevel >=50){
            label1.setText("Splitter On");
            centerPanel.setBackground(Color.RED);
        }else if(waterLevel<50){
            label1.setText("Splitter OFF");
            centerPanel.setBackground(Color.GREEN);
        }
    }
}
class  SmsSender extends JFrame implements WaterLevelDetector{
    JLabel label1;
    SmsSender(){
        setSize(300,100);
        setLocationRelativeTo(null);
        JPanel centerPanel=new JPanel();
        label1=new JLabel("",JLabel.CENTER);
        centerPanel.add(label1);
        add("Center",centerPanel);
        setVisible(true);
        
    }
    public void update(int waterLevel){
        label1.setText("Sending SMS : "+waterLevel);
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
