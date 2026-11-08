import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
interface WaterLevelDetector{
    public void update(int waterLevel);
}
class Alarm extends JFrame implements WaterLevelDetector{
    JPanel centerPanel;
    JLabel label1;
    private String id;
    Alarm(String id){
        this.id=id;
        
        setSize(300,100);
        setLocation(0,100);
        
        setTitle("Alarm : "+id);
        
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
    private String id;
    Display(String id){
        this.id=id;
        setSize(300,100);
        setLocation(300,100);
        
        setTitle("Display : "+id);
        
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
    private String id;
    Splitter(String id){
        this.id=id;
        setSize(300,100);
        setLocation(600,100);
        
        setTitle("Splitter : "+id);
        
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
    private String id;
    SmsSender(String id){
        this.id=id;
        setSize(300,100);
        setLocation(900,100);
        
        setTitle("SMS Sender : "+id);
        
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
    JButton btn;
    WaterLevelDetector[] devicesArray=new WaterLevelDetector[0];
    ControllRoom(){
        setSize(400,400);
        setTitle("Controll Room");
        setLocationRelativeTo(null);
        JLabel label1=new JLabel("WaterLevel Detector",JLabel.CENTER);
        add("North",label1);
        JPanel panel=new JPanel();
        slider=new JSlider(JSlider.VERTICAL,0,100,50);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        panel.add(slider);
        add("Center",panel);
        
        bottomPanel=new JPanel(new GridLayout(1,2));
        JPanel btnPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel textPanel=new JPanel(new FlowLayout());
        
        field=new JTextField(13);
        field.setFont(new Font("",Font.BOLD,15));
        textPanel.add(field);
        btn=new JButton("Add device (ID)");
        btnPanel.add(btn);
        
        bottomPanel.add(textPanel);
        bottomPanel.add(btnPanel);
        add("South",bottomPanel);
        
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                detectingNewDevice(field.getText());
            }
        });
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
    public void detectingNewDevice(String id){
        String firstLetter=id.substring(0,1);
        if(firstLetter.equals("A")){
            addDevice(new Alarm(id));
        }else if(firstLetter.equals("D")){
            addDevice(new Display(id));
        }else if(firstLetter.equals("S")){
            String secondLetter=id.substring(1,2);
            if(secondLetter.equals("M")){
                addDevice(new SmsSender(id));
            }else if(secondLetter.equals("P")){
                addDevice(new Splitter(id));
            }
        }
    } 

}

class Demo{
    public static void main(String args[]){
        ControllRoom c1=new ControllRoom();
        c1.addDevice(new Alarm("A001"));
        c1.addDevice(new Splitter("SP001"));
        c1.addDevice(new Display("D001"));
        c1.addDevice(new SmsSender("SM001"));
    }
}
