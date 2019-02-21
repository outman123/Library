package administrator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumn;

import database.GetAllAccounts;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JPanel pnlButtons;
	
	private JButton btnAccounts;
	private JButton btnBooks;
	
	private JScrollPane scp;
	
	private JTable table;
	private Object[][] data;
	private final String[] studentHeader= {"","姓名","性别","学院","年级","班级","已借书籍数量"};
	private final String[] bookHeader= {"","书名","作者","出版社","购买时间","是否被借阅","借阅者姓名"};
	
	private AddBook ab;
	
	private MainWindow mw;

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		mw=this;
		
		setTitle("管理员操作系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setResizable(false);
		
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		pnlButtons = new JPanel();
		pnlButtons.setBackground(Color.CYAN);
		pnlButtons.setBounds(0, 0, 600, 50);
		contentPane.add(pnlButtons);
		pnlButtons.setLayout(null);
		
		btnAccounts = new JButton("查看所有用户");
		btnAccounts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					getStudents();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnAccounts.setBounds(10, 17, 105, 23);
		pnlButtons.add(btnAccounts);
		
		btnBooks = new JButton("查看所有书籍");
		btnBooks.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					getBooks();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBooks.setBounds(144, 17, 105, 23);
		pnlButtons.add(btnBooks);
		
		JButton btnAdd = new JButton("增加书籍");
		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ab=new AddBook(mw);
				ab.setLocationRelativeTo(null);
				ab.setVisible(true);
			}
		});
		btnAdd.setBounds(287, 17, 93, 23);
		pnlButtons.add(btnAdd);
		
		table=new JTable();
			
		scp = new JScrollPane(table);
		scp.setBounds(0, 50, 600, 350);
		contentPane.add(scp);
	}
	
	private void getStudents() throws SQLException {
		ArrayList<Student> students=new GetAllAccounts().getAllAccounts();
		data=new Object[students.size()][7];
		int i=0;
		for(Student student: students) {
			data[i][0]=String.valueOf(i+1);
			data[i][1]=student.getName();
			data[i][2]=student.getSex();
			data[i][3]=student.getDepname();
			data[i][4]=student.getGrade();
			data[i][5]=student.getClassNo();
			data[i][6]=student.getBorrowBookNumber();
			i++;
		}
		table=new JTable(data,studentHeader);
		TableColumn tc=table.getColumnModel().getColumn(0);
		tc.setPreferredWidth(10);
		tc=table.getColumnModel().getColumn(1);
		tc.setPreferredWidth(30);
		tc=table.getColumnModel().getColumn(2);
		tc.setPreferredWidth(15);
		tc=table.getColumnModel().getColumn(4);
		tc.setPreferredWidth(30);
		tc=table.getColumnModel().getColumn(5);
		tc.setPreferredWidth(30);
		tc=table.getColumnModel().getColumn(6);
		tc.setPreferredWidth(35);
		scp= new JScrollPane(table);
		scp.setBounds(0, 50, 600, 350);
		contentPane.add(scp);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	private void getBooks() throws SQLException {
		ArrayList<Book> books=new GetBook().getBook();
		data=new Object[books.size()][7];
		int i=0;
		for(Book book : books) {
			data[i][0]=String.valueOf(i+1);
			data[i][1]=book.getBookName();
			data[i][2]=book.getWriter();
			data[i][3]=book.getPublisher();
			data[i][4]=book.getBuyDate();
			if(1==book.getIsLoan()) {
				data[i][5]="是";
				data[i][6]=book.getStudentName();
			}
			else {
				data[i][5]="否";
			}
			i++;
		}
		table=new JTable(data,bookHeader);
		scp= new JScrollPane(table);
		scp.setBounds(0, 50, 600, 350);
		contentPane.add(scp);
	}
	
	public void toFresh() throws SQLException {
		getBooks();
	}
}
