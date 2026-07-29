package androidx.fragment.app;

import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a3\u0010\b\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001a3\u0010\t\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086\bø\u0001\u0000\u001a=\u0010\u000b\u001a\u00020\u0005*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"Landroidx/fragment/app/FragmentManager;", "", "allowStateLoss", "Lkotlin/Function1;", "Landroidx/fragment/app/g0;", "Lkotlin/z1;", "Lkotlin/t;", "body", "a", "c", "now", "e", "fragment-ktx_release"}, k = 2, mv = {1, 6, 0})
public final class w {
    public static final void a(@yt.k FragmentManager fragmentManager, boolean z10, @yt.k ik.l<? super g0, z1> body) {
        kotlin.jvm.internal.f0.p(fragmentManager, "<this>");
        kotlin.jvm.internal.f0.p(body, "body");
        g0 g0VarU = fragmentManager.u();
        kotlin.jvm.internal.f0.o(g0VarU, "beginTransaction()");
        body.i(g0VarU);
        if (z10) {
            g0VarU.r();
        } else {
            g0VarU.q();
        }
    }

    public static /* synthetic */ void b(FragmentManager fragmentManager, boolean z10, ik.l body, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        kotlin.jvm.internal.f0.p(fragmentManager, "<this>");
        kotlin.jvm.internal.f0.p(body, "body");
        g0 g0VarU = fragmentManager.u();
        kotlin.jvm.internal.f0.o(g0VarU, "beginTransaction()");
        body.i(g0VarU);
        if (z10) {
            g0VarU.r();
        } else {
            g0VarU.q();
        }
    }

    public static final void c(@yt.k FragmentManager fragmentManager, boolean z10, @yt.k ik.l<? super g0, z1> body) {
        kotlin.jvm.internal.f0.p(fragmentManager, "<this>");
        kotlin.jvm.internal.f0.p(body, "body");
        g0 g0VarU = fragmentManager.u();
        kotlin.jvm.internal.f0.o(g0VarU, "beginTransaction()");
        body.i(g0VarU);
        if (z10) {
            g0VarU.t();
        } else {
            g0VarU.s();
        }
    }

    public static /* synthetic */ void d(FragmentManager fragmentManager, boolean z10, ik.l body, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        kotlin.jvm.internal.f0.p(fragmentManager, "<this>");
        kotlin.jvm.internal.f0.p(body, "body");
        g0 g0VarU = fragmentManager.u();
        kotlin.jvm.internal.f0.o(g0VarU, "beginTransaction()");
        body.i(g0VarU);
        if (z10) {
            g0VarU.t();
        } else {
            g0VarU.s();
        }
    }

    @kotlin.k(message = "Use commit { .. } or commitNow { .. } extensions")
    public static final void e(@yt.k FragmentManager fragmentManager, boolean z10, boolean z11, @yt.k ik.l<? super g0, z1> body) {
        kotlin.jvm.internal.f0.p(fragmentManager, "<this>");
        kotlin.jvm.internal.f0.p(body, "body");
        g0 g0VarU = fragmentManager.u();
        kotlin.jvm.internal.f0.o(g0VarU, "beginTransaction()");
        body.i(g0VarU);
        if (z10) {
            if (z11) {
                g0VarU.t();
                return;
            } else {
                g0VarU.s();
                return;
            }
        }
        if (z11) {
            g0VarU.r();
        } else {
            g0VarU.q();
        }
    }

    public static /* synthetic */ void f(FragmentManager fragmentManager, boolean z10, boolean z11, ik.l body, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        kotlin.jvm.internal.f0.p(fragmentManager, "<this>");
        kotlin.jvm.internal.f0.p(body, "body");
        g0 g0VarU = fragmentManager.u();
        kotlin.jvm.internal.f0.o(g0VarU, "beginTransaction()");
        body.i(g0VarU);
        if (z10) {
            if (z11) {
                g0VarU.t();
                return;
            } else {
                g0VarU.s();
                return;
            }
        }
        if (z11) {
            g0VarU.r();
        } else {
            g0VarU.q();
        }
    }
}
