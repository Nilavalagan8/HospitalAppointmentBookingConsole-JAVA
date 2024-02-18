import Model.*;
import View.Start;

import java.sql.SQLException;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        try {
            Start s = new Start();
            s.main();
        }
        catch (SQLException e){
            System.out.println(e);
        }

    }
}