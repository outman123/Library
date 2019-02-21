/**
 * 
 */
package administrator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.AddNewBook;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

/**
 * @author Administrator
 *
 */
public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField txtBookName;
	private JTextField txtWriter;
	private JTextField txtPublisher;
	private JTextField txtBuyDate;
	private JLabel lblAmount;
	private JTextField txtAmount;
	private JButton btnCreate;
	private JButton btnQuit;

	private String bookName;
	private String writer;
	private String publisher;
	private String buyDate;
	private int amount;
	private MainWindow mw;

	/**
	 * Create the frame.
	 */
	public AddBook(MainWindow mw) {
		this.mw = mw;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 398, 205);
		setResizable(false);
		setTitle("增加书籍");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblBookName = new JLabel("书名");
		lblBookName.setBounds(22, 10, 24, 15);
		contentPane.add(lblBookName);

		txtBookName = new JTextField();
		txtBookName.setBounds(56, 7, 100, 21);
		contentPane.add(txtBookName);
		txtBookName.setColumns(10);

		JLabel lblWriter = new JLabel("作者");
		lblWriter.setBounds(216, 10, 34, 15);
		contentPane.add(lblWriter);

		txtWriter = new JTextField();
		txtWriter.setBounds(248, 7, 126, 21);
		contentPane.add(txtWriter);
		txtWriter.setColumns(10);

		JLabel lblPublisher = new JLabel("出版社");
		lblPublisher.setBounds(10, 50, 36, 15);
		contentPane.add(lblPublisher);

		txtPublisher = new JTextField();
		txtPublisher.setBounds(56, 47, 100, 21);
		contentPane.add(txtPublisher);
		txtPublisher.setColumns(10);

		JLabel lblBuyDate = new JLabel("购买日期");
		lblBuyDate.setBounds(190, 50, 48, 15);
		contentPane.add(lblBuyDate);

		txtBuyDate = new JTextField();
		txtBuyDate.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtBuyDate.setForeground(Color.black);
				txtBuyDate.setText("");
			}
		});
		txtBuyDate.setForeground(Color.LIGHT_GRAY);
		txtBuyDate.setText("格式为：xxxx-xx-xx");
		txtBuyDate.setBounds(248, 47, 126, 21);
		contentPane.add(txtBuyDate);
		txtBuyDate.setColumns(10);

		lblAmount = new JLabel("数量");
		lblAmount.setBounds(22, 101, 24, 15);
		contentPane.add(lblAmount);

		txtAmount = new JTextField();
		txtAmount.setBounds(56, 98, 100, 21);
		contentPane.add(txtAmount);
		txtAmount.setColumns(10);

		btnCreate = new JButton("确定");
		btnCreate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (getInformation()) {
					try {
						set();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null, "添加成功");
				}
			}
		});
		btnCreate.setBounds(56, 142, 93, 23);
		contentPane.add(btnCreate);

		btnQuit = new JButton("退出");
		btnQuit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
			}
		});
		btnQuit.setBounds(248, 142, 93, 23);
		contentPane.add(btnQuit);
	}

	private boolean getInformation() {
		boolean flag = true;
		bookName = txtBookName.getText();
		writer = txtWriter.getText();
		publisher = txtPublisher.getText();
		buyDate = txtBuyDate.getText();

		if (bookName.isEmpty()) {
			flag = false;
		}
		if (writer.isEmpty()) {
			flag = false;
		}
		if (publisher.isEmpty()) {
			flag = false;
		}
		if (txtAmount.getText().isEmpty()) {
			flag = false;
		} else {
			amount = Integer.parseInt(txtAmount.getText());
		}

		if (flag == false) {
			JOptionPane.showMessageDialog(null, "将信息填写完整");
			return false;
		}
		if (buyDate.length() != 10 || buyDate.charAt(4) != "-".charAt(0) || buyDate.charAt(7) != "-".charAt(0)) {
			JOptionPane.showMessageDialog(null, "购买日期格式有误");
			return false;
		}
		if (amount < 0) {
			JOptionPane.showMessageDialog(null, "数量不能小于1");
			return false;
		}
		dispose();
		return true;
	}

	public void set() throws SQLException {
		AddNewBook anb = new AddNewBook(bookName, writer, publisher, buyDate, amount);
		anb.add();
		mw.toFresh();
	}

}
