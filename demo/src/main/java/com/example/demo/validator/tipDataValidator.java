package com.example.demo.validator;

import com.example.demo.model.tipData;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class tipDataValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return tipData.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        tipData formData = (tipData) target;

        if (formData.getReceiptAmount() != null && formData.getReceiptAmount() < 1) {
            errors.rejectValue("receiptAmount", "Min.tipData.receiptAmount");
        }
        
        if (formData.getTipPercentage() != null && formData.getTipPercentage() <= 0) {
            errors.rejectValue("tipPercentage", "NotEmpty.tipData.tipPercentage");
        }
        
        if (formData.getCheckboxSelection() == null || formData.getCheckboxSelection().isEmpty()) {
            errors.rejectValue("checkboxSelection", "NotEmpty.tipData.checkboxSelection");
        }
        
        if (formData.getDropDownMenu() == null || formData.getDropDownMenu().trim().isEmpty()) {
            errors.rejectValue("dropDownMenu", "NotEmpty.tipData.dropDownMenu");
        }

        // Include additional validation logic as necessary
    }
}
