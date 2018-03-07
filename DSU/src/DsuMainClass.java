public class DsuMainClass {                                              
	int[] parent, rank, setSize;
	// number of disjoint sets
	int numSets;

	public DsuMainClass(int N) 
	{
		parent = new int[numSets = N];
		rank = new int[N];
		setSize = new int[N];
		for (int i = 0; i < N; i++) {  parent[i] = i; setSize[i] = 1; }
	}
	
	//The trick is to make the parentaths for all those nodes shorter, by setting the parentarent of each visited vertex directly to parent.
	public int findSet(int i) { return parent[i] == i ? i : (parent[i] = findSet(parent[i])); }

	public boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

	public void unionSet(int i, int j) 
	{ 
		if (isSameSet(i, j)) 
			return;
		numSets--; 
		int x = findSet(i), y = findSet(j);
		if(rank[x] > rank[y]) { parent[y] = x; setSize[x] += setSize[y]; }
		else
		{	parent[x] = y; setSize[y] += setSize[x];
			if(rank[x] == rank[y]) rank[y]++; 
		} 
	}

	public int numDisjointSets() { return numSets; }

	public int sizeOfSet(int i) { return setSize[findSet(i)]; }
}