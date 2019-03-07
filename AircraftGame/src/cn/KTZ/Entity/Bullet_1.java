package cn.KTZ.Entity;
/**
 * 敌机子弹类
 * */
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bullet_1 {
	//子弹大小
	public static final int Z_WIDTH = 10;
	public static final int Z_HEIGHT = 15;
	//子弹图片
	Image image_1;
	private int xSpeed;
	//子弹的位置
	private int zx,zy;
	//获取敌机位置生成子弹，接受位置参数
	public  Bullet_1(int x ,int y) {
		zx = x;
		zy = y;
		xSpeed = 3;
		image_1 = new ImageIcon("image/zidan1.png").getImage();
	}
	//绘制
	public void paintBullet_1(Graphics g) {
		g.drawImage(image_1, zx, zy, Z_WIDTH, Z_HEIGHT, null);
	}
	//移动	
	public void step() {
		zy+=xSpeed;
	}

	public int getZx() {
		return zx;
	}

	public void setZx(int zx) {
		this.zx = zx;
	}

	public int getZy() {
		return zy;
	}

	public void setZy(int zy) {
		this.zy = zy;
	}

		
}
