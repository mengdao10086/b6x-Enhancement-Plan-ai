package androidx.room;

import androidx.annotation.RestrictTo;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class c3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f7358a = new AtomicBoolean(false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RoomDatabase f7359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile c2.i f7360c;

    public c3(RoomDatabase roomDatabase) {
        this.f7359b = roomDatabase;
    }

    public c2.i a() {
        b();
        return e(this.f7358a.compareAndSet(false, true));
    }

    public void b() {
        this.f7359b.c();
    }

    public final c2.i c() {
        return this.f7359b.h(d());
    }

    public abstract String d();

    public final c2.i e(boolean z10) {
        if (!z10) {
            return c();
        }
        if (this.f7360c == null) {
            this.f7360c = c();
        }
        return this.f7360c;
    }

    public void f(c2.i iVar) {
        if (iVar == this.f7360c) {
            this.f7358a.set(false);
        }
    }
}
