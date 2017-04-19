import org.python.core.PyInstance;
import org.python.util.PythonInterpreter;

/**
 * Created by myron on 4/11/2017.
 */
public class Interpreter {
    private PythonInterpreter interpreter = null;


    Interpreter() {
        PythonInterpreter.initialize(System.getProperties(),
                System.getProperties(), new String[0]);

        this.interpreter = new PythonInterpreter();
    }

    void execfile( final String fileName ) {
        this.interpreter.execfile(fileName);
    }

    PyInstance createClass(final String className,
                           int championOneID,
                           int championTwoID,
                           int championThreeID,
                           int championFourID,
                           int championFiveID,
                           int championSixID,
                           int championSevenID,
                           int championEightID,
                           int championNineID,
                           int championTenID) {
//        return (PyInstance) this.interpreter.eval(className + "(" +
//                championOneID + ", '" + name.toString() + "')");
        return (PyInstance) this.interpreter.eval(className + "(" +
                championOneID + ", " +
                championTwoID + ", " +
                championThreeID + ", " +
                championFourID + ", " +
                championFiveID + ", " +
                championSixID + ", " +
                championSevenID + ", " +
                championEightID + ", " +
                championNineID + ", " +
                championTenID + ")");
    }


}
