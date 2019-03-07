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
	// ��ʼ��Ϸ���˳���Ϸ����ͣͼƬ��ť
	JLabel start,exit,zanting;
	public Zanting() {
		// ����ʼ��Ϸ��ť��ֵ
		start=new JLabel(new ImageIcon("image/z14.png"));
		start.setBounds(130, 180, 138, 50);
		start.addMouseListener(this);
		this.add(start);
		
		// ���˳���Ϸ��ֵ
		exit=new JLabel(new ImageIcon("image/z15.png"));
		exit.setBounds(50, 250, 138, 50);
		exit.addMouseListener(this);
		this.add(exit);
		
		// ����ͣ��ֵͼƬ
		/*zanting=new JLabel(new ImageIcon("image/z13.jpg"));
		zanting.setBounds(30, 50, 300, 100);
		this.add(zanting);*/
		
		/**�������*/
		BackImagee back=new BackImagee();
		this.add(back);
		
		// ���ô����������
		this.setSize(350, 351);
		// ���ô���λ�þ�����ʾ
		this.setLocationRelativeTo(null);
		// ���ô���رհ�ť����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ���ô���˵�������ʾ
		this.setUndecorated(true);
		// ���ô���ͼ��
		this.setIconImage(new ImageIcon("image/logo.png").getImage());
		// ���ô���ɼ�
		this.setVisible(true);
	}		
    // �������
	class BackImagee extends JPanel{
		// ͼƬ����
		Image background;
		public BackImagee() {
			try {
				background=ImageIO.read(new File("image/z10.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// ���Ʊ���ͼƬ
		@Override
		public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(background, 0, 0, null);
		}		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// ������Ϸ
		if(e.getSource().equals(start)) {
			// ������Ϸ����
			//bool = true;
		}
		// �˳��ؿ�
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
