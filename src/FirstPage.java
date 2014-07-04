import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;



public class FirstPage extends JFrame implements ChangeListener{

	static public FirstPage frame1 = new FirstPage();
	static AddRent add_rent_frame;
	static Addmember add_member_frame;
	static AddVideo add_Video_frame;
	static DeleateRent deleate_rent_frame;
	static Deleatemember deleate_member_frame;
	static DeleateVideo deleate_Video_frame;
	static EditRent edit_rent_frame;
	static Editmember edit_member_frame;
	static EditVideo edit_Video_frame;
	
	static JTabbedPane tabbedpane;
	static int tabIndex;
	//
	String[] colname = {"member_id", "video_name"};
	String[] member_colname = {"member_id", "member_name"};
	String[] video_colname = {"video_name", "strage", "rent"};
	DefaultTableModel rent_table_model = new DefaultTableModel(colname, 0);
	DefaultTableModel member_table_model = new DefaultTableModel(member_colname, 0);
	DefaultTableModel video_table_model = new DefaultTableModel(video_colname, 0);
	JTable rent_table = new JTable(rent_table_model);
	JScrollPane rent_scp = new JScrollPane(rent_table);
	
	JTable member_table = new JTable(member_table_model);
	JScrollPane member_scp = new JScrollPane(member_table);
	
	JTable video_table = new JTable(video_table_model);
	JScrollPane video_scp = new JScrollPane(video_table);
	//
	public static void main(String[] args){
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setBounds(500, 500, 800, 800);
		frame1.setTitle("RentalVideoShop");
		frame1.setVisible(true);
	}
	
	FirstPage(){
		tabbedpane = new JTabbedPane();
		tabbedpane.addChangeListener(this);
		
		//
//
		ArrayList<Rent> get_rent_data = new ArrayList<Rent>();
		ArrayList<member> get_member_data = new ArrayList<member>();
		ArrayList<Video> get_video_data = new ArrayList<Video>();
		
		get_rent_data = Rent.get_data();
		for (int i = 0; i < get_rent_data.size(); i++){
			Vector<String> rent_tabledata_row = new Vector<String>();
			rent_tabledata_row.add(get_rent_data.get(i).member_id);
			rent_tabledata_row.add(get_rent_data.get(i).video_name);
			rent_table_model.addRow(rent_tabledata_row);
		}
		get_member_data = member.get_data();
		for (int i = 0; i < get_rent_data.size(); i++){
			Vector<String> member_table_data_row = new Vector<String>();
			member_table_data_row.add(get_member_data.get(i).member_id);
			member_table_data_row.add(get_member_data.get(i).member_name);
			member_table_model.addRow(member_table_data_row);
		}
		get_video_data = Video.get_data();
		for (int i = 0; i < get_video_data.size(); i++){
			Vector<String> video_table_data_row = new Vector<String>();
			video_table_data_row.add(get_video_data.get(i).video_name);
			video_table_data_row.add(String.valueOf(get_video_data.get(i).strage_num));
			video_table_data_row.add(String.valueOf(get_video_data.get(i).rent_num));
			video_table_model.addRow(video_table_data_row);
			
		}
		
//		JTable member_table = new JTable();
//		JTable video_table = new JTable();
		
//		member_scp.add(member_table);
//		video_scp.add(video_table);
		
		JPanel button_panel = new JPanel();
		
		JButton add_button = new JButton("Add");
		JButton deleate_button = new JButton("Deleate");
		JButton edit_button = new JButton("Edit");

		add_button.addActionListener(new AddActionListener());
		deleate_button.addActionListener(new DeleateActionListener());
		edit_button.addActionListener(new EditActionListener());
		
		button_panel.add(add_button);
		button_panel.add(deleate_button);
		button_panel.add(edit_button);
		
		JPanel p = new JPanel();
		JPanel mp = new JPanel();
		JPanel vp = new JPanel();
		
		rent_scp.setPreferredSize(new Dimension(700, 600));
		member_scp.setPreferredSize(new Dimension(700, 600));
		video_scp.setPreferredSize(new Dimension(700, 600));
		p.add(rent_scp);
		mp.add(member_scp);
		vp.add(video_scp);
		
		tabbedpane.addTab("RentalInfo", p);
		tabbedpane.addTab("MemberInfo", mp);
		tabbedpane.addTab("VideoInfo", vp);
		
		getContentPane().add(button_panel, BorderLayout.PAGE_END);
		getContentPane().add(tabbedpane, BorderLayout.CENTER);		
		
	}
	
	public void stateChanged(ChangeEvent e){
		tabIndex = tabbedpane.getSelectedIndex();
		System.out.println(tabIndex);
	}
	
