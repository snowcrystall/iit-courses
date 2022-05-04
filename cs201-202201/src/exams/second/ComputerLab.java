/*
 * Xuemin Cheng , course 201 , sec 03 , 2022/04/29
 * 
 */
package exams.second;

public class ComputerLab extends Classroom {
    private boolean computers;

    public ComputerLab() {
        super();
        this.computers = false;
    }

    public void setComputers(boolean computers) {
        this.computers = computers;
    }

    public boolean hasComputers() {
        return this.computers;
    }

    @Override
    public String toString() {
        return super.toString() + " hasComputers: " + this.computers;
    }
}
