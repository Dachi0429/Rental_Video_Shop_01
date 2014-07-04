import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleateRent extends JFrame{
	JTextField jtf_id = new JTextField("ID", 20);
	JTextField jtf_videoname = new JTextField("VIDEO_NAME", 20);
	
	DeleateRent(){
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
			//Vector<String> add_tmp = new Vector<String>();
			FirstPage.deleate_rent_frame.setVisible(false);
//			add_tmp.add(jtf_id.getText());
//			add_tmp.add(jtf_videoname.getText());
			int remove_index = Rent.Delete_Taple(jtf_id.getText(), jtf_videoname.getText());
			FirstPage.frame1.rent_table_model.removeRow(remove_index);;
			
			//Rent.Add_data(jtf_id.getText(), jtf_videoname.getText());
		}
	}
	
	class HomeActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			FirstPage.deleate_rent_frame.setVisible(false);
		}
	}
}