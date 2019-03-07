package cn.KTZ.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import cn.KTZ.Entity.Aircraft;
import cn.KTZ.Panel.GamePanel;

public class Zanting extends JFrame implements MouseListener{
	
	// static boolean flag;
	int n;
	// 开始游戏，退出游戏，暂停图片按钮
	JLabel start,exit,zanting;
	public Zanting() {
		// 给开始游戏按钮赋值
		start=new JLabel(new ImageIcon("image/z14.png"));
		start.setBounds(130, 180, 138, 50);
		start.addMouseListener(this);
		this.add(start);
		
		// 给退出游戏赋值
		exit=new JLabel(new ImageIcon("image/z15.png"));
		exit.setBounds(50, 250, 138, 50);
		exit.addMouseListener(this);
		this.add(exit);
		
		// 给暂停赋值图片
		/*zanting=new JLabel(new ImageIcon("image/z13.jpg"));
		zanting.setBounds(30, 50, 300, 100);
		this.add(zanting);*/
		
		/**创建面板*/
		BackImagee back=new BackImagee();
		this.add(back);
		
		// 设置窗体基本属性
		this.setSize(350, 351);
		// 设置窗体位置居中显示
		this.setLocationRelativeTo(null);
		// 设置窗体关闭按钮功能
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 设置窗体菜单栏不显示
		this.setUndecorated(true);
		// 设置窗体图标
		this.setIconImage(new ImageIcon("image/logo.png").getImage());
		// 设置窗体可见
		this.setVisible(true);
	}		
    // 创建面板
	class BackImagee extends JPanel{
		// 图片变量
		Image background;
		public BackImagee() {
			try {
				background=ImageIO.read(new File("image/z10.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 绘制背景图片
		@Override
		public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(background, 0, 0, null);
		}		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// 继续游戏
		if(e.getSource().equals(start)) {
			// 返回游戏界面
			//bool = true;
		}
		// 退出关卡
		if(e.getSource().equals(exit)) {
			System.exit(0);
		}		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(start)) {
			start.setBounds(110, 180, 138, 50);
		}
		if(e.getSource().equals(exit)) {
			exit.setBounds(90, 250, 138, 50);
		}		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub		
		if(e.getSource().equals(start)) {
			start.setBounds(130, 180, 138, 50);
		}
		if(e.getSource().equals(exit)) {
			exit.setBounds(70, 250, 138, 50);
		}
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //new Zanting();

	}	
}
