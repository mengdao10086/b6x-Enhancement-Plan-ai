package s4;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class q<T> extends j<T> {
    public q(ImageView imageView) {
        super(imageView);
    }

    @Override // s4.j
    public void x(@p0 T t10) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.f49503b).getLayoutParams();
        Drawable drawableZ = z(t10);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            drawableZ = new i(drawableZ, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.f49503b).setImageDrawable(drawableZ);
    }

    public abstract Drawable z(T t10);

    @Deprecated
    public q(ImageView imageView, boolean z10) {
        super(imageView, z10);
    }
}
