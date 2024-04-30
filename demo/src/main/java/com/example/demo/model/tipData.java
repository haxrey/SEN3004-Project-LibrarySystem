package com.example.demo.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

public class tipData {
    
    @Min(value = 1)
    private Double receiptAmount;
    @NotEmpty
    private Double tipPercentage;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
	private LocalDate dateField;
    @NotEmpty
	private List<String> checkboxSelection;
	@NotEmpty
	private String dropDownMenu;
    
    public Double getReceiptAmount() {
        return receiptAmount;
    }
    public void setReceiptAmount(Double receiptAmount) {
        this.receiptAmount = receiptAmount;
    }
    public Double getTipPercentage() {
        return tipPercentage;
    }
    public void setTipPercentage(Double tipPercentage) {
        this.tipPercentage = tipPercentage;
    }
    public LocalDate getDateField() {
        return dateField;
    }
    public void setDateField(LocalDate dateField) {
        this.dateField = dateField;
    }
    public List<String> getCheckboxSelection() {
        return checkboxSelection;
    }
    public void setCheckboxSelection(List<String> checkboxSelection) {
        this.checkboxSelection = checkboxSelection;
    }
    public String getDropDownMenu() {
        return dropDownMenu;
    }
    public void setDropDownMenu(String dropDownMenu) {
        this.dropDownMenu = dropDownMenu;
    }

    
}
