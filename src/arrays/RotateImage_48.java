package arrays;

public class RotateImage_48 {
    public static void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n/2;i++){
            for(int j=i;j<n-i-1;j++){
                int t=matrix[i][j];
                matrix[i][j]=matrix[n-1-j][i];
                matrix[n-1-j][i]=matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=t;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}, {13,14,15,16}};

        rotate(matrix);

    }
}
