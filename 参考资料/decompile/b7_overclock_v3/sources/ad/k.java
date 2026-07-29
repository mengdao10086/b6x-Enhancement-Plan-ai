package ad;

import g.p0;
import hd.u0;
import ya.r1;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f571a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r1[] f572b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.exoplayer2.trackselection.b[] f573c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final Object f574d;

    public k(r1[] r1VarArr, com.google.android.exoplayer2.trackselection.b[] bVarArr, @p0 Object obj) {
        this.f572b = r1VarArr;
        this.f573c = (com.google.android.exoplayer2.trackselection.b[]) bVarArr.clone();
        this.f574d = obj;
        this.f571a = r1VarArr.length;
    }

    public boolean a(@p0 k kVar) {
        if (kVar == null || kVar.f573c.length != this.f573c.length) {
            return false;
        }
        for (int i10 = 0; i10 < this.f573c.length; i10++) {
            if (!b(kVar, i10)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(@p0 k kVar, int i10) {
        return kVar != null && u0.c(this.f572b[i10], kVar.f572b[i10]) && u0.c(this.f573c[i10], kVar.f573c[i10]);
    }

    public boolean c(int i10) {
        return this.f572b[i10] != null;
    }
}
