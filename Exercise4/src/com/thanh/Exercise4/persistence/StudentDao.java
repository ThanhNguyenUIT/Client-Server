public class StudentDao {

    public List<Student> readStudents () {
        return (ArrayList<Student>) JDBCStatement.readData();
    }
}