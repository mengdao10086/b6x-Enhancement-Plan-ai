package androidx.versionedparcelable;

import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.NetworkOnMainThreadException;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseBooleanArray;
import androidx.annotation.RestrictTo;
import androidx.collection.c;
import g.n0;
import g.v0;
import i2.e;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class VersionedParcel {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f8038d = "VersionedParcel";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f8039e = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f8040f = -2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f8041g = -3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f8042h = -4;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f8043i = -5;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f8044j = -6;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f8045k = -7;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f8046l = -9;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f8047m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f8048n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f8049o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f8050p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f8051q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f8052r = 7;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f8053s = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.collection.a<String, Method> f8054a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.collection.a<String, Method> f8055b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final androidx.collection.a<String, Class> f8056c;

    public static class ParcelException extends RuntimeException {
        public ParcelException(Throwable th2) {
            super(th2);
        }
    }

    public class a extends ObjectInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException, IOException {
            Class<?> cls = Class.forName(objectStreamClass.getName(), false, getClass().getClassLoader());
            return cls != null ? cls : super.resolveClass(objectStreamClass);
        }
    }

    public VersionedParcel(androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        this.f8054a = aVar;
        this.f8055b = aVar2;
        this.f8056c = aVar3;
    }

    @n0
    public static Throwable f(@n0 Throwable th2) {
        while (th2.getCause() != null) {
            th2 = th2.getCause();
        }
        return th2;
    }

    public double[] A() {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        double[] dArr = new double[iL];
        for (int i10 = 0; i10 < iL; i10++) {
            dArr[i10] = y();
        }
        return dArr;
    }

    public final <T> void A0(Collection<T> collection) {
        if (collection == null) {
            L0(-1);
        }
        int size = collection.size();
        L0(size);
        if (size > 0) {
            int iG = g(collection.iterator().next());
            L0(iG);
            switch (iG) {
                case 1:
                    Iterator<T> it2 = collection.iterator();
                    while (it2.hasNext()) {
                        l1((e) it2.next());
                    }
                    break;
                case 2:
                    Iterator<T> it3 = collection.iterator();
                    while (it3.hasNext()) {
                        W0((Parcelable) it3.next());
                    }
                    break;
                case 3:
                    Iterator<T> it4 = collection.iterator();
                    while (it4.hasNext()) {
                        Y0((Serializable) it4.next());
                    }
                    break;
                case 4:
                    Iterator<T> it5 = collection.iterator();
                    while (it5.hasNext()) {
                        e1((String) it5.next());
                    }
                    break;
                case 5:
                    Iterator<T> it6 = collection.iterator();
                    while (it6.hasNext()) {
                        g1((IBinder) it6.next());
                    }
                    break;
                case 7:
                    Iterator<T> it7 = collection.iterator();
                    while (it7.hasNext()) {
                        L0(((Integer) it7.next()).intValue());
                    }
                    break;
                case 8:
                    Iterator<T> it8 = collection.iterator();
                    while (it8.hasNext()) {
                        H0(((Float) it8.next()).floatValue());
                    }
                    break;
            }
        }
    }

    public double[] B(double[] dArr, int i10) {
        return !F(i10) ? dArr : A();
    }

    public final <T> void B0(Collection<T> collection, int i10) {
        i0(i10);
        A0(collection);
    }

    public final Exception C(int i10, String str) {
        return b(i10, str);
    }

    public abstract void C0(double d10);

    public Exception D(Exception exc, int i10) {
        int iE;
        return (F(i10) && (iE = E()) != 0) ? C(iE, c0()) : exc;
    }

    public void D0(double d10, int i10) {
        i0(i10);
        C0(d10);
    }

    public final int E() {
        return L();
    }

    public void E0(double[] dArr) {
        if (dArr == null) {
            L0(-1);
            return;
        }
        L0(dArr.length);
        for (double d10 : dArr) {
            C0(d10);
        }
    }

    public abstract boolean F(int i10);

    public void F0(double[] dArr, int i10) {
        i0(i10);
        E0(dArr);
    }

    public abstract float G();

    /* JADX WARN: Multi-variable type inference failed */
    public void G0(Exception exc, int i10) {
        i0(i10);
        if (exc == 0) {
            V0();
            return;
        }
        int i11 = 0;
        if ((exc instanceof Parcelable) && exc.getClass().getClassLoader() == Parcelable.class.getClassLoader()) {
            i11 = -9;
        } else if (exc instanceof SecurityException) {
            i11 = -1;
        } else if (exc instanceof BadParcelableException) {
            i11 = -2;
        } else if (exc instanceof IllegalArgumentException) {
            i11 = -3;
        } else if (exc instanceof NullPointerException) {
            i11 = -4;
        } else if (exc instanceof IllegalStateException) {
            i11 = -5;
        } else if (exc instanceof NetworkOnMainThreadException) {
            i11 = -6;
        } else if (exc instanceof UnsupportedOperationException) {
            i11 = -7;
        }
        L0(i11);
        if (i11 == 0) {
            if (!(exc instanceof RuntimeException)) {
                throw new RuntimeException(exc);
            }
            throw ((RuntimeException) exc);
        }
        e1(exc.getMessage());
        if (i11 != -9) {
            return;
        }
        W0((Parcelable) exc);
    }

    public float H(float f10, int i10) {
        return !F(i10) ? f10 : G();
    }

    public abstract void H0(float f10);

    public float[] I() {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        float[] fArr = new float[iL];
        for (int i10 = 0; i10 < iL; i10++) {
            fArr[i10] = G();
        }
        return fArr;
    }

    public void I0(float f10, int i10) {
        i0(i10);
        H0(f10);
    }

    public float[] J(float[] fArr, int i10) {
        return !F(i10) ? fArr : I();
    }

    public void J0(float[] fArr) {
        if (fArr == null) {
            L0(-1);
            return;
        }
        L0(fArr.length);
        for (float f10 : fArr) {
            H0(f10);
        }
    }

    public <T extends e> T K(String str, VersionedParcel versionedParcel) {
        try {
            return (T) e(str).invoke(null, versionedParcel);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (InvocationTargetException e13) {
            if (e13.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e13.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e13);
        }
    }

    public void K0(float[] fArr, int i10) {
        i0(i10);
        J0(fArr);
    }

    public abstract int L();

    public abstract void L0(int i10);

    public int M(int i10, int i11) {
        return !F(i11) ? i10 : L();
    }

    public void M0(int i10, int i11) {
        i0(i11);
        L0(i10);
    }

    public int[] N() {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        int[] iArr = new int[iL];
        for (int i10 = 0; i10 < iL; i10++) {
            iArr[i10] = L();
        }
        return iArr;
    }

    public void N0(int[] iArr) {
        if (iArr == null) {
            L0(-1);
            return;
        }
        L0(iArr.length);
        for (int i10 : iArr) {
            L0(i10);
        }
    }

    public int[] O(int[] iArr, int i10) {
        return !F(i10) ? iArr : N();
    }

    public void O0(int[] iArr, int i10) {
        i0(i10);
        N0(iArr);
    }

    public <T> List<T> P(List<T> list, int i10) {
        return !F(i10) ? list : (List) x(new ArrayList());
    }

    public <T> void P0(List<T> list, int i10) {
        B0(list, i10);
    }

    public abstract long Q();

    public abstract void Q0(long j10);

    public long R(long j10, int i10) {
        return !F(i10) ? j10 : Q();
    }

    public void R0(long j10, int i10) {
        i0(i10);
        Q0(j10);
    }

    public long[] S() {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        long[] jArr = new long[iL];
        for (int i10 = 0; i10 < iL; i10++) {
            jArr[i10] = Q();
        }
        return jArr;
    }

    public void S0(long[] jArr) {
        if (jArr == null) {
            L0(-1);
            return;
        }
        L0(jArr.length);
        for (long j10 : jArr) {
            Q0(j10);
        }
    }

    public long[] T(long[] jArr, int i10) {
        return !F(i10) ? jArr : S();
    }

    public void T0(long[] jArr, int i10) {
        i0(i10);
        S0(jArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <K, V> Map<K, V> U(Map<K, V> map, int i10) {
        if (!F(i10)) {
            return map;
        }
        int iL = L();
        if (iL < 0) {
            return null;
        }
        androidx.collection.a aVar = new androidx.collection.a();
        if (iL == 0) {
            return aVar;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        x(arrayList);
        x(arrayList2);
        for (int i11 = 0; i11 < iL; i11++) {
            aVar.put(arrayList.get(i11), arrayList2.get(i11));
        }
        return aVar;
    }

    public <K, V> void U0(Map<K, V> map, int i10) {
        i0(i10);
        if (map == null) {
            L0(-1);
            return;
        }
        int size = map.size();
        L0(size);
        if (size == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList2.add(entry.getValue());
        }
        A0(arrayList);
        A0(arrayList2);
    }

    public abstract <T extends Parcelable> T V();

    public void V0() {
        L0(0);
    }

    public <T extends Parcelable> T W(T t10, int i10) {
        return !F(i10) ? t10 : (T) V();
    }

    public abstract void W0(Parcelable parcelable);

    public Serializable X() {
        String strC0 = c0();
        if (strC0 == null) {
            return null;
        }
        try {
            return (Serializable) new a(new ByteArrayInputStream(s())).readObject();
        } catch (IOException e10) {
            throw new RuntimeException("VersionedParcelable encountered IOException reading a Serializable object (name = " + strC0 + ee.a.f26979d, e10);
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException("VersionedParcelable encountered ClassNotFoundException reading a Serializable object (name = " + strC0 + ee.a.f26979d, e11);
        }
    }

    public void X0(Parcelable parcelable, int i10) {
        i0(i10);
        W0(parcelable);
    }

    public <T> Set<T> Y(Set<T> set, int i10) {
        return !F(i10) ? set : (Set) x(new c());
    }

    public final void Y0(Serializable serializable) {
        if (serializable == null) {
            e1(null);
            return;
        }
        String name = serializable.getClass().getName();
        e1(name);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            t0(byteArrayOutputStream.toByteArray());
        } catch (IOException e10) {
            throw new RuntimeException("VersionedParcelable encountered IOException writing serializable object (name = " + name + ee.a.f26979d, e10);
        }
    }

    @v0(api = 21)
    public Size Z(Size size, int i10) {
        if (!F(i10)) {
            return size;
        }
        if (l()) {
            return new Size(L(), L());
        }
        return null;
    }

    public void Z0(Serializable serializable, int i10) {
        i0(i10);
        Y0(serializable);
    }

    public abstract void a();

    @v0(api = 21)
    public SizeF a0(SizeF sizeF, int i10) {
        if (!F(i10)) {
            return sizeF;
        }
        if (l()) {
            return new SizeF(G(), G());
        }
        return null;
    }

    public <T> void a1(Set<T> set, int i10) {
        B0(set, i10);
    }

    public final Exception b(int i10, String str) {
        switch (i10) {
            case -9:
                return (Exception) V();
            case -8:
            default:
                return new RuntimeException("Unknown exception code: " + i10 + " msg " + str);
            case -7:
                return new UnsupportedOperationException(str);
            case -6:
                return new NetworkOnMainThreadException();
            case -5:
                return new IllegalStateException(str);
            case -4:
                return new NullPointerException(str);
            case -3:
                return new IllegalArgumentException(str);
            case -2:
                return new BadParcelableException(str);
            case -1:
                return new SecurityException(str);
        }
    }

    public SparseBooleanArray b0(SparseBooleanArray sparseBooleanArray, int i10) {
        if (!F(i10)) {
            return sparseBooleanArray;
        }
        int iL = L();
        if (iL < 0) {
            return null;
        }
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray(iL);
        for (int i11 = 0; i11 < iL; i11++) {
            sparseBooleanArray2.put(L(), l());
        }
        return sparseBooleanArray2;
    }

    @v0(api = 21)
    public void b1(Size size, int i10) {
        i0(i10);
        m0(size != null);
        if (size != null) {
            L0(size.getWidth());
            L0(size.getHeight());
        }
    }

    public abstract VersionedParcel c();

    public abstract String c0();

    @v0(api = 21)
    public void c1(SizeF sizeF, int i10) {
        i0(i10);
        m0(sizeF != null);
        if (sizeF != null) {
            H0(sizeF.getWidth());
            H0(sizeF.getHeight());
        }
    }

    public final Class d(Class<? extends e> cls) throws ClassNotFoundException {
        Class cls2 = this.f8056c.get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f8056c.put(cls.getName(), cls3);
        return cls3;
    }

    public String d0(String str, int i10) {
        return !F(i10) ? str : c0();
    }

    public void d1(SparseBooleanArray sparseBooleanArray, int i10) {
        i0(i10);
        if (sparseBooleanArray == null) {
            L0(-1);
            return;
        }
        int size = sparseBooleanArray.size();
        L0(size);
        for (int i11 = 0; i11 < size; i11++) {
            L0(sparseBooleanArray.keyAt(i11));
            m0(sparseBooleanArray.valueAt(i11));
        }
    }

    public final Method e(String str) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f8054a.get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, VersionedParcel.class.getClassLoader()).getDeclaredMethod("read", VersionedParcel.class);
        this.f8054a.put(str, declaredMethod);
        return declaredMethod;
    }

    public abstract IBinder e0();

    public abstract void e1(String str);

    public IBinder f0(IBinder iBinder, int i10) {
        return !F(i10) ? iBinder : e0();
    }

    public void f1(String str, int i10) {
        i0(i10);
        e1(str);
    }

    public final <T> int g(T t10) {
        if (t10 instanceof String) {
            return 4;
        }
        if (t10 instanceof Parcelable) {
            return 2;
        }
        if (t10 instanceof e) {
            return 1;
        }
        if (t10 instanceof Serializable) {
            return 3;
        }
        if (t10 instanceof IBinder) {
            return 5;
        }
        if (t10 instanceof Integer) {
            return 7;
        }
        if (t10 instanceof Float) {
            return 8;
        }
        throw new IllegalArgumentException(t10.getClass().getName() + " cannot be VersionedParcelled");
    }

    public <T extends e> T g0() {
        String strC0 = c0();
        if (strC0 == null) {
            return null;
        }
        return (T) K(strC0, c());
    }

    public abstract void g1(IBinder iBinder);

    /* JADX WARN: Multi-variable type inference failed */
    public final Method h(Class cls) throws IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method = this.f8055b.get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsD = d(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsD.getDeclaredMethod("write", cls, VersionedParcel.class);
        this.f8055b.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public <T extends e> T h0(T t10, int i10) {
        return !F(i10) ? t10 : (T) g0();
    }

    public void h1(IBinder iBinder, int i10) {
        i0(i10);
        g1(iBinder);
    }

    public boolean i() {
        return false;
    }

    public abstract void i0(int i10);

    public abstract void i1(IInterface iInterface);

    public <T> T[] j(T[] tArr) {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(iL);
        if (iL != 0) {
            int iL2 = L();
            if (iL < 0) {
                return null;
            }
            if (iL2 == 1) {
                while (iL > 0) {
                    arrayList.add(g0());
                    iL--;
                }
            } else if (iL2 == 2) {
                while (iL > 0) {
                    arrayList.add(V());
                    iL--;
                }
            } else if (iL2 == 3) {
                while (iL > 0) {
                    arrayList.add(X());
                    iL--;
                }
            } else if (iL2 == 4) {
                while (iL > 0) {
                    arrayList.add(c0());
                    iL--;
                }
            } else if (iL2 == 5) {
                while (iL > 0) {
                    arrayList.add(e0());
                    iL--;
                }
            }
        }
        return (T[]) arrayList.toArray(tArr);
    }

    public void j0(boolean z10, boolean z11) {
    }

    public void j1(IInterface iInterface, int i10) {
        i0(i10);
        i1(iInterface);
    }

    public <T> T[] k(T[] tArr, int i10) {
        return !F(i10) ? tArr : (T[]) j(tArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void k0(T[] tArr) {
        if (tArr == 0) {
            L0(-1);
            return;
        }
        int length = tArr.length;
        L0(length);
        if (length > 0) {
            int i10 = 0;
            int iG = g(tArr[0]);
            L0(iG);
            if (iG == 1) {
                while (i10 < length) {
                    l1((e) tArr[i10]);
                    i10++;
                }
                return;
            }
            if (iG == 2) {
                while (i10 < length) {
                    W0((Parcelable) tArr[i10]);
                    i10++;
                }
                return;
            }
            if (iG == 3) {
                while (i10 < length) {
                    Y0((Serializable) tArr[i10]);
                    i10++;
                }
            } else if (iG == 4) {
                while (i10 < length) {
                    e1((String) tArr[i10]);
                    i10++;
                }
            } else {
                if (iG != 5) {
                    return;
                }
                while (i10 < length) {
                    g1((IBinder) tArr[i10]);
                    i10++;
                }
            }
        }
    }

    public <T extends e> void k1(T t10, VersionedParcel versionedParcel) {
        try {
            h(t10.getClass()).invoke(null, t10, versionedParcel);
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e10);
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e11);
        } catch (NoSuchMethodException e12) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e12);
        } catch (InvocationTargetException e13) {
            if (!(e13.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e13);
            }
            throw ((RuntimeException) e13.getCause());
        }
    }

    public abstract boolean l();

    public <T> void l0(T[] tArr, int i10) {
        i0(i10);
        k0(tArr);
    }

    public void l1(e eVar) {
        if (eVar == null) {
            e1(null);
            return;
        }
        n1(eVar);
        VersionedParcel versionedParcelC = c();
        k1(eVar, versionedParcelC);
        versionedParcelC.a();
    }

    public boolean m(boolean z10, int i10) {
        return !F(i10) ? z10 : l();
    }

    public abstract void m0(boolean z10);

    public void m1(e eVar, int i10) {
        i0(i10);
        l1(eVar);
    }

    public boolean[] n() {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        boolean[] zArr = new boolean[iL];
        for (int i10 = 0; i10 < iL; i10++) {
            zArr[i10] = L() != 0;
        }
        return zArr;
    }

    public void n0(boolean z10, int i10) {
        i0(i10);
        m0(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n1(e eVar) {
        try {
            e1(d(eVar.getClass()).getName());
        } catch (ClassNotFoundException e10) {
            throw new RuntimeException(eVar.getClass().getSimpleName() + " does not have a Parcelizer", e10);
        }
    }

    public boolean[] o(boolean[] zArr, int i10) {
        return !F(i10) ? zArr : n();
    }

    public void o0(boolean[] zArr) {
        if (zArr == null) {
            L0(-1);
            return;
        }
        L0(zArr.length);
        for (boolean z10 : zArr) {
            L0(z10 ? 1 : 0);
        }
    }

    public abstract Bundle p();

    public void p0(boolean[] zArr, int i10) {
        i0(i10);
        o0(zArr);
    }

    public Bundle q(Bundle bundle, int i10) {
        return !F(i10) ? bundle : p();
    }

    public abstract void q0(Bundle bundle);

    public byte r(byte b10, int i10) {
        return !F(i10) ? b10 : (byte) (L() & 255);
    }

    public void r0(Bundle bundle, int i10) {
        i0(i10);
        q0(bundle);
    }

    public abstract byte[] s();

    public void s0(byte b10, int i10) {
        i0(i10);
        L0(b10);
    }

    public byte[] t(byte[] bArr, int i10) {
        return !F(i10) ? bArr : s();
    }

    public abstract void t0(byte[] bArr);

    public char[] u(char[] cArr, int i10) {
        if (!F(i10)) {
            return cArr;
        }
        int iL = L();
        if (iL < 0) {
            return null;
        }
        char[] cArr2 = new char[iL];
        for (int i11 = 0; i11 < iL; i11++) {
            cArr2[i11] = (char) L();
        }
        return cArr2;
    }

    public void u0(byte[] bArr, int i10) {
        i0(i10);
        t0(bArr);
    }

    public abstract CharSequence v();

    public abstract void v0(byte[] bArr, int i10, int i11);

    public CharSequence w(CharSequence charSequence, int i10) {
        return !F(i10) ? charSequence : v();
    }

    public void w0(byte[] bArr, int i10, int i11, int i12) {
        i0(i12);
        v0(bArr, i10, i11);
    }

    public final <T, S extends Collection<T>> S x(S s10) {
        int iL = L();
        if (iL < 0) {
            return null;
        }
        if (iL != 0) {
            int iL2 = L();
            if (iL < 0) {
                return null;
            }
            if (iL2 == 1) {
                while (iL > 0) {
                    s10.add(g0());
                    iL--;
                }
            } else if (iL2 == 2) {
                while (iL > 0) {
                    s10.add(V());
                    iL--;
                }
            } else if (iL2 == 3) {
                while (iL > 0) {
                    s10.add(X());
                    iL--;
                }
            } else if (iL2 == 4) {
                while (iL > 0) {
                    s10.add(c0());
                    iL--;
                }
            } else if (iL2 == 5) {
                while (iL > 0) {
                    s10.add(e0());
                    iL--;
                }
            }
        }
        return s10;
    }

    public void x0(char[] cArr, int i10) {
        i0(i10);
        if (cArr == null) {
            L0(-1);
            return;
        }
        L0(cArr.length);
        for (char c10 : cArr) {
            L0(c10);
        }
    }

    public abstract double y();

    public abstract void y0(CharSequence charSequence);

    public double z(double d10, int i10) {
        return !F(i10) ? d10 : y();
    }

    public void z0(CharSequence charSequence, int i10) {
        i0(i10);
        y0(charSequence);
    }
}
