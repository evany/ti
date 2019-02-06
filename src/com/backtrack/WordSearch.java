package com.backtrack;

import java.util.List;
import java.util.ArrayList;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
    	if (word == null || word.length() == 0){
    		return true;
    	}

    	boolean[][] used = new boolean[board.length][board[0].length];
    	return backTrack(board, word, used, new int[]{-1,-1});
    }

    private List<int[]> findMatch(char[][] board, int[] start, char target,boolean[][] used){
    	List<int[]> res = new ArrayList<>();
    	int height = board.length;
    	int width = board[0].length;

    	if (start[0] == -1){
    		for(int i = 0; i < height; i++){
    			for(int j = 0; j < width; j++){
    				if(board[i][j] == target){
    					res.add(new int[]{i,j});
    				}
    			}
    		}
    	}else{
    		if(isValid(start[0]-1,start[1], used ,board, target)){
    			res.add(new int[]{start[0]-1,start[1]});
    		} 
			if(isValid(start[0]+1,start[1], used, board, target)){
    			res.add(new int[]{start[0]+1,start[1]});
    		} 
			if(isValid(start[0],start[1]-1, used, board, target)){
    			res.add(new int[]{start[0],start[1]-1});
    		}
    		if(isValid(start[0],start[1]+1, used, board, target)){
    			res.add(new int[]{start[0],start[1]+1});
    		}
    	}
		return res;
    }

    private boolean isValid(int height, int width, boolean[][] used, char[][] board,int target){
    	return height >= 0 && height < used.length && width >= 0 && width < used[0].length && used[height][width] == false && board[height][width] == target;
    }

    private boolean backTrack(char[][] board, String word, boolean[][] used, int[] start){
    	if(word.length() == 0){
			return true;
    	}

    	List<int[]> matchPoints = findMatch(board, start, word.charAt(0), used);

    	for(int[] matchPoint : matchPoints){
    		used[matchPoint[0]][matchPoint[1]] = true;
    		boolean result = backTrack(board, word.substring(1), used, matchPoint);
    		if(result) return true;
    		used[matchPoint[0]][matchPoint[1]] = false;
    	}
    	return false;
    }

	public static void main(String[] args) {
		char[][] board = {{'a','b'},{'c','d'}};
		String target = "abcd";


		System.out.println(new WordSearch().exist(board,target));


	}
}
