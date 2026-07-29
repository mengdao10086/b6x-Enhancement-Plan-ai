package androidx.activity;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v;
import androidx.lifecycle.y;
import g.k0;
import g.u;
import g.v0;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nOnBackPressedDispatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnBackPressedDispatcher.kt\nandroidx/activity/OnBackPressedDispatcher\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,317:1\n1747#2,3:318\n533#2,6:321\n*S KotlinDebug\n*F\n+ 1 OnBackPressedDispatcher.kt\nandroidx/activity/OnBackPressedDispatcher\n*L\n194#1:318,3\n209#1:321,6\n*E\n"})
public final class OnBackPressedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public final Runnable f1335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final kotlin.collections.i<n> f1336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public ik.a<z1> f1337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public OnBackInvokedCallback f1338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.l
    public OnBackInvokedDispatcher f1339e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f1340f;

    public final class LifecycleOnBackPressedCancellable implements v, c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final Lifecycle f1341a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public final n f1342b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.l
        public c f1343c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f1344d;

        public LifecycleOnBackPressedCancellable(@yt.k OnBackPressedDispatcher onBackPressedDispatcher, @yt.k Lifecycle lifecycle, n onBackPressedCallback) {
            f0.p(lifecycle, "lifecycle");
            f0.p(onBackPressedCallback, "onBackPressedCallback");
            this.f1344d = onBackPressedDispatcher;
            this.f1341a = lifecycle;
            this.f1342b = onBackPressedCallback;
            lifecycle.a(this);
        }

        @Override // androidx.lifecycle.v
        public void c(@yt.k y source, @yt.k Lifecycle.Event event) {
            f0.p(source, "source");
            f0.p(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.f1343c = this.f1344d.d(this.f1342b);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                c cVar = this.f1343c;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f1341a.d(this);
            this.f1342b.f(this);
            c cVar = this.f1343c;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f1343c = null;
        }
    }

    @v0(33)
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public static final a f1345a = new a();

        public static final void c(ik.a onBackInvoked) {
            f0.p(onBackInvoked, "$onBackInvoked");
            onBackInvoked.o();
        }

        @u
        @yt.k
        public final OnBackInvokedCallback b(@yt.k final ik.a<z1> onBackInvoked) {
            f0.p(onBackInvoked, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.o
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    OnBackPressedDispatcher.a.c(onBackInvoked);
                }
            };
        }

        @u
        public final void d(@yt.k Object dispatcher, int i10, @yt.k Object callback) {
            f0.p(dispatcher, "dispatcher");
            f0.p(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).registerOnBackInvokedCallback(i10, (OnBackInvokedCallback) callback);
        }

        @u
        public final void e(@yt.k Object dispatcher, @yt.k Object callback) {
            f0.p(dispatcher, "dispatcher");
            f0.p(callback, "callback");
            ((OnBackInvokedDispatcher) dispatcher).unregisterOnBackInvokedCallback((OnBackInvokedCallback) callback);
        }
    }

    public final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public final n f1346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ OnBackPressedDispatcher f1347b;

        public b(@yt.k OnBackPressedDispatcher onBackPressedDispatcher, n onBackPressedCallback) {
            f0.p(onBackPressedCallback, "onBackPressedCallback");
            this.f1347b = onBackPressedDispatcher;
            this.f1346a = onBackPressedCallback;
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f1347b.f1336b.remove(this.f1346a);
            this.f1346a.f(this);
            if (Build.VERSION.SDK_INT >= 33) {
                this.f1346a.h(null);
                this.f1347b.h();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @hk.i
    public OnBackPressedDispatcher() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @hk.i
    public OnBackPressedDispatcher(@yt.l Runnable runnable) {
        this.f1335a = runnable;
        this.f1336b = new kotlin.collections.i<>();
        if (Build.VERSION.SDK_INT >= 33) {
            this.f1337c = new ik.a<z1>() { // from class: androidx.activity.OnBackPressedDispatcher.1
                {
                    super(0);
                }

                public final void b() {
                    OnBackPressedDispatcher.this.h();
                }

                @Override // ik.a
                public /* bridge */ /* synthetic */ z1 o() {
                    b();
                    return z1.f38230a;
                }
            };
            this.f1338d = a.f1345a.b(new ik.a<z1>() { // from class: androidx.activity.OnBackPressedDispatcher.2
                {
                    super(0);
                }

                public final void b() {
                    OnBackPressedDispatcher.this.f();
                }

                @Override // ik.a
                public /* bridge */ /* synthetic */ z1 o() {
                    b();
                    return z1.f38230a;
                }
            });
        }
    }

    @k0
    public final void b(@yt.k n onBackPressedCallback) {
        f0.p(onBackPressedCallback, "onBackPressedCallback");
        d(onBackPressedCallback);
    }

    @k0
    public final void c(@yt.k y owner, @yt.k n onBackPressedCallback) {
        f0.p(owner, "owner");
        f0.p(onBackPressedCallback, "onBackPressedCallback");
        Lifecycle lifecycleE = owner.e();
        if (lifecycleE.b() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.a(new LifecycleOnBackPressedCancellable(this, lifecycleE, onBackPressedCallback));
        if (Build.VERSION.SDK_INT >= 33) {
            h();
            onBackPressedCallback.h(this.f1337c);
        }
    }

    @k0
    @yt.k
    public final c d(@yt.k n onBackPressedCallback) {
        f0.p(onBackPressedCallback, "onBackPressedCallback");
        this.f1336b.add(onBackPressedCallback);
        b bVar = new b(this, onBackPressedCallback);
        onBackPressedCallback.a(bVar);
        if (Build.VERSION.SDK_INT >= 33) {
            h();
            onBackPressedCallback.h(this.f1337c);
        }
        return bVar;
    }

    @k0
    public final boolean e() {
        kotlin.collections.i<n> iVar = this.f1336b;
        if ((iVar instanceof Collection) && iVar.isEmpty()) {
            return false;
        }
        Iterator<n> it2 = iVar.iterator();
        while (it2.hasNext()) {
            if (it2.next().d()) {
                return true;
            }
        }
        return false;
    }

    @k0
    public final void f() {
        n nVarPrevious;
        kotlin.collections.i<n> iVar = this.f1336b;
        ListIterator<n> listIterator = iVar.listIterator(iVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                nVarPrevious = null;
                break;
            } else {
                nVarPrevious = listIterator.previous();
                if (nVarPrevious.d()) {
                    break;
                }
            }
        }
        n nVar = nVarPrevious;
        if (nVar != null) {
            nVar.c();
            return;
        }
        Runnable runnable = this.f1335a;
        if (runnable != null) {
            runnable.run();
        }
    }

    @v0(33)
    public final void g(@yt.k OnBackInvokedDispatcher invoker) {
        f0.p(invoker, "invoker");
        this.f1339e = invoker;
        h();
    }

    @v0(33)
    public final void h() {
        boolean zE = e();
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f1339e;
        OnBackInvokedCallback onBackInvokedCallback = this.f1338d;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (zE && !this.f1340f) {
            a.f1345a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f1340f = true;
        } else {
            if (zE || !this.f1340f) {
                return;
            }
            a.f1345a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f1340f = false;
        }
    }

    public /* synthetic */ OnBackPressedDispatcher(Runnable runnable, int i10, kotlin.jvm.internal.u uVar) {
        this((i10 & 1) != 0 ? null : runnable);
    }
}
