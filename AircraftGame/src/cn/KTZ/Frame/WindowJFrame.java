package cn.KTZ.Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * 游戏缓冲界面
 * */

public class WindowJFrame extends JFrame implements Runnable{

	//背景图片 hbg.jpg
	JLabel backImage;
	//进度条
	JProgressBar jdt;
	//启动方法
	public void Start() {
		WindowJFrame frame = new WindowJFrame();
		//创建一个线程，并绑定frame窗体
		Thread thread = new Thread(frame);
		//启动线程
		thread.start();
        dispose();
	}
	public WindowJFrame() {
		backImage = new JLabel(new ImageIcon("image/logo1.png"));
		jdt = new JProgressBar();//创建进度条
		
		//设置进度条颜色
		
		jdt.setForeground(Color.blue); 
		//jdt.setBackground(Color.green);
		this.add(backImage,BorderLayout.NORTH);
		
		//设置进度条字符串的值
		jdt.setStringPainted(true);
		this.add(jdt,BorderLayout.SOUTH);
		this.setUndecorated(true);
		this.setSize(480,700);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//背景图片480*680
		this.setIconImage(new ImageIcon("image/logo.png").getImage());		
	}
	public static void main(String[] args) {
       // new WindowJFrame().Start();
		new LoginJFrame();
		
	}
	@Override
	public void run() {
		// 进度条的值
		int [] progressValue = {0,(int)(Math.random()*10+1),(int)(Math.random()*10+11),(int)(Math.random()*10+21),
				(int)(Math.random()*10+31),(int)(Math.random()*10+41),(int)(Math.random()*10+51),(int)(Math.random()*10+61),
				(int)(Math.random()*10+71),(int)(Math.random()*10+81),(int)(Math.random()*10+91),100};
		
		for(int i = 0;i<progressValue.length;i++) {
			jdt.setValue(progressValue[i]);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//jdt.setValue(progressValue[i]);
		}
		//跳转到主界面，
		dispose();
		new GameFrame();
		//关闭当前页面
		
	}

}
