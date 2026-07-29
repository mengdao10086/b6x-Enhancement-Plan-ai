package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.f0;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public final class n<T> extends o<T> implements Iterator<T>, kotlin.coroutines.c<z1>, jk.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f38103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public T f38104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public Iterator<? extends T> f38105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.l
    public kotlin.coroutines.c<? super z1> f38106d;

    @Override // kotlin.sequences.o
    @yt.l
    public Object a(T t10, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        this.f38104b = t10;
        this.f38103a = 3;
        this.f38106d = cVar;
        Object objH = yj.b.h();
        if (objH == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objH == yj.b.h() ? objH : z1.f38230a;
    }

    @Override // kotlin.coroutines.c
    @yt.k
    public CoroutineContext b() {
        return EmptyCoroutineContext.f37755a;
    }

    @Override // kotlin.sequences.o
    @yt.l
    public Object g(@yt.k Iterator<? extends T> it2, @yt.k kotlin.coroutines.c<? super z1> cVar) {
        if (!it2.hasNext()) {
            return z1.f38230a;
        }
        this.f38105c = it2;
        this.f38103a = 2;
        this.f38106d = cVar;
        Object objH = yj.b.h();
        if (objH == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objH == yj.b.h() ? objH : z1.f38230a;
    }

    @Override // java.util.Iterator
    public boolean hasNext() throws Throwable {
        while (true) {
            int i10 = this.f38103a;
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2 || i10 == 3) {
                        return true;
                    }
                    if (i10 == 4) {
                        return false;
                    }
                    throw j();
                }
                Iterator<? extends T> it2 = this.f38105c;
                f0.m(it2);
                if (it2.hasNext()) {
                    this.f38103a = 2;
                    return true;
                }
                this.f38105c = null;
            }
            this.f38103a = 5;
            kotlin.coroutines.c<? super z1> cVar = this.f38106d;
            f0.m(cVar);
            this.f38106d = null;
            Result.a aVar = Result.f37633a;
            cVar.x(Result.b(z1.f38230a));
        }
    }

    public final Throwable j() {
        int i10 = this.f38103a;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f38103a);
    }

    @yt.l
    public final kotlin.coroutines.c<z1> k() {
        return this.f38106d;
    }

    public final T l() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    public final void m(@yt.l kotlin.coroutines.c<? super z1> cVar) {
        this.f38106d = cVar;
    }

    @Override // java.util.Iterator
    public T next() throws Throwable {
        int i10 = this.f38103a;
        if (i10 == 0 || i10 == 1) {
            return l();
        }
        if (i10 == 2) {
            this.f38103a = 1;
            Iterator<? extends T> it2 = this.f38105c;
            f0.m(it2);
            return it2.next();
        }
        if (i10 != 3) {
            throw j();
        }
        this.f38103a = 0;
        T t10 = this.f38104b;
        this.f38104b = null;
        return t10;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.c
    public void x(@yt.k Object obj) throws Throwable {
        u0.n(obj);
        this.f38103a = 4;
    }
}
