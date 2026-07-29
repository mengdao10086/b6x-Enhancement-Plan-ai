package xa;

import java.util.List;
import xa.h.a;

/* JADX INFO: loaded from: classes3.dex */
public class h<T extends a> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f54989g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f54990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f54991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f54992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f54993d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f54994e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f54995f;

    public static abstract class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f54996b = -1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f54997a = f54996b;

        public abstract a a();
    }

    public h(int i10, T t10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Object Pool must be instantiated with a capacity greater than 0!");
        }
        this.f54991b = i10;
        this.f54992c = new Object[i10];
        this.f54993d = 0;
        this.f54994e = t10;
        this.f54995f = 1.0f;
        i();
    }

    /* JADX WARN: In static synchronized method top region not synchronized by class const: (wrap:java.lang.Class:0x0000: CONST_CLASS  A[WRAPPED] xa.h.class) */
    public static synchronized h a(int i10, a aVar) {
        h hVar;
        synchronized (h.class) {
            hVar = new h(i10, aVar);
            int i11 = f54989g;
            hVar.f54990a = i11;
            f54989g = i11 + 1;
        }
        return hVar;
    }

    public synchronized T b() {
        T t10;
        if (this.f54993d == -1 && this.f54995f > 0.0f) {
            i();
        }
        Object[] objArr = this.f54992c;
        int i10 = this.f54993d;
        t10 = (T) objArr[i10];
        t10.f54997a = a.f54996b;
        this.f54993d = i10 - 1;
        return t10;
    }

    public int c() {
        return this.f54992c.length;
    }

    public int d() {
        return this.f54993d + 1;
    }

    public int e() {
        return this.f54990a;
    }

    public float f() {
        return this.f54995f;
    }

    public synchronized void g(List<T> list) {
        while (list.size() + this.f54993d + 1 > this.f54991b) {
            k();
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            T t10 = list.get(i10);
            int i11 = t10.f54997a;
            if (i11 != a.f54996b) {
                if (i11 == this.f54990a) {
                    throw new IllegalArgumentException("The object passed is already stored in this pool!");
                }
                throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t10.f54997a + ".  Object cannot belong to two different pool instances simultaneously!");
            }
            t10.f54997a = this.f54990a;
            this.f54992c[this.f54993d + 1 + i10] = t10;
        }
        this.f54993d += size;
    }

    public synchronized void h(T t10) {
        int i10 = t10.f54997a;
        if (i10 != a.f54996b) {
            if (i10 == this.f54990a) {
                throw new IllegalArgumentException("The object passed is already stored in this pool!");
            }
            throw new IllegalArgumentException("The object to recycle already belongs to poolId " + t10.f54997a + ".  Object cannot belong to two different pool instances simultaneously!");
        }
        int i11 = this.f54993d + 1;
        this.f54993d = i11;
        if (i11 >= this.f54992c.length) {
            k();
        }
        t10.f54997a = this.f54990a;
        this.f54992c[this.f54993d] = t10;
    }

    public final void i() {
        j(this.f54995f);
    }

    public final void j(float f10) {
        int i10 = this.f54991b;
        int i11 = (int) (i10 * f10);
        if (i11 < 1) {
            i10 = 1;
        } else if (i11 <= i10) {
            i10 = i11;
        }
        for (int i12 = 0; i12 < i10; i12++) {
            this.f54992c[i12] = this.f54994e.a();
        }
        this.f54993d = i10 - 1;
    }

    public final void k() {
        int i10 = this.f54991b;
        int i11 = i10 * 2;
        this.f54991b = i11;
        Object[] objArr = new Object[i11];
        for (int i12 = 0; i12 < i10; i12++) {
            objArr[i12] = this.f54992c[i12];
        }
        this.f54992c = objArr;
    }

    public void l(float f10) {
        if (f10 > 1.0f) {
            f10 = 1.0f;
        } else if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        this.f54995f = f10;
    }
}
