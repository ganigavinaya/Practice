package practice;
import java.util.*;


public class LeaderBoard {

	HashMap<Integer,Player> player_map;

	TreeSet<Player> tree_set;

	private class Player{
		private int player_id;
		private int total_score;
		private float average;
		private int num_of_scores;

		Player(int player_id){
			this.player_id = player_id;
			total_score = 0;
			num_of_scores =0;
		}

		float getAverage(){
			return average;
		}

		float addScore(int score){
			num_of_scores++;
			total_score+=score;
			average = total_score/((float)num_of_scores);
			return average;
		}

		void reset(){
			average = 0;
			num_of_scores = 0;
			total_score = 0;
		}
	}


	LeaderBoard(){
		player_map = new HashMap<>();

		tree_set = new TreeSet<>(new Comparator<Player>() {
			@Override
			public int compare(Player o1, Player o2) {
				float o1_avg = o1.getAverage();
				float o2_avg = o2.getAverage();
				if(o2_avg>o1_avg)
					return 1;
				else if(o2_avg<o1_avg)
					return -1;
				else
					return o1.player_id-o2.player_id;
			}
		});
	}

	float add_score(int player_id,int score){
		Player p = player_map.get(player_id);

		if(p==null){
			p=new Player(player_id);
			player_map.put(player_id,p);
		}
		else{
			tree_set.remove(p);
		}

		float avg_score = p.addScore(score);

		tree_set.add(p);

		return avg_score;
	}


	List<Integer> top(int max){

		List<Integer> result = new ArrayList<>();
		int i=0;
		for(Player p: tree_set){
			if(i==max)
				break;
			i++;
			result.add(p.player_id);
		}

		return result;
	}

	void reset(int player_id){
		Player p = player_map.get(player_id);
		if(p!=null)
			p.reset();
	}

	public static void main(String[] args) {
		LeaderBoard leader_board = new LeaderBoard();

		System.out.println(leader_board.add_score(1,50));
		System.out.println(leader_board.add_score(2,80));
		System.out.println(leader_board.add_score(2,70));
		System.out.println(leader_board.add_score(2,60));
		System.out.println(leader_board.add_score(3,90));
		System.out.println(leader_board.add_score(3,85));
//		System.out.println(leader_board.add_score(1,125));

		System.out.println(leader_board.top(3));
		System.out.println(leader_board.top(2));
		//System.out.println(leader_board.top(1));
		leader_board.reset(3);
		System.out.println(leader_board.top(3));

	}
}