	class AddActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			if (tabIndex == 0){
				add_rent_frame = new AddRent();
				add_rent_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				add_rent_frame.setBounds(200, 200, 400, 400);
				add_rent_frame.setTitle("RentAdd");
				add_rent_frame.setVisible(true);
			}
			else if (tabIndex == 1){
				add_member_frame = new Addmember();
				add_member_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				add_member_frame.setBounds(200, 200, 400, 400);
				add_member_frame.setTitle("MemberAdd");
				add_member_frame.setVisible(true);
			}
			else if (tabIndex == 2){
				add_Video_frame = new AddVideo();
				add_Video_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				add_Video_frame.setBounds(200, 200, 400, 400);
				add_Video_frame.setTitle("VideoAdd");
				add_Video_frame.setVisible(true);
			}
			else
				System.out.println("Tab Error");
		}
	}
	
	class DeleateActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			if (tabIndex == 0){
				deleate_rent_frame = new DeleateRent();
				deleate_rent_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				deleate_rent_frame.setBounds(200, 200, 400, 400);
				deleate_rent_frame.setTitle("RentDeleate");
				deleate_rent_frame.setVisible(true);
			}
			else if (tabIndex == 1){
				deleate_member_frame = new Deleatemember();
				deleate_member_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				deleate_member_frame.setBounds(200, 200, 400, 400);
				deleate_member_frame.setTitle("MemberDeleate");
				deleate_member_frame.setVisible(true);
			}
			else if (tabIndex == 2){
				deleate_Video_frame = new DeleateVideo();
				deleate_Video_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				deleate_Video_frame.setBounds(200, 200, 400, 400);
				deleate_Video_frame.setTitle("VideoDeleate");
				deleate_Video_frame.setVisible(true);
			}
			else
				System.out.println("Tab Error");
		}
	}
	
	class EditActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			if (tabIndex == 0){
				edit_rent_frame = new EditRent();
				edit_rent_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				edit_rent_frame.setBounds(200, 200, 400, 400);
				edit_rent_frame.setTitle("RentEdit");
				edit_rent_frame.setVisible(true);

			}
			else if (tabIndex == 1){
				edit_member_frame = new Editmember();
				edit_member_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				edit_member_frame.setBounds(200, 200, 400, 400);
				edit_member_frame.setTitle("MemberEdit");
				edit_member_frame.setVisible(true);
			}
			else if (tabIndex == 2){
				edit_Video_frame = new EditVideo();
				edit_Video_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				edit_Video_frame.setBounds(200, 200, 400, 400);
				edit_Video_frame.setTitle("RentEdit");
				edit_Video_frame.setVisible(true);
			}
			else
				System.out.println("Tab Error");
		}
	}
}


//		frame1.add(tabbedpane);
//		
//		JPanel tabPanel_rent = new JPanel();
//		//tabPanel_rent.add(new JscrollPane_rent());
//		//JscrollPane_rent scrent = new JscrollPane_rent();
//		
//		//JPanel tabPanel_member = new JPanel();
//		//tabPanel_member.add(new JscrollPane_member("Member_Information"));
//		
//		//JPanel tabPanel_video = new JPanel();
//		//tabPanel_video.add(new JscrollPane_video("Video_Information"));
//		
//		tabbedpane.addTab("Rent", tabPanel_rent);
//		//tabbedpane.addTab("Member", tabPanel_member);
//		//tabbedpane.addTab("Video", tabPanel_video);
//		
//		//indexText = new JTextField("", 2);
//		JButton addButton =new JButton("Add");
//		JButton deleateButton = new JButton("Deleate");
//		JButton editButton = new JButton("Edit");
//		JButton viewButton = new JButton("View");
//		
//		
//		String[] colname = {"member_id", "video_name"};
//		DefaultTableModel tm_rent = new DefaultTableModel(colname, 0);
//		JTable tb = new JTable(tm_rent);
//		
//		
//		ArrayList<Rent> data_rent = Rent.get_data();
//		for(int i = 0; i < data_rent.size(); i++){
//			Vector<String> rent_info_row = new Vector<String>();
//			rent_info_row.add(data_rent.get(i).member_id);
//			rent_info_row.add(data_rent.get(i).video_name);
//			tm_rent.addRow(rent_info_row);
//		}
//		JScrollPane sc = new JScrollPane(tb);
//		addButton.addActionListener(new AddActionListener());
//		
//		JPanel actionPanel = new JPanel();
//		actionPanel.add(addButton);
//		actionPanel.add(deleateButton);
//		actionPanel.add(editButton);
//		actionPanel.add(viewButton);
//		
//		//getContentPane().add(tabbedpane, BorderLayout.CENTER);
//		getContentPane().add(actionPanel, BorderLayout.PAGE_END);
//		getContentPane().add(sc, BorderLayout.CENTER);
//		
//		if(flag_second){
//			System.out.println(flag_second);
//			reframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			reframe.setBounds(100, 100, 300, 300);
//			reframe.setTitle("RentalVideoShop");
//			reframe.setVisible(true);
//		}
//	}
//	class AddActionListener implements ActionListener{
//		public void actionPerformed(ActionEvent e){
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	      	
//	      	frame.setVisible(false);
//	      	new Add();
//		}
//	}
//	class  Add extends JFrame{
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
//			
//		}
//
//		class FinishActionListener implements ActionListener{
//			public void actionPerformed(ActionEvent e){
//				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		      	Rent.Add_data(jt_rent_id.getText(), jt_rent_videoname.getText());
//				
//		      	frame.setVisible(false);
//		      	reframe = new FirstPage();
//		      	new FirstPage();
//			}
//	}
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//	
//	
//	}
//	@Override
//	public void actionPerformed(ActionEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//}
