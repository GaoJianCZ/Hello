package cn.KTZ.Frame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author gong
 * 游戏菜单界面
 * 游戏面板：背景图片
 * 图片按钮：开始游戏、帮助、离开
 * */
public class CaiDan extends JFrame implements MouseListener{
	// 开始  帮助   退出  三个图片按钮
		JLabel start,help,exit;
		File f1;
		URL url;
		URI uri;
		AudioClip aau;
			
		public CaiDan() {
				
			/*try {
				f1 = new File("images/sound/main.wav");
				uri = f1.toURI();
				url=uri.toURL();
				aau = Applet.newAudioClip(url);
				// 循环播放音乐文件
				aau.loop();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			start = new JLabel(new ImageIcon("image/z1.png"));
			start.setBounds(180, 330, 140, 40); 
			start.addMouseListener(this);
			this.add(start);
				
			help = new JLabel(new ImageIcon("image/z2.png"));
			help.setBounds(180, 400, 140, 40);
			help.addMouseListener(this);
			this.add(help);
				
			exit = new JLabel(new ImageIcon("image/z3.png"));
			exit.setBounds(180, 470, 140, 40);
			exit.addMouseListener(this);
			this.add(exit);
				
			//创建，面板，并添加到窗体上去
			Background back = new Background();
			this.add(back);				
				
			// 设置窗体的基本属性
			this.setSize(480,700);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setUndecorated(true);
			// 设置窗体图标
			this.setIconImage(new ImageIcon("image/logo.png").getImage());
			this.setVisible(true);
		}
		
		public static void main(String[] args) {
			// 测试函数，运行后进入该界面
			new LoginJFrame();
			//new CaiDan();

		}
			@Override
			public void mouseClicked(MouseEvent e) {
				// 鼠标点击事件
				if(e.getSource().equals(start)) {
					// 跳转到下一个界面
					new MoKuai();
					// 关闭背景音乐
					//aau.stop();
					// 关闭当前界面
					dispose();
				}
				if(e.getSource().equals(help)) {
					// 跳转到下一个界面
					new Help();					
				}
				if(e.getSource().equals(exit)) {
					// 关闭当前界面
					System.exit(0);
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
				
				start.setText("halou");
				
				// 鼠标移入事件
				// 如果鼠标移入的是start控件范围
				if(e.getSource().equals(start)) {
					// 设置该控件可用
					start.setBounds(180, 330, 150, 50);
				}
				if(e.getSource().equals(help)) {
					help.setBounds(180, 400, 150, 50);;
				}
				if(e.getSource().equals(exit)) {
					exit.setBounds(180, 470, 150, 50);;
				}
				//System.out.println("yiru");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// 鼠标移出事件
				// 如果鼠标移出start控件范围
				if(e.getSource().equals(start)) {
					// 设置该控件不可用
					start.setBounds(180, 330, 140, 40);
				}
				if(e.getSource().equals(help)) {
					help.setBounds(180, 400, 140, 40);;
				}
				if(e.getSource().equals(exit)) {
					exit.setBounds(180, 470, 140, 40);;
				}
				//System.out.println("yichu");
				
			}
			
			
			
}

	// 创建面板，绘制菜单界面的背景图片
	class Background extends JPanel{
		
		Image background;
		public Background() {
			try {
				background = ImageIO.read(new File("image/bg_menu.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(background, 0, 0, 480,700,null);
			
		}
		
		
		
}





