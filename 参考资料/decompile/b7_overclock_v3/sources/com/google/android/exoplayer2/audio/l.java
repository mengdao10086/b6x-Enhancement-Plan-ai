package com.google.android.exoplayer2.audio;

import ab.a0;
import com.google.android.exoplayer2.audio.AudioProcessor;
import g.p0;
import hd.t;
import hd.u0;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes3.dex */
public final class l extends c {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f16934i;

    public interface a {
        void a(ByteBuffer byteBuffer);

        void b(int i10, int i11, int i12);
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f16935j = "WaveFileAudioBufferSink";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final int f16936k = 4;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final int f16937l = 40;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final int f16938m = 44;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f16939a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f16940b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ByteBuffer f16941c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f16942d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f16943e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f16944f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @p0
        public RandomAccessFile f16945g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f16946h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f16947i;

        public b(String str) {
            this.f16939a = str;
            byte[] bArr = new byte[1024];
            this.f16940b = bArr;
            this.f16941c = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        }

        @Override // com.google.android.exoplayer2.audio.l.a
        public void a(ByteBuffer byteBuffer) {
            try {
                d();
                f(byteBuffer);
            } catch (IOException e10) {
                t.e(f16935j, "Error writing data", e10);
            }
        }

        @Override // com.google.android.exoplayer2.audio.l.a
        public void b(int i10, int i11, int i12) {
            try {
                e();
            } catch (IOException e10) {
                t.e(f16935j, "Error resetting", e10);
            }
            this.f16942d = i10;
            this.f16943e = i11;
            this.f16944f = i12;
        }

        public final String c() {
            int i10 = this.f16946h;
            this.f16946h = i10 + 1;
            return u0.I("%s-%04d.wav", this.f16939a, Integer.valueOf(i10));
        }

        public final void d() throws IOException {
            if (this.f16945g != null) {
                return;
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(c(), "rw");
            g(randomAccessFile);
            this.f16945g = randomAccessFile;
            this.f16947i = 44;
        }

        public final void e() throws IOException {
            RandomAccessFile randomAccessFile = this.f16945g;
            if (randomAccessFile == null) {
                return;
            }
            try {
                this.f16941c.clear();
                this.f16941c.putInt(this.f16947i - 8);
                randomAccessFile.seek(4L);
                randomAccessFile.write(this.f16940b, 0, 4);
                this.f16941c.clear();
                this.f16941c.putInt(this.f16947i - 44);
                randomAccessFile.seek(40L);
                randomAccessFile.write(this.f16940b, 0, 4);
            } catch (IOException e10) {
                t.o(f16935j, "Error updating file size", e10);
            }
            try {
                randomAccessFile.close();
            } finally {
                this.f16945g = null;
            }
        }

        public final void f(ByteBuffer byteBuffer) throws IOException {
            RandomAccessFile randomAccessFile = (RandomAccessFile) hd.a.g(this.f16945g);
            while (byteBuffer.hasRemaining()) {
                int iMin = Math.min(byteBuffer.remaining(), this.f16940b.length);
                byteBuffer.get(this.f16940b, 0, iMin);
                randomAccessFile.write(this.f16940b, 0, iMin);
                this.f16947i += iMin;
            }
        }

        public final void g(RandomAccessFile randomAccessFile) throws IOException {
            randomAccessFile.writeInt(1380533830);
            randomAccessFile.writeInt(-1);
            randomAccessFile.writeInt(a0.f373b);
            randomAccessFile.writeInt(a0.f374c);
            this.f16941c.clear();
            this.f16941c.putInt(16);
            this.f16941c.putShort((short) a0.b(this.f16944f));
            this.f16941c.putShort((short) this.f16943e);
            this.f16941c.putInt(this.f16942d);
            int iM0 = u0.m0(this.f16944f, this.f16943e);
            this.f16941c.putInt(this.f16942d * iM0);
            this.f16941c.putShort((short) iM0);
            this.f16941c.putShort((short) ((iM0 * 8) / this.f16943e));
            randomAccessFile.write(this.f16940b, 0, this.f16941c.position());
            randomAccessFile.writeInt(1684108385);
            randomAccessFile.writeInt(-1);
        }
    }

    public l(a aVar) {
        this.f16934i = (a) hd.a.g(aVar);
    }

    @Override // com.google.android.exoplayer2.audio.AudioProcessor
    public void d(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining == 0) {
            return;
        }
        this.f16934i.a(byteBuffer.asReadOnlyBuffer());
        k(iRemaining).put(byteBuffer).flip();
    }

    @Override // com.google.android.exoplayer2.audio.c
    public AudioProcessor.a g(AudioProcessor.a aVar) {
        return aVar;
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void h() {
        l();
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void i() {
        l();
    }

    @Override // com.google.android.exoplayer2.audio.c
    public void j() {
        l();
    }

    public final void l() {
        if (isActive()) {
            a aVar = this.f16934i;
            AudioProcessor.a aVar2 = this.f16862b;
            aVar.b(aVar2.f16754a, aVar2.f16755b, aVar2.f16756c);
        }
    }
}
