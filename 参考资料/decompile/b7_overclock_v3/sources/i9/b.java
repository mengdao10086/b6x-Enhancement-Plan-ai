package i9;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.flydigi.baseProvider.IRemoteProvider;
import i9.a;
import kotlin.jvm.internal.f0;
import yt.k;

/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public static final void a(@k Context context, @k String action) {
        f0.p(context, "<this>");
        f0.p(action, "action");
        Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
        f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
        ((IRemoteProvider) objNavigation).c(context, action);
    }

    public static final void b(@k View view, @k String action) {
        f0.p(view, "<this>");
        f0.p(action, "action");
        Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
        f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
        ((IRemoteProvider) objNavigation).c(view.getContext(), action);
    }

    public static final void c(@k Fragment fragment, @k String action) {
        f0.p(fragment, "<this>");
        f0.p(action, "action");
        Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
        f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
        ((IRemoteProvider) objNavigation).c(fragment.X1(), action);
    }

    public static final void d(@k Context context, @k String action) {
        f0.p(context, "<this>");
        f0.p(action, "action");
        Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
        f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
        ((IRemoteProvider) objNavigation).l(context, action);
    }

    public static final void e(@k View view, @k String action) {
        f0.p(view, "<this>");
        f0.p(action, "action");
        Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
        f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
        ((IRemoteProvider) objNavigation).l(view.getContext(), action);
    }

    public static final void f(@k Fragment fragment, @k String action) {
        f0.p(fragment, "<this>");
        f0.p(action, "action");
        Object objNavigation = h3.a.j().d(a.g.f31983b).navigation();
        f0.n(objNavigation, "null cannot be cast to non-null type com.flydigi.baseProvider.IRemoteProvider");
        ((IRemoteProvider) objNavigation).l(fragment.X1(), action);
    }
}
