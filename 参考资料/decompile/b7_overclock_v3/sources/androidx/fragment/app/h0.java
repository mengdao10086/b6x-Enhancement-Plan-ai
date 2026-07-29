package androidx.fragment.app;

import android.os.Bundle;
import com.umeng.socialize.net.dplus.CommonNetImpl;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\t\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0086\b\u001a-\u0010\n\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0086\b\u001a;\u0010\u000b\u001a\u00020\u0002\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0086\b¨\u0006\f"}, d2 = {"Landroidx/fragment/app/Fragment;", "F", "Landroidx/fragment/app/g0;", "", "containerViewId", "", CommonNetImpl.TAG, "Landroid/os/Bundle;", "args", "a", "b", "e", "fragment-ktx_release"}, k = 2, mv = {1, 6, 0})
public final class h0 {
    public static final /* synthetic */ <F extends Fragment> g0 a(g0 g0Var, @g.d0 int i10, String str, Bundle bundle) {
        kotlin.jvm.internal.f0.p(g0Var, "<this>");
        kotlin.jvm.internal.f0.y(4, "F");
        g0 g0VarI = g0Var.i(i10, Fragment.class, bundle, str);
        kotlin.jvm.internal.f0.o(g0VarI, "add(containerViewId, F::class.java, args, tag)");
        return g0VarI;
    }

    public static final /* synthetic */ <F extends Fragment> g0 b(g0 g0Var, String tag, Bundle bundle) {
        kotlin.jvm.internal.f0.p(g0Var, "<this>");
        kotlin.jvm.internal.f0.p(tag, "tag");
        kotlin.jvm.internal.f0.y(4, "F");
        g0 g0VarL = g0Var.l(Fragment.class, bundle, tag);
        kotlin.jvm.internal.f0.o(g0VarL, "add(F::class.java, args, tag)");
        return g0VarL;
    }

    public static /* synthetic */ g0 c(g0 g0Var, int i10, String str, Bundle bundle, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            bundle = null;
        }
        kotlin.jvm.internal.f0.p(g0Var, "<this>");
        kotlin.jvm.internal.f0.y(4, "F");
        g0 g0VarI = g0Var.i(i10, Fragment.class, bundle, str);
        kotlin.jvm.internal.f0.o(g0VarI, "add(containerViewId, F::class.java, args, tag)");
        return g0VarI;
    }

    public static /* synthetic */ g0 d(g0 g0Var, String tag, Bundle bundle, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            bundle = null;
        }
        kotlin.jvm.internal.f0.p(g0Var, "<this>");
        kotlin.jvm.internal.f0.p(tag, "tag");
        kotlin.jvm.internal.f0.y(4, "F");
        g0 g0VarL = g0Var.l(Fragment.class, bundle, tag);
        kotlin.jvm.internal.f0.o(g0VarL, "add(F::class.java, args, tag)");
        return g0VarL;
    }

    public static final /* synthetic */ <F extends Fragment> g0 e(g0 g0Var, @g.d0 int i10, String str, Bundle bundle) {
        kotlin.jvm.internal.f0.p(g0Var, "<this>");
        kotlin.jvm.internal.f0.y(4, "F");
        g0 g0VarF = g0Var.F(i10, Fragment.class, bundle, str);
        kotlin.jvm.internal.f0.o(g0VarF, "replace(containerViewId, F::class.java, args, tag)");
        return g0VarF;
    }

    public static /* synthetic */ g0 f(g0 g0Var, int i10, String str, Bundle bundle, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = null;
        }
        if ((i11 & 4) != 0) {
            bundle = null;
        }
        kotlin.jvm.internal.f0.p(g0Var, "<this>");
        kotlin.jvm.internal.f0.y(4, "F");
        g0 g0VarF = g0Var.F(i10, Fragment.class, bundle, str);
        kotlin.jvm.internal.f0.o(g0VarF, "replace(containerViewId, F::class.java, args, tag)");
        return g0VarF;
    }
}
