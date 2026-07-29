package ic;

import g.p0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f32058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f32059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final String f32060c;

    public d(String str, @p0 String str2, @p0 String str3) {
        this.f32058a = str;
        this.f32059b = str2;
        this.f32060c = str3;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return u0.c(this.f32058a, dVar.f32058a) && u0.c(this.f32059b, dVar.f32059b) && u0.c(this.f32060c, dVar.f32060c);
    }

    public int hashCode() {
        int iHashCode = this.f32058a.hashCode() * 31;
        String str = this.f32059b;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f32060c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }
}
