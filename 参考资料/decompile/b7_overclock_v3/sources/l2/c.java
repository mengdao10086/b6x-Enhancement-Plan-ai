package l2;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.work.o;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class c implements o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j0<o.b> f39341c = new j0<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.a<o.b.c> f39342d = androidx.work.impl.utils.futures.a.u();

    public c() {
        a(o.f8747b);
    }

    public void a(@n0 o.b state) {
        this.f39341c.o(state);
        if (state instanceof o.b.c) {
            this.f39342d.p((o.b.c) state);
        } else if (state instanceof o.b.a) {
            this.f39342d.q(((o.b.a) state).a());
        }
    }

    @Override // androidx.work.o
    @n0
    public ListenableFuture<o.b.c> getResult() {
        return this.f39342d;
    }

    @Override // androidx.work.o
    @n0
    public LiveData<o.b> getState() {
        return this.f39341c;
    }
}
