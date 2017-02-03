package com.BankingManagementSystem.frameDesign;

import java.awt.GraphicsEnvironment;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;     
import java.awt.Color;
import java.awt.image.*;
import java.awt.image.*;
import java.io.File;
import javax.imageio.ImageIO;




class picture extends JWindow implements Runnable
{
	public void run()
        {
		JLabel SplashLabel = new JLabel(new ImageIcon("bld.jpg"));
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		
		getContentPane().add(SplashLabel,BorderLayout.CENTER);
		
		setSize(2000,1300);
		setLocation((screen.width - 2000)/2,((screen.height-1300)/2));
		show();
	}
}


class start extends JFrame implements ActionListener 
{
	private JLabel lib;
	private JButton administrator;
	private JButton operator;
	
        public start() 
	{	
           initComponents();
	}	
	
        JPanel Panel1;
	JDesktopPane Desk1 = new JDesktopPane();
	Dimension screen =Toolkit.getDefaultToolkit().getScreenSize();
	picture pic = new picture();
	Thread ThFormSplash = new Thread(pic);
	
        private void initComponents() 
        {   
		loadpicture();
		JFrame f1=new JFrame("WELCOME");
		f1.setBackground(Color.cyan);
		f1.setResizable(false);
		try{
        		f1.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("bckgrnd.jpg")))));
		}
		catch(Exception o)
		{
		}
		
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f1.setVisible(true);
		f1.setForeground(new java.awt.Color(160, 210, 45));
		Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		f1.setVisible(true);  
		f1.setIconImage(Toolkit.getDefaultToolkit().getImage(start.class.getResource("/resources/1485472416_Banking_00019_A.png")));
		
                int windowWidth = 1100;
                int windowHeight = 600;
          
                f1.setBounds(center.x - windowWidth / 2, center.y - windowHeight / 2, windowWidth,windowHeight);
		
		lib=new JLabel();
		lib.setFont(new java.awt.Font("Elephant", 15, 50));
		
        f1.getContentPane().setLayout(null);
		f1.setForeground(new Color(120, 210,45));
        lib.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lib.setForeground(new Color(30, 150,65));
        lib.setText("");
        f1.add(lib);
        lib.setBounds(100, 100, 800, 150);
		
        Font f2=new Font("AR JULIAN",Font.BOLD,16);
        ImageIcon cup = new ImageIcon("admin1.png");
		administrator = new JButton("MANAGER",cup);
		administrator.setFont(f2);
        administrator.addActionListener(this);
        administrator.setToolTipText("CLICK TO ENTER");
		
		f1.getContentPane().add(administrator);
        administrator.setBounds(150, 400, 250, 100);
        
        administrator.addActionListener((e) ->
        {
        	managerLogin();
       
         }
       );
		
	    ImageIcon cup2 = new ImageIcon("opp.jpg");
		operator = new javax.swing.JButton("ACCOUNTANT",cup2);
        operator.addActionListener(this);
        operator.setFont(f2);
        operator.setToolTipText("CLICK TO ENTER");
        
        operator.addActionListener((e) ->
        {
        	AccountantLogin();
      	
         }
       );
        
		
		f1.getContentPane().add(operator);
                operator.setBounds(700, 400, 250, 100);
	}

        public void actionPerformed(ActionEvent ae)
        {
          if(ae.getSource()==administrator)
            {
              //new WelCome("WELCOME");

            }
          else if(ae.getSource()==operator)
            {
              //new WelCome1("WELCOME");

            }

        }
		
        protected void loadpicture()
        {
		ThFormSplash.start();
		while(!pic.isShowing())
                {
			try
                        {
			     Thread.sleep(3000);
				
			}catch(InterruptedException e){}
		}
	}
        
        
        
        public void AccountantLogin()
        {

            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    new LoginAccountant();
          
                }
            });
        }
        
        public void managerLogin()
        {

            SwingUtilities.invokeLater(new Runnable()
            {
                public void run()
                {
                    new ManagerLoginPage();
                    
                }
            });
        }
		
	public static void main(String args[])
	{
		start ob1=new start();
		
	}
}