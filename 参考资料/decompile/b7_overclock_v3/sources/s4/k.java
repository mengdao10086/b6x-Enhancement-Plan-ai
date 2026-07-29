package s4;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    @n0
    public <Z> r<ImageView, Z> a(@n0 ImageView imageView, @n0 Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new c(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new g(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
