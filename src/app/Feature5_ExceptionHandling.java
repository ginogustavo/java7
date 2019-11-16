package app;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.SQLException;

import javax.sql.ConnectionEvent;

class Feature5_ExceptionHandling {

    public void oldMethod() {
        try {
            methodThrowsExceptions();
        } catch (ArrayIndexOutOfBoundsException e) {
            // catchs and handle exception 1
        } catch (IOException e) {
            // catchs and handle exception 2
        } catch (SQLException e) {
            // catchs and handle exception 3
        } catch (Exception e) {
            // catchs and handle exception 4
        }
    }

    public void methodThrowsExceptions() throws IOException, SQLException {
    }

    /**
     * Improved Exception Handled
     */
    public void catchExceptions() {
        try {
            methodThrowsExceptions();
        } catch (IOException | SQLException | ArrayIndexOutOfBoundsException e) {
            // log and deal with all exceptions
        }

        // Grouping types of exception using multi multi-catch blocks

        try {
            methodThrowsExceptions();
        } catch (SQLException | ConnectException e) {
            // TODO: handle exception
        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            // TODO: handle exception
        } catch (IOException e) {
            // TODO: handle exception
        }

    }

}