package com.bumptech.glide.load.engine;

import g.n0;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class l implements c4.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f12444c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f12445d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f12446e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Class<?> f12447f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Class<?> f12448g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final c4.b f12449h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<Class<?>, c4.h<?>> f12450i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c4.e f12451j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f12452k;

    public l(Object obj, c4.b bVar, int i10, int i11, Map<Class<?>, c4.h<?>> map, Class<?> cls, Class<?> cls2, c4.e eVar) {
        this.f12444c = v4.m.d(obj);
        this.f12449h = (c4.b) v4.m.e(bVar, "Signature must not be null");
        this.f12445d = i10;
        this.f12446e = i11;
        this.f12450i = (Map) v4.m.d(map);
        this.f12447f = (Class) v4.m.e(cls, "Resource class must not be null");
        this.f12448g = (Class) v4.m.e(cls2, "Transcode class must not be null");
        this.f12451j = (c4.e) v4.m.d(eVar);
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f12444c.equals(lVar.f12444c) && this.f12449h.equals(lVar.f12449h) && this.f12446e == lVar.f12446e && this.f12445d == lVar.f12445d && this.f12450i.equals(lVar.f12450i) && this.f12447f.equals(lVar.f12447f) && this.f12448g.equals(lVar.f12448g) && this.f12451j.equals(lVar.f12451j);
    }

    @Override // c4.b
    public int hashCode() {
        if (this.f12452k == 0) {
            int iHashCode = this.f12444c.hashCode();
            this.f12452k = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.f12449h.hashCode()) * 31) + this.f12445d) * 31) + this.f12446e;
            this.f12452k = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.f12450i.hashCode();
            this.f12452k = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.f12447f.hashCode();
            this.f12452k = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f12448g.hashCode();
            this.f12452k = iHashCode5;
            this.f12452k = (iHashCode5 * 31) + this.f12451j.hashCode();
        }
        return this.f12452k;
    }

    public String toString() {
        return "EngineKey{model=" + this.f12444c + ", width=" + this.f12445d + ", height=" + this.f12446e + ", resourceClass=" + this.f12447f + ", transcodeClass=" + this.f12448g + ", signature=" + this.f12449h + ", hashCode=" + this.f12452k + ", transformations=" + this.f12450i + ", options=" + this.f12451j + '}';
    }
}
