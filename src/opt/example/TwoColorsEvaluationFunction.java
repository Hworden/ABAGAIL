package opt.example;

import util.linalg.Vector;
import opt.EvaluationFunction;
import shared.Instance;

/**
 * A function that evaluates whether a vector represents a 2-colored graph
 * @author Daniel Cohen dcohen@gatech.edu
 * @version 1.0
 */
public class TwoColorsEvaluationFunction implements EvaluationFunction, CountsEvals {

    public long evaluations;

    public long getEvals() {
        return evaluations;
    }

    public void resetEvals() {
        evaluations = 0;
    }

    public double value(Instance d) {
        evaluations++;
        return _value(d);
    }

    /**
     * @see opt.EvaluationFunction#value(opt.OptimizationData)
     */
    public double _value(Instance d) {
        Vector data = d.getData();
        double val = 0;
        for (int i = 1; i < data.size() - 1; i++) {
            if ((data.get(i) != data.get(i-1)) && (data.get(i) != data.get(i+1))) {
                val++;
            }
        }

        return val;
    }

}
