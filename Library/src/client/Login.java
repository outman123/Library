package client;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

@SuppressWarnings("serial")
public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtAccount;
	private JPasswordField txtPassword;

	private JButton btnLogin;
	private JButton btnNew;
	private JButton btnQuit;

	private String stuid;
	private String password;

	private CreateNewAccount cna;
	private database.Login lg;
	
	private administrator.MainWindow amw;

	MyFrame frame;

	/**
	 * Create the frame.
	 */
	public Login() {

		String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		setTitle("???");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 227);
		setLocationRelativeTo(null);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAccount = new JLabel("???");
		lblAccount.setForeground(new Color(30, 144, 255));
		lblAccount.setFont(new Font("SimSun", Font.PLAIN, 12));
		lblAccount.setBackground(new Color(30, 144, 255));
		lblAccount.setBounds(53, 32, 54, 15);
		contentPane.add(lblAccount);

		JLabel lblPassword = new JLabel("????");
		lblPassword.setForeground(new Color(30, 144, 255));
		lblPassword.setBounds(53, 87, 54, 15);
		contentPane.add(lblPassword);

		txtAccount = new JTextField();
		txtAccount.setBounds(119, 29, 168, 21);
		contentPane.add(txtAccount);
		txtAccount.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(119, 84, 168, 21);
		contentPane.add(txtPassword);

		btnLogin = new JButton("???");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				getInformation();
				try {
					login();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(35, 146, 80, 23);
		contentPane.add(btnLogin);

		btnNew = new JButton("???");
		btnNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cna = new CreateNewAccount();
				cna.setVisible(true);
			}
		});
		btnNew.setBounds(150, 146, 80, 23);
		contentPane.add(btnNew);

		btnQuit = new JButton("???");
		btnQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(265, 146, 80, 23);
		contentPane.add(btnQuit);
	}

	private void getInformation() {
		stuid = txtAccount.getText();
		password = String.valueOf(txtPassword.getPassword());
	}

	private void login() throws SQLException {
		lg = new database.Login(stuid, password);
		if (lg.login()) {
			dispose();
			if(stuid.equals("admin")) {
				amw=new administrator.MainWindow();
				amw.setVisible(true);
				amw.setLocationRelativeTo(null);
			}else {
				frame = new MyFrame(stuid);
				frame.setVisible(true);
			}
			
		} else {
			JOptionPane.showMessageDialog(null, "???????");
		}
	}

	public MyFrame getFrame() {
		return frame;
	}
}
