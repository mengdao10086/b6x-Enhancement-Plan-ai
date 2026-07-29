package a4;

import a4.a;
import android.graphics.Bitmap;
import android.util.Log;
import g.l;
import g.n0;
import g.p0;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class e implements a {
    public static final String A = "e";
    public static final int B = 4096;
    public static final int C = -1;
    public static final int D = -1;
    public static final int E = 4;
    public static final int F = 255;

    @l
    public static final int G = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @l
    public int[] f224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public final int[] f225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a.InterfaceC0009a f226h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ByteBuffer f227i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public byte[] f228j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public d f229k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public short[] f230l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public byte[] f231m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte[] f232n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public byte[] f233o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @l
    public int[] f234p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f235q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c f236r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Bitmap f237s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f238t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f239u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f240v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f241w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f242x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @p0
    public Boolean f243y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @n0
    public Bitmap.Config f244z;

    public e(@n0 a.InterfaceC0009a interfaceC0009a, c cVar, ByteBuffer byteBuffer) {
        this(interfaceC0009a, cVar, byteBuffer, 1);
    }

    @Override // a4.a
    @p0
    public synchronized Bitmap a() {
        if (this.f236r.f189c <= 0 || this.f235q < 0) {
            if (Log.isLoggable(A, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to decode frame, frameCount=");
                sb2.append(this.f236r.f189c);
                sb2.append(", framePointer=");
                sb2.append(this.f235q);
            }
            this.f239u = 1;
        }
        int i10 = this.f239u;
        if (i10 != 1 && i10 != 2) {
            this.f239u = 0;
            if (this.f228j == null) {
                this.f228j = this.f226h.e(255);
            }
            b bVar = this.f236r.f191e.get(this.f235q);
            int i11 = this.f235q - 1;
            b bVar2 = i11 >= 0 ? this.f236r.f191e.get(i11) : null;
            int[] iArr = bVar.f184k;
            if (iArr == null) {
                iArr = this.f236r.f187a;
            }
            this.f224f = iArr;
            if (iArr == null) {
                if (Log.isLoggable(A, 3)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("No valid color table found for frame #");
                    sb3.append(this.f235q);
                }
                this.f239u = 1;
                return null;
            }
            if (bVar.f179f) {
                System.arraycopy(iArr, 0, this.f225g, 0, iArr.length);
                int[] iArr2 = this.f225g;
                this.f224f = iArr2;
                iArr2[bVar.f181h] = 0;
                if (bVar.f180g == 2 && this.f235q == 0) {
                    this.f243y = Boolean.TRUE;
                }
            }
            return z(bVar, bVar2);
        }
        if (Log.isLoggable(A, 3)) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Unable to decode frame, status=");
            sb4.append(this.f239u);
        }
        return null;
    }

    @Override // a4.a
    public void b() {
        this.f235q = (this.f235q + 1) % this.f236r.f189c;
    }

    @Override // a4.a
    public int c() {
        return this.f236r.f189c;
    }

    @Override // a4.a
    public void clear() {
        this.f236r = null;
        byte[] bArr = this.f233o;
        if (bArr != null) {
            this.f226h.d(bArr);
        }
        int[] iArr = this.f234p;
        if (iArr != null) {
            this.f226h.f(iArr);
        }
        Bitmap bitmap = this.f237s;
        if (bitmap != null) {
            this.f226h.c(bitmap);
        }
        this.f237s = null;
        this.f227i = null;
        this.f243y = null;
        byte[] bArr2 = this.f228j;
        if (bArr2 != null) {
            this.f226h.d(bArr2);
        }
    }

    @Override // a4.a
    public int d() {
        int i10;
        if (this.f236r.f189c <= 0 || (i10 = this.f235q) < 0) {
            return 0;
        }
        return g(i10);
    }

    @Override // a4.a
    public synchronized void e(@n0 c cVar, @n0 byte[] bArr) {
        m(cVar, ByteBuffer.wrap(bArr));
    }

    @Override // a4.a
    public void f(@n0 Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.f244z = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    @Override // a4.a
    public int g(int i10) {
        if (i10 >= 0) {
            c cVar = this.f236r;
            if (i10 < cVar.f189c) {
                return cVar.f191e.get(i10).f182i;
            }
        }
        return -1;
    }

    @Override // a4.a
    @n0
    public ByteBuffer getData() {
        return this.f227i;
    }

    @Override // a4.a
    public int getHeight() {
        return this.f236r.f193g;
    }

    @Override // a4.a
    public int getWidth() {
        return this.f236r.f192f;
    }

    @Override // a4.a
    public void h() {
        this.f235q = -1;
    }

    @Override // a4.a
    public int i() {
        return this.f235q;
    }

    @Override // a4.a
    public int j() {
        return this.f236r.f199m;
    }

    @Override // a4.a
    public int k() {
        return this.f239u;
    }

    @Override // a4.a
    public int l(@p0 InputStream inputStream, int i10) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i10 > 0 ? i10 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int i11 = inputStream.read(bArr, 0, 16384);
                    if (i11 == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i11);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException unused) {
            }
        } else {
            this.f239u = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
        }
        return this.f239u;
    }

    @Override // a4.a
    public synchronized void m(@n0 c cVar, @n0 ByteBuffer byteBuffer) {
        p(cVar, byteBuffer, 1);
    }

    @Override // a4.a
    public int n() {
        return this.f227i.limit() + this.f233o.length + (this.f234p.length * 4);
    }

    @Override // a4.a
    public int o() {
        int i10 = this.f236r.f199m;
        if (i10 == -1) {
            return 1;
        }
        if (i10 == 0) {
            return 0;
        }
        return i10 + 1;
    }

    @Override // a4.a
    public synchronized void p(@n0 c cVar, @n0 ByteBuffer byteBuffer, int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
        }
        int iHighestOneBit = Integer.highestOneBit(i10);
        this.f239u = 0;
        this.f236r = cVar;
        this.f235q = -1;
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f227i = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.f227i.order(ByteOrder.LITTLE_ENDIAN);
        this.f238t = false;
        Iterator<b> it2 = cVar.f191e.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            } else if (it2.next().f180g == 3) {
                this.f238t = true;
                break;
            }
        }
        this.f240v = iHighestOneBit;
        int i11 = cVar.f192f;
        this.f242x = i11 / iHighestOneBit;
        int i12 = cVar.f193g;
        this.f241w = i12 / iHighestOneBit;
        this.f233o = this.f226h.e(i11 * i12);
        this.f234p = this.f226h.b(this.f242x * this.f241w);
    }

    @Override // a4.a
    @Deprecated
    public int q() {
        int i10 = this.f236r.f199m;
        if (i10 == -1) {
            return 1;
        }
        return i10;
    }

    @l
    public final int r(int i10, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = i10; i18 < this.f240v + i10; i18++) {
            byte[] bArr = this.f233o;
            if (i18 >= bArr.length || i18 >= i11) {
                break;
            }
            int i19 = this.f224f[bArr[i18] & 255];
            if (i19 != 0) {
                i13 += (i19 >> 24) & 255;
                i14 += (i19 >> 16) & 255;
                i15 += (i19 >> 8) & 255;
                i16 += i19 & 255;
                i17++;
            }
        }
        int i20 = i10 + i12;
        for (int i21 = i20; i21 < this.f240v + i20; i21++) {
            byte[] bArr2 = this.f233o;
            if (i21 >= bArr2.length || i21 >= i11) {
                break;
            }
            int i22 = this.f224f[bArr2[i21] & 255];
            if (i22 != 0) {
                i13 += (i22 >> 24) & 255;
                i14 += (i22 >> 16) & 255;
                i15 += (i22 >> 8) & 255;
                i16 += i22 & 255;
                i17++;
            }
        }
        if (i17 == 0) {
            return 0;
        }
        return ((i13 / i17) << 24) | ((i14 / i17) << 16) | ((i15 / i17) << 8) | (i16 / i17);
    }

    @Override // a4.a
    public synchronized int read(@p0 byte[] bArr) {
        c cVarD = v().r(bArr).d();
        this.f236r = cVarD;
        if (bArr != null) {
            e(cVarD, bArr);
        }
        return this.f239u;
    }

    public final void s(b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int[] iArr = this.f234p;
        int i15 = bVar.f177d;
        int i16 = this.f240v;
        int i17 = i15 / i16;
        int i18 = bVar.f175b / i16;
        int i19 = bVar.f176c / i16;
        int i20 = bVar.f174a / i16;
        boolean z10 = this.f235q == 0;
        int i21 = this.f242x;
        int i22 = this.f241w;
        byte[] bArr = this.f233o;
        int[] iArr2 = this.f224f;
        Boolean bool = this.f243y;
        int i23 = 8;
        int i24 = 0;
        int i25 = 0;
        int i26 = 1;
        while (i24 < i17) {
            Boolean bool2 = bool;
            if (bVar.f178e) {
                if (i25 >= i17) {
                    i10 = i17;
                    int i27 = i26 + 1;
                    if (i27 == 2) {
                        i26 = i27;
                        i25 = 4;
                    } else if (i27 == 3) {
                        i26 = i27;
                        i25 = 2;
                        i23 = 4;
                    } else if (i27 != 4) {
                        i26 = i27;
                    } else {
                        i26 = i27;
                        i25 = 1;
                        i23 = 2;
                    }
                } else {
                    i10 = i17;
                }
                i11 = i25 + i23;
            } else {
                i10 = i17;
                i11 = i25;
                i25 = i24;
            }
            int i28 = i25 + i18;
            boolean z11 = i16 == 1;
            if (i28 < i22) {
                int i29 = i28 * i21;
                int i30 = i29 + i20;
                int i31 = i30 + i19;
                int i32 = i29 + i21;
                if (i32 < i31) {
                    i31 = i32;
                }
                i12 = i11;
                int i33 = i24 * i16 * bVar.f176c;
                if (z11) {
                    int i34 = i30;
                    while (i34 < i31) {
                        int i35 = i18;
                        int i36 = iArr2[bArr[i33] & 255];
                        if (i36 != 0) {
                            iArr[i34] = i36;
                        } else if (z10 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i33 += i16;
                        i34++;
                        i18 = i35;
                    }
                } else {
                    i14 = i18;
                    int i37 = ((i31 - i30) * i16) + i33;
                    int i38 = i30;
                    while (true) {
                        i13 = i19;
                        if (i38 < i31) {
                            int iR = r(i33, i37, bVar.f176c);
                            if (iR != 0) {
                                iArr[i38] = iR;
                            } else if (z10 && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i33 += i16;
                            i38++;
                            i19 = i13;
                        }
                    }
                    bool = bool2;
                    i24++;
                    i18 = i14;
                    i19 = i13;
                    i17 = i10;
                    i25 = i12;
                }
            } else {
                i12 = i11;
            }
            i14 = i18;
            i13 = i19;
            bool = bool2;
            i24++;
            i18 = i14;
            i19 = i13;
            i17 = i10;
            i25 = i12;
        }
        Boolean bool3 = bool;
        if (this.f243y == null) {
            this.f243y = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    public final void t(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.f234p;
        int i10 = bVar2.f177d;
        int i11 = bVar2.f175b;
        int i12 = bVar2.f176c;
        int i13 = bVar2.f174a;
        boolean z10 = this.f235q == 0;
        int i14 = this.f242x;
        byte[] bArr = this.f233o;
        int[] iArr2 = this.f224f;
        int i15 = 0;
        byte b10 = -1;
        while (i15 < i10) {
            int i16 = (i15 + i11) * i14;
            int i17 = i16 + i13;
            int i18 = i17 + i12;
            int i19 = i16 + i14;
            if (i19 < i18) {
                i18 = i19;
            }
            int i20 = bVar2.f176c * i15;
            int i21 = i17;
            while (i21 < i18) {
                byte b11 = bArr[i20];
                int i22 = i10;
                int i23 = b11 & 255;
                if (i23 != b10) {
                    int i24 = iArr2[i23];
                    if (i24 != 0) {
                        iArr[i21] = i24;
                    } else {
                        b10 = b11;
                    }
                }
                i20++;
                i21++;
                i10 = i22;
            }
            i15++;
            bVar2 = bVar;
        }
        Boolean bool = this.f243y;
        this.f243y = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.f243y == null && z10 && b10 != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    public final void u(b bVar) {
        int i10;
        int i11;
        short s10;
        e eVar = this;
        if (bVar != null) {
            eVar.f227i.position(bVar.f183j);
        }
        if (bVar == null) {
            c cVar = eVar.f236r;
            i10 = cVar.f192f;
            i11 = cVar.f193g;
        } else {
            i10 = bVar.f176c;
            i11 = bVar.f177d;
        }
        int i12 = i10 * i11;
        byte[] bArr = eVar.f233o;
        if (bArr == null || bArr.length < i12) {
            eVar.f233o = eVar.f226h.e(i12);
        }
        byte[] bArr2 = eVar.f233o;
        if (eVar.f230l == null) {
            eVar.f230l = new short[4096];
        }
        short[] sArr = eVar.f230l;
        if (eVar.f231m == null) {
            eVar.f231m = new byte[4096];
        }
        byte[] bArr3 = eVar.f231m;
        if (eVar.f232n == null) {
            eVar.f232n = new byte[4097];
        }
        byte[] bArr4 = eVar.f232n;
        int iY = y();
        int i13 = 1 << iY;
        int i14 = i13 + 1;
        int i15 = i13 + 2;
        int i16 = iY + 1;
        int i17 = (1 << i16) - 1;
        int i18 = 0;
        for (int i19 = 0; i19 < i13; i19++) {
            sArr[i19] = 0;
            bArr3[i19] = (byte) i19;
        }
        byte[] bArr5 = eVar.f228j;
        int i20 = i16;
        int i21 = i15;
        int i22 = i17;
        int iX = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = -1;
        int i28 = 0;
        int i29 = 0;
        while (true) {
            if (i18 >= i12) {
                break;
            }
            if (iX == 0) {
                iX = x();
                if (iX <= 0) {
                    eVar.f239u = 3;
                    break;
                }
                i23 = 0;
            }
            i25 += (bArr5[i23] & 255) << i24;
            i23++;
            iX--;
            int i30 = i24 + 8;
            int i31 = i21;
            int i32 = i20;
            int i33 = i27;
            int i34 = i16;
            int i35 = i28;
            while (true) {
                if (i30 < i32) {
                    i27 = i33;
                    i21 = i31;
                    i24 = i30;
                    eVar = this;
                    i28 = i35;
                    i16 = i34;
                    i20 = i32;
                    break;
                }
                int i36 = i15;
                int i37 = i25 & i22;
                i25 >>= i32;
                i30 -= i32;
                if (i37 == i13) {
                    i22 = i17;
                    i32 = i34;
                    i31 = i36;
                    i15 = i31;
                    i33 = -1;
                } else {
                    if (i37 == i14) {
                        i24 = i30;
                        i28 = i35;
                        i21 = i31;
                        i16 = i34;
                        i15 = i36;
                        i27 = i33;
                        i20 = i32;
                        eVar = this;
                        break;
                    }
                    if (i33 == -1) {
                        bArr2[i26] = bArr3[i37];
                        i26++;
                        i18++;
                        i33 = i37;
                        i35 = i33;
                        i15 = i36;
                        i30 = i30;
                    } else {
                        if (i37 >= i31) {
                            bArr4[i29] = (byte) i35;
                            i29++;
                            s10 = i33;
                        } else {
                            s10 = i37;
                        }
                        while (s10 >= i13) {
                            bArr4[i29] = bArr3[s10];
                            i29++;
                            s10 = sArr[s10];
                        }
                        i35 = bArr3[s10] & 255;
                        byte b10 = (byte) i35;
                        bArr2[i26] = b10;
                        while (true) {
                            i26++;
                            i18++;
                            if (i29 <= 0) {
                                break;
                            }
                            i29--;
                            bArr2[i26] = bArr4[i29];
                        }
                        byte[] bArr6 = bArr4;
                        if (i31 < 4096) {
                            sArr[i31] = (short) i33;
                            bArr3[i31] = b10;
                            i31++;
                            if ((i31 & i22) == 0 && i31 < 4096) {
                                i32++;
                                i22 += i31;
                            }
                        }
                        i33 = i37;
                        i15 = i36;
                        i30 = i30;
                        bArr4 = bArr6;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i26, i12, (byte) 0);
    }

    @n0
    public final d v() {
        if (this.f229k == null) {
            this.f229k = new d();
        }
        return this.f229k;
    }

    public final Bitmap w() {
        Boolean bool = this.f243y;
        Bitmap bitmapA = this.f226h.a(this.f242x, this.f241w, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f244z);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    public final int x() {
        int iY = y();
        if (iY <= 0) {
            return iY;
        }
        ByteBuffer byteBuffer = this.f227i;
        byteBuffer.get(this.f228j, 0, Math.min(iY, byteBuffer.remaining()));
        return iY;
    }

    public final int y() {
        return this.f227i.get() & 255;
    }

    public final Bitmap z(b bVar, b bVar2) {
        int i10;
        int i11;
        Bitmap bitmap;
        int[] iArr = this.f234p;
        int i12 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.f237s;
            if (bitmap2 != null) {
                this.f226h.c(bitmap2);
            }
            this.f237s = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f180g == 3 && this.f237s == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i11 = bVar2.f180g) > 0) {
            if (i11 == 2) {
                if (!bVar.f179f) {
                    c cVar = this.f236r;
                    int i13 = cVar.f198l;
                    if (bVar.f184k == null || cVar.f196j != bVar.f181h) {
                        i12 = i13;
                    }
                }
                int i14 = bVar2.f177d;
                int i15 = this.f240v;
                int i16 = i14 / i15;
                int i17 = bVar2.f175b / i15;
                int i18 = bVar2.f176c / i15;
                int i19 = bVar2.f174a / i15;
                int i20 = this.f242x;
                int i21 = (i17 * i20) + i19;
                int i22 = (i16 * i20) + i21;
                while (i21 < i22) {
                    int i23 = i21 + i18;
                    for (int i24 = i21; i24 < i23; i24++) {
                        iArr[i24] = i12;
                    }
                    i21 += this.f242x;
                }
            } else if (i11 == 3 && (bitmap = this.f237s) != null) {
                int i25 = this.f242x;
                bitmap.getPixels(iArr, 0, i25, 0, 0, i25, this.f241w);
            }
        }
        u(bVar);
        if (bVar.f178e || this.f240v != 1) {
            s(bVar);
        } else {
            t(bVar);
        }
        if (this.f238t && ((i10 = bVar.f180g) == 0 || i10 == 1)) {
            if (this.f237s == null) {
                this.f237s = w();
            }
            Bitmap bitmap3 = this.f237s;
            int i26 = this.f242x;
            bitmap3.setPixels(iArr, 0, i26, 0, 0, i26, this.f241w);
        }
        Bitmap bitmapW = w();
        int i27 = this.f242x;
        bitmapW.setPixels(iArr, 0, i27, 0, 0, i27, this.f241w);
        return bitmapW;
    }

    public e(@n0 a.InterfaceC0009a interfaceC0009a, c cVar, ByteBuffer byteBuffer, int i10) {
        this(interfaceC0009a);
        p(cVar, byteBuffer, i10);
    }

    public e(@n0 a.InterfaceC0009a interfaceC0009a) {
        this.f225g = new int[256];
        this.f244z = Bitmap.Config.ARGB_8888;
        this.f226h = interfaceC0009a;
        this.f236r = new c();
    }
}
