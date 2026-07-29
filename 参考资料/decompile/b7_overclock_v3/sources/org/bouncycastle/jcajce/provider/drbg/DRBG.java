package org.bouncycastle.jcajce.provider.drbg;

import ar.f;
import ip.k;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.security.Security;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.bouncycastle.crypto.prng.SP800SecureRandom;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.o;
import org.bouncycastle.util.p;
import pp.e;
import pp.i;
import zo.h0;

/* JADX INFO: loaded from: classes7.dex */
public class DRBG {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f45117a = "org.bouncycastle.jcajce.provider.drbg.DRBG";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[][] f45118b = {new String[]{"sun.security.provider.Sun", "sun.security.provider.SecureRandom"}, new String[]{"org.apache.harmony.security.provider.crypto.CryptoProvider", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl"}, new String[]{"com.android.org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLRandom"}, new String[]{"org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLRandom"}};

    public static class CoreSecureRandom extends SecureRandom {
        public CoreSecureRandom(Object[] objArr) {
            super((SecureRandomSpi) objArr[1], (Provider) objArr[0]);
        }
    }

    public static class Default extends SecureRandomSpi {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SecureRandom f45119a = DRBG.e(true);

        @Override // java.security.SecureRandomSpi
        public byte[] engineGenerateSeed(int i10) {
            return f45119a.generateSeed(i10);
        }

        @Override // java.security.SecureRandomSpi
        public void engineNextBytes(byte[] bArr) {
            f45119a.nextBytes(bArr);
        }

        @Override // java.security.SecureRandomSpi
        public void engineSetSeed(byte[] bArr) {
            f45119a.setSeed(bArr);
        }
    }

    public static class HybridRandomProvider extends Provider {
        public HybridRandomProvider() {
            super("BCHEP", 1.0d, "Bouncy Castle Hybrid Entropy Provider");
        }
    }

    public static class HybridSecureRandom extends SecureRandom {
        private final SecureRandom baseRandom;
        private final SP800SecureRandom drbg;
        private final AtomicInteger samples;
        private final AtomicBoolean seedAvailable;

        public class a implements e {
            public a() {
            }

            @Override // pp.e
            public pp.d get(int i10) {
                return HybridSecureRandom.this.new b(i10);
            }
        }

        public class b implements pp.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f45121a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AtomicReference f45122b = new AtomicReference();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final AtomicBoolean f45123c = new AtomicBoolean(false);

            public class a implements Runnable {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final int f45125a;

                public a(int i10) {
                    this.f45125a = i10;
                }

                public final void a(long j10) {
                    try {
                        Thread.sleep(j10);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String strC = p.c("org.bouncycastle.drbg.gather_pause_secs");
                    long j10 = 5000;
                    if (strC != null) {
                        try {
                            j10 = Long.parseLong(strC) * 1000;
                        } catch (Exception unused) {
                        }
                    }
                    int i10 = this.f45125a;
                    byte[] bArr = new byte[i10];
                    for (int i11 = 0; i11 < b.this.f45121a / 8; i11++) {
                        a(j10);
                        byte[] bArrGenerateSeed = HybridSecureRandom.this.baseRandom.generateSeed(8);
                        System.arraycopy(bArrGenerateSeed, 0, bArr, i11 * 8, bArrGenerateSeed.length);
                    }
                    int i12 = b.this.f45121a - ((b.this.f45121a / 8) * 8);
                    if (i12 != 0) {
                        a(j10);
                        byte[] bArrGenerateSeed2 = HybridSecureRandom.this.baseRandom.generateSeed(i12);
                        System.arraycopy(bArrGenerateSeed2, 0, bArr, i10 - bArrGenerateSeed2.length, bArrGenerateSeed2.length);
                    }
                    b.this.f45122b.set(bArr);
                    HybridSecureRandom.this.seedAvailable.set(true);
                }
            }

            public b(int i10) {
                this.f45121a = (i10 + 7) / 8;
            }

