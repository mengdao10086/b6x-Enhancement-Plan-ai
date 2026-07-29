package io.objectbox;

import ii.a;
import ii.f;
import ii.k;
import ii.l;
import io.objectbox.BoxStore;
import io.objectbox.converter.PropertyConverter;
import io.objectbox.exception.DbException;
import io.objectbox.exception.DbExceptionListener;
import io.objectbox.exception.DbSchemaException;
import io.objectbox.internal.Feature;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;
import li.c;
import ni.d;
import pi.m;
import qt.b;
import si.e;

/* JADX INFO: loaded from: classes5.dex */
@ThreadSafe
public class BoxStore implements Closeable {
    public static final String A = "3.2.1-2022-07-05";
    public static BoxStore B = null;
    public static final Set<String> C = new HashSet();
    public static volatile Thread D = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public static Object f32613x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public static Object f32614y = null;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final String f32615z = "3.2.1";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f32616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f32617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f32618c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int[] f32623h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final k f32627l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f32628m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f32629n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f32630o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public volatile boolean f32632q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile int f32634s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f32635t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f32636u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final l<?> f32637v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    public e f32638w;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Class<?>, String> f32619d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Class<?>, Integer> f32620e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Class<?>, EntityInfo<?>> f32621f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b<Class<?>> f32622g = new b<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Class<?>, a<?>> f32624i = new ConcurrentHashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Set<Transaction> f32625j = Collections.newSetFromMap(new WeakHashMap());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ExecutorService f32626k = new ni.e(this);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ThreadLocal<Transaction> f32631p = new ThreadLocal<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Object f32633r = new Object();

    public BoxStore(f fVar) {
        f32613x = fVar.f32403f;
        f32614y = fVar.f32404g;
        d.b();
        File file = fVar.f32399b;
        this.f32616a = file;
        String strD1 = d1(file);
        this.f32617b = strD1;
        V2(strD1);
        try {
            long jNativeCreateWithFlatOptions = nativeCreateWithFlatOptions(fVar.g(strD1), fVar.f32398a);
            this.f32618c = jNativeCreateWithFlatOptions;
            if (jNativeCreateWithFlatOptions == 0) {
                throw new DbException("Could not create native store");
            }
            int i10 = fVar.f32406i;
            if (i10 != 0) {
                this.f32628m = (i10 & 1) != 0;
                this.f32629n = (i10 & 2) != 0;
            } else {
                this.f32629n = false;
                this.f32628m = false;
            }
            this.f32630o = fVar.f32408k;
            for (EntityInfo<?> entityInfo : fVar.f32419v) {
                try {
                    this.f32619d.put(entityInfo.getEntityClass(), entityInfo.getDbName());
                    int iNativeRegisterEntityClass = nativeRegisterEntityClass(this.f32618c, entityInfo.getDbName(), entityInfo.getEntityClass());
                    this.f32620e.put(entityInfo.getEntityClass(), Integer.valueOf(iNativeRegisterEntityClass));
                    this.f32622g.h(iNativeRegisterEntityClass, entityInfo.getEntityClass());
                    this.f32621f.put(entityInfo.getEntityClass(), entityInfo);
                    for (Property<?> property : entityInfo.getAllProperties()) {
                        Class<?> cls = property.customType;
                        if (cls != null) {
                            Class<? extends PropertyConverter> cls2 = property.converterClass;
                            if (cls2 == null) {
                                throw new RuntimeException("No converter class for custom type of " + property);
                            }
                            nativeRegisterCustomType(this.f32618c, iNativeRegisterEntityClass, 0, property.dbName, cls2, cls);
                        }
                    }
                } catch (RuntimeException e10) {
                    throw new RuntimeException("Could not setup up entity " + entityInfo.getEntityClass(), e10);
                }
            }
            int iL = this.f32622g.l();
            this.f32623h = new int[iL];
            long[] jArrG = this.f32622g.g();
            for (int i11 = 0; i11 < iL; i11++) {
                this.f32623h[i11] = (int) jArrG[i11];
            }
            this.f32627l = new k(this);
            this.f32637v = fVar.f32418u;
            this.f32636u = Math.max(fVar.f32412o, 1);
        } catch (RuntimeException e11) {
            close();
            throw e11;
        }
    }

