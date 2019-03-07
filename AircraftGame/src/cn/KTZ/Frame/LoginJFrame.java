package cn.KTZ.Frame;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * ��Ϸ��¼����
 * @author Liu
 * **/

public class LoginJFrame extends JFrame{
	//�û���:  JLabel �洢���֣�ͼƬ��ͼ������
		JLabel userLabel;	
		//�û�����
		JLabel pwdLabel;	
		//�û����ı������
		JTextField userText;
		//���������
		JPasswordField pwdText;
		//��½��ť
		JButton loginBtn;
		//ȡ����ť
		JButton cancelBtn;
		//�û�������������
		String userName;
		//��������������
		String userPwd;
		
		File f1;
		URL url;
		URI uri;
		AudioClip mus;
		
		public LoginJFrame() {
			f1=new File("sound/main.wav");
        	uri=f1.toURI();
        	try {
				url=uri.toURL();
				mus=Applet.newAudioClip(url);
				//ѭ�����Ÿ�����
				mus.loop();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    	/**�û�����������*/
	    	userLabel =new JLabel("�û���:");
	    	userLabel.setBounds(300, 170, 150, 30);
	    	userLabel.setForeground(Color.black);
	    	this.add(userLabel);
	    	
	    	pwdLabel =new JLabel("��     ��:");
	    	pwdLabel.setBounds(300, 210, 150, 30);
	        pwdLabel.setForeground(Color.black);//����ǰ��ɫ
	    	this.add(pwdLabel);
	    	
	    	/**����������û�������� ���������*/
	    	userText = new JTextField();
	    	userText.setBounds(350, 175, 115, 25);
	    	//���������İ���Ч��
	    	userText.setBorder(BorderFactory.createLoweredBevelBorder());
	    	this.add(userText);
	    	
	    	pwdText = new JPasswordField();
	    	pwdText.setBounds(350, 210, 115, 25);
	    	pwdText.setBorder(BorderFactory.createLoweredBevelBorder());
	    	this.add(pwdText);
	    	
	    	loginBtn = new JButton("��¼");	    	
	    	loginBtn.setBounds(330, 250, 60, 30);
	    	loginBtn.setForeground(Color.BLUE);
	    	loginBtn.setBorder(BorderFactory.createLineBorder(Color.green));
	    	/**��ӵ�¼��ť�¼�����*/
	    	loginBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// ������ť�ķ����������ť��ִ�е��¼���
					//��ȡ�û�������������
				    userName=userText.getText();
				    userPwd=pwdText.getText();
				    
				    if(userName.equals("")) {
				    	//���õ���
				    	JOptionPane.showMessageDialog(null, "�û�������Ϊ��");
				    }else if(userName.equals("������")==false) {
				    	JOptionPane.showMessageDialog(null, "�û�������");			   
				    }else if(userPwd.equals("123")==false) {
				    	JOptionPane.showMessageDialog(null, "�������");
				    }
				    if(userName.equals("������")==true 
				    	&& userPwd.equals("123")==true) {
				    	JOptionPane.showMessageDialog(null, "��¼�ɹ�");
				    	//������ת
				    	new CaiDan();
				    	//�رյ�ǰ����
				    	dispose();
				    	//System.exit(0);
				    }
				    
					//System.out.println("�û�����:"+userName);
					//System.out.println("������:"+userPwd);
				}
			});
	    	
	    	
	    	this.add(loginBtn);
	    	
	    	cancelBtn = new JButton("�˳�");
	    	cancelBtn.setBounds(420, 250, 60, 30);
	    	cancelBtn.setForeground(Color.BLUE);
	    	cancelBtn.setBorder(BorderFactory.createLineBorder(Color.green));
	    	/**���ȡ����ť�¼�����*/
	    	
	    	
	    	cancelBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					System.exit(0);//ȡ����ť����ر�
				}
			});
	    	
	    	this.add(cancelBtn);
	    	
	    	/**������壬����ӵ�������ȥ*/
	    	   BackImage back = new BackImage();
	    	   //�������ı߽��С
	    	   back.setBounds(0, 0, 570, 342);
	    	   //������
	    	   this.add(back);
	    	   this.setTitle(" ����ս�� ");
	    	//���ô���Ļ�������
	    	this.setSize(570,342);
	    	//���þ���
	    	this.setLocationRelativeTo(null);
	    	//���ô���˵�������ʾ
	    	this.setUndecorated(true);
	    	//���ô���ͼ�갴ť
	    	this.setIconImage(new ImageIcon("image/logo.jpg").getImage());
	    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	this.setVisible(true);
	    	
	    }		
		

	public static void main(String[] args) {
		new LoginJFrame();

	}

}
class BackImage extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����ͼƬ����
	Image backgroud;
	public BackImage() {
		try {
			//��background������ֵ
			backgroud = ImageIO.read(new File("image/beijin.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//���Ʒ���
	@Override
	public void paint(Graphics g) {
		//���Ʊ���ͼƬ
	super.paint(g);
	g.drawImage(backgroud, 0, 0, null);
	
	}
}
