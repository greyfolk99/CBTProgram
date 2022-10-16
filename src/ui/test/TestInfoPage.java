package ui.test;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import dto.QuestionDTO;
import ui.Main;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;

public class TestInfoPage extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TestInfoPage(String pagetype) {
		setSize(500, 500);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		JPanel pNorth = new JPanel();
		JPanel pCenter = new JPanel();
		JPanel pSouth = new JPanel();
		setLayout(new BorderLayout(0, 0));
		add(pNorth, BorderLayout.NORTH);
		add(pCenter, BorderLayout.CENTER);
		add(pSouth, BorderLayout.SOUTH);
		JTextArea lblInfo = new JTextArea();
		String infotext = Main.subject.testinfo()+" ";
		if (pagetype.equals("MOCK")) {
			infotext += "주어진 시간은 총 "+Main.subject.getTestTime()+"분이며 이후로 제출된 시험은 무효처리됩니다.";
		}
		lblInfo.setText(infotext);
		lblInfo.setLineWrap(true);
		if (pagetype.equals("MOCK")) {
			JLabel lblTitleMock = new JLabel("모의고사");
			pNorth.add(lblTitleMock);
		}
		if (pagetype.equals("QUIZ")) {
			JLabel lblTitleQuiz = new JLabel("일일시험");
			pNorth.add(lblTitleQuiz);
		}
		pCenter.setLayout(new BorderLayout(0, 0));
		pCenter.add(lblInfo);
		JButton btnTestStart = new JButton("시험시작");
		pSouth.add(btnTestStart);
		btnTestStart.addActionListener(e -> {
			ArrayList<QuestionDTO> questions = Main.dao.getQuestionDataWithSubject(Main.subject);
			Collections.shuffle(questions);
			if (pagetype.equals("QUIZ")) {
				ArrayList<QuestionDTO> quizzes = new ArrayList<QuestionDTO>();
				HashSet<String> categories = new HashSet<String>();
				for (QuestionDTO question : questions) {
					categories.add(question.getCategory());
				}
				for (String category : categories) {
					int i = 0;
					ArrayList<QuestionDTO> temp = new ArrayList<QuestionDTO>();
					for (QuestionDTO question : questions) {
						if(question.getCategory().equals(category)) {
							temp.add(question);
							i++;
						}
						if(i>=2) {
							Collections.shuffle(temp);
							quizzes.addAll(temp);
							break;}
					}
				}
				Main.goToPage(new QuestionsPage("QUIZ", new int[questions.size()], quizzes));
			} else {
				Main.goToPage(new QuestionsPage("MOCK", new int[questions.size()], questions));
			}
		});
		revalidate();
	}
}
