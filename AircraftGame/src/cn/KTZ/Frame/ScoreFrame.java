package cn.KTZ.Frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cn.KTZ.Frame.CaiDan;

public class ScoreFrame extends JFrame implements MouseListener{
	JLabel continu,exit,score;
	int sc;
	public ScoreFrame(int s) {
		sc = s;
		//��������ť��ֵ ͼƬ
				continu=new JLabel(new ImageIcon("image/a2.jpg"));
				continu.setBounds(20, 500,120, 70);
				continu.addMouseListener(this);
				this.add(continu);
		//�˳���ť  ��ֵͼƬ
				exit=new JLabel(new ImageIcon("image/a1.jpg"));
				exit.setBounds(220, 500, 120, 70);
				exit.addMouseListener(this);
				this.add(exit);
		//������ť��ֵͼƬ
				score=new JLabel(new ImageIcon("image/lg1.png"));
				score.setBounds(5, 100, 350, 363);
				this.add(score);
				
				
		//������壬����ӵ�������ȥ
		BackImag back=new BackImag();
		this.add(back);
		//���ô���Ļ�������
		this.setSize(360,574);
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(new ImageIcon("image/logo.png").getImage());
		this.setVisible(true);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.ORANGE);
		g.setFont(new Font("΢���ź�", Font.BOLD, 26));
		g.drawString(""+sc, 150, 320);
	}	
	class BackImag extends JPanel{
	//ͼƬ����
			Image background;
			public BackImag() {
				try {
					background=ImageIO.read(new File("image/bg1.png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//���Ʒ���  ���Ʊ���ͼƬ
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				super.paint(g);
				g.drawImage(background, 0, 0, null);	
			}
		}
	@Override
	public void mouseClicked(MouseEvent e) {
		//�˳���Ϸ����
		if(e.getSource().equals(exit)) {	
	     new CaiDan();
	     dispose();
		}
		if(e.getSource().equals(continu)) {
			new WindowJFrame().Start();
			dispose();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		if(arg0.getSource().equals(exit)) {
			exit.setBounds(220, 501, 120, 70);		
		}
		if(arg0.getSource().equals(continu)) {
			continu.setBounds(20, 501,120, 70);
		}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		if(arg0.getSource().equals(exit)) {
			exit.setBounds(220, 500, 120, 70);		
		}
		if(arg0.getSource().equals(continu)) {
			continu.setBounds(20, 500,120, 70);
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
		//int z=100;
		//new ScoreJFrame(z);
		new LoginJFrame();
	}
}
