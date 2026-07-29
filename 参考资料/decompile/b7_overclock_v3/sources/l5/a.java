package l5;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.request.h;
import com.flydigi.base.R;

/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f39455a;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f39456a = new a();
    }

    public static a b() {
        return b.f39456a;
    }

    public void a(Context context) {
        com.bumptech.glide.b.e(context).c();
    }

    public void c(Activity activity, ImageView imageView, int i10) {
        com.bumptech.glide.b.C(activity).B(imageView);
        com.bumptech.glide.b.C(activity).Y(this.f39455a).p(Integer.valueOf(i10)).s1(imageView);
    }

    public void d(Activity activity, ImageView imageView, String str) {
        com.bumptech.glide.b.C(activity).B(imageView);
        com.bumptech.glide.b.C(activity).Y(this.f39455a).t(str).s1(imageView);
    }

    public void e(Context context, ImageView imageView, int i10) {
        com.bumptech.glide.b.E(context).B(imageView);
        com.bumptech.glide.b.E(context).Y(this.f39455a).p(Integer.valueOf(i10)).s1(imageView);
    }

    public void f(Context context, ImageView imageView, String str) {
        com.bumptech.glide.b.E(context).B(imageView);
        com.bumptech.glide.b.E(context).Y(this.f39455a).t(str).s1(imageView);
    }

    public void g(View view, ImageView imageView, int i10) {
        com.bumptech.glide.b.F(view).B(imageView);
        com.bumptech.glide.b.F(view).Y(this.f39455a).p(Integer.valueOf(i10)).s1(imageView);
    }

    public void h(View view, ImageView imageView, String str) {
        com.bumptech.glide.b.F(view).B(imageView);
        com.bumptech.glide.b.F(view).Y(this.f39455a).t(str).s1(imageView);
    }

    public void i(Fragment fragment, ImageView imageView, int i10) {
        com.bumptech.glide.b.G(fragment).B(imageView);
        com.bumptech.glide.b.G(fragment).Y(this.f39455a).p(Integer.valueOf(i10)).s1(imageView);
    }

    public void j(Fragment fragment, ImageView imageView, String str) {
        com.bumptech.glide.b.G(fragment).B(imageView);
        com.bumptech.glide.b.G(fragment).Y(this.f39455a).t(str).s1(imageView);
    }

    public void k(Context context) {
        com.bumptech.glide.b.e(context).onLowMemory();
    }

    public void l(Context context, int i10) {
        com.bumptech.glide.b.e(context).A(i10);
    }

    public a() {
        this.f39455a = new h().f().E0(R.drawable.ic_place_holder);
    }
}
