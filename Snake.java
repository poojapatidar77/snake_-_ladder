import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Fdemo extends JFrame
{
	JPDemo jp;
	Fdemo()
	{
     super.setTitle("Snake & Ladder");	
     // setTitle("Snake & Ladder");	
	jp=new JPDemo();
		add(jp);
	}
}
class JPDemo extends JPanel implements ActionListener
{
	JButton b1,b2,b3,b4;
	int px1=40,py1=620,px2=120,py2=620;
	int count=0,p1=0,p2=0;
	int roll=0;
	boolean out=true;
	JTextField t1,t2,t3;
	ImageIcon img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11;
	Image board,swt,s2,start1,about1,reset,start2,player1,player2,player11
	,player12,dicer,dice;
	JPDemo()
	{
		setBackground(Color.black);
	  img1=new ImageIcon("board.jpg");
	  img2=new ImageIcon("swt.jpeg");
	  img3=new ImageIcon("s2.png");
	  img4=new ImageIcon("start1.jpeg");
	  img5=new ImageIcon("about1.gif");
	  img6=new ImageIcon("reset.jpeg");
	  img7=new ImageIcon("start2.gif");
	  img8=new ImageIcon("player1.png");
	  img9=new ImageIcon("player2.png");
	  img10=new ImageIcon("dicer.gif");
	  img11=new ImageIcon("dice.jpeg");
	  board=img1.getImage();
	  swt=img2.getImage();
	  s2=img3.getImage();
	  start1=img4.getImage();
	  about1=img5.getImage();
	  start2=img7.getImage();
	  player1=img8.getImage();
	  player2=img9.getImage();
	  player11=img8.getImage();
	  player12=img9.getImage();
	  dicer=img10.getImage();
	  dice=img11.getImage();
	  setLayout(null);
	  
	  b1=new JButton(img5);
	  b1.setBounds(50,120,100,30);
	  add(b1);
	  b1.setBackground(new Color(4,129,255));
	  
	  b2=new JButton(img6);
	  b2.setBounds(50,180,100,30);
	  add(b2);
	  b2.setBackground(new Color(4,129,255));
	  
	  Font f=new Font("Bauhaus 93",Font.ITALIC,20);
	  
	  t1=new JTextField("Start Game");
	  t1.setBounds(50,230,110,35);
	  t1.setFont(f);
	  t1.setBackground(Color.black);
	  t1.setForeground(Color.green);
	  add(t1);
	  
	  
	  t2=new JTextField("Player 1 Name");
	  t2.setBounds(50,290,140,35);
	  t2.setFont(f);
	  t2.setBackground(Color.black);
	  t2.setForeground(Color.green);
	  add(t2);
	  
	  
	  t3=new JTextField("Player 2 Name");
	  t3.setBounds(50,375,140,35);
	  t3.setFont(f);
	  t3.setBackground(Color.black);
	  t3.setForeground(Color.green);
	  add(t3);
	  
	  b3=new JButton("Roll");
	  b3.setBounds(50,500,100,30);
	  b3.setFont(f);
	  b3.setForeground(Color.red);
	  add(b3);
	   b3.addActionListener(this);
	  
	  
	  b4=new JButton(img7);
	  b4.setBounds(20,560,150,60);
	  add(b4);
	  b4.setFont(f);
	  b4.setForeground(Color.red);
 
	}
	 
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(new Color(4,129,255));
		g.fillRect(0,0,200,735);
		g.drawImage(board,200,0,this);
		
		g.drawImage(swt,0,0,this);
		g.drawImage(s2,920,0,this);
		g.drawImage(start1,20,550,this);
	    
	  Font f=new Font("Arial Black",Font.ITALIC,60);
	   setFont(f);
	  g.setColor(Color.black);
     	if(p1==100)
		{
			g.drawString("PLAYER 1 WINNER",230,400);
 			 out=false;
		}			
     	else if(p2==100)
		{
			g.drawString("PLAYER 2 WINNER",230,400);
			  out=false;
		}			
	
	
		 g.drawImage(player1,px1,py1,this);
	     g.drawImage(player2,px2,py2,this);
	
