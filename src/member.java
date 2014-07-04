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


public class member {
	public String member_id;
	public String member_name;
	static ArrayList<member> member_data;
	public static ArrayList<member> get_data() {
		member_data = new ArrayList<member>();
		BufferedReader in;
		int member = 0;
		String member_name_in = null;
		try {
			int i = 0;
			in = new BufferedReader(new FileReader("member.txt"));
			String line;
			String token;

			while ((line = in.readLine()) != null) {
				member member_table = new member();
				boolean flag = true;
				StringTokenizer parser = new StringTokenizer(line, "\t");
				token = parser.nextToken();
				member_table.member_id = token;
				member_name_in = parser.nextToken();

				i++;
				member_table.member_name = member_name_in;
				member_data.add(member_table);
			}
			in.close();
			return member_data;
		}
		catch(Exception e){
			return null;
		}
	}

	public static void Add_data(String member_id, String new_member_name){
		FileWriter out = null;
		File file_rent = new File("member.txt");
		try{
			member new_member_data = new member();
			new_member_data.member_id = member_id;
			new_member_data.member_name = new_member_name;
			
			out = new FileWriter(file_rent, true);
			out.write(member_id + "\t" + new_member_name + "\n");//あとで訂正

			out.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static int Delete_Taple(String deleate_id){
		try{
			int find_index = -1;
			PrintWriter out = null;
			out = new PrintWriter(new BufferedWriter(new FileWriter("rent.txt")));
			for (int i = 0; i < member_data.size(); i++){
				if (member_data.get(i).member_id.equals(deleate_id)){
					member_data.remove(i);
					find_index = i;
					break;
				}
			}
		
			if(find_index == -1){
				out.close();
				return find_index;
			}
		
			for (int i = 0; i < member_data.size(); i++){
				out.write(member_data.get(i).member_id + "\t" + member_data.get(i).member_name + "\n");
			}
			out.close();
			return find_index;
		}
		catch(Exception e){
			System.out.println(e);
			return -1;
		}
	}

	
	public static int Edit_Taple(String origin_id, String origin_member_name, String edit_id, String edit_member_name){
		try{
			int find_index = -1;
			PrintWriter out = null;
			out = new PrintWriter(new BufferedWriter(new FileWriter("rent.txt")));
			for (int i = 0; i < member_data.size(); i++){
				if ((member_data.get(i).member_id.equals(origin_id)) && (member_data.get(i).member_name.equals(origin_member_name))){
					member_data.get(i).member_id = edit_id;
					member_data.get(i).member_name = edit_member_name;
					find_index = i;
					break;
				}
			}
			if(find_index == -1){
				out.close();
				return find_index;
			}
			for (int i = 0; i < member_data.size(); i++){
				out.write(member_data.get(i).member_id + "\t" + member_data.get(i).member_name + "\n");
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


//	public static ArrayList<member> get_data() {
//		member_data = new ArrayList<member>();
//		BufferedReader in;
//		int member = 0;
//		String video_name_in = null;
//		try {
//			int i = 0;
//			in = new BufferedReader(new FileReader("member.txt"));
//
//			
//			String line;
//			String token;
//			
//			while ((line = in.readLine()) != null) {
//				member member_table = new member();
//				boolean flag = true;
//				StringTokenizer parser = new StringTokenizer(line, "\t");
//	
//				token = parser.nextToken();
//				member_table.member_id = token;
//				
//				video_name_in = parser.nextToken();
//				
//
//				// rent_data.add = member;
//				// rent_data.get(i).video_name = video_name_in;
//				
//				i++;
//				// System.out.println("chinko");
//				member_table.member_name = video_name_in;
//				member_data.add(member_table);
//			}
//			in.close();
//			return member_data;
//		}
//		catch(Exception e){
//			System.out.println(e);
//			System.out.println("chinko");
//			return null;
//		}
//	}
//	
//	public static void Add_data(String member_id, String new_video_name){
//		PrintWriter out = null;
//		try{
//			Rent new_rent_data = new Rent();
//			new_rent_data.member_id = member_id;
//			new_rent_data.video_name = new_video_name;
//			out = new PrintWriter(new BufferedWriter(new FileWriter("rent.txt", true)));
//			//out.write(member_id + "\t" + video_name);
//			for (int i = 0; i < Video.video_array.size(); i++){
//				if (((Video) Video.video_array.get(i)).match(new_video_name)){
//					((Video) Video.video_array.get(i)).decrement();
//					out.println(member_id + "\t" + new_video_name);
//					break;
//				}
//			}
//		}
//		catch(Exception e){
//			System.out.println(e);
//		}
//	}
//	
//	public static boolean Delete_Taple(String deleate_id, String deleate_video){
//		try{
//			boolean find = false;
//			PrintWriter out = null;
//			out = new PrintWriter(new BufferedWriter(new FileWriter("rent.txt")));
//			for (int i = 0; i < member_data.size(); i++){
//				if ((member_data.get(i).member_id.equals(deleate_id)) && (member_data.get(i).member_name.equals(deleate_video))){
//					member_data.remove(i);
//					find = true;
//					break;
//				}
//			}
//		
//			if(!(find)){
//				out.close();
//				return false;
//			}
//		
//			for (int i = 0; i < member_data.size(); i++){
//				out.println(member_data.get(i).member_id + "\t" + member_data.get(i).member_name);
//			}
//			out.close();
//			return true;
//		}
//		catch(Exception e){
//			System.out.println(e);
//			return false;
//		}
//	}
//	
//	public static boolean Edit_Taple(int origin_id, String origin_video_name, String edit_id, String edit_video_name){
//		try{
//			boolean find = false;
//			PrintWriter out = null;
//			out = new PrintWriter(new BufferedWriter(new FileWriter("rent.txt")));
//			for (int i = 0; i < member_data.size(); i++){
//				if ((member_data.get(i).member_id.equals(origin_id)) && (member_data.get(i).member_name.equals(origin_video_name))){
//					member_data.get(i).member_id = edit_id;
//					member_data.get(i).member_name = edit_video_name;
//					find = true;
//					break;
//				}
//			}
//			if(!(find)){
//				out.close();
//				return false;
//			}
//			for (int i = 0; i < member_data.size(); i++){
//				out.println(member_data.get(i).member_id + "\t" + member_data.get(i).member_name);
//			}
//			out.close();
//			return true;
//		}
//		catch(Exception e){
//			System.out.println(e);
//			return false;
//		}
//	}
//	
//}
