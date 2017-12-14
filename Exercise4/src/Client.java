
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.thanh.Exercise1.FileUtils;
import com.thanh.Exercise1.Student;
import com.thanh.Exercise3.ConnectServer;

public class Client {

	private JFrame frame;
	private JButton btnBrowse;
	private JButton btnUpload;
	private List<Student> students;
	private JButton btnRead;
	private String filePath;
	private JTextField textField;
	private Socket client;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client window = new Client();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Client() {
		initialize();

		btnBrowse.addActionListener(e -> {
			filePath = FileUtils.chooseFile();
			textField.setText(filePath);
		});

		btnUpload.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String host = "localhost";
				int port = 6066;
				try {
					client = new ConnectServer().connectServer(host, port);
					DataOutputStream output = new DataOutputStream(client.getOutputStream());
					output.writeUTF("SendData");
					System.out.println("Sending...");

					students = FileUtils.getListStudent(filePath);

					ObjectOutputStream objectOutput = new ObjectOutputStream(client.getOutputStream());
					objectOutput.writeObject(students);

					System.out.println("Success!");

				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					if (client != null) {
						try {
							client.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});

		btnRead.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				String host = "localhost";
				int port = 6066;
				try {
					client = new ConnectServer().connectServer(host, port);

					DataOutputStream output = new DataOutputStream(client.getOutputStream());
					output.writeUTF("RecieveData");

					ObjectInputStream input = new ObjectInputStream(client.getInputStream());
					System.out.println("Reading...");

					try {
						students = (ArrayList<Student>) input.readObject();
					} catch (ClassNotFoundException e1) {
						e1.printStackTrace();
					}

					FileUtils.printListStudent(students);

				} catch (IOException e1) {
					e1.printStackTrace();
				} finally {
					if (client != null) {
						try {
							client.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblFile = new JLabel("File");
		lblFile.setBounds(61, 85, 34, 14);
		frame.getContentPane().add(lblFile);

		textField = new JTextField();
		textField.setBounds(106, 82, 173, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		btnUpload = new JButton("Send");
		btnUpload.setBounds(106, 127, 70, 23);
		frame.getContentPane().add(btnUpload);

		btnBrowse = new JButton("Browse");
		btnBrowse.setBounds(298, 81, 89, 23);
		frame.getContentPane().add(btnBrowse);

		btnRead = new JButton("Read");
		btnRead.setBounds(201, 127, 78, 23);
		frame.getContentPane().add(btnRead);

	}
}
