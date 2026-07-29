package xn;

import gm.c0;
import gm.h;
import gm.h0;
import gm.i;
import gm.j2;
import gm.l2;
import gm.w;
import gm.y;

/* JADX INFO: loaded from: classes5.dex */
public class c extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h0 f55655a;

    public c(h0 h0Var) {
        this.f55655a = h0Var;
    }

    public c(y yVar, h hVar) {
        i iVar = new i(2);
        iVar.a(yVar);
        iVar.a(hVar);
        this.f55655a = new l2(new j2(iVar));
    }

    public c(a aVar) {
        this.f55655a = new l2(aVar);
    }

    public c(a[] aVarArr) {
        this.f55655a = new l2(aVarArr);
    }

    public static c A(Object obj) {
        if (obj instanceof c) {
            return (c) obj;
        }
        if (obj != null) {
            return new c(h0.I(obj));
        }
        return null;
    }

    public a[] B() {
        int size = this.f55655a.size();
        a[] aVarArr = new a[size];
        for (int i10 = 0; i10 != size; i10++) {
            aVarArr[i10] = a.x(this.f55655a.J(i10));
        }
        return aVarArr;
    }

    public boolean C() {
        return this.f55655a.size() > 1;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f55655a;
    }

    public int size() {
        return this.f55655a.size();
    }

    public int x(y[] yVarArr, int i10) {
        int size = this.f55655a.size();
        for (int i11 = 0; i11 < size; i11++) {
            yVarArr[i10 + i11] = a.x(this.f55655a.J(i11)).y();
        }
        return size;
    }

    public boolean y(y yVar) {
        int size = this.f55655a.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (a.x(this.f55655a.J(i10)).y().C(yVar)) {
                return true;
            }
        }
        return false;
    }

    public a z() {
        if (this.f55655a.size() == 0) {
            return null;
        }
        return a.x(this.f55655a.J(0));
    }
}
