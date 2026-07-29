package com.google.android.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import com.google.android.exoplayer2.upstream.e;
import ed.z;
import g.p0;
import hd.t;
import hd.u0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f19113m = "DefaultDataSource";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f19114n = "asset";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f19115o = "content";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f19116p = "rtmp";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f19117q = "udp";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f19118r = "data";

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f19119s = "rawresource";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f19120t = "android.resource";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f19121b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<z> f19122c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f19123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public a f19124e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @p0
    public a f19125f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    public a f19126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @p0
    public a f19127h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    public a f19128i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    public a f19129j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @p0
    public a f19130k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @p0
    public a f19131l;

    public c(Context context, boolean z10) {
        this(context, null, 8000, 8000, z10);
    }

    public final a A() {
        if (this.f19127h == null) {
            try {
                a aVar = (a) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f19127h = aVar;
                u(aVar);
            } catch (ClassNotFoundException unused) {
                t.n(f19113m, "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e10) {
                throw new RuntimeException("Error instantiating RTMP extension", e10);
            }
            if (this.f19127h == null) {
                this.f19127h = this.f19123d;
            }
        }
        return this.f19127h;
    }

    public final a B() {
        if (this.f19128i == null) {
            UdpDataSource udpDataSource = new UdpDataSource();
            this.f19128i = udpDataSource;
            u(udpDataSource);
        }
        return this.f19128i;
    }

    public final void C(@p0 a aVar, z zVar) {
        if (aVar != null) {
            aVar.d(zVar);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public long a(b bVar) throws IOException {
        hd.a.i(this.f19131l == null);
        String scheme = bVar.f19092a.getScheme();
        if (u0.G0(bVar.f19092a)) {
            String path = bVar.f19092a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                this.f19131l = y();
            } else {
                this.f19131l = v();
            }
        } else if (f19114n.equals(scheme)) {
            this.f19131l = v();
        } else if ("content".equals(scheme)) {
            this.f19131l = w();
        } else if (f19116p.equals(scheme)) {
            this.f19131l = A();
        } else if (f19117q.equals(scheme)) {
            this.f19131l = B();
        } else if ("data".equals(scheme)) {
            this.f19131l = x();
        } else if ("rawresource".equals(scheme) || f19120t.equals(scheme)) {
            this.f19131l = z();
        } else {
            this.f19131l = this.f19123d;
        }
        return this.f19131l.a(bVar);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public Map<String, List<String>> c() {
        a aVar = this.f19131l;
        return aVar == null ? Collections.emptyMap() : aVar.c();
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void close() throws IOException {
        a aVar = this.f19131l;
        if (aVar != null) {
            try {
                aVar.close();
            } finally {
                this.f19131l = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.a
    public void d(z zVar) {
        hd.a.g(zVar);
        this.f19123d.d(zVar);
        this.f19122c.add(zVar);
        C(this.f19124e, zVar);
        C(this.f19125f, zVar);
        C(this.f19126g, zVar);
        C(this.f19127h, zVar);
        C(this.f19128i, zVar);
        C(this.f19129j, zVar);
        C(this.f19130k, zVar);
    }

    @Override // ed.h
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        return ((a) hd.a.g(this.f19131l)).read(bArr, i10, i11);
    }

    @Override // com.google.android.exoplayer2.upstream.a
    @p0
    public Uri s() {
        a aVar = this.f19131l;
        if (aVar == null) {
            return null;
        }
        return aVar.s();
    }

    public final void u(a aVar) {
        for (int i10 = 0; i10 < this.f19122c.size(); i10++) {
            aVar.d(this.f19122c.get(i10));
        }
    }

    public final a v() {
        if (this.f19125f == null) {
            AssetDataSource assetDataSource = new AssetDataSource(this.f19121b);
            this.f19125f = assetDataSource;
            u(assetDataSource);
        }
        return this.f19125f;
    }

    public final a w() {
        if (this.f19126g == null) {
            ContentDataSource contentDataSource = new ContentDataSource(this.f19121b);
            this.f19126g = contentDataSource;
            u(contentDataSource);
        }
        return this.f19126g;
    }

    public final a x() {
        if (this.f19129j == null) {
            ed.i iVar = new ed.i();
            this.f19129j = iVar;
            u(iVar);
        }
        return this.f19129j;
    }

    public final a y() {
        if (this.f19124e == null) {
            FileDataSource fileDataSource = new FileDataSource();
            this.f19124e = fileDataSource;
            u(fileDataSource);
        }
        return this.f19124e;
    }

    public final a z() {
        if (this.f19130k == null) {
            RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.f19121b);
            this.f19130k = rawResourceDataSource;
            u(rawResourceDataSource);
        }
        return this.f19130k;
    }

    public c(Context context, @p0 String str, boolean z10) {
        this(context, str, 8000, 8000, z10);
    }

    public c(Context context, @p0 String str, int i10, int i11, boolean z10) {
        this(context, new e.b().k(str).f(i10).i(i11).e(z10).a());
    }

    public c(Context context, a aVar) {
        this.f19121b = context.getApplicationContext();
        this.f19123d = (a) hd.a.g(aVar);
        this.f19122c = new ArrayList();
    }
}
