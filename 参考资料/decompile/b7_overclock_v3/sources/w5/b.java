package w5;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.h;

/* JADX INFO: loaded from: classes2.dex */
public class b implements qh.a {
    @Override // qh.a
    public void a(Context context, int i10, int i11, ImageView imageView, Uri uri) {
        com.bumptech.glide.b.E(context).e(uri).a(new h().D0(i10, i11).G0(Priority.HIGH).C()).s1(imageView);
    }

    @Override // qh.a
    public boolean b() {
        return true;
    }

    @Override // qh.a
    public void c(Context context, int i10, int i11, ImageView imageView, Uri uri) {
        com.bumptech.glide.b.E(context).A().e(uri).a(new h().D0(i10, i11).G0(Priority.HIGH).C()).s1(imageView);
    }

    @Override // qh.a
    public void d(Context context, int i10, Drawable drawable, ImageView imageView, Uri uri) {
        com.bumptech.glide.b.E(context).x().e(uri).a(new h().D0(i10, i10).F0(drawable).c()).s1(imageView);
    }

    @Override // qh.a
    public void e(Context context, int i10, Drawable drawable, ImageView imageView, Uri uri) {
        com.bumptech.glide.b.E(context).x().e(uri).a(new h().D0(i10, i10).F0(drawable).c()).s1(imageView);
    }
}
