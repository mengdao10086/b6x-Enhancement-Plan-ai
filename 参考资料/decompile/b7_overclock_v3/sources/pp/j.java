package pp;

/* JADX INFO: loaded from: classes5.dex */
public class j {

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile int f46964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile boolean f46965b;

        public b() {
            this.f46964a = 0;
            this.f46965b = false;
        }

        public byte[] a(int i10, boolean z10) {
            Thread thread = new Thread(this);
            byte[] bArr = new byte[i10];
            this.f46964a = 0;
            this.f46965b = false;
            thread.start();
            if (!z10) {
                i10 *= 8;
            }
            int i11 = 0;
            for (int i12 = 0; i12 < i10; i12++) {
                while (this.f46964a == i11) {
                    try {
                        Thread.sleep(1L);
                    } catch (InterruptedException unused) {
                    }
                }
                i11 = this.f46964a;
                if (z10) {
                    bArr[i12] = (byte) (i11 & 255);
                } else {
                    int i13 = i12 / 8;
                    bArr[i13] = (byte) ((bArr[i13] << 1) | (i11 & 1));
                }
            }
            this.f46965b = true;
            return bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f46965b) {
                this.f46964a++;
            }
        }
    }

    public byte[] a(int i10, boolean z10) {
        return new b().a(i10, z10);
    }
}
