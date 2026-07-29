package com.flydigi.game.data;

import ag.c;
import com.blankj.utilcode.util.n0;
import io.objectbox.converter.PropertyConverter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class StringListConverter implements PropertyConverter<List<String>, String> {
    @Override // io.objectbox.converter.PropertyConverter
    public String convertToDatabaseValue(List<String> list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            sb2.append(it2.next());
            sb2.append(c.f654g);
        }
        return sb2.length() > 0 ? sb2.substring(0, sb2.length() - 1) : sb2.toString();
    }

    @Override // io.objectbox.converter.PropertyConverter
    public List<String> convertToEntityProperty(String str) {
        return n0.m(str) ? new ArrayList(0) : Arrays.asList(str.split(c.f654g));
    }
}
