package zg;

import com.trello.rxlifecycle3.OutsideLifecycleException;
import dj.o;
import dj.r;
import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o<Throwable, Boolean> f58577a = new C0686a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r<Boolean> f58578b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o<Object, xi.a> f58579c = new c();

    /* JADX INFO: renamed from: zg.a$a, reason: collision with other inner class name */
    public static class C0686a implements o<Throwable, Boolean> {
        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean apply(Throwable th2) throws Exception {
            if (th2 instanceof OutsideLifecycleException) {
                return Boolean.TRUE;
            }
            io.reactivex.exceptions.a.a(th2);
            return Boolean.FALSE;
        }
    }

    public static class b implements r<Boolean> {
        @Override // dj.r
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean a(Boolean bool) throws Exception {
            return bool.booleanValue();
        }
    }

    public static class c implements o<Object, xi.a> {
        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public xi.a apply(Object obj) throws Exception {
            return xi.a.P(new CancellationException());
        }
    }

    public a() {
        throw new AssertionError("No instances!");
    }
}
