package pp;

import java.security.SecureRandom;
import org.bouncycastle.crypto.prng.SP800SecureRandom;
import org.bouncycastle.crypto.prng.X931SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SecureRandom f46933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f46934b;

    /* JADX INFO: renamed from: pp.a$a, reason: collision with other inner class name */
    public class C0533a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f46935a;

        public C0533a(int i10) {
            this.f46935a = i10;
        }

        @Override // pp.d
        public byte[] a() {
            if (!(a.this.f46933a instanceof SP800SecureRandom) && !(a.this.f46933a instanceof X931SecureRandom)) {
                return a.this.f46933a.generateSeed((this.f46935a + 7) / 8);
            }
            byte[] bArr = new byte[(this.f46935a + 7) / 8];
            a.this.f46933a.nextBytes(bArr);
            return bArr;
        }

        @Override // pp.d
        public boolean b() {
            return a.this.f46934b;
        }

        @Override // pp.d
        public int c() {
            return this.f46935a;
        }
    }

    public a(SecureRandom secureRandom, boolean z10) {
        this.f46933a = secureRandom;
        this.f46934b = z10;
    }

    @Override // pp.e
    public d get(int i10) {
        return new C0533a(i10);
    }
}
