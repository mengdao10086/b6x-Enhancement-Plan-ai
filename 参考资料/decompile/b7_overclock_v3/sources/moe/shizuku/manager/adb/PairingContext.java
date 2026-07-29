package moe.shizuku.manager.adb;

import hk.m;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
final class PairingContext {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @k
    public static final a f41476c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f41477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final byte[] f41478b;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @l
        public final PairingContext a(@k byte[] password) {
            f0.p(password, "password");
            long jB = b(true, password);
            u uVar = null;
            if (jB != 0) {
                return new PairingContext(jB, uVar);
            }
            return null;
        }

        @m
        public final long b(boolean z10, byte[] bArr) {
            return PairingContext.nativeConstructor(z10, bArr);
        }
    }

    public PairingContext(long j10) {
        this.f41477a = j10;
        this.f41478b = nativeMsg(j10);
    }

    public /* synthetic */ PairingContext(long j10, u uVar) {
        this(j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @m
    public static final native long nativeConstructor(boolean z10, byte[] bArr);

    private final native byte[] nativeDecrypt(long j10, byte[] bArr);

    private final native void nativeDestroy(long j10);

    private final native byte[] nativeEncrypt(long j10, byte[] bArr);

    private final native boolean nativeInitCipher(long j10, byte[] bArr);

    private final native byte[] nativeMsg(long j10);

    @l
    public final byte[] b(@k byte[] in2) {
        f0.p(in2, "in");
        return nativeDecrypt(this.f41477a, in2);
    }

    public final void c() {
        nativeDestroy(this.f41477a);
    }

    @l
    public final byte[] d(@k byte[] in2) {
        f0.p(in2, "in");
        return nativeEncrypt(this.f41477a, in2);
    }

    @k
    public final byte[] e() {
        return this.f41478b;
    }

    public final boolean f(@k byte[] theirMsg) {
        f0.p(theirMsg, "theirMsg");
        return nativeInitCipher(this.f41477a, theirMsg);
    }
}
