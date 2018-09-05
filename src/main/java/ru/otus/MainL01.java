package ru.otus;

import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

import java.util.List;

import static java.lang.String.format;
import static java.time.Month.APRIL;
import static java.time.Month.AUGUST;
import static java.time.Month.FEBRUARY;
import static java.time.Month.JANUARY;
import static java.time.Month.JULY;
import static java.time.Month.MARCH;
import static java.time.Month.MAY;
import static java.time.Month.NOVEMBER;
import static java.time.Month.OCTOBER;
import static java.time.Month.SEPTEMBER;
import static java.util.Arrays.asList;

public class MainL01 {

    private static final String OUTPUT = "Месяц: %s; Доход: %s.";

    private static final List<MonthlyIncome> monthsOne = asList(
            new MonthlyIncome(NOVEMBER, 100), new MonthlyIncome(MAY, 250),
            new MonthlyIncome(JANUARY, 400), new MonthlyIncome(AUGUST, 1500),
            new MonthlyIncome(APRIL, 327), new MonthlyIncome(SEPTEMBER, 743),
            new MonthlyIncome(FEBRUARY, 20), new MonthlyIncome(OCTOBER, 811),
            new MonthlyIncome(JULY, 944), new MonthlyIncome(MARCH, 98)
    );

    @SuppressWarnings({"IfCanBeSwitch", "unchecked"})
    public static void main(String[] args) {
        String sortBy;
        try {
            sortBy = args[0];
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Параметр сортировки не задан.");
            return;
        }
        final ComparatorChain comparatorChain = new ComparatorChain();
        if (sortBy.equals("month")) {
            comparatorChain.addComparator(new BeanComparator<MonthlyIncome>("month"));
        } else if (sortBy.equals("income")) {
            comparatorChain.addComparator(new BeanComparator<MonthlyIncome>("income"));
        } else {
            System.err.println("Укажите поле для сортировки.");
        }

        monthsOne.sort(comparatorChain);
        monthsOne.forEach((token) -> System.out.println(format(OUTPUT, token.getMonth(), token.getIncome())));
    }
}