            @Override // pp.d
            public byte[] a() {
                byte[] bArrGenerateSeed = (byte[]) this.f45122b.getAndSet(null);
                if (bArrGenerateSeed == null || bArrGenerateSeed.length != this.f45121a) {
                    bArrGenerateSeed = HybridSecureRandom.this.baseRandom.generateSeed(this.f45121a);
                } else {
                    this.f45123c.set(false);
                }
                if (!this.f45123c.getAndSet(true)) {
                    Thread thread = new Thread(new a(this.f45121a));
                    thread.setDaemon(true);
                    thread.start();
                }
                return bArrGenerateSeed;
            }

            @Override // pp.d
            public boolean b() {
                return true;
            }

            @Override // pp.d
            public int c() {
                return this.f45121a * 8;
            }
        }

        public HybridSecureRandom() {
            super(null, new HybridRandomProvider());
            this.seedAvailable = new AtomicBoolean(false);
            this.samples = new AtomicInteger(0);
            SecureRandom secureRandomH = DRBG.h();
            this.baseRandom = secureRandomH;
            this.drbg = new i(new a()).g(Strings.i("Bouncy Castle Hybrid Entropy Source")).c(new k(new h0()), secureRandomH.generateSeed(32), false);
        }

        @Override // java.security.SecureRandom
        public byte[] generateSeed(int i10) {
            byte[] bArr = new byte[i10];
            if (this.samples.getAndIncrement() > 20 && this.seedAvailable.getAndSet(false)) {
                this.samples.set(0);
                this.drbg.a(null);
            }
            this.drbg.nextBytes(bArr);
            return bArr;
        }

        @Override // java.security.SecureRandom, java.util.Random
        public void setSeed(long j10) {
            SP800SecureRandom sP800SecureRandom = this.drbg;
            if (sP800SecureRandom != null) {
                sP800SecureRandom.setSeed(j10);
            }
        }

        @Override // java.security.SecureRandom
        public void setSeed(byte[] bArr) {
            SP800SecureRandom sP800SecureRandom = this.drbg;
            if (sP800SecureRandom != null) {
                sP800SecureRandom.setSeed(bArr);
            }
        }
    }

    public static class NonceAndIV extends SecureRandomSpi {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SecureRandom f45127a = DRBG.e(false);

        @Override // java.security.SecureRandomSpi
        public byte[] engineGenerateSeed(int i10) {
            return f45127a.generateSeed(i10);
        }

        @Override // java.security.SecureRandomSpi
        public void engineNextBytes(byte[] bArr) {
            f45127a.nextBytes(bArr);
        }

        @Override // java.security.SecureRandomSpi
        public void engineSetSeed(byte[] bArr) {
            f45127a.setSeed(bArr);
        }
    }

    public static class URLSeededSecureRandom extends SecureRandom {
        private final InputStream seedStream;

        public class a implements PrivilegedAction<InputStream> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ URL f45128a;

            public a(URL url) {
                this.f45128a = url;
            }

            @Override // java.security.PrivilegedAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public InputStream run() {
                try {
                    return this.f45128a.openStream();
                } catch (IOException unused) {
                    throw new IllegalStateException("unable to open random source");
                }
            }
        }

        public class b implements PrivilegedAction<Integer> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ byte[] f45130a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f45131b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ int f45132c;

            public b(byte[] bArr, int i10, int i11) {
                this.f45130a = bArr;
                this.f45131b = i10;
                this.f45132c = i11;
            }

