package gm;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.bouncycastle.util.a;

/* JADX INFO: loaded from: classes5.dex */
public abstract class f0 extends c0 implements org.bouncycastle.util.k<h> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t0 f29677b = new a(f0.class, 16);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public h[] f29678a;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 d(f0 f0Var) {
            return f0Var;
        }
    }

    public class b implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f29679a = 0;

        public b() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f29679a < f0.this.f29678a.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            int i10 = this.f29679a;
            h[] hVarArr = f0.this.f29678a;
            if (i10 >= hVarArr.length) {
                throw new NoSuchElementException();
            }
            this.f29679a = i10 + 1;
            return hVarArr[i10];
        }
    }

    public class c implements g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f29681a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f29682b;

        public c(int i10) {
            this.f29682b = i10;
        }

        @Override // gm.h
        public c0 b() {
            return f0.this;
        }

        @Override // gm.h3
        public c0 o() {
            return f0.this;
        }

        @Override // gm.g0
        public h readObject() throws IOException {
            int i10 = this.f29682b;
            int i11 = this.f29681a;
            if (i10 == i11) {
                return null;
            }
            h[] hVarArr = f0.this.f29678a;
            this.f29681a = i11 + 1;
            h hVar = hVarArr[i11];
            return hVar instanceof f0 ? ((f0) hVar).M() : hVar instanceof h0 ? ((h0) hVar).M() : hVar;
        }
    }

    public f0() {
        this.f29678a = i.f29704d;
    }

    public f0(h hVar) {
        Objects.requireNonNull(hVar, "'element' cannot be null");
        this.f29678a = new h[]{hVar};
    }

    public f0(i iVar) {
        Objects.requireNonNull(iVar, "'elementVector' cannot be null");
        this.f29678a = iVar.j();
    }

    public f0(h[] hVarArr) {
        if (org.bouncycastle.util.a.E0(hVarArr)) {
            throw new NullPointerException("'elements' cannot be null, or contain null");
        }
        this.f29678a = i.d(hVarArr);
    }

    public f0(h[] hVarArr, boolean z10) {
        this.f29678a = z10 ? i.d(hVarArr) : hVarArr;
    }

    public static f0 I(n0 n0Var, boolean z10) {
        return (f0) f29677b.f(n0Var, z10);
    }

    public static f0 J(Object obj) {
        if (obj == null || (obj instanceof f0)) {
            return (f0) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof f0) {
                return (f0) c0VarB;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (f0) f29677b.c((byte[]) obj);
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct sequence from byte[]: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    @Override // gm.c0
    public c0 E() {
        return new j2(this.f29678a, false);
    }

    @Override // gm.c0
    public c0 F() {
        return new z2(this.f29678a, false);
    }

    public d[] G() {
        int size = size();
        d[] dVarArr = new d[size];
        for (int i10 = 0; i10 < size; i10++) {
            dVarArr[i10] = d.K(this.f29678a[i10]);
        }
        return dVarArr;
    }

    public z[] H() {
        int size = size();
        z[] zVarArr = new z[size];
        for (int i10 = 0; i10 < size; i10++) {
            zVarArr[i10] = z.I(this.f29678a[i10]);
        }
        return zVarArr;
    }

    public h K(int i10) {
        return this.f29678a[i10];
    }

    public Enumeration L() {
        return new b();
    }

    public g0 M() {
        return new c(size());
    }

    public abstract d N();

    public abstract l O();

    public abstract z P();

    public abstract h0 Q();

    public h[] R() {
        return i.d(this.f29678a);
    }

    public h[] S() {
        return this.f29678a;
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        int length = this.f29678a.length;
        int iHashCode = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return iHashCode;
            }
            iHashCode = (iHashCode * 257) ^ this.f29678a[length].b().hashCode();
        }
    }

    @Override // org.bouncycastle.util.k, java.lang.Iterable
    public Iterator<h> iterator() {
        return new a.C0517a(this.f29678a);
    }

    public int size() {
        return this.f29678a.length;
    }

    public String toString() {
        int size = size();
        if (size == 0) {
            return okhttp3.u.f43953p;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('[');
        int i10 = 0;
        while (true) {
            stringBuffer.append(this.f29678a[i10]);
            i10++;
            if (i10 >= size) {
                stringBuffer.append(']');
                return stringBuffer.toString();
            }
            stringBuffer.append(", ");
        }
    }

    @Override // gm.c0
    public boolean x(c0 c0Var) {
        if (!(c0Var instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) c0Var;
        int size = size();
        if (f0Var.size() != size) {
            return false;
        }
        for (int i10 = 0; i10 < size; i10++) {
            c0 c0VarB = this.f29678a[i10].b();
            c0 c0VarB2 = f0Var.f29678a[i10].b();
            if (c0VarB != c0VarB2 && !c0VarB.x(c0VarB2)) {
                return false;
            }
        }
        return true;
    }

    @Override // gm.c0
    public boolean z() {
        return true;
    }
}
