package ui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ui.login.LoginPage;
import ui.mypage.MyPageMainPage;
import ui.test.SelectionPage;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class MenuPage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MenuPage() {
		// 새 패널
		setSize(400, 500);
		setLayout(new BorderLayout(0, 0));

		// North 패널 생성
		JPanel pNorth = new JPanel();
		add(pNorth, BorderLayout.NORTH);
		JLabel lblTitle = new JLabel("CBT Program");
		pNorth.add(lblTitle);

		// Center 패널 생성
		JPanel pCenter = new JPanel();
		add(pCenter, BorderLayout.CENTER);
		// South 패널 생성
		JPanel pSouth = new JPanel();
		add(pSouth, BorderLayout.SOUTH);

		// 버튼 메뉴 패널
		JPanel pMenu = new JPanel();
		pMenu.setBorder(new EmptyBorder(100, 0, 100, 0));
		pCenter.add(pMenu);
		pMenu.setLayout(new GridLayout(3, 1, 20, 20));

		// 메뉴 버튼들 생성
		JButton btnQuiz = new JButton("일일시험");
		pMenu.add(btnQuiz);
		btnQuiz.addActionListener(e -> {
			Main.goToPage(new SelectionPage("QUIZ"));
		});
		JButton btnMock = new JButton("모의고사");
		pMenu.add(btnMock);
		btnMock.addActionListener(e -> {
			Main.goToPage(new SelectionPage("MOCK"));
		});
		JButton btnMyPage = new JButton("마이페이지");
		pMenu.add(btnMyPage);
		btnMyPage.addActionListener(e -> {
			Main.goToPage(new MyPageMainPage());
		});
		JButton btnLogout = new JButton("로그아웃");
		pMenu.add(btnLogout);
		btnLogout.addActionListener(e -> {
			Main.student = null;
			Main.goToPage(new LoginPage());
		});
		revalidate();
	}
}
