package cn.KTZ.Entity;
/**
 * �л��ӵ���
 * */
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Bullet_1 {
	//�ӵ���С
	public static final int Z_WIDTH = 10;
	public static final int Z_HEIGHT = 15;
	//�ӵ�ͼƬ
	Image image_1;
	private int xSpeed;
	//�ӵ���λ��
	private int zx,zy;
	//��ȡ�л�λ�������ӵ�������λ�ò���
	public  Bullet_1(int x ,int y) {
		zx = x;
		zy = y;
		xSpeed = 3;
		image_1 = new ImageIcon("image/zidan1.png").getImage();
	}
	//����
	public void paintBullet_1(Graphics g) {
		g.drawImage(image_1, zx, zy, Z_WIDTH, Z_HEIGHT, null);
	}
	//�ƶ�	
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
