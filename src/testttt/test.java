package testttt;




import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.TabStop;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.ImageView;
import javax.swing.text.html.StyleSheet;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.DropMode;
import javax.swing.JTextArea;

import org.apache.poi.hssf.util.HSSFColor.BLACK;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JProgressBar;
import javax.swing.JLayeredPane;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class test extends JFrame{
	private JLabel add;
	private Map attributes;
	private JButton converter;
	private JButton convertRar;
	private JTextField TVA;
	private JTextField TTC;
	private JTextField HT;
	private JLabel labeltva;
	private JLabel labelht;
	private JLabel labelttc;
	private JPanel principal;
	private JPanel haut;
	private JPanel gauche;
	private JPanel bas;
	private JLabel l1;
	private JMenuBar menuBar;
	private JMenu menu1;
	private JMenu menu2;
	private JMenu menu3;
	private JMenu menu4;
	private JMenuItem importer;
	private JMenuItem quitter;
	private JMenuItem aide;
	private JMenuItem guide;
	private JMenuItem sinfelec;
	private JMenuItem convertir;
	private Font font;
	private JMenuItem retirer;
	private JMenuItem tout_selectionner;
	private int counter = 0;
	private JFileChooser XLSChooser = null;
	  private JFileChooser FolderChooser = null;
	  private String message = "";
	  private String msge = "";
	  private String workbookName = "";
	  private JButton jButton3;
	  private JButton jButton5;
	  //private JComboBox jComboBox1;
	  private JLabel myLabel;
	  private JLabel jLabel1;
	  private JLabel jLabel2;
	  private JLabel jLabel3;
	  private JLabel jLabel4;
	  private JLabel jLabel5;
	  private JScrollPane jScrollPane2;
	  private JTextField jTextField2;
	  private JTextPane jTextPane1;
	  private String st;
	  private int IdentifiantFiscal;
	  DefaultListModel dlm1 = new DefaultListModel();
	  private JTextPane textPane;
	  private JScrollPane jScrollPane1;
	  private JTextArea txtidf;
	  private JTextArea txtperiode;
	  private String url;
      private String path;
      private String zipName;
      private JList list;
      private DefaultListModel listmodel;
     private String indices=null;
     // private String labels[]=null;
	public test() {
		// TODO Auto-generated constructor stub
		initComponents();
		lire();
	   		
		setSize(900, 700);
		setTitle("Easy TVA");
		getContentPane().setBackground(new Color(146, 145, 145));
		
		setResizable(false);
		setLocationRelativeTo(null);
		//setPreferredSize(new Dimension(10000, 10000));
	}
	 private void initComponents()
	  {	
		 this.add = new JLabel("Ajouter");
		 this.convertRar = new JButton("");
		 convertRar.setIcon(new ImageIcon("img/cheked.png"));
		 convertRar.setToolTipText("Convertir en .zip");
		 convertRar.setFocusPainted( false );
		 convertRar.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 		
		 		rar(url);
		 		textPane.setText("");
				TVA.setText("");
				TTC.setText("");
				HT.setText("");
				txtidf.setText("");
		    	txtperiode.setText("");
		 	}
		 });
		 this.labeltva = new JLabel("TVA :");
		 font = labeltva.getFont();
	   	 attributes = font.getAttributes();
		 attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		 convertRar.setBounds(555, 17, 35, 35);
		 this.HT = new JTextField(20);
		 HT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 HT.setHorizontalAlignment(SwingConstants.CENTER);
		 HT.setBackground(Color.WHITE);
		 HT.setBounds(146, 9, 123, 23);
		 this.TTC = new JTextField(20);
		 TTC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 TTC.setHorizontalAlignment(SwingConstants.CENTER);
		 TTC.setBackground(Color.WHITE);
		 
		 TTC.setBounds(383, 9, 123, 23);
		 this.TVA = new JTextField(20);
		 TVA.setHorizontalAlignment(SwingConstants.CENTER);
		 TVA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 TVA.setForeground(new Color(255, 0, 0));
		 TVA.setBackground(Color.WHITE);
		 TVA.setBounds(146, 45, 123, 23);
		 this.HT.setEditable(false);
		 this.TTC.setEditable(false);
		 this.TVA.setEditable(false);
		 this.labelht = new JLabel("Montant hors taxe");
		 this.labelht.setFont(font.deriveFont(attributes));
		 this.labelht = new JLabel("Montant HT :");
		 this.labelht.setFont(font.deriveFont(attributes));
		 labelht.setBackground(new Color(220, 220, 220));
		 this.labelht.setForeground(new Color(0, 51, 153));
		 labelht.setBounds(23, 9, 113, 23);
		 
		 this.labeltva.setForeground(new Color(0, 51, 153));
		 labeltva.setFont(new Font("Tahoma", 1, 11));
		 labeltva.setFont(font.deriveFont(attributes));
		 labeltva.setBounds(23, 45, 49, 23);
		 this.labelttc = new JLabel("Montant TTC :");
		 this.labelttc.setForeground(new Color(0, 51, 153));
		 labelttc.setFont(new Font("Tahoma", 1, 11));
		 labelttc.setFont(font.deriveFont(attributes));
		 labelttc.setBounds(290, 9, 83, 23);
		 this.principal	=	new JPanel();
		 this.principal.setBorder(BorderFactory.createLineBorder(Color.gray));
		 principal.setBackground(new Color(220, 220, 220));
		 this.haut 	    =	new JPanel(new GridLayout(2, 2, 3, 3));
		 haut.setBackground(new Color(220, 220, 220));
		 haut.setBounds(0, 0, 894, 45);
		 this.gauche	= 	new JPanel();
		 this.haut.setBorder(BorderFactory.createLineBorder(Color.gray));
		 gauche.setBackground(new Color(220, 220, 220));
		 gauche.setBounds(0, 50, 260, 540);
		 this.bas		= 	new JPanel();
		 this.bas.setBorder(BorderFactory.createLineBorder(Color.gray));
		 bas.setBackground(new Color(220, 220, 220));
		 bas.setBounds(267, 595, 627, 77);
			
		this.l1 = new JLabel("Outil Développé par sinfelec, Tous droits réservés");
		this.menuBar = new JMenuBar();
		this.menu1 = new JMenu("Fichier");
		menu1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		this.menu4 = new JMenu("A propos");
		menu4.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		this.menu3 = new JMenu("Exécuter");
		menu3.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		this.menu2 = new JMenu("Editer");
		menu2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		this.tout_selectionner = new JMenuItem("Tout sélectionner");
		tout_selectionner.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		this.retirer = new JMenuItem("Retirer");
		retirer.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		this.convertir = new JMenuItem("Convertir");
		convertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText("");
				TVA.setText("");
				TTC.setText("");
				HT.setText("");
				convertir ();
			}
		});
		convertir.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		this.importer = new JMenuItem("Importer xlsx");
		importer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ajouter2();
			}
		});
		importer.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		this.quitter = new JMenuItem("Quitter");	
		this.aide = new JMenuItem("Aide");
		aide.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		this.guide = new JMenuItem("Guide");
		guide.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		this.sinfelec = new JMenuItem("A propos de SINFELEC");
		sinfelec.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		this.menu1.add(importer);
		this.menu1.add(quitter);
		this.menuBar.add(menu1);
		this.menu4.add(aide);
		this.menu4.add(guide);
		this.menu4.add(sinfelec);
		this.menu2.add(tout_selectionner);
		this.menu2.add(retirer);
		this.menu3.add(convertir);
		this.menuBar.add(menu2);
		this.menuBar.add(menu3);
		this.menuBar.add(menu4);
		quitter.addActionListener((ActionListener) new exitApp());
		gauche.setLayout(null);
		gauche.setBorder(BorderFactory.createLineBorder(Color.gray));
		listmodel= new DefaultListModel() ;
		list = new JList(listmodel);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				indices = ((ImgText)list.getSelectedValue()).getName();
				System.out.println(indices);
			}
		});
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(BorderFactory.createLineBorder(Color.gray));
		list.setBounds(0, 0, 241, 335);
		gauche.add(list);
		
		
		jScrollPane1 = new JScrollPane(list);
		jScrollPane1.setBounds(6, 59, 241, 470);
		jScrollPane1.setBorder(null);
		this.gauche.add(jScrollPane1);
	    this.jLabel1 = new JLabel();
	    myLabel = new JLabel();
	    this.jLabel2 = new JLabel();
	    this.jLabel3 = new JLabel();
	    this.jTextField2 = new JTextField();
	    this.jLabel4 = new JLabel();
	    this.jButton3 = new JButton();
	    this.jScrollPane2 = new JScrollPane();
	    this.jTextPane1 = new JTextPane();
	    this.jLabel5 = new JLabel();
	    this.jButton5 = new JButton();
	    
	    setDefaultCloseOperation(3);
	    setTitle("Easy TVA");
	    setCursor(new Cursor(0));
	    
	    
	    
	    this.jLabel1.setFont(new Font("Tahoma", 1, 11));
	    this.jLabel1.setForeground(new Color(0, 51, 153));
	    this.jLabel1.setText("Fichier Excel :");
	    this.jLabel2.setFont(new Font("Tahoma", 1, 11));
	    this.jLabel2.setForeground(new Color(0, 51, 153));
	    this.jLabel3.setFont(new Font("Tahoma", 1, 11));
	    this.jLabel3.setForeground(new Color(0, 51, 153));
	    this.jLabel3.setText("Répertoire de sortie :");
	    
	    this.jTextField2.setFont(new Font("Tahoma", 1, 11));
	    this.jTextField2.setForeground(new Color(102, 153, 255));
	    
	    this.jLabel4.setFont(new Font("Tahoma", 1, 11));
	    this.jLabel4.setForeground(new Color(0, 51, 153));
	    this.jLabel4.setText("Conversions en succès:  0");
	    
	    this.jButton3.setFont(new Font("Arial", 1, 24));
	    
	    this.jTextPane1.setEditable(false);
	    this.jTextPane1.setContentType("text/html");
	    this.jTextPane1.setFont(new Font("Arial", 1, 11));
	    this.jScrollPane2.setViewportView(this.jTextPane1);
	    
	    this.jLabel5.setFont(new Font("Tahoma", 1, 11));
	    this.jLabel5.setForeground(new Color(0, 51, 153));
	    this.jLabel5.setText("Messages :");
	    
	    this.haut.add(this.menuBar);
	    bas.setLayout(null);
	    this.bas.add(labeltva);
	    this.bas.add(labelht);
	    this.bas.add(labelttc);
	    this.bas.add(TVA);
	    this.bas.add(TTC);
	    this.bas.add(HT);
	    this.bas.add(convertRar);
		principal.setLayout(null);
		this.principal.add(this.haut);
		this.principal.add(this.gauche);
		
		
		
		
		JButton ajouter = new JButton("");
		ajouter.setBounds(6, 0, 65, 48);
		ajouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ajouter2();
				
				
			}
		});

		ajouter.setIcon(new ImageIcon("img/add.png"));
		ajouter.setToolTipText("Ajouter xlsx");
		ajouter.setBounds(34, 10, 35, 35);
		gauche.add(ajouter);
		ajouter.setFocusPainted( false );
		
		JButton supprimer = new JButton("");
		supprimer.setBounds(91, 0, 65, 48);
		supprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				supprimer();
			}
		});
		supprimer.setIcon(new ImageIcon("img/remove.png"));
		supprimer.setToolTipText("Retirer");
		supprimer.setBounds(106, 10, 35, 35);
		gauche.add(supprimer);
		supprimer.setFocusPainted( false );
		
		this.converter = new JButton("");
		this.converter.setFont(new Font("Arial", 1, 24));
		this.converter.setIcon(new ImageIcon("img/run.png"));
		
		this.converter.setBounds(176, 10, 35, 35);
		converter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textPane.setText("");
				TVA.setText("");
				TTC.setText("");
				HT.setText("");
				convertir ();
				//dilogue();
			}
		});
		converter.setForeground(new Color(0, 0, 0));
		converter.setFont(new Font("Tahoma", Font.PLAIN, 16));
		converter.setToolTipText("Convertir en xml");
		gauche.add(converter);
		
		converter.setFocusPainted( false );
		this.principal.add(this.bas);
		this.setContentPane(principal);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(220, 220, 220));
		panel.setBounds(0, 595, 260, 77);
		principal.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblIdentifientFiscal = new JLabel("Identifiant fiscal  :");
		lblIdentifientFiscal.setFont(new Font("Tahoma", 1, 11));
		lblIdentifientFiscal.setForeground(new Color(0, 51, 153));
		lblIdentifientFiscal.setFont(font.deriveFont(attributes));
		lblIdentifientFiscal.setBounds(10, 11, 110, 17);
		panel.add(lblIdentifientFiscal);
		
		JLabel lblNewLabel = new JLabel("Période / année :");
		lblNewLabel.setFont(new Font("Tahoma", 1, 11));
	    lblNewLabel.setForeground(new Color(0, 51, 153));
	    lblNewLabel.setFont(font.deriveFont(attributes));
		lblNewLabel.setBounds(10, 36, 110, 30);
		panel.add(lblNewLabel);
		
		txtidf = new JTextArea();
		txtidf.setBackground(new Color(220, 220, 220));
		txtidf.setEditable(false);
		txtidf.setBounds(130, 9, 120, 22);
		panel.add(txtidf);
		
		txtperiode = new JTextArea();
		txtperiode.setEditable(false);
		txtperiode.setBackground(new Color(220, 220, 220));
		txtperiode.setBounds(130, 41, 120, 22);
		panel.add(txtperiode);
		panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		 textPane = new JTextPane();
		 textPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		 textPane.setAlignmentY(Component.TOP_ALIGNMENT);
		 textPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		 textPane.setEditable(false);
		textPane.setBounds(259, 50, 635, 540);
		textPane.setBorder(BorderFactory.createLineBorder(Color.gray));
		//textPane.setMargin(getInsets());
		principal.add(textPane);
		
		JScrollPane scrollPane2 = new JScrollPane(textPane);
		scrollPane2.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane2.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane2.setBounds(259, 50, 635, 540);
		scrollPane2.scrollRectToVisible(new Rectangle(0, 0, 1, 1));
		principal.add(scrollPane2);
	    
	  }
	
	 private void Ajouter2()
	  {
	    if (this.XLSChooser == null)
	    {
	      this.XLSChooser = new JFileChooser();
	      this.XLSChooser.setAcceptAllFileFilterUsed(false);
	      this.XLSChooser.setMultiSelectionEnabled(true);
	      FileNameExtensionFilter xlsFilter = new FileNameExtensionFilter(".xlsx", new String[] { "xlsx" });
	      this.XLSChooser.setFileFilter(xlsFilter);
	  
	      //FileSystemView view = XLSChooser.getFileSystemView();
	    }
	    int returnVal = this.XLSChooser.showOpenDialog(this);
	    if (returnVal == 0)
	    {
	    	File [] leFichie = this.XLSChooser.getSelectedFiles(); 
			  for( int i = 0; i<leFichie.length; ++i) 
			  { 
			
			  if ((!leFichie[i].getAbsolutePath().isEmpty()) && (!this.dlm1.contains(leFichie[i].getAbsolutePath())))
			    {
				  //this.dlm1.addElement(leFichie[i].getAbsolutePath());
				 
				
				  //listmodel.addElement(leFichie[i].getAbsolutePath().substring(leFichie[i].getAbsolutePath().lastIndexOf('\\') +1,leFichie[i].getAbsolutePath().length()) );
				  
				 dlm1.addElement(new ImgText(leFichie[i].getAbsolutePath()));
				  //System.out.println(leFichie[i].getAbsolutePath());
				list.setCellRenderer(new randerer());
				list.setModel(dlm1);
				  
			    }

			  } 
	      
	    }
	    else
	    {
	      this.message += "<span>Commande annulée par l'utilisateur</span><br/><br/>";
	    }
	  }
	 
	 private void supprimer()
	  {
	    int[] indices = list.getSelectedIndices();
	    System.out.println(indices.length);
	    for (int k = 0; k <indices.length; k++) {
	    	System.out.println(k);
	    	System.out.println(indices[k]);
	      dlm1.remove(indices[k] );
	      
	    }
	  }
	 
	 private boolean translateXML(String dir) throws Exception{
		 // jdialogue pour bar progress......
    	 final JDialog dlg = new JDialog();
 	    JProgressBar dpb = new JProgressBar(0, 500);
 	    dlg.getContentPane().add(BorderLayout.CENTER, dpb);
 	    dlg.getContentPane().add(BorderLayout.NORTH, new JLabel("Progress..."));
 	    dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
 	    dlg.setSize(300, 75);
 	    
 	   Thread t = new Thread(new Runnable() {
 	      public void run() {
 	        dlg.setVisible(true);
 	      }
 	    });

	     // System.out.println("translat     cdcddfdfdffcd");
		    if (dir != null)
		    	
		    {
		    	System.out.println(dir);
		    	
		    	
		      /*if (this.jTextField2.getText().isEmpty())
		      {
		        this.msge += "<span class='failure'>Répertoire de sortie ne peut pas être vide.</span><br/><br/>";
		        return false;
		      }
		      */
		    File f = new File(dir);
		      
		      this.workbookName = f.getAbsolutePath();
		      XSSFWorkbook  wb;
		       path=f.getAbsolutePath();
		      System.out.println("translat     cdcddfdfdffcd");
		      
		      try
		      {   
		    	  InputStream targetStream = new FileInputStream(f);
		        wb = new XSSFWorkbook(targetStream);
		      }
		      catch (IOException ex)
		      {
		        this.msge += "<span class='failure'>Impossible d'ouvrir le fichier!</span><br/><br/>";
		        return false;
		      }
		      catch (Exception ex)
		      {
		        this.msge += "<span class='failure'>Impossible d'ouvrir classeur!</span><br/><br/>";
		        return false;
		      }
		      int sheets = wb.getNumberOfSheets();
		      Collection<String> XMLresults = new LinkedList();
		      for (int k = 0; k < sheets; k++)
		      {
		    	  XSSFSheet sheet=wb.getSheetAt(k);
		    	  int row=sheet.getLastRowNum();
		    	
		    	 String XMLresult = "<?xml version='1.0' encoding='UTF-8'?>\n<DeclarationReleveDeduction>\n";
		          
		    	 if( sheet.getRow(13).getCell(11).getCellType()== sheet.getRow(13).getCell(11).CELL_TYPE_BLANK){
		    		 this.msge = (this.msge + "<span class='failure'>merci de remplire l'identifiantFiscal</span><br/>");
		     		System.out.println("merci de remplire l'identifiantFiscal");
		     		//JOptionPane jop3 = new JOptionPane();
		     		JOptionPane.showMessageDialog(null, "merci de remplire l'identifiantFiscal", "Erreur", JOptionPane.ERROR_MESSAGE);
		     		
		     	}
		    	 else{
		    	  IdentifiantFiscal = (int)sheet.getRow(13).getCell(11).getNumericCellValue();
		    	 }
		    	
		    	 int Annee = (int)sheet.getRow(11).getCell(7).getNumericCellValue();
		    	 int Periode = (int)sheet.getRow(11).getCell(5).getNumericCellValue();
		    	 String IdRegime = sheet.getRow(13).getCell(1).toString();
		    	 XMLresult = XMLresult + "<identifiantFiscal>"+IdentifiantFiscal+"</identifiantFiscal>\n";
		    	 XMLresult = XMLresult + "<annee>"+Annee+"</annee>\n";
		    	 XMLresult = XMLresult + "<periode>"+Periode+"</periode>\n";
		    	 XMLresult = XMLresult + "<regime>"+IdRegime+"</regime>\n";
		    	 XMLresult = XMLresult + "<releveDeductions>\n";
		    	 txtidf.setText(Integer.toString(IdentifiantFiscal));
		    	 txtperiode.setText(Integer.toString(Periode));
		    	 double HT1=(double)sheet.getRow(row-3).getCell(7).getNumericCellValue();
		    	 HT.setText(Double.toString(HT1));
		    	 double TTC1=(double)sheet.getRow(row-3).getCell(10).getNumericCellValue();
		    	 DecimalFormat df = new DecimalFormat("########.00"); 
		    	 
		    	 TTC.setText(df.format(TTC1));
		    	 double TVA1=(double)sheet.getRow(row-3).getCell(9).getNumericCellValue();
		    	 TVA.setText(Double.toString(TVA1));
		    	
		    	 
		        for (int i = 15; i < row-3; i++) {
		        	/*Boolean  isLastRow = true;
		        	
		        	if(sheet.getRow(i)==null){
		        		System.out.println("ligne vide");
		        		isLastRow = false;
		        		JOptionPane.showMessageDialog(null, "merci de virifier la ligne"+ i+1, "Erreur", JOptionPane.ERROR_MESSAGE);
		                //System.out.println("ligne vide");
		        		
		        	}
		        	*/
		        	/*t.start();
		        	for (int j = 15; j < 300000000; j++){
		        	 dpb.setValue(j);
		   	      dpb.setVisible(true);
		   	      System.out.println("dfdfdfdfd");}*/
		        	
			        	String line = new String("<rd>\n");  
		        		String Content1 = sheet.getRow(i).getCell(0).toString();
		        		String Content2 = sheet.getRow(i).getCell(1).toString();
		        		SimpleDateFormat formater = null;
		        		formater = new SimpleDateFormat("yyyy-MM-dd");
		        		Date date = sheet.getRow(i).getCell(2).getDateCellValue();
		        		String Content3 = formater.format(date);
		        		String Content4 = sheet.getRow(i).getCell(3).toString();
		        		String Content5 = sheet.getRow(i).getCell(4).toString();
		        		String Content6 = sheet.getRow(i).getCell(5).toString();
		        		String Content7 = sheet.getRow(i).getCell(6).toString();
		        		String Content8 = sheet.getRow(i).getCell(7).toString();
		        		String Content9 = sheet.getRow(i).getCell(8).toString();
		        		double Content10 = sheet.getRow(i).getCell(9).getNumericCellValue();
		        		double Content11 = sheet.getRow(i).getCell(10).getNumericCellValue();
		        		String Content12 = sheet.getRow(i).getCell(11).toString();
		        		Date date2 = sheet.getRow(i).getCell(12).getDateCellValue();
		        		String Content13 = formater.format(date2);
		        		line = line + "<ord>"+Content1+"</ord>\n<num>"+Content2+"</num>\n<des>"+Content7+"</des>\n<mht>"+Content8+"</mht>\n<tva>"+Content10+"</tva>\n<ttc>"+Content11+"</ttc>\n"
		        				+ "<rfF>\n"
		        				+ "<if>"+Content5+"</if>\n<nom>"+Content4+"</nom>\n<ice>"+Content6+"</ice>\n"
		        						+ "</rfF>\n"
		        						+ "<tx>"+Content9+"</tx>\n"
		        								+ "<mp>\n"
		        								+ "<id>"+Content12+"</id>\n"
		        										+ "</mp>\n"
		        										+ "<dpai>"+Content13+"</dpai>\n<dfac>"+Content3+"</dfac>\n";
		        		
		        		
		 
		        		XMLresult = XMLresult + line+"</rd>\n";
		        		String sdsdsd="dfdfdfdfd";
		        	
		        		
		        }
		        XMLresult = XMLresult + "</releveDeductions>\n";
		        XMLresult = XMLresult + "</DeclarationReleveDeduction>";
		        XMLresults.add(XMLresult);
		        this.msge += XMLresult;
		        
		      }
		      wb.close();
		      for (String content : XMLresults)
		      {
		        BufferedWriter xml ;
		        try
		        {
		        	url="C:\\" + path.substring(path.lastIndexOf('\\') +1,path.length()-5)  + ".xml";
		          xml = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(url), "UTF-8"));
		        }
		        catch (FileNotFoundException ex)
		        {
		          this.msge += "<span class='failure'>Vous ne pouvez pas créer ou modifier le fichier XML, les raisons possibles:</span><br/><ul><li>Le fichier est ouvert par un autre programme.</li><li>Vous n'êtes pas autorisé à écrire dans le dossier de sortie.</li><li>Le dossier de sortie n'existe pas.</li></ul><br/>";
		          
		          return false;
		        }
		        catch (UnsupportedEncodingException ex)
		        {
		          this.msge += "<span class='failure'>Encodage unsupporté</span><br/><br/>";
		          return false;
		        }
		        this.jLabel4.setText("Nombre de Conversions: " + (this.counter + 1));
		        try
		        {
		          xml.write(content);
		        }
		        catch (IOException ex)
		        {
		          this.msge += "<span class='failure'>Vous ne pouvez pas modifier le fichier XML, peut-être le fichier est ouvert par un autre programme.</span><br/><br/>";
		          return false;
		        }
		        this.counter += 1;
		        try
		        {
		          xml.close();
		        }
		        catch (IOException ex)
		        {
		          Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
		        }
		      }
		    }
		      else
		    {
		      this.msge += "<span class='failure'>Emplacement fichier excel erroné.</span><br/><br/>";
		      return false;
		    }
		    dlg.setVisible(false);
	        dlg.dispose();
		    return true;
		  }
	 
	 
	 private void convertir ()
	  {
		// textPane.
		 
	   //int[] indices = this.list.getSelectedIndices();
	   // for (int k = 0; k < indices.length; k++)
	    {
	      this.msge = "";
	      try
	      {
	        //if (translateXML(((ImgText)list.getSelectedValue()).getName()))
	        if (indices!=null)
	        {
	        	translateXML(indices);
	          //this.list.setBackground(new Color(153, 204, 255));
	          String outputdir = "success";
	        /*  if (!outputdir.endsWith("\\")) {
	            outputdir = outputdir + "\\";
	          }*/
	          this.msge = (this.msge + outputdir);
	        }
	        else
	        {
	          if (this.msge.isEmpty()) {
	            this.msge = (this.msge + "<span class='failure'>Echec de conversion format erroné:</span><br/>");
	          }
	          this.list.setBackground(Color.red);
	        }
	      }
	      catch (Exception ex)
	      {
	        if ((this.msge.isEmpty()) && 
	          (this.msge.isEmpty())) {
	          this.msge = (this.msge + "<span class='failure'>Echec de conversion format erroné:</span><br/>");
	        }
	        //this.list.setBackground(Color.red);
	      }
	      this.message += this.msge;
	    }
	    
	    textPane.setText(message);
	    message=null;
	  }
	 
	 private void rar( String urlfich) {
		 if (this.FolderChooser == null)
		    {
		      this.FolderChooser = new JFileChooser();
		      this.FolderChooser.setFileSelectionMode(1);
		    }
		    int returnVal = this.FolderChooser.showOpenDialog(this);
		    if (returnVal == 0)
		    {
		      File folder = this.FolderChooser.getSelectedFile();
		      zipName= folder.getAbsolutePath()+"\\"+path.substring(path.lastIndexOf('\\') +1,path.length()-5)  +".zip";
		      System.out.println(zipName);
		    }
			try {
				ZipOutputStream zip =new ZipOutputStream(new FileOutputStream(zipName));
				zip.setMethod(ZipOutputStream.DEFLATED);
				zip.setLevel(Deflater.BEST_COMPRESSION);
				File dataDirectories = new File(urlfich);
				FileInputStream fis = new FileInputStream(dataDirectories);
				byte[] bytes = new byte[fis.available()];
				fis.read(bytes);
				String url1=url.substring(url.lastIndexOf('\\')+1);
		 		System.out.println(url1);
	 
				ZipEntry entry = new ZipEntry(url1);
				entry.setTime(dataDirectories.lastModified());
				zip.putNextEntry(entry);
				zip.write(bytes);
				zip.closeEntry();
				fis.close();
				//zipDirectory(dataDirectories, zip);
				zip.close();
			} catch (FileNotFoundException fileNotFound) {
			} catch (IOException io) {
			}
		}
	 
	 
	 static class exitApp implements ActionListener
	  {
	      public void actionPerformed(ActionEvent e)
	      {
	          System.exit(0);
	      }
	  }
	public static void main(String[] args) {
		
	new test().setVisible(true);
	}
	
	private void lire(){
		
		dialogue dg=new dialogue();
			String chaine="";
			String fichier ="c:/conf1.txt";
			File monFichier = new File(fichier); 
			
			if(monFichier.exists()) {	
			try{
				InputStream ips=new FileInputStream(fichier); 
				InputStreamReader ipsr=new InputStreamReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
				String ligne;
				while ((ligne=br.readLine())!=null){
					//System.out.println(ligne);
					chaine+=ligne+"\n"+"\n";
				}
				br.close(); 
			}		
			catch (Exception e){
				System.out.println(e.toString());
			}
			}
			else{
				System.out.println("fichier n'exsiste pas !!!!!");
				try {
					dialogue dialog = new dialogue();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					chaine=dialog.chaine;
					dialog.setAlwaysOnTop(true);
					System.out.println(chaine);
				} catch (Exception e) {
					e.printStackTrace();
				}
				}
			//SimpleAttributeSet center = new SimpleAttributeSet();
			//StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			Style defaut = textPane.getStyle("default");
			Style style1 = textPane.addStyle("style1", defaut);
			      StyleConstants.setFontFamily(style1, "Tahoma");
			      StyleConstants.setFontSize(style1, 14);
			      StyleConstants.setSpaceAbove(style1, 20);
			      StyleConstants.setAlignment(style1, StyleConstants.ALIGN_CENTER);
			Style style2 = textPane.addStyle("style2", style1);
			      StyleConstants.setFontFamily(style1, "Tahoma");
			      StyleConstants.setForeground(style2, Color.BLUE);
			      StyleConstants.setFontSize(style2, 18);
			String s1 = "\n  Coordonnées Société____________________________________________ ";
			String s2 = chaine;
			String s3 = "  Aide Support__________________________________________________\n";
			String s4 = "  \n pour toute qustion ou aide supplémentaire ,consultez :"+"\n"
			             +"  - Manuel d'utilisation "+"\n"+"  \n-support Sinfelec par téléphone au : 05 22 66 67 04"+"\n"
					+"  ou pa email à l'adresse suivante : support@sinfelec.ma"+"\n"
			             +"  \n Sinfelec Taxe sur la Valeur Ajoutée © Tous droit réservés - 2015- condition d'utilisation"+"\n"
			             +"  http://www.sinfelec.ma/"+"\n"
			             +"  adressss";
			StyledDocument sDoc = (StyledDocument)textPane.getDocument();
			try {
			      int pos = 0;
			      
			      sDoc.insertString(pos, s1, style2);pos+=s1.length();
			      sDoc.insertString(pos, s2, style1);pos+=s2.length();
			      sDoc.insertString(pos, s3, style2);pos+=s3.length();
			      sDoc.insertString(pos, s4, style1);
			     // sDoc.setParagraphAttributes(0, sDoc.getLength(), center, false);
			} catch (BadLocationException e) { }
			
	}
	
	
	private void modifier(){
		String chaine="";
		String fichier ="c:/conf1.txt";
		File monFichier = new File(fichier); 
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(monFichier));
			PrintWriter fichierSortie = new PrintWriter (writer); 
			 JDialog dlg = new JDialog();
			 dlg.setVisible(true);
			 dlg.setSize(100, 500);
		    dlg.getContentPane().add(BorderLayout.NORTH, new JLabel("Progress..."));
			
			
			fichierSortie.println (chaine); 
		fichierSortie.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void dilogue(){
		/*JFrame parentFrame = new JFrame();
	   // parentFrame.setSize(500, 1500);
	    //JLabel jl = new JLabel();
	    //jl.setText("Count : 0");

	    parentFrame.add(BorderLayout.CENTER, jl);
	    parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    parentFrame.setVisible(true);*/

	    final JDialog dlg = new JDialog();
	    JProgressBar dpb = new JProgressBar(0, 500);
	    dlg.getContentPane().add(BorderLayout.CENTER, dpb);
	    dlg.getContentPane().add(BorderLayout.NORTH, new JLabel("Progress..."));
	    dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
	    dlg.setSize(300, 75);
	    //dlg.setLocationRelativeTo(parentFrame);

	    Thread t = new Thread(new Runnable() {
	      public void run() {
	        dlg.setVisible(true);
	      }
	    });
	    t.start();
	    for (int i = 0; i <= 500; i++) {
	      //jl.setText("Count : " + i);
	      
	      dpb.setValue(i);
	      dpb.setVisible(true);
	      System.out.println("dfdfdfdfd");
	      if(dpb.getValue() == 500){
	        dlg.setVisible(false);
	        dispose();
	        
	      }
	      try {
	    	  
	        Thread.sleep(25);
	        System.out.print("dfff");
	      } catch (InterruptedException e) {
	        e.printStackTrace();
	      }
	    }
	    dlg.setVisible(true);
	  }


}
