import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculateAllTypeTax{
    public static BigDecimal calculateTaxes(BigDecimal taxType, BigDecimal value) {
        BigDecimal taxedItem =taxType.multiply(value) ;
        taxedItem = taxedItem.multiply(new BigDecimal("20")).setScale(0, RoundingMode.UP).setScale(2);
        taxedItem = taxedItem.divide(new BigDecimal("20"), RoundingMode.UP);
        return taxedItem;
    }
}

