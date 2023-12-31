public class Person
{
    private String ID;

    private String fName;

    private String lName;

    private String title;

    private int YOB;

    public Person(String ID, String fName, String lName, String title, int YOB) {
        this.ID = ID;
        this.fName = fName;
        this.lName = lName;
        this.title = title;
        this.YOB = YOB;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    public String toCSV()
    {

        return ID + ", " + fName + ", " + lName + ", " + title + ", " + YOB;
    }
    public String getFullName()
    {

        return  fName + " " + lName;
    }
    public String getFormalName()
    {

        return  title + " " + fName + " " + lName;
    }
    public int getAge() {return  2023 - YOB ; }
    public int getAge(int year){return YOB;}

}
