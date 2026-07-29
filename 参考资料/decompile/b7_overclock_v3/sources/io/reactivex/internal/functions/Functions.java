package io.reactivex.internal.functions;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class Functions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dj.o<Object, Object> f32979a = new w();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Runnable f32980b = new r();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final dj.a f32981c = new o();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final dj.g<Object> f32982d = new p();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final dj.g<Throwable> f32983e = new t();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final dj.g<Throwable> f32984f = new f0();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final dj.q f32985g = new q();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final dj.r<Object> f32986h = new k0();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final dj.r<Object> f32987i = new u();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Callable<Object> f32988j = new e0();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Comparator<Object> f32989k = new a0();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final dj.g<bu.e> f32990l = new z();

    public enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    public enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static final class a<T> implements dj.g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.a f32991a;

        public a(dj.a aVar) {
            this.f32991a = aVar;
        }

        @Override // dj.g
        public void accept(T t10) throws Exception {
            this.f32991a.run();
        }
    }

    public static final class a0 implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    public static final class b<T1, T2, R> implements dj.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.c<? super T1, ? super T2, ? extends R> f32992a;

        public b(dj.c<? super T1, ? super T2, ? extends R> cVar) {
            this.f32992a = cVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.f32992a.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    public static final class b0<T> implements dj.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.g<? super xi.y<T>> f32993a;

        public b0(dj.g<? super xi.y<T>> gVar) {
            this.f32993a = gVar;
        }

        @Override // dj.a
        public void run() throws Exception {
            this.f32993a.accept(xi.y.a());
        }
    }

    public static final class c<T1, T2, T3, R> implements dj.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.h<T1, T2, T3, R> f32994a;

        public c(dj.h<T1, T2, T3, R> hVar) {
            this.f32994a = hVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return this.f32994a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    public static final class c0<T> implements dj.g<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.g<? super xi.y<T>> f32995a;

        public c0(dj.g<? super xi.y<T>> gVar) {
            this.f32995a = gVar;
        }

        @Override // dj.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th2) throws Exception {
            this.f32995a.accept(xi.y.b(th2));
        }
    }

    public static final class d<T1, T2, T3, T4, R> implements dj.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.i<T1, T2, T3, T4, R> f32996a;

        public d(dj.i<T1, T2, T3, T4, R> iVar) {
            this.f32996a = iVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 4) {
                throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
            }
            return this.f32996a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3]);
        }
    }

    public static final class d0<T> implements dj.g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.g<? super xi.y<T>> f32997a;

        public d0(dj.g<? super xi.y<T>> gVar) {
            this.f32997a = gVar;
        }

        @Override // dj.g
        public void accept(T t10) throws Exception {
            this.f32997a.accept(xi.y.c(t10));
        }
    }

    public static final class e<T1, T2, T3, T4, T5, R> implements dj.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.j<T1, T2, T3, T4, T5, R> f32998a;

        public e(dj.j<T1, T2, T3, T4, T5, R> jVar) {
            this.f32998a = jVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 5) {
                throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
            }
            return this.f32998a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4]);
        }
    }

    public static final class e0 implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    public static final class f<T1, T2, T3, T4, T5, T6, R> implements dj.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.k<T1, T2, T3, T4, T5, T6, R> f32999a;

        public f(dj.k<T1, T2, T3, T4, T5, T6, R> kVar) {
            this.f32999a = kVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 6) {
                throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
            }
            return this.f32999a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4], (T6) objArr[5]);
        }
    }

    public static final class f0 implements dj.g<Throwable> {
        @Override // dj.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th2) {
            kj.a.Y(new OnErrorNotImplementedException(th2));
        }
    }

    public static final class g<T1, T2, T3, T4, T5, T6, T7, R> implements dj.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.l<T1, T2, T3, T4, T5, T6, T7, R> f33000a;

        public g(dj.l<T1, T2, T3, T4, T5, T6, T7, R> lVar) {
            this.f33000a = lVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 7) {
                throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
            }
            return this.f33000a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4], (T6) objArr[5], (T7) objArr[6]);
        }
    }

    public static final class g0<T> implements dj.o<T, lj.d<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TimeUnit f33001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xi.h0 f33002b;

        public g0(TimeUnit timeUnit, xi.h0 h0Var) {
            this.f33001a = timeUnit;
            this.f33002b = h0Var;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public lj.d<T> apply(T t10) throws Exception {
            return new lj.d<>(t10, this.f33002b.e(this.f33001a), this.f33001a);
        }
    }

    public static final class h<T1, T2, T3, T4, T5, T6, T7, T8, R> implements dj.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.m<T1, T2, T3, T4, T5, T6, T7, T8, R> f33003a;

        public h(dj.m<T1, T2, T3, T4, T5, T6, T7, T8, R> mVar) {
            this.f33003a = mVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 8) {
                throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
            }
            return this.f33003a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4], (T6) objArr[5], (T7) objArr[6], (T8) objArr[7]);
        }
    }

    public static final class h0<K, T> implements dj.b<Map<K, T>, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.o<? super T, ? extends K> f33004a;

        public h0(dj.o<? super T, ? extends K> oVar) {
            this.f33004a = oVar;
        }

        @Override // dj.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map<K, T> map, T t10) throws Exception {
            map.put(this.f33004a.apply(t10), t10);
        }
    }

    public static final class i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements dj.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f33005a;

        public i(dj.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> nVar) {
            this.f33005a = nVar;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 9) {
                throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
            }
            return this.f33005a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4], (T6) objArr[5], (T7) objArr[6], (T8) objArr[7], (T9) objArr[8]);
        }
    }

    public static final class i0<K, V, T> implements dj.b<Map<K, V>, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.o<? super T, ? extends V> f33006a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super T, ? extends K> f33007b;

        public i0(dj.o<? super T, ? extends V> oVar, dj.o<? super T, ? extends K> oVar2) {
            this.f33006a = oVar;
            this.f33007b = oVar2;
        }

        @Override // dj.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map<K, V> map, T t10) throws Exception {
            map.put(this.f33007b.apply(t10), this.f33006a.apply(t10));
        }
    }

    public static final class j<T> implements Callable<List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f33008a;

        public j(int i10) {
            this.f33008a = i10;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> call() throws Exception {
            return new ArrayList(this.f33008a);
        }
    }

    public static final class j0<K, V, T> implements dj.b<Map<K, Collection<V>>, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.o<? super K, ? extends Collection<? super V>> f33009a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final dj.o<? super T, ? extends V> f33010b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final dj.o<? super T, ? extends K> f33011c;

        public j0(dj.o<? super K, ? extends Collection<? super V>> oVar, dj.o<? super T, ? extends V> oVar2, dj.o<? super T, ? extends K> oVar3) {
            this.f33009a = oVar;
            this.f33010b = oVar2;
            this.f33011c = oVar3;
        }

        @Override // dj.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Map<K, Collection<V>> map, T t10) throws Exception {
            K kApply = this.f33011c.apply(t10);
            Collection<? super V> collectionApply = (Collection) map.get(kApply);
            if (collectionApply == null) {
                collectionApply = this.f33009a.apply(kApply);
                map.put(kApply, collectionApply);
            }
            collectionApply.add(this.f33010b.apply(t10));
        }
    }

    public static final class k<T> implements dj.r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dj.e f33012a;

        public k(dj.e eVar) {
            this.f33012a = eVar;
        }

        @Override // dj.r
        public boolean a(T t10) throws Exception {
            return !this.f33012a.a();
        }
    }

    public static final class k0 implements dj.r<Object> {
        @Override // dj.r
        public boolean a(Object obj) {
            return true;
        }
    }

    public static class l implements dj.g<bu.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f33013a;

        public l(int i10) {
            this.f33013a = i10;
        }

        @Override // dj.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(bu.e eVar) throws Exception {
            eVar.request(this.f33013a);
        }
    }

    public static final class m<T, U> implements dj.o<T, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<U> f33014a;

        public m(Class<U> cls) {
            this.f33014a = cls;
        }

        @Override // dj.o
        public U apply(T t10) throws Exception {
            return this.f33014a.cast(t10);
        }
    }

    public static final class n<T, U> implements dj.r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<U> f33015a;

        public n(Class<U> cls) {
            this.f33015a = cls;
        }

        @Override // dj.r
        public boolean a(T t10) throws Exception {
            return this.f33015a.isInstance(t10);
        }
    }

    public static final class o implements dj.a {
        @Override // dj.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    public static final class p implements dj.g<Object> {
        @Override // dj.g
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    public static final class q implements dj.q {
        @Override // dj.q
        public void a(long j10) {
        }
    }

    public static final class r implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    public static final class s<T> implements dj.r<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f33016a;

        public s(T t10) {
            this.f33016a = t10;
        }

        @Override // dj.r
        public boolean a(T t10) throws Exception {
            return io.reactivex.internal.functions.a.c(t10, this.f33016a);
        }
    }

    public static final class t implements dj.g<Throwable> {
        @Override // dj.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th2) {
            kj.a.Y(th2);
        }
    }

    public static final class u implements dj.r<Object> {
        @Override // dj.r
        public boolean a(Object obj) {
            return false;
        }
    }

    public static final class v implements dj.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Future<?> f33017a;

        public v(Future<?> future) {
            this.f33017a = future;
        }

        @Override // dj.a
        public void run() throws Exception {
            this.f33017a.get();
        }
    }

    public static final class w implements dj.o<Object, Object> {
        @Override // dj.o
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    public static final class x<T, U> implements Callable<U>, dj.o<T, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final U f33018a;

        public x(U u6) {
            this.f33018a = u6;
        }

        @Override // dj.o
        public U apply(T t10) throws Exception {
            return this.f33018a;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.f33018a;
        }
    }

    public static final class y<T> implements dj.o<List<T>, List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Comparator<? super T> f33019a;

        public y(Comparator<? super T> comparator) {
            this.f33019a = comparator;
        }

        @Override // dj.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.f33019a);
            return list;
        }
    }

    public static final class z implements dj.g<bu.e> {
        @Override // dj.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(bu.e eVar) throws Exception {
            eVar.request(Long.MAX_VALUE);
        }
    }

    public Functions() {
        throw new IllegalStateException("No instances!");
    }

    public static <T1, T2, T3, T4, T5, R> dj.o<Object[], R> A(dj.j<T1, T2, T3, T4, T5, R> jVar) {
        io.reactivex.internal.functions.a.g(jVar, "f is null");
        return new e(jVar);
    }

    public static <T1, T2, T3, T4, T5, T6, R> dj.o<Object[], R> B(dj.k<T1, T2, T3, T4, T5, T6, R> kVar) {
        io.reactivex.internal.functions.a.g(kVar, "f is null");
        return new f(kVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> dj.o<Object[], R> C(dj.l<T1, T2, T3, T4, T5, T6, T7, R> lVar) {
        io.reactivex.internal.functions.a.g(lVar, "f is null");
        return new g(lVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> dj.o<Object[], R> D(dj.m<T1, T2, T3, T4, T5, T6, T7, T8, R> mVar) {
        io.reactivex.internal.functions.a.g(mVar, "f is null");
        return new h(mVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> dj.o<Object[], R> E(dj.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> nVar) {
        io.reactivex.internal.functions.a.g(nVar, "f is null");
        return new i(nVar);
    }

    public static <T, K> dj.b<Map<K, T>, T> F(dj.o<? super T, ? extends K> oVar) {
        return new h0(oVar);
    }

    public static <T, K, V> dj.b<Map<K, V>, T> G(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2) {
        return new i0(oVar2, oVar);
    }

    public static <T, K, V> dj.b<Map<K, Collection<V>>, T> H(dj.o<? super T, ? extends K> oVar, dj.o<? super T, ? extends V> oVar2, dj.o<? super K, ? extends Collection<? super V>> oVar3) {
        return new j0(oVar3, oVar2, oVar);
    }

    public static <T> dj.g<T> a(dj.a aVar) {
        return new a(aVar);
    }

    public static <T> dj.r<T> b() {
        return (dj.r<T>) f32987i;
    }

    public static <T> dj.r<T> c() {
        return (dj.r<T>) f32986h;
    }

    public static <T> dj.g<T> d(int i10) {
        return new l(i10);
    }

    public static <T, U> dj.o<T, U> e(Class<U> cls) {
        return new m(cls);
    }

    public static <T> Callable<List<T>> f(int i10) {
        return new j(i10);
    }

    public static <T> Callable<Set<T>> g() {
        return HashSetCallable.INSTANCE;
    }

    public static <T> dj.g<T> h() {
        return (dj.g<T>) f32982d;
    }

    public static <T> dj.r<T> i(T t10) {
        return new s(t10);
    }

    public static dj.a j(Future<?> future) {
        return new v(future);
    }

    public static <T> dj.o<T, T> k() {
        return (dj.o<T, T>) f32979a;
    }

    public static <T, U> dj.r<T> l(Class<U> cls) {
        return new n(cls);
    }

    public static <T> Callable<T> m(T t10) {
        return new x(t10);
    }

    public static <T, U> dj.o<T, U> n(U u6) {
        return new x(u6);
    }

    public static <T> dj.o<List<T>, List<T>> o(Comparator<? super T> comparator) {
        return new y(comparator);
    }

    public static <T> Comparator<T> p() {
        return NaturalComparator.INSTANCE;
    }

    public static <T> Comparator<T> q() {
        return (Comparator<T>) f32989k;
    }

    public static <T> dj.a r(dj.g<? super xi.y<T>> gVar) {
        return new b0(gVar);
    }

    public static <T> dj.g<Throwable> s(dj.g<? super xi.y<T>> gVar) {
        return new c0(gVar);
    }

    public static <T> dj.g<T> t(dj.g<? super xi.y<T>> gVar) {
        return new d0(gVar);
    }

    public static <T> Callable<T> u() {
        return (Callable<T>) f32988j;
    }

    public static <T> dj.r<T> v(dj.e eVar) {
        return new k(eVar);
    }

    public static <T> dj.o<T, lj.d<T>> w(TimeUnit timeUnit, xi.h0 h0Var) {
        return new g0(timeUnit, h0Var);
    }

    public static <T1, T2, R> dj.o<Object[], R> x(dj.c<? super T1, ? super T2, ? extends R> cVar) {
        io.reactivex.internal.functions.a.g(cVar, "f is null");
        return new b(cVar);
    }

    public static <T1, T2, T3, R> dj.o<Object[], R> y(dj.h<T1, T2, T3, R> hVar) {
        io.reactivex.internal.functions.a.g(hVar, "f is null");
        return new c(hVar);
    }

    public static <T1, T2, T3, T4, R> dj.o<Object[], R> z(dj.i<T1, T2, T3, T4, R> iVar) {
        io.reactivex.internal.functions.a.g(iVar, "f is null");
        return new d(iVar);
    }
}
