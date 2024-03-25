package ru.sberbank.jd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.sberbank.jd.dto.SalaryDto;
import ru.sberbank.jd.service.CalculateService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class CalculateServiceTest {
    private CalculateService calculateService;

    @BeforeEach
    public void init() {
        calculateService = new CalculateService();
    }

    @Test
    public void correctSalaryDtoTest() {
        SalaryDto salaryDto = new SalaryDto(50000, 14);
        assertEquals(23890.78, calculateService.paymentCalculation(salaryDto).getAmount());
    }

    @Test
    public void exceptionSalaryServiceTest() {
        SalaryDto salaryDto = new SalaryDto(-50000, 14);
        assertThrows(IllegalArgumentException.class, () -> calculateService.paymentCalculation(salaryDto));
    }

    @Test
    public void exceptionDayServiceTest() {
        SalaryDto salaryDto = new SalaryDto(50000, -14);
        assertThrows(IllegalArgumentException.class, () -> calculateService.paymentCalculation(salaryDto));
    }
}