            @Override // java.security.PrivilegedAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Integer run() {
                try {
                    return Integer.valueOf(URLSeededSecureRandom.this.seedStream.read(this.f45130a, this.f45131b, this.f45132c));
                } catch (IOException unused) {
                    throw new InternalError("unable to read random source");
                }
            }
        }

        public URLSeededSecureRandom(URL url) {
            super(null, new HybridRandomProvider());
            this.seedStream = (InputStream) AccessController.doPrivileged(new a(url));
        }

        public final int b(byte[] bArr, int i10, int i11) {
            return ((Integer) AccessController.doPrivileged(new b(bArr, i10, i11))).intValue();
        }

        @Override // java.security.SecureRandom
        public byte[] generateSeed(int i10) {
            byte[] bArr;
            synchronized (this) {
                bArr = new byte[i10];
                int i11 = 0;
                while (i11 != i10) {
                    int iB = b(bArr, i11, i10 - i11);
                    if (iB <= -1) {
                        break;
                    }
                    i11 += iB;
                }
                if (i11 != i10) {
                    throw new InternalError("unable to fully read random source");
                }
            }
            return bArr;
        }

        @Override // java.security.SecureRandom, java.util.Random
        public void setSeed(long j10) {
        }

        @Override // java.security.SecureRandom
        public void setSeed(byte[] bArr) {
        }
    }

    public static class a implements PrivilegedAction<Boolean> {
        @Override // java.security.PrivilegedAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean run() {
            try {
                return Boolean.valueOf(SecureRandom.class.getMethod("getInstanceStrong", new Class[0]) != null);
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }
    }

    public static class b implements PrivilegedAction<SecureRandom> {
        @Override // java.security.PrivilegedAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public SecureRandom run() {
            try {
                return (SecureRandom) SecureRandom.class.getMethod("getInstanceStrong", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
                return DRBG.f();
            }
        }
    }

    public static class c implements PrivilegedAction<e> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f45134a;

        public c(String str) {
            this.f45134a = str;
        }

        @Override // java.security.PrivilegedAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public e run() {
            try {
                return (e) f.a(DRBG.class, this.f45134a).newInstance();
            } catch (Exception e10) {
                throw new IllegalStateException("entropy source " + this.f45134a + " not created: " + e10.getMessage(), e10);
            }
        }
    }

    public static class d extends br.b {
        @Override // br.a
        public void a(uq.a aVar) {
            aVar.h("SecureRandom.DEFAULT", DRBG.f45117a + "$Default");
            aVar.h("SecureRandom.NONCEANDIV", DRBG.f45117a + "$NonceAndIV");
        }
    }

    public static SecureRandom e(boolean z10) {
        if (p.c("org.bouncycastle.drbg.entropysource") == null) {
            HybridSecureRandom hybridSecureRandom = new HybridSecureRandom();
            byte[] bArrGenerateSeed = hybridSecureRandom.generateSeed(16);
            return new i(hybridSecureRandom, true).g(z10 ? j(bArrGenerateSeed) : k(bArrGenerateSeed)).d(new h0(), hybridSecureRandom.generateSeed(32), z10);
        }
        e eVarG = g();
        pp.d dVar = eVarG.get(128);
        byte[] bArrA = dVar.a();
        return new i(eVarG).g(z10 ? j(bArrA) : k(bArrA)).d(new h0(), org.bouncycastle.util.a.B(dVar.a(), dVar.a()), z10);
    }

    public static SecureRandom f() {
        if (Security.getProperty("securerandom.source") == null) {
            return new CoreSecureRandom(i());
        }
        try {
            return new URLSeededSecureRandom(new URL(Security.getProperty("securerandom.source")));
        } catch (Exception unused) {
            return new CoreSecureRandom(i());
        }
    }

    public static e g() {
        return (e) AccessController.doPrivileged(new c(p.c("org.bouncycastle.drbg.entropysource")));
    }

    public static SecureRandom h() {
        return ((Boolean) AccessController.doPrivileged(new a())).booleanValue() ? (SecureRandom) AccessController.doPrivileged(new b()) : f();
    }

    public static final Object[] i() {
        int i10 = 0;
        while (true) {
            String[][] strArr = f45118b;
            if (i10 >= strArr.length) {
                return null;
            }
            String[] strArr2 = strArr[i10];
            try {
                return new Object[]{Class.forName(strArr2[0]).newInstance(), Class.forName(strArr2[1]).newInstance()};
            } catch (Throwable unused) {
                i10++;
            }
        }
    }

    public static byte[] j(byte[] bArr) {
        return org.bouncycastle.util.a.D(Strings.i("Default"), bArr, o.D(Thread.currentThread().getId()), o.D(System.currentTimeMillis()));
    }

    public static byte[] k(byte[] bArr) {
        return org.bouncycastle.util.a.D(Strings.i("Nonce"), bArr, o.I(Thread.currentThread().getId()), o.I(System.currentTimeMillis()));
    }
}
