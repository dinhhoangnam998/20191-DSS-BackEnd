package com.group.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.springframework.stereotype.Component;

import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import com.group.model.enums.DoCay;
import com.group.model.enums.DoNgot;
import com.group.model.enums.DoDinhDuong;
import com.group.model.enums.GiaTien;

@Component
public class MainFrame {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1025, 993);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 988, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(66, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
				groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE).addContainerGap()));

		JPanel datMonPanel = new JPanel();
		tabbedPane.addTab("\u0110\u1EB7t m\u00F3n", null, datMonPanel, null);

		JPanel boLocPanel = new JPanel();
		boLocPanel.setBounds(12, 13, 338, 294);

		JPanel boTieuChiPanel = new JPanel();
		boTieuChiPanel.setBounds(384, 13, 586, 294);
		boTieuChiPanel.setLayout(null);

		JLabel lblCay = new JLabel("\u0110\u1ED9 cay");
		lblCay.setBounds(12, 16, 94, 16);
		boTieuChiPanel.add(lblCay);

		JLabel lblNgt = new JLabel("\u0110\u1ED9 ng\u1ECDt");
		lblNgt.setBounds(12, 67, 94, 16);
		boTieuChiPanel.add(lblNgt);

		JLabel lblDinhDng = new JLabel("\u0110\u1ED9 dinh d\u01B0\u1EE1ng");
		lblDinhDng.setBounds(12, 118, 94, 16);
		boTieuChiPanel.add(lblDinhDng);

		JLabel lblPhBin = new JLabel("\u0110\u1ED9 ph\u1ED5 bi\u1EBFn");
		lblPhBin.setBounds(12, 169, 94, 16);
		boTieuChiPanel.add(lblPhBin);

		JLabel lblGiTin = new JLabel("Gi\u00E1 ti\u1EC1n");
		lblGiTin.setBounds(12, 220, 94, 16);
		boTieuChiPanel.add(lblGiTin);

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(DoCay.values()));
		comboBox_5.setBounds(118, 13, 86, 22);
		boTieuChiPanel.add(comboBox_5);

		JSlider slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setValue(0);
		slider.setMajorTickSpacing(1);
		slider.setMaximum(4);
		slider.setBounds(355, 16, 200, 38);
		boTieuChiPanel.add(slider);
		datMonPanel.setLayout(null);

		JLabel lblLoiMn = new JLabel("Lo\u1EA1i m\u00F3n");
		lblLoiMn.setBounds(31, 13, 52, 16);

		JLabel lblNgunGc = new JLabel("Ngu\u1ED3n g\u1ED1c");
		lblNgunGc.setBounds(31, 64, 60, 16);

		JLabel lblDng = new JLabel("D\u1ECB \u1EE9ng");
		lblDng.setBounds(31, 115, 37, 16);

		JLabel lblGiT = new JLabel("Gi\u00E1 t\u1EEB");
		lblGiT.setBounds(31, 166, 34, 16);

		JLabel lblChon = new JLabel("Cho \u0111\u1EBFn");
		lblChon.setBounds(31, 217, 47, 16);

		String[] loaiMonItems = {"Cơm", "Cháo", "Phở", "Lalal", "bababa"};
		JComboBox loaiMon = new JComboBox(loaiMonItems);
		
		loaiMon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		loaiMon.setBounds(145, 13, 139, 22);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(145, 65, 139, 22);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(145, 117, 139, 22);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(145, 169, 139, 22);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(145, 219, 139, 22);
		boLocPanel.setLayout(null);
		boLocPanel.add(lblLoiMn);
		boLocPanel.add(lblNgunGc);
		boLocPanel.add(lblDng);
		boLocPanel.add(lblGiT);
		boLocPanel.add(lblChon);
		boLocPanel.add(comboBox_4);
		boLocPanel.add(comboBox_3);
		boLocPanel.add(comboBox_2);
		boLocPanel.add(comboBox_1);
		boLocPanel.add(loaiMon);
		datMonPanel.add(boLocPanel);
		datMonPanel.add(boTieuChiPanel);

		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(DoNgot.values()));
		comboBox_6.setBounds(118, 64, 86, 22);
		boTieuChiPanel.add(comboBox_6);

		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(DoDinhDuong.values()));
		comboBox_7.setBounds(118, 115, 86, 22);
		boTieuChiPanel.add(comboBox_7);

		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(118, 166, 86, 22);
		boTieuChiPanel.add(comboBox_8);

		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel(GiaTien.values()));
		comboBox_9.setBounds(118, 217, 86, 22);
		boTieuChiPanel.add(comboBox_9);

		JSlider slider_1 = new JSlider();
		slider_1.setValue(0);
		slider_1.setPaintLabels(true);
		slider_1.setMajorTickSpacing(1);
		slider_1.setMaximum(4);
		slider_1.setBounds(355, 67, 200, 26);
		boTieuChiPanel.add(slider_1);

		JSlider slider_2 = new JSlider();
		slider_2.setValue(0);
		slider_2.setPaintLabels(true);
		slider_2.setMaximum(4);
		slider_2.setMajorTickSpacing(1);
		slider_2.setBounds(355, 118, 200, 26);
		boTieuChiPanel.add(slider_2);

		JSlider slider_3 = new JSlider();
		slider_3.setValue(0);
		slider_3.setMajorTickSpacing(1);
		slider_3.setPaintLabels(true);
		slider_3.setMaximum(4);
		slider_3.setBounds(355, 169, 200, 26);
		boTieuChiPanel.add(slider_3);

		JSlider slider_4 = new JSlider();
		slider_4.setValue(0);
		slider_4.setPaintLabels(true);
		slider_4.setMajorTickSpacing(1);
		slider_4.setMaximum(4);
		slider_4.setBounds(355, 210, 200, 26);
		boTieuChiPanel.add(slider_4);

		JLabel lblMcuTin = new JLabel("M\u1EE9c \u01B0u ti\u00EAn");
		lblMcuTin.setBounds(267, 16, 94, 16);
		boTieuChiPanel.add(lblMcuTin);

		JLabel label = new JLabel("M\u1EE9c \u01B0u ti\u00EAn");
		label.setBounds(267, 67, 94, 16);
		boTieuChiPanel.add(label);

		JLabel label_1 = new JLabel("M\u1EE9c \u01B0u ti\u00EAn");
		label_1.setBounds(267, 118, 94, 16);
		boTieuChiPanel.add(label_1);

		JLabel label_2 = new JLabel("M\u1EE9c \u01B0u ti\u00EAn");
		label_2.setBounds(267, 169, 94, 16);
		boTieuChiPanel.add(label_2);

		JLabel label_3 = new JLabel("M\u1EE9c \u01B0u ti\u00EAn");
		label_3.setBounds(267, 220, 94, 16);
		boTieuChiPanel.add(label_3);

		JPanel ketquaPanel = new JPanel();
		ketquaPanel.setBounds(12, 320, 958, 315);
		datMonPanel.add(ketquaPanel);
		ketquaPanel.setLayout(null);

		JButton btnTmKimMn = new JButton("T\u00ECm ki\u1EBFm m\u00F3n \u0103n ph\u00F9 h\u1EE3p");
		btnTmKimMn.setBounds(371, 13, 215, 25);
		ketquaPanel.add(btnTmKimMn);

		JLabel lblDanhSchMn = new JLabel("Danh s\u00E1ch k\u1EBFt qu\u1EA3");
		lblDanhSchMn.setBounds(39, 35, 145, 16);
		ketquaPanel.add(lblDanhSchMn);

		JPanel danhSachDatMonPanel = new JPanel();
		danhSachDatMonPanel.setLayout(null);
		danhSachDatMonPanel.setBounds(12, 658, 958, 202);
		datMonPanel.add(danhSachDatMonPanel);

		JButton btntMn = new JButton("\u0110\u1EB7t m\u00F3n");
		btntMn.setBounds(371, 13, 215, 25);
		danhSachDatMonPanel.add(btntMn);

		JLabel lblCcMn = new JLabel("C\u00E1c m\u00F3n \u0111\u00E3 ch\u1ECDn");
		lblCcMn.setBounds(39, 35, 145, 16);
		danhSachDatMonPanel.add(lblCcMn);
		frame.getContentPane().setLayout(groupLayout);
	}
}
