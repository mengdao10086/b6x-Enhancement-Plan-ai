package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import g.n0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes2.dex */
public final class DefaultImageHeaderParser implements ImageHeaderParser {
    public static final int A = 1635150182;
    public static final int B = 1635150195;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f12503b = "DfltImageHeaderParser";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f12504c = 4671814;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f12505d = -1991225785;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f12506e = 65496;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f12507f = 19789;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f12508g = 18761;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f12509h = "Exif\u0000\u0000";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f12511j = 218;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f12512k = 217;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f12513l = 255;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f12514m = 225;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f12515n = 274;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f12517p = 1380533830;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f12518q = 1464156752;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f12519r = 1448097792;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f12520s = -256;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final int f12521t = 255;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final int f12522u = 88;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final int f12523v = 76;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final int f12524w = 2;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f12525x = 16;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f12526y = 8;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final int f12527z = 1718909296;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final byte[] f12510i = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int[] f12516o = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public interface Reader {

        public static final class EndOfFileException extends IOException {
            private static final long serialVersionUID = 1;

            public EndOfFileException() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a() throws IOException;

        int b(byte[] bArr, int i10) throws IOException;

        short c() throws IOException;

        long skip(long j10) throws IOException;
    }

    public static final class a implements Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f12528a;

        public a(ByteBuffer byteBuffer) {
            this.f12528a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a() throws Reader.EndOfFileException {
            return (c() << 8) | c();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int b(byte[] bArr, int i10) {
            int iMin = Math.min(i10, this.f12528a.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.f12528a.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short c() throws Reader.EndOfFileException {
            if (this.f12528a.remaining() >= 1) {
                return (short) (this.f12528a.get() & 255);
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j10) {
            int iMin = (int) Math.min(this.f12528a.remaining(), j10);
            ByteBuffer byteBuffer = this.f12528a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f12529a;

        public b(byte[] bArr, int i10) {
            this.f12529a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i10);
        }

        public short a(int i10) {
            if (c(i10, 2)) {
                return this.f12529a.getShort(i10);
            }
            return (short) -1;
        }

        public int b(int i10) {
            if (c(i10, 4)) {
                return this.f12529a.getInt(i10);
            }
            return -1;
        }

        public final boolean c(int i10, int i11) {
            return this.f12529a.remaining() - i10 >= i11;
        }

        public int d() {
            return this.f12529a.remaining();
        }

        public void e(ByteOrder byteOrder) {
            this.f12529a.order(byteOrder);
        }
    }

    public static final class c implements Reader {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream f12530a;

        public c(InputStream inputStream) {
            this.f12530a = inputStream;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int a() throws IOException {
            return (c() << 8) | c();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public int b(byte[] bArr, int i10) throws IOException {
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10 && (i12 = this.f12530a.read(bArr, i11, i10 - i11)) != -1) {
                i11 += i12;
            }
            if (i11 == 0 && i12 == -1) {
                throw new Reader.EndOfFileException();
            }
            return i11;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public short c() throws IOException {
            int i10 = this.f12530a.read();
            if (i10 != -1) {
                return (short) i10;
            }
            throw new Reader.EndOfFileException();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser.Reader
        public long skip(long j10) throws IOException {
            if (j10 < 0) {
                return 0L;
            }
            long j11 = j10;
            while (j11 > 0) {
                long jSkip = this.f12530a.skip(j11);
                if (jSkip <= 0) {
                    if (this.f12530a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j11 -= jSkip;
            }
            return j10 - j11;
        }
    }

    public static int e(int i10, int i11) {
        return i10 + 2 + (i11 * 12);
    }

    public static boolean h(int i10) {
        return (i10 & 65496) == 65496 || i10 == 19789 || i10 == 18761;
    }

    public static int k(b bVar) {
        ByteOrder byteOrder;
        short sA = bVar.a(6);
        if (sA != 18761) {
            if (sA != 19789 && Log.isLoggable(f12503b, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unknown endianness = ");
                sb2.append((int) sA);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.e(byteOrder);
        int iB = bVar.b(10) + 6;
        short sA2 = bVar.a(iB);
        for (int i10 = 0; i10 < sA2; i10++) {
            int iE = e(iB, i10);
            short sA3 = bVar.a(iE);
            if (sA3 == 274) {
                short sA4 = bVar.a(iE + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = bVar.b(iE + 4);
                    if (iB2 >= 0) {
                        if (Log.isLoggable(f12503b, 3)) {
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
                        int i11 = iB2 + f12516o[sA4];
                        if (i11 <= 4) {
                            int i12 = iE + 8;
                            if (i12 >= 0 && i12 <= bVar.d()) {
                                if (i11 >= 0 && i11 + i12 <= bVar.d()) {
                                    return bVar.a(i12);
                                }
                                if (Log.isLoggable(f12503b, 3)) {
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("Illegal number of bytes for TI tag data tagType=");
                                    sb4.append((int) sA3);
                                }
                            } else if (Log.isLoggable(f12503b, 3)) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("Illegal tagValueOffset=");
                                sb5.append(i12);
                                sb5.append(" tagType=");
                                sb5.append((int) sA3);
                            }
                        } else if (Log.isLoggable(f12503b, 3)) {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("Got byte count > 4, not orientation, continuing, formatCode=");
                            sb6.append((int) sA4);
                        }
                    } else {
                        continue;
                    }
                } else if (Log.isLoggable(f12503b, 3)) {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append("Got invalid format code = ");
                    sb7.append((int) sA4);
                }
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @n0
    public ImageHeaderParser.ImageType a(@n0 ByteBuffer byteBuffer) throws IOException {
        return g(new a((ByteBuffer) v4.m.d(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int b(@n0 ByteBuffer byteBuffer, @n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        return f(new a((ByteBuffer) v4.m.d(byteBuffer)), (com.bumptech.glide.load.engine.bitmap_recycle.b) v4.m.d(bVar));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    @n0
    public ImageHeaderParser.ImageType c(@n0 InputStream inputStream) throws IOException {
        return g(new c((InputStream) v4.m.d(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int d(@n0 InputStream inputStream, @n0 com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        return f(new c((InputStream) v4.m.d(inputStream)), (com.bumptech.glide.load.engine.bitmap_recycle.b) v4.m.d(bVar));
    }

    public final int f(Reader reader, com.bumptech.glide.load.engine.bitmap_recycle.b bVar) throws IOException {
        try {
            int iA = reader.a();
            if (!h(iA)) {
                if (Log.isLoggable(f12503b, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Parser doesn't handle magic number: ");
                    sb2.append(iA);
                }
                return -1;
            }
            int iJ = j(reader);
            if (iJ == -1) {
                return -1;
            }
            byte[] bArr = (byte[]) bVar.f(iJ, byte[].class);
            try {
                return l(reader, bArr, iJ);
            } finally {
                bVar.put(bArr);
            }
        } catch (Reader.EndOfFileException unused) {
            return -1;
        }
    }

    @n0
    public final ImageHeaderParser.ImageType g(Reader reader) throws IOException {
        try {
            int iA = reader.a();
            if (iA == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int iC = (iA << 8) | reader.c();
            if (iC == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int iC2 = (iC << 8) | reader.c();
            if (iC2 == -1991225785) {
                reader.skip(21L);
                try {
                    return reader.c() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (Reader.EndOfFileException unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (iC2 != 1380533830) {
                return m(reader, iC2) ? ImageHeaderParser.ImageType.AVIF : ImageHeaderParser.ImageType.UNKNOWN;
            }
            reader.skip(4L);
            if (((reader.a() << 16) | reader.a()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int iA2 = (reader.a() << 16) | reader.a();
            if ((iA2 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i10 = iA2 & 255;
            if (i10 == 88) {
                reader.skip(4L);
                short sC = reader.c();
                return (sC & 2) != 0 ? ImageHeaderParser.ImageType.ANIMATED_WEBP : (sC & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            if (i10 != 76) {
                return ImageHeaderParser.ImageType.WEBP;
            }
            reader.skip(4L);
            return (reader.c() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        } catch (Reader.EndOfFileException unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    public final boolean i(byte[] bArr, int i10) {
        boolean z10 = bArr != null && i10 > f12510i.length;
        if (z10) {
            int i11 = 0;
            while (true) {
                byte[] bArr2 = f12510i;
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

    public final int j(Reader reader) throws IOException {
        short sC;
        int iA;
        long j10;
        long jSkip;
        do {
            short sC2 = reader.c();
            if (sC2 != 255) {
                if (Log.isLoggable(f12503b, 3)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unknown segmentId=");
                    sb2.append((int) sC2);
                }
                return -1;
            }
            sC = reader.c();
            if (sC == 218 || sC == 217) {
                return -1;
            }
            iA = reader.a() - 2;
            if (sC == 225) {
                return iA;
            }
            j10 = iA;
            jSkip = reader.skip(j10);
        } while (jSkip == j10);
        if (Log.isLoggable(f12503b, 3)) {
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

    public final int l(Reader reader, byte[] bArr, int i10) throws IOException {
        int iB = reader.b(bArr, i10);
        if (iB == i10) {
            if (i(bArr, i10)) {
                return k(new b(bArr, i10));
            }
            return -1;
        }
        if (Log.isLoggable(f12503b, 3)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unable to read exif segment data, length: ");
            sb2.append(i10);
            sb2.append(", actually read: ");
            sb2.append(iB);
        }
        return -1;
    }

    public final boolean m(Reader reader, int i10) throws IOException {
        if (((reader.a() << 16) | reader.a()) != 1718909296) {
            return false;
        }
        int iA = (reader.a() << 16) | reader.a();
        if (iA == 1635150182 || iA == 1635150195) {
            return true;
        }
        reader.skip(4L);
        int i11 = i10 - 16;
        if (i11 % 4 != 0) {
            return false;
        }
        int i12 = 0;
        while (i12 < 5 && i11 > 0) {
            int iA2 = (reader.a() << 16) | reader.a();
            if (iA2 == 1635150182 || iA2 == 1635150195) {
                return true;
            }
            i12++;
            i11 -= 4;
        }
        return false;
    }
}
