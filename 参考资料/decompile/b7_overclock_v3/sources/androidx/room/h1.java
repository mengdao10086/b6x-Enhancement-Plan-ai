package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes2.dex */
public class h1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String[] f7392o = {"UPDATE", "DELETE", "INSERT"};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f7393p = "room_table_modification_log";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f7394q = "table_id";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f7395r = "invalidated";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f7396s = "CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @g.i1
    public static final String f7397t = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ";

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @g.i1
    public static final String f7398u = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.n0
    public final HashMap<String, Integer> f7399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String[] f7400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.n0
    public Map<String, Set<String>> f7401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.p0
    public androidx.room.a f7402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RoomDatabase f7403e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public AtomicBoolean f7404f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f7405g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile c2.i f7406h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f7407i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final f1 f7408j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @g.i1
    @SuppressLint({"RestrictedApi"})
    public final o.b<c, d> f7409k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public k1 f7410l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f7411m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @g.i1
    public Runnable f7412n;

    public class a implements Runnable {
        public a() {
        }

        public final Set<Integer> a() {
            HashSet hashSet = new HashSet();
            Cursor cursorF = h1.this.f7403e.F(new c2.a(h1.f7398u));
            while (cursorF.moveToNext()) {
                try {
                    hashSet.add(Integer.valueOf(cursorF.getInt(0)));
                } catch (Throwable th2) {
                    cursorF.close();
                    throw th2;
                }
            }
            cursorF.close();
            if (!hashSet.isEmpty()) {
                h1.this.f7406h.a0();
            }
            return hashSet;
        }

        @Override // java.lang.Runnable
        public void run() {
            androidx.room.a aVar;
            androidx.room.a aVar2;
            Lock lockN = h1.this.f7403e.n();
            lockN.lock();
            Set<Integer> setA = null;
            try {
                try {
                } catch (SQLiteException | IllegalStateException unused) {
                    lockN.unlock();
                    aVar2 = h1.this.f7402d;
                    if (aVar2 != null) {
                    }
                }
                if (!h1.this.g()) {
                    if (aVar != null) {
                        return;
                    } else {
                        return;
                    }
                }
                if (!h1.this.f7404f.compareAndSet(true, false)) {
                    lockN.unlock();
                    androidx.room.a aVar3 = h1.this.f7402d;
                    if (aVar3 != null) {
                        aVar3.b();
                        return;
                    }
                    return;
                }
                if (h1.this.f7403e.w()) {
                    lockN.unlock();
                    androidx.room.a aVar4 = h1.this.f7402d;
                    if (aVar4 != null) {
                        aVar4.b();
                        return;
                    }
                    return;
                }
                c2.d writableDatabase = h1.this.f7403e.p().getWritableDatabase();
                writableDatabase.A0();
                try {
                    setA = a();
                    writableDatabase.v0();
                    lockN.unlock();
                    aVar2 = h1.this.f7402d;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                    if (setA == null || setA.isEmpty()) {
                        return;
                    }
                    synchronized (h1.this.f7409k) {
                        Iterator<Map.Entry<c, d>> it2 = h1.this.f7409k.iterator();
                        while (it2.hasNext()) {
                            it2.next().getValue().a(setA);
                        }
                    }
                } finally {
                    writableDatabase.T0();
                }
            } finally {
                lockN.unlock();
                aVar = h1.this.f7402d;
                if (aVar != null) {
                    aVar.b();
                }
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final int f7414e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int f7415f = 1;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int f7416g = 2;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long[] f7417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean[] f7418b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f7419c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f7420d;

        public b(int i10) {
            long[] jArr = new long[i10];
            this.f7417a = jArr;
            boolean[] zArr = new boolean[i10];
            this.f7418b = zArr;
            this.f7419c = new int[i10];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        @g.p0
        public int[] a() {
            synchronized (this) {
                if (!this.f7420d) {
                    return null;
                }
                int length = this.f7417a.length;
                for (int i10 = 0; i10 < length; i10++) {
                    int i11 = 1;
                    boolean z10 = this.f7417a[i10] > 0;
                    boolean[] zArr = this.f7418b;
                    if (z10 != zArr[i10]) {
                        int[] iArr = this.f7419c;
                        if (!z10) {
                            i11 = 2;
                        }
                        iArr[i10] = i11;
                    } else {
                        this.f7419c[i10] = 0;
                    }
                    zArr[i10] = z10;
                }
                this.f7420d = false;
                return (int[]) this.f7419c.clone();
            }
        }

        public boolean b(int... iArr) {
            boolean z10;
            synchronized (this) {
                z10 = false;
                for (int i10 : iArr) {
                    long[] jArr = this.f7417a;
                    long j10 = jArr[i10];
                    jArr[i10] = 1 + j10;
                    if (j10 == 0) {
                        this.f7420d = true;
                        z10 = true;
                    }
                }
            }
            return z10;
        }

        public boolean c(int... iArr) {
            boolean z10;
            synchronized (this) {
                z10 = false;
                for (int i10 : iArr) {
                    long[] jArr = this.f7417a;
                    long j10 = jArr[i10];
                    jArr[i10] = j10 - 1;
                    if (j10 == 1) {
                        this.f7420d = true;
                        z10 = true;
                    }
                }
            }
            return z10;
        }

        public void d() {
            synchronized (this) {
                Arrays.fill(this.f7418b, false);
                this.f7420d = true;
            }
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f7422a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String[] f7423b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c f7424c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set<String> f7425d;

        public d(c cVar, int[] iArr, String[] strArr) {
            this.f7424c = cVar;
            this.f7422a = iArr;
            this.f7423b = strArr;
            if (iArr.length != 1) {
                this.f7425d = null;
                return;
            }
            HashSet hashSet = new HashSet();
            hashSet.add(strArr[0]);
            this.f7425d = Collections.unmodifiableSet(hashSet);
        }

        public void a(Set<Integer> set) {
            int length = this.f7422a.length;
            Set<String> hashSet = null;
            for (int i10 = 0; i10 < length; i10++) {
                if (set.contains(Integer.valueOf(this.f7422a[i10]))) {
                    if (length == 1) {
                        hashSet = this.f7425d;
                    } else {
                        if (hashSet == null) {
                            hashSet = new HashSet<>(length);
                        }
                        hashSet.add(this.f7423b[i10]);
                    }
                }
            }
            if (hashSet != null) {
                this.f7424c.b(hashSet);
            }
        }

        public void b(String[] strArr) {
            Set<String> set = null;
            if (this.f7423b.length == 1) {
                int length = strArr.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        break;
                    }
                    if (strArr[i10].equalsIgnoreCase(this.f7423b[0])) {
                        set = this.f7425d;
                        break;
                    }
                    i10++;
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.f7423b;
                    int length2 = strArr2.length;
                    int i11 = 0;
                    while (true) {
                        if (i11 < length2) {
                            String str2 = strArr2[i11];
                            if (str2.equalsIgnoreCase(str)) {
                                hashSet.add(str2);
                                break;
                            }
                            i11++;
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.f7424c.b(set);
            }
        }
    }

    public static class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final h1 f7426b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakReference<c> f7427c;

        public e(h1 h1Var, c cVar) {
            super(cVar.f7421a);
            this.f7426b = h1Var;
            this.f7427c = new WeakReference<>(cVar);
        }

        @Override // androidx.room.h1.c
        public void b(@g.n0 Set<String> set) {
            c cVar = this.f7427c.get();
            if (cVar == null) {
                this.f7426b.m(this);
            } else {
                cVar.b(set);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public h1(RoomDatabase roomDatabase, String... strArr) {
        this(roomDatabase, new HashMap(), Collections.emptyMap(), strArr);
    }

    public static void c(StringBuilder sb2, String str, String str2) {
        sb2.append("`");
        sb2.append("room_table_modification_trigger_");
        sb2.append(str);
        sb2.append("_");
        sb2.append(str2);
        sb2.append("`");
    }

    public static void d(c2.d dVar) {
        if (dVar.G1()) {
            dVar.A0();
        } else {
            dVar.o();
        }
    }

    @g.j1
    @SuppressLint({"RestrictedApi"})
    public void a(@g.n0 c cVar) {
        d dVarG;
        String[] strArrN = n(cVar.f7421a);
        int[] iArr = new int[strArrN.length];
        int length = strArrN.length;
        for (int i10 = 0; i10 < length; i10++) {
            Integer num = this.f7399a.get(strArrN[i10].toLowerCase(Locale.US));
            if (num == null) {
                throw new IllegalArgumentException("There is no table with name " + strArrN[i10]);
            }
            iArr[i10] = num.intValue();
        }
        d dVar = new d(cVar, iArr, strArrN);
        synchronized (this.f7409k) {
            dVarG = this.f7409k.g(cVar, dVar);
        }
        if (dVarG == null && this.f7407i.b(iArr)) {
            t();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void b(c cVar) {
        a(new e(this, cVar));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public <T> LiveData<T> e(String[] strArr, Callable<T> callable) {
        return f(strArr, false, callable);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> f(String[] strArr, boolean z10, Callable<T> callable) {
        return this.f7408j.a(v(strArr), z10, callable);
    }

    public boolean g() {
        if (!this.f7403e.C()) {
            return false;
        }
        if (!this.f7405g) {
            this.f7403e.p().getWritableDatabase();
        }
        return this.f7405g;
    }

    public void h(c2.d dVar) {
        synchronized (this) {
            if (this.f7405g) {
                return;
            }
            dVar.C("PRAGMA temp_store = MEMORY;");
            dVar.C("PRAGMA recursive_triggers='ON';");
            dVar.C(f7396s);
            u(dVar);
            this.f7406h = dVar.K(f7397t);
            this.f7405g = true;
        }
    }

    @g.i1(otherwise = 3)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void i(String... strArr) {
        synchronized (this.f7409k) {
            for (Map.Entry<c, d> entry : this.f7409k) {
                if (!entry.getKey().a()) {
                    entry.getValue().b(strArr);
                }
            }
        }
    }

    public void j() {
        synchronized (this) {
            this.f7405g = false;
            this.f7407i.d();
        }
    }

    public void k() {
        if (this.f7404f.compareAndSet(false, true)) {
            androidx.room.a aVar = this.f7402d;
            if (aVar != null) {
                aVar.f();
            }
            this.f7403e.q().execute(this.f7412n);
        }
    }

    @g.j1
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void l() {
        androidx.room.a aVar = this.f7402d;
        if (aVar != null) {
            aVar.f();
        }
        t();
        this.f7412n.run();
    }

    @g.j1
    @SuppressLint({"RestrictedApi"})
    public void m(@g.n0 c cVar) {
        d dVarI;
        synchronized (this.f7409k) {
            dVarI = this.f7409k.i(cVar);
        }
        if (dVarI == null || !this.f7407i.c(dVarI.f7422a)) {
            return;
        }
        t();
    }

    public final String[] n(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.f7401c.containsKey(lowerCase)) {
                hashSet.addAll(this.f7401c.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public void o(androidx.room.a aVar) {
        this.f7402d = aVar;
        aVar.i(new Runnable() { // from class: androidx.room.g1
            @Override // java.lang.Runnable
            public final void run() {
                this.f7382a.j();
            }
        });
    }

    public void p(Context context, String str, Intent intent) {
        this.f7410l = new k1(context, str, intent, this, this.f7403e.q());
    }

    public final void q(c2.d dVar, int i10) {
        dVar.C("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i10 + ", 0)");
        String str = this.f7400b[i10];
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : f7392o) {
            sb2.setLength(0);
            sb2.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            c(sb2, str, str2);
            sb2.append(" AFTER ");
            sb2.append(str2);
            sb2.append(" ON `");
            sb2.append(str);
            sb2.append("` BEGIN UPDATE ");
            sb2.append(f7393p);
            sb2.append(" SET ");
            sb2.append(f7395r);
            sb2.append(" = 1");
            sb2.append(" WHERE ");
            sb2.append(f7394q);
            sb2.append(" = ");
            sb2.append(i10);
            sb2.append(" AND ");
            sb2.append(f7395r);
            sb2.append(" = 0");
            sb2.append("; END");
            dVar.C(sb2.toString());
        }
    }

    public void r() {
        k1 k1Var = this.f7410l;
        if (k1Var != null) {
            k1Var.a();
            this.f7410l = null;
        }
    }

    public final void s(c2.d dVar, int i10) {
        String str = this.f7400b[i10];
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : f7392o) {
            sb2.setLength(0);
            sb2.append("DROP TRIGGER IF EXISTS ");
            c(sb2, str, str2);
            dVar.C(sb2.toString());
        }
    }

    public void t() {
        if (this.f7403e.C()) {
            u(this.f7403e.p().getWritableDatabase());
        }
    }

    public void u(c2.d dVar) {
        if (dVar.x1()) {
            return;
        }
        try {
            Lock lockN = this.f7403e.n();
            lockN.lock();
            try {
                synchronized (this.f7411m) {
                    int[] iArrA = this.f7407i.a();
                    if (iArrA == null) {
                        return;
                    }
                    int length = iArrA.length;
                    d(dVar);
                    for (int i10 = 0; i10 < length; i10++) {
                        try {
                            int i11 = iArrA[i10];
                            if (i11 == 1) {
                                q(dVar, i10);
                            } else if (i11 == 2) {
                                s(dVar, i10);
                            }
                        } finally {
                            dVar.T0();
                        }
                    }
                    dVar.v0();
                }
            } finally {
                lockN.unlock();
            }
        } catch (SQLiteException | IllegalStateException unused) {
        }
    }

    public final String[] v(String[] strArr) {
        String[] strArrN = n(strArr);
        for (String str : strArrN) {
            if (!this.f7399a.containsKey(str.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        return strArrN;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public h1(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.f7402d = null;
        this.f7404f = new AtomicBoolean(false);
        this.f7405g = false;
        this.f7409k = new o.b<>();
        this.f7411m = new Object();
        this.f7412n = new a();
        this.f7403e = roomDatabase;
        this.f7407i = new b(strArr.length);
        this.f7399a = new HashMap<>();
        this.f7401c = map2;
        this.f7408j = new f1(roomDatabase);
        int length = strArr.length;
        this.f7400b = new String[length];
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.f7399a.put(lowerCase, Integer.valueOf(i10));
            String str2 = map.get(strArr[i10]);
            if (str2 != null) {
                this.f7400b[i10] = str2.toLowerCase(locale);
            } else {
                this.f7400b[i10] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            Locale locale2 = Locale.US;
            String lowerCase2 = value.toLowerCase(locale2);
            if (this.f7399a.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(locale2);
                HashMap<String, Integer> map3 = this.f7399a;
                map3.put(lowerCase3, map3.get(lowerCase2));
            }
        }
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String[] f7421a;

        public c(@g.n0 String str, String... strArr) {
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
            this.f7421a = strArr2;
            strArr2[strArr.length] = str;
        }

        public boolean a() {
            return false;
        }

        public abstract void b(@g.n0 Set<String> set);

        public c(@g.n0 String[] strArr) {
            this.f7421a = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }
}
