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


public class Rent {
	public String member_id;
	public String video_name;
	static ArrayList<Rent> rent_data;

	public static ArrayList<Rent> get_data() {
		rent_data = new ArrayList<Rent>();
		BufferedReader in;
		int member = 0;
		String video_name_in = null;
		try {
			int i = 0;
			in = new BufferedReader(new FileReader("rent.txt"));
			String line;
			String token;
			// int i = 0;
			// Rent rent_table = new Rent();
			while ((line = in.readLine()) != null) {
				Rent rent_table = new Rent();
				boolean flag = true;
				StringTokenizer parser = new StringTokenizer(line, "\t");
				token = parser.nextToken();
				rent_table.member_id = token;
				video_name_in = parser.nextToken();

				// rent_data.add = member;
				// rent_data.get(i).video_name = video_name_in;
				i++;
				// System.out.println("chinko");
				rent_table.video_name = video_name_in;
				rent_data.add(rent_table);
			}
			in.close();
			return rent_data;
		}
		catch(Exception e){
			return null;
		}
	}

	public static void Add_data(String member_id, String new_video_name){
		FileWriter out = null;
		File file_rent = new File("rent.txt");
		try{
			Rent new_rent_data = new Rent();
			new_rent_data.member_id = member_id;
			new_rent_data.video_name = new_video_name;
			
			out = new FileWriter(file_rent, true);
			System.out.println(member_id);
			out.write(member_id + "\t" + new_video_name + "\n");//あとで訂正
			System.out.println("chinko");
			//out.write(member_id + "\t" + video_name);
//			for (int i = 0; i < Video.video_array.size(); i++){
//				if (((Video) Video.video_array.get(i)).match(new_video_name)){
//					((Video) Video.video_array.get(i)).decrement();
//					//out.println(member_id + "\t" + new_video_name);
//					break;
//				}
//			}
			out.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static int Delete_Taple(String deleate_id, String deleate_video){
		try{
			int find_index = -1;
			FileWriter out = null;
			File file_rent = new File("rent.txt");
			out = new FileWriter(file_rent, true);
			//out = new PrintWriter(new BufferedWriter(new FileWriter("rent.txt")));
			for (int i = 0; i < rent_data.size(); i++){
				if ((rent_data.get(i).member_id.equals(deleate_id)) && (rent_data.get(i).video_name.equals(deleate_video))){
					rent_data.remove(i);
					find_index = i;
					break;
				}
			}
		
			if(find_index == -1){
				out.close();
				return find_index;
			}
		
			for (int i = 0; i < rent_data.size(); i++){
				out.write(rent_data.get(i).member_id + "\t" + rent_data.get(i).video_name + "\n");
			}
			out.close();
			return find_index;
		}
		catch(Exception e){
			System.out.println(e);
			return -1;
		}
	}

	
	public static int Edit_Taple(String origin_id, String origin_video_name, String edit_id, String edit_video_name){
		try{
			int find_index = -1;
			FileWriter out = null;
			File file_rent = new File("rent.txt");
			out = new FileWriter(file_rent, true);
//			PrintWriter out = null;
//			out = new PrintWriter(new BufferedWriter(new FileWriter("rent.txt")));
			for (int i = 0; i < rent_data.size(); i++){
				if ((rent_data.get(i).member_id.equals(origin_id)) && (rent_data.get(i).video_name.equals(origin_video_name))){
					rent_data.get(i).member_id = edit_id;
					rent_data.get(i).video_name = edit_video_name;
					find_index = i;
					break;
				}
			}
			if(find_index == -1){
				out.close();
				return find_index;
			}
			for (int i = 0; i < rent_data.size(); i++){
				out.write(rent_data.get(i).member_id + "\t" + rent_data.get(i).video_name + "\n");
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
