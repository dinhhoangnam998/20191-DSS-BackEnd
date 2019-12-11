package com.group.gui;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.group.enums.DoCay;
import com.group.enums.DoDinhDuong;
import com.group.enums.DoNgot;
import com.group.enums.DoPhoBien;
import com.group.enums.GiaTien;
import com.group.gui.table.MonAnChuanTablePanel;
import com.group.gui.table.MonAnTablePanel;
import com.group.gui.table.PhuongAnTablePanel;
import com.group.gui.table.ThuocTinhMonAnTablePanel;
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
import com.group.topsis.BoTieuChiChuan;
import com.group.topsis.TOPSIS;
import com.group.topsis.user.BoLoc;
import com.group.topsis.user.BoTieuChi;
import com.group.topsis.user.BoTrongSo;
import com.group.topsis.user.BoTrongSoChuan;

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
	private MonAnTablePanel ketquaTimKiemPanel;
	private MonAnTablePanel danhSachDatMonPanel;

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
		doCayCB.setSelectedIndex(1);
		doCayCB.setBounds(118, 36, 108, 22);
		boTieuChiPanel.add(doCayCB);

		doCaySD = new JSlider();
		doCaySD.setPaintLabels(true);
		doCaySD.setValue(2);
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
		doDinhDuongCB.setSelectedIndex(2);
		doDinhDuongCB.setBounds(118, 138, 108, 22);
		boTieuChiPanel.add(doDinhDuongCB);

		doPhoBienCB = new JComboBox();
		doPhoBienCB.setModel(new DefaultComboBoxModel(DoPhoBien.values()));
		doPhoBienCB.setSelectedIndex(1);
		doPhoBienCB.setBounds(118, 189, 108, 22);
		boTieuChiPanel.add(doPhoBienCB);

		giaTienCB = new JComboBox();
		giaTienCB.setModel(new DefaultComboBoxModel(GiaTien.values()));
		giaTienCB.setBounds(118, 243, 108, 22);
		boTieuChiPanel.add(giaTienCB);

		doNgotSD = new JSlider();
		doNgotSD.setValue(1);
		doNgotSD.setPaintLabels(true);
		doNgotSD.setMajorTickSpacing(1);
		doNgotSD.setMaximum(4);
		doNgotSD.setBounds(355, 87, 200, 38);
		boTieuChiPanel.add(doNgotSD);

		doDinhDuongSD = new JSlider();
		doDinhDuongSD.setValue(2);
		doDinhDuongSD.setPaintLabels(true);
		doDinhDuongSD.setMaximum(4);
		doDinhDuongSD.setMajorTickSpacing(1);
		doDinhDuongSD.setBounds(355, 138, 200, 38);
		boTieuChiPanel.add(doDinhDuongSD);

		doPhoBienSD = new JSlider();
		doPhoBienSD.setValue(1);
		doPhoBienSD.setMajorTickSpacing(1);
		doPhoBienSD.setPaintLabels(true);
		doPhoBienSD.setMaximum(4);
		doPhoBienSD.setBounds(355, 189, 200, 38);
		boTieuChiPanel.add(doPhoBienSD);

		giaTienSD = new JSlider();
		giaTienSD.setValue(3);
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

		ketquaTimKiemPanel = new MonAnTablePanel();
		ketquaTimKiemPanel.setBorder(new TitledBorder(null, "K\u1EBFt qu\u1EA3 t\u00ECm ki\u1EBFm",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		ketquaTimKiemPanel.setBounds(12, 362, 919, 240);
		datMonPanel.add(ketquaTimKiemPanel);
		ketquaTimKiemPanel.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MonAn monAnMoiDuocChon = ketquaTimKiemPanel.getMonAnVuaDuocChon();
				danhSachDatMonPanel.addMonAn(monAnMoiDuocChon);
			}
		});

		danhSachDatMonPanel = new MonAnTablePanel();
		danhSachDatMonPanel.setBorder(new TitledBorder(null, "Danh s\u00E1ch m\u00F3n \u0111\u00E3 ch\u1ECDn",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		danhSachDatMonPanel.setBounds(12, 615, 919, 184);
		datMonPanel.add(danhSachDatMonPanel);
		danhSachDatMonPanel.table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = danhSachDatMonPanel.getRowIndexVuaDuocChon();
				danhSachDatMonPanel.removeMonAn(index);
			}
		});

		timKiemBTN = new JButton("Tìm món ăn phù hợp");
		timKiemBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				topsis.setup(collectInfoOnBoLoc(), collectInfoOnBoTieuChi(), collectionInfoOnBoTrongSo());
				ketquaTimKiemPanel.displayData(topsis.getKetQuaCuoiCung());
				injectDataToTopsisPanel();

			}
		});
		timKiemBTN.setBounds(345, 334, 215, 25);
		datMonPanel.add(timKiemBTN);

		datMonBTN = new JButton("\u0110\u1EB7t m\u00F3n");
		datMonBTN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<MonAn> mas = danhSachDatMonPanel.tableModel.monAns;
				JOptionPane.showMessageDialog(frame, maS.getOrderFormat(mas));
				for (MonAn ma : mas) {
					ma.setDoPhoBien(ma.getDoPhoBien() + 1);
					maS.maR.save(ma);
				}

			}
		});
		datMonBTN.setBounds(345, 812, 215, 25);
		datMonPanel.add(datMonBTN);

		topsisPanel = new JPanel();
		tabbedPane.addTab("TOPSIS", null, topsisPanel, null);
		topsisPanel.setLayout(null);

		panel = new JPanel();
		panel.setBounds(12, 13, 304, 169);
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(null, "B\u1ED9 l\u1ECDc k\u1EBFt qu\u1EA3", TitledBorder.LEFT,

				TitledBorder.TOP, null, null));
		topsisPanel.add(panel);

		label_4 = new JLabel("Loại món");
		label_4.setBounds(46, 20, 52, 16);
		panel.add(label_4);

		label_5 = new JLabel("Nguồn gốc");
		label_5.setBounds(46, 50, 60, 16);
		panel.add(label_5);

		label_6 = new JLabel("Dị ứng");
		label_6.setBounds(46, 80, 37, 16);
		panel.add(label_6);

		lblChon_1 = new JLabel("Cho đến");
		lblChon_1.setBounds(46, 140, 60, 16);
		panel.add(lblChon_1);

		lblGiT_1 = new JLabel("Giá từ");
		lblGiT_1.setBounds(46, 110, 47, 16);
		panel.add(lblGiT_1);

		loaimon = new JLabel("ALL");
		loaimon.setForeground(Color.BLACK);
		loaimon.setBounds(187, 20, 94, 16);
		panel.add(loaimon);

		nguongoc = new JLabel("Việt Nam");
		nguongoc.setForeground(Color.BLACK);
		nguongoc.setBounds(187, 50, 94, 16);
		panel.add(nguongoc);

		diung = new JLabel("Tôm");
		diung.setForeground(Color.BLACK);
		diung.setBounds(187, 80, 94, 16);
		panel.add(diung);

		giatu = new JLabel("100K");
		giatu.setForeground(Color.BLACK);
		giatu.setBounds(187, 110, 94, 16);
		panel.add(giatu);

		choden = new JLabel("400K");
		choden.setForeground(Color.BLACK);
		choden.setBounds(187, 140, 94, 16);
		panel.add(choden);

		panel_1 = new JPanel();
		panel_1.setBounds(328, 13, 586, 169);
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Ti\u00EAu ch\u00ED \u0111\u00E1nh gi\u00E1",

				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		topsisPanel.add(panel_1);

		label_9 = new JLabel("Độ cay");
		label_9.setBounds(12, 20, 94, 16);
		panel_1.add(label_9);

		label_10 = new JLabel("Độ ngọt");
		label_10.setBounds(12, 50, 94, 16);
		panel_1.add(label_10);

		label_11 = new JLabel("Độ dinh dưỡng");
		label_11.setBounds(12, 80, 94, 16);
		panel_1.add(label_11);

		label_12 = new JLabel("Độ phổ biến");
		label_12.setBounds(12, 110, 94, 16);
		panel_1.add(label_12);

		label_13 = new JLabel("Giá tiền");
		label_13.setBounds(12, 140, 94, 16);
		panel_1.add(label_13);

		label_14 = new JLabel("Mức ưu tiên");
		label_14.setBounds(358, 20, 94, 16);
		panel_1.add(label_14);

		label_15 = new JLabel("Mức ưu tiên");
		label_15.setBounds(358, 50, 94, 16);
		panel_1.add(label_15);

		label_16 = new JLabel("Mức ưu tiên");
		label_16.setBounds(358, 80, 94, 16);
		panel_1.add(label_16);

		label_17 = new JLabel("Mức ưu tiên");
		label_17.setBounds(358, 110, 94, 16);
		panel_1.add(label_17);

		label_18 = new JLabel("Mức ưu tiên");
		label_18.setBounds(358, 140, 94, 16);
		panel_1.add(label_18);

		tsdocay = new JLabel("1/4");
		tsdocay.setBounds(464, 20, 94, 16);
		panel_1.add(tsdocay);

		tsdongot = new JLabel("2/4");
		tsdongot.setBounds(464, 50, 94, 16);
		panel_1.add(tsdongot);

		tsdodinhduong = new JLabel("1/4");
		tsdodinhduong.setBounds(464, 80, 94, 16);
		panel_1.add(tsdodinhduong);

		tsdophobien = new JLabel("3/4");
		tsdophobien.setBounds(464, 110, 94, 16);
		panel_1.add(tsdophobien);

		tsgiatien = new JLabel("2/4");
		tsgiatien.setBounds(464, 140, 94, 16);
		panel_1.add(tsgiatien);

		docay = new JLabel("Rất Cay");
		docay.setBounds(118, 20, 80, 16);
		panel_1.add(docay);

		dongot = new JLabel("Khá Ngọt");
		dongot.setBounds(118, 50, 80, 16);
		panel_1.add(dongot);

		dodinhduong = new JLabel("Cao");
		dodinhduong.setBounds(118, 80, 80, 16);
		panel_1.add(dodinhduong);

		dophobien = new JLabel("Rất phổ biến");
		dophobien.setBounds(118, 110, 80, 16);
		panel_1.add(dophobien);

		giatien = new JLabel("Trung bình");
		giatien.setBounds(118, 140, 80, 16);
		panel_1.add(giatien);

		lhdocay = new JLabel("-> 4/4");
		lhdocay.setBounds(210, 20, 94, 16);
		panel_1.add(lhdocay);

		lhdongot = new JLabel("-> 3/4");
		lhdongot.setBounds(210, 50, 94, 16);
		panel_1.add(lhdongot);

		lhdodinhduong = new JLabel("-> 2/2");
		lhdodinhduong.setBounds(210, 80, 94, 16);
		panel_1.add(lhdodinhduong);

		lhdophobien = new JLabel("-> 2/2");
		lhdophobien.setBounds(210, 110, 94, 16);
		panel_1.add(lhdophobien);

		lhgiatien = new JLabel("-> 1/2");
		lhgiatien.setBounds(210, 140, 94, 16);
		panel_1.add(lhgiatien);

		panel_2 = new JPanel();
		panel_2.setToolTipText("Trọng số = mức ưu tiên  / tổng các mức ưu tiên");
		panel_2.setBounds(12, 189, 902, 112);
		panel_2.setBorder(new TitledBorder(null, "Chu\u1EA9n h\u00F3a th\u00F4ng tin ng\u01B0\u1EDDi d\u00F9ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		topsisPanel.add(panel_2);
		panel_2.setLayout(null);

		label_34 = new JLabel("Độ cay");
		label_34.setBounds(189, 24, 94, 16);
		panel_2.add(label_34);

		lblNgt_1 = new JLabel("Độ ngọt");
		lblNgt_1.setBounds(331, 24, 94, 16);
		panel_2.add(lblNgt_1);

		lblDinhDng_1 = new JLabel("Độ dinh dưỡng");
		lblDinhDng_1.setBounds(473, 24, 94, 16);
		panel_2.add(lblDinhDng_1);

		lblPhBin_1 = new JLabel("Độ phổ biến");
		lblPhBin_1.setBounds(615, 24, 94, 16);
		panel_2.add(lblPhBin_1);

		lblGiTin_1 = new JLabel("Giá tiền");
		lblGiTin_1.setBounds(757, 24, 94, 16);
		panel_2.add(lblGiTin_1);

		lblTieuchi = new JLabel("Tiêu Chí");
		lblTieuchi.setBounds(47, 24, 94, 16);
		panel_2.add(lblTieuchi);

		lblGiatri = new JLabel("Giá Trị");
		lblGiatri.setBounds(47, 53, 94, 16);
		panel_2.add(lblGiatri);

		gtdocay = new JLabel("Độ cay");
		gtdocay.setBounds(189, 53, 94, 16);
		panel_2.add(gtdocay);

		gtdongot = new JLabel("Mức ưu tiên");
		gtdongot.setBounds(331, 53, 94, 16);
		panel_2.add(gtdongot);

		gtdodinhduong = new JLabel("Mức ưu tiên");
		gtdodinhduong.setBounds(473, 53, 94, 16);
		panel_2.add(gtdodinhduong);

		gtdophobien = new JLabel("Mức ưu tiên");
		gtdophobien.setBounds(615, 53, 94, 16);
		panel_2.add(gtdophobien);

		gtgiatien = new JLabel("Mức ưu tiên");
		gtgiatien.setBounds(757, 53, 94, 16);
		panel_2.add(gtgiatien);

		lblTrngS = new JLabel("Trọng số");
		lblTrngS.setBounds(47, 82, 94, 16);
		panel_2.add(lblTrngS);

		tscdocay = new JLabel("Độ cay");
		tscdocay.setBounds(189, 82, 94, 16);
		panel_2.add(tscdocay);

		tscdongot = new JLabel("Mức ưu tiên");
		tscdongot.setBounds(331, 82, 94, 16);
		panel_2.add(tscdongot);

		tscdodinhduong = new JLabel("Mức ưu tiên");
		tscdodinhduong.setBounds(473, 82, 94, 16);
		panel_2.add(tscdodinhduong);

		tscdophobien = new JLabel("Mức ưu tiên");
		tscdophobien.setBounds(615, 82, 94, 16);
		panel_2.add(tscdophobien);

		tscgiatien = new JLabel("Mức ưu tiên");
		tscgiatien.setBounds(757, 82, 94, 16);
		panel_2.add(tscgiatien);

		dsmal = new ThuocTinhMonAnTablePanel();
		dsmal.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Danh s\u00E1ch m\u00F3n \u0103n l\u1ECDc t\u1EEB Database", TitledBorder.LEADING, TitledBorder.TOP,
				null, new Color(0, 0, 0)));
		dsmal.setBounds(12, 303, 902, 143);
		topsisPanel.add(dsmal);

		chttma = new MonAnChuanTablePanel();
		chttma.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"\u0110\u01B0a thu\u1ED9c t\u00EDnh c\u00E1c m\u00F3n \u0103n v\u1EC1 kho\u1EA3ng 0 - 1",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		chttma.setBounds(12, 447, 902, 143);
		topsisPanel.add(chttma);

		bqd = new PhuongAnTablePanel();
		bqd.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "B\u1EA3ng quy\u1EBFt \u0111\u1ECBnh",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		bqd.setBounds(12, 659, 902, 178);
		topsisPanel.add(bqd);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "M\u1ED9t s\u1ED1 th\u00F4ng tin", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_3.setBackground(SystemColor.control);
		panel_3.setBounds(12, 599, 902, 54);
		topsisPanel.add(panel_3);
		panel_3.setLayout(null);

		lblHmF = new JLabel("Hàm f: ");
		lblHmF.setBounds(12, 24, 56, 16);
		panel_3.add(lblHmF);

		lblBTrngS = new JLabel("Bộ trọng số");
		lblBTrngS.setBounds(491, 24, 79, 16);
		panel_3.add(lblBTrngS);

		lblThanhamf = new JLabel("return 1 - Math.abs(giaTriCuaUser - giaTriCuaMonAn)");
		lblThanhamf.setBounds(64, 24, 309, 16);
		panel_3.add(lblThanhamf);

		lblBotrongso = new JLabel("botrongso");
		lblBotrongso.setBounds(582, 24, 244, 16);
		panel_3.add(lblBotrongso);
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
		loaiMonCB.setSelectedIndex(5);
		nguonGocCB.setModel(new DefaultComboBoxModel<>(qgs.toArray()));
		nguonGocCB.setSelectedIndex(qgs.size() - 1);
		diUngCB.setModel(new DefaultComboBoxModel<>(dus.toArray()));
		giaTuCB.setModel(new DefaultComboBoxModel<Integer>(mucGiaArr));
		giaTuCB.setSelectedIndex(1);
		choDenCB.setModel(new DefaultComboBoxModel<Integer>(mucGiaArr));
		choDenCB.setSelectedIndex(mucGiaArr.length - 1);
	}

	public BoLoc collectInfoOnBoLoc() {
		BoLoc boloc = new BoLoc();
		boloc.setDiUng((DiUng) diUngCB.getSelectedItem());
		boloc.setNguonGoc((QuocGia) nguonGocCB.getSelectedItem());
		boloc.setTheLoai((TheLoai) loaiMonCB.getSelectedItem());
		boloc.setGiaNhoNhat((int) giaTuCB.getSelectedItem());
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

	private JPanel topsisPanel;
	private JPanel panel;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel lblChon_1;
	private JLabel lblGiT_1;
	private JPanel panel_1;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JLabel label_18;
	private JPanel panel_2;
	private ThuocTinhMonAnTablePanel dsmal;
	private MonAnChuanTablePanel chttma;
	private PhuongAnTablePanel bqd;
	private JLabel label_34;
	private JLabel lblNgt_1;
	private JLabel lblDinhDng_1;
	private JLabel lblPhBin_1;
	private JLabel lblGiTin_1;
	private JLabel lblTieuchi;
	private JLabel lblGiatri;
	private JLabel gtdocay;
	private JLabel gtdongot;
	private JLabel gtdodinhduong;
	private JLabel gtdophobien;
	private JLabel gtgiatien;
	private JLabel lblTrngS;
	private JLabel tscdocay;
	private JLabel tscdongot;
	private JLabel tscdodinhduong;
	private JLabel tscdophobien;
	private JLabel tscgiatien;
	private JLabel loaimon;
	private JLabel nguongoc;
	private JLabel diung;
	private JLabel giatu;
	private JLabel choden;
	private JLabel docay;
	private JLabel dongot;
	private JLabel dodinhduong;
	private JLabel dophobien;
	private JLabel giatien;
	private JLabel tsdocay;
	private JLabel tsdongot;
	private JLabel tsdodinhduong;
	private JLabel tsdophobien;
	private JLabel tsgiatien;
	private JLabel lhdocay;
	private JLabel lhdongot;
	private JLabel lhdodinhduong;
	private JLabel lhdophobien;
	private JLabel lhgiatien;
	private JLabel lblHmF;
	private JLabel lblBTrngS;
	private JLabel lblThanhamf;
	private JLabel lblBotrongso;

	private void injectDataToTopsisPanel() {
		injectDataBoLoc();
		injectDataTieuChi();
		injectDataChuanHoa();
		injectChuanHoaDuLieuNguoiDung();
		injectFAndATotAXau();
		populaDataToTableOnTopsis();
	}

	private void injectDataBoLoc() {
		BoLoc boloc = topsis.getUserInputData().getBoLoc();
		loaimon.setText(boloc.getTheLoai().getTen());
		nguongoc.setText(boloc.getNguonGoc().getTen());
		diung.setText(boloc.getDiUng().getTen());
		giatu.setText(Integer.valueOf(boloc.getGiaNhoNhat()).toString());
		choden.setText(Integer.valueOf(boloc.getGiaLonNhat()).toString());
	}

	private void injectDataTieuChi() {
		BoTieuChi btc = topsis.getUserInputData().getBoTieuChi();
		docay.setText(btc.getDoCay().getText());
		dongot.setText(btc.getDoNgot().getText());
		dodinhduong.setText(btc.getDoDinhDuong().getText());
		dophobien.setText(btc.getDoPhoBien().getText());
		giatien.setText(btc.getGiaTien().getText());

		lhdocay.setText("<==>   " + btc.getDoCay().getValue() + "/4");
		lhdongot.setText("<==>   " + btc.getDoNgot().getValue() + "/4");
		lhdodinhduong.setText("<==>   " + btc.getDoDinhDuong().getValue() + "/2");
		lhdophobien.setText("<==>   " + btc.getDoPhoBien().getValue() + "/2");
		lhgiatien.setText("<==>   " + btc.getGiaTien().getValue() + "/2");
	}

	private void injectDataChuanHoa() {
		BoTrongSo bts = topsis.getUserInputData().getBoTrongSo();
		tsdocay.setText(Integer.valueOf(bts.getWDoCay()).toString() + "/4");
		tsdongot.setText(Integer.valueOf(bts.getWDoNgot()).toString() + "/4");
		tsdodinhduong.setText(Integer.valueOf(bts.getWDoDinhDuong()).toString() + "/4");
		tsdophobien.setText(Integer.valueOf(bts.getWDoPhoBien()).toString() + "/4");
		tsgiatien.setText(Integer.valueOf(bts.getWGiaTien()).toString() + "/4");
	}

	private void injectChuanHoaDuLieuNguoiDung() {
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);
		BoTieuChiChuan btcc = topsis.getUserInputChuanHoa().getBoTieuChiChuan();
		BoTrongSoChuan btsc = topsis.getUserInputChuanHoa().getBoTrongSoChuan();

		gtdocay.setText(Double.valueOf(btcc.getDoCay()).toString());
		gtdongot.setText(Double.valueOf(btcc.getDoNgot()).toString());
		gtdodinhduong.setText(Double.valueOf(btcc.getDoDinhDuong()).toString());
		gtdophobien.setText(Double.valueOf(btcc.getDoPhoBien()).toString());
		gtgiatien.setText(Double.valueOf(btcc.getGiaTien()).toString());

		tscdocay.setText(df.format(btsc.getWDoCay()).toString());
		tscdongot.setText(df.format(btsc.getWDoNgot()).toString());
		tscdodinhduong.setText(df.format(btsc.getWDoDinhDuong()).toString());
		tscdophobien.setText(df.format(btsc.getWDoPhoBien()).toString());
		tscgiatien.setText(df.format(btsc.getWGiaTien()).toString());

	}

	public void injectFAndATotAXau() {
		DecimalFormat df = new DecimalFormat("#.###");
		df.setRoundingMode(RoundingMode.CEILING);
		lblBotrongso.setText(tscdocay.getText() + "  " + tscdongot.getText() + "  " + tscdodinhduong.getText() + "  "
				+ tscdophobien.getText() + "  " + tscgiatien.getText());
		BoTieuChiChuan t = topsis.getPhuongAnLyTuongTot().getBoTieuChiChuan();
		BoTieuChiChuan x = topsis.getPhuongAnLyTuongXau().getBoTieuChiChuan();
//		lblAtot.setText(
//				"(" + df.format(t.getDoCay()) + ", " + df.format(t.getDoNgot()) + ", " + df.format(t.getDoDinhDuong())
//						+ ", " + df.format(t.getDoPhoBien()) + ", " + df.format(t.getGiaTien()) + ")");
//		lblAxau.setText(
//				"(" + df.format(x.getDoCay()) + ", " + df.format(x.getDoNgot()) + ", " + df.format(x.getDoDinhDuong())
//						+ ", " + df.format(x.getDoPhoBien()) + ", " + df.format(x.getGiaTien()) + ")");
	}

	private void populaDataToTableOnTopsis() {
		dsmal.displayData(topsis.getKetQuaLocMonAn());
		chttma.displayData(topsis.getMonAnDaChuanHoa());
		bqd.displayData(topsis.getBangQuyetDinh());

	}
}