    public static synchronized void H2(BoxStore boxStore) {
        if (B != null) {
            throw new IllegalStateException("Default store was already built before. ");
        }
        B = boxStore;
    }

    @c
    @Nullable
    public static synchronized Object L1() {
        return f32614y;
    }

    public static synchronized boolean M() {
        boolean z10;
        z10 = B != null;
        B = null;
        return z10;
    }

    @li.b
    public static long Q2(String str) {
        return nativeSysProcMeminfoKb(str);
    }

    @li.b
    public static long R2(String str) {
        return nativeSysProcStatusKb(str);
    }

    public static void V2(String str) {
        Set<String> set = C;
        synchronized (set) {
            r2(str);
            if (!set.add(str)) {
                throw new DbException("Another BoxStore is still open for this directory: " + str + ". Hint: for most apps it's recommended to keep a BoxStore for the app's life time.");
            }
        }
    }

    public static boolean W(File file) {
        if (!file.exists()) {
            return true;
        }
        if (r2(d1(file))) {
            throw new IllegalStateException("Cannot delete files: store is still open");
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            if (!file2.delete() && file2.exists()) {
                return false;
            }
        }
        return file.delete();
    }

    public static String Y1() {
        return A;
    }

    public static boolean Z(@Nullable File file, @Nullable String str) {
        return W(f.v(file, str));
    }

    public static boolean b0(Object obj, @Nullable String str) {
        return W(f.s(obj, str));
    }

    public static String d1(File file) {
        if (file.exists()) {
            if (!file.isDirectory()) {
                throw new DbException("Is not a directory: " + file.getAbsolutePath());
            }
        } else if (!file.mkdirs()) {
            throw new DbException("Could not create directory: " + file.getAbsolutePath());
        }
        try {
            return file.getCanonicalPath();
        } catch (IOException e10) {
            throw new DbException("Could not verify dir", e10);
        }
    }

    public static String f2() {
        d.b();
        return nativeGetVersion();
    }

    @c
    @Nullable
    public static synchronized Object h1() {
        return f32613x;
    }

    public static boolean h2(Feature feature) {
        try {
            d.b();
            return nativeHasFeature(feature.f32778id);
        } catch (UnsatisfiedLinkError e10) {
            System.err.println("Old JNI lib? " + e10);
            return false;
        }
    }

    public static synchronized BoxStore k1() {
        BoxStore boxStore;
        boxStore = B;
        if (boxStore == null) {
            throw new IllegalStateException("Please call buildDefault() before calling this method");
        }
        return boxStore;
    }

    public static boolean n2(File file) throws IOException {
        return r2(file.getCanonicalPath());
    }

    public static native long nativeBeginReadTx(long j10);

    public static native long nativeBeginTx(long j10);

    public static native int nativeCleanStaleReadTransactions(long j10);

    public static native long nativeCreateWithFlatOptions(byte[] bArr, byte[] bArr2);

    public static native void nativeDelete(long j10);

    public static native String nativeDiagnose(long j10);

    public static native void nativeDropAllData(long j10);

    public static native String nativeGetVersion();

    @c
    public static native long nativeGloballyActiveEntityTypes();

    private static native boolean nativeHasFeature(int i10);

    public static native boolean nativeIsObjectBrowserAvailable();

    public static native boolean nativeIsReadOnly(long j10);

    public static native void nativeRegisterCustomType(long j10, int i10, int i11, String str, Class<? extends PropertyConverter> cls, Class<?> cls2);

    public static native int nativeRegisterEntityClass(long j10, String str, Class<?> cls);

    public static native void nativeSetDbExceptionListener(long j10, @Nullable DbExceptionListener dbExceptionListener);

    public static native void nativeSetDebugFlags(long j10, int i10);

