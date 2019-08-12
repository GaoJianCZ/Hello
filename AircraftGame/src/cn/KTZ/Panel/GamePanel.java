package cn.KTZ.Panel;
import java.applet.Applet;
import java.applet.AudioClip;
/**
 * @author gaoj
 * */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import cn.KTZ.Entity.Aircraft;
import cn.KTZ.Entity.Barrs_1;
import cn.KTZ.Entity.Bullet;
import cn.KTZ.Entity.Bullet_1;
import cn.KTZ.Entity.XuePing;
import cn.KTZ.Frame.GameFrame;
import cn.KTZ.Frame.ScoreFrame;

public class GamePanel extends JPanel implements KeyListener {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 700;
	
	//public int cnt = 1;
	//血条
	JProgressBar HP;
	//得分背景图
	Image showLabel;
	//暂停按钮
	JLabel pauseLabel;

	int xx[] = new int [100];
	int yy[] = new int [100];
	//玩家飞机
	public Aircraft aircraft;
	//玩家子弹
	Bullet [] buls = {};
	//敌机
	Barrs_1 [] barrs1 = {};
	//敌机子弹
	Bullet_1 [] bullets_1 = {};
	
	XuePing [] xu = {};
	
	public boolean flag = true;
	boolean zd = false;
	boolean flag1 = false;
	public boolean isOver = false;
	int n=0;
	
	//声明加载背景音乐的变量
			File f2,f3;
			URL url1,url2;
			URI uri1,uri2;
			AudioClip mus1,mus2;
		//Bad [] bad = {};
		
