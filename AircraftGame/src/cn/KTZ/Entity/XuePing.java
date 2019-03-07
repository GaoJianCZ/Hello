package cn.KTZ.Entity;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class XuePing {
	//子弹大小
	public static final int X_WIDTH = 40;
	public static final int X_HEIGHT = 40;
	//子弹图片
	//BufferedImage image_1;
	//BufferedImage [] image_1s;
	Image image_1;
	private int ySpeed;
	//子弹的位置
	private int xx;
	private int xy;
	public  XuePing(int x,int y) {
		xx = x;
		xy = y;
		ySpeed = 2;
		image_1 = new ImageIcon("image/img.png").getImage();
	}
	
	public void paintXueping(Graphics g) {
		g.drawImage(image_1, xx, xy, X_WIDTH, X_HEIGHT, null);
	}
	
	public void step() {
		xy+=ySpeed;
	}

	public Image getImage_1() {
		return image_1;
	}

	public void setImage_1(Image image_1) {
		this.image_1 = image_1;
	}

	public int getxSpeed() {
		return ySpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.ySpeed = xSpeed;
	}

	public  int getXx() {
		return xx;
	}

	public void setXx(int xx) {
		this.xx = xx;
	}

	public  int getXy() {
		return xy;
	}

	public void setXy(int xy) {
		this.xy = xy;
	}


	
	
}
