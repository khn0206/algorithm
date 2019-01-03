
public class WeightedUnionFind {

	private int arr[];
	private int sz[];
	
	public WeightedUnionFind() {
		
		arr = new int[10];
		sz = new int[10];
		
		for(int i = 0 ; i < 10 ; i++) {
			arr[i] = i;
			sz[i] = 1;
		}		
	}
	
	private int getRoot(int v) {
		while(v != arr[v]) {
			v = arr[v];
		}
		return v;
	}
	
	public boolean isConnected(int p, int q) {
		return getRoot(p) == getRoot(q);
	}
	
	private int getSize(int v) {
		return sz[v];
	}
	
	public void printArray() {
		System.out.print("id\t");
		for(int i =0 ; i< 10; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.print("parent\t");
		for(int i =0 ; i< 10; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
		System.out.print("size\t");
		for(int i =0 ; i< 10; i++) {
			System.out.print(sz[i] + "\t");
		}
	}
	
	public void union(int p, int q) {

		if(isConnected(p, q)) {
			System.out.println(p + " and " + q + " is already connected.");
			return;
		}
		
		int rootP = getRoot(p);
		int rootQ = getRoot(q);
		
		if(getSize(rootP) < getSize(rootQ)) {
			arr[rootP] = rootQ;
			sz[rootQ] += sz[rootP];
 		}else {
 			arr[rootQ] = rootP;
 			sz[rootP] += sz[rootQ];
 		}
	}
}