		g.drawImage(player11,10,280,this);
		g.drawImage(player12,10,360,this);
		g.drawImage(dicer,10,420,this);
		g.drawImage(dice,110,420,this);
	}
	public void actionPerformed(ActionEvent e)
	{
		int t=0;
		if(out)
		{
		 if(e.getSource()==b3)
		{
			int random=(int)Math.round(Math.random()*5+1);
			 if(roll%2==0)
			 {
			 px1=140;
			py1=645;
			 }
			 else
			 {
			px2=140;
			py2=645;
			 } 

			 switch(random)
			{
				case 1:
                count=1;
				img11=new ImageIcon("dice1.jpeg");
				break;
				
				case 2:
				count=2;
                 img11=new ImageIcon("dice2.jpeg");
				break;
				
				case 3:
				count=3;
                 img11=new ImageIcon("dice3.png");
				break;
				
				case 4:
				count=4;
                 img11=new ImageIcon("dice4.jpeg");
				break;
				
				case 5:
				count=5;
                 img11=new ImageIcon("dice5.jpeg");
				break;
				
				case 6:
				count=6;
              img11=new ImageIcon("dice6.jpeg");
				break;
			}  
			dice=img11.getImage();
			
			int count1=0,k=1;
			int x1,y1;
			t=count;
			if(roll%2==0)
			{
				p1=p1+count;
				count=p1;
			}
			else
			{
				p2+=count;
				count=p2;
			}  
			if(p1==4||p2==4)
			{
				count=25;
				if(roll%2==0)p1=25;
				else p2=25;
			}
			if(p1==13||p2==13)
			{
				count=46;
				if(roll%2==0)p1=46;
				else p2=46;
			}
			if(p1==42||p2==42)
			{
				count=63;
				if(roll%2==0)p1=63;
				else p2=63;
			}
			if(p1==33||p2==33)
			{
				count=49;
				if(roll%2==0)p1=49;
				else p2=49;
			}
			if(p1==50||p2==50)
			{
				count=69;
				if(roll%2==0)p1=69;
				else p2=69;
			}
			if(p1==62||p2==62)
			{
				count=81;
				if(roll%2==0)p1=81;
				else p2=81;
			}
			if(p1==74||p2==74)
			{
				count=92;
				if(roll%2==0)p1=92;
				else p2=92;
			}
	         //snake bite
			if(p1==27||p2==27)
			{
				count=5;
				if(roll%2==0)p1=5;
				else p2=5;
			}
			if(p1==40||p2==40)
			{
				count=3;
				if(roll%2==0)p1=3;
				else p2=3;
			}
			if(p1==43||p2==43)
			{
				count=18;
				if(roll%2==0)p1=18;
				else p2=18;
			}
			if(p1==54||p2==54)
			{
				count=31;
				if(roll%2==0)p1=31;
				else p2=31;
			}
			if(p1==66||p2==66)
			{
				count=45;
				if(roll%2==0)p1=45;
				else p2=45;
			}
			if(p1==76||p2==76)
			{
				count=58;
				if(roll%2==0)p1=58;
				else p2=58;
			}
			if(p1==89||p2==89)
			{
				count=53;
				if(roll%2==0)p1=53;
				else p2=53;
			}
			if(p1==99||p2==99)
			{
				count=41;
				if(roll%2==0)p1=41;
				else p2=41;
			}
	         		
			x1=(roll%2==0)?px1:px2;
			y1=(roll%2==0)?py1:py2;
			M:
			{
			for(int i=1;i<=10;i++)
			{ 
				for(int j=1;j<=10;j++)
				{
					count1++;
					if(i%2==1)
					{
						x1+=70;
						k++;
					}
					else
					{
						x1-=70;
						k--;
					}
					if(count==count1)break M;
				}
				y1-=70;
				
				if(i%2==1)x1+=70;
				else x1-=70;
				
			}
		    } 
			if(roll%2==0)
			{
				px1=x1;
				py1=y1;
			}
			else if(roll%2==1)
			{
				px2=x1;
				py2=y1;
			}
			 roll++;
			if(p1>100)
			{
				p1-=t;
			  px1+=t*70; 
				py1=15;
			 
			 }
			if(p2>100)
			{
				p2-=t;
				px2+=t*70; 
				py2=15;
			 }
            if(p1>=100)
			{
				px1=210;
				py1=15;
			}
            if(p2>=100)
			{
				px2=210;
				py2=15;
			}
			repaint();
		}
		 }
	}
	
}

class Snake
{
	public static void main(String ar[])
	{
	Fdemo f=new Fdemo();
	f.setVisible(true);
	f.setBounds(100,100,990,750);
	f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}