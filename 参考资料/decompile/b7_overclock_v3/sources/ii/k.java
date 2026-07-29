package ii;

import io.objectbox.BoxStore;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import javax.annotation.Nullable;
import org.greenrobot.essentials.collections.MultimapSet;

/* JADX INFO: loaded from: classes5.dex */
@li.c
public class k implements pi.b<Class>, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BoxStore f32463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MultimapSet<Integer, pi.a<Class>> f32464b = MultimapSet.p(MultimapSet.SetType.THREAD_SAFE);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Deque<a> f32465c = new ArrayDeque();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile boolean f32466d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final pi.a<Class> f32467a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f32468b;

        public a(@Nullable pi.a<Class> aVar, int[] iArr) {
            this.f32467a = aVar;
            this.f32468b = iArr;
        }
    }

    public k(BoxStore boxStore) {
        this.f32463a = boxStore;
    }

    @Override // pi.b
    public void a(pi.a<Class> aVar, @Nullable Object obj) {
        if (obj != null) {
            g(aVar, this.f32463a.u1((Class) obj));
            return;
        }
        for (int i10 : this.f32463a.M0()) {
            g(aVar, i10);
        }
    }

    @Override // pi.b
    public void b(pi.a<Class> aVar, @Nullable Object obj) {
        if (obj != null) {
            this.f32464b.j(Integer.valueOf(this.f32463a.u1((Class) obj)), aVar);
            return;
        }
        for (int i10 : this.f32463a.M0()) {
            this.f32464b.j(Integer.valueOf(i10), aVar);
        }
    }

    @Override // pi.b
    public void c(pi.a<Class> aVar, @Nullable Object obj) {
        f(aVar, obj != null ? new int[]{this.f32463a.u1((Class) obj)} : this.f32463a.M0());
    }

    public final void d(Class cls) {
        RuntimeException runtimeException = new RuntimeException("Observer failed while processing data for " + cls + ". Consider using an ErrorObserver");
        runtimeException.printStackTrace();
        throw runtimeException;
    }

    public void e(int[] iArr) {
        f(null, iArr);
    }

    public final void f(@Nullable pi.a<Class> aVar, int[] iArr) {
        synchronized (this.f32465c) {
            this.f32465c.add(new a(aVar, iArr));
            if (!this.f32466d) {
                this.f32466d = true;
                this.f32463a.l2(this);
            }
        }
    }

    public final void g(pi.a<Class> aVar, int i10) {
        pi.c.a(this.f32464b.get(Integer.valueOf(i10)), aVar);
    }

    @Override // java.lang.Runnable
    public void run() {
        a aVarPollFirst;
        while (true) {
            synchronized (this.f32465c) {
                aVarPollFirst = this.f32465c.pollFirst();
                if (aVarPollFirst == null) {
                    this.f32466d = false;
                    return;
                }
                this.f32466d = false;
            }
            for (int i10 : aVarPollFirst.f32468b) {
                Collection collectionSingletonList = aVarPollFirst.f32467a != null ? Collections.singletonList(aVarPollFirst.f32467a) : this.f32464b.get(Integer.valueOf(i10));
                if (collectionSingletonList != null && !collectionSingletonList.isEmpty()) {
                    Class<?> clsM1 = this.f32463a.m1(i10);
                    try {
                        Iterator it2 = collectionSingletonList.iterator();
                        while (it2.hasNext()) {
                            ((pi.a) it2.next()).b(clsM1);
                        }
                    } catch (RuntimeException unused) {
                        d(clsM1);
                    }
                }
            }
        }
    }
}
