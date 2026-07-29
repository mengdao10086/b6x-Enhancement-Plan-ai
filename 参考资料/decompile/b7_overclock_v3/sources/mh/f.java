package mh;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import g.v0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f41224b = "ImageHeaderParser";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f41225c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f41226d = 65496;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f41227e = 19789;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f41228f = 18761;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f41229g = "Exif\u0000\u0000";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f41231i = 218;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f41232j = 217;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f41233k = 255;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f41234l = 225;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f41235m = 274;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f41237a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final byte[] f41230h = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int[] f41236n = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f41238a;

        public a(byte[] bArr, int i10) {
            this.f41238a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i10);
        }

        public short a(int i10) {
            return this.f41238a.getShort(i10);
        }

        public int b(int i10) {
            return this.f41238a.getInt(i10);
        }

        public int c() {
            return this.f41238a.remaining();
        }

        public void d(ByteOrder byteOrder) {
            this.f41238a.order(byteOrder);
        }
    }

    public interface b {
        int a() throws IOException;

        int b(byte[] bArr, int i10) throws IOException;

        short c() throws IOException;

        long skip(long j10) throws IOException;
    }

    public static class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream f41239a;

        public c(InputStream inputStream) {
            this.f41239a = inputStream;
        }

        @Override // mh.f.b
        public int a() throws IOException {
            return ((this.f41239a.read() << 8) & 65280) | (this.f41239a.read() & 255);
        }

        @Override // mh.f.b
        public int b(byte[] bArr, int i10) throws IOException {
            int i11 = i10;
            while (i11 > 0) {
                int i12 = this.f41239a.read(bArr, i10 - i11, i11);
                if (i12 == -1) {
                    break;
                }
                i11 -= i12;
            }
            return i10 - i11;
        }

        @Override // mh.f.b
        public short c() throws IOException {
            return (short) (this.f41239a.read() & 255);
        }

        @Override // mh.f.b
        public long skip(long j10) throws IOException {
            if (j10 < 0) {
                return 0L;
            }
            long j11 = j10;
            while (j11 > 0) {
                long jSkip = this.f41239a.skip(j11);
                if (jSkip <= 0) {
                    if (this.f41239a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j11 -= jSkip;
            }
            return j10 - j11;
        }
    }

    public f(InputStream inputStream) {
        this.f41237a = new c(inputStream);
    }

    public static int a(int i10, int i11) {
        return i10 + 2 + (i11 * 12);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0067 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0056 -> B:46:0x0059). Please report as a decompilation issue!!! */
    @g.v0(21)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void b(android.content.Context r3, int r4, int r5, android.net.Uri r6, android.net.Uri r7) throws java.lang.Throwable {
        /*
            if (r3 != 0) goto L3
            return
        L3:
            r0 = 0
            android.content.ContentResolver r1 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L40
            java.io.InputStream r6 = r1.openInputStream(r6)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L40
            i1.a r1 = new i1.a     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L39
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L39
            android.content.ContentResolver r3 = r3.getContentResolver()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L39
            java.lang.String r2 = "rw"
            android.os.ParcelFileDescriptor r0 = r3.openFileDescriptor(r7, r2)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L39
            i1.a r3 = new i1.a     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L39
            java.io.FileDescriptor r7 = r0.getFileDescriptor()     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L39
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L39
            f(r1, r3, r4, r5)     // Catch: java.lang.Throwable -> L35 java.io.IOException -> L39
            if (r6 == 0) goto L31
            r6.close()     // Catch: java.io.IOException -> L2d
            goto L31
        L2d:
            r3 = move-exception
            r3.getMessage()
        L31:
            r0.close()     // Catch: java.io.IOException -> L55
            goto L59
        L35:
            r3 = move-exception
            r4 = r0
            r0 = r6
            goto L5b
        L39:
            r3 = move-exception
            r4 = r0
            r0 = r6
            goto L42
        L3d:
            r3 = move-exception
            r4 = r0
            goto L5b
        L40:
            r3 = move-exception
            r4 = r0
        L42:
            r3.getMessage()     // Catch: java.lang.Throwable -> L5a
            if (r0 == 0) goto L4f
            r0.close()     // Catch: java.io.IOException -> L4b
            goto L4f
        L4b:
            r3 = move-exception
            r3.getMessage()
        L4f:
            if (r4 == 0) goto L59
            r4.close()     // Catch: java.io.IOException -> L55
            goto L59
        L55:
            r3 = move-exception
            r3.getMessage()
        L59:
            return
        L5a:
            r3 = move-exception
        L5b:
            if (r0 == 0) goto L65
            r0.close()     // Catch: java.io.IOException -> L61
            goto L65
        L61:
            r5 = move-exception
            r5.getMessage()
        L65:
            if (r4 == 0) goto L6f
            r4.close()     // Catch: java.io.IOException -> L6b
            goto L6f
        L6b:
            r4 = move-exception
            r4.getMessage()
        L6f:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: mh.f.b(android.content.Context, int, int, android.net.Uri, android.net.Uri):void");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x002c -> B:29:0x002f). Please report as a decompilation issue!!! */
    public static void c(Context context, int i10, int i11, Uri uri, String str) {
        if (context == null) {
            return;
        }
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                try {
                    inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                    f(new i1.a(inputStreamOpenInputStream), new i1.a(str), i10, i11);
                    if (inputStreamOpenInputStream != null) {
                        inputStreamOpenInputStream.close();
                    }
                } catch (IOException e10) {
                    e10.getMessage();
                    if (inputStreamOpenInputStream == null) {
                    } else {
                        inputStreamOpenInputStream.close();
                    }
                }
            } catch (IOException e11) {
                e11.getMessage();
            }
        } catch (Throwable th2) {
            if (inputStreamOpenInputStream != null) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e12) {
                    e12.getMessage();
                }
            }
            throw th2;
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002b -> B:24:0x002e). Please report as a decompilation issue!!! */
    @v0(21)
    public static void d(Context context, i1.a aVar, int i10, int i11, Uri uri) {
        if (context == null) {
            return;
        }
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = null;
        try {
            try {
                try {
                    parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "rw");
                    f(aVar, new i1.a(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()), i10, i11);
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (IOException e10) {
                    e10.getMessage();
                }
            } catch (IOException e11) {
                e11.getMessage();
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                } else {
                    parcelFileDescriptorOpenFileDescriptor.close();
                }
            }
        } catch (Throwable th2) {
            if (parcelFileDescriptorOpenFileDescriptor != null) {
                try {
                    parcelFileDescriptorOpenFileDescriptor.close();
                } catch (IOException e12) {
                    e12.getMessage();
                }
            }
            throw th2;
        }
    }

    public static void e(i1.a aVar, int i10, int i11, String str) throws Throwable {
        try {
            f(aVar, new i1.a(str), i10, i11);
        } catch (IOException e10) {
            e10.getMessage();
        }
    }

    public static void f(i1.a aVar, i1.a aVar2, int i10, int i11) throws Throwable {
        String[] strArr = {i1.a.f31716v0, i1.a.U, i1.a.f31652n0, i1.a.f31708u0, i1.a.P0, i1.a.R0, i1.a.D1, i1.a.C1, i1.a.f31550a2, i1.a.f31753z1, i1.a.f31744y1, i1.a.B1, i1.a.A1, i1.a.Y1, i1.a.E1, i1.a.f31752z0, i1.a.W, i1.a.X, i1.a.f31684r0, i1.a.f31700t0, i1.a.f31692s0, i1.a.f31589f1};
        for (int i12 = 0; i12 < 22; i12++) {
            String str = strArr[i12];
            String strI = aVar.i(str);
            if (!TextUtils.isEmpty(strI)) {
                aVar2.v0(str, strI);
            }
        }
        aVar2.v0(i1.a.f31733x, String.valueOf(i10));
        aVar2.v0(i1.a.f31742y, String.valueOf(i11));
        aVar2.v0(i1.a.C, "0");
        aVar2.q0();
    }

    public static boolean h(int i10) {
        return (i10 & 65496) == 65496 || i10 == 19789 || i10 == 18761;
    }

    public static int k(a aVar) {
        ByteOrder byteOrder;
        short sA = aVar.a(6);
        if (sA == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (sA == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable(f41224b, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unknown endianness = ");
                sb2.append((int) sA);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        aVar.d(byteOrder);
        int iB = aVar.b(10) + 6;
        short sA2 = aVar.a(iB);
        for (int i10 = 0; i10 < sA2; i10++) {
            int iA = a(iB, i10);
            short sA3 = aVar.a(iA);
            if (sA3 == 274) {
                short sA4 = aVar.a(iA + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = aVar.b(iA + 4);
                    if (iB2 >= 0) {
                        if (Log.isLoggable(f41224b, 3)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("Got tagIndex=");
                            sb3.append(i10);
                            sb3.append(" tagType=");
                            sb3.append((int) sA3);
                            sb3.append(" formatCode=");
                            sb3.append((int) sA4);
                            sb3.append(" componentCount=");
                            sb3.append(iB2);
                        }
                        int i11 = iB2 + f41236n[sA4];
                        if (i11 <= 4) {
                            int i12 = iA + 8;
                            if (i12 >= 0 && i12 <= aVar.c()) {
                                if (i11 >= 0 && i11 + i12 <= aVar.c()) {
                                    return aVar.a(i12);
                                }
                                if (Log.isLoggable(f41224b, 3)) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("Illegal number of bytes for TI tag data tagType=");
                                    sb4.append((int) sA3);
                                }
                            } else if (Log.isLoggable(f41224b, 3)) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("Illegal tagValueOffset=");
                                sb5.append(i12);
                                sb5.append(" tagType=");
                                sb5.append((int) sA3);
                            }
                        } else if (Log.isLoggable(f41224b, 3)) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("Got byte count > 4, not orientation, continuing, formatCode=");
                            sb6.append((int) sA4);
                        }
                    } else {
                        continue;
                    }
                } else if (Log.isLoggable(f41224b, 3)) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("Got invalid format code = ");
                    sb7.append((int) sA4);
                }
            }
        }
        return -1;
    }

    public int g() throws IOException {
        int iA = this.f41237a.a();
        if (h(iA)) {
            int iJ = j();
            if (iJ == -1) {
                return -1;
            }
            return l(new byte[iJ], iJ);
        }
        if (Log.isLoggable(f41224b, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Parser doesn't handle magic number: ");
            sb2.append(iA);
        }
        return -1;
    }

    public final boolean i(byte[] bArr, int i10) {
        boolean z10 = bArr != null && i10 > f41230h.length;
        if (z10) {
            int i11 = 0;
            while (true) {
                byte[] bArr2 = f41230h;
                if (i11 >= bArr2.length) {
                    break;
                }
                if (bArr[i11] != bArr2[i11]) {
                    return false;
                }
                i11++;
            }
        }
        return z10;
    }

    public final int j() throws IOException {
        short sC;
        int iA;
        long j10;
        long jSkip;
        do {
            short sC2 = this.f41237a.c();
            if (sC2 != 255) {
                if (Log.isLoggable(f41224b, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unknown segmentId=");
                    sb2.append((int) sC2);
                }
                return -1;
            }
            sC = this.f41237a.c();
            if (sC == 218 || sC == 217) {
                return -1;
            }
            iA = this.f41237a.a() - 2;
            if (sC == 225) {
                return iA;
            }
            j10 = iA;
            jSkip = this.f41237a.skip(j10);
        } while (jSkip == j10);
        if (Log.isLoggable(f41224b, 3)) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to skip enough data, type: ");
            sb3.append((int) sC);
            sb3.append(", wanted to skip: ");
            sb3.append(iA);
            sb3.append(", but actually skipped: ");
            sb3.append(jSkip);
        }
        return -1;
    }

    public final int l(byte[] bArr, int i10) throws IOException {
        int iB = this.f41237a.b(bArr, i10);
        if (iB == i10) {
            if (i(bArr, i10)) {
                return k(new a(bArr, i10));
            }
            return -1;
        }
        if (Log.isLoggable(f41224b, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to read exif segment data, length: ");
            sb2.append(i10);
            sb2.append(", actually read: ");
            sb2.append(iB);
        }
        return -1;
    }
}
