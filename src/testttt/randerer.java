package testttt;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class randerer extends DefaultListCellRenderer  implements ListCellRenderer<Object>  
{
	@Override
	
    public Component getListCellRendererComponent(JList<?> list,Object value, int index, boolean isSelected, boolean cellHasFocus) {
      
		setEnabled(true);
		
		ImgText is=(ImgText)value;
		
		setText(is.getName());
		setIcon(new ImageIcon("img/Excel.png"));
		//setBackground(new Color(255, 255, 255));
		
		return this;
    }

}
