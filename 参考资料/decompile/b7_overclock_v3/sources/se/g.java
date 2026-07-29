package se;

import android.graphics.RectF;

/* JADX INFO: loaded from: classes7.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f49714a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f49715b = new b();

    public class a implements f {
        @Override // se.f
        public h a(float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
            float fM = u.m(f13, f15, f11, f12, f10, true);
            float f17 = fM / f13;
            float f18 = fM / f15;
            return new h(f17, f18, fM, f14 * f17, fM, f16 * f18);
        }

        @Override // se.f
        public void b(RectF rectF, float f10, h hVar) {
            rectF.bottom -= Math.abs(hVar.f49721f - hVar.f49719d) * f10;
        }

        @Override // se.f
        public boolean c(h hVar) {
            return hVar.f49719d > hVar.f49721f;
        }
    }

    public class b implements f {
        @Override // se.f
        public h a(float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
            float fM = u.m(f14, f16, f11, f12, f10, true);
            float f17 = fM / f14;
            float f18 = fM / f16;
            return new h(f17, f18, f13 * f17, fM, f15 * f18, fM);
        }

        @Override // se.f
        public void b(RectF rectF, float f10, h hVar) {
            float fAbs = (Math.abs(hVar.f49720e - hVar.f49718c) / 2.0f) * f10;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }

        @Override // se.f
        public boolean c(h hVar) {
            return hVar.f49718c > hVar.f49720e;
        }
    }

    public static f a(int i10, boolean z10, RectF rectF, RectF rectF2) {
        if (i10 == 0) {
            return b(z10, rectF, rectF2) ? f49714a : f49715b;
        }
        if (i10 == 1) {
            return f49714a;
        }
        if (i10 == 2) {
            return f49715b;
        }
        throw new IllegalArgumentException("Invalid fit mode: " + i10);
    }

    public static boolean b(boolean z10, RectF rectF, RectF rectF2) {
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        float fWidth2 = rectF2.width();
        float fHeight2 = rectF2.height();
        float f10 = (fHeight2 * fWidth) / fWidth2;
        float f11 = (fWidth2 * fHeight) / fWidth;
        if (z10) {
            if (f10 >= fHeight) {
                return true;
            }
        } else if (f11 >= fHeight2) {
            return true;
        }
        return false;
    }
}
