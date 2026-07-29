package hd;

import android.os.SystemClock;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.ConcurrentModificationException;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31049a = "time.android.com";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f31050b = 10000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f31051c = 24;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f31052d = 32;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f31053e = 40;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f31054f = 48;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f31055g = 123;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f31056h = 3;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f31057i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f31058j = 5;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f31059k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f31060l = 3;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f31061m = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f31062n = 15;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final long f31063o = 2208988800L;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final Object f31064p = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Object f31065q = new Object();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @g.b0("valueLock")
    public static boolean f31066r = false;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @g.b0("valueLock")
    public static long f31067s = 0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @g.b0("valueLock")
    public static String f31068t = "time.android.com";

    public interface b {
        void a(IOException iOException);

        void b();
    }

    public static final class c implements Loader.b<Loader.e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.p0
        public final b f31069a;

        public c(@g.p0 b bVar) {
            this.f31069a = bVar;
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        public void i(Loader.e eVar, long j10, long j11, boolean z10) {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        public void l(Loader.e eVar, long j10, long j11) {
            if (this.f31069a != null) {
                if (k0.k()) {
                    this.f31069a.b();
                } else {
                    this.f31069a.a(new IOException(new ConcurrentModificationException()));
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.b
        public Loader.c t(Loader.e eVar, long j10, long j11, IOException iOException, int i10) {
            b bVar = this.f31069a;
            if (bVar != null) {
                bVar.a(iOException);
            }
            return Loader.f19041j;
        }
    }

    public static final class d implements Loader.e {
        public d() {
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void b() throws IOException {
            synchronized (k0.f31064p) {
                synchronized (k0.f31065q) {
                    if (k0.f31066r) {
                        return;
                    }
                    long jL = k0.l();
                    synchronized (k0.f31065q) {
                        long unused = k0.f31067s = jL;
                        boolean unused2 = k0.f31066r = true;
                    }
                }
            }
        }

        @Override // com.google.android.exoplayer2.upstream.Loader.e
        public void c() {
        }
    }

    public static void g(byte b10, byte b11, int i10, long j10) throws IOException {
        if (b10 == 3) {
            throw new IOException("SNTP: Unsynchronized server");
        }
        if (b11 != 4 && b11 != 5) {
            throw new IOException("SNTP: Untrusted mode: " + ((int) b11));
        }
        if (i10 != 0 && i10 <= 15) {
            if (j10 == 0) {
                throw new IOException("SNTP: Zero transmitTime");
            }
        } else {
            throw new IOException("SNTP: Untrusted stratum: " + i10);
        }
    }

    public static long h() {
        long j10;
        synchronized (f31065q) {
            j10 = f31066r ? f31067s : ya.g.f56663b;
        }
        return j10;
    }

    public static String i() {
        String str;
        synchronized (f31065q) {
            str = f31068t;
        }
        return str;
    }

    public static void j(@g.p0 Loader loader, @g.p0 b bVar) {
        if (k()) {
            if (bVar != null) {
                bVar.b();
            }
        } else {
            if (loader == null) {
                loader = new Loader("SntpClient");
            }
            loader.n(new d(), new c(bVar), 1);
        }
    }

    public static boolean k() {
        boolean z10;
        synchronized (f31065q) {
            z10 = f31066r;
        }
        return z10;
    }

    public static long l() throws IOException {
        InetAddress byName = InetAddress.getByName(i());
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(10000);
            byte[] bArr = new byte[48];
            DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, byName, 123);
            bArr[0] = 27;
            long jCurrentTimeMillis = System.currentTimeMillis();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            p(bArr, 40, jCurrentTimeMillis);
            datagramSocket.send(datagramPacket);
            datagramSocket.receive(new DatagramPacket(bArr, 48));
            long jElapsedRealtime2 = SystemClock.elapsedRealtime();
            long j10 = jCurrentTimeMillis + (jElapsedRealtime2 - jElapsedRealtime);
            byte b10 = (byte) ((bArr[0] >> 6) & 3);
            byte b11 = (byte) (bArr[0] & 7);
            int i10 = bArr[1] & 255;
            long jN = n(bArr, 24);
            long jN2 = n(bArr, 32);
            long jN3 = n(bArr, 40);
            g(b10, b11, i10, jN3);
            long j11 = (j10 + (((jN2 - jN) + (jN3 - j10)) / 2)) - jElapsedRealtime2;
            datagramSocket.close();
            return j11;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                try {
                    datagramSocket.close();
                } catch (Throwable th4) {
                    th2.addSuppressed(th4);
                }
                throw th3;
            }
        }
    }

    public static long m(byte[] bArr, int i10) {
        int i11 = bArr[i10];
        int i12 = bArr[i10 + 1];
        int i13 = bArr[i10 + 2];
        int i14 = bArr[i10 + 3];
        if ((i11 & 128) == 128) {
            i11 = (i11 & 127) + 128;
        }
        if ((i12 & 128) == 128) {
            i12 = (i12 & 127) + 128;
        }
        if ((i13 & 128) == 128) {
            i13 = (i13 & 127) + 128;
        }
        if ((i14 & 128) == 128) {
            i14 = (i14 & 127) + 128;
        }
        return (((long) i11) << 24) + (((long) i12) << 16) + (((long) i13) << 8) + ((long) i14);
    }

    public static long n(byte[] bArr, int i10) {
        long jM = m(bArr, i10);
        long jM2 = m(bArr, i10 + 4);
        if (jM == 0 && jM2 == 0) {
            return 0L;
        }
        return ((jM - f31063o) * 1000) + ((jM2 * 1000) / 4294967296L);
    }

    public static void o(String str) {
        synchronized (f31065q) {
            if (!f31068t.equals(str)) {
                f31068t = str;
                f31066r = false;
            }
        }
    }

    public static void p(byte[] bArr, int i10, long j10) {
        if (j10 == 0) {
            Arrays.fill(bArr, i10, i10 + 8, (byte) 0);
            return;
        }
        long j11 = j10 / 1000;
        long j12 = j10 - (j11 * 1000);
        long j13 = j11 + f31063o;
        int i11 = i10 + 1;
        bArr[i10] = (byte) (j13 >> 24);
        int i12 = i11 + 1;
        bArr[i11] = (byte) (j13 >> 16);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (j13 >> 8);
        int i14 = i13 + 1;
        bArr[i13] = (byte) (j13 >> 0);
        long j14 = (j12 * 4294967296L) / 1000;
        int i15 = i14 + 1;
        bArr[i14] = (byte) (j14 >> 24);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (j14 >> 16);
        bArr[i16] = (byte) (j14 >> 8);
        bArr[i16 + 1] = (byte) (Math.random() * 255.0d);
    }
}
