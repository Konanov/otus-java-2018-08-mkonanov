package ru.otus;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Month;

@Getter
@AllArgsConstructor
@SuppressWarnings("WeakerAccess")
public class MonthlyIncome {
    private Month month;
    private int income;
}
