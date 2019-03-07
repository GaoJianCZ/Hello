package cn.KTZ.Entity;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import cn.KTZ.Frame.GameFrame;

/**
 * 敌机类
 * @author gaoj
 * */
public class Barrs_1 {
	//图片大小
	public static final int WIDTH = 50;
	public static final int HEIGHT = 50;
	
	BufferedImage [] images;
	BufferedImage bad1,bad2,bad3,bad4,bad5,bad6,img;
	private int x1 ,y1;

	
	//图片
	//Image image;
	//位置
	private int x,y;
	//移动
	private int xSpeed,ySpeed;
	//判断左移、右移变量
	public boolean flag1,flag2;
	//删除计数
	public int count;
	//切换图片
	private int index;
	//随机数
	Random random = new Random();
	//int index = 0;
	//构造方法
	public Barrs_1() {
		initBad();
		images = new BufferedImage [] {img,bad1,bad2,bad3,bad4,bad5,bad6};
		
		x = random.nextInt(GameFrame.WIDTH)+1;
		y = 0-random.nextInt(200);
		xSpeed = 2;
		ySpeed = 2;
		flag1 = true;
		flag2 = false;
		count = 5;
	}
	//移动
	public void step() {
		if(flag1) {
			x-=xSpeed;
			y+=ySpeed;
			if(x<=0) {
				x = 0;
				flag1 = false;
			}
		}else {
			x+=xSpeed;
			y+=ySpeed;
			if(x>=GameFrame.WIDTH-WIDTH) {
				x = GameFrame.WIDTH-WIDTH;
				flag1 = true;
			}
		}
	}
	//绘制
	public void paintBarrs_1(Graphics g) {
		//index++;
		if(flag2) {
			index++;
		}
		g.drawImage(images[index/5%images.length], x1=getX(), y1=getY(), WIDTH,HEIGHT,null);
	}
	
	private void initBad() {
		// TODO Auto-generated method stub
		try {
			img = ImageIO.read(new File("image/a2-"+(random.nextInt(9)+1)+".png"));
			bad1 = ImageIO.read(new File("image/bomb1.png"));
			bad2 = ImageIO.read(new File("image/bobm2.png"));
			bad3 = ImageIO.read(new File("image/bobm3.png"));
			bad4 = ImageIO.read(new File("image/bobm4.png"));
			bad5 = ImageIO.read(new File("image/bobm5.png"));
			bad6 = ImageIO.read(new File("image/bobm6.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public boolean isFlag1() {
		return flag1;
	}
	public void setFlag1(boolean flag1) {
		this.flag1 = flag1;
	}
	public boolean isFlag2() {
		return flag2;
	}
	public void setFlag2(boolean flag2) {
		this.flag2 = flag2;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	
	
}
