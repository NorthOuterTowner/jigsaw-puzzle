import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
public class GameJFrame extends JFrame implements ActionListener, MouseListener, KeyListener{
	private int data[][]=new int[4][4];
	private int x,y,foot,victoryCnt;
	private String userName;
	public GameJFrame() {
		initJFrame();
		initJMenuBar();
		initData();
		initImage();

		this.setVisible(true);
	}
	private void initData() {
		// TODO Auto-generated method stub
		int tempArr[]= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Random r=new Random();
		for(int i=0;i<tempArr.length;i++) {
			int randint = r.nextInt(tempArr.length);
			int tmpData=tempArr[i];
			tempArr[i]=tempArr[randint];
			tempArr[randint]=tmpData;
		}
		for(int i=0;i<tempArr.length;i++) {	
			if(tempArr[i]==0) {
				data[i/4][i%4]=tempArr[i];
				x=i/4;
				y=i%4;
			}else {
				data[i/4][i%4]=tempArr[i];
			}
		}
	}
	private void initImage() {
		// TODO Auto-generated method stub
		this.getContentPane().removeAll();
		if(victory()) {
			this.victoryCnt++;
			this.getContentPane().removeAll();
			JLabel win=new JLabel(new ImageIcon("image//all.jpg"));
			win.setBounds(100, 100, 384, 216);
			ImageIcon bg=new ImageIcon("background.jpg ");
			JLabel background=new JLabel(bg);
			background.setBounds(40, 40, 505, 350);
			background.setBorder(new BevelBorder(BevelBorder.RAISED));
			JLabel user=new JLabel("User: "+userName);
			user.setBounds(100, 340, 180, 30);
			user.setBorder(new BevelBorder(BevelBorder.LOWERED));
			
			JLabel winning=new JLabel("Victory Count: "+victoryCnt);
			winning.setBounds(300, 340, 180, 30);
			winning.setBorder(new BevelBorder(BevelBorder.LOWERED));
			JLabel footCount=new JLabel("Foot: "+foot);
			footCount.setBounds(40, 5, 100, 30);
			footCount.setBorder(new BevelBorder(BevelBorder.LOWERED));
			
			JLabel hint=new JLabel(" Hint: Press 'a' look whole map. Click 'w' finish game.");
			hint.setBounds(200, 5, 340, 30);
			hint.setBorder(new BevelBorder(BevelBorder.LOWERED));
			
			JLabel rule=new JLabel("                 Rule : Use 'left' , 'right' , 'up' , 'down' keys on the keyboard to control.");
			rule.setBounds(42, 50, 500, 30);
			rule.setBorder(new BevelBorder(BevelBorder.LOWERED));
			
			this.getContentPane().add(user);
			this.getContentPane().add(winning);
			this.getContentPane().add(background);
			this.getContentPane().add(rule);
			this.getContentPane().add(hint);
			this.getContentPane().add(footCount);
			this.getContentPane().add(win);
			this.getContentPane().repaint();
			System.out.println("Finished");
			return;
		}
		
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				int number=data[i][j];
				JLabel jLabel=new JLabel(new ImageIcon("image\\"+number+".jpg"));
				jLabel.setBounds(j*96+100,i*54+100,96,54);
				jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
				this.getContentPane().add(jLabel);
			}
		}
		ImageIcon bg=new ImageIcon("background.jpg ");
		JLabel background=new JLabel(bg);
		background.setBounds(40, 40, 505, 350);
		background.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		JLabel footCount=new JLabel("Foot: "+foot);
		footCount.setBounds(40, 5, 100, 30);
		footCount.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		JLabel hint=new JLabel(" Hint: Press 'a' look whole map. Click 'w' finish game.");
		hint.setBounds(200, 5, 340, 30);
		hint.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		JLabel rule=new JLabel("                 Rule : Use 'left' , 'right' , 'up' , 'down' keys on the keyboard to control.");
		rule.setBounds(42, 50, 500, 30);
		rule.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		JLabel user=new JLabel("User: "+userName);
		user.setBounds(100, 340, 180, 30);
		user.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		JLabel winning=new JLabel("Victory Count: "+victoryCnt);
		winning.setBounds(300, 340, 180, 30);
		winning.setBorder(new BevelBorder(BevelBorder.LOWERED));
		this.getContentPane().add(user);
		this.getContentPane().add(winning);
		this.getContentPane().add(rule);
		this.getContentPane().add(hint);
		this.getContentPane().add(footCount);
		this.getContentPane().add(background);
		this.getContentPane().repaint();
	}
	private void initJMenuBar() {
		// TODO Auto-generated method stub
		
	        JMenuBar menuBar = new JMenuBar();

	        JMenu menu1 = new JMenu("Function");
	        JMenuItem menuItem1_1 = new JMenuItem("Restart Game");
	        menuItem1_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		foot=0;
	        		initData();
	        		initImage();
	        	}
	        });
	        JMenuItem menuItem1_2 = new JMenuItem("Sign-up");
	        menuItem1_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		JFrame upFrame=new JFrame("Sign-up");
	        		upFrame.setSize(new Dimension(300,150));
	        		upFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        		upFrame.setLayout(null);
	        		upFrame.setAlwaysOnTop(true);
	        		JLabel userNameLabel=new JLabel("User Name:");
	        		userNameLabel.setBounds(10,20,100,20);
	        		JLabel passWordLabel=new JLabel("Pass Word:");
	        		passWordLabel.setBounds(10,50,100,20);
	        		
	        		JTextField nameInput=new JTextField();
	        		JTextField passwordInput=new JTextField();
	        		nameInput.setBounds(100,20,100,20);
	        		passwordInput.setBounds(100, 50, 100, 20);
	        		JButton submit = new JButton("Submit");
	        		JButton cancel = new JButton("Cancel");
	        		cancel.addActionListener(new ActionListener() {
	        			public void actionPerformed(ActionEvent e) {
	        				upFrame.setVisible(false);
	        			}
	        		});
	        		submit.addActionListener(new ActionListener() {
	        			public void actionPerformed(ActionEvent e) {
	        				upFrame.setVisible(false);
	        				userName=nameInput.getText();
	        				initImage();
	        			}
	        		});
	        		submit.setBounds(110,80, 80, 20);
	        		cancel.setBounds(200,80, 80, 20);
	        		upFrame.add(submit);
	        		upFrame.add(cancel);
	        		upFrame.add(userNameLabel);
	        		upFrame.add(passWordLabel);
	        		upFrame.add(nameInput);
	        		upFrame.add(passwordInput);
	        		upFrame.setLocationRelativeTo(null);
	        		upFrame.setAlwaysOnTop(true);
	        		//upFrame.pack();
	        		upFrame.setVisible(true);
	        	}
	        });
	        JMenuItem menuItem1_3 = new JMenuItem("Quit Game");
	        menuItem1_3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		System.exit(0);
	        	}
	        });
	        menu1.add(menuItem1_1);
	        menu1.add(menuItem1_2);
	        menu1.add(menuItem1_3);
	        JMenu menu2 = new JMenu("About");
	        JMenuItem menuItem2_1 = new JMenuItem("author");
	        menuItem2_1.addActionListener(new ActionListener(){
	        	public void actionPerformed(ActionEvent e) {
	        		JFrame authorFrame=new JFrame("Author");
	        		authorFrame.setSize(300, 150);
	        		authorFrame.setLayout(null);
	        		authorFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        		authorFrame.setLocationRelativeTo(null);
	        		
	        		JLabel label1p=new JLabel("Name:");
	        		label1p.setBounds(10,10,50,20);
	        		JLabel label1=new JLabel("NorthOuterTowner");
	        		label1.setBounds(60,10,200,20);
	        		label1.setBorder(new BevelBorder(BevelBorder.LOWERED));
	        		authorFrame.getContentPane().add(label1p);
	        		authorFrame.getContentPane().add(label1);
	        		
	        		JLabel label2p=new JLabel("School:");
	        		label2p.setBounds(10,30,50,20);
	        		JLabel label2=new JLabel("Beijing Jiaotong University");
	        		label2.setBounds(60,30,200,20);
	        		label2.setBorder(new BevelBorder(BevelBorder.LOWERED));
	        		authorFrame.getContentPane().add(label2p);
	        		authorFrame.getContentPane().add(label2);
	        		
	        		JLabel label3p=new JLabel("Age:");
	        		label3p.setBounds(10,50,50,20);
	        		JLabel label3=new JLabel("18");
	        		label3.setBounds(60,50,200,20);
	        		label3.setBorder(new BevelBorder(BevelBorder.LOWERED));
	        		authorFrame.getContentPane().add(label3p);
	        		authorFrame.getContentPane().add(label3);
	        		
	        		JLabel label4p=new JLabel("Gender:");
	        		label4p.setBounds(10,70,50,20);
	        		JLabel label4=new JLabel("Male");
	        		label4.setBounds(60,70,200,20);
	        		label4.setBorder(new BevelBorder(BevelBorder.LOWERED));
	        		authorFrame.getContentPane().add(label4p);
	        		authorFrame.getContentPane().add(label4);
	        		
	        		authorFrame.setVisible(true);
	        	}
	        });
	        JMenuItem menuItem2_2 = new JMenuItem("connection");
	        menuItem2_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		JFrame conFrame=new JFrame("Connect With Me");
	        		conFrame.setSize(300, 150);
	        		conFrame.setLayout(null);
	        		conFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	        		conFrame.setLocationRelativeTo(null);
	        		
	        		JLabel label1p=new JLabel("E-mail:");
	        		label1p.setBounds(10,10,50,20);
	        		JLabel label1=new JLabel("23301069@bjtu.edu.cn");
	        		label1.setBounds(60,10,200,20);
	        		label1.setBorder(new BevelBorder(BevelBorder.LOWERED));
	        		conFrame.getContentPane().add(label1p);
	        		conFrame.getContentPane().add(label1);
	        		
	        		JLabel label2p=new JLabel("Phone:");
	        		label2p.setBounds(10,30,50,20);
	        		JLabel label2=new JLabel("18519766805");
	        		label2.setBounds(60,30,200,20);
	        		label2.setBorder(new BevelBorder(BevelBorder.LOWERED));
	        		conFrame.getContentPane().add(label2p);
	        		conFrame.getContentPane().add(label2);
	        		
	        		JLabel label3p=new JLabel("Github:");
	        		label3p.setBounds(10,50,50,20);
	        		JLabel label3=new JLabel("github.com/NorthOuterTowner/");
	        		label3.setBounds(60,50,200,20);
	        		label3.setBorder(new BevelBorder(BevelBorder.LOWERED));
	        		conFrame.getContentPane().add(label3p);
	        		conFrame.getContentPane().add(label3);
	        		
	        		conFrame.setVisible(true);
	        	}
	        });
	        menu2.add(menuItem2_1);
	        menu2.add(menuItem2_2);

	        menuBar.add(menu1);
	        menuBar.add(menu2);

	        setJMenuBar(menuBar);
	}
	private void initJFrame() {
		// TODO Auto-generated method stub
		this.setTitle("Jigsaw Puzzle");
		this.setSize(620,500);
		this.setLayout(null);
		//this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addKeyListener(this);
		/*JLabel footCount=new JLabel("Foot: ");
		footCount.setBounds(30, 30, 50, 50);
		this.getContentPane().add(footCount);*/
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if((data[0][0]==1)&&(data[0][1]==2)&&(data[1][0]==3)) {
			System.out.println("Finished");
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code=e.getKeyCode();
		if(code==65) {
			this.getContentPane().removeAll();
			JLabel allPic=new JLabel(new ImageIcon("image\\all.jpg"));
			allPic.setBounds(100, 100, 384, 216);
			ImageIcon bg=new ImageIcon("background.jpg ");
			JLabel background=new JLabel(bg);
			background.setBounds(40, 40, 505, 350);
			background.setBorder(new BevelBorder(BevelBorder.RAISED));
			JLabel footCount=new JLabel("Foot: "+foot);
			footCount.setBounds(40, 5, 100, 30);
			footCount.setBorder(new BevelBorder(BevelBorder.LOWERED));
			JLabel hint=new JLabel(" Hint: Press 'a' look whole map. Click 'w' finish game.");
			hint.setBounds(200, 5, 340, 30);
			hint.setBorder(new BevelBorder(BevelBorder.LOWERED));
			JLabel rule=new JLabel("                 Rule : Use 'left' , 'right' , 'up' , 'down' keys on the keyboard to control.");
			rule.setBounds(42, 50, 500, 30);
			rule.setBorder(new BevelBorder(BevelBorder.LOWERED));
			JLabel user=new JLabel("User: "+userName);
			user.setBounds(100, 340, 180, 30);
			user.setBorder(new BevelBorder(BevelBorder.LOWERED));
			JLabel winning=new JLabel("Victory Count: "+victoryCnt);
			winning.setBounds(300, 340, 180, 30);
			winning.setBorder(new BevelBorder(BevelBorder.LOWERED));
			this.getContentPane().add(user);
			this.getContentPane().add(winning);
			this.getContentPane().add(hint);
			this.getContentPane().add(footCount);
			this.getContentPane().add(rule);
			this.getContentPane().add(background);
			this.getContentPane().add(allPic);
			this.getContentPane().repaint();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code =e.getKeyCode();
		switch(code) {
			case 37:
				System.out.print("Left ");
				if(y==3) {
						System.err.println("Failure");
						return;
					}
					foot++;
					System.out.println("Success");
					data[x][y]=data[x][y+1];
					data[x][y+1]=0;
					++y;
					initImage();
				break;
			case 38:
				System.out.println("Up");
				if(x==3) {
					System.err.println("Failure");
					return;
					}
				foot++;
				data[x][y]=data[x+1][y];
				data[x+1][y]=0;
				++x;
				initImage();
				break;
			case 39:
				System.out.println("Right");
				if(y==0) {
					System.err.println("Failure");
					return;
					}
				foot++;
				data[x][y]=data[x][y-1];
				data[x][y-1]=0;
				--y;
				initImage();
				break;
			case 40:
				System.out.println("Down");
				if(x==0) {
					System.err.println("Failure");
					return;}
				foot++;
				data[x][y]=data[x-1][y];
				data[x-1][y]=0;
				--x;
				initImage();
				break;
			case 65:
				initImage();
				break;
			case 87:
				data=new int[][] {
					{1,2,3,4},
					{5,6,7,8},
					{9,10,11,12},
					{13,14,15,0}
				};
				x=3;
				y=3;
				initImage();
				break;
			default:
				break;
		}
	}
	private boolean victory() {
		int cnt=0;
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				if(data[i][j]==i*4+j+1) 
						cnt++;
				else break;
			}
		}
		if(cnt==15) {
			return true;
		}else {
			return false;
		}
	}
}
