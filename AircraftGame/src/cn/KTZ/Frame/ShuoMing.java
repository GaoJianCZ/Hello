package cn.KTZ.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**@author liul*/
public class ShuoMing extends JFrame implements MouseListener{
	
	JLabel tui;
	public ShuoMing() {
		
		
		tui=new JLabel(new ImageIcon("image/tui.png"));
		//tui.setBorder(BorderFactory.createLoweredBevelBorder());
		tui.setBounds(307, 0, 50,30);
		//���ÿؼ�������
		//tui.setEnabled(false);
		//start�ؼ�������¼�
		tui.addMouseListener(this);
		this.add(tui);
				
		BackImages back=new BackImages();
		this.add(back);		
		
		this.setUndecorated(true);
		this.setSize(360,574);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���ô���ͼ��
		this.setIconImage(new ImageIcon("image/logo.png").getImage());
		this.setVisible(true);
	}

	private void setRootPane(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new ShuoMing();
		new LoginJFrame();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(tui)) {		
			//�رյ�ǰ����
			//tui=new JLabel(new ImageIcon("image/tui.png"));
			//k1.setBorder(BorderFactory.createLoweredBevelBorder());
			//���ÿؼ�������
			//k1.setEnabled(false);
			//start�ؼ�������¼�
			//tui.addMouseListener(this);
			//this.add(tui);
			dispose();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(tui)) {
			tui.setBounds(307, 1, 50,30);
			//���øÿؼ�����
			//tui.setEnabled(true);
			}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(tui))
		{
			tui.setBounds(307, 0, 50,30);
			//tui.setEnabled(false);
			
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

}
/**������壬���Ʊ���ͼƬ*/
class BackImages extends JPanel{
	Image shuo;
	public BackImages() {
		// TODO Auto-generated constructor stub
		try {
			shuo=ImageIO.read(new File("image/shuo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(shuo,0, 0,360, 575, null);
	}


}










