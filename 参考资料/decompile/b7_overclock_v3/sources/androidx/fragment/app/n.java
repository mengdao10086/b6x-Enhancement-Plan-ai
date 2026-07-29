package androidx.fragment.app;

import android.os.Bundle;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001a\u0010\u0006\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003\u001a\u0012\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001aJ\u0010\r\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000126\u0010\f\u001a2\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0002\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\b\u001a\u0012\u0010\u000e\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¨\u0006\u000f"}, d2 = {"Landroidx/fragment/app/Fragment;", "", "requestKey", "Landroid/os/Bundle;", CommonNetImpl.RESULT, "Lkotlin/z1;", "d", "b", "Lkotlin/Function2;", "Lkotlin/n0;", "name", "bundle", "listener", "e", "c", "fragment-ktx_release"}, k = 2, mv = {1, 6, 0})
public final class n {
    public static final void b(@yt.k Fragment fragment, @yt.k String requestKey) {
        kotlin.jvm.internal.f0.p(fragment, "<this>");
        kotlin.jvm.internal.f0.p(requestKey, "requestKey");
        fragment.L2().d(requestKey);
    }

    public static final void c(@yt.k Fragment fragment, @yt.k String requestKey) {
        kotlin.jvm.internal.f0.p(fragment, "<this>");
        kotlin.jvm.internal.f0.p(requestKey, "requestKey");
        fragment.L2().c(requestKey);
    }

    public static final void d(@yt.k Fragment fragment, @yt.k String requestKey, @yt.k Bundle result) {
        kotlin.jvm.internal.f0.p(fragment, "<this>");
        kotlin.jvm.internal.f0.p(requestKey, "requestKey");
        kotlin.jvm.internal.f0.p(result, "result");
        fragment.L2().a(requestKey, result);
    }

    public static final void e(@yt.k Fragment fragment, @yt.k String requestKey, @yt.k final ik.p<? super String, ? super Bundle, z1> listener) {
        kotlin.jvm.internal.f0.p(fragment, "<this>");
        kotlin.jvm.internal.f0.p(requestKey, "requestKey");
        kotlin.jvm.internal.f0.p(listener, "listener");
        fragment.L2().b(requestKey, fragment, new b0() { // from class: androidx.fragment.app.m
            @Override // androidx.fragment.app.b0
            public final void a(String str, Bundle bundle) {
                n.f(listener, str, bundle);
            }
        });
    }

    public static final void f(ik.p tmp0, String p02, Bundle p12) {
        kotlin.jvm.internal.f0.p(tmp0, "$tmp0");
        kotlin.jvm.internal.f0.p(p02, "p0");
        kotlin.jvm.internal.f0.p(p12, "p1");
        tmp0.r0(p02, p12);
    }
}
