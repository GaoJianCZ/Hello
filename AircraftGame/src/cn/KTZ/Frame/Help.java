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

public  class Help extends JFrame implements MouseListener{	
	
		JLabel tuichu;
		public Help() {
			
			tuichu = new JLabel(new ImageIcon("image/tuichu.png"));
			tuichu.setBounds(442, 0, 38, 40);
			tuichu.addMouseListener(this);
			this.add(tuichu);			
			
			BackImag2 back = new BackImag2();
			this.add(back);
			
			// ���ô���Ļ�������
			this.setSize(480,700);
			this.setLocationRelativeTo(null);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setUndecorated(true);
			// ���ô���ͼ��
			this.setIconImage(new ImageIcon("image/115.png").getImage());
			this.setVisible(true);
		}
		public static void main(String[] args) {
			// ���Ժ��������к����ý���
			//new Help();
			new LoginJFrame();
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			// ���
			if(e.getSource().equals(tuichu)) {
				// ��ת����һ������
				//new CaiDan();
				// �رյ�ǰ����
				dispose();
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
			// ����
			if(e.getSource().equals(tuichu)) {
				tuichu.setBounds(442, 0, 42, 44);				
			}
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// �Ƴ�
			if(e.getSource().equals(tuichu)) {
				tuichu.setBounds(442, 0, 38, 40);				
			}
		}	
		
}
class BackImag2 extends JPanel{
	// ͼƬ����
	Image background;
	public BackImag2() {
		try {
			background = ImageIO.read(new File("image/helpbg.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// ���Ʒ��������Ʊ���ͼƬ
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(background, 0, 0, 480,700,null);
		
	}
	
	
	
}
