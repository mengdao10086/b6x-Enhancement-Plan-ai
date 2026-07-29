package xa;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import xa.h;

/* JADX INFO: loaded from: classes3.dex */
public class g extends h.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static h<g> f54985e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Parcelable.Creator<g> f54986f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f54987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f54988d;

    public static class a implements Parcelable.Creator<g> {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(Parcel parcel) {
            g gVar = new g(0.0f, 0.0f);
            gVar.g(parcel);
            return gVar;
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i10) {
            return new g[i10];
        }
    }

    static {
        h<g> hVarA = h.a(32, new g(0.0f, 0.0f));
        f54985e = hVarA;
        hVarA.l(0.5f);
        f54986f = new a();
    }

    public g() {
    }

    public static g b() {
        return (g) f54985e.b();
    }

    public static g c(float f10, float f11) {
        g gVar = (g) f54985e.b();
        gVar.f54987c = f10;
        gVar.f54988d = f11;
        return gVar;
    }

    public static g d(g gVar) {
        g gVar2 = (g) f54985e.b();
        gVar2.f54987c = gVar.f54987c;
        gVar2.f54988d = gVar.f54988d;
        return gVar2;
    }

    public static void h(g gVar) {
        f54985e.h(gVar);
    }

    public static void i(List<g> list) {
        f54985e.g(list);
    }

    @Override // xa.h.a
    public h.a a() {
        return new g(0.0f, 0.0f);
    }

    public float e() {
        return this.f54987c;
    }

    public float f() {
        return this.f54988d;
    }

    public void g(Parcel parcel) {
        this.f54987c = parcel.readFloat();
        this.f54988d = parcel.readFloat();
    }

    public g(float f10, float f11) {
        this.f54987c = f10;
        this.f54988d = f11;
    }
}
