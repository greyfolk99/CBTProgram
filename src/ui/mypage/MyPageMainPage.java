package ui.mypage;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import ui.Main;
import ui.login.LoginPage;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class MyPageMainPage extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyPageMainPage() {
		
		/* 패널 설정 */
		// base
		setSize(400, 500);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));
		// North
		JPanel pNorth = new JPanel();
		// Center
		JPanel pCenter = new JPanel();
		pCenter.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagLayout gbl_pCenter = new GridBagLayout();
		gbl_pCenter.columnWidths = new int[]{0, 0,0,0};
		gbl_pCenter.rowHeights = new int[]{100,0,100,0,83,0};
		gbl_pCenter.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_pCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		// South
		JPanel pSouth = new JPanel();
		pSouth.setBorder(new LineBorder(new Color(0, 0, 0)));
		pSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		
		/* 컴포넌트 설정 */
		
		// pNorth
		JLabel lblTitle = new JLabel("마이페이지");
		lblTitle.setFont(new Font("굴림", Font.BOLD, 20));
		// pCenter
		JButton btnUpdate = new JButton("회원정보 변경");
		btnUpdate.setFont(new Font("굴림", Font.PLAIN, 15));
		GridBagConstraints gbc_btnUpdate = new GridBagConstraints();
		gbc_btnUpdate.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUpdate.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate.gridx = 1;
		gbc_btnUpdate.gridy = 0;
		JButton btnTestlist = new JButton("이전 시험 정보");
		btnTestlist.setFont(new Font("굴림", Font.PLAIN, 15));
		GridBagConstraints gbc_btnTestlist= new GridBagConstraints();
		gbc_btnTestlist.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTestlist.insets = new Insets(0, 0, 5, 5);
		gbc_btnTestlist.gridx = 1;
		gbc_btnTestlist.gridy = 2;
		JButton btnUnsub = new JButton("회원 탈퇴");
		btnUnsub.setFont(new Font("굴림", Font.PLAIN, 15));
		GridBagConstraints gbc_btnUnsub = new GridBagConstraints();
		gbc_btnUnsub.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnUnsub.insets = new Insets(0, 0, 5, 5);
		gbc_btnUnsub.gridx = 1;
		gbc_btnUnsub.gridy = 4;
		// pSouth
		JButton btnPrevious = new JButton("이전");

		/* 컴포넌트 추가 */
		add(pNorth, BorderLayout.NORTH);
		add(pCenter, BorderLayout.CENTER);
		add(pSouth, BorderLayout.SOUTH);
		pNorth.add(lblTitle);
		pCenter.setLayout(gbl_pCenter);
		pCenter.add(btnUpdate, gbc_btnUpdate);
		pCenter.add(btnUnsub, gbc_btnUnsub);
		pCenter.add(btnTestlist, gbc_btnTestlist);
		pSouth.add(btnPrevious);

		/* 리스너 */
		btnPrevious.addActionListener(e->{Main.frame.setContentPane(Main.history.pop());});
		btnUpdate.addActionListener(e->{Main.goToPage(new MyPageUpdatePage());});
		btnTestlist.addActionListener(e-> new MyPageHistoryPage());
		btnUnsub.addActionListener(e ->{
			int result = JOptionPane.showConfirmDialog(null, "회원 탈퇴하시겠습니까?", "회원탈퇴",
					JOptionPane.OK_CANCEL_OPTION);
			if (result == 0) { //OK=0 , Cancel=2 리턴
				String setSql = "unsubdate = sysdate()";
				Main.dao.unsubStudent(Main.student, setSql);
				JOptionPane.showMessageDialog(null, "탈퇴가 완료되었습니다.", "회원탈퇴", JOptionPane.INFORMATION_MESSAGE);
				Main.student = null;
				Main.goToPage(new LoginPage());
			}
		});
	}
}