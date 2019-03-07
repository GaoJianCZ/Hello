package cn.KTZ.Entity;
/**
 * @author gaoj
 * */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Aircraft {

	//飞机大小
	public static final int WIDTH = 70;
	public static final int HEIGHT = 70;	
	//飞机图片
	BufferedImage  [] images;
	BufferedImage img1,img2;
	//飞机位置
	public int x;
	public int y;
	int index=0;
	//获得分数
	private int score;
	//生命值
	private  int life;
	
	public Aircraft() {
		//bullet = new Bullet();
		x = 215;
		y = 620;		
		life = 100;
		score = 0;
		initImg();
		images = new BufferedImage [] {img1,img2};		
	}
	
	private void initImg() {
		// TODO Auto-generated method stub
		try {
			img1 = ImageIO.read(new File("image/feiji1.png"));
			img2 = ImageIO.read(new File("image/feijiw.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//绘制方法
	public void paintAircraft(Graphics g) {
		index++;
		g.drawImage(images[index/20%images.length], x, y, WIDTH, HEIGHT, null);
	}
	
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public  int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	
	
	
}
