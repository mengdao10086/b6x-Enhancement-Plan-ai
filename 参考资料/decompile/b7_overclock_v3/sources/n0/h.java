package n0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import g.n0;
import g.p0;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f41734a = "RoundedBitmapDrawableFa";

    public static class a extends g {
        public a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        @Override // n0.g
        public void f(int i10, int i11, int i12, Rect rect, Rect rect2) {
            androidx.core.view.m.b(i10, i11, i12, rect, rect2, 0);
        }

        @Override // n0.g
        public boolean h() {
            Bitmap bitmap = this.f41721a;
            return bitmap != null && m0.a.c(bitmap);
        }

        @Override // n0.g
        public void o(boolean z10) {
            Bitmap bitmap = this.f41721a;
            if (bitmap != null) {
                m0.a.d(bitmap, z10);
                invalidateSelf();
            }
        }
    }

    @n0
    public static g a(@n0 Resources resources, @p0 Bitmap bitmap) {
        return new f(resources, bitmap);
    }

    @n0
    public static g b(@n0 Resources resources, @n0 InputStream inputStream) {
        g gVarA = a(resources, BitmapFactory.decodeStream(inputStream));
        if (gVarA.b() == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("RoundedBitmapDrawable cannot decode ");
            sb2.append(inputStream);
        }
        return gVarA;
    }

    @n0
    public static g c(@n0 Resources resources, @n0 String str) {
        g gVarA = a(resources, BitmapFactory.decodeFile(str));
        if (gVarA.b() == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("RoundedBitmapDrawable cannot decode ");
            sb2.append(str);
        }
        return gVarA;
    }
}
