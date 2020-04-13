package practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SkylineProblem {

	class Building{
		int li;
		int ri;
		int h;

		Building(int li, int ri, int h) {
			this.li = li;
			this.ri = ri;
			this.h = h;
		}

	}
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> result = new ArrayList<>();

		PriorityQueue<Building> pq = new PriorityQueue<>(new Comparator<Building>() {
			@Override
			public int compare(Building o1, Building o2) {
				return o1.li-o2.li;
			}
		});

		for(int i=0;i<buildings.length;i++){
			pq.add(new Building(buildings[i][0],buildings[i][1],buildings[i][2]));
		}

		Building curr = pq.remove();
		int minX = curr.li;
		int maxY = curr.h;
		int maxX = curr.ri;
		int minY = curr.h;

		result.add(new int[]{minX,maxY});
		while(!pq.isEmpty()){
			curr = pq.remove();
			if(minX<curr.li && curr.li<maxX) {
				maxX = Math.max(maxX, curr.ri);

				if (curr.h > maxY) {
					result.add(new int[]{curr.li, curr.h});
					maxY = curr.h;
				}
				if (curr.ri > maxX) {
					maxX = curr.ri;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {

	}
}
