package org.bouncycastle.est;

import java.net.URL;
import org.bouncycastle.est.HttpUtil;

/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f44801a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public URL f44802b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HttpUtil.Headers f44803c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f44804d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public o f44805e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f44806f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public byte[] f44807g;

    public k(String str, URL url) {
        this.f44801a = str;
        this.f44802b = url;
        this.f44803c = new HttpUtil.Headers();
    }

    public k(j jVar) {
        this.f44801a = jVar.f44794a;
        this.f44802b = jVar.f44795b;
        this.f44805e = jVar.f44800g;
        this.f44807g = jVar.f44797d;
        this.f44804d = jVar.f44798e;
        this.f44803c = (HttpUtil.Headers) jVar.f44796c.clone();
        this.f44806f = jVar.a();
    }

    public k a(String str, String str2) {
        this.f44803c.b(str, str2);
        return this;
    }

    public j b() {
        return new j(this.f44801a, this.f44802b, this.f44807g, this.f44804d, this.f44805e, this.f44803c, this.f44806f);
    }

    public k c(String str, String str2) {
        this.f44803c.m(str, str2);
        return this;
    }

    public k d(f fVar) {
        this.f44806f = fVar;
        return this;
    }

    public k e(o oVar) {
        this.f44805e = oVar;
        return this;
    }

    public k f(byte[] bArr) {
        this.f44807g = org.bouncycastle.util.a.p(bArr);
        return this;
    }

    public k g(i iVar) {
        this.f44804d = iVar;
        return this;
    }

    public k h(URL url) {
        this.f44802b = url;
        return this;
    }
}
