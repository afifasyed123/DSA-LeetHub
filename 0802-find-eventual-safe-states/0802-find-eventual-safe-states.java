class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;
        List<List<Integer>> reverseGraph= new ArrayList<>();
        int[] outdegree = new int[n];

        for(int i=0;i<n;i++){
            reverseGraph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int neighbor: graph[i]){
                reverseGraph.get(neighbor).add(i);
                outdegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(outdegree[i]==0){
                queue.add(i);
            }
        }
        List<Integer> safe = new ArrayList<>();

        while(!queue.isEmpty()){

            int current = queue.remove();
            safe.add(current);
            for(int prev: reverseGraph.get(current)){
                outdegree[prev]--;
                if(outdegree[prev]==0){
                    queue.add(prev);
                }
            }
        }
        Collections.sort(safe);
        return safe;
    }
}