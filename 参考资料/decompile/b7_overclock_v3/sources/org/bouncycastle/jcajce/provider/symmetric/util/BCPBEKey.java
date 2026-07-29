package org.bouncycastle.jcajce.provider.symmetric.util;

import gm.y;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import javax.security.auth.Destroyable;
import np.n1;
import np.v1;
import org.bouncycastle.crypto.c0;
import org.bouncycastle.crypto.k;

/* JADX INFO: loaded from: classes5.dex */
public class BCPBEKey implements PBEKey, Destroyable {
    public String algorithm;
    public int digest;
    private final AtomicBoolean hasBeenDestroyed;
    private final int iterationCount;
    public int ivSize;
    public int keySize;
    public y oid;
    private final k param;
    private final char[] password;
    private final byte[] salt;
    public boolean tryWrong;
    public int type;

    public BCPBEKey(String str, y yVar, int i10, int i11, int i12, int i13, PBEKeySpec pBEKeySpec, k kVar) {
        this.hasBeenDestroyed = new AtomicBoolean(false);
        this.tryWrong = false;
        this.algorithm = str;
        this.oid = yVar;
        this.type = i10;
        this.digest = i11;
        this.keySize = i12;
        this.ivSize = i13;
        this.password = pBEKeySpec.getPassword();
        this.iterationCount = pBEKeySpec.getIterationCount();
        this.salt = pBEKeySpec.getSalt();
        this.param = kVar;
    }

    public BCPBEKey(String str, k kVar) {
        this.hasBeenDestroyed = new AtomicBoolean(false);
        this.tryWrong = false;
        this.algorithm = str;
        this.param = kVar;
        this.password = null;
        this.iterationCount = -1;
        this.salt = null;
    }

    public static void a(Destroyable destroyable) {
        if (destroyable.isDestroyed()) {
            throw new IllegalStateException("key has been destroyed");
        }
    }

    public int b() {
        a(this);
        return this.digest;
    }

    public int c() {
        a(this);
        return this.ivSize;
    }

    public int d() {
        a(this);
        return this.keySize;
    }

    @Override // javax.security.auth.Destroyable
    public void destroy() {
        if (this.hasBeenDestroyed.getAndSet(true)) {
            return;
        }
        char[] cArr = this.password;
        if (cArr != null) {
            org.bouncycastle.util.a.f0(cArr, (char) 0);
        }
        byte[] bArr = this.salt;
        if (bArr != null) {
            org.bouncycastle.util.a.d0(bArr, (byte) 0);
        }
    }

    public y f() {
        a(this);
        return this.oid;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        a(this);
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        a(this);
        k kVarB = this.param;
        if (kVarB == null) {
            int i10 = this.type;
            return i10 == 2 ? c0.a(this.password) : i10 == 5 ? c0.c(this.password) : c0.b(this.password);
        }
        if (kVarB instanceof v1) {
            kVarB = ((v1) kVarB).b();
        }
        return ((n1) kVarB).a();
    }

    @Override // java.security.Key
    public String getFormat() {
        return "RAW";
    }

    @Override // javax.crypto.interfaces.PBEKey
    public int getIterationCount() {
        a(this);
        return this.iterationCount;
    }

    @Override // javax.crypto.interfaces.PBEKey
    public char[] getPassword() {
        a(this);
        char[] cArr = this.password;
        if (cArr != null) {
            return org.bouncycastle.util.a.r(cArr);
        }
        throw new IllegalStateException("no password available");
    }

    @Override // javax.crypto.interfaces.PBEKey
    public byte[] getSalt() {
        a(this);
        return org.bouncycastle.util.a.p(this.salt);
    }

    public k h() {
        a(this);
        return this.param;
    }

    public int i() {
        a(this);
        return this.type;
    }

    @Override // javax.security.auth.Destroyable
    public boolean isDestroyed() {
        return this.hasBeenDestroyed.get();
    }

    public void k(boolean z10) {
        this.tryWrong = z10;
    }

    public boolean l() {
        return this.tryWrong;
    }
}
