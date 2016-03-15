package testttt;


import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class randerer extends DefaultListCellRenderer  implements ListCellRenderer<Object>  
{
	private String chemain;
	@Override
	
    public Component getListCellRendererComponent(JList<?> list,Object value, int index, boolean isSelected, boolean cellHasFocus) {
      
		setEnabled(true);
		ImgText is=(ImgText)value;
		chemain=is.getName().substring(is.getName().lastIndexOf('\\') +1,is.getName().length());
		System.out.println(chemain);
		setText(chemain);
		setIcon(new ImageIcon("img/Excel.png"));
		//setBackground(new Color(255, 255, 255));
		if(isSelected){
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		}
		
		else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
			
		}
		setEnabled(true);
		setFont(list.getFont());
		
		return this;
    }

}
