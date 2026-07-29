package zn;

import gm.c2;
import gm.i2;
import gm.p2;
import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
public class s1 extends x1 {
    @Override // zn.x1
    public gm.c0 c(gm.y yVar, String str) {
        if (str.length() == 0 || str.charAt(0) != '#') {
            if (str.length() != 0 && str.charAt(0) == '\\') {
                str = str.substring(1);
            }
            return (yVar.C(w1.f59041v2) || yVar.C(w1.F7)) ? new c2(str) : yVar.C(w1.A) ? new gm.z1(str) : (yVar.C(w1.f59023h) || yVar.C(w1.f59030m) || yVar.C(w1.f59044y) || yVar.C(w1.C1)) ? new i2(str) : new p2(str);
        }
        try {
            return b(str, 1);
        } catch (IOException unused) {
            throw new RuntimeException("can't recode value for oid " + yVar.L());
        }
    }
}