    private native String nativeStartObjectBrowser(long j10, @Nullable String str, int i10);

    private native boolean nativeStopObjectBrowser(long j10);

    public static native long nativeSysProcMeminfoKb(String str);

    public static native long nativeSysProcStatusKb(String str);

    public static boolean o2(@Nullable File file, @Nullable String str) throws IOException {
        return r2(f.v(file, str).getCanonicalPath());
    }

    public static boolean p2(Object obj, @Nullable String str) throws IOException {
        return r2(f.s(obj, str).getCanonicalPath());
    }

    public static boolean r2(final String str) {
        boolean zContains;
        Set<String> set = C;
        synchronized (set) {
            if (!set.contains(str)) {
                return false;
            }
            Thread thread = D;
            if (thread != null && thread.isAlive()) {
                return s2(str, false);
            }
            Thread thread2 = new Thread(new Runnable() { // from class: ii.d
                @Override // java.lang.Runnable
                public final void run() {
                    BoxStore.y2(str);
                }
            });
            thread2.setDaemon(true);
            D = thread2;
            thread2.start();
            try {
                thread2.join(500L);
            } catch (InterruptedException e10) {
                e10.printStackTrace();
            }
            Set<String> set2 = C;
            synchronized (set2) {
                zContains = set2.contains(str);
            }
            return zContains;
        }
    }

    public static boolean s2(String str, boolean z10) {
        boolean zContains;
        synchronized (C) {
            int i10 = 0;
            while (i10 < 5) {
                Set<String> set = C;
                if (!set.contains(str)) {
                    break;
                }
                i10++;
                System.gc();
                if (z10 && i10 > 1) {
                    System.runFinalization();
                }
                System.gc();
                if (z10 && i10 > 1) {
                    System.runFinalization();
                }
                try {
                    set.wait(100L);
                } catch (InterruptedException unused) {
                }
            }
            zContains = C.contains(str);
        }
        return zContains;
    }

    public static boolean t2() {
        return h2(Feature.ADMIN);
    }

    public static boolean v2() {
        return h2(Feature.SYNC);
    }