	public GamePanel() {
		f2=new File("sound/fight.wav");
    	uri1=f2.toURI();
    	try {
    		
			url1=uri1.toURL();
			mus1=Applet.newAudioClip(url1);
			//循环播放该音乐
			mus1.loop();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	
	
		showLabel = new ImageIcon("image/blue1_menu.png").getImage();
		pauseLabel = new JLabel(new ImageIcon("image/gameover.png"));
		pauseLabel.setBounds( 400, 5,100, 37);
		
		//添加鼠标监听器
		pauseLabel.addMouseListener(new MouseListener() {			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub				
			}			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub				
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				pauseLabel.setBounds( 400, 5,100, 37);				
			}			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				pauseLabel.setBounds( 400, 6,100, 37);
				
			}			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//new Zanting();
				
				flag1=true;
				
			}
		});
		aircraft = new Aircraft();
		HP = new JProgressBar();
		HP.setForeground(Color.ORANGE);
		HP.setBackground(null);
		HP.setValue(aircraft.getLife());
		HP.setBounds(145, 5, 250, 10);
		HP.setVisible(true);		
		
		for(int i = 0;i<100;i++) {
			xx[i] = (int) (Math.random() * WIDTH);
			yy[i] = (int) (Math.random() * HEIGHT);
		}
		this.setBackground(Color.black);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		Font ft = new Font("微软雅黑", Font.BOLD, 15);
		g.setFont(ft);
		// 1.画一颗小星星
		// g.drawString("*", 30, 50);
		//aircraft.paintAircraft(g);
		for (int i = 0; i < 100; i++) {			
			int R = (int) (Math.random() * 255);
			int G = (int) (Math.random() * 255);
			int B = (int) (Math.random() * 255);
			g.setColor(new Color(R,G,B));
			g.drawString("*", xx[i], yy[i]);			
		}
				
		
		//绘制敌机
		for(int i = 0;i<barrs1.length;i++) {
			barrs1[i].paintBarrs_1(g);
		}
		//绘制敌机子弹
		for(int i = 0;i<bullets_1.length;i++) {
			bullets_1[i].paintBullet_1(g);
		}	
		for(int i = 0;i<xu.length;i++) {
			xu[i].paintXueping(g);
		}
		//绘制玩家子弹 
		for(int i = 0;i<buls.length;i++) {
			buls[i].paintBullet(g);
		}
		
		g.drawImage(showLabel, 0, 0, 150, 40,null);
		g.setColor(Color.YELLOW);
		g.setFont(new Font("微软雅黑",Font.BOLD,16));		
		g.drawString("得分："+aircraft.getScore(), 20, 25);
		
		/*if(flag1==false) {
			
			flag=false;
		}*/
		//绘制玩家
		aircraft.paintAircraft(g);
		this.add(HP);
		this.add(pauseLabel);
	}
	//物体移动方法
	public void stepAction() {
		//玩家子弹移动
		for(int i = 0;i<buls.length;i++) {
			buls[i].step();
		}
		//敌机移动
		for(int i = 0;i<barrs1.length;i++) {
			barrs1[i].step();
		}
		//敌机子弹移动
		for(int i = 0; i<bullets_1.length;i++) {
			bullets_1[i].step();
		}
		for(int i = 0;i<xu.length;i++) {
			xu[i].step();
		}
	}
	
	int index=0;
	//生成物体
	public void EnteredAction() {
		index++;
		//玩家子弹
		if(index%3==0) {
			Bullet bul = new Bullet(aircraft.getX(),aircraft.getY());
			if(zd) {
				bul.setIndex(n);
			}
			buls = Arrays.copyOf(buls, buls.length+1);
			buls[buls.length-1] = bul;
		}
		//敌机
		if(index%150==0) {
			Barrs_1 bar = new Barrs_1();
			barrs1 = Arrays.copyOf(barrs1, barrs1.length+1);
			barrs1[barrs1.length-1] = bar;
		}
		//敌机子弹
		if(index%50==0 && barrs1.length>=1) {
			Bullet_1 bul_1 = new Bullet_1(barrs1[barrs1.length-1].getX()+23,
										barrs1[barrs1.length-1].getY()+55);
			bullets_1 = Arrays.copyOf(bullets_1, bullets_1.length+1);
			bullets_1[bullets_1.length-1]=bul_1;
		}
	}
	//删除越界的对象
	public void Del(){
		//删除越界的敌机
		for(int i = 0;i<barrs1.length;i++) {
			if(barrs1[i].getY()>GameFrame.HEIGHT || barrs1[i].getIndex()>25) {
				barrs1[i]=barrs1[barrs1.length-1];
				barrs1= Arrays.copyOf(barrs1, barrs1.length-1);
			}
		}
		//删除越界的玩家子弹
		for(int i =0;i<buls.length;i++) {
			if(buls[i].getZy()<-Bullet.Z_HEIGHT) {
				buls[i] = buls[buls.length-1];
				buls = Arrays.copyOf(buls, buls.length-1);
			}
		}
		//删除越界的敌机子弹
		for(int i = 0;i<bullets_1.length;i++) {
			if(bullets_1[i].getZy()>GameFrame.HEIGHT) {
				bullets_1[i] = bullets_1[bullets_1.length-1];
				bullets_1 = Arrays.copyOf(bullets_1, bullets_1.length-1);
			}
		}
		for(int i = 0;i<xu.length;i++) {
			if(xu[i].getXy()>GameFrame.HEIGHT) {
				xu[i]=xu[xu.length-1];
				xu=Arrays.copyOf(xu, xu.length-1);
			}
		}
	}
	
	//碰撞判断方法
	public void wardAction() {
		//碰撞敌机
		for(int i = 0;i<barrs1.length;i++) {
			//if(barrs1[i].flag) {
			if(barrs1[i].isFlag2()!=true &&
				aircraft.getX()+aircraft.WIDTH>barrs1[i].getX() &&
				aircraft.getX()<barrs1[i].getX()+barrs1[i].WIDTH &&
				aircraft.getY()+5<barrs1[i].getY()+barrs1[i].HEIGHT &&
				aircraft.getY()+aircraft.HEIGHT-15>barrs1[i].getY()) {
				
				int l1 = aircraft.getLife();
				aircraft.setLife(l1-10);
				HP.setValue(aircraft.getLife());
				barrs1[i].setFlag2(true);				
			}
			
		}
		//碰撞敌机子弹
		for(int i = 0;i<bullets_1.length;i++) {
			if(aircraft.getX()<bullets_1[i].getZx()+bullets_1[i].Z_WIDTH &&
				aircraft.getX()+aircraft.WIDTH>bullets_1[i].getZx() &&
				aircraft.getY()+5<bullets_1[i].getZy()+bullets_1[i].Z_HEIGHT &&
				aircraft.getY()+aircraft.HEIGHT-15>bullets_1[i].getZy()) {
				
				//System.out.println("碰到子弹");
				int l = aircraft.getLife();
				aircraft.setLife(l-10);
				HP.setValue(aircraft.getLife());
				bullets_1[i] = bullets_1[bullets_1.length-1];
				bullets_1 = Arrays.copyOf(bullets_1, bullets_1.length-1);
			}
		}
		//子弹打中敌机
		for(int i = 0;i<buls.length;i++) {
			for(int j = 0;j<barrs1.length;j++) {
				if(barrs1[j].isFlag2()!=true && 
					buls[i].getZx()<barrs1[j].getX()+barrs1[j].WIDTH &&
					buls[i].getZx()+buls[i].Z_WIDTH>barrs1[j].getX() &&
					buls[i].getZy()<barrs1[j].getY()+barrs1[j].HEIGHT &&
					buls[i].getZy()+buls[i].Z_HEIGHT>barrs1[j].getY()) {
					//System.out.println("打中敌机");
					int s = aircraft.getScore();
					aircraft.setScore(s+10);					
					barrs1[j].setFlag2(true);
					
					if(index%10==0) {
						XuePing h1 = new XuePing(barrs1[j].getX(),barrs1[j].getY());
						xu = Arrays.copyOf(xu, xu.length+1);
						xu[xu.length-1] = h1;
					}
					buls[i] = buls[buls.length-1];
					buls = Arrays.copyOf(buls, buls.length-1);						
				}
			}			
		}
		for(int i = 0;i<xu.length;i++) {
			if(aircraft.getX()<xu[i].getXx()+xu[i].X_WIDTH &&
				aircraft.getX()+aircraft.WIDTH>xu[i].getXx() && 
				aircraft.getY()<xu[i].getXy()+xu[i].X_HEIGHT &&
				aircraft.getY()+aircraft.HEIGHT>xu[i].getXy()) {
					zd=true;
					if(n<2) {
						n++;
					}
					xu [i] = xu[xu.length-1];
					xu = Arrays.copyOf(xu, xu.length-1);
				
			}
		}
	}
	
	//判断游戏是否结束的方法
	public void GameOverAction() {
		if(aircraft.getLife()<=0 || flag1) {
			JOptionPane.showMessageDialog(null, "游戏结束");
			flag = false;
			isOver = true;
			mus1.stop();
			//new ScoreJFrame(aircraft.getScore());
			new ScoreFrame(aircraft.getScore());
		}
	}
	
	//线程	
	public void action() {
		new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					if(flag) {
						EnteredAction();
						stepAction();
						wardAction();
						Del();
						GameOverAction();
						for(int i = 0;i < 100;i++) {
							xx[i]++;
							yy[i]++;
							if(xx[i] > WIDTH) {xx[i] = 0;}
							if(yy[i] > HEIGHT) {yy[i] = 0;}
						}
						repaint();
					}
					try {
						sleep(20);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	@Override
	//键盘监听
	public void keyPressed(KeyEvent arg0) {
		int x = aircraft.getX();
		int y = aircraft.getY();
		if(arg0.getKeyCode()==KeyEvent.VK_UP) {
			//System.out.println("键盘监听上移");
			aircraft.setY(y-5);
		}
		if(aircraft.getY()<=100){
			aircraft.setY(100);
		}
		if(arg0.getKeyCode()==KeyEvent.VK_DOWN) {
			//System.out.println("键盘监听下移");
			aircraft.setY(y+5);
		}
		if(aircraft.getY()>=HEIGHT-Aircraft.HEIGHT) {
			aircraft.setY(HEIGHT-Aircraft.HEIGHT);
		}
		
		if(arg0.getKeyCode()==KeyEvent.VK_LEFT) {
			aircraft.setX(x-5);
		}
		if(aircraft.getX()<=0) {
			aircraft.setX(0);
		}
		if(arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
			aircraft.setX(x+5);
		}
		if(aircraft.getX()>=WIDTH-aircraft.WIDTH) {
			aircraft.setX(WIDTH-aircraft.WIDTH);
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	
}
