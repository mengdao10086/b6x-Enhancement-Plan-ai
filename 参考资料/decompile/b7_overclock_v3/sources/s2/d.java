package s2;

import android.content.Context;
import androidx.annotation.RestrictTo;
import androidx.work.l;
import g.n0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class d<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f49425f = l.f("ConstraintTracker");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w2.a f49426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f49427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f49428c = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<q2.a<T>> f49429d = new LinkedHashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f49430e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f49431a;

        public a(final List val$listenersList) {
            this.f49431a = val$listenersList;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it2 = this.f49431a.iterator();
            while (it2.hasNext()) {
                ((q2.a) it2.next()).a(d.this.f49430e);
            }
        }
    }

    public d(@n0 Context context, @n0 w2.a taskExecutor) {
        this.f49427b = context.getApplicationContext();
        this.f49426a = taskExecutor;
    }

    public void a(q2.a<T> listener) {
        synchronized (this.f49428c) {
            if (this.f49429d.add(listener)) {
                if (this.f49429d.size() == 1) {
                    this.f49430e = b();
                    l.c().a(f49425f, String.format("%s: initial state = %s", getClass().getSimpleName(), this.f49430e), new Throwable[0]);
                    e();
                }
                listener.a(this.f49430e);
            }
        }
    }

    public abstract T b();

    public void c(q2.a<T> listener) {
        synchronized (this.f49428c) {
            if (this.f49429d.remove(listener) && this.f49429d.isEmpty()) {
                f();
            }
        }
    }

    public void d(T newState) {
        synchronized (this.f49428c) {
            T t10 = this.f49430e;
            if (t10 != newState && (t10 == null || !t10.equals(newState))) {
                this.f49430e = newState;
                this.f49426a.b().execute(new a(new ArrayList(this.f49429d)));
            }
        }
    }

    public abstract void e();

    public abstract void f();
}
