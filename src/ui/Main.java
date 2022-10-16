package ui;

import java.awt.Container;
import java.util.Deque;
import java.util.LinkedList;
import dto.StudentDTO;
import dto.SubjectDTO;
import javax.swing.*;
import ui.login.LoginPage;
import dao.UserDAO;

public class Main {

	public static JFrame frame;

	public static UserDAO dao = new UserDAO();
	public static StudentDTO student;
	public static SubjectDTO subject;

	public static Deque<Container> history;

	public Main() {
		frame = new JFrame("CBT Program");
		history = new LinkedList<Container>();

		frame.setSize(1000, 700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// 시작페이지(로그인)
		goToPage(new LoginPage());
	}

	public static void goToPage(Container c) {
		history.push(frame.getContentPane());
		if (history.size()>30) history.removeFirst();
		frame.setContentPane(c);
		frame.setResizable(true);
		frame.revalidate();
	}
}