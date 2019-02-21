package client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class CreateNewAccount extends JFrame {

	private JPanel contentPane;
	private JTextField txtAccount;
	private JPasswordField txtPassword;
	private JPasswordField txtCheckPassword;

	private JButton btnQuit;
	private JButton btnCreate;

	private String password;
	private String stuid;
	private String passwordCheck;

	private JLabel lblCheckPassword;
	private JLabel lblPassword;
	private JLabel lblTipWrong;
	private JLabel lblTipLength;
	private JLabel lblAccountTip;

	private final String ACCOUNT_NULL = "????????????";
	private final String ACCOUNT_LENGTH = "???????????????10";
	private final String PASSWORD_NULL = "?????????";
	private final String PASSWORD_LENGTH = "????????????20";
	private final String PASSWORD_CHECK = "???????";

	private boolean flag;

	private database.CreateNewAccount cna;

	/**
	 * Create the frame.
	 */
	public CreateNewAccount() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 377, 281);
		setResizable(false);
		setLocationRelativeTo(null);
		setTitle("??????");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAccount = new JLabel("?????");
		lblAccount.setBounds(32, 43, 54, 15);
		contentPane.add(lblAccount);

		lblPassword = new JLabel("????");
		lblPassword.setBounds(32, 95, 54, 15);
		contentPane.add(lblPassword);

		lblCheckPassword = new JLabel("???????");
		lblCheckPassword.setBounds(32, 145, 54, 15);
		contentPane.add(lblCheckPassword);

		txtAccount = new JTextField();
		txtAccount.setBounds(113, 40, 151, 21);
		contentPane.add(txtAccount);
		txtAccount.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(113, 92, 151, 21);
		contentPane.add(txtPassword);

		txtCheckPassword = new JPasswordField();
		txtCheckPassword.setBounds(113, 142, 151, 21);
		contentPane.add(txtCheckPassword);

		btnCreate = new JButton("????");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getInformation();
				check();
				if (flag) {
					createNewAccount();
				}
			}
		});
		btnCreate.setBounds(50, 204, 80, 23);
		contentPane.add(btnCreate);

		btnQuit = new JButton("???");
		btnQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnQuit.setBounds(180, 204, 80, 23);
		contentPane.add(btnQuit);

		lblTipWrong = new JLabel("");
		lblTipWrong.setForeground(new Color(255, 0, 0));
		lblTipWrong.setBounds(284, 145, 86, 15);
		contentPane.add(lblTipWrong);

		lblTipLength = new JLabel("");
		lblTipLength.setForeground(new Color(255, 0, 0));
		lblTipLength.setBounds(284, 95, 86, 15);
		contentPane.add(lblTipLength);

		lblAccountTip = new JLabel("");
		lblAccountTip.setForeground(new Color(255, 0, 0));
		lblAccountTip.setBounds(284, 43, 86, 15);
		contentPane.add(lblAccountTip);
	}

	private void getInformation() {
		stuid = txtAccount.getText();
		password = String.valueOf(txtPassword.getPassword());
		passwordCheck = String.valueOf(txtCheckPassword.getPassword());
	}

	private void check() {
		flag = true;

		if (stuid.isEmpty()) {
			lblAccountTip.setText(ACCOUNT_NULL);
			flag = false;
		} else if (stuid.length() > 10) {
			lblAccountTip.setText(ACCOUNT_LENGTH);
			flag = false;
		} else {
			lblAccountTip.setText(null);
		}

		if (password.isEmpty()) {
			lblTipLength.setText(PASSWORD_NULL);
			flag = false;
		} else if (password.length() > 20) {
			lblTipLength.setText(PASSWORD_LENGTH);
			flag = false;
		} else {
			lblTipLength.setText(null);
		}

		if (!passwordCheck.equals(password)) {
			lblTipWrong.setText(PASSWORD_CHECK);
			flag = false;
		} else {
			lblTipWrong.setText(null);
		}
	}

	private void createNewAccount() {
		cna = new database.CreateNewAccount(stuid, password);
		if (cna.createNewAccount()) {
			JOptionPane.showMessageDialog(null, "???????");
			dispose();
		} else {
			JOptionPane.showMessageDialog(null, "????????????");
		}
	}

}
