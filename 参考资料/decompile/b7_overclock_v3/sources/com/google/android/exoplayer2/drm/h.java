package com.google.android.exoplayer2.drm;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.drm.f;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.b;
import com.google.common.collect.ImmutableMap;
import ed.l;
import ed.x;
import g.p0;
import hd.u0;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f17089e = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HttpDataSource.b f17090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f17091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f17092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f17093d;

    public h(@p0 String str, HttpDataSource.b bVar) {
        this(str, false, bVar);
    }

    public static byte[] e(HttpDataSource.b bVar, String str, @p0 byte[] bArr, Map<String, String> map) throws MediaDrmCallbackException {
        x xVar = new x(bVar.a());
        com.google.android.exoplayer2.upstream.b bVarA = new b.C0198b().k(str).f(map).e(2).d(bArr).c(1).a();
        int i10 = 0;
        com.google.android.exoplayer2.upstream.b bVarA2 = bVarA;
        while (true) {
            try {
                l lVar = new l(xVar, bVarA2);
                try {
                    return u0.t1(lVar);
                } catch (HttpDataSource.InvalidResponseCodeException e10) {
                    String strF = f(e10, i10);
                    if (strF == null) {
                        throw e10;
                    }
                    i10++;
                    bVarA2 = bVarA2.a().k(strF).a();
                } finally {
                    u0.q(lVar);
                }
            } catch (Exception e11) {
                throw new MediaDrmCallbackException(bVarA, (Uri) hd.a.g(xVar.v()), xVar.c(), xVar.u(), e11);
            }
        }
    }

    @p0
    public static String f(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException, int i10) {
        Map<String, List<String>> map;
        List<String> list;
        int i11 = invalidResponseCodeException.responseCode;
        if (!((i11 == 307 || i11 == 308) && i10 < 5) || (map = invalidResponseCodeException.headerFields) == null || (list = map.get("Location")) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override // com.google.android.exoplayer2.drm.j
    public byte[] a(UUID uuid, f.b bVar) throws MediaDrmCallbackException {
        String strB = bVar.b();
        if (this.f17092c || TextUtils.isEmpty(strB)) {
            strB = this.f17091b;
        }
        if (TextUtils.isEmpty(strB)) {
            throw new MediaDrmCallbackException(new b.C0198b().j(Uri.EMPTY).a(), Uri.EMPTY, ImmutableMap.of(), 0L, new IllegalStateException("No license URL"));
        }
        HashMap map = new HashMap();
        UUID uuid2 = ya.g.L1;
        map.put("Content-Type", uuid2.equals(uuid) ? "text/xml" : ya.g.J1.equals(uuid) ? "application/json" : DfuBaseService.MIME_TYPE_OCTET_STREAM);
        if (uuid2.equals(uuid)) {
            map.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
        }
        synchronized (this.f17093d) {
            map.putAll(this.f17093d);
        }
        return e(this.f17090a, strB, bVar.a(), map);
    }

    @Override // com.google.android.exoplayer2.drm.j
    public byte[] b(UUID uuid, f.h hVar) throws MediaDrmCallbackException {
        return e(this.f17090a, hVar.b() + "&signedRequest=" + u0.J(hVar.a()), null, Collections.emptyMap());
    }

    public void c() {
        synchronized (this.f17093d) {
            this.f17093d.clear();
        }
    }

    public void d(String str) {
        hd.a.g(str);
        synchronized (this.f17093d) {
            this.f17093d.remove(str);
        }
    }

    public void g(String str, String str2) {
        hd.a.g(str);
        hd.a.g(str2);
        synchronized (this.f17093d) {
            this.f17093d.put(str, str2);
        }
    }

    public h(@p0 String str, boolean z10, HttpDataSource.b bVar) {
        hd.a.a((z10 && TextUtils.isEmpty(str)) ? false : true);
        this.f17090a = bVar;
        this.f17091b = str;
        this.f17092c = z10;
        this.f17093d = new HashMap();
    }
}
