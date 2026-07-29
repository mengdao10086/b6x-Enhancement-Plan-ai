package s4;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class g extends j<Drawable> {
    public g(ImageView imageView) {
        super(imageView);
    }

    @Override // s4.j
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void x(@p0 Drawable drawable) {
        ((ImageView) this.f49503b).setImageDrawable(drawable);
    }

    @Deprecated
    public g(ImageView imageView, boolean z10) {
        super(imageView, z10);
    }
}
