package com.bumptech.glide.load.engine;

import g.n0;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements c4.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c4.b f12349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final c4.b f12350d;

    public c(c4.b bVar, c4.b bVar2) {
        this.f12349c = bVar;
        this.f12350d = bVar2;
    }

    @Override // c4.b
    public void a(@n0 MessageDigest messageDigest) {
        this.f12349c.a(messageDigest);
        this.f12350d.a(messageDigest);
    }

    public c4.b c() {
        return this.f12349c;
    }

    @Override // c4.b
    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f12349c.equals(cVar.f12349c) && this.f12350d.equals(cVar.f12350d);
    }

    @Override // c4.b
    public int hashCode() {
        return (this.f12349c.hashCode() * 31) + this.f12350d.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f12349c + ", signature=" + this.f12350d + '}';
    }
}
