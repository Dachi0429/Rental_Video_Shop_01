import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Addmember extends JFrame{
	JTextField jtf_member_id = new JTextField("ID", 20);
	JTextField jtf_member_name = new JTextField("MEMBER_NAME", 20);
	
	Addmember(){
		JButton button_home = new JButton("Home");
		button_home.addActionListener(new HomeActionListener());
		
		JButton button_finish = new JButton("Finish");
		button_finish.addActionListener(new FinishActionListener());
		
		
		
		JPanel button_panel = new JPanel();
		button_panel.add(button_home);
		button_panel.add(button_finish);
		
		JPanel input_panel = new JPanel();
		input_panel.add(jtf_member_id);
		input_panel.add(jtf_member_name);
		
		getContentPane().add(button_panel, BorderLayout.PAGE_END);
		getContentPane().add(input_panel, BorderLayout.CENTER);
	}
	
	class FinishActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Vector<String> add_tmp = new Vector<String>();
			FirstPage.add_member_frame.setVisible(false);
			add_tmp.add(jtf_member_id.getText());
			add_tmp.add(jtf_member_name.getText());
			FirstPage.frame1.member_table_model.addRow(add_tmp);
			member.Add_data(jtf_member_id.getText(), jtf_member_name.getText());
			member new_member = new member();
			new_member.member_id = jtf_member_id.getText();
			new_member.member_name = jtf_member_name.getText();
			member.member_data.add(new_member);
			//decleaseも忘れずに
		}
	}
	
	class HomeActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			FirstPage.add_member_frame.setVisible(false);
			
		}
	}
}