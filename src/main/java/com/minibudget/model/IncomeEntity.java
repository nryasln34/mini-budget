package com.minibudget.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "income", schema = "mini_budget", catalog = "")
public class IncomeEntity {
    private int id;
    private String type;
    private int amount;
    private String currency;
    private Timestamp date;
    private String notes;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "amount")
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "currency")
    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "notes")
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncomeEntity that = (IncomeEntity) o;
        return id == that.id &&
                amount == that.amount &&
                Objects.equals(type, that.type) &&
                Objects.equals(currency, that.currency) &&
                Objects.equals(date, that.date) &&
                Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, amount, currency, date, notes);
    }
}
