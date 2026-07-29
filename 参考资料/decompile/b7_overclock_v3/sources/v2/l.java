package v2;

import androidx.annotation.RestrictTo;
import androidx.work.WorkInfo;
import androidx.work.w;
import com.google.common.util.concurrent.ListenableFuture;
import g.j1;
import g.n0;
import java.util.List;
import java.util.UUID;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class l<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.work.impl.utils.futures.a<T> f52597a = androidx.work.impl.utils.futures.a.u();

    public class a extends l<List<WorkInfo>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l2.i f52598b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ List f52599c;

        public a(final l2.i val$workManager, final List val$ids) {
            this.f52598b = val$workManager;
            this.f52599c = val$ids;
        }

        @Override // v2.l
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public List<WorkInfo> g() {
            return u2.r.f51840u.apply(this.f52598b.M().W().E(this.f52599c));
        }
    }

    public class b extends l<WorkInfo> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l2.i f52600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UUID f52601c;

        public b(final l2.i val$workManager, final UUID val$id) {
            this.f52600b = val$workManager;
            this.f52601c = val$id;
        }

        @Override // v2.l
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public WorkInfo g() {
            r.c cVarS = this.f52600b.M().W().s(this.f52601c.toString());
            if (cVarS != null) {
                return cVarS.a();
            }
            return null;
        }
    }

    public class c extends l<List<WorkInfo>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l2.i f52602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f52603c;

        public c(final l2.i val$workManager, final String val$tag) {
            this.f52602b = val$workManager;
            this.f52603c = val$tag;
        }

        @Override // v2.l
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public List<WorkInfo> g() {
            return u2.r.f51840u.apply(this.f52602b.M().W().w(this.f52603c));
        }
    }

    public class d extends l<List<WorkInfo>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l2.i f52604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f52605c;

        public d(final l2.i val$workManager, final String val$name) {
            this.f52604b = val$workManager;
            this.f52605c = val$name;
        }

        @Override // v2.l
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public List<WorkInfo> g() {
            return u2.r.f51840u.apply(this.f52604b.M().W().D(this.f52605c));
        }
    }

    public class e extends l<List<WorkInfo>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l2.i f52606b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ w f52607c;

        public e(final l2.i val$workManager, final w val$querySpec) {
            this.f52606b = val$workManager;
            this.f52607c = val$querySpec;
        }

        @Override // v2.l
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public List<WorkInfo> g() {
            return u2.r.f51840u.apply(this.f52606b.M().S().a(i.b(this.f52607c)));
        }
    }

    @n0
    public static l<List<WorkInfo>> a(@n0 final l2.i workManager, @n0 final List<String> ids) {
        return new a(workManager, ids);
    }

    @n0
    public static l<List<WorkInfo>> b(@n0 final l2.i workManager, @n0 final String tag) {
        return new c(workManager, tag);
    }

    @n0
    public static l<WorkInfo> c(@n0 final l2.i workManager, @n0 final UUID id2) {
        return new b(workManager, id2);
    }

    @n0
    public static l<List<WorkInfo>> d(@n0 final l2.i workManager, @n0 final String name) {
        return new d(workManager, name);
    }

    @n0
    public static l<List<WorkInfo>> e(@n0 final l2.i workManager, @n0 final w querySpec) {
        return new e(workManager, querySpec);
    }

    @n0
    public ListenableFuture<T> f() {
        return this.f52597a;
    }

    @j1
    public abstract T g();

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f52597a.p(g());
        } catch (Throwable th2) {
            this.f52597a.q(th2);
        }
    }
}
