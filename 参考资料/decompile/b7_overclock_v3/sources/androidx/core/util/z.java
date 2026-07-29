package androidx.core.util;

import android.util.SizeF;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f4780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f4781b;

    @v0(21)
    public static final class a {
        @g.u
        @n0
        public static SizeF a(@n0 z zVar) {
            o.l(zVar);
            return new SizeF(zVar.b(), zVar.a());
        }

        @g.u
        @n0
        public static z b(@n0 SizeF sizeF) {
            o.l(sizeF);
            return new z(sizeF.getWidth(), sizeF.getHeight());
        }
    }

    public z(float f10, float f11) {
        this.f4780a = o.d(f10, SocializeProtocolConstants.WIDTH);
        this.f4781b = o.d(f11, SocializeProtocolConstants.HEIGHT);
    }

    @n0
    @v0(21)
    public static z d(@n0 SizeF sizeF) {
        return a.b(sizeF);
    }

    public float a() {
        return this.f4781b;
    }

    public float b() {
        return this.f4780a;
    }

    @n0
    @v0(21)
    public SizeF c() {
        return a.a(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return zVar.f4780a == this.f4780a && zVar.f4781b == this.f4781b;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f4780a) ^ Float.floatToIntBits(this.f4781b);
    }

    @n0
    public String toString() {
        return this.f4780a + "x" + this.f4781b;
    }
}
