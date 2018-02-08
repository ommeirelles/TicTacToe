/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package velhaswing;

/**
 *
 * @author lucasamiune
 */
public class Brain {
    public int[][] winCombinations = new int[][] {
            {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, //linha
            {1, 4, 7}, {2, 5, 8}, {3, 6, 9}, //coluna 
            {1, 5, 9}, {3, 5, 7}             //vertical wins
    };
}
