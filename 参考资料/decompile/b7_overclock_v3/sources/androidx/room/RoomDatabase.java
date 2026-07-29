package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import androidx.annotation.RestrictTo;
import c2.b;
import c2.e;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class RoomDatabase {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f7256o = "_Impl";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int f7257p = 999;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Deprecated
    public volatile c2.d f7258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f7259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Executor f7260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c2.e f7261d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f7263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @g.p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public List<b> f7265h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.p0
    public androidx.room.a f7268k;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ReentrantReadWriteLock f7267j = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ThreadLocal<Integer> f7269l = new ThreadLocal<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Map<String, Object> f7270m = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final h1 f7262e = i();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<Class<?>, Object> f7271n = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @g.n0
    public Map<Class<? extends z1.b>, z1.b> f7266i = new HashMap();

    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean isLowRamDevice(@g.n0 ActivityManager activityManager) {
            return b.C0107b.b(activityManager);
        }

        public JournalMode resolve(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService(androidx.appcompat.widget.c.f2369r);
            return (activityManager == null || isLowRamDevice(activityManager)) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }
    }

    public static class a<T extends RoomDatabase> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f7272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Context f7274c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public ArrayList<b> f7275d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public d f7276e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public e f7277f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Executor f7278g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List<Object> f7279h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List<z1.b> f7280i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Executor f7281j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Executor f7282k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public e.c f7283l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f7284m;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Intent f7286o;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f7288q;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public TimeUnit f7290s;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Set<Integer> f7292u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Set<Integer> f7293v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public String f7294w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public File f7295x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public Callable<InputStream> f7296y;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public long f7289r = -1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public JournalMode f7285n = JournalMode.AUTOMATIC;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f7287p = true;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public final c f7291t = new c();

        public a(@g.n0 Context context, @g.n0 Class<T> cls, @g.p0 String str) {
            this.f7274c = context;
            this.f7272a = cls;
            this.f7273b = str;
        }

        @g.n0
        public a<T> a(@g.n0 z1.b bVar) {
            if (this.f7280i == null) {
                this.f7280i = new ArrayList();
            }
            this.f7280i.add(bVar);
            return this;
        }

        @g.n0
        public a<T> b(@g.n0 b bVar) {
            if (this.f7275d == null) {
                this.f7275d = new ArrayList<>();
            }
            this.f7275d.add(bVar);
            return this;
        }

        @g.n0
        public a<T> c(@g.n0 z1.c... cVarArr) {
            if (this.f7293v == null) {
                this.f7293v = new HashSet();
            }
            for (z1.c cVar : cVarArr) {
                this.f7293v.add(Integer.valueOf(cVar.f57674a));
                this.f7293v.add(Integer.valueOf(cVar.f57675b));
            }
            this.f7291t.c(cVarArr);
            return this;
        }

        @g.n0
        public a<T> d(@g.n0 Object obj) {
            if (this.f7279h == null) {
                this.f7279h = new ArrayList();
            }
            this.f7279h.add(obj);
            return this;
        }

        @g.n0
        public a<T> e() {
            this.f7284m = true;
            return this;
        }

        @SuppressLint({"RestrictedApi"})
        @g.n0
        public T f() {
            Executor executor;
            if (this.f7274c == null) {
                throw new IllegalArgumentException("Cannot provide null context for the database.");
            }
            if (this.f7272a == null) {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            Executor executor2 = this.f7281j;
            if (executor2 == null && this.f7282k == null) {
                Executor executorG = n.c.g();
                this.f7282k = executorG;
                this.f7281j = executorG;
            } else if (executor2 != null && this.f7282k == null) {
                this.f7282k = executor2;
            } else if (executor2 == null && (executor = this.f7282k) != null) {
                this.f7281j = executor;
            }
            Set<Integer> set = this.f7293v;
            if (set != null && this.f7292u != null) {
                for (Integer num : set) {
                    if (this.f7292u.contains(num)) {
                        throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                    }
                }
            }
            e.c b3Var = this.f7283l;
            if (b3Var == null) {
                b3Var = new d2.c();
            }
            long j10 = this.f7289r;
            if (j10 > 0) {
                if (this.f7273b == null) {
                    throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                }
                b3Var = new h0(b3Var, new androidx.room.a(j10, this.f7290s, this.f7282k));
            }
            String str = this.f7294w;
            if (str != null || this.f7295x != null || this.f7296y != null) {
                if (this.f7273b == null) {
                    throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                }
                int i10 = str == null ? 0 : 1;
                File file = this.f7295x;
                int i11 = i10 + (file == null ? 0 : 1);
                Callable<InputStream> callable = this.f7296y;
                if (i11 + (callable != null ? 1 : 0) != 1) {
                    throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                }
                b3Var = new b3(str, file, callable, b3Var);
            }
            e eVar = this.f7277f;
            e.c e2Var = eVar != null ? new e2(b3Var, eVar, this.f7278g) : b3Var;
            Context context = this.f7274c;
            n0 n0Var = new n0(context, this.f7273b, e2Var, this.f7291t, this.f7275d, this.f7284m, this.f7285n.resolve(context), this.f7281j, this.f7282k, this.f7286o, this.f7287p, this.f7288q, this.f7292u, this.f7294w, this.f7295x, this.f7296y, this.f7276e, this.f7279h, this.f7280i);
            T t10 = (T) r2.b(this.f7272a, RoomDatabase.f7256o);
            t10.x(n0Var);
            return t10;
        }

        @g.n0
        public a<T> g(@g.n0 String str) {
            this.f7294w = str;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public a<T> h(@g.n0 String str, @g.n0 d dVar) {
            this.f7276e = dVar;
            this.f7294w = str;
            return this;
        }

        @g.n0
        public a<T> i(@g.n0 File file) {
            this.f7295x = file;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "StreamFiles"})
        @g.n0
        public a<T> j(@g.n0 File file, @g.n0 d dVar) {
            this.f7276e = dVar;
            this.f7295x = file;
            return this;
        }

        @SuppressLint({"BuilderSetStyle"})
        @g.n0
        public a<T> k(@g.n0 Callable<InputStream> callable) {
            this.f7296y = callable;
            return this;
        }

        @SuppressLint({"BuilderSetStyle", "LambdaLast"})
        @g.n0
        public a<T> l(@g.n0 Callable<InputStream> callable, @g.n0 d dVar) {
            this.f7276e = dVar;
            this.f7296y = callable;
            return this;
        }

        @g.n0
        public a<T> m() {
            this.f7286o = this.f7273b != null ? new Intent(this.f7274c, (Class<?>) MultiInstanceInvalidationService.class) : null;
            return this;
        }

        @g.n0
        public a<T> n() {
            this.f7287p = false;
            this.f7288q = true;
            return this;
        }

        @g.n0
        public a<T> o(int... iArr) {
            if (this.f7292u == null) {
                this.f7292u = new HashSet(iArr.length);
            }
            for (int i10 : iArr) {
                this.f7292u.add(Integer.valueOf(i10));
            }
            return this;
        }

        @g.n0
        public a<T> p() {
            this.f7287p = true;
            this.f7288q = true;
            return this;
        }

        @g.n0
        public a<T> q(@g.p0 e.c cVar) {
            this.f7283l = cVar;
            return this;
        }

        @x0
        @g.n0
        public a<T> r(@g.f0(from = 0) long j10, @g.n0 TimeUnit timeUnit) {
            if (j10 < 0) {
                throw new IllegalArgumentException("autoCloseTimeout must be >= 0");
            }
            this.f7289r = j10;
            this.f7290s = timeUnit;
            return this;
        }

        @g.n0
        public a<T> s(@g.n0 JournalMode journalMode) {
            this.f7285n = journalMode;
            return this;
        }

        @x0
        @g.n0
        public a<T> t(@g.n0 Intent intent) {
            if (this.f7273b == null) {
                intent = null;
            }
            this.f7286o = intent;
            return this;
        }

        @g.n0
        public a<T> u(@g.n0 e eVar, @g.n0 Executor executor) {
            this.f7277f = eVar;
            this.f7278g = executor;
            return this;
        }

        @g.n0
        public a<T> v(@g.n0 Executor executor) {
            this.f7281j = executor;
            return this;
        }

        @g.n0
        public a<T> w(@g.n0 Executor executor) {
            this.f7282k = executor;
            return this;
        }
    }

    public static abstract class b {
        public void a(@g.n0 c2.d dVar) {
        }

        public void b(@g.n0 c2.d dVar) {
        }

        public void c(@g.n0 c2.d dVar) {
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public HashMap<Integer, TreeMap<Integer, z1.c>> f7297a = new HashMap<>();

        public final void a(z1.c cVar) {
            int i10 = cVar.f57674a;
            int i11 = cVar.f57675b;
            TreeMap<Integer, z1.c> treeMap = this.f7297a.get(Integer.valueOf(i10));
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                this.f7297a.put(Integer.valueOf(i10), treeMap);
            }
            z1.c cVar2 = treeMap.get(Integer.valueOf(i11));
            if (cVar2 != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Overriding migration ");
                sb2.append(cVar2);
                sb2.append(" with ");
                sb2.append(cVar);
            }
            treeMap.put(Integer.valueOf(i11), cVar);
        }

        public void b(@g.n0 List<z1.c> list) {
            Iterator<z1.c> it2 = list.iterator();
            while (it2.hasNext()) {
                a(it2.next());
            }
        }

        public void c(@g.n0 z1.c... cVarArr) {
            for (z1.c cVar : cVarArr) {
                a(cVar);
            }
        }

        @g.p0
        public List<z1.c> d(int i10, int i11) {
            if (i10 == i11) {
                return Collections.emptyList();
            }
            return e(new ArrayList(), i11 > i10, i10, i11);
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x003e  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:36:0x0047 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:43:? A[LOOP:1: B:13:0x0026->B:43:?, LOOP_END, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.List<z1.c> e(java.util.List<z1.c> r7, boolean r8, int r9, int r10) {
            /*
                r6 = this;
            L0:
                if (r8 == 0) goto L5
                if (r9 >= r10) goto L5a
                goto L7
            L5:
                if (r9 <= r10) goto L5a
            L7:
                java.util.HashMap<java.lang.Integer, java.util.TreeMap<java.lang.Integer, z1.c>> r0 = r6.f7297a
                java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
                java.lang.Object r0 = r0.get(r1)
                java.util.TreeMap r0 = (java.util.TreeMap) r0
                r1 = 0
                if (r0 != 0) goto L17
                return r1
            L17:
                if (r8 == 0) goto L1e
                java.util.NavigableSet r2 = r0.descendingKeySet()
                goto L22
            L1e:
                java.util.Set r2 = r0.keySet()
            L22:
                java.util.Iterator r2 = r2.iterator()
            L26:
                boolean r3 = r2.hasNext()
                r4 = 1
                r5 = 0
                if (r3 == 0) goto L56
                java.lang.Object r3 = r2.next()
                java.lang.Integer r3 = (java.lang.Integer) r3
                int r3 = r3.intValue()
                if (r8 == 0) goto L40
                if (r3 > r10) goto L45
                if (r3 <= r9) goto L45
            L3e:
                r5 = 1
                goto L45
            L40:
                if (r3 < r10) goto L45
                if (r3 >= r9) goto L45
                goto L3e
            L45:
                if (r5 == 0) goto L26
                java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
                java.lang.Object r9 = r0.get(r9)
                z1.c r9 = (z1.c) r9
                r7.add(r9)
                r9 = r3
                goto L57
            L56:
                r4 = 0
            L57:
                if (r4 != 0) goto L0
                return r1
            L5a:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase.c.e(java.util.List, boolean, int, int):java.util.List");
        }

        @g.n0
        public Map<Integer, Map<Integer, z1.c>> f() {
            return Collections.unmodifiableMap(this.f7297a);
        }
    }

    public static abstract class d {
        public void a(@g.n0 c2.d dVar) {
        }
    }

    public interface e {
        void a(@g.n0 String str, @g.n0 List<Object> list);
    }

    public static boolean B() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object D(c2.d dVar) {
        y();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object E(c2.d dVar) {
        z();
        return null;
    }

    public void A(@g.n0 c2.d dVar) {
        this.f7262e.h(dVar);
    }

    public boolean C() {
        androidx.room.a aVar = this.f7268k;
        if (aVar != null) {
            return aVar.h();
        }
        c2.d dVar = this.f7258a;
        return dVar != null && dVar.isOpen();
    }

    @g.n0
    public Cursor F(@g.n0 c2.g gVar) {
        return G(gVar, null);
    }

    @g.n0
    public Cursor G(@g.n0 c2.g gVar, @g.p0 CancellationSignal cancellationSignal) {
        c();
        d();
        return cancellationSignal != null ? this.f7261d.getWritableDatabase().O(gVar, cancellationSignal) : this.f7261d.getWritableDatabase().j1(gVar);
    }

    @g.n0
    public Cursor H(@g.n0 String str, @g.p0 Object[] objArr) {
        return this.f7261d.getWritableDatabase().j1(new c2.a(str, objArr));
    }

    public <V> V I(@g.n0 Callable<V> callable) {
        e();
        try {
            try {
                V vCall = callable.call();
                K();
                k();
                return vCall;
            } catch (RuntimeException e10) {
                throw e10;
            } catch (Exception e11) {
                b2.f.a(e11);
                k();
                return null;
            }
        } catch (Throwable th2) {
            k();
            throw th2;
        }
    }

    public void J(@g.n0 Runnable runnable) {
        e();
        try {
            runnable.run();
            K();
        } finally {
            k();
        }
    }

    @Deprecated
    public void K() {
        this.f7261d.getWritableDatabase().v0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @g.p0
    public final <T> T L(Class<T> cls, c2.e eVar) {
        if (cls.isInstance(eVar)) {
            return eVar;
        }
        if (eVar instanceof p0) {
            return (T) L(cls, ((p0) eVar).l());
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void c() {
        if (!this.f7263f && B()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void d() {
        if (!w() && this.f7269l.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void e() {
        c();
        androidx.room.a aVar = this.f7268k;
        if (aVar == null) {
            y();
        } else {
            aVar.c(new p.a() { // from class: androidx.room.s2
                @Override // p.a
                public final Object apply(Object obj) {
                    return this.f7514a.D((c2.d) obj);
                }
            });
        }
    }

    @g.j1
    public abstract void f();

    public void g() {
        if (C()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.f7267j.writeLock();
            writeLock.lock();
            try {
                this.f7262e.r();
                this.f7261d.close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public c2.i h(@g.n0 String str) {
        c();
        d();
        return this.f7261d.getWritableDatabase().K(str);
    }

    @g.n0
    public abstract h1 i();

    @g.n0
    public abstract c2.e j(n0 n0Var);

    @Deprecated
    public void k() {
        androidx.room.a aVar = this.f7268k;
        if (aVar == null) {
            z();
        } else {
            aVar.c(new p.a() { // from class: androidx.room.t2
                @Override // p.a
                public final Object apply(Object obj) {
                    return this.f7517a.E((c2.d) obj);
                }
            });
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @g.n0
    public List<z1.c> l(@g.n0 Map<Class<? extends z1.b>, z1.b> map) {
        return Collections.emptyList();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Map<String, Object> m() {
        return this.f7270m;
    }

    public Lock n() {
        return this.f7267j.readLock();
    }

    @g.n0
    public h1 o() {
        return this.f7262e;
    }

    @g.n0
    public c2.e p() {
        return this.f7261d;
    }

    @g.n0
    public Executor q() {
        return this.f7259b;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @g.n0
    public Set<Class<? extends z1.b>> r() {
        return Collections.emptySet();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @g.n0
    public Map<Class<?>, List<Class<?>>> s() {
        return Collections.emptyMap();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ThreadLocal<Integer> t() {
        return this.f7269l;
    }

    @g.n0
    public Executor u() {
        return this.f7260c;
    }

    @g.p0
    public <T> T v(@g.n0 Class<T> cls) {
        return (T) this.f7271n.get(cls);
    }

    public boolean w() {
        return this.f7261d.getWritableDatabase().x1();
    }

    @g.i
    public void x(@g.n0 n0 n0Var) {
        this.f7261d = j(n0Var);
        Set<Class<? extends z1.b>> setR = r();
        BitSet bitSet = new BitSet();
        Iterator<Class<? extends z1.b>> it2 = setR.iterator();
        while (true) {
            int i10 = -1;
            if (!it2.hasNext()) {
                for (int size = n0Var.f7487h.size() - 1; size >= 0; size--) {
                    if (!bitSet.get(size)) {
                        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                    }
                }
                Iterator<z1.c> it3 = l(this.f7266i).iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    z1.c next = it3.next();
                    if (!n0Var.f7483d.f().containsKey(Integer.valueOf(next.f57674a))) {
                        n0Var.f7483d.c(next);
                    }
                }
                a3 a3Var = (a3) L(a3.class, this.f7261d);
                if (a3Var != null) {
                    a3Var.f(n0Var);
                }
                a0 a0Var = (a0) L(a0.class, this.f7261d);
                if (a0Var != null) {
                    androidx.room.a aVarA = a0Var.a();
                    this.f7268k = aVarA;
                    this.f7262e.o(aVarA);
                }
                boolean z10 = n0Var.f7489j == JournalMode.WRITE_AHEAD_LOGGING;
                this.f7261d.setWriteAheadLoggingEnabled(z10);
                this.f7265h = n0Var.f7484e;
                this.f7259b = n0Var.f7490k;
                this.f7260c = new g3(n0Var.f7491l);
                this.f7263f = n0Var.f7488i;
                this.f7264g = z10;
                Intent intent = n0Var.f7493n;
                if (intent != null) {
                    this.f7262e.p(n0Var.f7481b, n0Var.f7482c, intent);
                }
                Map<Class<?>, List<Class<?>>> mapS = s();
                BitSet bitSet2 = new BitSet();
                for (Map.Entry<Class<?>, List<Class<?>>> entry : mapS.entrySet()) {
                    Class<?> key = entry.getKey();
                    for (Class<?> cls : entry.getValue()) {
                        int size2 = n0Var.f7486g.size() - 1;
                        while (true) {
                            if (size2 < 0) {
                                size2 = -1;
                                break;
                            } else {
                                if (cls.isAssignableFrom(n0Var.f7486g.get(size2).getClass())) {
                                    bitSet2.set(size2);
                                    break;
                                }
                                size2--;
                            }
                        }
                        if (size2 < 0) {
                            throw new IllegalArgumentException("A required type converter (" + cls + ") for " + key.getCanonicalName() + " is missing in the database configuration.");
                        }
                        this.f7271n.put(cls, n0Var.f7486g.get(size2));
                    }
                }
                for (int size3 = n0Var.f7486g.size() - 1; size3 >= 0; size3--) {
                    if (!bitSet2.get(size3)) {
                        throw new IllegalArgumentException("Unexpected type converter " + n0Var.f7486g.get(size3) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                    }
                }
                return;
            }
            Class<? extends z1.b> next2 = it2.next();
            int size4 = n0Var.f7487h.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (next2.isAssignableFrom(n0Var.f7487h.get(size4).getClass())) {
                    bitSet.set(size4);
                    i10 = size4;
                    break;
                }
                size4--;
            }
            if (i10 < 0) {
                throw new IllegalArgumentException("A required auto migration spec (" + next2.getCanonicalName() + ") is missing in the database configuration.");
            }
            this.f7266i.put(next2, n0Var.f7487h.get(i10));
        }
    }

    public final void y() {
        c();
        c2.d writableDatabase = this.f7261d.getWritableDatabase();
        this.f7262e.u(writableDatabase);
        if (writableDatabase.G1()) {
            writableDatabase.A0();
        } else {
            writableDatabase.o();
        }
    }

    public final void z() {
        this.f7261d.getWritableDatabase().T0();
        if (w()) {
            return;
        }
        this.f7262e.k();
    }
}
