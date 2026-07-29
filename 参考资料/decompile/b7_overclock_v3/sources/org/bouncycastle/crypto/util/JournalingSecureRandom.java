package org.bouncycastle.crypto.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes5.dex */
public class JournalingSecureRandom extends SecureRandom {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static byte[] f44718a = new byte[0];
    private final SecureRandom base;
    private int index;
    private b tOut;
    private byte[] transcript;

    public class b extends ByteArrayOutputStream {
        public b() {
        }

        public void a() {
            org.bouncycastle.util.a.d0(((ByteArrayOutputStream) this).buf, (byte) 0);
        }
    }

    public JournalingSecureRandom() {
        this(org.bouncycastle.crypto.n.f());
    }

    public JournalingSecureRandom(SecureRandom secureRandom) {
        this.tOut = new b();
        this.index = 0;
        this.base = secureRandom;
        this.transcript = f44718a;
    }

    public JournalingSecureRandom(byte[] bArr, SecureRandom secureRandom) {
        this.tOut = new b();
        this.index = 0;
        this.base = secureRandom;
        this.transcript = org.bouncycastle.util.a.p(bArr);
    }

    public byte[] a() {
        int i10 = this.index;
        byte[] bArr = this.transcript;
        return i10 == bArr.length ? this.tOut.toByteArray() : org.bouncycastle.util.a.p(bArr);
    }

    public byte[] b() {
        return this.tOut.toByteArray();
    }

    public void c() {
        this.index = 0;
        if (this.transcript.length == 0) {
            this.transcript = this.tOut.toByteArray();
        }
        this.tOut.reset();
    }

    public void clear() {
        org.bouncycastle.util.a.d0(this.transcript, (byte) 0);
        this.tOut.a();
    }

    @Override // java.security.SecureRandom, java.util.Random
    public final void nextBytes(byte[] bArr) {
        if (this.index >= this.transcript.length) {
            this.base.nextBytes(bArr);
        } else {
            int i10 = 0;
            while (i10 != bArr.length) {
                int i11 = this.index;
                byte[] bArr2 = this.transcript;
                if (i11 >= bArr2.length) {
                    break;
                }
                this.index = i11 + 1;
                bArr[i10] = bArr2[i11];
                i10++;
            }
            if (i10 != bArr.length) {
                int length = bArr.length - i10;
                byte[] bArr3 = new byte[length];
                this.base.nextBytes(bArr3);
                System.arraycopy(bArr3, 0, bArr, i10, length);
            }
        }
        try {
            this.tOut.write(bArr);
        } catch (IOException e10) {
            throw new IllegalStateException("unable to record transcript: " + e10.getMessage());
        }
    }
}
