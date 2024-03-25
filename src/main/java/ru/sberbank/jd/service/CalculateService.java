package ru.sberbank.jd.service;

import org.springframework.stereotype.Service;
import ru.sberbank.jd.dto.SalaryDto;
import ru.sberbank.jd.model.AmountVacationPay;
import java.text.DecimalFormat;


@Service
public class CalculateService {
    public AmountVacationPay paymentCalculation(SalaryDto salaryDto) {
        if (salaryDto.getAmount() <= 0 || salaryDto.getNumberDays() <= 0) {
            throw  new IllegalArgumentException("Значения не могут быть меньше либо равно 0");
        }

        DecimalFormat rounding = new DecimalFormat("#.##");
        double totalAmount = salaryDto.getNumberDays() * (salaryDto.getAmount() / 29.3);
        String formattedNumber = rounding.format(totalAmount).replace(",", ".");
        return new AmountVacationPay(Double.parseDouble(formattedNumber));
    }
}
