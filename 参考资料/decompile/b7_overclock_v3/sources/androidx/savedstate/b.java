package androidx.savedstate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v;
import androidx.lifecycle.y;
import androidx.savedstate.Recreator;
import g.k0;
import java.util.Map;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nSavedStateRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateRegistry.kt\nandroidx/savedstate/SavedStateRegistry\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,272:1\n1#2:273\n*E\n"})
@SuppressLint({"RestrictedApi"})
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public static final C0070b f7633g = new C0070b(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    @Deprecated
    public static final String f7634h = "androidx.lifecycle.BundlableSavedStateRegistry.key";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f7636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public Bundle f7637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f7638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @l
    public Recreator.b f7639e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final o.b<String, c> f7635a = new o.b<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7640f = true;

    public interface a {
        void a(@k d dVar);
    }

    /* JADX INFO: renamed from: androidx.savedstate.b$b, reason: collision with other inner class name */
    public static final class C0070b {
        public C0070b() {
        }

        public /* synthetic */ C0070b(u uVar) {
            this();
        }
    }

    public interface c {
        @k
        Bundle a();
    }

    public static final void f(b this$0, y yVar, Lifecycle.Event event) {
        f0.p(this$0, "this$0");
        f0.p(yVar, "<anonymous parameter 0>");
        f0.p(event, "event");
        if (event == Lifecycle.Event.ON_START) {
            this$0.f7640f = true;
        } else if (event == Lifecycle.Event.ON_STOP) {
            this$0.f7640f = false;
        }
    }

    @k0
    @l
    public final Bundle b(@k String key) {
        f0.p(key, "key");
        if (!this.f7638d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component".toString());
        }
        Bundle bundle = this.f7637c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f7637c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f7637c;
        boolean z10 = false;
        if (bundle4 != null && !bundle4.isEmpty()) {
            z10 = true;
        }
        if (!z10) {
            this.f7637c = null;
        }
        return bundle2;
    }

    @l
    public final c c(@k String key) {
        f0.p(key, "key");
        for (Map.Entry<String, c> components : this.f7635a) {
            f0.o(components, "components");
            String key2 = components.getKey();
            c value = components.getValue();
            if (f0.g(key2, key)) {
                return value;
            }
        }
        return null;
    }

    public final boolean d() {
        return this.f7640f;
    }

    @k0
    public final boolean e() {
        return this.f7638d;
    }

    @k0
    public final void g(@k Lifecycle lifecycle) {
        f0.p(lifecycle, "lifecycle");
        if (!(!this.f7636b)) {
            throw new IllegalStateException("SavedStateRegistry was already attached.".toString());
        }
        lifecycle.a(new v() { // from class: androidx.savedstate.a
            @Override // androidx.lifecycle.v
            public final void c(y yVar, Lifecycle.Event event) {
                b.f(this.f7632a, yVar, event);
            }
        });
        this.f7636b = true;
    }

    @k0
    public final void h(@l Bundle bundle) {
        if (!this.f7636b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).".toString());
        }
        if (!(!this.f7638d)) {
            throw new IllegalStateException("SavedStateRegistry was already restored.".toString());
        }
        this.f7637c = bundle != null ? bundle.getBundle(f7634h) : null;
        this.f7638d = true;
    }

    @k0
    public final void i(@k Bundle outBundle) {
        f0.p(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f7637c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        o.b<String, c>.d dVarD = this.f7635a.d();
        f0.o(dVarD, "this.components.iteratorWithAdditions()");
        while (dVarD.hasNext()) {
            Map.Entry next = dVarD.next();
            bundle.putBundle((String) next.getKey(), ((c) next.getValue()).a());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle(f7634h, bundle);
    }

    @k0
    public final void j(@k String key, @k c provider) {
        f0.p(key, "key");
        f0.p(provider, "provider");
        if (!(this.f7635a.g(key, provider) == null)) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered".toString());
        }
    }

    @k0
    public final void k(@k Class<? extends a> clazz) {
        f0.p(clazz, "clazz");
        if (!this.f7640f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState".toString());
        }
        Recreator.b bVar = this.f7639e;
        if (bVar == null) {
            bVar = new Recreator.b(this);
        }
        this.f7639e = bVar;
        try {
            clazz.getDeclaredConstructor(new Class[0]);
            Recreator.b bVar2 = this.f7639e;
            if (bVar2 != null) {
                String name = clazz.getName();
                f0.o(name, "clazz.name");
                bVar2.b(name);
            }
        } catch (NoSuchMethodException e10) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
        }
    }

    public final void l(boolean z10) {
        this.f7640f = z10;
    }

    @k0
    public final void m(@k String key) {
        f0.p(key, "key");
        this.f7635a.i(key);
    }
}
