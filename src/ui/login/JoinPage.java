package ui.login;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.util.HashMap;

import javax.swing.border.LineBorder;

import dto.StudentDTO;
import ui.Main;
import util.Encrypter;
import util.RegularExpressionChecker;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

import java.awt.FlowLayout;

public class JoinPage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JoinPage() {

		setSize(500, 500);
		setLayout(new BorderLayout(0, 0));

		/* 패널 공간 정의 */

		JPanel pNorth = new JPanel();
		pNorth.setBorder(new LineBorder(new Color(0, 0, 0)));
		pNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JPanel pCenter = new JPanel();
		pCenter.setBorder(new EmptyBorder(0, 0, 0, 0));
		GridBagLayout gbl_pCenter = new GridBagLayout();
		gbl_pCenter.columnWidths = new int[] { 30, 100, 10, 10, 10, 10, 30, 30 };
		gbl_pCenter.rowHeights = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 30, 5 };
		gbl_pCenter.columnWeights = new double[] { 0.0, 1.0, 1.0 };
		gbl_pCenter.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		pCenter.setLayout(gbl_pCenter);
		JPanel pSouth = new JPanel();

		/* 패널별 컴포넌트 설정 */

		// pNorth //

		// Title
		JLabel lblTitle = new JLabel("회원가입");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));

		// pCenter //

		// ID
		JLabel lblID = new JLabel("아이디 : ");
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.fill = GridBagConstraints.BOTH;
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.gridx = 1;
		gbc_lblID.gridy = 0;
		JTextField tfID = new JTextField();
		GridBagConstraints gbc_tfID = new GridBagConstraints();
		gbc_tfID.fill = GridBagConstraints.BOTH;
		gbc_tfID.insets = new Insets(0, 0, 5, 5);
		gbc_tfID.gridx = 2;
		gbc_tfID.gridy = 0;
		gbc_tfID.gridwidth = 4;
		tfID.setColumns(20);
		JButton btnCheckID = new JButton("중복확인");
		GridBagConstraints gbc_btnCheckID = new GridBagConstraints();
		gbc_btnCheckID.fill = GridBagConstraints.VERTICAL;
		gbc_btnCheckID.insets = new Insets(0, 0, 5, 5);
		gbc_btnCheckID.gridx = 6;
		gbc_btnCheckID.gridy = 0;
		JLabel lblIDExp = new JLabel("영문, 숫자 조합 (5~16 자리)");
		lblIDExp.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblIDExp = new GridBagConstraints();
		gbc_lblIDExp.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblIDExp.gridwidth = 5;
		gbc_lblIDExp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIDExp.gridx = 2;
		gbc_lblIDExp.gridy = 1;

		// 비밀번호
		JLabel lblPwd = new JLabel("비밀번호 : ");
		GridBagConstraints gbc_lblPwd = new GridBagConstraints();
		gbc_lblPwd.fill = GridBagConstraints.BOTH;
		gbc_lblPwd.insets = new Insets(5, 0, 5, 5);
		gbc_lblPwd.gridx = 1;
		gbc_lblPwd.gridy = 2;
		JPasswordField tfPwd = new JPasswordField();
		GridBagConstraints gbc_tfPwd = new GridBagConstraints();
		gbc_tfPwd.fill = GridBagConstraints.BOTH;
		gbc_tfPwd.insets = new Insets(5, 0, 5, 5);
		gbc_tfPwd.gridx = 2;
		gbc_tfPwd.gridy = 2;
		gbc_tfPwd.gridwidth = 4;
		tfPwd.setColumns(20);
		JLabel lblPwdChk = new JLabel("비밀번호 확인 : ");
		GridBagConstraints gbc_lblPwdChk = new GridBagConstraints();
		gbc_lblPwdChk.fill = GridBagConstraints.BOTH;
		gbc_lblPwdChk.insets = new Insets(0, 0, 5, 5);
		gbc_lblPwdChk.gridx = 1;
		gbc_lblPwdChk.gridy = 3;
		JPasswordField tfPwdChk = new JPasswordField();
		GridBagConstraints gbc_tfPwdChk = new GridBagConstraints();
		gbc_tfPwdChk.fill = GridBagConstraints.BOTH;
		gbc_tfPwdChk.insets = new Insets(0, 0, 5, 5);
		gbc_tfPwdChk.gridx = 2;
		gbc_tfPwdChk.gridy = 3;
		gbc_tfPwdChk.gridwidth = 4;
		tfPwdChk.setColumns(20);
		JLabel lblPwdExp = new JLabel("영문, 숫자, 특수기호 조합 (7~20 자리)");
		GridBagConstraints gbc_lblPwdExp = new GridBagConstraints();
		gbc_lblPwdExp.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPwdExp.gridwidth = 5;
		gbc_lblPwdExp.insets = new Insets(0, 0, 5, 5);
		gbc_lblPwdExp.gridx = 2;
		gbc_lblPwdExp.gridy = 4;

		// 이름
		JLabel lblName = new JLabel("이름 :");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblName.insets = new Insets(5, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 5;
		JTextField tfName = new JTextField();
		GridBagConstraints gbc_tfName = new GridBagConstraints();
		gbc_tfName.insets = new Insets(5, 0, 5, 5);
		gbc_tfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfName.gridx = 2;
		gbc_tfName.gridy = 5;
		gbc_tfName.gridwidth = 4;
		tfName.setColumns(10);

		// 생년월일
		JLabel lblBirth = new JLabel("생년월일 : ");
		GridBagConstraints gbc_lblBirth = new GridBagConstraints();
		gbc_lblBirth.fill = GridBagConstraints.BOTH;
		gbc_lblBirth.insets = new Insets(5, 0, 5, 5);
		gbc_lblBirth.gridx = 1;
		gbc_lblBirth.gridy = 6;
		JTextField tfBirth = new JTextField();
		GridBagConstraints gbc_tfBirth = new GridBagConstraints();
		gbc_tfBirth.fill = GridBagConstraints.BOTH;
		gbc_tfBirth.insets = new Insets(5, 0, 5, 5);
		gbc_tfBirth.gridx = 2;
		gbc_tfBirth.gridy = 6;
		gbc_tfBirth.gridwidth = 4;
		tfBirth.setColumns(20);
		JLabel lblBirthExp = new JLabel("YYYYMMDD");
		lblBirthExp.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblBirthExp = new GridBagConstraints();
		gbc_lblBirthExp.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblBirthExp.gridwidth = 5;
		gbc_lblBirthExp.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthExp.gridx = 2;
		gbc_lblBirthExp.gridy = 7;

		JLabel lblPhone = new JLabel("핸드폰  :");
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.fill = GridBagConstraints.BOTH;
		gbc_lblPhone.insets = new Insets(5, 0, 5, 5);
		gbc_lblPhone.gridx = 1;
		gbc_lblPhone.gridy = 8;
		JTextField tfPhone = new JTextField();
		GridBagConstraints gbc_tfPhone = new GridBagConstraints();
		gbc_tfPhone.fill = GridBagConstraints.BOTH;
		gbc_tfPhone.insets = new Insets(5, 0, 5, 5);
		gbc_tfPhone.gridx = 2;
		gbc_tfPhone.gridy = 8;
		gbc_tfPhone.gridwidth = 4;
		tfPhone.setColumns(20);
		JLabel lblPhoneExp = new JLabel("(-)없이 입력.");
		GridBagConstraints gbc_lblPhoneExp = new GridBagConstraints();
		gbc_lblPhoneExp.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblPhoneExp.gridwidth = 5;
		gbc_lblPhoneExp.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhoneExp.gridx = 2;
		gbc_lblPhoneExp.gridy = 9;

		JLabel lblEmail = new JLabel("이메일 : ");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblEmail.anchor = GridBagConstraints.SOUTH;
		gbc_lblEmail.insets = new Insets(5, 0, 5, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 10;
		JTextField tfEmail = new JTextField();
		GridBagConstraints gbc_tfEmail = new GridBagConstraints();
		gbc_tfEmail.fill = GridBagConstraints.BOTH;
		gbc_tfEmail.insets = new Insets(5, 0, 5, 5);
		gbc_tfEmail.gridx = 2;
		gbc_tfEmail.gridy = 10;
		gbc_tfEmail.gridwidth = 4;
		tfEmail.setColumns(20);

		JLabel lblAddress = new JLabel("주소 : ");
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.fill = GridBagConstraints.BOTH;
		gbc_lblAddress.insets = new Insets(5, 0, 5, 5);
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 11;
		JTextArea tfAddress = new JTextArea();
		GridBagConstraints gbc_tfAddress = new GridBagConstraints();
		gbc_tfAddress.fill = GridBagConstraints.BOTH;
		gbc_tfAddress.insets = new Insets(5, 0, 5, 5);
		gbc_tfAddress.gridx = 2;
		gbc_tfAddress.gridy = 11;
		gbc_tfAddress.gridwidth = 4;
		gbc_tfAddress.gridheight = 2;
		tfAddress.setColumns(20);

		JLabel lblPrivacy = new JLabel("개인정보 보관기간 : ");
		GridBagConstraints gbc_lblPrivacy = new GridBagConstraints();
		gbc_lblPrivacy.fill = GridBagConstraints.BOTH;
		gbc_lblPrivacy.insets = new Insets(5, 0, 0, 5);
		gbc_lblPrivacy.gridx = 1;
		gbc_lblPrivacy.gridy = 13;
		JRadioButton rd0 = new JRadioButton("탈퇴시");
		rd0.setMnemonic('0');
		rd0.setHorizontalAlignment(SwingConstants.TRAILING);
		GridBagConstraints rd0c = new GridBagConstraints();
		rd0c.anchor = GridBagConstraints.WEST;
		rd0c.insets = new Insets(5, 0, 0, 5);
		rd0c.gridx = 2;
		rd0c.gridy = 13;
		JRadioButton rd1 = new JRadioButton("1년");
		rd1.setMnemonic('1');
		GridBagConstraints rd1c = new GridBagConstraints();
		rd1c.gridx = 3;
		rd1c.gridy = 13;
		rd1c.insets = rd0c.insets;
		JRadioButton rd2 = new JRadioButton("2년");
		rd2.setMnemonic('2');
		GridBagConstraints rd2c = new GridBagConstraints();
		rd2c.gridx = 4;
		rd2c.gridy = 13;
		rd2c.insets = rd0c.insets;
		JRadioButton rd3 = new JRadioButton("3년");
		rd3.setMnemonic('3');
		GridBagConstraints rd3c = new GridBagConstraints();
		rd3c.gridx = 5;
		rd3c.gridy = 13;
		rd3c.insets = rd0c.insets;
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rd0);
		btnGroup.add(rd1);
		btnGroup.add(rd2);
		btnGroup.add(rd3);

		// pSouth //
		JButton btnPrevious = new JButton("이전");
		JButton btnJoin = new JButton("회원가입");

		// 컴포넌트 붙이기
		add(pNorth, BorderLayout.NORTH);
		add(pCenter, BorderLayout.CENTER);
		add(pSouth, BorderLayout.SOUTH);

		pNorth.add(lblTitle);

		pCenter.add(lblID, gbc_lblID);
		pCenter.add(lblIDExp, gbc_lblIDExp);
		pCenter.add(lblPwd, gbc_lblPwd);
		pCenter.add(lblPwdChk, gbc_lblPwdChk);
		pCenter.add(lblPwdExp, gbc_lblPwdExp);
		pCenter.add(lblName, gbc_lblName);
		pCenter.add(lblBirth, gbc_lblBirth);
		pCenter.add(lblPhone, gbc_lblPhone);
		pCenter.add(lblBirthExp, gbc_lblBirthExp);
		pCenter.add(lblPhoneExp, gbc_lblPhoneExp);
		pCenter.add(lblEmail, gbc_lblEmail);
		pCenter.add(lblAddress, gbc_lblAddress);
		pCenter.add(lblPrivacy, gbc_lblPrivacy);
		pCenter.add(rd0, rd0c);
		pCenter.add(rd1, rd1c);
		pCenter.add(rd2, rd2c);
		pCenter.add(rd3, rd3c);
		pCenter.add(btnCheckID, gbc_btnCheckID);
		pCenter.add(tfID, gbc_tfID);
		pCenter.add(tfPwd, gbc_tfPwd);
		pCenter.add(tfPwdChk, gbc_tfPwdChk);
		pCenter.add(tfName, gbc_tfName);
		pCenter.add(tfBirth, gbc_tfBirth);
		pCenter.add(tfPhone, gbc_tfPhone);
		pCenter.add(tfEmail, gbc_tfEmail);
		pCenter.add(tfAddress, gbc_tfAddress);

		pSouth.add(btnPrevious);
		pSouth.add(btnJoin);

		/* 리스너 등록 */

		// 아이디 중복 확인
		btnCheckID.addActionListener(e -> {
			RegularExpressionChecker checker = new RegularExpressionChecker();
			if (!checker.idCheck(tfID.getText().trim())) {
				JOptionPane.showMessageDialog(null, "아이디는 영문, 숫자 조합(5~16자).", "중복확인", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (Main.dao.IdCheck(tfID.getText().trim()) != null) {
				JOptionPane.showMessageDialog(null, "해당 아이디는 사용중입니다.", "중복확인", JOptionPane.WARNING_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null, tfID.getText() + "은(는) 사용가능합니다.", "중복확인", JOptionPane.WARNING_MESSAGE);
		});
		// 이전 페이지로 가기
		btnPrevious.addActionListener(e -> {
			Main.frame.setContentPane(Main.history.pop());
		});
		// 회원가입하기
		btnJoin.addActionListener(e -> {
			RegularExpressionChecker checker = new RegularExpressionChecker();
			Encrypter encrypter = new Encrypter();
			@SuppressWarnings("serial")
			HashMap<Component, String> tempMap = new HashMap<Component, String>() {
				{
					put(tfID, tfID.getText().trim());
					put(tfPwd, encrypter.pwdEncrypt(String.valueOf(tfPwd.getPassword()).trim()));
					put(tfPwdChk, encrypter.pwdEncrypt(String.valueOf(tfPwdChk.getPassword()).trim()));
					put(tfName, tfName.getText().trim());
					put(tfBirth, tfBirth.getText().trim());
					put(tfPhone, tfPhone.getText().trim());
					put(tfEmail, tfEmail.getText().trim());
					put(tfAddress, tfAddress.getText().trim());
				}
			};

			for (Component tf : tempMap.keySet()) {
				String value = tempMap.get(tf);
				if (value.equals("")) {
					JOptionPane.showMessageDialog(null, "모든 정보를 입력해주시길 바랍니다.", "회원가입 오류", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			if (!checker.idCheck(tempMap.get(tfID))) {
				JOptionPane.showMessageDialog(null, "아이디는 영문, 숫자 조합(5~16자).", "아이디 입력 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (Main.dao.IdCheck(tfID.getText().trim()) != null) {
				JOptionPane.showMessageDialog(null, "해당 아이디는 사용중입니다.", "중복확인", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (!tempMap.get(tfPwd).equals(tempMap.get(tfPwdChk))) {
				JOptionPane.showMessageDialog(null, "입력하신 비밀번호가 일치하지 않습니다.", "비밀번호 입력 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (!checker.pwdCheck(String.valueOf(tfPwd.getPassword()).trim())) {
				JOptionPane.showMessageDialog(null, "비밀번호는 영문, 숫자, 특수문자 조합(7~20자)입니다.", "비밀번호 오류",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			int disposedate = 0;
			if (rd0.isSelected()) disposedate = 0;
			if (rd1.isSelected()) disposedate = 1;
			if (rd2.isSelected()) disposedate = 2;
			if (rd3.isSelected()) disposedate = 3;
			
			StudentDTO stu = new StudentDTO();
			stu.setId(tempMap.get(tfID));
			stu.setPwd(tempMap.get(tfPwd));
			stu.setName(tempMap.get(tfName));
			stu.setBirthday(tempMap.get(tfBirth)); 
			stu.setPhone(tempMap.get(tfPhone));
			stu.setEmail(tempMap.get(tfEmail));
			stu.setAddress(tempMap.get(tfAddress));
			stu.setDisposeDate(disposedate);

			if (Main.dao.addUserData(stu) == 0) {
				JOptionPane.showMessageDialog(null, "회원가입도중 오류가 발생했습니다. \n 문의 부탁드립니다.", "회원가입 오류",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다. \n 로그인 이후 프로그램사용이 가능합니다.", "회원가입완료",
					JOptionPane.PLAIN_MESSAGE);
			Main.goToPage(new LoginPage());
		});
	}
}