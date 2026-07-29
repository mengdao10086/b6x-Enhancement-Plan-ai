package ya;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import ya.j;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public final class o {
    @Deprecated
    public static n a(Context context, o1[] o1VarArr, ad.j jVar) {
        return b(context, o1VarArr, jVar, new k());
    }

    @Deprecated
    public static n b(Context context, o1[] o1VarArr, ad.j jVar, u0 u0Var) {
        return c(context, o1VarArr, jVar, u0Var, hd.u0.X());
    }

    @Deprecated
    public static n c(Context context, o1[] o1VarArr, ad.j jVar, u0 u0Var, Looper looper) {
        return d(context, o1VarArr, jVar, u0Var, ed.n.l(context), looper);
    }

    @Deprecated
    public static n d(Context context, o1[] o1VarArr, ad.j jVar, u0 u0Var, ed.d dVar, Looper looper) {
        return new m0(o1VarArr, jVar, new com.google.android.exoplayer2.source.e(context), u0Var, dVar, null, true, t1.f57074g, new j.b().a(), 500L, false, hd.c.f30965a, looper, null);
    }

    @Deprecated
    public static u1 e(Context context) {
        return f(context, new DefaultTrackSelector(context));
    }

    @Deprecated
    public static u1 f(Context context, ad.j jVar) {
        return j(context, new m(context), jVar);
    }

    @Deprecated
    public static u1 g(Context context, ad.j jVar, u0 u0Var) {
        return k(context, new m(context), jVar, u0Var);
    }

    @Deprecated
    public static u1 h(Context context, ad.j jVar, u0 u0Var, int i10) {
        return k(context, new m(context).q(i10), jVar, u0Var);
    }

    @Deprecated
    public static u1 i(Context context, ad.j jVar, u0 u0Var, int i10, long j10) {
        return k(context, new m(context).q(i10).l(j10), jVar, u0Var);
    }

    @Deprecated
    public static u1 j(Context context, s1 s1Var, ad.j jVar) {
        return k(context, s1Var, jVar, new k());
    }

    @Deprecated
    public static u1 k(Context context, s1 s1Var, ad.j jVar, u0 u0Var) {
        return l(context, s1Var, jVar, u0Var, hd.u0.X());
    }

    @Deprecated
    public static u1 l(Context context, s1 s1Var, ad.j jVar, u0 u0Var, Looper looper) {
        return p(context, s1Var, jVar, u0Var, new za.f1(hd.c.f30965a), looper);
    }

    @Deprecated
    public static u1 m(Context context, s1 s1Var, ad.j jVar, u0 u0Var, ed.d dVar) {
        return n(context, s1Var, jVar, u0Var, dVar, new za.f1(hd.c.f30965a), hd.u0.X());
    }

    @Deprecated
    public static u1 n(Context context, s1 s1Var, ad.j jVar, u0 u0Var, ed.d dVar, za.f1 f1Var, Looper looper) {
        return new u1(context, s1Var, jVar, new com.google.android.exoplayer2.source.e(context), u0Var, dVar, f1Var, true, hd.c.f30965a, looper);
    }

    @Deprecated
    public static u1 o(Context context, s1 s1Var, ad.j jVar, u0 u0Var, za.f1 f1Var) {
        return p(context, s1Var, jVar, u0Var, f1Var, hd.u0.X());
    }

    @Deprecated
    public static u1 p(Context context, s1 s1Var, ad.j jVar, u0 u0Var, za.f1 f1Var, Looper looper) {
        return n(context, s1Var, jVar, u0Var, ed.n.l(context), f1Var, looper);
    }
}
