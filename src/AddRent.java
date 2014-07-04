import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddRent extends JFrame{
	JTextField jtf_id = new JTextField("ID", 20);
	JTextField jtf_videoname = new JTextField("VIDEO_NAME", 20);
	
	AddRent(){
		JButton button_home = new JButton("Home");
		button_home.addActionListener(new HomeActionListener());
		
		JButton button_finish = new JButton("Finish");
		button_finish.addActionListener(new FinishActionListener());
		
		
		
		JPanel button_panel = new JPanel();
		button_panel.add(button_home);
		button_panel.add(button_finish);
		
		JPanel input_panel = new JPanel();
		input_panel.add(jtf_id);
		input_panel.add(jtf_videoname);
		
		getContentPane().add(button_panel, BorderLayout.PAGE_END);
		getContentPane().add(input_panel, BorderLayout.CENTER);
	}
	
	class FinishActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Vector<String> add_tmp = new Vector<String>();
			FirstPage.add_rent_frame.setVisible(false);
			add_tmp.add(jtf_id.getText());
			add_tmp.add(jtf_videoname.getText());
			FirstPage.frame1.rent_table_model.addRow(add_tmp);
			Rent.Add_data(jtf_id.getText(), jtf_videoname.getText());
			Rent new_rent = new Rent();
			new_rent.member_id = jtf_id.getText();
			new_rent.video_name = jtf_videoname.getText();
			Rent.rent_data.add(new_rent);
			//decleaseも忘れずに
		}
	}
	
	class HomeActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			FirstPage.add_rent_frame.setVisible(false);
			
		}
	}
}
//		JFrame frame_add = new JFrame();
//		JTextField jt_rent_id = new JTextField("ID", 20);
//		JTextField jt_rent_videoname = new JTextField("Name", 20);
//		public Add(){
//			JButton button_home = new JButton("Home");
//			JButton button_finish = new JButton("Finish");
//			//JTextField jt_rent_id = new JTextField("ID", 20);
//			//JTextField jt_rent_videoname = new JTextField("Name", 20);
//			JPanel home_finish_panel = new JPanel();
//			home_finish_panel.add(button_home);
//			home_finish_panel.add(button_finish);
//			JPanel rent_input = new JPanel();
//			rent_input.add(jt_rent_id);
//			rent_input.add(jt_rent_videoname);
//			
//			getContentPane().add(rent_input, BorderLayout.PAGE_END);
//			getContentPane().add(home_finish_panel, BorderLayout.CENTER);
//			
//			frame_add.add(rent_input, BorderLayout.CENTER);
//			frame_add.add(home_finish_panel, BorderLayout.PAGE_END);
//			
//			button_finish.addActionListener(new FinishActionListener());
//			frame_add.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			frame_add.setBounds(100, 100, 300, 300);
//			frame_add.setTitle("RentalInformation");
//			frame_add.setVisible(true);
