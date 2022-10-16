package ui.test;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import dto.QuestionDTO;
import dto.RecordDTO;
import ui.Main;
import ui.MenuPage;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class ResultPage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<QuestionDTO> questions;
	ArrayList<RecordDTO> records;

	public ResultPage(ArrayList<RecordDTO> records, ArrayList<QuestionDTO> questions) {
		this.records = records;
		this.questions = questions;
		setSize(500, 500);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel pCenter = new JPanel();
		pCenter.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(new GridLayout(3, 3, 0, 0));

		JLabel lblSubject = new JLabel(Main.subject.toString());
		lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSubject.setFont(new Font("굴림", Font.PLAIN, 15));
		pCenter.add(lblSubject);

		JLabel lblTimeTaken = new JLabel(records.get(0).getTest().getTakeTime() / 60 + "분");
		lblTimeTaken.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeTaken.setFont(new Font("굴림", Font.PLAIN, 15));
		pCenter.add(lblTimeTaken);

		JLabel lblScoreResult = new JLabel(records.get(0).getTest().getScore() + "/" + questions.size());
		lblScoreResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblScoreResult.setFont(new Font("굴림", Font.PLAIN, 15));
		pCenter.add(lblScoreResult);

		JPanel pNorth = new JPanel();
		add(pNorth, BorderLayout.NORTH);

		JLabel lblResult = new JLabel("시험 결과");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setFont(new Font("굴림", Font.BOLD, 20));
		pNorth.add(lblResult);

		JPanel pSouth = new JPanel();
		add(pSouth, BorderLayout.SOUTH);

		JButton btnViewExplain = new JButton("해설보기");
		pSouth.add(btnViewExplain);
		btnViewExplain.addActionListener(e -> {
			int[] answers = new int[records.size()];
			for (int i = 0; i < records.size(); i++) {
				answers[i] = records.get(i).getAnswer();
			}
			Main.goToPage(new QuestionsPage("EXPLAIN", answers, questions));
		});

		JButton btnExit = new JButton("종료");
		pSouth.add(btnExit);
		btnExit.addActionListener(e -> {
			Main.subject = null;
			Main.goToPage(new MenuPage());
		});
	}
}
