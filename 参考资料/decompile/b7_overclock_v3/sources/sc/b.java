package sc;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.google.common.math.DoubleMath;
import g.p0;
import hd.b0;
import hd.t;
import hd.u0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import qc.b;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f49589h = "DvbParser";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f49590i = 16;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f49591j = 17;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f49592k = 18;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f49593l = 19;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f49594m = 20;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f49595n = 0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f49596o = 2;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f49597p = 3;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f49598q = 0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f49599r = 1;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f49600s = 16;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f49601t = 17;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f49602u = 18;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f49603v = 32;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f49604w = 33;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f49605x = 34;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f49606y = 240;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f49608a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Paint f49609b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Canvas f49610c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C0570b f49611d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f49612e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h f49613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Bitmap f49614g;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final byte[] f49607z = {0, 7, 8, 15};
    public static final byte[] A = {0, 119, -120, -1};
    public static final byte[] B = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f49615a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int[] f49616b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int[] f49617c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int[] f49618d;

        public a(int i10, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f49615a = i10;
            this.f49616b = iArr;
            this.f49617c = iArr2;
            this.f49618d = iArr3;
        }
    }

    /* JADX INFO: renamed from: sc.b$b, reason: collision with other inner class name */
    public static final class C0570b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f49619a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f49620b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f49621c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f49622d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f49623e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f49624f;

        public C0570b(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f49619a = i10;
            this.f49620b = i11;
            this.f49621c = i12;
            this.f49622d = i13;
            this.f49623e = i14;
            this.f49624f = i15;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f49625a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f49626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final byte[] f49627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final byte[] f49628d;

        public c(int i10, boolean z10, byte[] bArr, byte[] bArr2) {
            this.f49625a = i10;
            this.f49626b = z10;
            this.f49627c = bArr;
            this.f49628d = bArr2;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f49629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f49630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f49631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray<e> f49632d;

        public d(int i10, int i11, int i12, SparseArray<e> sparseArray) {
            this.f49629a = i10;
            this.f49630b = i11;
            this.f49631c = i12;
            this.f49632d = sparseArray;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f49633a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f49634b;

        public e(int i10, int i11) {
            this.f49633a = i10;
            this.f49634b = i11;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f49635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f49636b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f49637c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f49638d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f49639e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f49640f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f49641g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f49642h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f49643i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final int f49644j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final SparseArray<g> f49645k;

        public f(int i10, boolean z10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, SparseArray<g> sparseArray) {
            this.f49635a = i10;
            this.f49636b = z10;
            this.f49637c = i11;
            this.f49638d = i12;
            this.f49639e = i13;
            this.f49640f = i14;
            this.f49641g = i15;
            this.f49642h = i16;
            this.f49643i = i17;
            this.f49644j = i18;
            this.f49645k = sparseArray;
        }

        public void a(f fVar) {
            SparseArray<g> sparseArray = fVar.f49645k;
            for (int i10 = 0; i10 < sparseArray.size(); i10++) {
                this.f49645k.put(sparseArray.keyAt(i10), sparseArray.valueAt(i10));
            }
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f49646a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f49647b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f49648c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f49649d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f49650e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f49651f;

        public g(int i10, int i11, int i12, int i13, int i14, int i15) {
            this.f49646a = i10;
            this.f49647b = i11;
            this.f49648c = i12;
            this.f49649d = i13;
            this.f49650e = i14;
            this.f49651f = i15;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f49652a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f49653b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final SparseArray<f> f49654c = new SparseArray<>();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SparseArray<a> f49655d = new SparseArray<>();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final SparseArray<c> f49656e = new SparseArray<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final SparseArray<a> f49657f = new SparseArray<>();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final SparseArray<c> f49658g = new SparseArray<>();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @p0
        public C0570b f49659h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @p0
        public d f49660i;

        public h(int i10, int i11) {
            this.f49652a = i10;
            this.f49653b = i11;
        }

        public void a() {
            this.f49654c.clear();
            this.f49655d.clear();
            this.f49656e.clear();
            this.f49657f.clear();
            this.f49658g.clear();
            this.f49659h = null;
            this.f49660i = null;
        }
    }

    public b(int i10, int i11) {
        Paint paint = new Paint();
        this.f49608a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f49609b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f49610c = new Canvas();
        this.f49611d = new C0570b(719, 575, 0, 719, 0, 575);
        this.f49612e = new a(0, c(), d(), e());
        this.f49613f = new h(i10, i11);
    }

    public static byte[] a(int i10, int i11, b0 b0Var) {
        byte[] bArr = new byte[i10];
        for (int i12 = 0; i12 < i10; i12++) {
            bArr[i12] = (byte) b0Var.h(i11);
        }
        return bArr;
    }

    public static int[] c() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    public static int[] d() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i10 = 1; i10 < 16; i10++) {
            if (i10 < 8) {
                iArr[i10] = f(255, (i10 & 1) != 0 ? 255 : 0, (i10 & 2) != 0 ? 255 : 0, (i10 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i10] = f(255, (i10 & 1) != 0 ? 127 : 0, (i10 & 2) != 0 ? 127 : 0, (i10 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    public static int[] e() {
        int i10;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i11 = 0; i11 < 256; i11++) {
            if (i11 < 8) {
                iArr[i11] = f(63, (i11 & 1) != 0 ? 255 : 0, (i11 & 2) != 0 ? 255 : 0, (i11 & 4) == 0 ? 0 : 255);
            } else {
                int i12 = i11 & 136;
                int i13 = DoubleMath.MAX_FACTORIAL;
                if (i12 == 0) {
                    int i14 = ((i11 & 1) != 0 ? 85 : 0) + ((i11 & 16) != 0 ? DoubleMath.MAX_FACTORIAL : 0);
                    int i15 = ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? DoubleMath.MAX_FACTORIAL : 0);
                    i10 = (i11 & 4) == 0 ? 0 : 85;
                    if ((i11 & 64) == 0) {
                        i13 = 0;
                    }
                    iArr[i11] = f(255, i14, i15, i10 + i13);
                } else if (i12 == 8) {
                    int i16 = ((i11 & 1) != 0 ? 85 : 0) + ((i11 & 16) != 0 ? DoubleMath.MAX_FACTORIAL : 0);
                    int i17 = ((i11 & 2) != 0 ? 85 : 0) + ((i11 & 32) != 0 ? DoubleMath.MAX_FACTORIAL : 0);
                    i10 = (i11 & 4) == 0 ? 0 : 85;
                    if ((i11 & 64) == 0) {
                        i13 = 0;
                    }
                    iArr[i11] = f(127, i16, i17, i10 + i13);
                } else if (i12 == 128) {
                    iArr[i11] = f(255, ((i11 & 1) != 0 ? 43 : 0) + 127 + ((i11 & 16) != 0 ? 85 : 0), ((i11 & 2) != 0 ? 43 : 0) + 127 + ((i11 & 32) != 0 ? 85 : 0), ((i11 & 4) == 0 ? 0 : 43) + 127 + ((i11 & 64) == 0 ? 0 : 85));
                } else if (i12 == 136) {
                    iArr[i11] = f(255, ((i11 & 1) != 0 ? 43 : 0) + ((i11 & 16) != 0 ? 85 : 0), ((i11 & 2) != 0 ? 43 : 0) + ((i11 & 32) != 0 ? 85 : 0), ((i11 & 4) == 0 ? 0 : 43) + ((i11 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    public static int f(int i10, int i11, int i12, int i13) {
        return (i10 << 24) | (i11 << 16) | (i12 << 8) | i13;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0063 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0083 A[LOOP:0: B:3:0x0009->B:33:0x0083, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int g(hd.b0 r13, int[] r14, @g.p0 byte[] r15, int r16, int r17, @g.p0 android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L9:
            r3 = 2
            int r4 = r13.h(r3)
            r5 = 1
            if (r4 == 0) goto L14
            r11 = r2
        L12:
            r12 = 1
            goto L61
        L14:
            boolean r4 = r13.g()
            r6 = 3
            if (r4 == 0) goto L28
            int r4 = r13.h(r6)
            int r4 = r4 + r6
            int r3 = r13.h(r3)
        L24:
            r11 = r2
            r12 = r4
            r4 = r3
            goto L61
        L28:
            boolean r4 = r13.g()
            if (r4 == 0) goto L31
            r11 = r2
            r4 = 0
            goto L12
        L31:
            int r4 = r13.h(r3)
            if (r4 == 0) goto L5e
            if (r4 == r5) goto L5a
            if (r4 == r3) goto L4e
            if (r4 == r6) goto L41
            r11 = r2
            r4 = 0
        L3f:
            r12 = 0
            goto L61
        L41:
            r4 = 8
            int r4 = r13.h(r4)
            int r4 = r4 + 29
            int r3 = r13.h(r3)
            goto L24
        L4e:
            r4 = 4
            int r4 = r13.h(r4)
            int r4 = r4 + 12
            int r3 = r13.h(r3)
            goto L24
        L5a:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L61
        L5e:
            r4 = 0
            r11 = 1
            goto L3f
        L61:
            if (r12 == 0) goto L7f
            if (r8 == 0) goto L7f
            if (r15 == 0) goto L69
            r4 = r15[r4]
        L69:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r6 = (float) r2
            int r2 = r1 + 1
            float r7 = (float) r2
            r2 = r19
            r5 = r6
            r6 = r7
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L7f:
            int r10 = r10 + r12
            if (r11 == 0) goto L83
            return r10
        L83:
            r2 = r11
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: sc.b.g(hd.b0, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008e A[LOOP:0: B:3:0x0009->B:36:0x008e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int h(hd.b0 r13, int[] r14, @g.p0 byte[] r15, int r16, int r17, @g.p0 android.graphics.Paint r18, android.graphics.Canvas r19) {
        /*
            r0 = r13
            r1 = r17
            r8 = r18
            r9 = 0
            r10 = r16
            r2 = 0
        L9:
            r3 = 4
            int r4 = r13.h(r3)
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L16
            r11 = r2
        L13:
            r12 = 1
            goto L6e
        L16:
            boolean r4 = r13.g()
            r7 = 3
            if (r4 != 0) goto L2c
            int r3 = r13.h(r7)
            if (r3 == 0) goto L29
            int r5 = r3 + 2
            r11 = r2
            r12 = r5
            r4 = 0
            goto L6e
        L29:
            r4 = 0
            r11 = 1
            goto L4d
        L2c:
            boolean r4 = r13.g()
            if (r4 != 0) goto L3f
            int r4 = r13.h(r5)
            int r5 = r4 + 4
            int r4 = r13.h(r3)
        L3c:
            r11 = r2
            r12 = r5
            goto L6e
        L3f:
            int r4 = r13.h(r5)
            if (r4 == 0) goto L6b
            if (r4 == r6) goto L67
            if (r4 == r5) goto L5c
            if (r4 == r7) goto L4f
            r11 = r2
            r4 = 0
        L4d:
            r12 = 0
            goto L6e
        L4f:
            r4 = 8
            int r4 = r13.h(r4)
            int r5 = r4 + 25
            int r4 = r13.h(r3)
            goto L3c
        L5c:
            int r4 = r13.h(r3)
            int r5 = r4 + 9
            int r4 = r13.h(r3)
            goto L3c
        L67:
            r11 = r2
            r4 = 0
            r12 = 2
            goto L6e
        L6b:
            r11 = r2
            r4 = 0
            goto L13
        L6e:
            if (r12 == 0) goto L8a
            if (r8 == 0) goto L8a
            if (r15 == 0) goto L76
            r4 = r15[r4]
        L76:
            r2 = r14[r4]
            r8.setColor(r2)
            float r3 = (float) r10
            float r4 = (float) r1
            int r2 = r10 + r12
            float r5 = (float) r2
            int r2 = r1 + 1
            float r6 = (float) r2
            r2 = r19
            r7 = r18
            r2.drawRect(r3, r4, r5, r6, r7)
        L8a:
            int r10 = r10 + r12
            if (r11 == 0) goto L8e
            return r10
        L8e:
            r2 = r11
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: sc.b.h(hd.b0, int[], byte[], int, int, android.graphics.Paint, android.graphics.Canvas):int");
    }

    public static int i(b0 b0Var, int[] iArr, @p0 byte[] bArr, int i10, int i11, @p0 Paint paint, Canvas canvas) {
        boolean z10;
        int iH;
        int i12 = i10;
        boolean z11 = false;
        while (true) {
            int iH2 = b0Var.h(8);
            if (iH2 != 0) {
                z10 = z11;
                iH = 1;
            } else if (b0Var.g()) {
                z10 = z11;
                iH = b0Var.h(7);
                iH2 = b0Var.h(8);
            } else {
                int iH3 = b0Var.h(7);
                if (iH3 != 0) {
                    z10 = z11;
                    iH = iH3;
                    iH2 = 0;
                } else {
                    iH2 = 0;
                    z10 = true;
                    iH = 0;
                }
            }
            if (iH != 0 && paint != null) {
                if (bArr != null) {
                    iH2 = bArr[iH2];
                }
                paint.setColor(iArr[iH2]);
                canvas.drawRect(i12, i11, i12 + iH, i11 + 1, paint);
            }
            i12 += iH;
            if (z10) {
                return i12;
            }
            z11 = z10;
        }
    }

    public static void j(byte[] bArr, int[] iArr, int i10, int i11, int i12, @p0 Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        b0 b0Var = new b0(bArr);
        int iG = i11;
        int i13 = i12;
        byte[] bArrA = null;
        byte[] bArrA2 = null;
        byte[] bArrA3 = null;
        while (b0Var.b() != 0) {
            int iH = b0Var.h(8);
            if (iH != 240) {
                switch (iH) {
                    case 16:
                        if (i10 == 3) {
                            bArr3 = bArrA == null ? A : bArrA;
                        } else if (i10 != 2) {
                            bArr2 = null;
                            iG = g(b0Var, iArr, bArr2, iG, i13, paint, canvas);
                            b0Var.c();
                        } else {
                            bArr3 = bArrA3 == null ? f49607z : bArrA3;
                        }
                        bArr2 = bArr3;
                        iG = g(b0Var, iArr, bArr2, iG, i13, paint, canvas);
                        b0Var.c();
                        break;
                    case 17:
                        iG = h(b0Var, iArr, i10 == 3 ? bArrA2 == null ? B : bArrA2 : null, iG, i13, paint, canvas);
                        b0Var.c();
                        break;
                    case 18:
                        iG = i(b0Var, iArr, null, iG, i13, paint, canvas);
                        break;
                    default:
                        switch (iH) {
                            case 32:
                                bArrA3 = a(4, 4, b0Var);
                                break;
                            case 33:
                                bArrA = a(4, 8, b0Var);
                                break;
                            case 34:
                                bArrA2 = a(16, 8, b0Var);
                                break;
                        }
                        break;
                }
            } else {
                i13 += 2;
                iG = i11;
            }
        }
    }

    public static void k(c cVar, a aVar, int i10, int i11, int i12, @p0 Paint paint, Canvas canvas) {
        int[] iArr = i10 == 3 ? aVar.f49618d : i10 == 2 ? aVar.f49617c : aVar.f49616b;
        j(cVar.f49627c, iArr, i10, i11, i12, paint, canvas);
        j(cVar.f49628d, iArr, i10, i11, i12 + 1, paint, canvas);
    }

    public static a l(b0 b0Var, int i10) {
        int iH;
        int i11;
        int iH2;
        int iH3;
        int iH4;
        int i12 = 8;
        int iH5 = b0Var.h(8);
        b0Var.s(8);
        int i13 = 2;
        int i14 = i10 - 2;
        int[] iArrC = c();
        int[] iArrD = d();
        int[] iArrE = e();
        while (i14 > 0) {
            int iH6 = b0Var.h(i12);
            int iH7 = b0Var.h(i12);
            int i15 = i14 - 2;
            int[] iArr = (iH7 & 128) != 0 ? iArrC : (iH7 & 64) != 0 ? iArrD : iArrE;
            if ((iH7 & 1) != 0) {
                iH3 = b0Var.h(i12);
                iH4 = b0Var.h(i12);
                iH = b0Var.h(i12);
                iH2 = b0Var.h(i12);
                i11 = i15 - 4;
            } else {
                int iH8 = b0Var.h(6) << i13;
                int iH9 = b0Var.h(4) << 4;
                iH = b0Var.h(4) << 4;
                i11 = i15 - 2;
                iH2 = b0Var.h(i13) << 6;
                iH3 = iH8;
                iH4 = iH9;
            }
            if (iH3 == 0) {
                iH4 = 0;
                iH = 0;
                iH2 = 255;
            }
            double d10 = iH3;
            double d11 = iH4 - 128;
            double d12 = iH - 128;
            iArr[iH6] = f((byte) (255 - (iH2 & 255)), u0.t((int) (d10 + (1.402d * d11)), 0, 255), u0.t((int) ((d10 - (0.34414d * d12)) - (d11 * 0.71414d)), 0, 255), u0.t((int) (d10 + (d12 * 1.772d)), 0, 255));
            i14 = i11;
            iH5 = iH5;
            i12 = 8;
            i13 = 2;
        }
        return new a(iH5, iArrC, iArrD, iArrE);
    }

    public static C0570b m(b0 b0Var) {
        int i10;
        int iH;
        int i11;
        int i12;
        b0Var.s(4);
        boolean zG = b0Var.g();
        b0Var.s(3);
        int iH2 = b0Var.h(16);
        int iH3 = b0Var.h(16);
        if (zG) {
            int iH4 = b0Var.h(16);
            int iH5 = b0Var.h(16);
            int iH6 = b0Var.h(16);
            iH = b0Var.h(16);
            i10 = iH5;
            i12 = iH6;
            i11 = iH4;
        } else {
            i10 = iH2;
            iH = iH3;
            i11 = 0;
            i12 = 0;
        }
        return new C0570b(iH2, iH3, i11, i10, i12, iH);
    }

    public static c n(b0 b0Var) {
        byte[] bArr;
        int iH = b0Var.h(16);
        b0Var.s(4);
        int iH2 = b0Var.h(2);
        boolean zG = b0Var.g();
        b0Var.s(1);
        byte[] bArr2 = u0.f31159f;
        if (iH2 != 1) {
            if (iH2 == 0) {
                int iH3 = b0Var.h(16);
                int iH4 = b0Var.h(16);
                if (iH3 > 0) {
                    bArr2 = new byte[iH3];
                    b0Var.k(bArr2, 0, iH3);
                }
                if (iH4 > 0) {
                    bArr = new byte[iH4];
                    b0Var.k(bArr, 0, iH4);
                }
            }
            return new c(iH, zG, bArr2, bArr);
        }
        b0Var.s(b0Var.h(8) * 16);
        bArr = bArr2;
        return new c(iH, zG, bArr2, bArr);
    }

    public static d o(b0 b0Var, int i10) {
        int iH = b0Var.h(8);
        int iH2 = b0Var.h(4);
        int iH3 = b0Var.h(2);
        b0Var.s(2);
        int i11 = i10 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i11 > 0) {
            int iH4 = b0Var.h(8);
            b0Var.s(8);
            i11 -= 6;
            sparseArray.put(iH4, new e(b0Var.h(16), b0Var.h(16)));
        }
        return new d(iH, iH2, iH3, sparseArray);
    }

    public static f p(b0 b0Var, int i10) {
        int iH;
        int iH2;
        int iH3 = b0Var.h(8);
        b0Var.s(4);
        boolean zG = b0Var.g();
        b0Var.s(3);
        int i11 = 16;
        int iH4 = b0Var.h(16);
        int iH5 = b0Var.h(16);
        int iH6 = b0Var.h(3);
        int iH7 = b0Var.h(3);
        int i12 = 2;
        b0Var.s(2);
        int iH8 = b0Var.h(8);
        int iH9 = b0Var.h(8);
        int iH10 = b0Var.h(4);
        int iH11 = b0Var.h(2);
        b0Var.s(2);
        int i13 = i10 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i13 > 0) {
            int iH12 = b0Var.h(i11);
            int iH13 = b0Var.h(i12);
            int iH14 = b0Var.h(i12);
            int iH15 = b0Var.h(12);
            int i14 = iH11;
            b0Var.s(4);
            int iH16 = b0Var.h(12);
            i13 -= 6;
            if (iH13 == 1 || iH13 == 2) {
                i13 -= 2;
                iH = b0Var.h(8);
                iH2 = b0Var.h(8);
            } else {
                iH = 0;
                iH2 = 0;
            }
            sparseArray.put(iH12, new g(iH13, iH14, iH15, iH16, iH, iH2));
            iH11 = i14;
            i12 = 2;
            i11 = 16;
        }
        return new f(iH3, zG, iH4, iH5, iH6, iH7, iH8, iH9, iH10, iH11, sparseArray);
    }

    public static void q(b0 b0Var, h hVar) {
        f fVar;
        int iH = b0Var.h(8);
        int iH2 = b0Var.h(16);
        int iH3 = b0Var.h(16);
        int iD = b0Var.d() + iH3;
        if (iH3 * 8 > b0Var.b()) {
            t.n(f49589h, "Data field length exceeds limit");
            b0Var.s(b0Var.b());
            return;
        }
        switch (iH) {
            case 16:
                if (iH2 == hVar.f49652a) {
                    d dVar = hVar.f49660i;
                    d dVarO = o(b0Var, iH3);
                    if (dVarO.f49631c != 0) {
                        hVar.f49660i = dVarO;
                        hVar.f49654c.clear();
                        hVar.f49655d.clear();
                        hVar.f49656e.clear();
                    } else if (dVar != null && dVar.f49630b != dVarO.f49630b) {
                        hVar.f49660i = dVarO;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.f49660i;
                if (iH2 == hVar.f49652a && dVar2 != null) {
                    f fVarP = p(b0Var, iH3);
                    if (dVar2.f49631c == 0 && (fVar = hVar.f49654c.get(fVarP.f49635a)) != null) {
                        fVarP.a(fVar);
                    }
                    hVar.f49654c.put(fVarP.f49635a, fVarP);
                }
                break;
            case 18:
                if (iH2 == hVar.f49652a) {
                    a aVarL = l(b0Var, iH3);
                    hVar.f49655d.put(aVarL.f49615a, aVarL);
                } else if (iH2 == hVar.f49653b) {
                    a aVarL2 = l(b0Var, iH3);
                    hVar.f49657f.put(aVarL2.f49615a, aVarL2);
                }
                break;
            case 19:
                if (iH2 == hVar.f49652a) {
                    c cVarN = n(b0Var);
                    hVar.f49656e.put(cVarN.f49625a, cVarN);
                } else if (iH2 == hVar.f49653b) {
                    c cVarN2 = n(b0Var);
                    hVar.f49658g.put(cVarN2.f49625a, cVarN2);
                }
                break;
            case 20:
                if (iH2 == hVar.f49652a) {
                    hVar.f49659h = m(b0Var);
                }
                break;
        }
        b0Var.t(iD - b0Var.d());
    }

    public List<qc.b> b(byte[] bArr, int i10) {
        int i11;
        SparseArray<g> sparseArray;
        b0 b0Var = new b0(bArr, i10);
        while (b0Var.b() >= 48 && b0Var.h(8) == 15) {
            q(b0Var, this.f49613f);
        }
        h hVar = this.f49613f;
        d dVar = hVar.f49660i;
        if (dVar == null) {
            return Collections.emptyList();
        }
        C0570b c0570b = hVar.f49659h;
        if (c0570b == null) {
            c0570b = this.f49611d;
        }
        Bitmap bitmap = this.f49614g;
        if (bitmap == null || c0570b.f49619a + 1 != bitmap.getWidth() || c0570b.f49620b + 1 != this.f49614g.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(c0570b.f49619a + 1, c0570b.f49620b + 1, Bitmap.Config.ARGB_8888);
            this.f49614g = bitmapCreateBitmap;
            this.f49610c.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray<e> sparseArray2 = dVar.f49632d;
        for (int i12 = 0; i12 < sparseArray2.size(); i12++) {
            this.f49610c.save();
            e eVarValueAt = sparseArray2.valueAt(i12);
            f fVar = this.f49613f.f49654c.get(sparseArray2.keyAt(i12));
            int i13 = eVarValueAt.f49633a + c0570b.f49621c;
            int i14 = eVarValueAt.f49634b + c0570b.f49623e;
            this.f49610c.clipRect(i13, i14, Math.min(fVar.f49637c + i13, c0570b.f49622d), Math.min(fVar.f49638d + i14, c0570b.f49624f));
            a aVar = this.f49613f.f49655d.get(fVar.f49641g);
            if (aVar == null && (aVar = this.f49613f.f49657f.get(fVar.f49641g)) == null) {
                aVar = this.f49612e;
            }
            SparseArray<g> sparseArray3 = fVar.f49645k;
            int i15 = 0;
            while (i15 < sparseArray3.size()) {
                int iKeyAt = sparseArray3.keyAt(i15);
                g gVarValueAt = sparseArray3.valueAt(i15);
                c cVar = this.f49613f.f49656e.get(iKeyAt);
                c cVar2 = cVar == null ? this.f49613f.f49658g.get(iKeyAt) : cVar;
                if (cVar2 != null) {
                    i11 = i15;
                    sparseArray = sparseArray3;
                    k(cVar2, aVar, fVar.f49640f, gVarValueAt.f49648c + i13, i14 + gVarValueAt.f49649d, cVar2.f49626b ? null : this.f49608a, this.f49610c);
                } else {
                    i11 = i15;
                    sparseArray = sparseArray3;
                }
                i15 = i11 + 1;
                sparseArray3 = sparseArray;
            }
            if (fVar.f49636b) {
                int i16 = fVar.f49640f;
                this.f49609b.setColor(i16 == 3 ? aVar.f49618d[fVar.f49642h] : i16 == 2 ? aVar.f49617c[fVar.f49643i] : aVar.f49616b[fVar.f49644j]);
                this.f49610c.drawRect(i13, i14, fVar.f49637c + i13, fVar.f49638d + i14, this.f49609b);
            }
            arrayList.add(new b.c().r(Bitmap.createBitmap(this.f49614g, i13, i14, fVar.f49637c, fVar.f49638d)).v(i13 / c0570b.f49619a).w(0).t(i14 / c0570b.f49620b, 0).u(0).y(fVar.f49637c / c0570b.f49619a).s(fVar.f49638d / c0570b.f49620b).a());
            this.f49610c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.f49610c.restore();
        }
        return Collections.unmodifiableList(arrayList);
    }

    public void r() {
        this.f49613f.a();
    }
}
