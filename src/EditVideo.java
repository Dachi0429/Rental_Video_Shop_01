import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditVideo extends JFrame{
	JTextField origin_video_name = new JTextField("ORIGINAL_VIDEO_NAME", 20);
	JTextField origin_strage = new JTextField("ORIGINAL_STRAGE", 20);
	JTextField origin_rent = new JTextField("ORIGIN_RENT");
	JTextField jtf_video_name = new JTextField("EDIT_VIDEO_NAME", 20);
	JTextField jtf_strage = new JTextField("EDIT_STRAGE", 20);
	JTextField jtf_rent = new JTextField("EDIT_RENT", 20);
	
	EditVideo(){
		JButton button_home = new JButton("Home");
		button_home.addActionListener(new HomeActionListener());
		
		JButton button_finish = new JButton("Finish");
		button_finish.addActionListener(new FinishActionListener());
		
		
		
		JPanel button_panel = new JPanel();
		button_panel.add(button_home);
		button_panel.add(button_finish);
		
		JPanel input_panel = new JPanel();
		input_panel.setPreferredSize(new Dimension(150, 300));
		input_panel.add(origin_video_name);
		input_panel.add(jtf_video_name);
		input_panel.add(jtf_strage);
		input_panel.add(jtf_rent);
		
		getContentPane().add(button_panel, BorderLayout.PAGE_END);
		getContentPane().add(input_panel, BorderLayout.CENTER);
	}
	
	class FinishActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//Vector<String> add_tmp = new Vector<String>();
			FirstPage.edit_Video_frame.setVisible(false);
//			//add_tmp.add(jtf_id.getText());
//			//add_tmp.add(jtf_videoname.getText());
			int edit_index = Video.Edit_Taple(origin_video_name.getText(), jtf_video_name.getText(), jtf_strage.getText(), jtf_rent.getText());
			Vector<String> new_row = new Vector<String>();
			new_row.add(jtf_video_name.getText());
			new_row.add(jtf_strage.getText());
			new_row.add(jtf_rent.getText());
			FirstPage.frame1.video_table_model.removeRow(edit_index);
			FirstPage.frame1.video_table_model.insertRow(edit_index, new_row);
			
			//Rent.Add_data(jtf_id.getText(), jtf_videoname.getText());
		}
	}
	
	class HomeActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			FirstPage.edit_Video_frame.setVisible(false);
		}
	}
}