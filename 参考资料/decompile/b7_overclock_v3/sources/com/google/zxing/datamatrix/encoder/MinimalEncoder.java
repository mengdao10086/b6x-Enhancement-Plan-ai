package com.google.zxing.datamatrix.encoder;

import com.flydigi.sdk.waspwing.WaspWingInfo;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.y;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import v7.a;

/* JADX INFO: loaded from: classes7.dex */
public final class MinimalEncoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f21299a = {PublicSuffixDatabase.f43873i, y.f38188b, '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', zc.f.f58380j, ':', zc.f.f58382l, '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};

    public enum Mode {
        ASCII,
        C40,
        TEXT,
        X12,
        EDF,
        B256
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f21301b;

        static {
            int[] iArr = new int[SymbolShapeHint.values().length];
            f21301b = iArr;
            try {
                iArr[SymbolShapeHint.FORCE_SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21301b[SymbolShapeHint.FORCE_RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Mode.values().length];
            f21300a = iArr2;
            try {
                iArr2[Mode.ASCII.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21300a[Mode.B256.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21300a[Mode.C40.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f21300a[Mode.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f21300a[Mode.X12.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f21300a[Mode.EDF.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final int[] f21302g = {3, 5, 8, 10, 12, 16, 18, 22, 30, 32, 36, 44, 49, 62, 86, 114, 144, mb.e.f41073w1, a.c.f52774j, 280, 368, 456, 576, 696, 816, 1050, 1304, 1558};

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final int[] f21303h = {3, 5, 8, 12, 18, 22, 30, 36, 44, 62, 86, 114, 144, mb.e.f41073w1, a.c.f52774j, 280, 368, 456, 576, 696, 816, 1050, 1304, 1558};

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final int[] f21304i = {5, 10, 16, 33, 32, 49};

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ boolean f21305j = false;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f21306a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Mode f21307b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f21308c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f21309d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final b f21310e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f21311f;

        public /* synthetic */ b(c cVar, Mode mode, int i10, int i11, b bVar, a aVar) {
            this(cVar, mode, i10, i11, bVar);
        }

        public static byte[] h(int i10) {
            return new byte[]{(byte) i10};
        }

        public static byte[] i(int i10, int i11) {
            return new byte[]{(byte) i10, (byte) i11};
        }

        public static int j(boolean z10, int i10, char c10, int i11) {
            if (c10 == i11) {
                return 27;
            }
            if (z10) {
                if (c10 <= 31) {
                    return c10;
                }
                if (c10 == ' ') {
                    return 3;
                }
                return c10 <= '/' ? c10 - '!' : c10 <= '9' ? c10 - ',' : c10 <= '@' ? c10 - '+' : c10 <= 'Z' ? c10 - '3' : c10 <= '_' ? c10 - 'E' : c10 <= 127 ? c10 - '`' : c10;
            }
            if (c10 != 0) {
                if (i10 == 0 && c10 <= 3) {
                    return c10 - 1;
                }
                if (i10 == 1 && c10 <= 31) {
                    return c10;
                }
                if (c10 == ' ') {
                    return 3;
                }
                if (c10 >= '!' && c10 <= '/') {
                    return c10 - '!';
                }
                if (c10 >= '0' && c10 <= '9') {
                    return c10 - ',';
                }
                if (c10 >= ':' && c10 <= '@') {
                    return c10 - '+';
                }
                if (c10 >= 'A' && c10 <= 'Z') {
                    return c10 - '@';
                }
                if (c10 >= '[' && c10 <= '_') {
                    return c10 - 'E';
                }
                if (c10 != '`') {
                    return (c10 < 'a' || c10 > 'z') ? (c10 < '{' || c10 > 127) ? c10 : c10 - '`' : c10 - 'S';
                }
            }
            return 0;
        }

        public static int v(char c10, boolean z10, int i10) {
            if (!(z10 && MinimalEncoder.m(c10)) && (z10 || !MinimalEncoder.o(c10))) {
                return (!(z10 && MinimalEncoder.n(c10, i10)) && (z10 || !MinimalEncoder.p(c10, i10))) ? 2 : 1;
            }
            return 0;
        }

        public static int w(char c10) {
            if (c10 == '\r') {
                return 0;
            }
            if (c10 == '*') {
                return 1;
            }
            if (c10 == '>') {
                return 2;
            }
            if (c10 == ' ') {
                return 3;
            }
            return (c10 < '0' || c10 > '9') ? (c10 < 'A' || c10 > 'Z') ? c10 : c10 - '3' : c10 - ',';
        }

        public static void y(byte[] bArr, int i10, int i11, int i12, int i13) {
            int i14 = ((i11 & 255) * 1600) + ((i12 & 255) * 40) + (i13 & 255) + 1;
            bArr[i10] = (byte) (i14 / 256);
            bArr[i10 + 1] = (byte) (i14 % 256);
        }

        public int g() {
            int i10 = 0;
            for (b bVar = this; bVar != null && bVar.f21307b == Mode.B256 && i10 <= 250; bVar = bVar.f21310e) {
                i10++;
            }
            return i10;
        }

        public byte[] k(boolean z10, int i10) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < this.f21309d; i11++) {
                char cCharAt = this.f21306a.charAt(this.f21308c + i11);
                if ((z10 && j.j(cCharAt)) || (!z10 && j.l(cCharAt))) {
                    arrayList.add(Byte.valueOf((byte) j(z10, 0, cCharAt, i10)));
                } else if (MinimalEncoder.l(cCharAt, i10)) {
                    char c10 = (char) ((cCharAt & 255) - 128);
                    if (!(z10 && j.j(c10)) && (z10 || !j.l(c10))) {
                        arrayList.add((byte) 1);
                        arrayList.add((byte) 30);
                        int iV = v(c10, z10, i10);
                        arrayList.add(Byte.valueOf((byte) iV));
                        arrayList.add(Byte.valueOf((byte) j(z10, iV, c10, i10)));
                    } else {
                        arrayList.add((byte) 1);
                        arrayList.add((byte) 30);
                        arrayList.add(Byte.valueOf((byte) j(z10, 0, c10, i10)));
                    }
                } else {
                    int iV2 = v(cCharAt, z10, i10);
                    arrayList.add(Byte.valueOf((byte) iV2));
                    arrayList.add(Byte.valueOf((byte) j(z10, iV2, cCharAt, i10)));
                }
            }
            if (arrayList.size() % 3 != 0) {
                arrayList.add((byte) 0);
            }
            byte[] bArr = new byte[(arrayList.size() / 3) * 2];
            int i12 = 0;
            for (int i13 = 0; i13 < arrayList.size(); i13 += 3) {
                y(bArr, i12, ((Byte) arrayList.get(i13)).byteValue() & 255, ((Byte) arrayList.get(i13 + 1)).byteValue() & 255, ((Byte) arrayList.get(i13 + 2)).byteValue() & 255);
                i12 += 2;
            }
            return bArr;
        }

        public int l(int i10) {
            return r(i10) - i10;
        }

        public byte[] m() {
            switch (a.f21300a[this.f21307b.ordinal()]) {
                case 1:
                    return this.f21306a.b(this.f21308c) ? i(241, this.f21306a.a(this.f21308c) + 1) : MinimalEncoder.l(this.f21306a.charAt(this.f21308c), this.f21306a.g()) ? i(235, this.f21306a.charAt(this.f21308c) - 127) : this.f21309d == 2 ? h(((((this.f21306a.charAt(this.f21308c) - '0') * 10) + this.f21306a.charAt(this.f21308c + 1)) - 48) + 130) : this.f21306a.h(this.f21308c) ? h(232) : h(this.f21306a.charAt(this.f21308c) + 1);
                case 2:
                    return h(this.f21306a.charAt(this.f21308c));
                case 3:
                    return k(true, this.f21306a.g());
                case 4:
                    return k(false, this.f21306a.g());
                case 5:
                    return x();
                case 6:
                    return n();
                default:
                    return new byte[0];
            }
        }

        public byte[] n() {
            int iCeil = (int) Math.ceil(((double) this.f21309d) / 4.0d);
            byte[] bArr = new byte[iCeil * 3];
            int i10 = this.f21308c;
            int iMin = Math.min((this.f21309d + i10) - 1, this.f21306a.length() - 1);
            for (int i11 = 0; i11 < iCeil; i11 += 3) {
                int[] iArr = new int[4];
                for (int i12 = 0; i12 < 4; i12++) {
                    if (i10 <= iMin) {
                        iArr[i12] = this.f21306a.charAt(i10) & '?';
                        i10++;
                    } else {
                        iArr[i12] = i10 == iMin + 1 ? 31 : 0;
                    }
                }
                int i13 = (iArr[0] << 18) | (iArr[1] << 12) | (iArr[2] << 6) | iArr[3];
                bArr[i11] = (byte) ((i13 >> 16) & 255);
                bArr[i11 + 1] = (byte) ((i13 >> 8) & 255);
                bArr[i11 + 2] = (byte) (i13 & 255);
            }
            return bArr;
        }

        public Mode o() {
            if (this.f21307b == Mode.EDF) {
                if (this.f21309d < 4) {
                    return Mode.ASCII;
                }
                int iP = p();
                if (iP > 0 && l(this.f21311f + iP) <= 2 - iP) {
                    return Mode.ASCII;
                }
            }
            Mode mode = this.f21307b;
            if (mode == Mode.C40 || mode == Mode.TEXT || mode == Mode.X12) {
                if (this.f21308c + this.f21309d >= this.f21306a.length() && l(this.f21311f) == 0) {
                    return Mode.ASCII;
                }
                if (p() == 1 && l(this.f21311f + 1) == 0) {
                    return Mode.ASCII;
                }
            }
            return this.f21307b;
        }

        public int p() {
            int length = this.f21306a.length();
            int i10 = this.f21308c + this.f21309d;
            int i11 = length - i10;
            if (i11 <= 4 && i10 < length) {
                if (i11 == 1) {
                    return MinimalEncoder.l(this.f21306a.charAt(i10), this.f21306a.g()) ? 0 : 1;
                }
                if (i11 == 2) {
                    if (!MinimalEncoder.l(this.f21306a.charAt(i10), this.f21306a.g())) {
                        int i12 = i10 + 1;
                        if (!MinimalEncoder.l(this.f21306a.charAt(i12), this.f21306a.g())) {
                            return (j.h(this.f21306a.charAt(i10)) && j.h(this.f21306a.charAt(i12))) ? 1 : 2;
                        }
                    }
                    return 0;
                }
                if (i11 == 3) {
                    if (j.h(this.f21306a.charAt(i10)) && j.h(this.f21306a.charAt(i10 + 1)) && !MinimalEncoder.l(this.f21306a.charAt(i10 + 2), this.f21306a.g())) {
                        return 2;
                    }
                    return (j.h(this.f21306a.charAt(i10 + 1)) && j.h(this.f21306a.charAt(i10 + 2)) && !MinimalEncoder.l(this.f21306a.charAt(i10), this.f21306a.g())) ? 2 : 0;
                }
                if (j.h(this.f21306a.charAt(i10)) && j.h(this.f21306a.charAt(i10 + 1)) && j.h(this.f21306a.charAt(i10 + 2)) && j.h(this.f21306a.charAt(i10 + 3))) {
                    return 2;
                }
            }
            return 0;
        }

        public byte[] q() {
            int[] iArr = a.f21300a;
            switch (iArr[t().ordinal()]) {
                case 1:
                case 2:
                    int i10 = iArr[this.f21307b.ordinal()];
                    if (i10 == 2) {
                        return h(mb.e.f41040l1);
                    }
                    if (i10 == 3) {
                        return h(WaspWingInfo.EXPERIMENTAL_RUN_MODE_COLD_LEVEL);
                    }
                    if (i10 == 4) {
                        return h(239);
                    }
                    if (i10 == 5) {
                        return h(mb.e.f41061s1);
                    }
                    if (i10 == 6) {
                        return h(240);
                    }
                    break;
                case 3:
                case 4:
                case 5:
                    if (this.f21307b != t()) {
                        switch (iArr[this.f21307b.ordinal()]) {
                            case 1:
                                return h(254);
                            case 2:
                                return i(254, mb.e.f41040l1);
                            case 3:
                                return i(254, WaspWingInfo.EXPERIMENTAL_RUN_MODE_COLD_LEVEL);
                            case 4:
                                return i(254, 239);
                            case 5:
                                return i(254, mb.e.f41061s1);
                            case 6:
                                return i(254, 240);
                        }
                    }
                    break;
            }
            return new byte[0];
        }

        public int r(int i10) {
            int i11 = a.f21301b[this.f21306a.l().ordinal()];
            if (i11 == 1) {
                for (int i12 : f21303h) {
                    if (i12 >= i10) {
                        return i12;
                    }
                }
            } else if (i11 == 2) {
                for (int i13 : f21304i) {
                    if (i13 >= i10) {
                        return i13;
                    }
                }
            }
            for (int i14 : f21302g) {
                if (i14 >= i10) {
                    return i14;
                }
            }
            int[] iArr = f21302g;
            return iArr[iArr.length - 1];
        }

        public Mode s() {
            return this.f21307b;
        }

        public Mode t() {
            b bVar = this.f21310e;
            return bVar == null ? Mode.ASCII : bVar.o();
        }

        public Mode u() {
            b bVar = this.f21310e;
            return bVar == null ? Mode.ASCII : bVar.f21307b;
        }

        public byte[] x() {
            int i10 = (this.f21309d / 3) * 2;
            byte[] bArr = new byte[i10];
            for (int i11 = 0; i11 < i10; i11 += 2) {
                int i12 = (i11 / 2) * 3;
                y(bArr, i11, w(this.f21306a.charAt(this.f21308c + i12)), w(this.f21306a.charAt(this.f21308c + i12 + 1)), w(this.f21306a.charAt(this.f21308c + i12 + 2)));
            }
            return bArr;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x003c A[PHI: r10
  0x003c: PHI (r10v15 int) = 
  (r10v8 int)
  (r10v8 int)
  (r10v8 int)
  (r10v11 int)
  (r10v11 int)
  (r10v11 int)
  (r10v17 int)
  (r10v17 int)
  (r10v17 int)
 binds: [B:51:0x0089, B:53:0x008d, B:55:0x0091, B:36:0x0067, B:38:0x006b, B:39:0x006d, B:15:0x0032, B:17:0x0036, B:19:0x003a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0040 A[PHI: r10
  0x0040: PHI (r10v13 int) = (r10v6 int), (r10v6 int), (r10v6 int), (r10v8 int), (r10v11 int), (r10v11 int), (r10v17 int), (r10v17 int) binds: [B:63:0x00ae, B:65:0x00b2, B:67:0x00b6, B:48:0x0084, B:30:0x005c, B:32:0x0060, B:10:0x0029, B:12:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public b(com.google.zxing.datamatrix.encoder.MinimalEncoder.c r6, com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode r7, int r8, int r9, com.google.zxing.datamatrix.encoder.MinimalEncoder.b r10) {
            /*
                Method dump skipped, instruction units count: 204
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.MinimalEncoder.b.<init>(com.google.zxing.datamatrix.encoder.MinimalEncoder$c, com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode, int, int, com.google.zxing.datamatrix.encoder.MinimalEncoder$b):void");
        }
    }

    public static final class c extends af.m {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SymbolShapeHint f21312d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f21313e;

        public /* synthetic */ c(String str, Charset charset, int i10, SymbolShapeHint symbolShapeHint, int i11, a aVar) {
            this(str, charset, i10, symbolShapeHint, i11);
        }

        public final int k() {
            return this.f21313e;
        }

        public final SymbolShapeHint l() {
            return this.f21312d;
        }

        public c(String str, Charset charset, int i10, SymbolShapeHint symbolShapeHint, int i11) {
            super(str, charset, i10);
            this.f21312d = symbolShapeHint;
            this.f21313e = i11;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f21314a;

        public d(b bVar) {
            int i10;
            c cVar = bVar.f21306a;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i11 = 0;
            int iC = ((bVar.f21307b == Mode.C40 || bVar.f21307b == Mode.TEXT || bVar.f21307b == Mode.X12) && bVar.o() != Mode.ASCII) ? c(b.h(254), arrayList) + 0 : 0;
            for (b bVar2 = bVar; bVar2 != null; bVar2 = bVar2.f21310e) {
                iC += c(bVar2.m(), arrayList);
                if (bVar2.f21310e == null || bVar2.u() != bVar2.s()) {
                    if (bVar2.s() == Mode.B256) {
                        if (iC <= 249) {
                            arrayList.add(0, Byte.valueOf((byte) iC));
                            i10 = iC + 1;
                        } else {
                            arrayList.add(0, Byte.valueOf((byte) (iC % 250)));
                            arrayList.add(0, Byte.valueOf((byte) ((iC / 250) + a4.d.f205j)));
                            i10 = iC + 2;
                        }
                        arrayList2.add(Integer.valueOf(arrayList.size()));
                        arrayList3.add(Integer.valueOf(i10));
                    }
                    c(bVar2.q(), arrayList);
                    iC = 0;
                }
            }
            if (cVar.k() == 5) {
                c(b.h(236), arrayList);
            } else if (cVar.k() == 6) {
                c(b.h(237), arrayList);
            }
            if (cVar.g() > 0) {
                c(b.h(232), arrayList);
            }
            for (int i12 = 0; i12 < arrayList2.size(); i12++) {
                a(arrayList, arrayList.size() - ((Integer) arrayList2.get(i12)).intValue(), ((Integer) arrayList3.get(i12)).intValue());
            }
            int iR = bVar.r(arrayList.size());
            if (arrayList.size() < iR) {
                arrayList.add((byte) -127);
            }
            while (arrayList.size() < iR) {
                arrayList.add(Byte.valueOf((byte) d(arrayList.size() + 1)));
            }
            this.f21314a = new byte[arrayList.size()];
            while (true) {
                byte[] bArr = this.f21314a;
                if (i11 >= bArr.length) {
                    return;
                }
                bArr[i11] = ((Byte) arrayList.get(i11)).byteValue();
                i11++;
            }
        }

        public static void a(List<Byte> list, int i10, int i11) {
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = i10 + i12;
                int iByteValue = (list.get(i13).byteValue() & 255) + (((i13 + 1) * WaspWingInfo.COLD_LEVEL_STANDARD_B7) % 255) + 1;
                if (iByteValue > 255) {
                    iByteValue -= 256;
                }
                list.set(i13, Byte.valueOf((byte) iByteValue));
            }
        }

        public static int c(byte[] bArr, List<Byte> list) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                list.add(0, Byte.valueOf(bArr[length]));
            }
            return bArr.length;
        }

        public static int d(int i10) {
            int i11 = ((i10 * WaspWingInfo.COLD_LEVEL_STANDARD_B7) % 253) + 1 + 129;
            return i11 <= 254 ? i11 : i11 - 254;
        }

        public byte[] b() {
            return this.f21314a;
        }
    }

    public static void e(b[][] bVarArr, b bVar) {
        int i10 = bVar.f21308c + bVar.f21309d;
        if (bVarArr[i10][bVar.o().ordinal()] == null || bVarArr[i10][bVar.o().ordinal()].f21311f > bVar.f21311f) {
            bVarArr[i10][bVar.o().ordinal()] = bVar;
        }
    }

    public static void f(c cVar, b[][] bVarArr, int i10, b bVar) {
        if (cVar.b(i10)) {
            e(bVarArr, new b(cVar, Mode.ASCII, i10, 1, bVar, null));
            return;
        }
        char cCharAt = cVar.charAt(i10);
        char c10 = 0;
        if (bVar == null || bVar.o() != Mode.EDF) {
            if (j.h(cCharAt) && cVar.c(i10, 2) && j.h(cVar.charAt(i10 + 1))) {
                e(bVarArr, new b(cVar, Mode.ASCII, i10, 2, bVar, null));
            } else {
                e(bVarArr, new b(cVar, Mode.ASCII, i10, 1, bVar, null));
            }
            Mode[] modeArr = {Mode.C40, Mode.TEXT};
            int i11 = 0;
            while (i11 < 2) {
                Mode mode = modeArr[i11];
                int[] iArr = new int[1];
                if (k(cVar, i10, mode == Mode.C40, iArr) > 0) {
                    e(bVarArr, new b(cVar, mode, i10, iArr[c10], bVar, null));
                }
                i11++;
                c10 = 0;
            }
            if (cVar.c(i10, 3) && j.m(cVar.charAt(i10)) && j.m(cVar.charAt(i10 + 1)) && j.m(cVar.charAt(i10 + 2))) {
                e(bVarArr, new b(cVar, Mode.X12, i10, 3, bVar, null));
            }
            e(bVarArr, new b(cVar, Mode.B256, i10, 1, bVar, null));
        }
        int i12 = 0;
        while (i12 < 3) {
            int i13 = i10 + i12;
            if (!cVar.c(i13, 1) || !j.k(cVar.charAt(i13))) {
                break;
            }
            i12++;
            e(bVarArr, new b(cVar, Mode.EDF, i10, i12, bVar, null));
        }
        if (i12 == 3 && cVar.c(i10, 4) && j.k(cVar.charAt(i10 + 3))) {
            e(bVarArr, new b(cVar, Mode.EDF, i10, 4, bVar, null));
        }
    }

    public static byte[] g(String str, Charset charset, int i10, SymbolShapeHint symbolShapeHint, int i11) {
        return j(new c(str, charset, i10, symbolShapeHint, i11, null)).b();
    }

    public static String h(String str) {
        return i(str, null, -1, SymbolShapeHint.FORCE_NONE);
    }

    public static String i(String str, Charset charset, int i10, SymbolShapeHint symbolShapeHint) {
        int i11;
        if (str.startsWith(j.f21344l) && str.endsWith(j.f21346n)) {
            i11 = 5;
            str = str.substring(7, str.length() - 2);
        } else if (str.startsWith(j.f21345m) && str.endsWith(j.f21346n)) {
            i11 = 6;
            str = str.substring(7, str.length() - 2);
        } else {
            i11 = 0;
        }
        return new String(g(str, charset, i10, symbolShapeHint, i11), StandardCharsets.ISO_8859_1);
    }

    public static d j(c cVar) {
        int length = cVar.length();
        int i10 = 0;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, length + 1, 6);
        f(cVar, bVarArr, 0, null);
        for (int i11 = 1; i11 <= length; i11++) {
            for (int i12 = 0; i12 < 6; i12++) {
                if (bVarArr[i11][i12] != null && i11 < length) {
                    f(cVar, bVarArr, i11, bVarArr[i11][i12]);
                }
            }
            for (int i13 = 0; i13 < 6; i13++) {
                bVarArr[i11 - 1][i13] = null;
            }
        }
        int i14 = -1;
        int i15 = Integer.MAX_VALUE;
        while (i10 < 6) {
            if (bVarArr[length][i10] != null) {
                b bVar = bVarArr[length][i10];
                int i16 = (i10 < 1 || i10 > 3) ? bVar.f21311f : bVar.f21311f + 1;
                if (i16 < i15) {
                    i14 = i10;
                    i15 = i16;
                }
            }
            i10++;
        }
        if (i14 >= 0) {
            return new d(bVarArr[length][i14]);
        }
        throw new IllegalStateException("Failed to encode \"" + cVar + "\"");
    }

    public static int k(c cVar, int i10, boolean z10, int[] iArr) {
        int i11 = 0;
        for (int i12 = i10; i12 < cVar.length(); i12++) {
            if (cVar.b(i12)) {
                iArr[0] = 0;
                return 0;
            }
            char cCharAt = cVar.charAt(i12);
            if ((z10 && j.j(cCharAt)) || (!z10 && j.l(cCharAt))) {
                i11++;
            } else if (l(cCharAt, cVar.g())) {
                int i13 = cCharAt & 255;
                i11 = (i13 < 128 || (!(z10 && j.j((char) (i13 + (-128)))) && (z10 || !j.l((char) (i13 + (-128)))))) ? i11 + 4 : i11 + 3;
            } else {
                i11 += 2;
            }
            if (i11 % 3 == 0 || ((i11 - 2) % 3 == 0 && i12 + 1 == cVar.length())) {
                iArr[0] = (i12 - i10) + 1;
                return (int) Math.ceil(((double) i11) / 3.0d);
            }
        }
        iArr[0] = 0;
        return 0;
    }

    public static boolean l(char c10, int i10) {
        return c10 != i10 && c10 >= 128 && c10 <= 255;
    }

    public static boolean m(char c10) {
        return c10 <= 31;
    }

    public static boolean n(char c10, int i10) {
        for (char c11 : f21299a) {
            if (c11 == c10) {
                return true;
            }
        }
        return c10 == i10;
    }

    public static boolean o(char c10) {
        return m(c10);
    }

    public static boolean p(char c10, int i10) {
        return n(c10, i10);
    }
}
