package gm;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.bouncycastle.util.a;

/* JADX INFO: loaded from: classes5.dex */
public abstract class h0 extends c0 implements org.bouncycastle.util.k<h> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final t0 f29696c = new a(h0.class, 17);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h[] f29697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f29698b;

    public static class a extends t0 {
        public a(Class cls, int i10) {
            super(cls, i10);
        }

        @Override // gm.t0
        public c0 d(f0 f0Var) {
            return f0Var.Q();
        }
    }

    public class b implements Enumeration {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f29699a = 0;

        public b() {
        }

        @Override // java.util.Enumeration
        public boolean hasMoreElements() {
            return this.f29699a < h0.this.f29697a.length;
        }

        @Override // java.util.Enumeration
        public Object nextElement() {
            int i10 = this.f29699a;
            h[] hVarArr = h0.this.f29697a;
            if (i10 >= hVarArr.length) {
                throw new NoSuchElementException();
            }
            this.f29699a = i10 + 1;
            return hVarArr[i10];
        }
    }

    public class c implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f29701a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f29702b;

        public c(int i10) {
            this.f29702b = i10;
        }

        @Override // gm.h
        public c0 b() {
            return h0.this;
        }

        @Override // gm.h3
        public c0 o() {
            return h0.this;
        }

        @Override // gm.i0
        public h readObject() throws IOException {
            int i10 = this.f29702b;
            int i11 = this.f29701a;
            if (i10 == i11) {
                return null;
            }
            h[] hVarArr = h0.this.f29697a;
            this.f29701a = i11 + 1;
            h hVar = hVarArr[i11];
            return hVar instanceof f0 ? ((f0) hVar).M() : hVar instanceof h0 ? ((h0) hVar).M() : hVar;
        }
    }

    public h0() {
        this.f29697a = i.f29704d;
        this.f29698b = true;
    }

    public h0(h hVar) {
        Objects.requireNonNull(hVar, "'element' cannot be null");
        this.f29697a = new h[]{hVar};
        this.f29698b = true;
    }

    public h0(i iVar, boolean z10) {
        h[] hVarArrJ;
        Objects.requireNonNull(iVar, "'elementVector' cannot be null");
        if (!z10 || iVar.i() < 2) {
            hVarArrJ = iVar.j();
        } else {
            hVarArrJ = iVar.e();
            N(hVarArrJ);
        }
        this.f29697a = hVarArrJ;
        this.f29698b = z10 || hVarArrJ.length < 2;
    }

    public h0(boolean z10, h[] hVarArr) {
        this.f29697a = hVarArr;
        this.f29698b = z10 || hVarArr.length < 2;
    }

    public h0(h[] hVarArr, boolean z10) {
        if (org.bouncycastle.util.a.E0(hVarArr)) {
            throw new NullPointerException("'elements' cannot be null, or contain null");
        }
        h[] hVarArrD = i.d(hVarArr);
        if (z10 && hVarArrD.length >= 2) {
            N(hVarArrD);
        }
        this.f29697a = hVarArrD;
        this.f29698b = z10 || hVarArrD.length < 2;
    }

    public static byte[] G(h hVar) {
        try {
            return hVar.b().v(j.f29713a);
        } catch (IOException unused) {
            throw new IllegalArgumentException("cannot encode object added to SET");
        }
    }

    public static h0 H(n0 n0Var, boolean z10) {
        return (h0) f29696c.f(n0Var, z10);
    }

    public static h0 I(Object obj) {
        if (obj == null || (obj instanceof h0)) {
            return (h0) obj;
        }
        if (obj instanceof h) {
            c0 c0VarB = ((h) obj).b();
            if (c0VarB instanceof h0) {
                return (h0) c0VarB;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (h0) f29696c.c((byte[]) obj);
            } catch (IOException e10) {
                throw new IllegalArgumentException("failed to construct set from byte[]: " + e10.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
    }

    public static boolean L(byte[] bArr, byte[] bArr2) {
        int i10 = bArr[0] & (-33);
        int i11 = bArr2[0] & (-33);
        if (i10 != i11) {
            return i10 < i11;
        }
        int iMin = Math.min(bArr.length, bArr2.length) - 1;
        for (int i12 = 1; i12 < iMin; i12++) {
            if (bArr[i12] != bArr2[i12]) {
                return (bArr[i12] & 255) < (bArr2[i12] & 255);
            }
        }
        return (bArr[iMin] & 255) <= (bArr2[iMin] & 255);
    }

    public static void N(h[] hVarArr) {
        int length = hVarArr.length;
        if (length < 2) {
            return;
        }
        h hVar = hVarArr[0];
        h hVar2 = hVarArr[1];
        byte[] bArrG = G(hVar);
        byte[] bArrG2 = G(hVar2);
        if (L(bArrG2, bArrG)) {
            hVar2 = hVar;
            hVar = hVar2;
            bArrG2 = bArrG;
            bArrG = bArrG2;
        }
        for (int i10 = 2; i10 < length; i10++) {
            h hVar3 = hVarArr[i10];
            byte[] bArrG3 = G(hVar3);
            if (L(bArrG2, bArrG3)) {
                hVarArr[i10 - 2] = hVar;
                hVar = hVar2;
                bArrG = bArrG2;
                hVar2 = hVar3;
                bArrG2 = bArrG3;
            } else if (L(bArrG, bArrG3)) {
                hVarArr[i10 - 2] = hVar;
                hVar = hVar3;
                bArrG = bArrG3;
            } else {
                int i11 = i10 - 1;
                while (true) {
                    i11--;
                    if (i11 <= 0) {
                        break;
                    }
                    h hVar4 = hVarArr[i11 - 1];
                    if (L(G(hVar4), bArrG3)) {
                        break;
                    } else {
                        hVarArr[i11] = hVar4;
                    }
                }
                hVarArr[i11] = hVar3;
            }
        }
        hVarArr[length - 2] = hVar;
        hVarArr[length - 1] = hVar2;
    }

    @Override // gm.c0
    public c0 E() {
        h[] hVarArr;
        if (this.f29698b) {
            hVarArr = this.f29697a;
        } else {
            hVarArr = (h[]) this.f29697a.clone();
            N(hVarArr);
        }
        return new l2(true, hVarArr);
    }

    @Override // gm.c0
    public c0 F() {
        return new b3(this.f29698b, this.f29697a);
    }

    public h J(int i10) {
        return this.f29697a[i10];
    }

    public Enumeration K() {
        return new b();
    }

    public i0 M() {
        return new c(size());
    }

    public h[] O() {
        return i.d(this.f29697a);
    }

    @Override // gm.c0, gm.w
    public int hashCode() {
        int length = this.f29697a.length;
        int iHashCode = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return iHashCode;
            }
            iHashCode += this.f29697a[length].b().hashCode();
        }
    }

    @Override // org.bouncycastle.util.k, java.lang.Iterable
    public Iterator<h> iterator() {
        return new a.C0517a(O());
    }

    public int size() {
        return this.f29697a.length;
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
            stringBuffer.append(this.f29697a[i10]);
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
        if (!(c0Var instanceof h0)) {
            return false;
        }
        h0 h0Var = (h0) c0Var;
        int size = size();
        if (h0Var.size() != size) {
            return false;
        }
        l2 l2Var = (l2) E();
        l2 l2Var2 = (l2) h0Var.E();
        for (int i10 = 0; i10 < size; i10++) {
            c0 c0VarB = l2Var.f29697a[i10].b();
            c0 c0VarB2 = l2Var2.f29697a[i10].b();
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
