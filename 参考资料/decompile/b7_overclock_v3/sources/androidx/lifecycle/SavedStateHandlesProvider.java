package androidx.lifecycle;

import android.os.Bundle;
import androidx.savedstate.b;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.jvm.internal.t0({"SMAP\nSavedStateHandleSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandlesProvider\n+ 2 _Maps.kt\nkotlin/collections/MapsKt___MapsKt\n*L\n1#1,221:1\n215#2,2:222\n*S KotlinDebug\n*F\n+ 1 SavedStateHandleSupport.kt\nandroidx/lifecycle/SavedStateHandlesProvider\n*L\n146#1:222,2\n*E\n"})
public final class SavedStateHandlesProvider implements b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final androidx.savedstate.b f6127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6128b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public Bundle f6129c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public final kotlin.z f6130d;

    public SavedStateHandlesProvider(@yt.k androidx.savedstate.b savedStateRegistry, @yt.k final d1 viewModelStoreOwner) {
        kotlin.jvm.internal.f0.p(savedStateRegistry, "savedStateRegistry");
        kotlin.jvm.internal.f0.p(viewModelStoreOwner, "viewModelStoreOwner");
        this.f6127a = savedStateRegistry;
        this.f6130d = kotlin.b0.a(new ik.a<s0>() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            {
                super(0);
            }

            @Override // ik.a
            @yt.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final s0 o() {
                return SavedStateHandleSupport.e(viewModelStoreOwner);
            }
        });
    }

    @Override // androidx.savedstate.b.c
    @yt.k
    public Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f6129c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, r0> entry : c().g().entrySet()) {
            String key = entry.getKey();
            Bundle bundleA = entry.getValue().o().a();
            if (!kotlin.jvm.internal.f0.g(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(key, bundleA);
            }
        }
        this.f6128b = false;
        return bundle;
    }

    @yt.l
    public final Bundle b(@yt.k String key) {
        kotlin.jvm.internal.f0.p(key, "key");
        d();
        Bundle bundle = this.f6129c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f6129c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f6129c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f6129c = null;
        }
        return bundle2;
    }

    public final s0 c() {
        return (s0) this.f6130d.getValue();
    }

    public final void d() {
        if (this.f6128b) {
            return;
        }
        this.f6129c = this.f6127a.b(SavedStateHandleSupport.f6122b);
        this.f6128b = true;
        c();
    }
}
