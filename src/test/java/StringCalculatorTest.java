import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringCalculatorTest {
    private StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator();
    }

    @Test
    void emptyStringOrNullReturnZeroTest() {
        String emptyString = "";
        String nullString = null;

        assertThat(stringAddCalculator.splitAndSum(emptyString)).isEqualTo(0);
        assertThat(stringAddCalculator.splitAndSum(nullString)).isEqualTo(0);

    }

    @Test
    void length_1_StringTest() {
        String numberString = "1";
        assertThat(stringAddCalculator.splitAndSum(numberString)).isEqualTo(1);
    }

    @Test
    void containCommaStringTest() {
        String commaString = "1, 2, 3";
        assertThat(stringAddCalculator.splitAndSum(commaString)).isEqualTo(6);
    }

    @Test
    void containCommaAndColonStringTest() {
        String commaColonString = "1, 2: 3";
        assertThat(stringAddCalculator.splitAndSum(commaColonString)).isEqualTo(6);
    }



    @Test
    public void customDivisionTest() throws Exception {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void negativeThrownTest() throws Exception {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
