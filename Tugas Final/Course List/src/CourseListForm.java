import javax.swing.*;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CourseListForm extends JDialog {
    private JTextField CName;
    private JTextField CNumber;
    private JTextField CEnrollment;
    private JTextField CStart;
    private JTextField CEnd;
    private JButton btnAdd;
    private JButton btnCancel;
    private JPanel courselistlPanel;
    private JButton btnShow;


    public CourseListForm(JFrame parent) {
        super(parent);
        setTitle("Course List");
        setContentPane(courselistlPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GetCourse();
            }
        });
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ShowCourseList show;
                show = new ShowCourseList();
                show.setVisible(true);

            }

        });

        setVisible(true);

    }


    private void GetCourse() {
        String course_name = CName.getText();
        String course_number = CNumber.getText();
        String course_enrollment = CEnrollment.getText();
        String course_start = CStart.getText();
        String course_end = CEnd.getText();
        if (course_name.isEmpty() || course_number.isEmpty() || course_enrollment.isEmpty() || course_start.isEmpty() || course_end.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please enter all fields",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        cr = addCourseToDatabase(course_name, course_number, course_enrollment, course_start, course_end);
        if (cr != null) {
            dispose();
        }
        else {
            JOptionPane.showMessageDialog(this,
                    "Failed to add course",
                    "Try again",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public CrList cr;
    private CrList addCourseToDatabase(String course_name, String course_number, String course_enrollment, String course_start, String course_end) {
        CrList cr = null;
        final String DB_URL = "jdbc:mysql://localhost/courselist_db";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try{
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            // Connected to database successfully...

            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO allcourse (course_name, course_number, course_enrollment, course_start, course_end) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, course_name);
            preparedStatement.setString(2, course_number);
            preparedStatement.setString(3, course_enrollment);
            preparedStatement.setString(4, course_start);
            preparedStatement.setString(5, course_end);

            //Insert row into the table
            int addedRows = preparedStatement.executeUpdate();
            if (addedRows > 0) {
                cr = new CrList();
                cr.course_name = course_name;
                cr.course_number = course_number;
                cr.course_enrollment = course_enrollment;
                cr.course_start = course_start;
                cr.course_end = course_end;
            }
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return cr;
    }

    public static void main(String[] args) {
        CourseListForm myForm = new CourseListForm(null);
        CrList cr = myForm.cr;
        if (cr != null) {
            System.out.println("\n" + "Successful to Add : " + cr.course_name);
        }
        else {
            System.out.println("\n" + "Exit");
        }
    }
}
