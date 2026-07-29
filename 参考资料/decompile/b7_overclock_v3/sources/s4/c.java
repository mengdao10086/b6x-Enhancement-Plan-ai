package s4;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class c extends j<Bitmap> {
    public c(ImageView imageView) {
        super(imageView);
    }

    @Override // s4.j
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public void x(Bitmap bitmap) {
        ((ImageView) this.f49503b).setImageBitmap(bitmap);
    }

    @Deprecated
    public c(ImageView imageView, boolean z10) {
        super(imageView, z10);
    }
}
