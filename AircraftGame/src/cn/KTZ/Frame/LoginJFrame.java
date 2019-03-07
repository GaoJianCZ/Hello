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
 * 游戏登录界面
 * @author Liu
 * **/

public class LoginJFrame extends JFrame{
	//用户名:  JLabel 存储文字，图片，图形文字
		JLabel userLabel;	
		//用户密码
		JLabel pwdLabel;	
		//用户名文本输入框
		JTextField userText;
		//密码输入框
		JPasswordField pwdText;
		//登陆按钮
		JButton loginBtn;
		//取消按钮
		JButton cancelBtn;
		//用户名输入框的内容
		String userName;
		//密码输入框的内容
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
				//循环播放该音乐
				mus.loop();
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    	/**用户名密码的添加*/
	    	userLabel =new JLabel("用户名:");
	    	userLabel.setBounds(300, 170, 150, 30);
	    	userLabel.setForeground(Color.black);
	    	this.add(userLabel);
	    	
	    	pwdLabel =new JLabel("密     码:");
	    	pwdLabel.setBounds(300, 210, 150, 30);
	        pwdLabel.setForeground(Color.black);//设置前景色
	    	this.add(pwdLabel);
	    	
	    	/**创建并添加用户名输入框 密码输入框*/
	    	userText = new JTextField();
	    	userText.setBounds(350, 175, 115, 25);
	    	//设置输入框的凹陷效果
	    	userText.setBorder(BorderFactory.createLoweredBevelBorder());
	    	this.add(userText);
	    	
	    	pwdText = new JPasswordField();
	    	pwdText.setBounds(350, 210, 115, 25);
	    	pwdText.setBorder(BorderFactory.createLoweredBevelBorder());
	    	this.add(pwdText);
	    	
	    	loginBtn = new JButton("登录");	    	
	    	loginBtn.setBounds(330, 250, 60, 30);
	    	loginBtn.setForeground(Color.BLUE);
	    	loginBtn.setBorder(BorderFactory.createLineBorder(Color.green));
	    	/**添加登录按钮事件监听*/
	    	loginBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 监听按钮的方法（点击按钮所执行的事件）
					//获取用户名输入框的内容
				    userName=userText.getText();
				    userPwd=pwdText.getText();
				    
				    if(userName.equals("")) {
				    	//设置弹窗
				    	JOptionPane.showMessageDialog(null, "用户名不能为空");
				    }else if(userName.equals("开拓者")==false) {
				    	JOptionPane.showMessageDialog(null, "用户名错误");			   
				    }else if(userPwd.equals("123")==false) {
				    	JOptionPane.showMessageDialog(null, "密码错误");
				    }
				    if(userName.equals("开拓者")==true 
				    	&& userPwd.equals("123")==true) {
				    	JOptionPane.showMessageDialog(null, "登录成功");
				    	//界面跳转
				    	new CaiDan();
				    	//关闭当前界面
				    	dispose();
				    	//System.exit(0);
				    }
				    
					//System.out.println("用户名是:"+userName);
					//System.out.println("密码是:"+userPwd);
				}
			});
	    	
	    	
	    	this.add(loginBtn);
	    	
	    	cancelBtn = new JButton("退出");
	    	cancelBtn.setBounds(420, 250, 60, 30);
	    	cancelBtn.setForeground(Color.BLUE);
	    	cancelBtn.setBorder(BorderFactory.createLineBorder(Color.green));
	    	/**添加取消按钮事件监听*/
	    	
	    	
	    	cancelBtn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					System.exit(0);//取消按钮点击关闭
				}
			});
	    	
	    	this.add(cancelBtn);
	    	
	    	/**创建面板，并添加到窗体上去*/
	    	   BackImage back = new BackImage();
	    	   //设置面板的边界大小
	    	   back.setBounds(0, 0, 570, 342);
	    	   //添加面板
	    	   this.add(back);
	    	   this.setTitle(" 雷霆战机 ");
	    	//设置窗体的基本属性
	    	this.setSize(570,342);
	    	//设置居中
	    	this.setLocationRelativeTo(null);
	    	//设置窗体菜单栏不显示
	    	this.setUndecorated(true);
	    	//设置窗体图标按钮
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
	//背景图片变量
	Image backgroud;
	public BackImage() {
		try {
			//给background变量赋值
			backgroud = ImageIO.read(new File("image/beijin.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//绘制方法
	@Override
	public void paint(Graphics g) {
		//绘制背景图片
	super.paint(g);
	g.drawImage(backgroud, 0, 0, null);
	
	}
}
