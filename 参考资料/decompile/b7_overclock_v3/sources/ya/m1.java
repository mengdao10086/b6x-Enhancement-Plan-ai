package ya;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class m1 extends a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f56950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f56951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int[] f56952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f56953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final x1[] f56954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Object[] f56955j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final HashMap<Object, Integer> f56956k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m1(Collection<? extends b1> collection, com.google.android.exoplayer2.source.t tVar) {
        super(false, tVar);
        int iQ = 0;
        int size = collection.size();
        this.f56952g = new int[size];
        this.f56953h = new int[size];
        this.f56954i = new x1[size];
        this.f56955j = new Object[size];
        this.f56956k = new HashMap<>();
        int i10 = 0;
        int i11 = 0;
        for (b1 b1Var : collection) {
            this.f56954i[i11] = b1Var.b();
            this.f56953h[i11] = iQ;
            this.f56952g[i11] = i10;
            iQ += this.f56954i[i11].q();
            i10 += this.f56954i[i11].i();
            this.f56955j[i11] = b1Var.a();
            this.f56956k.put(this.f56955j[i11], Integer.valueOf(i11));
            i11++;
        }
        this.f56950e = iQ;
        this.f56951f = i10;
    }

    @Override // ya.a
    public int A(int i10) {
        return this.f56952g[i10];
    }

    @Override // ya.a
    public int B(int i10) {
        return this.f56953h[i10];
    }

    @Override // ya.a
    public x1 E(int i10) {
        return this.f56954i[i10];
    }

    public List<x1> F() {
        return Arrays.asList(this.f56954i);
    }

    @Override // ya.x1
    public int i() {
        return this.f56951f;
    }

    @Override // ya.x1
    public int q() {
        return this.f56950e;
    }

    @Override // ya.a
    public int t(Object obj) {
        Integer num = this.f56956k.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // ya.a
    public int u(int i10) {
        return hd.u0.i(this.f56952g, i10 + 1, false, false);
    }

    @Override // ya.a
    public int v(int i10) {
        return hd.u0.i(this.f56953h, i10 + 1, false, false);
    }

    @Override // ya.a
    public Object y(int i10) {
        return this.f56955j[i10];
    }
}
