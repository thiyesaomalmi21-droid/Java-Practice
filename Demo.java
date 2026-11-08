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
        setLocation(0,100);
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
        setLocation(300,100);
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
        setLocation(600,100);
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
        setLocation(900,100);
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
    JPanel bottomPanel;
    JTextField field;
    WaterLevelDetector[] devicesArray=new WaterLevelDetector[0];
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
        
        bottomPanel=new JPanel();
        field=new JTextField(20);
        
        bottomPanel.add(field);
        add("South",bottomPanel);
        
        
        slider.addChangeListener(event -> {
                if( ! slider.getValueIsAdjusting()){
                    addWaterLevel(slider.getValue());
                }
            
        });

        setVisible(true);
        
    }
    public void addWaterLevel(int waterLevel){
        for(WaterLevelDetector device : devicesArray){
            device.update(waterLevel);
        }
    }
    public void extendArray(){
        if(devicesArray.length==0){
            WaterLevelDetector[] temp=new WaterLevelDetector[devicesArray.length+1];
            devicesArray=temp;
        }else if(devicesArray.length>0){
            WaterLevelDetector[] temp=new WaterLevelDetector[devicesArray.length+1];
            for(int i=0;i<devicesArray.length;i++){
                temp[i]=devicesArray[i];
            }
           
            devicesArray=temp;
        }
    }
    public void addDevice(WaterLevelDetector device){
        extendArray();
        devicesArray[devicesArray.length-1]=device;
    }

    
    
}

class Demo{
    public static void main(String args[]){
        ControllRoom c1=new ControllRoom();
        c1.addDevice(new Alarm());
        c1.addDevice(new Splitter());
        c1.addDevice(new Display());
        c1.addDevice(new SmsSender());
    }
}
