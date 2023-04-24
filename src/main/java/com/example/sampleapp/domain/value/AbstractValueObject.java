package com.example.sampleapp.domain.value;

import lombok.EqualsAndHashCode;
import lombok.Getter;import org.springframework.validation.FieldError;import java.io.Serializable;import java.util.ArrayList;import java.util.List;


/**
 * バリューオブジェクトを実装する場合は継承すること
 *
 * @param <T>
 */
@EqualsAndHashCode
public abstract class AbstractValueObject<T> implements Serializable {

    @Getter private final List<FieldError> fieldErrorList;

    protected AbstractValueObject(){
        this.fieldErrorList = new ArrayList<>();
    }

    protected abstract T validate();

}
