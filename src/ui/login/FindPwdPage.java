package ui.login;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import dto.StudentDTO;
import ui.Main;
import util.Encrypter;
import util.RegularExpressionChecker;

import java.awt.FlowLayout;

public class FindPwdPage extends JPanel {

	private static final long serialVersionUID = 1L;

	StudentDTO tempStudent;
	boolean isPwdNotFound;

	FindPwdPage() {
		draw(true);
	}

	public void draw(boolean isPwdNotFound) {
		this.isPwdNotFound = isPwdNotFound;
		setSize(300, 500);
		setLayout(new BorderLayout(0, 0));

		JPanel pTop = new JPanel();
		add(pTop, BorderLayout.NORTH);
		pTop.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblTitle = new JLabel("비밀번호 찾기");
		pTop.add(lblTitle);

		JPanel pCenter = new JPanel();
		add(pCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pCenter = new GridBagLayout();
		gbl_pCenter.columnWidths = new int[] { 300 };
		gbl_pCenter.rowHeights = new int[] { 100 };
		gbl_pCenter.columnWeights = new double[] { 1.0 };
		gbl_pCenter.rowWeights = new double[] { 0.0 };
		pCenter.setLayout(gbl_pCenter);

		JPanel pCenter_inner = new JPanel();
		GridBagConstraints gbc_pCenter_inner = new GridBagConstraints();
		gbc_pCenter_inner.insets = new Insets(10, 10, 10, 10);
		gbc_pCenter_inner.gridwidth = 0;
		gbc_pCenter_inner.gridheight = 0;
		gbc_pCenter_inner.weighty = 1.0;
		gbc_pCenter_inner.weightx = 1.0;
		gbc_pCenter_inner.gridx = 0;
		gbc_pCenter_inner.gridy = 0;
		pCenter.add(pCenter_inner, gbc_pCenter_inner);
		pCenter_inner.setLayout(new BoxLayout(pCenter_inner, BoxLayout.Y_AXIS));

		JPanel pExplain = new JPanel();
		pExplain.setBorder(new EmptyBorder(10, 10, 0, 10));
		pCenter_inner.add(pExplain);

		JLabel lblExplainFindPwd = new JLabel("찾으실 아이디의 정보를 입력하세요.");
		pExplain.add(lblExplainFindPwd);
		lblExplainFindPwd.setVisible(isPwdNotFound);

		JLabel lblExplainResetPwd = new JLabel("비밀번호를 재설정 하시길 바랍니다.");
		pExplain.add(lblExplainResetPwd);
		lblExplainResetPwd.setVisible(!isPwdNotFound);

		JPanel pFindPwd = new JPanel();
		pFindPwd.setVisible(false);
		pFindPwd.setBorder(new EmptyBorder(10, 30, 20, 30));
		pCenter_inner.add(pFindPwd);
		GridBagLayout gbl_pFindPwd = new GridBagLayout();
		gbl_pFindPwd.columnWidths = new int[] { 30, 100 };
		gbl_pFindPwd.rowHeights = new int[] { 30, 30, 30, 30 };
		gbl_pFindPwd.columnWeights = new double[] { 1.0 };
		gbl_pFindPwd.rowWeights = new double[] { 1.0, 1.0 };
		pFindPwd.setLayout(gbl_pFindPwd);
		pFindPwd.setVisible(isPwdNotFound);

		JTextField tfEmail = new JTextField();
		GridBagConstraints gbc_lbltfEmail = new GridBagConstraints();
		gbc_lbltfEmail.insets = new Insets(2, 0, 5, 0);
		gbc_lbltfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbltfEmail.anchor = GridBagConstraints.NORTH;
		gbc_lbltfEmail.gridheight = 0;
		gbc_lbltfEmail.gridwidth = 0;
		gbc_lbltfEmail.weighty = 1.0;
		gbc_lbltfEmail.weightx = 1.0;
		gbc_lbltfEmail.gridx = 1;
		gbc_lbltfEmail.gridy = 3;
		pFindPwd.add(tfEmail, gbc_lbltfEmail);

		JLabel lblName = new JLabel("이름 :");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 1;
		pFindPwd.add(lblName, gbc_lblName);

		JLabel lblBirthday = new JLabel("생년월일:");
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.anchor = GridBagConstraints.EAST;
		gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthday.gridx = 0;
		gbc_lblBirthday.gridy = 2;
		pFindPwd.add(lblBirthday, gbc_lblBirthday);

		JTextField tfName = new JTextField();
		GridBagConstraints gbc_lbltfName = new GridBagConstraints();
		gbc_lbltfName.insets = new Insets(2, 0, 5, 0);
		gbc_lbltfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbltfName.anchor = GridBagConstraints.NORTH;
		gbc_lbltfName.weighty = 1.0;
		gbc_lbltfName.weightx = 1.0;
		gbc_lbltfName.gridx = 1;
		gbc_lbltfName.gridy = 1;
		pFindPwd.add(tfName, gbc_lbltfName);

		JTextField tfBirthday = new JTextField();
		GridBagConstraints gbc_tfBirthday = new GridBagConstraints();
		gbc_tfBirthday.insets = new Insets(2, 0, 5, 0);
		gbc_tfBirthday.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfBirthday.anchor = GridBagConstraints.NORTH;
		gbc_tfBirthday.weighty = 1.0;
		gbc_tfBirthday.weightx = 1.0;
		gbc_tfBirthday.gridx = 1;
		gbc_tfBirthday.gridy = 2;
		pFindPwd.add(tfBirthday, gbc_tfBirthday);

		JLabel lblEmail = new JLabel("Email :");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 3;
		pFindPwd.add(lblEmail, gbc_lblEmail);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 2;

		JLabel lblID = new JLabel("ID :");
		lblID.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.anchor = GridBagConstraints.EAST;
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 0;
		pFindPwd.add(lblID, gbc_lblID);

		JTextField tfID = new JTextField();
		GridBagConstraints gbc_lbltfID = new GridBagConstraints();
		gbc_lbltfID.insets = new Insets(2, 0, 5, 0);
		gbc_lbltfID.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbltfID.anchor = GridBagConstraints.NORTH;
		gbc_lbltfID.weighty = 1.0;
		gbc_lbltfID.weightx = 1.0;
		gbc_lbltfID.gridx = 1;
		gbc_lbltfID.gridy = 0;
		pFindPwd.add(tfID, gbc_lbltfID);

		JPanel pResetPwd = new JPanel();
		pResetPwd.setBorder(new EmptyBorder(10, 30, 20, 30));
		pCenter_inner.add(pResetPwd);
		GridBagLayout gbl_pResetPwd = new GridBagLayout();
		gbl_pResetPwd.columnWidths = new int[] { 30, 100 };
		gbl_pResetPwd.rowHeights = new int[] { 30, 30, 30 };
		gbl_pResetPwd.columnWeights = new double[] { 1.0, 0.0 };
		gbl_pResetPwd.rowWeights = new double[] { 1.0, 1.0, 0.0 };
		pResetPwd.setLayout(gbl_pResetPwd);
		pResetPwd.setVisible(!isPwdNotFound);

		JLabel lblPwd = new JLabel("비밀번호 :");
		lblPwd.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblPwd = new GridBagConstraints();
		gbc_lblPwd.anchor = GridBagConstraints.EAST;
		gbc_lblPwd.insets = new Insets(0, 0, 5, 5);
		gbc_lblPwd.gridx = 0;
		gbc_lblPwd.gridy = 0;
		pResetPwd.add(lblPwd, gbc_lblPwd);
		JPasswordField tfPwd = new JPasswordField();
		GridBagConstraints gbc_tfPwd = new GridBagConstraints();
		gbc_tfPwd.weighty = 1.0;
		gbc_tfPwd.weightx = 1.0;
		gbc_tfPwd.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPwd.anchor = GridBagConstraints.NORTH;
		gbc_tfPwd.insets = new Insets(2, 0, 5, 0);
		gbc_tfPwd.gridx = 1;
		gbc_tfPwd.gridy = 0;
		pResetPwd.add(tfPwd, gbc_tfPwd);
		JLabel lblPwdStd = new JLabel("영문, 숫자, 특수기호 조합 (7~20 자리)");
		GridBagConstraints gbc_lblPwdStd = new GridBagConstraints();
		gbc_lblPwdStd.gridwidth = 2;
		gbc_lblPwdStd.anchor = GridBagConstraints.EAST;
		gbc_lblPwdStd.insets = new Insets(0, 0, 5, 0);
		gbc_lblPwdStd.gridx = 0;
		gbc_lblPwdStd.gridy = 2;
		pResetPwd.add(lblPwdStd, gbc_lblPwdStd);

		JPasswordField tfPwdChk = new JPasswordField();
		GridBagConstraints gbc_tfPwdChk = new GridBagConstraints();
		gbc_tfPwdChk.weighty = 1.0;
		gbc_tfPwdChk.weightx = 1.0;
		gbc_tfPwdChk.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPwdChk.anchor = GridBagConstraints.NORTH;
		gbc_tfPwdChk.insets = new Insets(2, 0, 5, 0);
		gbc_tfPwdChk.gridx = 1;
		gbc_tfPwdChk.gridy = 1;
		pResetPwd.add(tfPwdChk, gbc_tfPwdChk);
		JLabel lblPwdChk = new JLabel("비밀번호 확인 :");
		GridBagConstraints gbc_lblPwdChk = new GridBagConstraints();
		gbc_lblPwdChk.anchor = GridBagConstraints.EAST;
		gbc_lblPwdChk.insets = new Insets(0, 0, 0, 5);
		gbc_lblPwdChk.gridx = 0;
		gbc_lblPwdChk.gridy = 1;
		pResetPwd.add(lblPwdChk, gbc_lblPwdChk);

		JPanel pSouth = new JPanel();
		pSouth.setBorder(new EmptyBorder(10, 10, 10, 10));
		pSouth.setAlignmentY(0.0f);
		pSouth.setAlignmentX(0.0f);
		add(pSouth, BorderLayout.SOUTH);

		JButton btnBack = new JButton("이전");
		JButton btnFind = new JButton("찾기");
		JButton btnReset = new JButton("재설정");

		pSouth.add(btnBack);
		pSouth.add(btnFind);
		pSouth.add(btnReset);
		btnFind.setVisible(isPwdNotFound);
		btnReset.setVisible(!isPwdNotFound);

		/* 리스너 등록 */
		
		btnBack.addActionListener(e -> {
			Main.frame.setContentPane(Main.history.pop());
		});
		
		btnFind.addActionListener(e -> {
			String arr[] = new String[] { tfID.getText().trim(), tfName.getText().trim(), tfBirthday.getText().trim(),
					tfEmail.getText().trim() };
			for (String value : arr) {
				if (value.equals("")) {
					JOptionPane.showMessageDialog(null, "모든 정보를 입력해주시길 바랍니다.", "찾기 오류", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			String pwd = Main.dao.findUserPwd(arr[0], arr[1], arr[2], arr[3]);
			if (pwd == null) {
				JOptionPane.showConfirmDialog(null, "입력하신 정보가 잘못되었습니다.", "아이디 찾기 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			try {
				tempStudent = Main.dao.selectStudentData(arr[0], pwd);
			} catch (NullPointerException e2) {
				JOptionPane.showMessageDialog(null, "일치하는 정보가 없습니다.", "찾기 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			removeAll();
			draw(false);
		});
	
		btnReset.addActionListener(e -> {
			Encrypter en = new Encrypter();
			RegularExpressionChecker chk = new RegularExpressionChecker();
			String arr[] = new String[] { String.valueOf(tfPwd.getPassword()).trim(),
					String.valueOf(tfPwdChk.getPassword()).trim() };

			if (arr[0].equals("") || arr[1].equals("")) {
				JOptionPane.showMessageDialog(null, "모든 정보를 입력해주시길 바랍니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}

			if (!arr[0].equals(arr[1])) {
				JOptionPane.showMessageDialog(null, "확인 비밀번호가 일치하지 않습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (!chk.pwdCheck(arr[0])) {
				JOptionPane.showMessageDialog(null, "비밀번호 형식이 맞지 않습니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			tempStudent.setPwd(en.pwdEncrypt(arr[0]));
			try {
				Main.dao.updateStudentData(tempStudent);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "재설정 오류입니다. 다시 시도해주세요.", "찾기 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			JOptionPane.showMessageDialog(null, "비밀번호가 재설정 되었습니다.", "찾기 오류", JOptionPane.WARNING_MESSAGE);
			Main.goToPage(new LoginPage());
		});
	}
}
