package com.minibudget.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "income table", schema = "mini_budget", catalog = "")
public class Income {
    private int incomeId;
    private String incomeType;
    private int incomeAmount;
    private String incomeCurrency;
    private Timestamp incomeDate;
    private String incomeNotes;

    @Id
    @Column(name = "income id")
    public int getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(int incomeId) {
        this.incomeId = incomeId;
    }

    @Basic
    @Column(name = "income type")
    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
    }

    @Basic
    @Column(name = "income amount")
    public int getIncomeAmount() {
        return incomeAmount;
    }

    public void setIncomeAmount(int incomeAmount) {
        this.incomeAmount = incomeAmount;
    }

    @Basic
    @Column(name = "income currency")
    public String getIncomeCurrency() {
        return incomeCurrency;
    }

    public void setIncomeCurrency(String incomeCurrency) {
        this.incomeCurrency = incomeCurrency;
    }

    @Basic
    @Column(name = "income date")
    public Timestamp getIncomeDate() {
        return incomeDate;
    }

    public void setIncomeDate(Timestamp incomeDate) {
        this.incomeDate = incomeDate;
    }

    @Basic
    @Column(name = "income notes")
    public String getIncomeNotes() {
        return incomeNotes;
    }

    public void setIncomeNotes(String incomeNotes) {
        this.incomeNotes = incomeNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Income that = (Income) o;
        return incomeId == that.incomeId &&
                incomeAmount == that.incomeAmount &&
                Objects.equals(incomeType, that.incomeType) &&
                Objects.equals(incomeCurrency, that.incomeCurrency) &&
                Objects.equals(incomeDate, that.incomeDate) &&
                Objects.equals(incomeNotes, that.incomeNotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(incomeId, incomeType, incomeAmount, incomeCurrency, incomeDate, incomeNotes);
    }
}
