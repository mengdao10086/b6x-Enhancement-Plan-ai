package ek;

import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.v0;
import okio.w0;
import yt.k;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.8")
@f
public class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f27002d = 8;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f27003e = 6;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f27004f = 3;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f27005g = 4;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte f27006h = 61;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f27007i = 76;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f27008j = 19;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f27012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f27013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final C0311a f27001c = new C0311a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @k
    public static final byte[] f27009k = {13, 10};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @k
    public static final a f27010l = new a(true, false);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @k
    public static final a f27011m = new a(false, true);

    /* JADX INFO: renamed from: ek.a$a, reason: collision with other inner class name */
    public static final class C0311a extends a {
        /* JADX WARN: Illegal instructions before constructor call */
        public C0311a() {
            boolean z10 = false;
            super(z10, z10, null);
        }

        public /* synthetic */ C0311a(u uVar) {
            this();
        }

        @k
        public final a G() {
            return a.f27011m;
        }

        @k
        public final byte[] H() {
            return a.f27009k;
        }

        @k
        public final a I() {
            return a.f27010l;
        }
    }

    public a(boolean z10, boolean z11) {
        this.f27012a = z10;
        this.f27013b = z11;
        if (!((z10 && z11) ? false : true)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public /* synthetic */ a(boolean z10, boolean z11, u uVar) {
        this(z10, z11);
    }

    public static /* synthetic */ byte[] A(a aVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return aVar.z(bArr, i10, i11);
    }

    public static /* synthetic */ byte[] j(a aVar, CharSequence charSequence, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = charSequence.length();
        }
        return aVar.h(charSequence, i10, i11);
    }

    public static /* synthetic */ byte[] k(a aVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return aVar.i(bArr, i10, i11);
    }

    public static /* synthetic */ int o(a aVar, CharSequence charSequence, byte[] bArr, int i10, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        }
        int i14 = (i13 & 4) != 0 ? 0 : i10;
        int i15 = (i13 & 8) != 0 ? 0 : i11;
        if ((i13 & 16) != 0) {
            i12 = charSequence.length();
        }
        return aVar.m(charSequence, bArr, i14, i15, i12);
    }

    public static /* synthetic */ int p(a aVar, byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
        }
        int i14 = (i13 & 4) != 0 ? 0 : i10;
        int i15 = (i13 & 8) != 0 ? 0 : i11;
        if ((i13 & 16) != 0) {
            i12 = bArr.length;
        }
        return aVar.n(bArr, bArr2, i14, i15, i12);
    }

    public static /* synthetic */ String s(a aVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
        }
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            i11 = bArr.length;
        }
        return aVar.r(bArr, i10, i11);
    }

    public static /* synthetic */ int u(a aVar, byte[] bArr, byte[] bArr2, int i10, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
        }
        int i14 = (i13 & 4) != 0 ? 0 : i10;
        int i15 = (i13 & 8) != 0 ? 0 : i11;
        if ((i13 & 16) != 0) {
            i12 = bArr.length;
        }
        return aVar.t(bArr, bArr2, i14, i15, i12);
    }

    public static /* synthetic */ Appendable y(a aVar, byte[] bArr, Appendable appendable, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
        }
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        if ((i12 & 8) != 0) {
            i11 = bArr.length;
        }
        return aVar.x(bArr, appendable, i10, i11);
    }

    @k
    public final byte[] B(@k byte[] source, int i10, int i11) {
        f0.p(source, "source");
        g(source.length, i10, i11);
        byte[] bArr = new byte[w(i11 - i10)];
        v(source, bArr, 0, i10, i11);
        return bArr;
    }

    public final int C(byte[] bArr, int i10, int i11, int i12) {
        if (i12 == -8) {
            throw new IllegalArgumentException("Redundant pad character at index " + i10);
        }
        if (i12 != -6) {
            if (i12 == -4) {
                i10 = F(bArr, i10 + 1, i11);
                if (i10 == i11 || bArr[i10] != 61) {
                    throw new IllegalArgumentException("Missing one pad character at index " + i10);
                }
            } else if (i12 != -2) {
                throw new IllegalStateException("Unreachable".toString());
            }
        }
        return i10 + 1;
    }

    public final boolean D() {
        return this.f27013b;
    }

    public final boolean E() {
        return this.f27012a;
    }

    public final int F(byte[] bArr, int i10, int i11) {
        if (!this.f27013b) {
            return i10;
        }
        while (i10 < i11) {
            if (c.f27015b[bArr[i10] & 255] != -1) {
                return i10;
            }
            i10++;
        }
        return i10;
    }

    @k
    public final String d(@k byte[] source) {
        f0.p(source, "source");
        StringBuilder sb2 = new StringBuilder(source.length);
        for (byte b10 : source) {
            sb2.append((char) b10);
        }
        String string = sb2.toString();
        f0.o(string, "stringBuilder.toString()");
        return string;
    }

    @k
    public final byte[] e(@k CharSequence source, int i10, int i11) {
        f0.p(source, "source");
        g(source.length(), i10, i11);
        byte[] bArr = new byte[i11 - i10];
        int i12 = 0;
        while (i10 < i11) {
            char cCharAt = source.charAt(i10);
            if (cCharAt <= 255) {
                bArr[i12] = (byte) cCharAt;
                i12++;
            } else {
                bArr[i12] = w0.f44229a;
                i12++;
            }
            i10++;
        }
        return bArr;
    }

    public final void f(int i10, int i11, int i12) {
        if (i11 < 0 || i11 > i10) {
            throw new IndexOutOfBoundsException("destination offset: " + i11 + ", destination size: " + i10);
        }
        int i13 = i11 + i12;
        if (i13 < 0 || i13 > i10) {
            throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + i11 + ", destination size: " + i10 + ", capacity needed: " + i12);
        }
    }

    public final void g(int i10, int i11, int i12) {
        kotlin.collections.b.f37685a.a(i11, i12, i10);
    }

    @k
    public final byte[] h(@k CharSequence source, int i10, int i11) {
        byte[] bArrE;
        f0.p(source, "source");
        if (source instanceof String) {
            g(source.length(), i10, i11);
            String strSubstring = ((String) source).substring(i10, i11);
            f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            Charset charset = kotlin.text.d.f38166g;
            f0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
            bArrE = strSubstring.getBytes(charset);
            f0.o(bArrE, "this as java.lang.String).getBytes(charset)");
        } else {
            bArrE = e(source, i10, i11);
        }
        return k(this, bArrE, 0, 0, 6, null);
    }

    @k
    public final byte[] i(@k byte[] source, int i10, int i11) {
        f0.p(source, "source");
        g(source.length, i10, i11);
        int iQ = q(source, i10, i11);
        byte[] bArr = new byte[iQ];
        if (l(source, bArr, 0, i10, i11) == iQ) {
            return bArr;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d1, code lost:
    
        if (r7 == (-2)) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d3, code lost:
    
        r3 = F(r19, r4, r23);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d7, code lost:
    
        if (r3 < r23) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00db, code lost:
    
        return r8 - r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00dc, code lost:
    
        r1 = r19[r3] & 255;
        r4 = new java.lang.StringBuilder();
        r4.append("Symbol '");
        r4.append((char) r1);
        r4.append("'(");
        r1 = java.lang.Integer.toString(r1, kotlin.text.b.a(8));
        kotlin.jvm.internal.f0.o(r1, "toString(this, checkRadix(radix))");
        r4.append(r1);
        r4.append(") at index ");
        r4.append(r3 - 1);
        r4.append(" is prohibited after the pad character");
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0115, code lost:
    
        throw new java.lang.IllegalArgumentException(r4.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x011d, code lost:
    
        throw new java.lang.IllegalArgumentException("The last unit of input does not have enough bits");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int l(byte[] r19, byte[] r20, int r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ek.a.l(byte[], byte[], int, int, int):int");
    }

    public final int m(@k CharSequence source, @k byte[] destination, int i10, int i11, int i12) {
        byte[] bArrE;
        f0.p(source, "source");
        f0.p(destination, "destination");
        if (source instanceof String) {
            g(source.length(), i11, i12);
            String strSubstring = ((String) source).substring(i11, i12);
            f0.o(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            Charset charset = kotlin.text.d.f38166g;
            f0.n(strSubstring, "null cannot be cast to non-null type java.lang.String");
            bArrE = strSubstring.getBytes(charset);
            f0.o(bArrE, "this as java.lang.String).getBytes(charset)");
        } else {
            bArrE = e(source, i11, i12);
        }
        return p(this, bArrE, destination, i10, 0, 0, 24, null);
    }

    public final int n(@k byte[] source, @k byte[] destination, int i10, int i11, int i12) {
        f0.p(source, "source");
        f0.p(destination, "destination");
        g(source.length, i11, i12);
        f(destination.length, i10, q(source, i11, i12));
        return l(source, destination, i10, i11, i12);
    }

    public final int q(byte[] bArr, int i10, int i11) {
        int i12 = i11 - i10;
        if (i12 == 0) {
            return 0;
        }
        if (i12 == 1) {
            throw new IllegalArgumentException("Input should have at list 2 symbols for Base64 decoding, startIndex: " + i10 + ", endIndex: " + i11);
        }
        if (this.f27013b) {
            while (true) {
                if (i10 >= i11) {
                    break;
                }
                int i13 = c.f27015b[bArr[i10] & 255];
                if (i13 < 0) {
                    if (i13 == -2) {
                        i12 -= i11 - i10;
                        break;
                    }
                    i12--;
                }
                i10++;
            }
        } else if (bArr[i11 - 1] == 61) {
            i12--;
            if (bArr[i11 - 2] == 61) {
                i12--;
            }
        }
        return (int) ((((long) i12) * ((long) 6)) / ((long) 8));
    }

    @k
    public final String r(@k byte[] source, int i10, int i11) {
        f0.p(source, "source");
        return new String(B(source, i10, i11), kotlin.text.d.f38166g);
    }

    public final int t(@k byte[] source, @k byte[] destination, int i10, int i11, int i12) {
        f0.p(source, "source");
        f0.p(destination, "destination");
        return v(source, destination, i10, i11, i12);
    }

    public final int v(@k byte[] source, @k byte[] destination, int i10, int i11, int i12) {
        f0.p(source, "source");
        f0.p(destination, "destination");
        g(source.length, i11, i12);
        f(destination.length, i10, w(i12 - i11));
        byte[] bArr = this.f27012a ? c.f27016c : c.f27014a;
        int i13 = this.f27013b ? 19 : Integer.MAX_VALUE;
        int i14 = i10;
        while (true) {
            if (i11 + 2 >= i12) {
                break;
            }
            int iMin = Math.min((i12 - i11) / 3, i13);
            int i15 = 0;
            while (i15 < iMin) {
                int i16 = i11 + 1;
                int i17 = i16 + 1;
                int i18 = ((source[i11] & 255) << 16) | ((source[i16] & 255) << 8) | (source[i17] & 255);
                int i19 = i14 + 1;
                destination[i14] = bArr[i18 >>> 18];
                int i20 = i19 + 1;
                destination[i19] = bArr[(i18 >>> 12) & 63];
                int i21 = i20 + 1;
                destination[i20] = bArr[(i18 >>> 6) & 63];
                i14 = i21 + 1;
                destination[i21] = bArr[i18 & 63];
                i15++;
                i11 = i17 + 1;
            }
            if (iMin == i13 && i11 != i12) {
                int i22 = i14 + 1;
                byte[] bArr2 = f27009k;
                destination[i14] = bArr2[0];
                i14 = i22 + 1;
                destination[i22] = bArr2[1];
            }
        }
        int i23 = i12 - i11;
        if (i23 == 1) {
            int i24 = i11 + 1;
            int i25 = (source[i11] & 255) << 4;
            int i26 = i14 + 1;
            destination[i14] = bArr[i25 >>> 6];
            int i27 = i26 + 1;
            destination[i26] = bArr[i25 & 63];
            int i28 = i27 + 1;
            destination[i27] = 61;
            i14 = i28 + 1;
            destination[i28] = 61;
            i11 = i24;
        } else if (i23 == 2) {
            int i29 = i11 + 1;
            int i30 = i29 + 1;
            int i31 = ((source[i29] & 255) << 2) | ((source[i11] & 255) << 10);
            int i32 = i14 + 1;
            destination[i14] = bArr[i31 >>> 12];
            int i33 = i32 + 1;
            destination[i32] = bArr[(i31 >>> 6) & 63];
            int i34 = i33 + 1;
            destination[i33] = bArr[i31 & 63];
            i14 = i34 + 1;
            destination[i34] = 61;
            i11 = i30;
        }
        if (i11 == i12) {
            return i14 - i10;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final int w(int i10) {
        int i11 = ((i10 + 3) - 1) / 3;
        int i12 = (i11 * 4) + ((this.f27013b ? (i11 - 1) / 19 : 0) * 2);
        if (i12 >= 0) {
            return i12;
        }
        throw new IllegalArgumentException("Input is too big");
    }

    @k
    public final <A extends Appendable> A x(@k byte[] source, @k A destination, int i10, int i11) throws IOException {
        f0.p(source, "source");
        f0.p(destination, "destination");
        destination.append(new String(B(source, i10, i11), kotlin.text.d.f38166g));
        return destination;
    }

    @k
    public final byte[] z(@k byte[] source, int i10, int i11) {
        f0.p(source, "source");
        return B(source, i10, i11);
    }
}
