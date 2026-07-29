package rh;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/* JADX INFO: loaded from: classes5.dex */
public class b implements qh.a {
    @Override // qh.a
    public void a(Context context, int i10, int i11, ImageView imageView, Uri uri) {
        Picasso.with(context).load(uri).resize(i10, i11).priority(Picasso.Priority.HIGH).centerInside().into(imageView);
    }

    @Override // qh.a
    public boolean b() {
        return false;
    }

    @Override // qh.a
    public void c(Context context, int i10, int i11, ImageView imageView, Uri uri) {
        a(context, i10, i11, imageView, uri);
    }

    @Override // qh.a
    public void d(Context context, int i10, Drawable drawable, ImageView imageView, Uri uri) {
        Picasso.with(context).load(uri).placeholder(drawable).resize(i10, i10).centerCrop().into(imageView);
    }

    @Override // qh.a
    public void e(Context context, int i10, Drawable drawable, ImageView imageView, Uri uri) {
        d(context, i10, drawable, imageView, uri);
    }
}
