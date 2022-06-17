import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ShowCourseList extends JDialog {
    private JPanel showPanel;
    private JTable tbCourseList;
    private JButton btnCheck;

    public ShowCourseList() {

        setTitle("Course List");
        setContentPane(showPanel);
        setMinimumSize(new Dimension(600, 500));
        setModal(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GetCourse();
            }

            private void GetCourse() {
                final String DB_URL = "jdbc:mysql://localhost/courselist_db";
                final String USERNAME = "root";
                final String PASSWORD = "";
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    Statement stmt = conn.createStatement();
                    String query = "select * from allcourse";
                    ResultSet rs = stmt.executeQuery(query);
                    ResultSetMetaData rsmd = rs.getMetaData();
                    DefaultTableModel model = (DefaultTableModel) tbCourseList.getModel();

                    int cols = rsmd.getColumnCount();
                    String[] colName = new String[cols];
                    for (int i = 0; i < cols; i++)
                        colName[i] = rsmd.getColumnName(i + 1);
                    model.setColumnIdentifiers(colName);
                    String id, course, number, enroll, start, end;
                    while (rs.next()) {
                        id = rs.getString(1);
                        course = rs.getString(2);
                        number = rs.getString(3);
                        enroll = rs.getString(4);
                        start = rs.getString(5);
                        end = rs.getString(6);
                        String[] row = {id, course, number, enroll, start, end};
                        model.addRow(row);
                    }
                    stmt.close();
                    conn.close();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }
}
