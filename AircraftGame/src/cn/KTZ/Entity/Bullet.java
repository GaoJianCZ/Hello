package cn.KTZ.Entity;
/**
 * 玩家子弹类
 * @author gaoj
 * */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet {
	//子弹大小
	public static final int Z_WIDTH = 20;
	public static final int Z_HEIGHT = 25;
	
	public static final int Z1_WIDTH = 30;
	public static final int Z1_HEIGHT = 45;
	//子弹图片
	//BufferedImage image_1;
	BufferedImage [] images;
	BufferedImage img1,img2,img3;
	//Image image_1;
	private int ySpeed;
	//子弹的位置
	private int zx;
	private int zy;
	public int index=0;
	public  Bullet(int x,int y) {
		zx = x+25;
		zy = y;
		ySpeed = 10;
		initImg();
		images = new BufferedImage [] {img1,img2,img3};
	}
	
	private void initImg() {
		// TODO Auto-generated method stub
		try {
			img1 = ImageIO.read(new File("image/jizhong1.png"));
			img2 = ImageIO.read(new File("image/jizhong.png"));
			img3 = ImageIO.read(new File("image/zidan.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void paintBullet(Graphics g) {
		if(index==0) {
			g.drawImage(images[index], zx, zy, Z_WIDTH, Z_HEIGHT, null);
		}else if(index==1){
			g.drawImage(images[index], zx-5, zy, Z1_WIDTH, Z1_HEIGHT, null);
		}else if(index==2){
			g.drawImage(images[index], zx-5, zy, Z1_WIDTH, Z1_HEIGHT, null);
		}
	}
	
	public void step() {
		zy-=ySpeed;
	}


	public int getxSpeed() {
		return ySpeed;
	}

	public void setxSpeed(int xSpeed) {
		this.ySpeed = xSpeed;
	}

	public  int getZx() {
		return zx;
	}

	public void setZx(int zx) {
		this.zx = zx;
	}

	public  int getZy() {
		return zy;
	}

	public void setZy(int zy) {
		this.zy = zy;
	}

	public static int getzWidth() {
		return Z_WIDTH;
	}

	public static int getzHeight() {
		return Z_HEIGHT;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	
	
}
