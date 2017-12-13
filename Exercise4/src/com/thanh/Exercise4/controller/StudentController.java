

public class StudentController {

    private StudentService studentService = new StudentService();

    public void processRequest(String path) {
        if (path.equals("RecieveData")) {

            System.out.println("Receive a read data request...");
            System.out.println("Sending...");

            // call to service
            List<Student> students = studentService.getStudents();

            // return data
            ObjectOutputStream output = new ObjectOutputStream(server.getOutputStream());
            output.writeObject(students);

            System.out.println("Sent!");

        } else if (path.equals("SendData")) {
            List<Student> students = new ArrayList<>();

            System.out.println("Receive a insert data request...");
            System.out.println("Inserting...");

            ObjectInputStream objectInput = new ObjectInputStream(server.getInputStream());

            students = (ArrayList<Student>) objectInput.readObject();

            Insert.insertInfo((ArrayList<Student>) students);

            System.out.println("DatabaseUtils done!");
        }
    }

}