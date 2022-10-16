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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import ui.Main;

import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;

public class FindIDPage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FindIDPage() {

		setSize(400, 500);
		setLayout(new BorderLayout(0, 0));

		JPanel pTop = new JPanel();
		add(pTop, BorderLayout.NORTH);
		FlowLayout fl_pTop = new FlowLayout(FlowLayout.CENTER, 10, 10);
		pTop.setLayout(fl_pTop);

		JLabel lblId = new JLabel("ID / 비밀번호 찾기");
		lblId.setFont(new Font("굴림", Font.BOLD, 15));
		lblId.setForeground(new Color(0, 0, 0));
		lblId.setToolTipText("");
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		pTop.add(lblId);

		JPanel pCenter = new JPanel();
		add(pCenter);
		GridBagLayout gbl_pCenter = new GridBagLayout();
		gbl_pCenter.columnWidths = new int[] { 400 };
		gbl_pCenter.rowHeights = new int[] { 100 };
		gbl_pCenter.columnWeights = new double[] { 1.0 };
		gbl_pCenter.rowWeights = new double[] { 0.0 };
		pCenter.setLayout(gbl_pCenter);

		JPanel pCenter_1 = new JPanel();
		GridBagConstraints gbc_pCenter_1 = new GridBagConstraints();
		gbc_pCenter_1.insets = new Insets(10, 10, 10, 10);
		gbc_pCenter_1.gridwidth = 0;
		gbc_pCenter_1.gridheight = 0;
		gbc_pCenter_1.weighty = 1.0;
		gbc_pCenter_1.weightx = 1.0;
		gbc_pCenter_1.gridx = 0;
		gbc_pCenter_1.gridy = 0;
		pCenter.add(pCenter_1, gbc_pCenter_1);
		pCenter_1.setLayout(new BoxLayout(pCenter_1, BoxLayout.Y_AXIS));

		JPanel pFindID = new JPanel();
		pFindID.setBorder(new EmptyBorder(30, 30, 30, 30));
		pCenter_1.add(pFindID);
		GridBagLayout gbl_pFindID = new GridBagLayout();
		gbl_pFindID.columnWidths = new int[] { 30, 100 };
		gbl_pFindID.rowHeights = new int[] { 30, 30, 30 };
		gbl_pFindID.columnWeights = new double[] { 1.0 };
		gbl_pFindID.rowWeights = new double[] { 1.0, 1.0 };
		pFindID.setLayout(gbl_pFindID);

		JLabel lblName = new JLabel("이름 :");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		pFindID.add(lblName, gbc_lblName);

		JLabel lblBirthday = new JLabel("생년월일:");
		GridBagConstraints gbc_lblBirthday = new GridBagConstraints();
		gbc_lblBirthday.anchor = GridBagConstraints.EAST;
		gbc_lblBirthday.insets = new Insets(0, 0, 5, 5);
		gbc_lblBirthday.gridx = 0;
		gbc_lblBirthday.gridy = 1;
		pFindID.add(lblBirthday, gbc_lblBirthday);

		JTextField tfName = new JTextField();
		GridBagConstraints gbc_lbltfName = new GridBagConstraints();
		gbc_lbltfName.insets = new Insets(2, 0, 0, 0);
		gbc_lbltfName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbltfName.anchor = GridBagConstraints.NORTH;
		gbc_lbltfName.gridheight = 0;
		gbc_lbltfName.gridwidth = 0;
		gbc_lbltfName.weighty = 1.0;
		gbc_lbltfName.weightx = 1.0;
		gbc_lbltfName.gridx = 1;
		gbc_lbltfName.gridy = 0;
		pFindID.add(tfName, gbc_lbltfName);

		JTextField tfBirthDay = new JTextField();
		GridBagConstraints gbc_lbltfBirthDay = new GridBagConstraints();
		gbc_lbltfBirthDay.insets = new Insets(2, 0, 0, 0);
		gbc_lbltfBirthDay.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbltfBirthDay.anchor = GridBagConstraints.NORTH;
		gbc_lbltfBirthDay.gridheight = 0;
		gbc_lbltfBirthDay.gridwidth = 0;
		gbc_lbltfBirthDay.weighty = 1.0;
		gbc_lbltfBirthDay.weightx = 1.0;
		gbc_lbltfBirthDay.gridx = 1;
		gbc_lbltfBirthDay.gridy = 1;
		pFindID.add(tfBirthDay, gbc_lbltfBirthDay);

		JTextField tfEmail = new JTextField();
		GridBagConstraints gbc_lbltfEmail = new GridBagConstraints();
		gbc_lbltfEmail.insets = new Insets(2, 0, 0, 0);
		gbc_lbltfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_lbltfEmail.anchor = GridBagConstraints.NORTH;
		gbc_lbltfEmail.gridheight = 0;
		gbc_lbltfEmail.gridwidth = 0;
		gbc_lbltfEmail.weighty = 1.0;
		gbc_lbltfEmail.weightx = 1.0;
		gbc_lbltfEmail.gridx = 1;
		gbc_lbltfEmail.gridy = 2;
		pFindID.add(tfEmail, gbc_lbltfEmail);

		JLabel lblEmail = new JLabel("Email :");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 2;
		pFindID.add(lblEmail, gbc_lblEmail);
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 0, 5);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 2;

		JPanel pSouth = new JPanel();
		pSouth.setBorder(new EmptyBorder(10, 10, 10, 10));
		pSouth.setAlignmentY(0.0f);
		pSouth.setAlignmentX(0.0f);
		add(pSouth, BorderLayout.SOUTH);

		JButton btnBack = new JButton("이전");
		pSouth.add(btnBack);
		btnBack.addActionListener(e->Main.frame.setContentPane(Main.history.pop()));

		JButton btnFind = new JButton("찾기");
		pSouth.add(btnFind);
		btnFind.addActionListener(e -> {
			String arr[] = new String[] { tfName.getText().trim(), tfBirthDay.getText().trim(),
					tfEmail.getText().trim() };
			for (String value : arr) {
				if (value.equals("")) {
					JOptionPane.showMessageDialog(null, "모든 정보를 입력해주시길 바랍니다.", "입력 오류", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
			String id = Main.dao.findUserID(tfName.getText(), tfBirthDay.getText(), tfEmail.getText());
			if (id != null) {
				JOptionPane.showMessageDialog(null, "찾는 ID는 " + id + "입니다.", "ID/PW 찾기",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "ID가 존재하지 않거나 찾을 수 없습니다", "ID/PW 찾기",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		revalidate();
	}
}
