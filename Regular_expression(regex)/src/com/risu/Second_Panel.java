package com.risu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.print.Doc;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;

import java.io.File;

import javax.swing.JOptionPane;

import com.aspose.words.Document;
import com.aspose.words.SaveFormat;

public class Second_Panel extends JFrame {

	private JPanel contentPane;
	JPanel panel_5;
	JCheckBox chckbxfileconvert;
	JCheckBox rdbtnNewRadioButton_2;
	JCheckBox rdbtnNewRadioButton_3;
	JCheckBox rdbtnNewRadioButton_4;
	JCheckBox chckbxNewCheckBox;
	Thread th;
	File f;
	LoadingThreadclass obTh;
	Second_Panel mf;
	public static String messageboxtitle ="Rishu project";
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Second_Panel frame = new Second_Panel();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Second_Panel(Set<File> hashset, String filetype, String filepath) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);

		setTitle("Rishu First Project");
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(new ImageIcon("28x28.png").getImage());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(-12, 0, 720, 65);
		panel.setLayout(null);
		panel.setRequestFocusEnabled(false);
		panel.setFocusable(false);
		panel.setFocusTraversalKeysEnabled(false);
		panel.setDoubleBuffered(false);
		panel.setBorder(new LineBorder(new Color(255, 215, 0)));
		panel.setBackground(new Color(25, 25, 112));
		contentPane.add(panel);
		

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setRequestFocusEnabled(false);
		panel_2.setFocusable(false);
		panel_2.setFocusTraversalKeysEnabled(false);
		panel_2.setDoubleBuffered(false);
		panel_2.setBorder(new LineBorder(new Color(255, 215, 0)));
		panel_2.setBackground(new Color(25, 25, 112));
		panel_2.setBounds(0, 446, 684, 65);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();

		JButton btn_converter = new JButton("");
		btn_converter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				th = new Thread(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						// File f1 = new File(f+File.separator+hashset[0]);
//						for(int i =0 ;i<Mobile_number.hashset.size();i++) {
//							
//							File cfile = Mobile_number.hashset.
//						}
						//File cfile = Mobile_number.hashset.;
						
						
						Iterator<File>itr = Mobile_number.hashset.iterator();
						while(itr.hasNext()) {
							File cfile =itr.next();
							String name = cfile.getName();
							System.out.println("thisu is nem "+cfile);
							String strp =cfile.getAbsolutePath();
							//System.out.println("this is selected fiel"+cfile);
							String nam= getRidOfIllegalFileNameCharacters(name);
							System.out.println("this is naming conventiio "+nam);
							if(rdbtnNewRadioButton_2.isSelected()) {
								if(nam.endsWith("docx")) {
									obTh = new LoadingThreadclass(mf);
									obTh.start();
									f = new File((System.getProperty("user.home") + File.separator + "Desktop") + File.separator
											+ "Rishu_First_Project");
									f.mkdir();

									Doc_to_pdf(f,strp,name);
								}
								
							}
							 if(nam.endsWith("txt")) {
								//Txt_to_pdf();
								
							}
							
						}
						
						
					}
				});
				th.start();
				
			}
		});
		
		btn_converter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_converter.setIcon(new ImageIcon(Mobile_number.class.getResource("convert-hvr-btn.png")));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn_converter.setIcon(new ImageIcon(Mobile_number.class.getResource("convert-btn.png")));
			}
		});
		btn_converter.setIcon(new ImageIcon(Mobile_number.class.getResource("convert-btn.png")));
		btn_converter.setBounds(508, 11, 115, 35);
		panel_2.add(btn_converter);

		JButton btnBack = new JButton("");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Mobile_number mn = new Mobile_number();
				mn.setVisible(true);
				dispose();
			}
		});

		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnBack.setIcon(new ImageIcon(Mobile_number.class.getResource("previous-hvr-btn.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnBack.setIcon(new ImageIcon(Mobile_number.class.getResource("previous-btn.png")));
			}
		});

		btnBack.setIcon(new ImageIcon(Mobile_number.class.getResource("previous-btn.png")));

		btnBack.setBounds(10, 11, 115, 35);
		panel_2.add(btnBack);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(10, 76, 664, 359);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		
			
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255), new Color(64, 64, 64)),
						"<html><b>Filter File", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 0, 0)));
		panel_3.setBounds(10, 11, 322, 337);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		chckbxfileconvert = new JCheckBox("<html><b>Convert to Other File Formet");

		chckbxfileconvert.setForeground(Color.RED);
		chckbxfileconvert.setBackground(Color.WHITE);
		chckbxfileconvert.setBounds(17, 131, 188, 23);
		panel_3.add(chckbxfileconvert);

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				rdbtnNewRadioButton_2.setEnabled(false);
				rdbtnNewRadioButton_3.setEnabled(false);
				rdbtnNewRadioButton_4.setEnabled(false);
				chckbxNewCheckBox.setEnabled(false);
				rdbtnNewRadioButton_2.setSelected(false);
				rdbtnNewRadioButton_3.setSelected(false);
				rdbtnNewRadioButton_4.setSelected(false);
				chckbxNewCheckBox.setSelected(false);
			}
		});
		
