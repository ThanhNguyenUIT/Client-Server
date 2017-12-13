public class StudentService {

    private StudentDao studentDao = new StudentDao();

    public List<Student> getStudents () {
        return studentDao.readStudents();
    }
}