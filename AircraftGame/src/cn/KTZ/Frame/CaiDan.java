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
 * ��Ϸ�˵�����
 * ��Ϸ��壺����ͼƬ
 * ͼƬ��ť����ʼ��Ϸ���������뿪
 * */
public class CaiDan extends JFrame implements MouseListener{
	// ��ʼ  ����   �˳�  ����ͼƬ��ť
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
				// ѭ�����������ļ�
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
				
			//��������壬����ӵ�������ȥ
			Background back = new Background();
			this.add(back);				
				
			// ���ô���Ļ�������
			this.setSize(480,700);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setUndecorated(true);
			// ���ô���ͼ��
			this.setIconImage(new ImageIcon("image/logo.png").getImage());
			this.setVisible(true);
		}
		
		public static void main(String[] args) {
			// ���Ժ��������к����ý���
			new LoginJFrame();
			//new CaiDan();

		}
			@Override
			public void mouseClicked(MouseEvent e) {
				// ������¼�
				if(e.getSource().equals(start)) {
					// ��ת����һ������
					new MoKuai();
					// �رձ�������
					//aau.stop();
					// �رյ�ǰ����
					dispose();
				}
				if(e.getSource().equals(help)) {
					// ��ת����һ������
					new Help();					
				}
				if(e.getSource().equals(exit)) {
					// �رյ�ǰ����
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
				
				// ��������¼�
				// �������������start�ؼ���Χ
				if(e.getSource().equals(start)) {
					// ���øÿؼ�����
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
				// ����Ƴ��¼�
				// �������Ƴ�start�ؼ���Χ
				if(e.getSource().equals(start)) {
					// ���øÿؼ�������
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

	// ������壬���Ʋ˵�����ı���ͼƬ
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





