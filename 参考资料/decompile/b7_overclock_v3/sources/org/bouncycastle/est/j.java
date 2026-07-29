package org.bouncycastle.est;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.Map;
import org.bouncycastle.est.HttpUtil;

/* JADX INFO: loaded from: classes5.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final URL f44795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HttpUtil.Headers f44796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final byte[] f44797d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f44798e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f44799f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final o f44800g;

    public j(String str, URL url, byte[] bArr, i iVar, o oVar, HttpUtil.Headers headers, f fVar) {
        new HttpUtil.Headers();
        this.f44794a = str;
        this.f44795b = url;
        this.f44797d = bArr;
        this.f44798e = iVar;
        this.f44800g = oVar;
        this.f44796c = headers;
        this.f44799f = fVar;
    }

    public f a() {
        return this.f44799f;
    }

    public Map<String, String[]> b() {
        return (Map) this.f44796c.clone();
    }

    public i c() {
        return this.f44798e;
    }

    public o d() {
        return this.f44800g;
    }

    public String e() {
        return this.f44794a;
    }

    public URL f() {
        return this.f44795b;
    }

    public void g(OutputStream outputStream) throws IOException {
        byte[] bArr = this.f44797d;
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }
}
