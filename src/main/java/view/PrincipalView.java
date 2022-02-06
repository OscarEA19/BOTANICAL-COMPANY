package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import botany.layer.IMethods;
import controller.Methods_Data_Imple;
import models.Cactus;
import models.Ornamental;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;

public class PrincipalView extends JFrame {

	private final IMethods plant = new Methods_Data_Imple();
	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldCode;
	private JTextField textFieldName;
	private JTextArea textAreaDescrip;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalView frame = new PrincipalView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PrincipalView() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 650);
		setLocationRelativeTo(null);
		setTitle("Botanical Company");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("BOTANICAL COMPANY");
		lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 25));
		lblNewLabel.setBounds(116, 10, 299, 53);
		contentPane.add(lblNewLabel);

		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "CODE", "NAME", "DESCRIP", "BREEDING", "FLOWERCOLOR" }));
		table.setBounds(10, 184, 766, 365);
		table.setPreferredScrollableViewportSize(new Dimension(450, 63));
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setVisible(true);
		scroll.setBounds(10, 184, 766, 376);
		contentPane.add(scroll);

		JButton btnaddCACTUS = new JButton("ADD CACTUS");
		btnaddCACTUS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldCode.getText().equals(" ")) {
					JOptionPane.showMessageDialog(null, "ENTER INFORMATION");
				} else {
					Cactus cactus;
					String code = textFieldCode.getText();
					String name = textFieldName.getText();
					String descrip = textAreaDescrip.getText();
					cactus = new Cactus(code, name, descrip);
					plant.createPlants(cactus);
					plant.readPlantsCAC(table, cactus);
					textFieldCode.setText(" ");
					textFieldName.setText(" ");
					textAreaDescrip.setText(" ");
				}

			}
		});
		btnaddCACTUS.setBounds(76, 575, 120, 28);
		contentPane.add(btnaddCACTUS);

		JButton btnAddOrnamental = new JButton("ADD ORNAMENTAL");
		btnAddOrnamental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textFieldCode.getText().equals(" ")) {
					JOptionPane.showMessageDialog(null, "ENTER INFORMATION");
				} else {
					String color = JOptionPane.showInputDialog("ENTER FLOWER COLOR");
					Ornamental ornamental;
					String code = textFieldCode.getText();
					String name = textFieldName.getText();
					String descrip = textAreaDescrip.getText();
					ornamental = new Ornamental(code, name, descrip, color);
					plant.createPlants(ornamental);
					plant.readPlantsOrna(table, ornamental);
					textFieldCode.setText(" ");
					textFieldName.setText(" ");
					textAreaDescrip.setText(" ");
				}
			}
		});
		btnAddOrnamental.setBounds(565, 575, 150, 28);
		contentPane.add(btnAddOrnamental);

		JButton btnDeletePlants = new JButton("DELETE PLANT");
		btnDeletePlants.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plant.deletePlants(table);
			}
		});
		btnDeletePlants.setBounds(305, 575, 166, 28);
		contentPane.add(btnDeletePlants);

		JLabel textCode = new JLabel("CODE:");
		textCode.setFont(new Font("Verdana", Font.PLAIN, 15));
		textCode.setBounds(10, 79, 56, 35);
		contentPane.add(textCode);

		JLabel textName = new JLabel("NAME:");
		textName.setFont(new Font("Verdana", Font.PLAIN, 15));
		textName.setBounds(10, 139, 56, 35);
		contentPane.add(textName);

		JLabel textDescrip = new JLabel("DESCRIPTION:");
		textDescrip.setFont(new Font("Verdana", Font.PLAIN, 15));
		textDescrip.setBounds(409, 79, 131, 35);
		contentPane.add(textDescrip);

		textFieldCode = new JTextField(" ");
		textFieldCode.setBounds(76, 89, 96, 19);
		contentPane.add(textFieldCode);
		textFieldCode.setColumns(10);

		textFieldName = new JTextField(" ");
		textFieldName.setColumns(10);
		textFieldName.setBounds(76, 149, 96, 19);
		contentPane.add(textFieldName);

		textAreaDescrip = new JTextArea(" ");
		textAreaDescrip.setBounds(527, 87, 224, 87);
		contentPane.add(textAreaDescrip);

		JButton btncactus = new JButton("SHOW ONLY CACTUS");
		btncactus.setToolTipText("This order will help you better visualize the cactus");
		btncactus.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btncactus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plant.orderplants(table, 0);
			}
		});
		btncactus.setBounds(565, 10, 211, 28);
		contentPane.add(btncactus);

		JButton btnordamental = new JButton("SHOW ONLY ORDAMENTAL");
		btnordamental.setToolTipText("This order will help you better visualize the ornamental");
		btnordamental.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plant.orderplants(table, 1);
			}
		});
		btnordamental.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnordamental.setBounds(565, 48, 211, 28);
		contentPane.add(btnordamental);

		JButton btnAll = new JButton("SHOW ALL");
		btnAll.setToolTipText("Show all plants");
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plant.orderplants(table, 2);
			}
		});
		btnAll.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnAll.setBounds(459, 10, 96, 28);
		contentPane.add(btnAll);
	}
}
