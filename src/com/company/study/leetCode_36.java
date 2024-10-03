package com.company.study;

import java.util.*;

public class leetCode_36 {
    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        isValidSudoku(board);
    }

    public static boolean isValidSudoku(char[][] board) {
        // 가로
        Set<Character>[] rowArr = new HashSet[9];
        Set<Character>[] colArr = new HashSet[9];
        Set<Character>[] boxArr = new HashSet[9];

        int rowCount = 0;
        for (int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    rowCount++;
                    rowSet.add(board[i][j]);
                }
            }
            if (rowSet.size() != rowCount) {
                return false;
            }
            rowCount = 0;
        }
        int colCount = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(colArr[j] == null){
                    colArr[j] = new HashSet<>();
                }
                if(board[i][j] != '.') {
                    colArr[j].add(board[i][j]);
                    colCount++;
                }
            }
        }
        int total = 0;
        for (int i = 0; i < 9; i++) {
            total += colArr[i].size();
        }

        if (colCount != total) {
            return false;
        }

        int boxCount = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(boxArr[(i / 3) * 3 + (j / 3)] == null){
                    boxArr[(i / 3) * 3 + (j / 3)] = new HashSet<>();
                }
                if(board[i][j] != '.') {
                    boxArr[(i / 3) * 3 + (j / 3)].add(board[i][j]);
                    boxCount++;
                }
            }
        }
        total = 0;
        for (int i = 0; i < 9; i++) {
            total += boxArr[i].size();
        }
        if (boxCount != total) {
            return false;
        }
        return true;

        // i / 3 = 0
        //         1 + (i/3)
        //         2

        // j     = 0
        //         2
        //         4


        // j 는 3으로 나눴을 때 나머지
//[(i / 3) * 3 + (j / 3) + 1]
        // box 는 j 를 3으로 나눴을때 나머지로
        //   0               1               2
        // 0,0 0,1 0,2    0,4 0,5 0,6    0,7 0,8 0,9
        // 1,1 1,2 1,3
        // 2,1 2,2 2,3
        //   3               4               5
        // 3,1 3,2 3,3    3,4 3,5 3,6    3,7 3,8 3,9
        // 4,1 4,2 4,3
        // 5,1 5,2 5,3
        //    6
        // 6,1 6,2 6,3
        // 7,1 7,2 7,3
        // 8,1 8,2 8,3



        //   0               1               2
        // 1 2 3    0,4 0,5 0,6    0,7 0,8 0,9
        // 2 3 4
        // 3 4 5
        //   4               5               6
        // 4 5 6    3,4 3,5 3,6    3,7 3,8 3,9
        // 5 6 7
        // 5,1 5,2 5,3





    }
}
