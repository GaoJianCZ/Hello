package cn.KTZ.Frame;
import java.awt.Color;

/**
 * @author gaoj
 * */
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import cn.KTZ.Entity.Aircraft;
import cn.KTZ.Entity.ScoreJFrame;
import cn.KTZ.Panel.GamePanel;

public class GameFrame extends JFrame{
	//窗体大小
	public static final int WIDTH = 480;
	public static final int HEIGHT = 700;
	//boolean bool;
	public GamePanel panel;
	//构造方法
	public GameFrame() {
		//bool=true;
		panel = new GamePanel();
		panel.action();
		//添加面板监听事件
		this.addKeyListener(panel);
		//this.addMouseListener(panel);
		this.add(panel);

		//设置窗体属性
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("image/a.jpg").getImage());
		this.setUndecorated(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		while(true) {
			if(panel.isOver==true) {
				//if(bool) {
					
					//bool=false;
				//}
				this.dispose();	
			 
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new GameFrame();
		new LoginJFrame();
	}

	public GamePanel getPanel() {
		return panel;
	}

	public void setPanel(GamePanel panel) {
		this.panel = panel;
	}
	
}
