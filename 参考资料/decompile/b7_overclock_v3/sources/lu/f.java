package lu;

import java.lang.reflect.Type;
import javax.annotation.Nullable;
import xi.h0;

/* JADX INFO: loaded from: classes6.dex */
public final class f<R> implements retrofit2.c<R, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f40472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final h0 f40473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f40474c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f40475d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f40476e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f40477f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f40478g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f40479h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f40480i;

    public f(Type type, @Nullable h0 h0Var, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16) {
        this.f40472a = type;
        this.f40473b = h0Var;
        this.f40474c = z10;
        this.f40475d = z11;
        this.f40476e = z12;
        this.f40477f = z13;
        this.f40478g = z14;
        this.f40479h = z15;
        this.f40480i = z16;
    }

    @Override // retrofit2.c
    public Type a() {
        return this.f40472a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    @Override // retrofit2.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(retrofit2.b<R> r2) {
        /*
            r1 = this;
            boolean r0 = r1.f40474c
            if (r0 == 0) goto La
            lu.b r0 = new lu.b
            r0.<init>(r2)
            goto Lf
        La:
            lu.c r0 = new lu.c
            r0.<init>(r2)
        Lf:
            boolean r2 = r1.f40475d
            if (r2 == 0) goto L1a
            lu.e r2 = new lu.e
            r2.<init>(r0)
        L18:
            r0 = r2
            goto L24
        L1a:
            boolean r2 = r1.f40476e
            if (r2 == 0) goto L24
            lu.a r2 = new lu.a
            r2.<init>(r0)
            goto L18
        L24:
            xi.h0 r2 = r1.f40473b
            if (r2 == 0) goto L2c
            xi.z r0 = r0.J5(r2)
        L2c:
            boolean r2 = r1.f40477f
            if (r2 == 0) goto L37
            io.reactivex.BackpressureStrategy r2 = io.reactivex.BackpressureStrategy.LATEST
            xi.j r2 = r0.W6(r2)
            return r2
        L37:
            boolean r2 = r1.f40478g
            if (r2 == 0) goto L40
            xi.i0 r2 = r0.l5()
            return r2
        L40:
            boolean r2 = r1.f40479h
            if (r2 == 0) goto L49
            xi.q r2 = r0.k5()
            return r2
        L49:
            boolean r2 = r1.f40480i
            if (r2 == 0) goto L52
            xi.a r2 = r0.d3()
            return r2
        L52:
            xi.z r2 = kj.a.U(r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: lu.f.b(retrofit2.b):java.lang.Object");
    }
}
