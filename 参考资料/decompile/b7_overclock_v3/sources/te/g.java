package te;

import android.graphics.RectF;
import g.v0;

/* JADX INFO: loaded from: classes7.dex */
@v0(21)
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f51105a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f51106b = new b();

    public class a implements f {
        @Override // te.f
        public h a(float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
            float fM = v.m(f13, f15, f11, f12, f10, true);
            float f17 = fM / f13;
            float f18 = fM / f15;
            return new h(f17, f18, fM, f14 * f17, fM, f16 * f18);
        }

        @Override // te.f
        public void b(RectF rectF, float f10, h hVar) {
            rectF.bottom -= Math.abs(hVar.f51112f - hVar.f51110d) * f10;
        }

        @Override // te.f
        public boolean c(h hVar) {
            return hVar.f51110d > hVar.f51112f;
        }
    }

    public class b implements f {
        @Override // te.f
        public h a(float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
            float fM = v.m(f14, f16, f11, f12, f10, true);
            float f17 = fM / f14;
            float f18 = fM / f16;
            return new h(f17, f18, f13 * f17, fM, f15 * f18, fM);
        }

        @Override // te.f
        public void b(RectF rectF, float f10, h hVar) {
            float fAbs = (Math.abs(hVar.f51111e - hVar.f51109c) / 2.0f) * f10;
            rectF.left += fAbs;
            rectF.right -= fAbs;
        }

        @Override // te.f
        public boolean c(h hVar) {
            return hVar.f51109c > hVar.f51111e;
        }
    }

    public static f a(int i10, boolean z10, RectF rectF, RectF rectF2) {
        if (i10 == 0) {
            return b(z10, rectF, rectF2) ? f51105a : f51106b;
        }
        if (i10 == 1) {
            return f51105a;
        }
        if (i10 == 2) {
            return f51106b;
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
