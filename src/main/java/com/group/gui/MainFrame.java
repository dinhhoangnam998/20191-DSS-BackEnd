package com.group.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.group.enums.DoCay;
import com.group.enums.DoDinhDuong;
import com.group.enums.DoNgot;
import com.group.enums.DoPhoBien;
import com.group.enums.GiaTien;
import com.group.model.DiUng;
import com.group.model.MonAn;
import com.group.model.QuocGia;
import com.group.model.TheLoai;
import com.group.service.DiUngS;
import com.group.service.MonAnNguyenLieuS;
import com.group.service.MonAnS;
import com.group.service.NguyenLieuS;
import com.group.service.QuocGiaS;
import com.group.service.TheLoaiS;
import com.group.topsis.BoLoc;
import com.group.topsis.BoTieuChi;
import com.group.topsis.BoTrongSo;
import com.group.topsis.TOPSIS;

@Controller
public class MainFrame {
	private JFrame frame;

	private JComboBox loaiMonCB;
	private JComboBox nguonGocCB;
	private JComboBox diUngCB;
	private JComboBox giaTuCB;
	private JComboBox choDenCB;
	private JComboBox doCayCB;
	private JSlider doCaySD;
	private JComboBox doNgotCB;
	private JComboBox doDinhDuongCB;
	private JComboBox doPhoBienCB;
	private JComboBox giaTienCB;
	private JSlider doNgotSD;
	private JSlider doDinhDuongSD;
	private JSlider doPhoBienSD;
	private JSlider giaTienSD;
	private JButton timKiemBTN;
	private JButton datMonBTN;
	private MonAnResultPanel ketquaTimKiemPanel;
	private JPanel danhSachDatMonPanel;

