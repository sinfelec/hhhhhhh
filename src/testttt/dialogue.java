package testttt;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import testttt.test.exitApp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class dialogue extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
    public String chaine =new String();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	/*	try {
			dialogue dialog = new dialogue();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	/**
	 * Create the dialog.
	 */
	public dialogue() {
		

		setResizable(false);
		setTitle("Information d'entreprise");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			textField = new JTextField();
			textField.setBounds(153, 11, 249, 20);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			textField_1 = new JTextField();
			textField_1.setBounds(153, 198, 249, 20);
			contentPanel.add(textField_1);
			textField_1.setColumns(10);
		}
		{
			textField_2 = new JTextField();
			textField_2.setBounds(153, 54, 249, 20);
			contentPanel.add(textField_2);
			textField_2.setColumns(10);
		}
		{
			textField_3 = new JTextField();
			textField_3.setBounds(153, 105, 249, 20);
			contentPanel.add(textField_3);
			textField_3.setColumns(10);
		}
		{
			textField_4 = new JTextField();
			textField_4.setBounds(153, 152, 249, 20);
			contentPanel.add(textField_4);
			textField_4.setColumns(10);
		}
		
		JLabel lblRaisonSocial = new JLabel("Raison social :");
		lblRaisonSocial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRaisonSocial.setBounds(35, 10, 121, 20);
		contentPanel.add(lblRaisonSocial);
		
		JLabel lblAdresse = new JLabel("Adresse :");
		lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdresse.setBounds(35, 54, 91, 20);
		contentPanel.add(lblAdresse);
		
		JLabel lblEm = new JLabel("Email :");
		lblEm.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEm.setBounds(35, 104, 46, 20);
		contentPanel.add(lblEm);
		
		JLabel lblTele = new JLabel("t\u00E9l\u00E9phone :");
		lblTele.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTele.setBounds(35, 152, 91, 20);
		contentPanel.add(lblTele);
		
		JLabel lblFax = new JLabel("Fax :");
		lblFax.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFax.setBounds(35, 201, 46, 20);
		contentPanel.add(lblFax);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						modifier();
						dispose();
						
					}
				});
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						dispose();
						
					}
				});
			}
		}
	}
	
	
	public void modifier(){
		
		 this.chaine="Coordonnées Société_______________________________________________________  "+"\n";
		String fichier ="c:/conf1.txt";
		String nom=textField.getText();
		chaine=chaine+ " Raison social : " + nom+"\n";
		String adress=textField_4.getText();
		chaine=chaine+" Adresse : "+ adress+"\n";
		String mail=textField_1.getText();
		chaine=chaine+" E-mail : "+mail+"\n";
		String telephone=textField_2.getText();
		chaine=chaine+ " Téléphone : " + telephone+"\n";
		String fax=textField_3.getText()+"\n";
		chaine=chaine+ " Fax : " + fax;
		chaine+=" Aide Support";
		File monFichier = new File(fichier); 
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(monFichier));
			PrintWriter fichierSortie = new PrintWriter (writer); 
			
			fichierSortie.println(chaine);  
		fichierSortie.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String getChaine() {
		return chaine;
	}

	public void setChaine(String chaine) {
		this.chaine = chaine;

		System.out.println(chaine);
	}

}
