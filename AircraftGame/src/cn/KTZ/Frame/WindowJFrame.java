package cn.KTZ.Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 * ��Ϸ�������
 * */

public class WindowJFrame extends JFrame implements Runnable{

	//����ͼƬ hbg.jpg
	JLabel backImage;
	//������
	JProgressBar jdt;
	//��������
	public void Start() {
		WindowJFrame frame = new WindowJFrame();
		//����һ���̣߳�����frame����
		Thread thread = new Thread(frame);
		//�����߳�
		thread.start();
        dispose();
	}
	public WindowJFrame() {
		backImage = new JLabel(new ImageIcon("image/logo1.png"));
		jdt = new JProgressBar();//����������
		
		//���ý�������ɫ
		
		jdt.setForeground(Color.blue); 
		//jdt.setBackground(Color.green);
		this.add(backImage,BorderLayout.NORTH);
		
		//���ý������ַ�����ֵ
		jdt.setStringPainted(true);
		this.add(jdt,BorderLayout.SOUTH);
		this.setUndecorated(true);
		this.setSize(480,700);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//����ͼƬ480*680
		this.setIconImage(new ImageIcon("image/logo.png").getImage());		
	}
	public static void main(String[] args) {
       // new WindowJFrame().Start();
		new LoginJFrame();
		
	}
	@Override
	public void run() {
		// ��������ֵ
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
		//��ת�������棬
		dispose();
		new GameFrame();
		//�رյ�ǰҳ��
		
	}

}
