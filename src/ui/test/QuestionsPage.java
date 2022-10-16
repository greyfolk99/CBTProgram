package ui.test;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import dto.QuestionDTO;
import dto.RecordDTO;
import dto.TestDTO;
import ui.Main;
import ui.MenuPage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class QuestionsPage extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLayeredPane contentPane; // 메인
	private List<JPanel> panels; // 패널들

	// 필드값
	private ArrayList<QuestionDTO> questions; // 문제들
	private int[] answers; // 답안들
	private int pageNo, maxNo; // 페이지 번호, 총 문제 개수
	private TimerLabel lbTimer;

	public QuestionsPage(String pagetype, int[] answers, ArrayList<QuestionDTO> questions) {
		
		// 기본값 설정
		this.answers = answers;
		this.questions = questions;
		pageNo = 1; // 1
		maxNo = questions.size(); // 100
		panels = new ArrayList<JPanel>();
		for (int i = 0; i < maxNo; i++) {
			panels.add(new JPanel());
		}
		answers = new int[maxNo];

		// 기본 창 설정
		Main.frame.setSize(1000, 700);
		setLayout(new BorderLayout(0, 0));
		contentPane = new JLayeredPane();
		add(contentPane);
		contentPane.setLayout(new CardLayout());

		lbTimer = new TimerLabel(Main.subject.getTestTime());

		draw(panels.get(pageNo - 1), pagetype);
		
	}

	public void draw(JPanel p, String pagetype) {
		contentPane.removeAll();
		contentPane.add(p);
		contentPane.repaint();
		contentPane.revalidate();
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		p.setLayout(new BorderLayout(0, 0));

		/* North */
		JPanel pNorth = new JPanel();
		pNorth.setBackground(new Color(255, 255, 255));
		p.add(pNorth, BorderLayout.NORTH);
		GridBagLayout gbl_pNorth = new GridBagLayout();
		gbl_pNorth.columnWidths = new int[] { 200, 200, 200, 200, 200 };
		gbl_pNorth.rowHeights = new int[] { 30, 30, 30 };
		gbl_pNorth.columnWeights = new double[] { 0.0, 0.0 };
		gbl_pNorth.rowWeights = new double[] { 0.0, 0.0 };
		pNorth.setLayout(gbl_pNorth);
		
		// 모의고사일때 타이머 추가
		if (pagetype.equals("MOCK")) {
			GridBagConstraints gbc_lbTimer = new GridBagConstraints();
			gbc_lbTimer.insets = new Insets(0, 0, 5, 5);
			gbc_lbTimer.fill = GridBagConstraints.HORIZONTAL;
			gbc_lbTimer.gridx = 4;
			gbc_lbTimer.gridy = 0;
			pNorth.add(lbTimer, gbc_lbTimer);
		}
		JLabel lblTitle = new JLabel(Main.subject.toString());
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 20));
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.gridwidth = 3;
		gbc_lblTitle.gridx = 1;
		gbc_lblTitle.gridy = 1;
		pNorth.add(lblTitle, gbc_lblTitle);

		/* Center */

		JPanel pCenter = new JPanel();
		pCenter.setBorder(null);
		p.add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new BorderLayout(0, 0));

		JPanel pContent = new JPanel();
		pCenter.add(pContent, BorderLayout.CENTER);
		pContent.setLayout(new BorderLayout(0, 0));
		JLabel lbContent = new JLabel();
		lbContent.setAutoscrolls(true);
		
		String str = "<html><body>";
		if (pagetype.equals("QUIZ")) {
		str +=questions.get(pageNo-1).getCategory()+ "<br>";}
		str	+="정답률: " + questions.get(pageNo - 1).getCorrectRate() + "%" + "<br>"
			+ "문제 " + pageNo + "번"+ "<br>"
			+ questions.get(pageNo - 1).getTitle() + "<br>" 
			+ questions.get(pageNo - 1).getContent() + "<br>";
		str	+="</body></html>";
		lbContent.setText(str);
		pContent.add(lbContent, BorderLayout.NORTH);

		try {
			ImageContainer imgPanel = new ImageContainer(questions.get(pageNo - 1));
			pContent.add(imgPanel, BorderLayout.CENTER);
		} catch (IOException ex) {
			pContent.setSize(1000, 300);
		}

		JPanel pRadioBtnGroup = new JPanel();
		pRadioBtnGroup.setBorder(new LineBorder(new Color(0, 0, 0)));
		pRadioBtnGroup.setBackground(Color.WHITE);
		pCenter.add(pRadioBtnGroup, BorderLayout.SOUTH);
		GridBagLayout gbl_pRadioBtnGroup = new GridBagLayout();
		gbl_pRadioBtnGroup.columnWidths = new int[] { 100, 800, 200, 0 };
		gbl_pRadioBtnGroup.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_pRadioBtnGroup.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pRadioBtnGroup.rowWeights = new double[] { 0.0, 4.9E-324, 0.0, 0.0, Double.MIN_VALUE };
		pRadioBtnGroup.setLayout(gbl_pRadioBtnGroup);
		// 선택지
		JRadioButton rdbtnSelect1 = new JRadioButton(questions.get(pageNo - 1).getSelect1());
		rdbtnSelect1.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnSelect1 = new GridBagConstraints();
		gbc_rdbtnSelect1.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnSelect1.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSelect1.gridx = 1;
		gbc_rdbtnSelect1.gridy = 0;
		JRadioButton rdbtnSelect2 = new JRadioButton(questions.get(pageNo - 1).getSelect2());
		rdbtnSelect2.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnSelect2 = new GridBagConstraints();
		gbc_rdbtnSelect2.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnSelect2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSelect2.gridx = 1;
		gbc_rdbtnSelect2.gridy = 1;
		JRadioButton rdbtnSelect3 = new JRadioButton(questions.get(pageNo - 1).getSelect3());
		rdbtnSelect3.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnSelect3 = new GridBagConstraints();
		gbc_rdbtnSelect3.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnSelect3.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnSelect3.gridx = 1;
		gbc_rdbtnSelect3.gridy = 2;
		JRadioButton rdbtnSelect4 = new JRadioButton(questions.get(pageNo - 1).getSelect4());
		rdbtnSelect4.setBackground(Color.WHITE);
		GridBagConstraints gbc_rdbtnSelect4 = new GridBagConstraints();
		gbc_rdbtnSelect4.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnSelect4.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnSelect4.gridx = 1;
		gbc_rdbtnSelect4.gridy = 3;
		pRadioBtnGroup.add(rdbtnSelect1, gbc_rdbtnSelect1);
		pRadioBtnGroup.add(rdbtnSelect2, gbc_rdbtnSelect2);
		pRadioBtnGroup.add(rdbtnSelect3, gbc_rdbtnSelect3);
		pRadioBtnGroup.add(rdbtnSelect4, gbc_rdbtnSelect4);

		// (EXPLAIN 창일 경우 디폴트값 설정 후 disable)

		/* South */

		JPanel pSouth = new JPanel();
		p.add(pSouth, BorderLayout.SOUTH);
		pSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		// 해설창일 경우 추가 설정

		if (!pagetype.equals("EXPLAIN")) {
			ButtonGroup btnGroup = new ButtonGroup();
			btnGroup.add(rdbtnSelect1);
			btnGroup.add(rdbtnSelect2);
			btnGroup.add(rdbtnSelect3);
			btnGroup.add(rdbtnSelect4);
		}

		if (pagetype.equals("EXPLAIN")) {
			int ans = answers[pageNo - 1];
			int cor = questions.get(pageNo - 1).getAnsNo();
			if (ans == cor && ans == 1) {
				rdbtnSelect1.setBackground(Color.BLUE);
			}
			if (ans == cor && ans == 2) {
				rdbtnSelect2.setBackground(Color.BLUE);
			}
			if (ans == cor && ans == 3) {
				rdbtnSelect3.setBackground(Color.BLUE);
			}
			if (ans == cor && ans == 4) {
				rdbtnSelect4.setBackground(Color.BLUE);
			}
			if (ans != cor && ans == 1) {
				rdbtnSelect1.setBackground(Color.RED);
			}
			if (ans != cor && ans == 2) {
				rdbtnSelect2.setBackground(Color.RED);
			}
			if (ans != cor && ans == 3) {
				rdbtnSelect3.setBackground(Color.RED);
			}
			if (ans != cor && ans == 4) {
				rdbtnSelect4.setBackground(Color.RED);
			}
			if (cor == 1)
				rdbtnSelect1.setSelected(true);
			if (ans == 1)
				rdbtnSelect1.setSelected(true);
			if (cor == 2)
				rdbtnSelect2.setSelected(true);
			if (ans == 2)
				rdbtnSelect2.setSelected(true);
			if (cor == 3)
				rdbtnSelect3.setSelected(true);
			if (ans == 3)
				rdbtnSelect3.setSelected(true);
			if (cor == 4)
				rdbtnSelect4.setSelected(true);
			if (ans == 4)
				rdbtnSelect4.setSelected(true);
			rdbtnSelect1.setEnabled(false);
			rdbtnSelect2.setEnabled(false);
			rdbtnSelect3.setEnabled(false);
			rdbtnSelect4.setEnabled(false);

			JTextArea taExplain = new JTextArea(questions.get(pageNo-1).getExplain());
			taExplain.setLineWrap(true);
			taExplain.setEditable(false);
			pContent.add(taExplain, BorderLayout.SOUTH);
			taExplain.setVisible(false);
			JButton btnExplain = new JButton("해설 보기");
			pSouth.add(btnExplain);
			btnExplain.addActionListener(e -> {
				taExplain.setVisible(!taExplain.isVisible());
			});
			JButton btnExit = new JButton("종료");
			pSouth.add(btnExit);
			btnExit.addActionListener(e -> {
				Main.subject = null;
				Main.goToPage(new MenuPage());
			});
			revalidate();
		}

		// 이전 버튼
		JButton btnPrevious = new JButton("이전");
		pSouth.add(btnPrevious);
		btnPrevious.addActionListener(e -> {
			if (pageNo == 1) {
				int result = JOptionPane.showConfirmDialog(null, "시험을 종료하시겠습니까?", "시험종료", JOptionPane.OK_CANCEL_OPTION);
				if (result == 0) {
					Main.subject = null;
					Main.goToPage(new MenuPage());
				}
			}
			if (pageNo > 1) {
				if (rdbtnSelect1.isSelected())
					answers[pageNo - 1] = 1;
				if (rdbtnSelect2.isSelected())
					answers[pageNo - 1] = 2;
				if (rdbtnSelect3.isSelected())
					answers[pageNo - 1] = 3;
				if (rdbtnSelect4.isSelected())
					answers[pageNo - 1] = 4;
				pageNo--;
				draw(panels.get(pageNo - 1), pagetype);
			}
		});
		// 다음 버튼 (마지막 페이지일 경우 표시안함)
		if (pageNo < maxNo) {
			JButton btnNext = new JButton("다음");
			pSouth.add(btnNext);
			btnNext.addActionListener(e -> {
				if (rdbtnSelect1.isSelected())
					answers[pageNo - 1] = 1;
				if (rdbtnSelect2.isSelected())
					answers[pageNo - 1] = 2;
				if (rdbtnSelect3.isSelected())
					answers[pageNo - 1] = 3;
				if (rdbtnSelect4.isSelected())
					answers[pageNo - 1] = 4;
				pageNo++;
				draw(panels.get(pageNo - 1), pagetype);
			});
		}
		// 완료 버튼 (마지막 페이지일 경우 표시)
		if (pageNo == maxNo && !pagetype.equals("EXPLAIN")) {
			JButton btnComplete = new JButton("완료");
			pSouth.add(btnComplete);
			btnComplete.addActionListener(e -> {
				if (rdbtnSelect1.isSelected())
					answers[pageNo - 1] = 1;
				if (rdbtnSelect2.isSelected())
					answers[pageNo - 1] = 2;
				if (rdbtnSelect3.isSelected())
					answers[pageNo - 1] = 3;
				if (rdbtnSelect4.isSelected())
					answers[pageNo - 1] = 4;

				int result = JOptionPane.showConfirmDialog(null, "시험을 완료하시겠습니까?", "시험 종료",
						JOptionPane.OK_CANCEL_OPTION);// OK=0 , Cancel=2
				if (result == 2) {
					return;
				}
				int score = 0;
				for (int i = 0; i < maxNo; i++) {
					if (questions.get(i).getAnsNo() == answers[i]) {
						score++;
					}
				}
				
				TestDTO test = new TestDTO();
				if (pagetype.equals("MOCK")) {
					if (lbTimer.getSec()<=0) score = 0;
					
					// 테스트 db 저장 (db에서 테스트 번호 및 완료시간 자동 생성)
					TestDTO tempTest = new TestDTO();
					tempTest.setStudent(Main.student);
					tempTest.setSubject(Main.subject);
					tempTest.setScore(score);
					tempTest.setTakeTime(Main.subject.getTestTime() * 60 - lbTimer.getSec());
					Main.dao.addTestData(tempTest);
					// 테스트 전부 가져와서 테스트번호 및 완료시간 찾기
					ArrayList<TestDTO> tests = Main.dao.getTestDataWithStudentNo(Main.student.getStudentNo());
					test.setTestNo(tests.get(tests.size() - 1).getTestNo());
					test.setEndTime(tests.get(tests.size() - 1).getEndTime());
				}
				
				// 테스트 나머지 정보 저장
				test.setTakeTime(Main.subject.getTestTime() * 60 - lbTimer.getSec());
				test.setStudent(Main.student);
				test.setSubject(Main.subject);
				test.setScore(score);
				
				// 레코드 생성
				ArrayList<RecordDTO> records = new ArrayList<RecordDTO>();
				for (int i = 0; i < maxNo; i++) {
					records.add(new RecordDTO(Main.student, test, questions.get(i), answers[i],
							questions.get(i).getCategory(), questions.get(i).getKeyword()));
				}
				
				if (pagetype.equals("MOCK")) {
					// 레코드 db 저장
					Main.dao.addRecordData(records);
					// 정답률 업데이트(시간 소요) *추후 관리자 기능 제작시 업데이트 기능으로 이전 필요
					for(RecordDTO record : records)
					Main.dao.updateCorrectRate(record.getQuestion(), Main.dao.getCorrectRate(record));
				}
				
				Main.goToPage(new ResultPage(records, questions));
				revalidate();
			});
		}
	}
}
