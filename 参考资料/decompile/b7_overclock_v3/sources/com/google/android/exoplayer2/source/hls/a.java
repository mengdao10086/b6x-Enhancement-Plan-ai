package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import ed.z;
import g.p0;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class a implements com.google.android.exoplayer2.upstream.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.android.exoplayer2.upstream.a f17815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f17816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f17817d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public CipherInputStream f17818e;

    public a(com.google.android.exoplayer2.upstream.a aVar, byte[] bArr, byte[] bArr2) {
        this.f17815b = aVar;
        this.f17816c = bArr;
        this.f17817d = bArr2;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final long a(com.google.android.exoplayer2.upstream.b bVar) throws IOException {
        try {
            Cipher cipherU = u();
            try {
                cipherU.init(2, new SecretKeySpec(this.f17816c, m5.b.f40641c), new IvParameterSpec(this.f17817d));
                ed.l lVar = new ed.l(this.f17815b, bVar);
                this.f17818e = new CipherInputStream(lVar, cipherU);
                lVar.d();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e10) {
                throw new RuntimeException(e10);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e11) {
            throw new RuntimeException(e11);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final Map<String, List<String>> c() {
        return this.f17815b.c();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        if (this.f17818e != null) {
            this.f17818e = null;
            this.f17815b.close();
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public final void d(z zVar) {
        hd.a.g(zVar);
        this.f17815b.d(zVar);
    }

    @Override // ed.h
    public final int read(byte[] bArr, int i10, int i11) throws IOException {
        hd.a.g(this.f17818e);
        int i12 = this.f17818e.read(bArr, i10, i11);
        if (i12 < 0) {
            return -1;
        }
        return i12;
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public final Uri s() {
        return this.f17815b.s();
    }

    public Cipher u() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }
}
