package com.risu;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mobile_number extends JFrame {

	private JPanel contentPane;
	static JFileChooser jFileChooser;
	public static String fileoption;
	public static File files[];
	public static File file;
	String filetype = "Not selected";
	public String filepath = null;
	JComboBox comboBox;
	Mobile_number frame1;
	String messageboxtitle = "Rishu first project";
	private JTextField textField;
	JButton btnbrowse;
	JRadioButton rdbtnmultiplefile;
	JRadioButton rdbtnsinglefilechooser;
	public static Set<File> hashset = new LinkedHashSet<File>();
	private JTable table;
	DefaultTableModel modeli;
	int filesno = 1;
	static int countforfile = 0;
	double SPACE_KB = 1024;
	double SPACE_MB = 1024 * SPACE_KB;
	double SPACE_GB = 1024 * SPACE_MB;
	double SPACE_TB = 1024 * SPACE_GB;
	
	Mobile_number mn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

				} catch (ClassNotFoundException e1) {

				} catch (InstantiationException e1) {

				} catch (IllegalAccessException e1) {

				} catch (UnsupportedLookAndFeelException e1) {

				}

				try {
					Mobile_number frame = new Mobile_number();
					frame.setVisible(true);
					// frame.setIconImage(new ImageIcon("28x28.png").getImage());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Mobile_number() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 700, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setRequestFocusEnabled(false);
		panel.setFocusable(false);
		panel.setFocusTraversalKeysEnabled(false);
		panel.setDoubleBuffered(false);
		panel.setBorder(new LineBorder(new Color(255, 215, 0)));
		panel.setBackground(new Color(25, 25, 112));

		panel.setLayout(null);
//		panel.setBackground(Color.BLUE);
//		panel.setForeground(Color.BLUE);
		panel.setBounds(-12, 0, 720, 65);
		contentPane.add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(0, 65, 249, 381);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 229, 359);
		panel_1.add(scrollPane);

		table = new JTable(){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column) {

				return false;
			}
		};
		table.getTableHeader().setReorderingAllowed(false);
		table.setBackground(Color.WHITE);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Sr.no", "File Name", "Size" }));
		table.setRequestFocusEnabled(false);
		table.setFocusable(false);
		table.setFocusTraversalKeysEnabled(false);
		table.setDoubleBuffered(false);
		table.setBorder(new LineBorder(new Color(255, 215, 0)));

		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		
		
		scrollPane.setViewportView(table);

		JPanel panel_2 = new JPanel();
		panel_2.setRequestFocusEnabled(false);
		panel_2.setFocusable(false);
		panel_2.setFocusTraversalKeysEnabled(false);
		panel_2.setDoubleBuffered(false);
		panel_2.setBorder(new LineBorder(new Color(255, 215, 0)));
		panel_2.setBackground(new Color(25, 25, 112));
		panel_2.setBounds(0, 446, 684, 65);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
				btnNewButton.setToolTipText("Click here to go next page");
				
				btnNewButton.setIcon(new ImageIcon(Mobile_number.class.getResource("next-hvr-btn.png")));
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				btnNewButton.setIcon(new ImageIcon(Mobile_number.class.getResource("next-btn.png")));
			}
		});
		
		btnNewButton.setIcon(new ImageIcon(Mobile_number.class.getResource("next-btn.png")));

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getRowCount()==0) {
					JOptionPane.showMessageDialog(mn, "Please Browse File after thet go next!",
							"rishu project", JOptionPane.ERROR_MESSAGE,
							new ImageIcon(Mobile_number.class.getResource("information.png")));
				}
				if(table.getRowCount()!=0) {
					Second_Panel sp=new Second_Panel(hashset,filetype,filepath);
					System.out.println("this is file type "+filetype);
					System.out.println(filepath);
					for(File f: hashset) {
						System.out.println(f.getName().toString());
					}
				sp.setVisible(true);
				dispose();
				}
			}
		});
		btnNewButton.setBounds(488, 17, 115, 35);
		panel_2.add(btnNewButton);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setForeground(new Color(255, 0, 0));
		panel_3.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"<html><b>File chooser", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_3.setBounds(259, 76, 415, 359);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		String[] fi = { "<html><b>Docx File", "<html><b>Text File", "<html><b>Text and Docx" };
		comboBox = new JComboBox(fi);
		// comboBox.setRenderer(new ListRenderer());

		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				comboBox.setSelectedItem("<html><b>Docx File");
			}
		});

		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField.setBounds(107, 269, 291, 22);
		panel_3.add(textField);
		textField.setColumns(10);

		// comboBox.setSelectedItem("<html><b>Doc File");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == comboBox) {

					JComboBox cb = (JComboBox) e.getSource();

					filetype = (String) cb.getSelectedItem();
					System.out.println("this is combo box choosable file type " + filetype);
				}
			}
		});

		// System.out.println("this is combo box choosable file type " + filetype);
		comboBox.setBounds(129, 21, 263, 30);
		panel_3.add(comboBox);

		JLabel lblNewLabel = new JLabel("Choose File Type");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 21, 115, 29);
		panel_3.add(lblNewLabel);

		rdbtnsinglefilechooser = new JRadioButton("For singel File");
		rdbtnsinglefilechooser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hashset.clear();
				 filesno = 1;
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				for(int i =0;i<model.getRowCount();i++) {
					model.setRowCount(0);
				}
				
				textField.setText("");
			}
		});

