package opt.example;

import shared.Instance;

/**
 * An implementation of the traveling salesman problem
 * where the encoding used is a permutation of [0, ..., n]
 * where there are n+1 cities.  That is the encoding
 * is just the path to take.
 * @author Andrew Guillory gtg008g@mail.gatech.edu
 * @version 1.0
 */
public class TravelingSalesmanRouteEvaluationFunction extends TravelingSalesmanEvaluationFunction implements CountsEvals {

    /**
     * Make a new route evaluation function
     * @param points the points of the cities
     */
    public TravelingSalesmanRouteEvaluationFunction(double[][] points) {
        super(points);
    }

    private long evaluations;

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
        double distance = 0;
        for (int i = 0; i < d.size() - 1; i++) {
            distance += getDistance(d.getDiscrete(i), d.getDiscrete(i+1));
        }
        distance += getDistance(d.getDiscrete(d.size() - 1), d.getDiscrete(0));
        return 1/distance;
    }


}
