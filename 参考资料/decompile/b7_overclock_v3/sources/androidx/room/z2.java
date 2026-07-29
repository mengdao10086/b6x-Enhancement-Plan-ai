package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.room.h1;
import io.reactivex.BackpressureStrategy;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class z2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f7609a = new Object();

    public class a implements xi.m<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f7610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RoomDatabase f7611b;

        /* JADX INFO: renamed from: androidx.room.z2$a$a, reason: collision with other inner class name */
        public class C0069a extends h1.c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ xi.l f7612b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0069a(String[] strArr, xi.l lVar) {
                super(strArr);
                this.f7612b = lVar;
            }

            @Override // androidx.room.h1.c
            public void b(@g.n0 Set<String> set) {
                if (this.f7612b.isCancelled()) {
                    return;
                }
                this.f7612b.onNext(z2.f7609a);
            }
        }

        public class b implements dj.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h1.c f7614a;

            public b(h1.c cVar) {
                this.f7614a = cVar;
            }

            @Override // dj.a
            public void run() throws Exception {
                a.this.f7611b.o().m(this.f7614a);
            }
        }

        public a(String[] strArr, RoomDatabase roomDatabase) {
            this.f7610a = strArr;
            this.f7611b = roomDatabase;
        }

        @Override // xi.m
        public void a(xi.l<Object> lVar) throws Exception {
            C0069a c0069a = new C0069a(this.f7610a, lVar);
            if (!lVar.isCancelled()) {
                this.f7611b.o().a(c0069a);
                lVar.c(io.reactivex.disposables.c.c(new b(c0069a)));
            }
            if (lVar.isCancelled()) {
                return;
            }
            lVar.onNext(z2.f7609a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> implements dj.o<Object, xi.w<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xi.q f7616a;

        public b(xi.q qVar) {
            this.f7616a = qVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public xi.w<T> apply(Object obj) throws Exception {
            return this.f7616a;
        }
    }

    public class c implements xi.c0<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String[] f7617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RoomDatabase f7618b;

        public class a extends h1.c {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ xi.b0 f7619b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String[] strArr, xi.b0 b0Var) {
                super(strArr);
                this.f7619b = b0Var;
            }

            @Override // androidx.room.h1.c
            public void b(@g.n0 Set<String> set) {
                this.f7619b.onNext(z2.f7609a);
            }
        }

        public class b implements dj.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ h1.c f7621a;

            public b(h1.c cVar) {
                this.f7621a = cVar;
            }

            @Override // dj.a
            public void run() throws Exception {
                c.this.f7618b.o().m(this.f7621a);
            }
        }

        public c(String[] strArr, RoomDatabase roomDatabase) {
            this.f7617a = strArr;
            this.f7618b = roomDatabase;
        }

        @Override // xi.c0
        public void a(xi.b0<Object> b0Var) throws Exception {
            a aVar = new a(this.f7617a, b0Var);
            this.f7618b.o().a(aVar);
            b0Var.c(io.reactivex.disposables.c.c(new b(aVar)));
            b0Var.onNext(z2.f7609a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class d<T> implements dj.o<Object, xi.w<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ xi.q f7623a;

        public d(xi.q qVar) {
            this.f7623a = qVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public xi.w<T> apply(Object obj) throws Exception {
            return this.f7623a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class e<T> implements xi.m0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Callable f7624a;

        public e(Callable callable) {
            this.f7624a = callable;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // xi.m0
        public void a(xi.k0<T> k0Var) throws Exception {
            try {
                k0Var.onSuccess(this.f7624a.call());
            } catch (EmptyResultSetException e10) {
                k0Var.a(e10);
            }
        }
    }

    @Deprecated
    public z2() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> xi.j<T> a(RoomDatabase roomDatabase, boolean z10, String[] strArr, Callable<T> callable) {
        xi.h0 h0VarB = lj.b.b(h(roomDatabase, z10));
        return (xi.j<T>) b(roomDatabase, strArr).l6(h0VarB).S7(h0VarB).l4(h0VarB).J2(new b(xi.q.l0(callable)));
    }

    public static xi.j<Object> b(RoomDatabase roomDatabase, String... strArr) {
        return xi.j.w1(new a(strArr, roomDatabase), BackpressureStrategy.LATEST);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static <T> xi.j<T> c(RoomDatabase roomDatabase, String[] strArr, Callable<T> callable) {
        return a(roomDatabase, false, strArr, callable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> xi.z<T> d(RoomDatabase roomDatabase, boolean z10, String[] strArr, Callable<T> callable) {
        xi.h0 h0VarB = lj.b.b(h(roomDatabase, z10));
        return (xi.z<T>) e(roomDatabase, strArr).J5(h0VarB).n7(h0VarB).b4(h0VarB).B2(new d(xi.q.l0(callable)));
    }

    public static xi.z<Object> e(RoomDatabase roomDatabase, String... strArr) {
        return xi.z.r1(new c(strArr, roomDatabase));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public static <T> xi.z<T> f(RoomDatabase roomDatabase, String[] strArr, Callable<T> callable) {
        return d(roomDatabase, false, strArr, callable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static <T> xi.i0<T> g(Callable<T> callable) {
        return xi.i0.A(new e(callable));
    }

    public static Executor h(RoomDatabase roomDatabase, boolean z10) {
        return z10 ? roomDatabase.u() : roomDatabase.q();
    }
}
