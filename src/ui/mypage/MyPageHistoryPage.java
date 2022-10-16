package ui.mypage;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dto.StudentDTO;
import dto.SubjectDTO;
import dto.TestDTO;
import ui.Main;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MyPageHistoryPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel contentPane;
	ActionListener action;
	DefaultTableModel model;
	Vector<SubjectDTO> v;
	StudentDTO stu = new StudentDTO();

	public MyPageHistoryPage() {

		setSize(600, 400);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		String header = "과목/유형/출제년도/총점/시험날짜";

		ArrayList<TestDTO> tests = Main.dao.getAllTestData(Main.student.getStudentNo());

		model = new DefaultTableModel(header.split("/"), 0);
		model.setNumRows(0);

		for (int i = 0; i < tests.size(); i++) {
			split(tests.get(i).toStringTestHistory());
		}

		contentPane.setLayout(new BorderLayout(0, 0));

		JTable table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		contentPane.add(pane, BorderLayout.CENTER);

		JLabel lblNewLabel = new JLabel("이전 시험 기록");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);

		JButton close = new JButton("닫기");
		contentPane.add(close, BorderLayout.SOUTH);
		close.addActionListener(e -> {
			dispose();
		});

		setVisible(true);
	}

	public void split(String str) {
		model.addRow(str.split("/"));
	}
}
