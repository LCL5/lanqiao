import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	int x,y;

	Image heroLeftImg[]=new Image[3];
	Image heroRightImg[]=new Image[3];
	Image heroUpImg[]=new Image[3];
	Image heroDownImg[]=new Image[3];

	int leftFlag,rightFlag,upFlag,downFlag;
	Image currentImg; /*img,img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,*/
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			for(int i=0;i<3;i++){
				heroLeftImg[i]=Image.createImage("/sayo"+i+"2.png");
			}
			//左
			/*img4=Image.createImage("/sayo02.png");
			img1=Image.createImage("/sayo12.png");
			img5=Image.createImage("/sayo22.png");*/

            //下
			for(int i=0;i<3;i++){
				heroDownImg[i]=Image.createImage("/sayo"+i+"0.png");
			}
			/*img=Image.createImage("/sayo10.png");
			img10=Image.createImage("/sayo00.png");
			img11=Image.createImage("/sayo20.png");*/

			//上
			for(int i=0;i<3;i++){
				heroUpImg[i]=Image.createImage("/sayo"+i+"4.png");
			}
			/*img2=Image.createImage("/sayo14.png");
			img8=Image.createImage("/sayo04.png");
			img9=Image.createImage("/sayo24.png");*/

			//右
			for(int i=0;i<3;i++){
				heroRightImg[i]=Image.createImage("/sayo"+i+"6.png");
			}
			/*img3=Image.createImage("/sayo16.png");
			img6=Image.createImage("/sayo06.png");
			img7=Image.createImage("/sayo26.png");*/
			
			currentImg=heroDownImg[1];

			x=120;
			y=100;

			leftFlag=1;
			rightFlag=1;
			upFlag=1;
			downFlag=1;

		}

		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			if(leftFlag==1){
				currentImg=heroLeftImg[0];
				leftFlag++;
			}
				else if(leftFlag==2){
					currentImg=heroLeftImg[2];
					leftFlag=1;
				}
			//currentImg=heroLeftImg[1];
			System.out.println("向左转");
			repaint();
			x=x-10;
		}
		if(action==UP){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			if(upFlag==1){
				currentImg=heroUpImg[0];
				upFlag++;
			}
				else if(upFlag==2){
					currentImg=heroUpImg[2];
					upFlag=1;
				}
			//currentImg=heroUpImg[1];
			System.out.println("向上转");
			repaint();
			y=y-10;
		}
		if(action==RIGHT){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			if(rightFlag==1){
				currentImg=heroRightImg[0];
				rightFlag++;
			}
				else if(rightFlag==2){
					currentImg=heroRightImg[2];
					rightFlag=1;
				}
			//currentImg=heroRightImg[1];
			System.out.println("向右转");
			repaint();
			x=x+10;
		}
		if(action==DOWN){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			if(downFlag==1){
				currentImg=heroDownImg[0];
				downFlag++;
			}
				else if(downFlag==2){
					currentImg=heroDownImg[2];
					downFlag=1;
				}
			//currentImg=heroDownImg[1];
			System.out.println("向下转");
			repaint();
			y=y+10;
		}
	}
}