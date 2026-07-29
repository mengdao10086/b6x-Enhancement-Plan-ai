package com.google.zxing.pdf417.decoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, Integer> f21562a = new HashMap();

    public Integer a(int i10) {
        return this.f21562a.get(Integer.valueOf(i10));
    }

    public int[] b() {
        ArrayList arrayList = new ArrayList();
        int iIntValue = -1;
        for (Map.Entry<Integer, Integer> entry : this.f21562a.entrySet()) {
            if (entry.getValue().intValue() > iIntValue) {
                iIntValue = entry.getValue().intValue();
                arrayList.clear();
                arrayList.add(entry.getKey());
            } else if (entry.getValue().intValue() == iIntValue) {
                arrayList.add(entry.getKey());
            }
        }
        return kf.a.c(arrayList);
    }

    public void c(int i10) {
        Integer num = this.f21562a.get(Integer.valueOf(i10));
        if (num == null) {
            num = 0;
        }
        this.f21562a.put(Integer.valueOf(i10), Integer.valueOf(num.intValue() + 1));
    }
}
