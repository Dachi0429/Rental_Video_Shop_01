import java.util.ArrayList;
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.PrintWriter;
	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.StringTokenizer;


public class Video {
	public String video_name;
	int strage_num;
	int rent_num;
	static ArrayList<Video> video_data;// = new ArrayList();
	
		public static ArrayList<Video> get_data() {
			video_data = new ArrayList<Video>();
			BufferedReader in;
			int member = 0;
			String video_name_in = null;
			try {
				int i = 0;
				in = new BufferedReader(new FileReader("video.txt"));
				String line;
				String token;
				// int i = 0;
				// Rent rent_table = new Rent();
				while ((line = in.readLine()) != null) {
					Video video_table = new Video();
					boolean flag = true;
					StringTokenizer parser = new StringTokenizer(line, "\t");
					token = parser.nextToken();
					video_table.video_name = token;
					video_name_in = parser.nextToken();

					// rent_data.add = member;
					// rent_data.get(i).video_name = video_name_in;
					i++;
					video_table.strage_num = Integer.valueOf(video_name_in);
					video_name_in = parser.nextToken();
					video_table.rent_num = Integer.valueOf(video_name_in);
					
					video_data.add(video_table);
				}
				in.close();
				return video_data;
			}
			catch(Exception e){
				return null;
			}
		}

		public static void Add_data(String new_video_name, String new_video_strage, String new_video_rent){
			FileWriter out = null;
			File file_rent = new File("video.txt");
			try{
				Video new_video_data = new Video();
				new_video_data.video_name = new_video_name;
				new_video_data.strage_num = Integer.valueOf(new_video_strage);
				new_video_data.rent_num = Integer.valueOf(new_video_rent);
				
				out = new FileWriter(file_rent, true);
				
				out.write(new_video_name + "\t" + new_video_strage + "\t" + new_video_rent + "\n");//あとで訂正
				
				//out.write(member_id + "\t" + video_name);
//				for (int i = 0; i < Video.video_array.size(); i++){
//					if (((Video) Video.video_array.get(i)).match(new_video_name)){
//						((Video) Video.video_array.get(i)).decrement();
//						//out.println(member_id + "\t" + new_video_name);
//						break;
//					}
//				}
				out.close();
			}
			catch(Exception e){
				System.out.println(e);
			}
		}
		
		public static int Delete_Taple(String deleate_video_name){
			try{
				int find_index = -1;
				FileWriter out = null;
				File file_rent = new File("video.txt");
				out = new FileWriter(file_rent, true);
//				PrintWriter out = null;
//				out = new PrintWriter(new BufferedWriter(new FileWriter("video.txt")));
				for (int i = 0; i < video_data.size(); i++){
					if (video_data.get(i).video_name.equals(deleate_video_name)){
						video_data.remove(i);
						find_index = i;
						break;
					}
				}
			
				if(find_index == -1){
					out.close();
					return find_index;
				}
			
				for (int i = 0; i < video_data.size(); i++){
					out.write(video_data.get(i).video_name + "\t" + video_data.get(i).strage_num + video_data.get(i).rent_num + "\n");
				}
				out.close();
				return find_index;
			}
			catch(Exception e){
				System.out.println(e);
				return -1;
			}
		}

		
		public static int Edit_Taple(String origin_video_name, String edit_video_name, String edit_video_strage, String edit_video_rent){
			try{
				int find_index = -1;
				FileWriter out = null;
				File file_rent = new File("video.txt");
				out = new FileWriter(file_rent, true);
//				PrintWriter out = null;
//				out = new PrintWriter(new BufferedWriter(new FileWriter("video.txt")));
				for (int i = 0; i < video_data.size(); i++){
					if (video_data.get(i).video_name.equals(origin_video_name)){
						video_data.get(i).video_name = edit_video_name;
						video_data.get(i).strage_num = Integer.valueOf(edit_video_name);
						video_data.get(i).rent_num = Integer.valueOf(edit_video_strage);
						
						find_index = i;
						break;
					}
				}
				if(find_index == -1){
					out.close();
					return find_index;
				}
				for (int i = 0; i < video_data.size(); i++){
					out.write(video_data.get(i).video_name + "\t" + video_data.get(i).strage_num + video_data.get(i).rent_num + "\n");
				}
				out.close();
				return find_index;
			}
			catch(Exception e){
				System.out.println(e);
				return -1;
			}
		}
		
	}
	
	
//	public void decrement(){
//		rent_num--;
//	}
//	
//	public void add_newvideo(Video new_video_object){
//		video_array.add(new_video_object);
//	}
//	
//	public boolean match(String n){
//		if (n.equals(this.video_name)){
//			return true;
//		}
//		return false;
//	}
//}
