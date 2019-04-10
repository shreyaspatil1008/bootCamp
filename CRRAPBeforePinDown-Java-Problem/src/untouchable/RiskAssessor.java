package untouchable;

import java.math.BigDecimal;

public class RiskAssessor {

    private static RiskAssessor instance = null;

    public BigDecimal getRiskCoefficient(String family, BigDecimal assessedCeiling) {
        return new BigDecimal(family.length()).add(assessedCeiling).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static RiskAssessor getInstance() {
        if (instance == null)
            instance = new RiskAssessor();
        return instance;
    }
}
