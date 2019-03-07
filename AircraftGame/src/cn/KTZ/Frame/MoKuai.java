package cn.KTZ.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoKuai extends JFrame implements MouseListener{
	 JLabel k1,k2,k3,k4,k5,k6;
	
	//��������
	public MoKuai() {
	
	k1=new JLabel(new ImageIcon("image/k1.png"));
	//k1.setBorder(BorderFactory.createLoweredBevelBorder());
	k1.setBounds(377, 646, 142,44);
	//���ÿؼ�������
	//k1.setEnabled(false);
	//start�ؼ�������¼�
	k1.addMouseListener(this);
	this.add(k1);
			
	k2=new JLabel(new ImageIcon("image/k2.png"));
	//k2.setBorder(BorderFactory.createLoweredBevelBorder());
	k2.setBounds(63,400, 352,74);
	//���ÿؼ�������
	k2.setEnabled(true);
	//start�ؼ�������¼�
	k2.addMouseListener(this);
	this.add(k2);
				
	k3=new JLabel(new ImageIcon("image/k3.png"));
	//k3.setBorder(BorderFactory.createLoweredBevelBorder());
	k3.setBounds(63, 300, 352,74);
	//���ÿؼ�������
	k3.setEnabled(true);
	//start�ؼ�������¼�
	k3.addMouseListener(this);
	this.add(k3);					
					
	k4=new JLabel(new ImageIcon("image/k4.png"));
	k4.setBounds(63, 200,  352,74);
   //k4.setBorder(BorderFactory.createLoweredBevelBorder());
	//���ÿؼ�������
	k4.setEnabled(true);
	//start�ؼ�������¼�
	k4.addMouseListener(this);
	this.add(k4);

    k6=new JLabel(new ImageIcon("image/33.png"));
    k6.setBounds(370, 0,130,50);
	k6.addMouseListener(this);
    this.add(k6);												
	
	BackImag back=new BackImag();
	this.add(back);
		
	//��������
	this.setSize(500,700);
		
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setUndecorated(true);

		
	//���ô���ͼ��
	this.setIconImage(new ImageIcon("image/logo.png").getImage());
	this.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //new MoKuai();
		new LoginJFrame();
	}
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {	
		// ������¼�
		if(e.getSource().equals(k1)) {
			//������ת
			new CaiDan();
			dispose();
		}				
		if(e.getSource().equals(k6)) {
			//������ת
			new ShuoMing();
			//�رյ�ǰ����
			//dispose();
		}
		if(e.getSource().equals(k4)) {
			new WindowJFrame().Start();
			dispose();
		}
		if(e.getSource().equals(k2)) {
			new WindowJFrame().Start();
			dispose();
		}
		if(e.getSource().equals(k3)) {
			new WindowJFrame().Start();
			dispose();
		}
				
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(k1)) {
			//���øÿؼ�����
			//k1.setEnabled(true);
			k1.setBounds(377, 647, 142,44);
			}
		if(e.getSource().equals(k2)) {
			//���øÿؼ�����
			//k2.setEnabled(true);
			k2.setBounds(63, 401, 352,74);
			//k2=new JLabel(new ImageIcon("image/k2.png"));
		}
		if(e.getSource().equals(k3)) {
			//���øÿؼ�����
			//k3.setEnabled(true);
			k3.setBounds(63, 301, 352,74);
		}
		if(e.getSource().equals(k4)) {
			//���øÿؼ�����
			//k4.setEnabled(true);
			k4.setBounds(63, 201,  352,74);
		}
		if(e.getSource().equals(k6)) {
			//���øÿؼ�����
			 k6.setBounds(370, 1,130,50);
			//k6.setEnabled(true);
		}		
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(k1))
		{
			//k1.setEnabled(false);
		
			k1.setBounds(377, 646, 142,44);
			
		}
		if(e.getSource().equals(k2))
		{
			//k2.setEnabled(false);
			k2.setBounds(63, 400, 352,74);
			
			//k2=new JLabel(new ImageIcon("image/k21.png"));
			
		}if(e.getSource().equals(k3))
		{
			//k3.setEnabled(false);
			k3.setBounds(63, 300, 352,74);
			
		}if(e.getSource().equals(k4))
		{
			//k4.setEnabled(false);
			k4.setBounds(63, 200,  352,74);
			
		}
		if(e.getSource().equals(k6))
		{
			//k6.setEnabled(false);
			 k6.setBounds(370, 0,130,50);
		}
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
	
			
		}
	
	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

/**������壬���Ʊ���ͼƬ*/
class BackImag extends JPanel{
	Image background;
	public BackImag() {
		try {
			background=ImageIO.read(new File("image/background.png"));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawImage(background, 0,0, 500,750,null);
	}
	
}
