	public MainFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 972, 942);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 942, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 880, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(53, Short.MAX_VALUE)));

		JPanel datMonPanel = new JPanel();
		tabbedPane.addTab("\u0110\u1EB7t m\u00F3n", null, datMonPanel, null);

		JPanel boLocPanel = new JPanel();
		boLocPanel.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc k\u1EBFt qu\u1EA3", TitledBorder.LEFT,
				TitledBorder.TOP, null, null));
		boLocPanel.setBounds(12, 13, 304, 294);

		JPanel boTieuChiPanel = new JPanel();
		boTieuChiPanel.setBorder(new TitledBorder(null, "Ti\u00EAu ch\u00ED \u0111\u00E1nh gi\u00E1",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		boTieuChiPanel.setBounds(345, 13, 586, 294);
		boTieuChiPanel.setLayout(null);

		JLabel lblCay = new JLabel("\u0110\u1ED9 cay");
		lblCay.setBounds(12, 36, 94, 16);
		boTieuChiPanel.add(lblCay);

		JLabel lblNgt = new JLabel("\u0110\u1ED9 ng\u1ECDt");
		lblNgt.setBounds(12, 87, 94, 16);
		boTieuChiPanel.add(lblNgt);

		JLabel lblDinhDng = new JLabel("\u0110\u1ED9 dinh d\u01B0\u1EE1ng");
		lblDinhDng.setBounds(12, 138, 94, 16);
		boTieuChiPanel.add(lblDinhDng);

		JLabel lblPhBin = new JLabel("\u0110\u1ED9 ph\u1ED5 bi\u1EBFn");
		lblPhBin.setBounds(12, 189, 94, 16);
		boTieuChiPanel.add(lblPhBin);

		JLabel lblGiTin = new JLabel("Gi\u00E1 ti\u1EC1n");
		lblGiTin.setBounds(12, 243, 94, 16);
		boTieuChiPanel.add(lblGiTin);

		doCayCB = new JComboBox();
		doCayCB.setModel(new DefaultComboBoxModel(DoCay.values()));
		doCayCB.setBounds(118, 36, 108, 22);
		boTieuChiPanel.add(doCayCB);

		doCaySD = new JSlider();
		doCaySD.setPaintLabels(true);
		doCaySD.setValue(0);
		doCaySD.setMajorTickSpacing(1);
		doCaySD.setMaximum(4);
		doCaySD.setBounds(355, 36, 200, 38);
		boTieuChiPanel.add(doCaySD);
		datMonPanel.setLayout(null);

		JLabel lblLoiMn = new JLabel("Lo\u1EA1i m\u00F3n");
		lblLoiMn.setBounds(31, 41, 52, 16);

		JLabel lblNgunGc = new JLabel("Ngu\u1ED3n g\u1ED1c");
		lblNgunGc.setBounds(31, 92, 60, 16);

		JLabel lblDng = new JLabel("D\u1ECB \u1EE9ng");
		lblDng.setBounds(31, 143, 37, 16);

		JLabel lblGiT = new JLabel("Gi\u00E1 t\u1EEB");
		lblGiT.setBounds(31, 194, 34, 16);

		JLabel lblChon = new JLabel("Cho \u0111\u1EBFn");
		lblChon.setBounds(31, 245, 47, 16);

		String[] loaiMonItems = { "Cơm", "Cháo", "Phở", "Lalal", "bababa" };
		loaiMonCB = new JComboBox(loaiMonItems);

		loaiMonCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		loaiMonCB.setBounds(123, 41, 108, 22);

		nguonGocCB = new JComboBox();
		nguonGocCB.setBounds(123, 93, 108, 22);

		diUngCB = new JComboBox();
		diUngCB.setBounds(123, 145, 108, 22);

		giaTuCB = new JComboBox();
		giaTuCB.setBounds(123, 197, 108, 22);

		choDenCB = new JComboBox();
		choDenCB.setBounds(123, 247, 108, 22);
		boLocPanel.setLayout(null);
		boLocPanel.add(lblLoiMn);
		boLocPanel.add(lblNgunGc);
		boLocPanel.add(lblDng);
		boLocPanel.add(lblGiT);
		boLocPanel.add(lblChon);
		boLocPanel.add(choDenCB);
		boLocPanel.add(giaTuCB);
		boLocPanel.add(diUngCB);
		boLocPanel.add(nguonGocCB);
		boLocPanel.add(loaiMonCB);
		datMonPanel.add(boLocPanel);
		datMonPanel.add(boTieuChiPanel);

		doNgotCB = new JComboBox();
		doNgotCB.setModel(new DefaultComboBoxModel(DoNgot.values()));
		doNgotCB.setBounds(118, 87, 108, 22);
		boTieuChiPanel.add(doNgotCB);

		doDinhDuongCB = new JComboBox();
		doDinhDuongCB.setModel(new DefaultComboBoxModel(DoDinhDuong.values()));
		doDinhDuongCB.setBounds(118, 138, 108, 22);
		boTieuChiPanel.add(doDinhDuongCB);

		doPhoBienCB = new JComboBox();
		doPhoBienCB.setModel(new DefaultComboBoxModel(DoPhoBien.values()));
		doPhoBienCB.setBounds(118, 189, 108, 22);
		boTieuChiPanel.add(doPhoBienCB);

		giaTienCB = new JComboBox();
		giaTienCB.setModel(new DefaultComboBoxModel(GiaTien.values()));
		giaTienCB.setBounds(118, 243, 108, 22);
		boTieuChiPanel.add(giaTienCB);

		doNgotSD = new JSlider();
		doNgotSD.setValue(0);
		doNgotSD.setPaintLabels(true);
		doNgotSD.setMajorTickSpacing(1);
		doNgotSD.setMaximum(4);
		doNgotSD.setBounds(355, 87, 200, 38);
		boTieuChiPanel.add(doNgotSD);

		doDinhDuongSD = new JSlider();
		doDinhDuongSD.setValue(0);
		doDinhDuongSD.setPaintLabels(true);
		doDinhDuongSD.setMaximum(4);
		doDinhDuongSD.setMajorTickSpacing(1);
		doDinhDuongSD.setBounds(355, 138, 200, 38);
		boTieuChiPanel.add(doDinhDuongSD);

		doPhoBienSD = new JSlider();
		doPhoBienSD.setValue(0);
		doPhoBienSD.setMajorTickSpacing(1);
		doPhoBienSD.setPaintLabels(true);
		doPhoBienSD.setMaximum(4);
		doPhoBienSD.setBounds(355, 189, 200, 38);
		boTieuChiPanel.add(doPhoBienSD);

		giaTienSD = new JSlider();
		giaTienSD.setValue(0);
		giaTienSD.setPaintLabels(true);
		giaTienSD.setMajorTickSpacing(1);
		giaTienSD.setMaximum(4);
		giaTienSD.setBounds(355, 243, 200, 38);
		boTieuChiPanel.add(giaTienSD);

		JLabel lblMcuTin = new JLabel("M\u1EE9c \u01B0u ti\u00EAn");
		lblMcuTin.setBounds(267, 36, 94, 16);
		boTieuChiPanel.add(lblMcuTin);

		JLabel label = new JLabel("M\u1EE9c \u01B0u ti\u00EAn");
		label.setBounds(267, 87, 94, 16);
		boTieuChiPanel.add(label);

		JLabel label_1 = new JLabel("M\u1EE9c \u01B0u ti\u00EAn");
		label_1.setBounds(267, 138, 94, 16);
		boTieuChiPanel.add(label_1);

		JLabel label_2 = new JLabel("M\u1EE9c \u01B0u ti\u00EAn");
		label_2.setBounds(267, 189, 94, 16);
		boTieuChiPanel.add(label_2);

		JLabel label_3 = new JLabel("M\u1EE9c \u01B0u ti\u00EAn");
		label_3.setBounds(267, 243, 94, 16);
		boTieuChiPanel.add(label_3);

		ketquaTimKiemPanel = new MonAnResultPanel();
		ketquaTimKiemPanel.setBorder(new TitledBorder(null, "K\u1EBFt qu\u1EA3 t\u00ECm ki\u1EBFm",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ketquaTimKiemPanel.setBounds(12, 362, 919, 240);
		datMonPanel.add(ketquaTimKiemPanel);
//		ketquaTimKiemPanel.setLayout(null);

		danhSachDatMonPanel = new JPanel();
		danhSachDatMonPanel.setBorder(new TitledBorder(null, "Danh s\u00E1ch m\u00F3n \u0111\u00E3 ch\u1ECDn",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		danhSachDatMonPanel.setLayout(null);
		danhSachDatMonPanel.setBounds(12, 615, 919, 184);
		datMonPanel.add(danhSachDatMonPanel);

		timKiemBTN = new JButton("Tìm món ăn phù hợp");
		timKiemBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<MonAn> ketQuaTimKiem = topsis.userInputOccured(collectInfoOnBoLoc(), collectInfoOnBoTieuChi(),
						collectionInfoOnBoTrongSo());
				System.out.println(ketQuaTimKiem.size());
				ketquaTimKiemPanel.displayData(ketQuaTimKiem);
			}
		});
		timKiemBTN.setBounds(345, 334, 215, 25);
		datMonPanel.add(timKiemBTN);

		datMonBTN = new JButton("\u0110\u1EB7t m\u00F3n");
		datMonBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		datMonBTN.setBounds(345, 812, 215, 25);
		datMonPanel.add(datMonBTN);
		frame.getContentPane().setLayout(groupLayout);

	}

	public void displayFrame() {
		frame.setVisible(true);
	}

	@Autowired
	private DiUngS duS;
	@Autowired
	private MonAnS maS;
	@Autowired
	private MonAnNguyenLieuS manlS;
	@Autowired
	private NguyenLieuS nlS;
	@Autowired
	private QuocGiaS qgS;
	@Autowired
	private TheLoaiS tlS;

	final Integer[] mucGiaArr = { 0, 100, 200, 300, 400, 500, 600, 700, 800, 900 };

	public void injectData() {
		List<TheLoai> tls = tlS.tlR.findAll();
		List<QuocGia> qgs = qgS.qgR.findAll();
		List<DiUng> dus = duS.duR.findAll();

		loaiMonCB.setModel(new DefaultComboBoxModel<>(tls.toArray()));
		loaiMonCB.setSelectedIndex(tls.size() - 1);
		nguonGocCB.setModel(new DefaultComboBoxModel<>(qgs.toArray()));
		nguonGocCB.setSelectedIndex(qgs.size() - 1);
		diUngCB.setModel(new DefaultComboBoxModel<>(dus.toArray()));
		giaTuCB.setModel(new DefaultComboBoxModel<Integer>(mucGiaArr));
		choDenCB.setModel(new DefaultComboBoxModel<Integer>(mucGiaArr));
		choDenCB.setSelectedIndex(mucGiaArr.length - 1);
	}

	public BoLoc collectInfoOnBoLoc() {
		BoLoc boloc = new BoLoc();
		boloc.setDiUng((DiUng) diUngCB.getSelectedItem());
		boloc.setNguonGoc((QuocGia) nguonGocCB.getSelectedItem());
		boloc.setTheLoai((TheLoai) loaiMonCB.getSelectedItem());
		boloc.setGiaLonNhat((int) giaTuCB.getSelectedItem());
		boloc.setGiaLonNhat((int) choDenCB.getSelectedItem());
		return boloc;
	}

	public BoTieuChi collectInfoOnBoTieuChi() {
		BoTieuChi btc = new BoTieuChi();
		btc.setDoCay((DoCay) doCayCB.getSelectedItem());
		btc.setDoNgot((DoNgot) doNgotCB.getSelectedItem());
		btc.setDoDinhDuong((DoDinhDuong) doDinhDuongCB.getSelectedItem());
		btc.setDoPhoBien((DoPhoBien) doPhoBienCB.getSelectedItem());
		btc.setGiaTien((GiaTien) giaTienCB.getSelectedItem());
		return btc;
	}

	public BoTrongSo collectionInfoOnBoTrongSo() {
		return new BoTrongSo(doCaySD.getValue(), doNgotSD.getValue(), doDinhDuongSD.getValue(), doPhoBienSD.getValue(),
				giaTienSD.getValue());
	}

	@Autowired
	private TOPSIS topsis;

}
