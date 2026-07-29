package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.DeniedByServerException;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import android.os.PersistableBundle;
import android.text.TextUtils;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.f;
import com.google.common.base.Charsets;
import g.p0;
import g.v0;
import hd.c0;
import hd.t;
import hd.u0;
import hd.w;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import ob.l;

/* JADX INFO: loaded from: classes3.dex */
@v0(18)
public final class g implements f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f17080j = "FrameworkMediaDrm";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final f.g f17081k = new f.g() { // from class: gb.x
        @Override // com.google.android.exoplayer2.drm.f.g
        public final com.google.android.exoplayer2.drm.f a(UUID uuid) {
            return com.google.android.exoplayer2.drm.g.J(uuid);
        }
    };

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f17082l = "cenc";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f17083m = "https://x";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f17084n = "<LA_URL>https://x</LA_URL>";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f17085o = 2;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final UUID f17086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MediaDrm f17087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f17088i;

    public g(UUID uuid) throws UnsupportedSchemeException {
        hd.a.g(uuid);
        hd.a.b(!ya.g.I1.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f17086g = uuid;
        MediaDrm mediaDrm = new MediaDrm(B(uuid));
        this.f17087h = mediaDrm;
        this.f17088i = 1;
        if (ya.g.K1.equals(uuid) && K()) {
            D(mediaDrm);
        }
    }

    public static String A(UUID uuid, String str) {
        return (u0.f31154a < 26 && ya.g.J1.equals(uuid) && (w.f31182f.equals(str) || w.f31222z.equals(str))) ? "cenc" : str;
    }

    public static UUID B(UUID uuid) {
        return (u0.f31154a >= 27 || !ya.g.J1.equals(uuid)) ? uuid : ya.g.I1;
    }

    @SuppressLint({"WrongConstant"})
    public static void D(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    public static DrmInitData.SchemeData E(UUID uuid, List<DrmInitData.SchemeData> list) {
        boolean z10;
        if (!ya.g.K1.equals(uuid)) {
            return list.get(0);
        }
        if (u0.f31154a >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = list.get(0);
            int length = 0;
            for (int i10 = 0; i10 < list.size(); i10++) {
                DrmInitData.SchemeData schemeData2 = list.get(i10);
                byte[] bArr = (byte[]) hd.a.g(schemeData2.f17039e);
                if (!u0.c(schemeData2.f17038d, schemeData.f17038d) || !u0.c(schemeData2.f17037c, schemeData.f17037c) || !l.c(bArr)) {
                    z10 = false;
                    break;
                }
                length += bArr.length;
            }
            z10 = true;
            if (z10) {
                byte[] bArr2 = new byte[length];
                int i11 = 0;
                for (int i12 = 0; i12 < list.size(); i12++) {
                    byte[] bArr3 = (byte[]) hd.a.g(list.get(i12).f17039e);
                    int length2 = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i11, length2);
                    i11 += length2;
                }
                return schemeData.b(bArr2);
            }
        }
        for (int i13 = 0; i13 < list.size(); i13++) {
            DrmInitData.SchemeData schemeData3 = list.get(i13);
            int iG = l.g((byte[]) hd.a.g(schemeData3.f17039e));
            int i14 = u0.f31154a;
            if (i14 < 23 && iG == 0) {
                return schemeData3;
            }
            if (i14 >= 23 && iG == 1) {
                return schemeData3;
            }
        }
        return list.get(0);
    }

    public static boolean F(UUID uuid) {
        return MediaDrm.isCryptoSchemeSupported(B(uuid));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(f.d dVar, MediaDrm mediaDrm, byte[] bArr, int i10, int i11, byte[] bArr2) {
        dVar.a(this, bArr, i10, i11, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(f.e eVar, MediaDrm mediaDrm, byte[] bArr, long j10) {
        eVar.a(this, bArr, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(f.InterfaceC0177f interfaceC0177f, MediaDrm mediaDrm, byte[] bArr, List list, boolean z10) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            MediaDrm.KeyStatus keyStatus = (MediaDrm.KeyStatus) it2.next();
            arrayList.add(new f.c(keyStatus.getStatusCode(), keyStatus.getKeyId()));
        }
        interfaceC0177f.a(this, bArr, arrayList, z10);
    }

    public static /* synthetic */ f J(UUID uuid) {
        try {
            return L(uuid);
        } catch (UnsupportedDrmException unused) {
            t.d(f17080j, "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + j3.b.f36044h);
            return new d();
        }
    }

    public static boolean K() {
        return "ASUS_Z00AD".equals(u0.f31157d);
    }

    public static g L(UUID uuid) throws UnsupportedDrmException {
        try {
            return new g(uuid);
        } catch (UnsupportedSchemeException e10) {
            throw new UnsupportedDrmException(1, e10);
        } catch (Exception e11) {
            throw new UnsupportedDrmException(2, e11);
        }
    }

    public static byte[] x(byte[] bArr) {
        c0 c0Var = new c0(bArr);
        int iR = c0Var.r();
        short sU = c0Var.u();
        short sU2 = c0Var.u();
        if (sU != 1 || sU2 != 1) {
            t.i(f17080j, "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short sU3 = c0Var.u();
        Charset charset = Charsets.UTF_16LE;
        String strE = c0Var.E(sU3, charset);
        if (strE.contains("<LA_URL>")) {
            return bArr;
        }
        int iIndexOf = strE.indexOf("</DATA>");
        if (iIndexOf == -1) {
            t.n(f17080j, "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = strE.substring(0, iIndexOf) + f17084n + strE.substring(iIndexOf);
        int i10 = iR + 52;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(i10);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        byteBufferAllocate.putInt(i10);
        byteBufferAllocate.putShort(sU);
        byteBufferAllocate.putShort(sU2);
        byteBufferAllocate.putShort((short) (str.length() * 2));
        byteBufferAllocate.put(str.getBytes(charset));
        return byteBufferAllocate.array();
    }

    public static byte[] y(UUID uuid, byte[] bArr) {
        return ya.g.J1.equals(uuid) ? gb.a.a(bArr) : bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] z(java.util.UUID r3, byte[] r4) {
        /*
            java.util.UUID r0 = ya.g.L1
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L18
            byte[] r1 = ob.l.e(r4, r3)
            if (r1 != 0) goto Lf
            goto L10
        Lf:
            r4 = r1
        L10:
            byte[] r4 = x(r4)
            byte[] r4 = ob.l.a(r0, r4)
        L18:
            int r1 = hd.u0.f31154a
            r2 = 23
            if (r1 >= r2) goto L26
            java.util.UUID r1 = ya.g.K1
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L58
        L26:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5f
            java.lang.String r0 = hd.u0.f31156c
            java.lang.String r1 = "Amazon"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5f
            java.lang.String r0 = hd.u0.f31157d
            java.lang.String r1 = "AFTB"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5f
        L58:
            byte[] r3 = ob.l.e(r4, r3)
            if (r3 == 0) goto L5f
            return r3
        L5f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.g.z(java.util.UUID, byte[]):byte[]");
    }

    @Override // com.google.android.exoplayer2.drm.f
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public gb.t f(byte[] bArr) throws MediaCryptoException {
        return new gb.t(B(this.f17086g), bArr, u0.f31154a < 21 && ya.g.K1.equals(this.f17086g) && "L3".equals(e("securityLevel")));
    }

    @Override // com.google.android.exoplayer2.drm.f
    public synchronized void a() {
        hd.a.i(this.f17088i > 0);
        this.f17088i++;
    }

    @Override // com.google.android.exoplayer2.drm.f
    public Class<gb.t> b() {
        return gb.t.class;
    }

    @Override // com.google.android.exoplayer2.drm.f
    public Map<String, String> c(byte[] bArr) {
        return this.f17087h.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void d(String str, byte[] bArr) {
        this.f17087h.setPropertyByteArray(str, bArr);
    }

    @Override // com.google.android.exoplayer2.drm.f
    public String e(String str) {
        return this.f17087h.getPropertyString(str);
    }

    @Override // com.google.android.exoplayer2.drm.f
    public f.h g() {
        MediaDrm.ProvisionRequest provisionRequest = this.f17087h.getProvisionRequest();
        return new f.h(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.f
    @v0(23)
    public void h(@p0 final f.e eVar) {
        if (u0.f31154a < 23) {
            throw new UnsupportedOperationException();
        }
        this.f17087h.setOnExpirationUpdateListener(eVar == null ? null : new MediaDrm.OnExpirationUpdateListener() { // from class: gb.v
            @Override // android.media.MediaDrm.OnExpirationUpdateListener
            public final void onExpirationUpdate(MediaDrm mediaDrm, byte[] bArr, long j10) {
                this.f29129a.H(eVar, mediaDrm, bArr, j10);
            }
        }, (Handler) null);
    }

    @Override // com.google.android.exoplayer2.drm.f
    public byte[] i() throws MediaDrmException {
        return this.f17087h.openSession();
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void j(byte[] bArr, byte[] bArr2) {
        this.f17087h.restoreKeys(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void k(String str, String str2) {
        this.f17087h.setPropertyString(str, str2);
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void l(byte[] bArr) {
        this.f17087h.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.f
    public byte[] m(String str) {
        return this.f17087h.getPropertyByteArray(str);
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void n(@p0 final f.d dVar) {
        this.f17087h.setOnEventListener(dVar == null ? null : new MediaDrm.OnEventListener() { // from class: gb.u
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i10, int i11, byte[] bArr2) {
                this.f29127a.G(dVar, mediaDrm, bArr, i10, i11, bArr2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.f
    @p0
    public byte[] o(byte[] bArr, byte[] bArr2) throws DeniedByServerException, NotProvisionedException {
        if (ya.g.J1.equals(this.f17086g)) {
            bArr2 = gb.a.b(bArr2);
        }
        return this.f17087h.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.f
    @p0
    public PersistableBundle p() {
        if (u0.f31154a < 28) {
            return null;
        }
        return this.f17087h.getMetrics();
    }

    @Override // com.google.android.exoplayer2.drm.f
    public void q(byte[] bArr) throws DeniedByServerException {
        this.f17087h.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.f
    public f.b r(byte[] bArr, @p0 List<DrmInitData.SchemeData> list, int i10, @p0 HashMap<String, String> map) throws NotProvisionedException {
        byte[] bArrZ;
        String strA;
        DrmInitData.SchemeData schemeDataE = null;
        if (list != null) {
            schemeDataE = E(this.f17086g, list);
            bArrZ = z(this.f17086g, (byte[]) hd.a.g(schemeDataE.f17039e));
            strA = A(this.f17086g, schemeDataE.f17038d);
        } else {
            bArrZ = null;
            strA = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f17087h.getKeyRequest(bArr, bArrZ, strA, i10, map);
        byte[] bArrY = y(this.f17086g, keyRequest.getData());
        String defaultUrl = keyRequest.getDefaultUrl();
        if (f17083m.equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && schemeDataE != null && !TextUtils.isEmpty(schemeDataE.f17037c)) {
            defaultUrl = schemeDataE.f17037c;
        }
        return new f.b(bArrY, defaultUrl, u0.f31154a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // com.google.android.exoplayer2.drm.f
    public synchronized void release() {
        int i10 = this.f17088i - 1;
        this.f17088i = i10;
        if (i10 == 0) {
            this.f17087h.release();
        }
    }

    @Override // com.google.android.exoplayer2.drm.f
    @v0(23)
    public void s(@p0 final f.InterfaceC0177f interfaceC0177f) {
        if (u0.f31154a < 23) {
            throw new UnsupportedOperationException();
        }
        this.f17087h.setOnKeyStatusChangeListener(interfaceC0177f == null ? null : new MediaDrm.OnKeyStatusChangeListener() { // from class: gb.w
            @Override // android.media.MediaDrm.OnKeyStatusChangeListener
            public final void onKeyStatusChange(MediaDrm mediaDrm, byte[] bArr, List list, boolean z10) {
                this.f29131a.I(interfaceC0177f, mediaDrm, bArr, list, z10);
            }
        }, (Handler) null);
    }
}
