package com.bumptech.glide.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.google.common.collect.LinkedHashMultimap;
import g.f0;
import g.n0;
import g.p0;
import g.v;
import g.x;

/* JADX INFO: loaded from: classes2.dex */
public class h extends a<h> {

    @p0
    public static h M7;

    @p0
    public static h N7;

    @p0
    public static h O7;

    @p0
    public static h P7;

    @p0
    public static h Q7;

    @p0
    public static h R7;

    @p0
    public static h S7;

    @p0
    public static h T7;

    @g.j
    @n0
    public static h a1(@n0 c4.h<Bitmap> hVar) {
        return new h().R0(hVar);
    }

    @g.j
    @n0
    public static h b1() {
        if (Q7 == null) {
            Q7 = new h().c().b();
        }
        return Q7;
    }

    @g.j
    @n0
    public static h c1() {
        if (P7 == null) {
            P7 = new h().f().b();
        }
        return P7;
    }

    @g.j
    @n0
    public static h d1() {
        if (R7 == null) {
            R7 = new h().g().b();
        }
        return R7;
    }

    @g.j
    @n0
    public static h e1(@n0 Class<?> cls) {
        return new h().m(cls);
    }

    @g.j
    @n0
    public static h f1(@n0 com.bumptech.glide.load.engine.h hVar) {
        return new h().q(hVar);
    }

    @g.j
    @n0
    public static h g1(@n0 DownsampleStrategy downsampleStrategy) {
        return new h().u(downsampleStrategy);
    }

    @g.j
    @n0
    public static h h1(@n0 Bitmap.CompressFormat compressFormat) {
        return new h().v(compressFormat);
    }

    @g.j
    @n0
    public static h i1(@f0(from = 0, to = 100) int i10) {
        return new h().w(i10);
    }

    @g.j
    @n0
    public static h j1(@v int i10) {
        return new h().x(i10);
    }

    @g.j
    @n0
    public static h k1(@p0 Drawable drawable) {
        return new h().y(drawable);
    }

    @g.j
    @n0
    public static h l1() {
        if (O7 == null) {
            O7 = new h().C().b();
        }
        return O7;
    }

    @g.j
    @n0
    public static h m1(@n0 DecodeFormat decodeFormat) {
        return new h().D(decodeFormat);
    }

    @g.j
    @n0
    public static h n1(@f0(from = 0) long j10) {
        return new h().E(j10);
    }

    @g.j
    @n0
    public static h o1() {
        if (T7 == null) {
            T7 = new h().r().b();
        }
        return T7;
    }

    @g.j
    @n0
    public static h p1() {
        if (S7 == null) {
            S7 = new h().s().b();
        }
        return S7;
    }

    @g.j
    @n0
    public static <T> h q1(@n0 c4.d<T> dVar, @n0 T t10) {
        return new h().L0(dVar, t10);
    }

    @g.j
    @n0
    public static h r1(int i10) {
        return s1(i10, i10);
    }

    @g.j
    @n0
    public static h s1(int i10, int i11) {
        return new h().D0(i10, i11);
    }

    @g.j
    @n0
    public static h t1(@v int i10) {
        return new h().E0(i10);
    }

    @g.j
    @n0
    public static h u1(@p0 Drawable drawable) {
        return new h().F0(drawable);
    }

    @g.j
    @n0
    public static h v1(@n0 Priority priority) {
        return new h().G0(priority);
    }

    @g.j
    @n0
    public static h w1(@n0 c4.b bVar) {
        return new h().M0(bVar);
    }

    @g.j
    @n0
    public static h x1(@x(from = 0.0d, to = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR) float f10) {
        return new h().N0(f10);
    }

    @g.j
    @n0
    public static h y1(boolean z10) {
        if (z10) {
            if (M7 == null) {
                M7 = new h().O0(true).b();
            }
            return M7;
        }
        if (N7 == null) {
            N7 = new h().O0(false).b();
        }
        return N7;
    }

    @g.j
    @n0
    public static h z1(@f0(from = 0) int i10) {
        return new h().Q0(i10);
    }
}
