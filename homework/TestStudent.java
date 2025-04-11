
class TestStudent {
    // 测试代码

    public static void main(String[] args) {
        // 创建学生数组
        Student[] students = new Student[5];

        // 初始化学生对象并存储到数组中
        students[0] = new Student("001", "Alice", 'F', 20);
        students[1] = new Student("002", "Bob", 'M', 22);
        students[2] = new Student("003", "Charlie", 'M', 21);
        students[3] = new Student("004", "Diana", 'F', 19);
        students[4] = new Student("005", "Eva", 'F', 23);

        // 打印每个学生的信息
        for (Student student : students) {
            System.out.println(student);
        }

        // 打印当前学生的总数
        System.out.println("Total Students: " + Student.getTotalStudents());

    }
}
