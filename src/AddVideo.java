import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddVideo extends JFrame{
	JTextField jtf_video_name = new JTextField("VIDEO_NAME", 20);
	JTextField jtf_strage = new JTextField("STRAGE", 20);
	
	AddVideo(){
		JButton button_home = new JButton("Home");
		button_home.addActionListener(new HomeActionListener());
		
		JButton button_finish = new JButton("Finish");
		button_finish.addActionListener(new FinishActionListener());
		
		
		
		JPanel button_panel = new JPanel();
		button_panel.add(button_home);
		button_panel.add(button_finish);
		
		JPanel input_panel = new JPanel();
		input_panel.add(jtf_video_name);
		input_panel.add(jtf_strage);
		
		getContentPane().add(button_panel, BorderLayout.PAGE_END);
		getContentPane().add(input_panel, BorderLayout.CENTER);
	}
	
	class FinishActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			Vector<String> add_tmp = new Vector<String>();
			FirstPage.add_Video_frame.setVisible(false);
			add_tmp.add(jtf_video_name.getText());
			add_tmp.add(jtf_strage.getText());
			add_tmp.add("0");
			FirstPage.frame1.video_table_model.addRow(add_tmp);
			Video.Add_data(jtf_video_name.getText(), jtf_strage.getText(), "0");
			Video new_video = new Video();
			new_video.video_name = jtf_video_name.getText();
			new_video.strage_num = Integer.valueOf(jtf_strage.getText());
			new_video.rent_num = 0;
			Video.video_data.add(new_video);
			//decleaseも忘れずに
		}
	}
	
	class HomeActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			FirstPage.add_Video_frame.setVisible(false);
			
		}
	}
}