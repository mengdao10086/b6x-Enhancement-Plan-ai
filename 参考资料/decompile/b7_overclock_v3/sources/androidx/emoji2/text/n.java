package androidx.emoji2.text;

import android.content.res.AssetManager;
import androidx.annotation.RestrictTo;
import g.f0;
import g.n0;
import g.v0;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.v1;

/* JADX INFO: loaded from: classes2.dex */
@g.d
@RestrictTo({RestrictTo.Scope.LIBRARY})
@v0(19)
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5565a = 1164798569;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f5566b = 1701669481;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5567c = 1835365473;

    public static class a implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @n0
        public final ByteBuffer f5568c;

        public a(@n0 ByteBuffer byteBuffer) {
            this.f5568c = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // androidx.emoji2.text.n.d
        public void b(int i10) throws IOException {
            ByteBuffer byteBuffer = this.f5568c;
            byteBuffer.position(byteBuffer.position() + i10);
        }

        @Override // androidx.emoji2.text.n.d
        public int c() throws IOException {
            return this.f5568c.getInt();
        }

        @Override // androidx.emoji2.text.n.d
        public long d() throws IOException {
            return n.e(this.f5568c.getInt());
        }

        @Override // androidx.emoji2.text.n.d
        public long getPosition() {
            return this.f5568c.position();
        }

        @Override // androidx.emoji2.text.n.d
        public int readUnsignedShort() throws IOException {
            return n.f(this.f5568c.getShort());
        }
    }

    public static class b implements d {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @n0
        public final byte[] f5569c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @n0
        public final ByteBuffer f5570d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @n0
        public final InputStream f5571e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f5572f = 0;

        public b(@n0 InputStream inputStream) {
            this.f5571e = inputStream;
            byte[] bArr = new byte[4];
            this.f5569c = bArr;
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            this.f5570d = byteBufferWrap;
            byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        }

        public final void a(@f0(from = 0, to = 4) int i10) throws IOException {
            if (this.f5571e.read(this.f5569c, 0, i10) != i10) {
                throw new IOException("read failed");
            }
            this.f5572f += (long) i10;
        }

        @Override // androidx.emoji2.text.n.d
        public void b(int i10) throws IOException {
            while (i10 > 0) {
                int iSkip = (int) this.f5571e.skip(i10);
                if (iSkip < 1) {
                    throw new IOException("Skip didn't move at least 1 byte forward");
                }
                i10 -= iSkip;
                this.f5572f += (long) iSkip;
            }
        }

        @Override // androidx.emoji2.text.n.d
        public int c() throws IOException {
            this.f5570d.position(0);
            a(4);
            return this.f5570d.getInt();
        }

        @Override // androidx.emoji2.text.n.d
        public long d() throws IOException {
            this.f5570d.position(0);
            a(4);
            return n.e(this.f5570d.getInt());
        }

        @Override // androidx.emoji2.text.n.d
        public long getPosition() {
            return this.f5572f;
        }

        @Override // androidx.emoji2.text.n.d
        public int readUnsignedShort() throws IOException {
            this.f5570d.position(0);
            a(2);
            return n.f(this.f5570d.getShort());
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f5573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f5574b;

        public c(long j10, long j11) {
            this.f5573a = j10;
            this.f5574b = j11;
        }

        public long a() {
            return this.f5574b;
        }

        public long b() {
            return this.f5573a;
        }
    }

    public interface d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f5575a = 2;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f5576b = 4;

        void b(int i10) throws IOException;

        int c() throws IOException;

        long d() throws IOException;

        long getPosition();

        int readUnsignedShort() throws IOException;
    }

    public static c a(d dVar) throws IOException {
        long jD;
        dVar.b(4);
        int unsignedShort = dVar.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        dVar.b(6);
        int i10 = 0;
        while (true) {
            if (i10 >= unsignedShort) {
                jD = -1;
                break;
            }
            int iC = dVar.c();
            dVar.b(4);
            jD = dVar.d();
            dVar.b(4);
            if (1835365473 == iC) {
                break;
            }
            i10++;
        }
        if (jD != -1) {
            dVar.b((int) (jD - dVar.getPosition()));
            dVar.b(12);
            long jD2 = dVar.d();
            for (int i11 = 0; i11 < jD2; i11++) {
                int iC2 = dVar.c();
                long jD3 = dVar.d();
                long jD4 = dVar.d();
                if (1164798569 == iC2 || 1701669481 == iC2) {
                    return new c(jD3 + jD, jD4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static androidx.emoji2.text.flatbuffer.o b(AssetManager assetManager, String str) throws IOException {
        InputStream inputStreamOpen = assetManager.open(str);
        try {
            androidx.emoji2.text.flatbuffer.o oVarC = c(inputStreamOpen);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            return oVarC;
        } catch (Throwable th2) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    public static androidx.emoji2.text.flatbuffer.o c(InputStream inputStream) throws IOException {
        b bVar = new b(inputStream);
        c cVarA = a(bVar);
        bVar.b((int) (cVarA.b() - bVar.getPosition()));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) cVarA.a());
        int i10 = inputStream.read(byteBufferAllocate.array());
        if (i10 == cVarA.a()) {
            return androidx.emoji2.text.flatbuffer.o.G(byteBufferAllocate);
        }
        throw new IOException("Needed " + cVarA.a() + " bytes, got " + i10);
    }

    public static androidx.emoji2.text.flatbuffer.o d(ByteBuffer byteBuffer) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) a(new a(byteBufferDuplicate)).b());
        return androidx.emoji2.text.flatbuffer.o.G(byteBufferDuplicate);
    }

    public static long e(int i10) {
        return ((long) i10) & 4294967295L;
    }

    public static int f(short s10) {
        return s10 & v1.f38215d;
    }
}
