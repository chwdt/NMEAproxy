/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package net.brainaid.sol.NMEAproxy;

/**
 *
 * @author cw@brainaid.dk
 */
public class Matrix4x4 {
    private double[][] a;
    
    public Matrix4x4() {
        a = new double [4][4];
    }
    
    public Matrix4x4 transpose() {
        Matrix4x4 A = new Matrix4x4();
        int i, j;
        
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                A.a[i][j] = a[j][i];
            }
        }
        
        return A;
    }
    
    public double determinant() {
        double d;
        
        d = a[0][3] * a[1][2] * a[2][1] * a[3][0] -
            a[0][2] * a[1][3] * a[2][1] * a[3][0] -
            a[0][3] * a[1][1] * a[2][2] * a[3][0] +
            a[0][1] * a[1][3] * a[2][2] * a[3][0] +
            a[0][2] * a[1][1] * a[2][3] * a[3][0] -
            a[0][1] * a[1][2] * a[2][3] * a[3][0] -
            a[0][3] * a[1][2] * a[2][0] * a[3][1] +
            a[0][2] * a[1][3] * a[2][0] * a[3][1] +
            a[0][3] * a[1][0] * a[2][2] * a[3][1] -
            a[0][0] * a[1][3] * a[2][2] * a[3][1] -
            a[0][2] * a[1][0] * a[2][3] * a[3][1] +
            a[0][0] * a[1][2] * a[2][3] * a[3][1] +
            a[0][3] * a[1][1] * a[2][0] * a[3][2] -
            a[0][1] * a[1][3] * a[2][0] * a[3][2] -
            a[0][3] * a[1][0] * a[2][1] * a[3][2] +
            a[0][0] * a[1][3] * a[2][1] * a[3][2] +
            a[0][1] * a[1][0] * a[2][3] * a[3][2] -
            a[0][0] * a[1][1] * a[2][3] * a[3][2] -
            a[0][2] * a[1][1] * a[2][0] * a[3][3] +
            a[0][1] * a[1][2] * a[2][0] * a[3][3] +
            a[0][2] * a[1][0] * a[2][1] * a[3][3] -
            a[0][0] * a[1][2] * a[2][1] * a[3][3] -
            a[0][1] * a[1][0] * a[2][2] * a[3][3] +
            a[0][0] * a[1][1] * a[2][2] * a[3][3];

        return d; 
    }
    
    public Matrix4x4 inverse() {
        Matrix4x4 A = new Matrix4x4();
        double d = determinant();
                
        A.a[0][0] =
            (a[1][2] * a[2][3] * a[3][1] - a[1][3] * a[2][2] * a[3][1] +
             a[1][3] * a[2][1] * a[3][2] - a[1][1] * a[2][3] * a[3][2] -
             a[1][2] * a[2][1] * a[3][3] +
             a[1][1] * a[2][2] * a[3][3]) / d;
        A.a[0][1] =
            (a[0][3] * a[2][2] * a[3][1] - a[0][2] * a[2][3] * a[3][1] -
             a[0][3] * a[2][1] * a[3][2] + a[0][1] * a[2][3] * a[3][2] +
             a[0][2] * a[2][1] * a[3][3] -
             a[0][1] * a[2][2] * a[3][3]) / d;
        A.a[0][2] =
            (a[0][2] * a[1][3] * a[3][1] - a[0][3] * a[1][2] * a[3][1] +
             a[0][3] * a[1][1] * a[3][2] - a[0][1] * a[1][3] * a[3][2] -
             a[0][2] * a[1][1] * a[3][3] +
             a[0][1] * a[1][2] * a[3][3]) / d;
        A.a[0][3] =
            (a[0][3] * a[1][2] * a[2][1] - a[0][2] * a[1][3] * a[2][1] -
             a[0][3] * a[1][1] * a[2][2] + a[0][1] * a[1][3] * a[2][2] +
             a[0][2] * a[1][1] * a[2][3] -
             a[0][1] * a[1][2] * a[2][3]) / d;
        A.a[1][0] =
            (a[1][3] * a[2][2] * a[3][0] - a[1][2] * a[2][3] * a[3][0] -
             a[1][3] * a[2][0] * a[3][2] + a[1][0] * a[2][3] * a[3][2] +
             a[1][2] * a[2][0] * a[3][3] -
             a[1][0] * a[2][2] * a[3][3]) / d;
        A.a[1][1] =
            (a[0][2] * a[2][3] * a[3][0] - a[0][3] * a[2][2] * a[3][0] +
             a[0][3] * a[2][0] * a[3][2] - a[0][0] * a[2][3] * a[3][2] -
             a[0][2] * a[2][0] * a[3][3] +
             a[0][0] * a[2][2] * a[3][3]) / d;
        A.a[1][2] =
            (a[0][3] * a[1][2] * a[3][0] - a[0][2] * a[1][3] * a[3][0] -
             a[0][3] * a[1][0] * a[3][2] + a[0][0] * a[1][3] * a[3][2] +
             a[0][2] * a[1][0] * a[3][3] -
             a[0][0] * a[1][2] * a[3][3]) / d;
        A.a[1][3] =
            (a[0][2] * a[1][3] * a[2][0] - a[0][3] * a[1][2] * a[2][0] +
             a[0][3] * a[1][0] * a[2][2] - a[0][0] * a[1][3] * a[2][2] -
             a[0][2] * a[1][0] * a[2][3] +
             a[0][0] * a[1][2] * a[2][3]) / d;
        A.a[2][0] =
            (a[1][1] * a[2][3] * a[3][0] - a[1][3] * a[2][1] * a[3][0] +
             a[1][3] * a[2][0] * a[3][1] - a[1][0] * a[2][3] * a[3][1] -
             a[1][1] * a[2][0] * a[3][3] +
             a[1][0] * a[2][1] * a[3][3]) / d;
        A.a[2][1] =
            (a[0][3] * a[2][1] * a[3][0] - a[0][1] * a[2][3] * a[3][0] -
             a[0][3] * a[2][0] * a[3][1] + a[0][0] * a[2][3] * a[3][1] +
             a[0][1] * a[2][0] * a[3][3] -
             a[0][0] * a[2][1] * a[3][3]) / d;
        A.a[2][2] =
            (a[0][1] * a[1][3] * a[3][0] - a[0][3] * a[1][1] * a[3][0] +
             a[0][3] * a[1][0] * a[3][1] - a[0][0] * a[1][3] * a[3][1] -
             a[0][1] * a[1][0] * a[3][3] +
             a[0][0] * a[1][1] * a[3][3]) / d;
        A.a[2][3] =
            (a[0][3] * a[1][1] * a[2][0] - a[0][1] * a[1][3] * a[2][0] -
             a[0][3] * a[1][0] * a[2][1] + a[0][0] * a[1][3] * a[2][1] +
             a[0][1] * a[1][0] * a[2][3] -
             a[0][0] * a[1][1] * a[2][3]) / d;
        A.a[3][0] =
            (a[1][2] * a[2][1] * a[3][0] - a[1][1] * a[2][2] * a[3][0] -
             a[1][2] * a[2][0] * a[3][1] + a[1][0] * a[2][2] * a[3][1] +
             a[1][1] * a[2][0] * a[3][2] -
             a[1][0] * a[2][1] * a[3][2]) / d;
        A.a[3][1] =
            (a[0][1] * a[2][2] * a[3][0] - a[0][2] * a[2][1] * a[3][0] +
             a[0][2] * a[2][0] * a[3][1] - a[0][0] * a[2][2] * a[3][1] -
             a[0][1] * a[2][0] * a[3][2] +
             a[0][0] * a[2][1] * a[3][2]) / d;
        A.a[3][2] =
            (a[0][2] * a[1][1] * a[3][0] - a[0][1] * a[1][2] * a[3][0] -
             a[0][2] * a[1][0] * a[3][1] + a[0][0] * a[1][2] * a[3][1] +
             a[0][1] * a[1][0] * a[3][2] -
             a[0][0] * a[1][1] * a[3][2]) / d;
        A.a[3][3] =
            (a[0][1] * a[1][2] * a[2][0] - a[0][2] * a[1][1] * a[2][0] +
             a[0][2] * a[1][0] * a[2][1] - a[0][0] * a[1][2] * a[2][1] -
             a[0][1] * a[1][0] * a[2][2] +
             a[0][0] * a[1][1] * a[2][2]) / d;
        
        return A;
    }
    
    public Matrix4x4 times(Matrix4x4 B) {
        Matrix4x4 R = new Matrix4x4();
        int i, j, k;
        
        for (i = 0; i < 4; i++) {
            for (j = 0; j < 4; j++) {
                for (k = 0; k < 4; k++) {
                    R.a[i][j] += a[i][k] * B.a[k][j];
                }
            }
        }
        
        return R;
    }
    
    public double get(int i, int j) {
        return a[i][j];
    }
    
    public void set(int i, int j, double v) {
        a[i][j] = v;
    }
}