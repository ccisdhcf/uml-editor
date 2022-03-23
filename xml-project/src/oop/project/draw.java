package oop.project;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;


public class draw {
	
	public void drawBaseObject(int x,int y,SharedObject.buttonModeEnum mode,Graphics g) {
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
		if (mode.equals(SharedObject.buttonModeEnum.useCaseMode)) {
			
			g.drawImage(bi, 10, 10, null);
		}
		else if (mode.equals(SharedObject.buttonModeEnum.classMode)) {
			g.drawImage(bi, x, y, null);
		}
	}
}
