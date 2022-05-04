package labs.lab0;

public class Square {

    /*
     * output a square to the console
     * pseudocode :
     * 
     * for (i < lineNum; i++ ) {
     *      for (j < colNum; j++){
     *          if isFilled {
     *              printout char
     *          }else{
     *              if i==0 || i==lineNum-1 || j==0 || j==colNum-1 {
     *                  printout char
     *              }else{
     *                  printout space
     *              }
     *          }
     *          printout \n
     *      }
     * } 
     */


    public static void main(String[] args) {

        // number of rows of  square
        int lineNum = 10;

        // number of columns of square
        int colNum = 10;

        // output char
        char c = '*';

        // be filled
        boolean isFilled = false;

        // output for each line
        for (int i=0;i<lineNum;i++){
            // output for each col
            for (int j=0;j<colNum;j++){
                if (isFilled) {
                    System.out.print(c);
                }else{
                    /* first line ：i==0 
                     * last line ： i==lineNum-1
                     * first column ： j==0
                     * last column ： j==colNum-1
                     * use logical or to union them
                     */
                    if (i==0 || i==lineNum-1 || j==0 || j==colNum-1){
                        System.out.print(c);
                    }else{
                        System.out.print(' ');
                    }
                }
            }
            System.out.print('\n');
        }
    }
}