//		if(!chckbxfileconvert.isSelected()) {
//			
//			rdbtnNewRadioButton_2.setSelected(false);
//			rdbtnNewRadioButton_3.setSelected(false);
//			rdbtnNewRadioButton_4.setSelected(false);
//			chckbxNewCheckBox.setSelected(false);
//		}

		panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 140, 302, 186);
		panel_5.setEnabled(false);
		panel_3.add(panel_5);
		panel_5.setLayout(null);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Click here to Find all Mobile Number Persent in File");
		rdbtnNewRadioButton.setForeground(new Color(0, 0, 0));
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(6, 21, 310, 20);
		panel_3.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Click here to Find all Gmail Account Persent in File");
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_1.setForeground(new Color(0, 0, 0));
		rdbtnNewRadioButton_1.setBounds(6, 63, 310, 32);
		panel_3.add(rdbtnNewRadioButton_1);

		JLabel lblNewLabel = new JLabel("( save them in a seperate file)");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(25, 40, 180, 14);
		panel_3.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("( save them in a seperate file)");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(24, 92, 180, 14);
		panel_3.add(lblNewLabel_1);

		rdbtnNewRadioButton_2 = new JCheckBox("Conver to Pdf Formet");
		rdbtnNewRadioButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_2.setBackground(Color.WHITE);
		rdbtnNewRadioButton_2.setBounds(6, 19, 246, 23);
		panel_5.add(rdbtnNewRadioButton_2);
		// rdbtnNewRadioButton_2.setEnabled(false);

		rdbtnNewRadioButton_3 = new JCheckBox("Convert to Html");
		rdbtnNewRadioButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_3.setBackground(Color.WHITE);
		rdbtnNewRadioButton_3.setBounds(6, 59, 246, 23);
		panel_5.add(rdbtnNewRadioButton_3);
		// rdbtnNewRadioButton_3.setEnabled(false);

		rdbtnNewRadioButton_4 = new JCheckBox("Convert to Mhtml");
		rdbtnNewRadioButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnNewRadioButton_4.setBackground(Color.WHITE);
		rdbtnNewRadioButton_4.setBounds(6, 102, 246, 23);
		panel_5.add(rdbtnNewRadioButton_4);
		// rdbtnNewRadioButton_4.setEnabled(false);

		chckbxNewCheckBox = new JCheckBox("Compress as zip File");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setBounds(6, 142, 202, 23);
		panel_5.add(chckbxNewCheckBox);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(342, 11, 312, 337);
		panel_1.add(panel_4);
		
		ButtonGroup b1 = new ButtonGroup();
		b1.add(rdbtnNewRadioButton_2);
		b1.add(rdbtnNewRadioButton_4);
		b1.add(rdbtnNewRadioButton_3);
		b1.add(chckbxNewCheckBox);
		
		

		chckbxfileconvert.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				if (chckbxfileconvert.isSelected()) {
					rdbtnNewRadioButton_2.setEnabled(true);
					rdbtnNewRadioButton_3.setEnabled(true);
					rdbtnNewRadioButton_4.setEnabled(true);
					chckbxNewCheckBox.setEnabled(true);
				} else  {
					rdbtnNewRadioButton_2.setEnabled(false);
					rdbtnNewRadioButton_3.setEnabled(false);
					rdbtnNewRadioButton_4.setEnabled(false);
					chckbxNewCheckBox.setEnabled(false);
					rdbtnNewRadioButton_2.setSelected(false);
					rdbtnNewRadioButton_3.setSelected(false);
					rdbtnNewRadioButton_4.setSelected(false);
					chckbxNewCheckBox.setSelected(false);
					b1.clearSelection();
				}

			}
		});
		
		

	}

	public void Doc_to_pdf(File f,String str4,String str) {

		//File f1 = new File("C:\\Users\\Aryson\\Desktop\\rishu");
		//String str = "doctest.docx";
		//String str4 = f1.getPath().trim() + File.separator + str;

		// Document doc = new Document("C:\\Users\\Aryson\\Desktop\\rishu" +
		// "doctest.txt");

		// Save the document in PDF format.

		// doc.Save(f.getAbsolutePath()"pdf" + "SaveDoc2Pdf.pdf");

		Document doc1 = null;
		try {
			doc1 = new Document(str4);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			doc1.save(f.getAbsolutePath().trim() + File.separator + str.replace("docx", "") + "pdf", SaveFormat.PDF);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "your work done congrats!");
		obTh.close();
		// doc1.save(f.getAbsolutePath() + "pdf", SaveFormat.PDF);

	}
	public static String getRidOfIllegalFileNameCharacters(String strName) {
		String strLegalName = strName.replace(":", " ").replace("\\", "").replace("?", "").replace("/", "")
				.replace("|", "").replace("*", "").replace("<", "").replace(">", "").replace("\t", "")
				.replace("//s", "").replace("\"", "");
		if (strLegalName.length() >= 80) {
			strLegalName = strLegalName.substring(0, 80);
		}
		return strLegalName;
	}
}
