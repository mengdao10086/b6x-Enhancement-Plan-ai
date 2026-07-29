package org.bouncycastle.oer;

import com.blankj.utilcode.util.i0;
import gm.c0;
import gm.f;
import gm.f0;
import gm.h;
import gm.h0;
import gm.k;
import gm.n0;
import gm.r0;
import gm.t;
import gm.u1;
import gm.z;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Enumeration;
import java.util.Iterator;
import org.bouncycastle.oer.OERDefinition;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.o;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f45575c = {1, 2, 4, 8, 16, 32, 64, 128};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OutputStream f45576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PrintWriter f45577b = null;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45578a;

        static {
            int[] iArr = new int[OERDefinition.BaseType.values().length];
            f45578a = iArr;
            try {
                iArr[OERDefinition.BaseType.SEQ.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45578a[OERDefinition.BaseType.SEQ_OF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45578a[OERDefinition.BaseType.CHOICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45578a[OERDefinition.BaseType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45578a[OERDefinition.BaseType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45578a[OERDefinition.BaseType.OCTET_STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f45578a[OERDefinition.BaseType.UTF8_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f45578a[OERDefinition.BaseType.BIT_STRING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f45578a[OERDefinition.BaseType.NULL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f45578a[OERDefinition.BaseType.EXTENSION.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f45578a[OERDefinition.BaseType.ENUM_ITEM.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f45578a[OERDefinition.BaseType.BOOLEAN.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public e(OutputStream outputStream) {
        this.f45576a = outputStream;
    }

    public static int a(long j10) {
        int i10 = 8;
        while (i10 > 0 && ((-72057594037927936L) & j10) == 0) {
            j10 <<= 8;
            i10--;
        }
        return i10;
    }

    public static e b(OutputStream outputStream) {
        return new e(outputStream);
    }

    public void c(String str) {
        if (this.f45577b == null) {
            return;
        }
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        int i10 = -1;
        for (int i11 = 0; i11 != stackTrace.length; i11++) {
            StackTraceElement stackTraceElement = stackTrace[i11];
            if (stackTraceElement.getMethodName().equals("debugPrint")) {
                i10 = 0;
            } else if (stackTraceElement.getClassName().contains("OERInput")) {
                i10++;
            }
        }
        while (true) {
            PrintWriter printWriter = this.f45577b;
            if (i10 <= 0) {
                printWriter.append((CharSequence) str).append((CharSequence) "\n");
                this.f45577b.flush();
                return;
            } else {
                printWriter.append((CharSequence) wn.a.f54751a);
                i10--;
            }
        }
    }

    public final void d(long j10) throws IOException {
        if (j10 <= 127) {
            this.f45576a.write((int) j10);
            return;
        }
        byte[] bArrC = org.bouncycastle.util.b.c(BigInteger.valueOf(j10));
        this.f45576a.write(bArrC.length | 128);
        this.f45576a.write(bArrC);
    }

    public final void e(long j10) throws IOException {
        byte[] bArrC = org.bouncycastle.util.b.c(BigInteger.valueOf(j10));
        this.f45576a.write(bArrC.length);
        this.f45576a.write(bArrC);
    }

    public void f(h hVar, OERDefinition.b bVar) throws IOException {
        int i10;
        int i11;
        Enumeration enumerationL;
        int size;
        int iQ;
        c0 c0VarB;
        String str;
        byte[] bArrD;
        String strA;
        if (hVar == d.f45570c) {
            return;
        }
        if (hVar instanceof d) {
            f(((d) hVar).y(), bVar);
            return;
        }
        c0 c0VarB2 = hVar.b();
        int i12 = 6;
        switch (a.f45578a[bVar.f45543a.ordinal()]) {
            case 1:
                f0 f0VarJ = f0.J(c0VarB2);
                if (bVar.f45550h) {
                    i10 = bVar.f() ? f45575c[7] | 0 : 0;
                } else {
                    i10 = 0;
                    i12 = 7;
                }
                for (int i13 = 0; i13 < bVar.f45544b.size(); i13++) {
                    OERDefinition.b bVar2 = bVar.f45544b.get(i13);
                    if (i12 < 0) {
                        this.f45576a.write(i10);
                        i10 = 0;
                        i12 = 7;
                    }
                    h hVarK = f0VarJ.K(i13);
                    boolean z10 = bVar2.f45545c;
                    if (z10 && (hVarK instanceof d)) {
                        throw new IllegalStateException("absent sequence element that is required by oer definition");
                    }
                    if (!z10) {
                        h hVarK2 = f0VarJ.K(i13);
                        if (bVar2.c() == null) {
                            if (hVarK != d.f45570c) {
                                i11 = f45575c[i12];
                                i10 |= i11;
                            }
                            i12--;
                        } else if (hVarK2 instanceof d) {
                            d dVar = (d) hVarK2;
                            if (dVar.C() && !dVar.y().equals(bVar2.f45552j)) {
                                i11 = f45575c[i12];
                                i10 |= i11;
                            }
                            i12--;
                        } else {
                            if (!bVar2.c().equals(hVarK2)) {
                                i11 = f45575c[i12];
                                i10 |= i11;
                            }
                            i12--;
                        }
                    }
                }
                if (i12 != 7) {
                    this.f45576a.write(i10);
                }
                for (int i14 = 0; i14 < bVar.f45544b.size(); i14++) {
                    h hVarK3 = f0VarJ.K(i14);
                    OERDefinition.b bVar3 = bVar.f45544b.get(i14);
                    if (bVar3.c() == null || !bVar3.c().equals(hVarK3)) {
                        f(hVarK3, bVar3);
                    }
                }
                this.f45576a.flush();
                c(bVar.a(""));
                return;
            case 2:
                if (c0VarB2 instanceof h0) {
                    h0 h0Var = (h0) c0VarB2;
                    enumerationL = h0Var.K();
                    size = h0Var.size();
                } else {
                    if (!(c0VarB2 instanceof f0)) {
                        throw new IllegalStateException("encodable at for SEQ_OF is not a container");
                    }
                    f0 f0Var = (f0) c0VarB2;
                    enumerationL = f0Var.L();
                    size = f0Var.size();
                }
                e(size);
                while (enumerationL.hasMoreElements()) {
                    f((h) enumerationL.nextElement(), bVar.d());
                }
                this.f45576a.flush();
                c(bVar.a(""));
                return;
            case 3:
                c0 c0VarB3 = c0VarB2.b();
                org.bouncycastle.oer.a aVar = new org.bouncycastle.oer.a();
                if (c0VarB3 instanceof gm.a) {
                    gm.a aVar2 = (gm.a) c0VarB3;
                    iQ = aVar2.H();
                    aVar.f(0).f(1);
                    c0VarB = aVar2.J();
                } else {
                    if (!(c0VarB3 instanceof n0)) {
                        throw new IllegalStateException("only support tagged objects");
                    }
                    n0 n0Var = (n0) c0VarB3;
                    int iR = n0Var.r();
                    aVar.f(iR & 128).f(iR & 64);
                    iQ = n0Var.q();
                    c0VarB = n0Var.L().b();
                }
                if (iQ <= 63) {
                    aVar.g(iQ, 6);
                } else {
                    aVar.g(255L, 6);
                    aVar.c(iQ);
                }
                if (this.f45577b != null) {
                    if (!(c0VarB instanceof gm.a)) {
                        str = c0VarB instanceof n0 ? "CS" : "AS";
                    }
                    c(bVar.a(str));
                }
                aVar.e(this.f45576a);
                f(c0VarB, bVar.f45544b.get(iQ));
                this.f45576a.flush();
                return;
            case 4:
                BigInteger bigIntegerK = c0VarB2 instanceof t ? t.I(c0VarB2).K() : k.I(c0VarB2).J();
                Iterator<OERDefinition.b> it2 = bVar.f45544b.iterator();
                while (it2.hasNext()) {
                    if (it2.next().f45551i.equals(bigIntegerK)) {
                        if (bigIntegerK.compareTo(BigInteger.valueOf(127L)) > 0) {
                            byte[] byteArray = bigIntegerK.toByteArray();
                            this.f45576a.write((byteArray.length & 255) | 128);
                            this.f45576a.write(byteArray);
                        } else {
                            this.f45576a.write(bigIntegerK.intValue() & 127);
                        }
                        this.f45576a.flush();
                        c(bVar.a(bVar.m()));
                        return;
                    }
                }
                throw new IllegalArgumentException("enum value " + bigIntegerK + i0.f11861z + jt.h.j(bigIntegerK.toByteArray()) + " no in defined child list");
            case 5:
                t tVarI = t.I(c0VarB2);
                int iG = bVar.g();
                if (iG > 0) {
                    byte[] bArrB = org.bouncycastle.util.b.b(iG, tVarI.K());
                    if (iG != 1 && iG != 2 && iG != 4 && iG != 8) {
                        throw new IllegalStateException("unknown uint length " + iG);
                    }
                    this.f45576a.write(bArrB);
                } else if (iG < 0) {
                    BigInteger bigIntegerK2 = tVarI.K();
                    if (iG == -8) {
                        bArrD = o.D(org.bouncycastle.util.b.m(bigIntegerK2));
                    } else if (iG == -4) {
                        bArrD = o.k(org.bouncycastle.util.b.l(bigIntegerK2));
                    } else if (iG == -2) {
                        bArrD = o.L(org.bouncycastle.util.b.p(bigIntegerK2));
                    } else {
                        if (iG != -1) {
                            throw new IllegalStateException("unknown twos compliment length");
                        }
                        bArrD = new byte[]{org.bouncycastle.util.b.d(bigIntegerK2)};
                    }
                    this.f45576a.write(bArrD);
                } else {
                    boolean zI = bVar.i();
                    BigInteger bigIntegerK3 = tVarI.K();
                    byte[] bArrC = zI ? org.bouncycastle.util.b.c(bigIntegerK3) : bigIntegerK3.toByteArray();
                    d(bArrC.length);
                    this.f45576a.write(bArrC);
                }
                strA = bVar.a(bVar.m());
                c(strA);
                this.f45576a.flush();
                return;
            case 6:
                byte[] bArrJ = z.I(c0VarB2).J();
                if (!bVar.h()) {
                    d(bArrJ.length);
                }
                this.f45576a.write(bArrJ);
                strA = bVar.a(bVar.m());
                c(strA);
                this.f45576a.flush();
                return;
            case 7:
                byte[] bArrM = Strings.m(r0.I(c0VarB2).d());
                d(bArrM.length);
                this.f45576a.write(bArrM);
                strA = bVar.a("");
                c(strA);
                this.f45576a.flush();
                return;
            case 8:
                u1 u1VarS = u1.S(c0VarB2);
                byte[] bArrH = u1VarS.H();
                if (!bVar.h()) {
                    int iM = u1VarS.m();
                    d(bArrH.length + 1);
                    this.f45576a.write(iM);
                }
                this.f45576a.write(bArrH);
                strA = bVar.a(bVar.m());
                c(strA);
                this.f45576a.flush();
                return;
            case 9:
            case 11:
            default:
                return;
            case 10:
                byte[] bArrJ2 = z.I(c0VarB2).J();
                if (!bVar.h()) {
                    d(bArrJ2.length);
                }
                this.f45576a.write(bArrJ2);
                strA = bVar.a(bVar.m());
                c(strA);
                this.f45576a.flush();
                return;
            case 12:
                c(bVar.f45546d);
                if (f.J(c0VarB2).L()) {
                    this.f45576a.write(255);
                } else {
                    this.f45576a.write(0);
                }
                this.f45576a.flush();
                return;
        }
    }
}
