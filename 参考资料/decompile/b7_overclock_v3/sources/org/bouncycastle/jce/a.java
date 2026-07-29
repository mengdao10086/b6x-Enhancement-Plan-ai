package org.bouncycastle.jce;

import co.l;
import gm.y;
import java.util.Enumeration;

/* JADX INFO: loaded from: classes5.dex */
public class a {
    public static Enumeration a() {
        return qm.b.i();
    }

    public static gr.c b(String str) {
        l lVarE = qm.b.e(str);
        if (lVarE == null) {
            try {
                lVarE = qm.b.g(new y(str));
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (lVarE == null) {
            return null;
        }
        return new gr.c(str, lVarE.y(), lVarE.B(), lVarE.E(), lVarE.C(), lVarE.F());
    }
}
