package zn;

import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
public class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Vector f58687a = new Vector();

    public d0 a(b0 b0Var) {
        this.f58687a.addElement(b0Var);
        return this;
    }

    public d0 b(c0 c0Var) {
        b0[] b0VarArrB = c0Var.B();
        for (int i10 = 0; i10 != b0VarArrB.length; i10++) {
            this.f58687a.addElement(b0VarArrB[i10]);
        }
        return this;
    }

    public c0 c() {
        int size = this.f58687a.size();
        b0[] b0VarArr = new b0[size];
        for (int i10 = 0; i10 != size; i10++) {
            b0VarArr[i10] = (b0) this.f58687a.elementAt(i10);
        }
        return new c0(b0VarArr);
    }
}
