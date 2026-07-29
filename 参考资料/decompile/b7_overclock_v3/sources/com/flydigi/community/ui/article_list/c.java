package com.flydigi.community.ui.article_list;

import com.blankj.utilcode.util.n0;
import kotlin.jvm.internal.f0;
import m9.t;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    @yt.k
    public static final String a(@yt.k String str) {
        f0.p(str, "<this>");
        String strI = t.i(str);
        if (!n0.x(strI)) {
            return str;
        }
        String strC = a5.b.c(strI);
        f0.o(strC, "{\n        DeviceManager.…uctName(deviceCode)\n    }");
        return strC;
    }
}
