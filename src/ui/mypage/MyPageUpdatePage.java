package ui.mypage;

import java.awt.Color;

import java.awt.GridBagLayout;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ui.Main;
import util.RegularExpressionChecker;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.util.HashMap;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class MyPageUpdatePage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyPageUpdatePage() {

		setSize(400, 500);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel pNorth = new JPanel();
		add(pNorth, BorderLayout.NORTH);
		pNorth.setBorder(new LineBorder(new Color(0, 0, 0)));
		pNorth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel main = new JLabel("회원정보 변경");
		main.setFont(new Font("굴림", Font.BOLD, 20));
		pNorth.add(main);

		JPanel pCentre = new JPanel();
		add(pCentre);
		pCentre.setBorder(new LineBorder(new Color(0, 0, 0)));

		GridBagLayout gbl_pCentre = new GridBagLayout();
		gbl_pCentre.columnWidths = new int[] { 30, 100, 200, 30 };
		gbl_pCentre.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 30 };
		gbl_pCentre.columnWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_pCentre.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		pCentre.setLayout(gbl_pCentre);

		JLabel label1 = new JLabel("비밀번호  ");
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		label1.setFont(new Font("굴림", Font.PLAIN, 15));
		GridBagConstraints label1c = new GridBagConstraints();
		label1c.anchor = GridBagConstraints.WEST;
		label1c.insets = new Insets(0, 0, 5, 5);
		label1c.gridx = 1;
		label1c.gridy = 0;
		pCentre.add(label1, label1c);

		JPasswordField pwd = new JPasswordField();
		GridBagConstraints pwdc = new GridBagConstraints();
		pwdc.fill = GridBagConstraints.HORIZONTAL;
		pwdc.insets = new Insets(0, 0, 5, 0);
		pwdc.gridx = 2;
		pwdc.gridy = 0;
		pCentre.add(pwd, pwdc);
		pwd.setColumns(10);

		JLabel label2 = new JLabel("비밀번호 확인  ");
		label2.setFont(new Font("굴림", Font.PLAIN, 15));
		GridBagConstraints label2c = new GridBagConstraints();
		label2c.anchor = GridBagConstraints.WEST;
		label2c.insets = new Insets(0, 0, 5, 5);
		label2c.gridx = 1;
		label2c.gridy = 1;
		pCentre.add(label2, label2c);

		JPasswordField repwd = new JPasswordField();
		GridBagConstraints repwdc = new GridBagConstraints();
		repwdc.insets = new Insets(0, 0, 5, 0);
		repwdc.fill = GridBagConstraints.HORIZONTAL;
		repwdc.gridx = 2;
		repwdc.gridy = 1;
		pCentre.add(repwd, repwdc);
		repwd.setColumns(10);

		JLabel lblNewLabel = new JLabel("영문, 숫자, 특수기호 조합 (8~20 자리)");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		pCentre.add(lblNewLabel, gbc_lblNewLabel);

		JLabel label3 = new JLabel("전화번호 ");
		label3.setFont(new Font("굴림", Font.PLAIN, 15));
		GridBagConstraints label3c = new GridBagConstraints();
		label3c.anchor = GridBagConstraints.WEST;
		label3c.insets = new Insets(5, 0, 5, 5);
		label3c.gridx = 1;
		label3c.gridy = 3;
		pCentre.add(label3, label3c);

		JTextField mobile = new JTextField();
		GridBagConstraints mobilec = new GridBagConstraints();
		mobilec.insets = new Insets(5, 0, 5, 0);
		mobilec.fill = GridBagConstraints.HORIZONTAL;
		mobilec.gridx = 2;
		mobilec.gridy = 3;
		pCentre.add(mobile, mobilec);
		mobile.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("(-)없이 입력");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 4;
		pCentre.add(lblNewLabel_1, gbc_lblNewLabel_1);

		JLabel label4 = new JLabel("이메일 ");
		label4.setFont(new Font("굴림", Font.PLAIN, 15));
		GridBagConstraints label4c = new GridBagConstraints();
		label4c.anchor = GridBagConstraints.WEST;
		label4c.insets = new Insets(5, 0, 5, 5);
		label4c.gridx = 1;
		label4c.gridy = 5;
		pCentre.add(label4, label4c);

		JTextField email = new JTextField();
		GridBagConstraints emailc = new GridBagConstraints();
		emailc.insets = new Insets(5, 0, 5, 0);
		emailc.fill = GridBagConstraints.HORIZONTAL;
		emailc.gridx = 2;
		emailc.gridy = 5;
		pCentre.add(email, emailc);
		email.setColumns(10);

		JLabel label5 = new JLabel("주소 ");
		label5.setFont(new Font("굴림", Font.PLAIN, 15));
		GridBagConstraints label5c = new GridBagConstraints();
		label5c.anchor = GridBagConstraints.WEST;
		label5c.insets = new Insets(5, 0, 5, 5);
		label5c.gridx = 1;
		label5c.gridy = 6;
		pCentre.add(label5, label5c);

		JTextArea addr = new JTextArea();
		GridBagConstraints addrc = new GridBagConstraints();
		addrc.insets = new Insets(5, 0, 5, 0);
		addrc.fill = GridBagConstraints.BOTH;
		addrc.gridx = 2;
		addrc.gridy = 6;
		addrc.gridheight = 2;
		pCentre.add(addr, addrc);
		addr.setColumns(10);

		JPanel pSouth = new JPanel();
		add(pSouth, BorderLayout.SOUTH);

		JButton save = new JButton("저장");
		pSouth.add(save);
		save.addActionListener(e -> {
			HashMap<String, String> tempMap = new HashMap<String, String>();
			tempMap.put("pwd", String.valueOf(pwd.getPassword()).trim());
			String pwdre = String.valueOf(repwd.getPassword()).trim();
			tempMap.put("phone", mobile.getText().trim());
			tempMap.put("email", email.getText().trim());
			tempMap.put("address", addr.getText().trim());
			for (String key : tempMap.keySet()) {
				String value = tempMap.get(key);
				if (value == null) {
					JOptionPane.showMessageDialog(null, "모든 정보를 입력해주시길 바랍니다.", "비밀번호 입력 오류",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			RegularExpressionChecker chk = new RegularExpressionChecker();
			if (!pwdre.equals(tempMap.get("pwd"))) {
				JOptionPane.showMessageDialog(null, "입력하신 비밀번호가 일치하지 않습니다.", "비밀번호 입력 오류", JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (!chk.mobileCheck(tempMap.get("phone"))) {
				JOptionPane.showMessageDialog(null, "(-)없이 숫자만 입력가능합니다.", "전화번호 입력 오류",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			if (!chk.emailCheck(tempMap.get("email"))) { // 전화
				JOptionPane.showMessageDialog(null, "형식에 맞지않는 입력입니다.", "이메일 입력 오류",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			StringBuilder setSql = new StringBuilder();
			tempMap.forEach((key, value)->{
				setSql.append(key + "=" + "'"+value+"'");
				setSql.append(",");
			});
			setSql.setLength(setSql.length()-1);
			Main.dao.updateStudentData(Main.student,setSql.toString());
			JOptionPane.showMessageDialog(null, "정보가 변경되었습니다.", "정보 변경",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		});

		JButton back = new JButton("이전");
		pSouth.add(back);
		back.addActionListener(e->{ Main.frame.setContentPane(Main.history.pop()); });
	}
}
