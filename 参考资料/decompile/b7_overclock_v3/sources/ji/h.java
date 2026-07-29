package ji;

import androidx.lifecycle.LiveData;
import io.objectbox.query.Query;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class h<T> extends LiveData<List<T>> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Query<T> f36433m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public pi.d f36434n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final pi.a<List<T>> f36435o = new pi.a() { // from class: ji.g
        @Override // pi.a
        public final void b(Object obj) {
            this.f36432a.o((List) obj);
        }
    };

    public h(Query<T> query) {
        this.f36433m = query;
    }

    @Override // androidx.lifecycle.LiveData
    public void m() {
        if (this.f36434n == null) {
            this.f36434n = this.f36433m.J2().f(this.f36435o);
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void n() {
        if (i()) {
            return;
        }
        this.f36434n.cancel();
        this.f36434n = null;
    }
}
