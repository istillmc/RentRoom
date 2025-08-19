package org.atgalway.lease.web.admin.custom.converter;

import org.atgalway.lease.model.enums.ItemType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToItemTypeConverter implements Converter<String, ItemType> {

    @Override
    public ItemType convert(String source) {
        ItemType[] values = ItemType.values();
        for (ItemType value : values) {
            if (value.getCode().equals(Integer.valueOf(source))) {
                return value;
            }

        }
        throw new IllegalArgumentException("Invalid item type: " + source);
    }
}
