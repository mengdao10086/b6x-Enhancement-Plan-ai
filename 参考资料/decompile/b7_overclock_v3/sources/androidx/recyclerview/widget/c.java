package androidx.recyclerview.widget;

import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.i;
import g.n0;
import g.p0;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes2.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final Executor f6836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @n0
    public final Executor f6837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @n0
    public final i.d<T> f6838c;

    public static final class a<T> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Object f6839d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static Executor f6840e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @p0
        public Executor f6841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Executor f6842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final i.d<T> f6843c;

        public a(@n0 i.d<T> dVar) {
            this.f6843c = dVar;
        }

        @n0
        public c<T> a() {
            if (this.f6842b == null) {
                synchronized (f6839d) {
                    if (f6840e == null) {
                        f6840e = Executors.newFixedThreadPool(2);
                    }
                }
                this.f6842b = f6840e;
            }
            return new c<>(this.f6841a, this.f6842b, this.f6843c);
        }

        @n0
        public a<T> b(Executor executor) {
            this.f6842b = executor;
            return this;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @n0
        public a<T> c(Executor executor) {
            this.f6841a = executor;
            return this;
        }
    }

    public c(@p0 Executor executor, @n0 Executor executor2, @n0 i.d<T> dVar) {
        this.f6836a = executor;
        this.f6837b = executor2;
        this.f6838c = dVar;
    }

    @n0
    public Executor a() {
        return this.f6837b;
    }

    @n0
    public i.d<T> b() {
        return this.f6838c;
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Executor c() {
        return this.f6836a;
    }
}
