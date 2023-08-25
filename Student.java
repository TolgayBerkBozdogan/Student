public class Student {
    String name, stuNo;
    int classes;
    Course mat;
    Course fizik;
    Course kimya;
    double average;
    boolean isPass;

    Student(String name, String stuNo, int classes, Course mat, Course fizik, Course kimya) {
        this.name = name;
        this.stuNo = stuNo;
        this.classes = classes;
        this.mat = mat;
        this.kimya = kimya;
        this.fizik = fizik;
        calcAvarage();
        this.isPass = false;
    }

    public void addBulkExamNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }
        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }
        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }

    }

    public void isPass() {
        if (this.mat.note == 0 || this.kimya.note == 0 || this.fizik.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş.");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.average);
            if (this.isPass) {
                System.out.println("Sınıfı geçti. ");
            } else {
                System.out.println("Sınıfta kaldı. ");
            }

        }

    }

    public void calcAvarage() {
        this.average = (this.fizik.note + this.mat.note + this.kimya.note) / 3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.average > 55;
    }

    void printNote() {
        System.out.println("==================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
        System.out.println("Fizik Notu : " + this.fizik.note);

    }
}
