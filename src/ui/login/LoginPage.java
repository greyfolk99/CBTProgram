package ui.login;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import dto.StudentDTO;
import ui.Main;
import ui.MenuPage;
import util.Encrypter;

public class LoginPage extends JPanel {

	private static final long serialVersionUID = 1L;

	public LoginPage() {

		/* 패널 설정 */

		// base
		setSize(300, 500);
		setLayout(new BorderLayout(0, 0));

		// North
		JPanel pNorth = new JPanel();
		pNorth.setBackground(Color.WHITE);
		pNorth.setBorder(new LineBorder(new Color(0, 0, 0)));
		pNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblTitle = new JLabel("CBT Program");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTitle.setBackground(Color.WHITE);

		// Center
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new BoxLayout(pCenter, BoxLayout.X_AXIS));
		JPanel pCenter_inner = new JPanel();
		pCenter_inner.setBackground(Color.WHITE);
		pCenter_inner.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		GridBagLayout gbl_pCenter_inner = new GridBagLayout();
		gbl_pCenter_inner.columnWidths = new int[] { 100 };
		gbl_pCenter_inner.rowHeights = new int[] { 20, 50, 20 };
		gbl_pCenter_inner.columnWeights = new double[] { 0.0 };
		gbl_pCenter_inner.rowWeights = new double[] { 0.0, 0.0, 0.0 };
		pCenter_inner.setLayout(gbl_pCenter_inner);

		JPanel pExplain = new JPanel();
		pExplain.setBackground(Color.WHITE);
		pExplain.setBorder(new EmptyBorder(10, 10, 0, 10));
		GridBagConstraints gbc_pExplain = new GridBagConstraints();
		gbc_pExplain.insets = new Insets(0, 0, 5, 0);
		gbc_pExplain.gridx = 0;
		gbc_pExplain.gridy = 0;
		pExplain.setLayout(new BoxLayout(pExplain, BoxLayout.Y_AXIS));
		JLabel lblExplain = new JLabel("로그인이 필요합니다.");
		lblExplain.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel pLogin = new JPanel();
		pLogin.setBackground(Color.WHITE);
		pLogin.setBorder(new EmptyBorder(10, 10, 10, 10));
		GridBagLayout gbl_pLogin = new GridBagLayout();
		gbl_pLogin.columnWidths = new int[] { 20, 100 };
		gbl_pLogin.rowHeights = new int[] { 40, 40 };
		gbl_pLogin.columnWeights = new double[] { 0.0, 1.0 };
		gbl_pLogin.rowWeights = new double[] { 0.0, 0.0 };
		GridBagConstraints gbc_pLogin = new GridBagConstraints();
		gbc_pLogin.insets = new Insets(0, 0, 5, 0);
		gbc_pLogin.gridx = 0;
		gbc_pLogin.gridy = 1;
		pLogin.setLayout(gbl_pLogin);
		JLabel lblID = new JLabel("아이디");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 0;
		JTextField tfID = new JTextField();
		tfID.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_tfID = new GridBagConstraints();
		gbc_tfID.insets = new Insets(0, 0, 5, 0);
		gbc_tfID.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfID.gridx = 1;
		gbc_tfID.gridy = 0;
		JLabel lblPwd = new JLabel("비밀번호");
		lblPwd.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblPwd = new GridBagConstraints();
		gbc_lblPwd.insets = new Insets(0, 0, 0, 12);
		gbc_lblPwd.gridx = 0;
		gbc_lblPwd.gridy = 1;
		JPasswordField tfPwd = new JPasswordField();
		tfPwd.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_tfPwd = new GridBagConstraints();
		gbc_tfPwd.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPwd.gridx = 1;
		gbc_tfPwd.gridy = 1;

		JPanel pButtons = new JPanel();
		pButtons.setBackground(Color.WHITE);
		pButtons.setAlignmentY(Component.TOP_ALIGNMENT);
		pButtons.setAlignmentX(Component.LEFT_ALIGNMENT);
		GridBagConstraints gbc_pButtons = new GridBagConstraints();
		gbc_pButtons.gridx = 0;
		gbc_pButtons.gridy = 2;
		pButtons.setLayout(new BoxLayout(pButtons, BoxLayout.X_AXIS));
		JButton btnLogin = new JButton("로그인");
		JButton btnJoin = new JButton("회원가입");

		// South
		JPanel pSouth = new JPanel();
		pSouth.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) pSouth.getLayout();
		flowLayout.setVgap(0);
		pSouth.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pSouth.setAlignmentY(0.0f);
		pSouth.setAlignmentX(0.0f);
		JButton btnFindID = new JButton("아이디 찾기");
		JButton btnFindPwd = new JButton("비밀번호 찾기");

		/* 패널 및 컴포넌트 추가 */
		add(pNorth, BorderLayout.NORTH);
		add(pCenter, BorderLayout.CENTER);
		add(pSouth, BorderLayout.SOUTH);

		pNorth.add(lblTitle);
		pCenter.add(pCenter_inner);
		pCenter_inner.add(pExplain, gbc_pExplain);
		pCenter_inner.add(pLogin, gbc_pLogin);
		pCenter_inner.add(pButtons, gbc_pButtons);
		pExplain.add(lblExplain);
		pLogin.add(tfPwd, gbc_tfPwd);
		pLogin.add(tfID, gbc_tfID);
		pLogin.add(lblPwd, gbc_lblPwd);
		pLogin.add(lblID, gbc_lblID);
		pButtons.add(btnLogin);
		pButtons.add(btnJoin);
		pSouth.add(btnFindID);
		pSouth.add(btnFindPwd);

		// 로그인
		btnLogin.addActionListener(e -> {
			Encrypter enc = new Encrypter();
			if (tfID.getText().trim().equals("")
					|| String.valueOf(tfPwd.getPassword()).trim().equals("")) {
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 입력하세요", "로그인 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (Main.dao.IdCheck(tfID.getText().trim()) == null) {
				JOptionPane.showMessageDialog(null, "입력하신 아이디는 없는 아이디 입니다.", "로그인 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			StudentDTO student = Main.dao.selectStudentData(tfID.getText().trim(),
					enc.pwdEncrypt(String.valueOf(tfPwd.getPassword()).trim()));
			if (student == null) {
				JOptionPane.showMessageDialog(null, "비밀번호가 틀렸습니다.", "로그인 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			Main.student = student;
			Main.subject=null;
			Main.goToPage(new MenuPage());
		});
		// 회원가입
		btnJoin.addActionListener(e->Main.goToPage(new JoinPage()));
		// 아이디찾기
		btnFindID.addActionListener(e->Main.goToPage(new FindIDPage()));
		// 비밀번호찾기
		btnFindPwd.addActionListener(e->Main.goToPage(new FindIDPage()));
	}
}
