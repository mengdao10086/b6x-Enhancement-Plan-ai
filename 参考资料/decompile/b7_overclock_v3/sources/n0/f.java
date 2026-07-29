package n0;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import g.n0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@v0(21)
public class f extends g {
    public f(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    @Override // n0.g
    public void f(int i10, int i11, int i12, Rect rect, Rect rect2) {
        Gravity.apply(i10, i11, i12, rect, rect2, 0);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(@n0 Outline outline) {
        t();
        outline.setRoundRect(this.f41728h, c());
    }

    @Override // n0.g
    public boolean h() {
        Bitmap bitmap = this.f41721a;
        return bitmap != null && bitmap.hasMipMap();
    }

    @Override // n0.g
    public void o(boolean z10) {
        Bitmap bitmap = this.f41721a;
        if (bitmap != null) {
            bitmap.setHasMipMap(z10);
            invalidateSelf();
        }
    }
}
