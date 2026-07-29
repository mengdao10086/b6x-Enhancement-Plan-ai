package androidx.activity;

import g.k0;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nOnBackPressedCallback.kt\nKotlin\n*S Kotlin\n*F\n+ 1 OnBackPressedCallback.kt\nandroidx/activity/OnBackPressedCallback\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,85:1\n1855#2,2:86\n*S KotlinDebug\n*F\n+ 1 OnBackPressedCallback.kt\nandroidx/activity/OnBackPressedCallback\n*L\n67#1:86,2\n*E\n"})
public abstract class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final CopyOnWriteArrayList<c> f1380b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public ik.a<z1> f1381c;

    public n(boolean z10) {
        this.f1379a = z10;
    }

    @hk.h(name = "addCancellable")
    public final void a(@yt.k c cancellable) {
        f0.p(cancellable, "cancellable");
        this.f1380b.add(cancellable);
    }

    @yt.l
    public final ik.a<z1> b() {
        return this.f1381c;
    }

    @k0
    public abstract void c();

    @k0
    public final boolean d() {
        return this.f1379a;
    }

    @k0
    public final void e() {
        Iterator<T> it2 = this.f1380b.iterator();
        while (it2.hasNext()) {
            ((c) it2.next()).cancel();
        }
    }

    @hk.h(name = "removeCancellable")
    public final void f(@yt.k c cancellable) {
        f0.p(cancellable, "cancellable");
        this.f1380b.remove(cancellable);
    }

    @k0
    public final void g(boolean z10) {
        this.f1379a = z10;
        ik.a<z1> aVar = this.f1381c;
        if (aVar != null) {
            aVar.o();
        }
    }

    public final void h(@yt.l ik.a<z1> aVar) {
        this.f1381c = aVar;
    }
}
