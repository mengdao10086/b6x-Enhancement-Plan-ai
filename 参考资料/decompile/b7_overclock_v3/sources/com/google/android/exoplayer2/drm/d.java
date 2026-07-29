package com.google.android.exoplayer2.drm;

import android.media.MediaDrmException;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.f;
import g.p0;
import g.v0;
import gb.s;
import gb.y;
import hd.u0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
@v0(18)
public final class d implements f {
    public static d t() {
        return new d();
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void a() {
    }

    @Override // com.google.android.exoplayer2.drm.f
    public Class<y> b() {
        return y.class;
    }

    @Override // com.google.android.exoplayer2.drm.f
    public Map<String, String> c(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void d(String str, byte[] bArr) {
    }

    @Override // com.google.android.exoplayer2.drm.f
    public String e(String str) {
        return "";
    }

    @Override // com.google.android.exoplayer2.drm.f
    public s f(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.f
    public f.h g() {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void h(@p0 f.e eVar) {
    }

    @Override // com.google.android.exoplayer2.drm.f
    public byte[] i() throws MediaDrmException {
        throw new MediaDrmException("Attempting to open a session using a dummy ExoMediaDrm.");
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void j(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void k(String str, String str2) {
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void l(byte[] bArr) {
    }

    @Override // com.google.android.exoplayer2.drm.f
    public byte[] m(String str) {
        return u0.f31159f;
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void n(@p0 f.d dVar) {
    }

    @Override // com.google.android.exoplayer2.drm.f
    @p0
    public byte[] o(byte[] bArr, byte[] bArr2) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.f
    @p0
    public PersistableBundle p() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void q(byte[] bArr) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.f
    public f.b r(byte[] bArr, @p0 List<DrmInitData.SchemeData> list, int i10, @p0 HashMap<String, String> map) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void release() {
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void s(@p0 f.InterfaceC0177f interfaceC0177f) {
    }
}
