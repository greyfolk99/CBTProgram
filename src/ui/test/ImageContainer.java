package ui.test;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dto.QuestionDTO;

public class ImageContainer extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int width;
	int height;
	final String url = "src//image//";
	
	/** JPanel 상속 클래스, 입력 파라미터 QuesitonDTO **/
	ImageContainer(QuestionDTO q) throws IOException{
    setSize(700,700);
    Image img = setImageFile(q.getReference());
    Image changeImg =img.getScaledInstance(img.getWidth(null)-100, img.getHeight(null)-100, Image.SCALE_SMOOTH);
    
    ImageIcon icon = new ImageIcon(changeImg);
    JLabel label = new JLabel(icon);
    label.addAncestorListener(null);
    label.addMouseListener(new MouseAdapter() {
       @Override
       public void mouseClicked(MouseEvent e) {
          JFrame frame = new JFrame();
          ImageIcon originalIcon = new ImageIcon(img);
          JLabel label2 = new JLabel(originalIcon);
          frame.setSize(img.getWidth(null)+100, img.getHeight(null)+100);
          frame.add(label2);
          frame.setVisible(true);
       }
    });
    add(label);
    setVisible(true);
	}
	public Image setImageFile(String str) throws IOException {
		BufferedImage img = null;
		//File file = new File(url+q.getReference());
			img = ImageIO.read(new File(url+str));
			width = img.getWidth();
			height = img.getHeight();
		return img;
	}
 }