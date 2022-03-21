package oop.project;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.text.AttributedCharacterIterator;

import javax.imageio.ImageIO;


public class draw {
	
	public void drawBaseObject(int x,int y,object.buttonModeEnum mode,Graphics g) {
		BufferedImage bi = null ;
		try {
			String relativelyPath=System.getProperty("user.dir");
			System.out.println(relativelyPath);
			
			 bi=ImageIO.read(new File("./src/Resources/UseCaseIcon.png"));
			 System.out.println("image OK");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("image path error");
		}
		
		System.out.println("draw");
		if (mode.equals(object.buttonModeEnum.useCaseMode)) {
			
			g.drawImage(bi, 10, 10, null);
		}
		else if (mode.equals(object.buttonModeEnum.classMode)) {
			g.drawImage(bi, x, y, null);
		}
	}
}
