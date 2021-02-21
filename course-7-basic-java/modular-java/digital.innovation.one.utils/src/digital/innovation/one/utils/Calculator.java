package digital.innovation.one.utils;

import digital.innovation.one.utils.operation.internal.DivHelper;
import digital.innovation.one.utils.operation.internal.MultHelper;
import digital.innovation.one.utils.operation.internal.SubHelper;
import digital.innovation.one.utils.operation.internal.SumHelper;

public class Calculator {

    private DivHelper divHelper;
    private MultHelper multHelper;
    private SubHelper subHelper;
    private SumHelper sumHelper;

    public Calculator() {
        this.divHelper = new DivHelper();
        this.multHelper = new MultHelper();
        this.subHelper = new SubHelper();
        this.sumHelper = new SumHelper();
    }

    public Double sum(Double a, Double b) {
        return sumHelper.execute(a, b);
    }

    public Double sub(Double a, Double b) {
        return subHelper.execute(a, b);
    }

    public Double multiply(Double a, Double b) {
        return multHelper.execute(a, b);
    }

    public Double div(Double a, Double b) {
        return divHelper.execute(a, b);
    }
}
