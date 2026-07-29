package xn;

import gm.h;
import gm.y;
import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f55662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Vector f55663b;

    public e() {
        this(yn.c.Q);
    }

    public e(f fVar) {
        this.f55663b = new Vector();
        this.f55662a = fVar;
    }

    public e a(y[] yVarArr, h[] hVarArr) {
        a[] aVarArr = new a[yVarArr.length];
        for (int i10 = 0; i10 != yVarArr.length; i10++) {
            aVarArr[i10] = new a(yVarArr[i10], hVarArr[i10]);
        }
        return c(aVarArr);
    }

    public e b(y[] yVarArr, String[] strArr) {
        int length = strArr.length;
        h[] hVarArr = new h[length];
        for (int i10 = 0; i10 != length; i10++) {
            hVarArr[i10] = this.f55662a.f(yVarArr[i10], strArr[i10]);
        }
        return a(yVarArr, hVarArr);
    }

    public e c(a[] aVarArr) {
        this.f55663b.addElement(new c(aVarArr));
        return this;
    }

    public e d(y yVar, h hVar) {
        this.f55663b.addElement(new c(yVar, hVar));
        return this;
    }

    public e e(y yVar, String str) {
        d(yVar, this.f55662a.f(yVar, str));
        return this;
    }

    public e f(a aVar) {
        this.f55663b.addElement(new c(aVar));
        return this;
    }

    public d g() {
        int size = this.f55663b.size();
        c[] cVarArr = new c[size];
        for (int i10 = 0; i10 != size; i10++) {
            cVarArr[i10] = (c) this.f55663b.elementAt(i10);
        }
        return new d(this.f55662a, cVarArr);
    }
}