    public static boolean w2() {
        return h2(Feature.SYNC_SERVER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x2(Callable callable, l lVar) {
        try {
            Object objM = m(callable);
            if (lVar != null) {
                lVar.a(objM, null);
            }
        } catch (Throwable th2) {
            if (lVar != null) {
                lVar.a(null, th2);
            }
        }
    }

    public static /* synthetic */ void y2(String str) {
        s2(str, true);
        D = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z2(Runnable runnable, l lVar) {
        try {
            D2(runnable);
            if (lVar != null) {
                lVar.a(null, null);
            }
        } catch (Throwable th2) {
            if (lVar != null) {
                lVar.a(null, th2);
            }
        }
    }

    public long A2(int i10) {
        z();
        return nativePanicModeRemoveAllObjects(this.f32618c, i10);
    }

    public void B2() {
        z();
        nativeDropAllData(this.f32618c);
    }

    @li.b
    public int C1() {
        return this.f32635t;
    }

    public void C2(Runnable runnable) {
        if (this.f32631p.get() != null) {
            runnable.run();
            return;
        }
        Transaction transactionF = f();
        this.f32631p.set(transactionF);
        try {
            runnable.run();
        } finally {
            this.f32631p.remove();
            Iterator<a<?>> it2 = this.f32624i.values().iterator();
            while (it2.hasNext()) {
                it2.next().N(transactionF);
            }
            transactionF.close();
        }
    }

    public void D2(Runnable runnable) {
        Transaction transaction = this.f32631p.get();
        if (transaction != null) {
            if (transaction.e0()) {
                throw new IllegalStateException("Cannot start a transaction while a read only transaction is active");
            }
            runnable.run();
            return;
        }
        Transaction transactionH = h();
        this.f32631p.set(transactionH);
        try {
            runnable.run();
            transactionH.d();
        } finally {
            this.f32631p.remove();
            transactionH.close();
        }
    }

    public void E2(final Runnable runnable, @Nullable final l<Void> lVar) {
        this.f32626k.submit(new Runnable() { // from class: ii.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f32388a.z2(runnable, lVar);
            }
        });
    }

    public String F0() {
        z();
        return nativeDiagnose(this.f32618c);
    }

    public void F2(@Nullable DbExceptionListener dbExceptionListener) {
        z();
        nativeSetDbExceptionListener(this.f32618c, dbExceptionListener);
    }

    public Collection<Class<?>> G0() {
        return this.f32619d.keySet();
    }

    public void G2(int i10) {
        z();
        nativeSetDebugFlags(this.f32618c, i10);
    }

    public final void I() {
        try {
            if (this.f32626k.awaitTermination(1L, TimeUnit.SECONDS)) {
                return;
            }
            int iActiveCount = Thread.activeCount();
            System.err.println("Thread pool not terminated in time; printing stack traces...");
            Thread[] threadArr = new Thread[iActiveCount + 2];
            int iEnumerate = Thread.enumerate(threadArr);
            for (int i10 = 0; i10 < iEnumerate; i10++) {
                System.err.println("Thread: " + threadArr[i10].getName());
                Thread.dumpStack();
            }
        } catch (InterruptedException e10) {
            e10.printStackTrace();
        }
    }

    public void I2(@Nullable e eVar) {
        this.f32638w = eVar;
    }

    public long J2() {
        z();
        return nativeSizeOnDisk(this.f32618c);
    }

    @li.b
    @Nullable
    public String K2() {
        String strL2;
        W2();
        for (int i10 = 8090; i10 < 8100; i10++) {
            try {
                strL2 = L2(i10);
            } catch (DbException e10) {
                if (e10.getMessage() == null || !e10.getMessage().contains("port")) {
                    throw e10;
                }
            }
            if (strL2 != null) {
                return strL2;
            }
        }
        return null;
    }

    public int L() {
        z();
        return nativeCleanStaleReadTransactions(this.f32618c);
    }

    @li.b
    @Nullable
    public String L2(int i10) {
        W2();
        z();
        String strNativeStartObjectBrowser = nativeStartObjectBrowser(this.f32618c, null, i10);
        if (strNativeStartObjectBrowser != null) {
            this.f32635t = i10;
        }
        return strNativeStartObjectBrowser;
    }

    @c
    public int[] M0() {
        return this.f32623h;
    }

    @li.b
    @Nullable
    public String M2(String str) {
        W2();
        z();
        try {
            int port = new URL(str).getPort();
            String strNativeStartObjectBrowser = nativeStartObjectBrowser(this.f32618c, str, 0);
            if (strNativeStartObjectBrowser != null) {
                this.f32635t = port;
            }
            return strNativeStartObjectBrowser;
        } catch (MalformedURLException e10) {
            throw new RuntimeException("Can not start Object Browser at " + str, e10);
        }
    }

    @li.b
    public synchronized boolean N2() {
        if (this.f32635t == 0) {
            throw new IllegalStateException("ObjectBrowser has not been started before");
        }
        this.f32635t = 0;
        z();
        return nativeStopObjectBrowser(this.f32618c);
    }

    public m<Class> O2() {
        z();
        return new m<>(this.f32627l, null);
    }

    public void P() {
        Iterator<a<?>> it2 = this.f32624i.values().iterator();
        while (it2.hasNext()) {
            it2.next().b();
        }
    }

    public <T> m<Class<T>> P2(Class<T> cls) {
        z();
        return new m<>(this.f32627l, cls);
    }

    public void S2(Transaction transaction, @Nullable int[] iArr) {
        synchronized (this.f32633r) {
            this.f32634s++;
            if (this.f32629n) {
                PrintStream printStream = System.out;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("TX committed. New commit count: ");
                sb2.append(this.f32634s);
                sb2.append(", entity types affected: ");
                sb2.append(iArr != null ? iArr.length : 0);
                printStream.println(sb2.toString());
            }
        }
        Iterator<a<?>> it2 = this.f32624i.values().iterator();
        while (it2.hasNext()) {
            it2.next().Y(transaction);
        }
        if (iArr != null) {
            this.f32627l.e(iArr);
        }
    }

    public boolean T() {
        if (this.f32632q) {
            return W(this.f32616a);
        }
        throw new IllegalStateException("Store must be closed");
    }

    @c
    public void T2(Transaction transaction) {
        synchronized (this.f32625j) {
            this.f32625j.remove(transaction);
        }
    }

    @li.a
    public long U2(long j10, boolean z10) {
        if (j10 < 0) {
            throw new IllegalArgumentException("pageLimit must be zero or positive");
        }
        z();
        return nativeValidate(this.f32618c, j10, z10);
    }

    @Nullable
    public e V1() {
        return this.f32638w;
    }

    public final void W2() {
        if (this.f32635t == 0) {
            return;
        }
        throw new DbException("ObjectBrowser is already running at port " + this.f32635t);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        boolean z10;
        ArrayList arrayList;
        synchronized (this) {
            z10 = this.f32632q;
            if (!this.f32632q) {
                if (this.f32635t != 0) {
                    try {
                        N2();
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                }
                this.f32632q = true;
                synchronized (this.f32625j) {
                    arrayList = new ArrayList(this.f32625j);
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    ((Transaction) it2.next()).close();
                }
                long j10 = this.f32618c;
                if (j10 != 0) {
                    nativeDelete(j10);
                }
                this.f32626k.shutdown();
                I();
            }
        }
        if (z10) {
            return;
        }
        Set<String> set = C;
        synchronized (set) {
            set.remove(this.f32617b);
            set.notifyAll();
        }
    }

    public boolean e0() {
        z();
        return nativeIsReadOnly(this.f32618c);
    }

    @c
    public Transaction f() {
        z();
        int i10 = this.f32634s;
        if (this.f32628m) {
            System.out.println("Begin read TX with commit count " + i10);
        }
        long jNativeBeginReadTx = nativeBeginReadTx(this.f32618c);
        if (jNativeBeginReadTx == 0) {
            throw new DbException("Could not create native read transaction");
        }
        Transaction transaction = new Transaction(this, jNativeBeginReadTx, i10);
        synchronized (this.f32625j) {
            this.f32625j.add(transaction);
        }
        return transaction;
    }

    public void finalize() throws Throwable {
        close();
        super.finalize();
    }

    @c
    public Transaction h() {
        z();
        int i10 = this.f32634s;
        if (this.f32629n) {
            System.out.println("Begin TX with commit count " + i10);
        }
        long jNativeBeginTx = nativeBeginTx(this.f32618c);
        if (jNativeBeginTx == 0) {
            throw new DbException("Could not create native transaction");
        }
        Transaction transaction = new Transaction(this, jNativeBeginTx, i10);
        synchronized (this.f32625j) {
            this.f32625j.add(transaction);
        }
        return transaction;
    }

    public <T> a<T> i(Class<T> cls) {
        a<?> aVar;
        a<T> aVar2 = (a) this.f32624i.get(cls);
        if (aVar2 != null) {
            return aVar2;
        }
        if (!this.f32619d.containsKey(cls)) {
            throw new IllegalArgumentException(cls + " is not a known entity. Please add it and trigger generation again.");
        }
        synchronized (this.f32624i) {
            aVar = this.f32624i.get(cls);
            if (aVar == null) {
                aVar = new a<>(this, cls);
                this.f32624i.put(cls, aVar);
            }
        }
        return (a<T>) aVar;
    }

    public String i1(Class<?> cls) {
        return this.f32619d.get(cls);
    }

    @c
    public l<?> i2() {
        return this.f32637v;
    }

    public boolean isClosed() {
        return this.f32632q;
    }

    @c
    public long j2() {
        return this.f32618c;
    }

    public <T> T k(Callable<T> callable) {
        if (this.f32631p.get() != null) {
            try {
                return callable.call();
            } catch (Exception e10) {
                throw new RuntimeException("Callable threw exception", e10);
            }
        }
        Transaction transactionF = f();
        this.f32631p.set(transactionF);
        try {
            try {
                return callable.call();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception e12) {
                throw new RuntimeException("Callable threw exception", e12);
            }
        } finally {
            this.f32631p.remove();
            Iterator<a<?>> it2 = this.f32624i.values().iterator();
            while (it2.hasNext()) {
                it2.next().N(transactionF);
            }
            transactionF.close();
        }
    }

    @c
    public int k2() {
        return this.f32636u;
    }

    @li.b
    public <T> T l(Callable<T> callable, int i10, int i11, boolean z10) {
        if (i10 == 1) {
            return (T) k(callable);
        }
        if (i10 < 1) {
            throw new IllegalArgumentException("Illegal value of attempts: " + i10);
        }
        long j10 = i11;
        DbException e10 = null;
        for (int i12 = 1; i12 <= i10; i12++) {
            try {
                return (T) k(callable);
            } catch (DbException e11) {
                e10 = e11;
                String strF0 = F0();
                String str = i12 + " of " + i10 + " attempts of calling a read TX failed:";
                if (z10) {
                    System.err.println(str);
                    e10.printStackTrace();
                    System.err.println(strF0);
                    System.err.flush();
                    System.gc();
                    System.runFinalization();
                    L();
                }
                l<?> lVar = this.f32637v;
                if (lVar != null) {
                    lVar.a(null, new DbException(str + " \n" + strF0, e10));
                }
                try {
                    Thread.sleep(j10);
                    j10 *= 2;
                } catch (InterruptedException e12) {
                    e12.printStackTrace();
                    throw e10;
                }
            }
        }
        throw e10;
    }

    @c
    public Future<?> l2(Runnable runnable) {
        return this.f32626k.submit(runnable);
    }

    public <R> R m(Callable<R> callable) throws Exception {
        Transaction transaction = this.f32631p.get();
        if (transaction != null) {
            if (transaction.e0()) {
                throw new IllegalStateException("Cannot start a transaction while a read only transaction is active");
            }
            return callable.call();
        }
        Transaction transactionH = h();
        this.f32631p.set(transactionH);
        try {
            R rCall = callable.call();
            transactionH.d();
            return rCall;
        } finally {
            this.f32631p.remove();
            transactionH.close();
        }
    }

    @c
    public Class<?> m1(int i10) {
        Class<?> clsF = this.f32622g.f(i10);
        if (clsF != null) {
            return clsF;
        }
        throw new DbSchemaException("No entity registered for type ID " + i10);
    }

    @c
    public ExecutorService m2() {
        return this.f32626k;
    }

    public <R> void n(final Callable<R> callable, @Nullable final l<R> lVar) {
        this.f32626k.submit(new Runnable() { // from class: ii.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f32391a.x2(callable, lVar);
            }
        });
    }

    public native long nativePanicModeRemoveAllObjects(long j10, int i10);

    public native long nativeSizeOnDisk(long j10);

    public native long nativeValidate(long j10, long j11, boolean z10);

    @c
    public <T> EntityInfo<T> p1(Class<T> cls) {
        return (EntityInfo) this.f32621f.get(cls);
    }

    @c
    public boolean q2() {
        return this.f32630o;
    }

    public Integer s1(Class<?> cls) {
        return this.f32620e.get(cls);
    }

    public <R> R u(Callable<R> callable) {
        try {
            return (R) m(callable);
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }

    @c
    public int u1(Class<?> cls) {
        Integer num = this.f32620e.get(cls);
        if (num != null) {
            return num.intValue();
        }
        throw new DbSchemaException("No entity registered for " + cls);
    }

    public boolean u2() {
        return this.f32635t != 0;
    }

    public final void z() {
        if (this.f32632q) {
            throw new IllegalStateException("Store is closed");
        }
    }

    public long z1() {
        z();
        return this.f32618c;
    }
}
