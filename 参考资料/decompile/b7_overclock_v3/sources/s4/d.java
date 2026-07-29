package s4;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class d extends q<Bitmap> {
    public d(ImageView imageView) {
        super(imageView);
    }

    @Override // s4.q
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public Drawable z(Bitmap bitmap) {
        return new BitmapDrawable(((ImageView) this.f49503b).getResources(), bitmap);
    }

    @Deprecated
    public d(ImageView imageView, boolean z10) {
        super(imageView, z10);
    }
}