//		rdbtnsinglefilechooser.addChangeListener(new ChangeListener() {
//			public void stateChanged(ChangeEvent e) {
//				if(rdbtnsinglefilechooser.isSelected()) {
//					btnbrowse.setVisible(true);
//					btnbrowse.setToolTipText("click here to choose single file");
//				}
//			}
//		});
		rdbtnsinglefilechooser.setSelected(true);
		rdbtnsinglefilechooser.setBackground(Color.WHITE);
		rdbtnsinglefilechooser.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 12));
		rdbtnsinglefilechooser.setBounds(23, 91, 353, 23);
		panel_3.add(rdbtnsinglefilechooser);

		rdbtnmultiplefile = new JRadioButton("For multiple File");
		rdbtnmultiplefile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hashset.clear();
				 filesno = 1;
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				for(int i =0;i<model.getRowCount();i++) {
					model.setRowCount(0);
				}
				textField.setText("");
			}
		});

		rdbtnmultiplefile.setBackground(Color.WHITE);
		rdbtnmultiplefile.setFont(new Font("Sitka Small", Font.BOLD | Font.ITALIC, 12));
		rdbtnmultiplefile.setBounds(24, 144, 347, 23);
		panel_3.add(rdbtnmultiplefile);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnmultiplefile);
		bg.add(rdbtnsinglefilechooser);

		btnbrowse = new JButton("");
		
		btnbrowse.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0) {
				if(rdbtnmultiplefile.isSelected()) {
					btnbrowse.setToolTipText("Click here to Choose Multiple File's");
					
				}
				if(rdbtnsinglefilechooser.isSelected()) {
					btnbrowse.setToolTipText("Click here to Choose Single File");
					
				}
				btnbrowse.setIcon(new ImageIcon(Mobile_number.class.getResource("browse-hvr-btn.png")));
			}

			public void mouseExited(MouseEvent e) {
				btnbrowse.setIcon(new ImageIcon(Mobile_number.class.getResource("browse-btn.png")));
			}
		});

		btnbrowse.setIcon(new ImageIcon(Mobile_number.class.getResource("browse-btn.png")));
		
		
		
		
		btnbrowse.setToolTipText("");
		
		
		
		
		btnbrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				filechoo();

			}
		});
		btnbrowse.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnbrowse.setBounds(129, 204, 115, 35);
		
		
		
		
		
		panel_3.add(btnbrowse);

		JLabel lblNewLabel_1 = new JLabel("Selected File :-");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(10, 266, 94, 29);
		panel_3.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("(Select This option for single file than Browse the file.)");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_2.setBounds(44, 107, 285, 22);
		panel_3.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("(Select This Option for multiple File's then click on Next Button Below)");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(44, 161, 359, 22);
		panel_3.add(lblNewLabel_3);

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_4.setBackground(Color.ORANGE);
		panel_4.setBounds(-2, 65, 686, 381);
		contentPane.add(panel_4);
		panel_4.setLayout(new CardLayout(0, 0));
		setTitle("Rishu First Project");
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(new ImageIcon("28x28.png").getImage());

	}

	public void filechoo() {
		jFileChooser = new JFileChooser(System.getProperty("user.home") + File.separator + "Desktop");
		jFileChooser.setBackground(Color.WHITE);

		jFileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = null;
		if(rdbtnmultiplefile.isSelected()) {
			jFileChooser.setMultiSelectionEnabled(true);
			
		}
		System.out.println("combo file selected "+filetype);
		if(filetype.equalsIgnoreCase("<html><b>Doc File")) {
			filter = new FileNameExtensionFilter(".docx","DOCx");
			
		}else if(filetype.equalsIgnoreCase("<html><b>Text File")) {
			filter = new FileNameExtensionFilter(".txt","txt");
			
		}else if(filetype.equalsIgnoreCase("<html><b>Text and Docx")) {
			filter = new FileNameExtensionFilter("select Docx & text ","docx","txt");
		}
		jFileChooser.addChoosableFileFilter(filter);
		if (jFileChooser.showOpenDialog(Mobile_number.this) == JFileChooser.APPROVE_OPTION) {
			if(rdbtnmultiplefile.isSelected()) {
				 files = jFileChooser.getSelectedFiles();
				 
				 for(int i =0;i<files.length;i++) {
				 
				 filepath=files[i].getAbsolutePath();
				 textField.setText(filepath);
				 hashset.add(files[i]);
				 file_Add_to_table();
				 }
				 
				
			}else {
				file = jFileChooser.getSelectedFile();
				filepath=file.getAbsolutePath();
				hashset.add(file);
				file_Add_to_table();
				
				
				
				
				
				 textField.setText(filepath);
			}
			
		}
	}
	public void file_Add_to_table() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();

		while (model.getRowCount() > 0) {

			for (int i = 0; i < model.getRowCount(); ++i) {

				model.removeRow(i);
				filesno--;
			}
		}

		Iterator<File> itr = hashset.iterator();
		while (itr.hasNext()) {

			modeli = (DefaultTableModel) table.getModel();
			File fo = itr.next();
			String filet = "";
			if (fo.isFile()) {
				filet = "File";
			} else {
				filet = "Folder";
			}
			long sizeInBytes = fo.length();
			modeli.addRow(new Object[] { "<html><b>" + filesno, "<html><b>" + fo.getName(), "<html><b>"+ bytes2String(sizeInBytes) });
			filesno++;
			countforfile++;
		}
	}
	
	
	private String bytes2String(long sizeInBytes) {
		NumberFormat nf = new DecimalFormat();
		nf.setMaximumFractionDigits(2);

		try {
			if (sizeInBytes < SPACE_KB) {
				return nf.format(sizeInBytes) + " Byte(s)";
			} else if (sizeInBytes < SPACE_MB) {
				return nf.format(sizeInBytes / SPACE_KB) + " KB";
			} else if (sizeInBytes < SPACE_GB) {
				return nf.format(sizeInBytes / SPACE_MB) + " MB";
			} else if (sizeInBytes < SPACE_TB) {
				return nf.format(sizeInBytes / SPACE_GB) + " GB";
			} else {
				return nf.format(sizeInBytes / SPACE_TB) + " TB";
			}
		} catch (Exception e) {
			return sizeInBytes + " Byte(s)";
		}
	}

}
