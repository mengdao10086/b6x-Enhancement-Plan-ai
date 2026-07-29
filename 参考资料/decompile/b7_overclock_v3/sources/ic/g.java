package ic;

import g.p0;
import hd.u0;

/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @p0
    public final String f32071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @p0
    public final String f32072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    public final String f32073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    public final String f32074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final String f32075e;

    public g(@p0 String str, @p0 String str2, @p0 String str3, @p0 String str4, @p0 String str5) {
        this.f32071a = str;
        this.f32072b = str2;
        this.f32073c = str3;
        this.f32074d = str4;
        this.f32075e = str5;
    }

    public boolean equals(@p0 Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return u0.c(this.f32071a, gVar.f32071a) && u0.c(this.f32072b, gVar.f32072b) && u0.c(this.f32073c, gVar.f32073c) && u0.c(this.f32074d, gVar.f32074d) && u0.c(this.f32075e, gVar.f32075e);
    }

    public int hashCode() {
        String str = this.f32071a;
        int iHashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f32072b;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f32073c;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.f32074d;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.f32075e;
        return iHashCode4 + (str5 != null ? str5.hashCode() : 0);
    }
}
