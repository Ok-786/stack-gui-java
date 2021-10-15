
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author osama
 */

class Stack
{
    int top=-1;
    int size=0;
    int[] arr;

    public Stack(int size)
    {
        arr= new int[size];
        this.size=size;

    }
    public void push(int value)
    {
        arr[++top] = value;
    }
    public int pop()
    {
        return arr[top--];
    }
    public int peek()
    {
        return arr[top];
    }
    public void reset()
    {
        top=-1;
    }
}

public class stackapplet extends JApplet
{
    Stack stackx;
    int size;
    JButton insert,resize,delete,reset,update;
    JPanel panel,stackpanelholder,stackpanel,buttonpanelholder,buttonpanel,labelpanel,labelpanelholder,buttonpanel1,buttonpanel2;
    JLabel empty,stackk,status,length,lastitem;
    JTextField statustxt,lengthtxt,lastitemtxt,insertitem,resizetxt,arr[];
    
    public void init()
    {
        
        setSize(480,300);
//        setLayout(new BorderLayout());
//        add(new Stack(), BorderLayout.CENTER);
        
        System.out.println("initialize");
        int size=Integer.parseInt(JOptionPane.showInputDialog("Enter size of stack:"));
        this.size=size;
        arr=new JTextField[size];
        
        buttonpanelholder = new JPanel();
        buttonpanel = new JPanel(new GridLayout(3,2,80,0));
        buttonpanel1=new JPanel(new GridLayout(1,2,1,0));
        buttonpanel2 = new JPanel(new GridLayout(1,2,1,0));
        stackpanelholder = new JPanel();
        stackpanel = new JPanel(new GridLayout(10000000,0,0,1));
        labelpanelholder = new JPanel();
        labelpanel = new JPanel(new GridLayout(3,2));
        panel = new JPanel(new BorderLayout());
        
        update = new JButton("Update");
//        update.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 3));
        update.setBorder(BorderFactory.createBevelBorder(1, Color.RED, Color.yellow));
        resize = new RoundButton("Resize Stack");
        resize.setBorder(BorderFactory.createMatteBorder(2, 5, 2, 5, Color.red));
        resizetxt = new JTextField(3);
        reset = new RoundButton("Reset");
        insert = new RoundButton("Insert Value");
        insertitem = new JTextField(3);
        delete = new RoundButton("Delete");
        
        
        buttonpanel1.add(resize);
        resizetxt.setText("Enter value");
        resizetxt.setHorizontalAlignment(JTextField.CENTER);
        resizetxt.setForeground(Color.LIGHT_GRAY);
        buttonpanel1.add(resizetxt);
        buttonpanel.add(buttonpanel1);
        
        buttonpanel.add(reset);
        buttonpanel2.add(insert);
        insertitem.setText("Enter value");
        insertitem.setHorizontalAlignment(JTextField.CENTER);
        insertitem.setForeground(Color.LIGHT_GRAY);
        buttonpanel2.add(insertitem);
        buttonpanel.add(buttonpanel2);
        
        buttonpanel.add(delete);
        
        buttonpanelholder.add(buttonpanel, new GridLayout());
        panel.add(buttonpanelholder, BorderLayout.BEFORE_FIRST_LINE);
        
        status = new JLabel("Status: ");
        length = new JLabel("Stack Length: ");
        lastitem = new JLabel("Last Item: ");
        empty=new JLabel("");
        statustxt = new JTextField();
        lengthtxt = new JTextField(1);
        lastitemtxt = new JTextField(1);
        
        statustxt.setEditable(false);
        statustxt.setForeground(Color.red);
        lengthtxt.setEditable(false);
        lastitemtxt.setEditable(false);
        
//        labelpanel.add(status);
//        labelpanel.add(statustxt);
        
        labelpanel.add(length);
        labelpanel.add(lengthtxt);
        
        labelpanel.add(lastitem);
        labelpanel.add(lastitemtxt);
        labelpanel.add(empty);
        labelpanel.add(update,5);
        labelpanelholder.add(labelpanel);
        
        panel.add(labelpanelholder,BorderLayout.LINE_START);
        
        statustxt.setText("Stack of size "+size+" is declared and is Empty!!");
        statustxt.setHorizontalAlignment(JTextField.CENTER);
        panel.add(statustxt,BorderLayout.SOUTH);
        
        lengthtxt.setText(Integer.toString(0));
        lengthtxt.setHorizontalAlignment(JTextField.CENTER);
        lastitemtxt.setText("Click Update");
        lastitemtxt.setForeground(Color.red);
        
        
        stackk = new JLabel("  STACK");
        stackpanel.add(stackk);
        for(int i=arr.length-1;i>=0;i--)
        {
            arr[i]=new JTextField(1);
            arr[i].setEditable(false);
            arr[i].setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.orange, Color.red, Color.blue));
            arr[i].setBackground(Color.gray);
            arr[i].setForeground(Color.WHITE);
            stackpanel.add(arr[i]);
            
        }
        
        
        stackpanelholder.add(stackpanel);
        
        panel.add(stackpanelholder,BorderLayout.EAST);
        
        add(panel);
        
        HandlerClass handler = new HandlerClass();
        insert.addActionListener(handler);
        delete.addActionListener(handler);
        update.addActionListener(handler);
        reset.addActionListener(handler);
        resize.addActionListener(handler);
        
    }
    
    private class HandlerClass  implements ActionListener
    {
        Stack stackx = new Stack(size);
       
       
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            
            
            if(e.getSource() == insert)
            {
                try
                {
                    
                    String value = insertitem.getText();
                    stackx.push(Integer.parseInt(value));

                    arr[stackx.top].setText(value);
                    arr[stackx.top].setHorizontalAlignment(JTextField.CENTER);
                    statustxt.setText("Element "+ (stackx.top+1) +" containing value "+value+" is inserted in the Stack!");
                    lengthtxt.setText(Integer.toString(stackx.top+1));
                    lengthtxt.setHorizontalAlignment(JTextField.CENTER);
                    lastitemtxt.setText("Click Update");
                    
                }
                catch(Exception ex)
                {
                    if(stackx.top>= size)
                    {
                        statustxt.setText("you cannot Enter as the stack is full resize it");
                    }
                    else
                        statustxt.setText("Insert valid value!");
                    
                }
            }
            
            if(e.getSource() == delete)
            {
                try
                {
                    statustxt.setText("Element "+(stackx.top+1)+" containing value "+arr[stackx.top].getText()+" is Deleted from the Stack!");
                    arr[stackx.top].setText("");
                    stackx.pop();
                    lengthtxt.setText(Integer.toString(stackx.top+1));
                    lengthtxt.setHorizontalAlignment(JTextField.CENTER);
                    lastitemtxt.setText("Click Update");
                }
                catch(Exception ex)
                {
                    statustxt.setText("You cannot delete as Stack is Empty");
                }
            }
            if(e.getSource() == reset)
            {
                try
                {
                    stackx.reset();
                    for(int i=arr.length-1;i>=0;i--)
                    {
                        arr[i].setText("");
                    }
                    statustxt.setText("Stack is resetted!");
                    lengthtxt.setText(Integer.toString(0));
                    lengthtxt.setHorizontalAlignment(JTextField.CENTER);
                    lastitemtxt.setText("Click Update");
                    stackx.top=-1;
                }
                catch(Exception ex)
                {
                    statustxt.setText("Stack is already empty");
                }
            }
            
            if(e.getSource() == update)
            {
                try
                {
                    lastitemtxt.setText(Integer.toString(stackx.peek()));
                    lastitemtxt.setHorizontalAlignment(JTextField.CENTER);
                }
                catch(Exception ex)
                {
                    statustxt.setText("Nothing to show as the Stack is empty ");
                }
            }
            
            if(e.getSource() == resize)
            {
                try
                {
                    statustxt.setText("The size of stack is changed to "+resizetxt.getText());
                    Stack stackx1=new Stack(Integer.parseInt(resizetxt.getText()));
                    for(int i=0; i<=stackx.top;i++)
                    {
                        stackx1.push(stackx.arr[i]);

                    } 

    //                panel.remove(arr[0]);
    //                panel.revalidate();
    //                panel.repaint();
                    JButton button = (JButton)e.getSource();
                    JPanel grandparent = (JPanel) button.getParent();
                    JPanel ggparent = (JPanel) grandparent.getParent();
                    JPanel gggparent = (JPanel) ggparent.getParent();
                    JPanel ggggparent = (JPanel) gggparent.getParent();
                    JPanel gf = (JPanel) ggggparent.getComponent(3);
                    JPanel jf=(JPanel) gf.getComponent(0);
//                    JLabel as=(JLabel) jf.getComponent(0);
                    jf.removeAll();
                    stackk = new JLabel("  STACK");
                    stackpanel.add(stackk);
                    JTextField[] arr1 = new JTextField[Integer.parseInt(resizetxt.getText())];
                    size=Integer.parseInt(resizetxt.getText());

                    for(int i=Integer.parseInt(resizetxt.getText())-1;i>=0;i--)
                    {

                        arr1[i]=new JTextField(1);
                        arr1[i].setEditable(false);
                        arr1[i].setBorder(BorderFactory.createBevelBorder(0, Color.green, Color.orange, Color.red, Color.blue));
                        arr1[i].setBackground(Color.gray);
                        arr1[i].setForeground(Color.WHITE);
                        arr1[i].setHorizontalAlignment(JTextField.CENTER);
                        jf.add(arr1[i]);

                    }

                    for( int i=0; i<Integer.parseInt(resizetxt.getText());i++)
                    {
    //                    stackx1.push(stackx.arr[i]);
                        if(i<=stackx.top)
                        arr1[i].setText(Integer.toString(stackx1.arr[i]));
                    }
                    arr=arr1;
    //                stackx.pop();
                    stackx =stackx1;
                    stackx.top=stackx1.top;
                    //Stack temp=new
    //                jf.removeAll();
                    jf.revalidate();
                    jf.repaint();
                }
            
                catch(Exception ex)
                {
                    statustxt.setText("Enter valid value");
                }
            
            }
        }
        
        
    }
    public class RoundButton extends JButton {
        public RoundButton(String label) {
          super(label);
          setContentAreaFilled(true);
        }

        protected void paintComponent(Graphics g) 
        {
           if (getModel().isArmed()) 
           {
               g.setColor(Color.blue);
           }
          else
          {
            g.setColor(getBackground());
          }

          super.paintComponent(g);
        }

        protected void paintBorder(Graphics g) 
        {
            
          g.setColor(getForeground());
          g.drawRoundRect(0,0,getSize().width-1,getSize().height,22,22);
          g.setColor(Color.red);
        }

        Shape shape;
        public boolean contains(int x, int y)
        {

          if (shape == null ||!shape.getBounds().equals(getBounds())) 
          {
            shape = new Ellipse2D.Double(0, 0,
              getSize().width,getSize().height);
            
          }
        return shape.contains(x, y);
        }
    }
      
    
    public void destroy()
    {
        System.out.println("destroy");
    }
    public void start()
    {
        System.out.println("start");
    }
    public void stop()
    {
        System.out.println("stop");
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
}