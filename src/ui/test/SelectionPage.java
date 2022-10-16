package ui.test;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dto.SubjectDTO;
import ui.Main;

import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.UIManager;

public class SelectionPage extends JPanel {

	private static final long serialVersionUID = 1L;

	public SelectionPage(String pageType) {
		// 창 설정
		setSize(400, 400);
		setLayout(new BorderLayout(0, 0));

		// North 타이틀 설정
		JPanel pNorth = new JPanel(new BorderLayout());
		pNorth.setBorder(new EmptyBorder(20, 20, 20, 20));
		add(pNorth, BorderLayout.NORTH);
		JPanel pCenter = new JPanel();
		pCenter.setBorder(UIManager.getBorder("CheckBox.border"));
		add(pCenter, BorderLayout.CENTER);
		JPanel pSouth = new JPanel();
		add(pSouth, BorderLayout.SOUTH);
		
		JLabel lblTitle = new JLabel("과목 선택");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pNorth.add(lblTitle);
		
		JButton btnPrevious = new JButton("이전");
		pSouth.add(btnPrevious);
		JButton btnSelectSubject = new JButton("선택");
		pSouth.add(btnSelectSubject);
		
		GridBagLayout gbl_pCenter = new GridBagLayout();
		gbl_pCenter.columnWidths = new int[] {30, 0, 30};
		gbl_pCenter.rowHeights = new int[] {30, 30, 0};
		gbl_pCenter.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pCenter.rowWeights = new double[]{0.0, 1.0, 0.0};
		pCenter.setLayout(gbl_pCenter);
		
		JPanel pSelection = new JPanel();
		GridBagConstraints gbc_pSelection = new GridBagConstraints();
		gbc_pSelection.insets = new Insets(0, 0, 5, 0);
		gbc_pSelection.gridx = 1;
		gbc_pSelection.gridy = 1;
		pCenter.add(pSelection, gbc_pSelection);
		GridBagLayout gbl_pSelection = new GridBagLayout();
		gbl_pSelection.columnWidths = new int[] {50, 150};
		gbl_pSelection.rowHeights = new int[] {25, 25, 25, 25};
		gbl_pSelection.columnWeights = new double[]{4.9E-324, 0.0};
		gbl_pSelection.rowWeights = new double[]{4.9E-324, 0.0, 0.0, 0.0};
		pSelection.setLayout(gbl_pSelection);
		
		JLabel lblSubjectName = new JLabel("과목");
		GridBagConstraints gbc_lblSubjectName = new GridBagConstraints();
		gbc_lblSubjectName.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubjectName.gridx = 0;
		gbc_lblSubjectName.gridy = 0;
		pSelection.add(lblSubjectName, gbc_lblSubjectName);
		JComboBox<String> cbSubjectName = new JComboBox<String>();
		cbSubjectName.setSelectedIndex(-1);
		GridBagConstraints gbc_cbSubjectName = new GridBagConstraints();
		gbc_cbSubjectName.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSubjectName.insets = new Insets(0, 0, 5, 0);
		gbc_cbSubjectName.gridx = 1;
		gbc_cbSubjectName.gridy = 0;
		pSelection.add(cbSubjectName, gbc_cbSubjectName);
		
		JLabel lblSubjectGrade = new JLabel("등급");
		GridBagConstraints gbc_lblSubjectGrade = new GridBagConstraints();
		gbc_lblSubjectGrade.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubjectGrade.gridx = 0;
		gbc_lblSubjectGrade.gridy = 1;
		pSelection.add(lblSubjectGrade, gbc_lblSubjectGrade);
		JComboBox<String> cbSubjectGrade = new JComboBox<String>();
		cbSubjectGrade.setSelectedIndex(-1);
		cbSubjectGrade.setEnabled(false);
		GridBagConstraints gbc_cbSubjectGrade = new GridBagConstraints();
		gbc_cbSubjectGrade.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSubjectGrade.insets = new Insets(0, 0, 5, 0);
		gbc_cbSubjectGrade.gridx = 1;
		gbc_cbSubjectGrade.gridy = 1;
		pSelection.add(cbSubjectGrade, gbc_cbSubjectGrade);
		
		JLabel lblSubjectType = new JLabel("유형");
		GridBagConstraints gbc_lblSubjectType = new GridBagConstraints();
		gbc_lblSubjectType.insets = new Insets(0, 0, 5, 5);
		gbc_lblSubjectType.gridx = 0;
		gbc_lblSubjectType.gridy = 2;
		pSelection.add(lblSubjectType, gbc_lblSubjectType);
		JComboBox<String> cbSubjectType = new JComboBox<String>();
		cbSubjectType.setSelectedIndex(-1);
		cbSubjectType.setEnabled(false);
		GridBagConstraints gbc_cbSubjectType = new GridBagConstraints();
		gbc_cbSubjectType.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSubjectType.insets = new Insets(0, 0, 5, 0);
		gbc_cbSubjectType.gridx = 1;
		gbc_cbSubjectType.gridy = 2;
		pSelection.add(cbSubjectType, gbc_cbSubjectType);
		
		JLabel lblPubYear = new JLabel("년도");
		GridBagConstraints gbc_lblPubYear = new GridBagConstraints();
		gbc_lblPubYear.insets = new Insets(0, 0, 0, 5);
		gbc_lblPubYear.gridx = 0;
		gbc_lblPubYear.gridy = 3;
		pSelection.add(lblPubYear, gbc_lblPubYear);
		JComboBox<String> cbPubYear = new JComboBox<String>();
		cbPubYear.setSelectedIndex(-1);
		cbPubYear.setEnabled(false);
		GridBagConstraints gbc_cbPubYear = new GridBagConstraints();
		gbc_cbPubYear.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbPubYear.gridx = 1;
		gbc_cbPubYear.gridy = 3;
		pSelection.add(cbPubYear, gbc_cbPubYear);
	
		ArrayList<SubjectDTO> subjects = Main.dao.getSubjectData();

		//콤보박스
		
		//기본값
		cbSubjectGrade.setEnabled(false);
		cbSubjectType.setEnabled(false);
		cbPubYear.setEnabled(false);
		btnSelectSubject.setEnabled(false);
		HashSet<String> nameSet = new HashSet<String>();
		HashSet<String> gradeSet = new HashSet<String>();
		HashSet<String> typeSet = new HashSet<String>();
		HashSet<String> yearSet = new HashSet<String>();
		for(SubjectDTO sub:subjects)
			nameSet.add(sub.getSubjectName());
		cbSubjectName.setModel(new DefaultComboBoxModel<String>(nameSet.toArray(new String[0])));
		//과목 선택시
		cbSubjectName.addActionListener(e->{
			for(SubjectDTO sub: subjects) {
				if(sub.getSubjectName().equals
						(cbSubjectName.getSelectedItem().toString())) {
					gradeSet.add(sub.getSubjectGrade());
				}
			}
			cbSubjectGrade.setModel(new DefaultComboBoxModel<String>(gradeSet.toArray(new String[0])));
			cbSubjectGrade.setEnabled(true);
			cbSubjectType.setEnabled(false);
			cbPubYear.setEnabled(false);
			btnSelectSubject.setEnabled(false);
		});
		//등급 선택시
		cbSubjectGrade.addActionListener(e->{
			for(SubjectDTO sub: subjects) {
				if(sub.getSubjectName().equals(cbSubjectName.getSelectedItem().toString()) 
						&& sub.getSubjectGrade().equals(cbSubjectGrade.getSelectedItem().toString()))
				{
					typeSet.add(sub.getSubjectType());
				}
			}
			cbSubjectType.setModel(new DefaultComboBoxModel<String>(typeSet.toArray(new String[0])));
			cbSubjectType.setEnabled(true);
			cbPubYear.setEnabled(false);
			btnSelectSubject.setEnabled(false);
		});
		//유형 선택시
		cbSubjectType.addActionListener(e->{
			for(SubjectDTO sub: subjects) {
				if(sub.getSubjectName().equals(cbSubjectName.getSelectedItem().toString()) 
						&& sub.getSubjectGrade().equals(cbSubjectGrade.getSelectedItem().toString())
						&& sub.getSubjectType().equals(cbSubjectType.getSelectedItem().toString())) 
				{
					yearSet.add(sub.getPubYear());
				}
			}
			cbPubYear.setModel(new DefaultComboBoxModel<String>(yearSet.toArray(new String[0])));
			cbPubYear.setEnabled(true);
			btnSelectSubject.setEnabled(false);
		});
		//년도 선택시
		cbPubYear.addActionListener(e->{
			btnSelectSubject.setEnabled(true);
		});
		
		//이전 버튼
		btnPrevious.addActionListener(e->Main.frame.setContentPane(Main.history.pop()));

		//선택 버튼
		btnSelectSubject.addActionListener(e->{
			//과목,등급,유형,년도 검사
			for ( SubjectDTO subject : subjects ) {
				if (subject.getSubjectName().equals(cbSubjectName.getSelectedItem()) 
						&& subject.getSubjectGrade().equals(cbSubjectGrade.getSelectedItem()) 
						&& subject.getSubjectType().equals(cbSubjectType.getSelectedItem()) 
						&& subject.getPubYear().equals(cbPubYear.getSelectedItem()) 
						) {
					Main.subject = subject;
					break;
				}
			}
			//테스트인포
			if (Main.dao.getQuestionDataWithSubject(Main.subject).size() == 0) {
				JOptionPane.showMessageDialog(null, "준비 중인 과목입니다.", "문제 불러오기 실패", JOptionPane.WARNING_MESSAGE);
				return;
			}
			Main.goToPage(new TestInfoPage(pageType));
		});
	}
}
