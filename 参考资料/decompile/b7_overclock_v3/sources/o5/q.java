package o5;

import android.view.animation.RotateAnimation;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    public static void a(ImageView imageView, boolean z10) {
        if (imageView == null) {
            return;
        }
        float width = imageView.getWidth() / 2.0f;
        float height = imageView.getHeight() / 2.0f;
        float f10 = 180.0f;
        float f11 = 0.0f;
        if (!z10) {
            f10 = 0.0f;
            f11 = 180.0f;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(f10, f11, width, height);
        rotateAnimation.setDuration(300L);
        rotateAnimation.setFillAfter(true);
        imageView.startAnimation(rotateAnimation);
    }
}
