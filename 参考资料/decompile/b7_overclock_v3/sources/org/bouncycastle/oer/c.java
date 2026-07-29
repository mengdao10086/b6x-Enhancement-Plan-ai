package org.bouncycastle.oer;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Iterator;
import jt.h;
import org.bouncycastle.oer.OERDefinition;

/* JADX INFO: loaded from: classes6.dex */
public class c extends FilterInputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f45557c = {1, 2, 4, 8, 16, 32, 64, 128};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f45558a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PrintWriter f45559b;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45560a;

        static {
            int[] iArr = new int[OERDefinition.BaseType.values().length];
            f45560a = iArr;
            try {
                iArr[OERDefinition.BaseType.SEQ_OF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f45560a[OERDefinition.BaseType.SEQ.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f45560a[OERDefinition.BaseType.CHOICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f45560a[OERDefinition.BaseType.ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f45560a[OERDefinition.BaseType.INT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f45560a[OERDefinition.BaseType.OCTET_STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f45560a[OERDefinition.BaseType.UTF8_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f45560a[OERDefinition.BaseType.BIT_STRING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f45560a[OERDefinition.BaseType.NULL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f45560a[OERDefinition.BaseType.EXTENSION.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public static class b extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f45561d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f45562e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f45563f;

        public b(InputStream inputStream) throws Exception {
            int i10;
            super(inputStream);
            int i11 = read();
            this.f45561d = i11;
            if (i11 < 0) {
                throw new EOFException("expecting preamble byte of choice");
            }
            this.f45563f = i11 & 192;
            int i12 = i11 & 63;
            if (i12 >= 63) {
                i12 = 0;
                do {
                    i10 = inputStream.read();
                    if (i10 < 0) {
                        throw new EOFException("expecting further tag bytes");
                    }
                    i12 = (i12 << 7) | (i10 & 127);
                } while ((i10 & 128) != 0);
            }
            this.f45562e = i12;
        }

        public int F0() {
            return this.f45563f;
        }

        public boolean G0() {
            return this.f45563f == 64;
        }

        public boolean M0() {
            return this.f45563f == 128;
        }

        public int b0() {
            return this.f45562e;
        }

        public boolean d1() {
            return this.f45563f == 192;
        }

        public boolean h1() {
            return this.f45563f == 0;
        }

        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("CHOICE(");
            int i10 = this.f45563f;
            if (i10 == 0) {
                str = "Universal ";
            } else if (i10 == 64) {
                str = "Application ";
            } else {
                if (i10 != 128) {
                    if (i10 == 192) {
                        str = "Private ";
                    }
                    sb2.append("Tag = " + this.f45562e);
                    sb2.append(ee.a.f26979d);
                    return sb2.toString();
                }
                str = "ContextSpecific ";
            }
            sb2.append(str);
            sb2.append("Tag = " + this.f45562e);
            sb2.append(ee.a.f26979d);
            return sb2.toString();
        }
    }

    /* JADX INFO: renamed from: org.bouncycastle.oer.c$c, reason: collision with other inner class name */
    public final class C0512c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BigInteger f45564a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f45565b;

        public C0512c(BigInteger bigInteger, boolean z10) {
            this.f45564a = bigInteger;
            this.f45565b = z10;
        }

        public final int b() {
            return this.f45564a.intValue();
        }
    }

    public static class d extends c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f45567d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean[] f45568e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f45569f;

        public d(InputStream inputStream, int i10, boolean z10, boolean z11) throws IOException {
            super(inputStream);
            if (i10 == 0 && !z11 && !z10) {
                this.f45567d = 0;
                this.f45568e = new boolean[0];
                this.f45569f = false;
                return;
            }
            int i11 = inputStream.read();
            this.f45567d = i11;
            if (i11 < 0) {
                throw new EOFException("expecting preamble byte of sequence");
            }
            this.f45569f = z11 && (i11 & 128) == 128;
            int i12 = z11 ? 6 : 7;
            this.f45568e = new boolean[i10];
            for (int i13 = 0; i13 < this.f45568e.length; i13++) {
                if (i12 < 0) {
                    i11 = inputStream.read();
                    if (i11 < 0) {
                        throw new EOFException("expecting mask byte sequence");
                    }
                    i12 = 7;
                }
                this.f45568e[i13] = (c.f45557c[i12] & i11) > 0;
                i12--;
            }
        }

        public boolean F0(int i10) {
            return this.f45568e[i10];
        }

        public boolean b0() {
            return this.f45569f;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SEQ(");
            sb2.append(b0() ? "Ext " : "");
            int i10 = 0;
            while (true) {
                boolean[] zArr = this.f45568e;
                if (i10 >= zArr.length) {
                    sb2.append(ee.a.f26979d);
                    return sb2.toString();
                }
                sb2.append(zArr[i10] ? "1" : "0");
                i10++;
            }
        }
    }

    public c(InputStream inputStream) {
        super(inputStream);
        this.f45558a = 1048576;
        this.f45559b = null;
    }

    public c(InputStream inputStream, int i10) {
        super(inputStream);
        this.f45559b = null;
        this.f45558a = i10;
    }

    public BigInteger I(boolean z10, int i10) throws Exception {
        byte[] bArr = new byte[i10];
        if (kt.c.g(this, bArr) == i10) {
            return z10 ? new BigInteger(1, bArr) : new BigInteger(bArr);
        }
        throw new IllegalStateException("integer not fully read");
    }

    public C0512c L() throws Exception {
        int i10 = read();
        if (i10 == -1) {
            throw new EOFException("expecting length");
        }
        if ((i10 & 128) == 0) {
            return new C0512c(BigInteger.valueOf(i10 & 127), true);
        }
        int i11 = i10 & 127;
        byte[] bArr = new byte[i11];
        if (kt.c.g(this, bArr) != i11) {
            throw new EOFException("did not read all bytes of length definition");
        }
        h.j(bArr);
        return new C0512c(org.bouncycastle.util.b.i(bArr), false);
    }

    public d M(int i10, boolean z10, boolean z11) throws Exception {
        return new d(this, i10, z10, z11);
    }

    public BigInteger P() throws Exception {
        return I(true, 2);
    }

    public BigInteger T() throws Exception {
        return I(true, 4);
    }

    public BigInteger W() throws Exception {
        return I(false, 8);
    }

    public BigInteger Z() throws Exception {
        return I(true, 1);
    }

    public final gm.h a(OERDefinition.b bVar) {
        i(bVar.a("Absent"));
        return org.bouncycastle.oer.d.f45570c;
    }

    public final byte[] d(int i10) {
        if (i10 <= this.f45558a) {
            return new byte[i10];
        }
        throw new IllegalArgumentException("required byte array size " + i10 + " was greater than " + this.f45558a);
    }

    public b f() throws Exception {
        return new b(this);
    }

    public final int h(OERDefinition.b bVar) {
        Iterator<OERDefinition.b> it2 = bVar.f45544b.iterator();
        int i10 = 0;
        while (it2.hasNext()) {
            i10 += !it2.next().f45545c ? 1 : 0;
        }
        return i10;
    }

    public void i(String str) {
        if (this.f45559b == null) {
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
            PrintWriter printWriter = this.f45559b;
            if (i10 <= 0) {
                printWriter.append((CharSequence) str).append((CharSequence) "\n");
                this.f45559b.flush();
                return;
            } else {
                printWriter.append((CharSequence) wn.a.f54751a);
                i10--;
            }
        }
    }

    public BigInteger k() throws Exception {
        int i10 = read();
        if (i10 == -1) {
            throw new EOFException("expecting prefix of enumeration");
        }
        if ((i10 & 128) != 128) {
            return BigInteger.valueOf(i10);
        }
        int i11 = i10 & 127;
        if (i11 == 0) {
            return BigInteger.ZERO;
        }
        byte[] bArr = new byte[i11];
        if (kt.c.g(this, bArr) == i11) {
            return new BigInteger(1, bArr);
        }
        throw new EOFException("unable to fully read integer component of enumeration");
    }

    public BigInteger l() throws Exception {
        return I(false, 2);
    }

    public BigInteger m() throws Exception {
        return I(false, 4);
    }

    public BigInteger n() throws Exception {
        return I(false, 8);
    }

    public BigInteger u() throws Exception {
        return I(false, 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0228 A[PHI: r0
  0x0228: PHI (r0v18 byte[]) = (r0v17 byte[]), (r0v21 byte[]) binds: [B:86:0x0226, B:82:0x020e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public gm.w z(org.bouncycastle.oer.OERDefinition.b r9) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 992
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.oer.c.z(org.bouncycastle.oer.OERDefinition$b):gm.w");
    }
}
