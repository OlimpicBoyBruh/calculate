package ru.sberbank.jd.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sberbank.jd.dto.SalaryDto;
import ru.sberbank.jd.model.AmountVacationPay;
import ru.sberbank.jd.service.CalculateService;


@RestController
@AllArgsConstructor
public class CalculateController {
    private final CalculateService calculateService;

    @GetMapping("/calculate")
    public ResponseEntity<AmountVacationPay> calculateVacation(@RequestBody SalaryDto salaryDto) {
        return ResponseEntity.ok(calculateService.paymentCalculation(salaryDto));
    }


}
