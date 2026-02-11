package com.example.contact_management.util.phonenumber;

import com.example.contact_management.config.PhoneProperties;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // NOTE: Required for constructor injection because PhoneProperties is a Spring-managed bean.
                         // Since the field is `final`, Spring must inject it via constructor.
                         // Lombok generates the constructor automatically.
public class PhoneNumberUtilService {

    private final PhoneProperties phoneProperties;

    private final PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance(); // NOTE:
                                                                                   // Since this is a library - we are instantiating it this way

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String validateAndFormat(String rawPhone) {

        try {

            Phonenumber.PhoneNumber phoneNumber =
                    phoneNumberUtil.parse(rawPhone, phoneProperties.getDefaultRegion());

            if (!phoneNumberUtil.isValidNumber(phoneNumber)) {
                throw new IllegalArgumentException("Invalid phone number");
            }

            return phoneNumberUtil.format(
                    phoneNumber,
                    PhoneNumberUtil.PhoneNumberFormat.E164
            );

        } catch (NumberParseException e) {

            throw new IllegalArgumentException("Invalid phone number format");
        }
    }
}