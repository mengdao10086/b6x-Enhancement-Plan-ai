package com.flydigi.base.common;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.blankj.utilcode.util.j1;
import com.flydigi.base.R;
import g.n0;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"InflateParams"})
public class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @g.l
    public static int f13346a = Color.parseColor("#FFFFFF");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @g.l
    public static int f13347b = Color.parseColor("#D50000");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @g.l
    public static int f13348c = Color.parseColor("#3F51B5");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.l
    public static int f13349d = Color.parseColor("#388E3C");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @g.l
    public static int f13350e = Color.parseColor("#FFA900");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @g.l
    public static final int f13351f = Color.parseColor("#353A3E");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Typeface f13352g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Typeface f13353h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f13354i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static boolean f13355j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static Toast f13356k;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @g.l
        public int f13357a = o.f13346a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @g.l
        public int f13358b = o.f13347b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @g.l
        public int f13359c = o.f13348c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @g.l
        public int f13360d = o.f13349d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @g.l
        public int f13361e = o.f13350e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Typeface f13362f = o.f13353h;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f13363g = o.f13354i;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f13364h = o.f13355j;

        @g.j
        public static a b() {
            return new a();
        }

        public static void c() {
            int unused = o.f13346a = Color.parseColor("#FFFFFF");
            int unused2 = o.f13347b = Color.parseColor("#D50000");
            int unused3 = o.f13348c = Color.parseColor("#3F51B5");
            int unused4 = o.f13349d = Color.parseColor("#388E3C");
            int unused5 = o.f13350e = Color.parseColor("#FFA900");
            Typeface unused6 = o.f13353h = o.f13352g;
            int unused7 = o.f13354i = 16;
            boolean unused8 = o.f13355j = true;
        }

        public void a() {
            int unused = o.f13346a = this.f13357a;
            int unused2 = o.f13347b = this.f13358b;
            int unused3 = o.f13348c = this.f13359c;
            int unused4 = o.f13349d = this.f13360d;
            int unused5 = o.f13350e = this.f13361e;
            Typeface unused6 = o.f13353h = this.f13362f;
            int unused7 = o.f13354i = this.f13363g;
            boolean unused8 = o.f13355j = this.f13364h;
        }

        @g.j
        public a d(@g.l int i10) {
            this.f13358b = i10;
            return this;
        }

        @g.j
        public a e(@g.l int i10) {
            this.f13359c = i10;
            return this;
        }

        @g.j
        public a f(@g.l int i10) {
            this.f13360d = i10;
            return this;
        }

        @g.j
        public a g(@g.l int i10) {
            this.f13357a = i10;
            return this;
        }

        @g.j
        public a h(int i10) {
            this.f13363g = i10;
            return this;
        }

        @g.j
        public a i(@n0 Typeface typeface) {
            this.f13362f = typeface;
            return this;
        }

        @g.j
        public a j(@g.l int i10) {
            this.f13361e = i10;
            return this;
        }

        @g.j
        public a k(boolean z10) {
            this.f13364h = z10;
            return this;
        }
    }

    static {
        Typeface typefaceCreate = Typeface.create("sans-serif-condensed", 0);
        f13352g = typefaceCreate;
        f13353h = typefaceCreate;
        f13354i = 16;
        f13355j = true;
    }

    public o() {
        throw new UnsupportedOperationException("can't instantiate me...");
    }

    public static void A(@n0 CharSequence charSequence) {
        C(charSequence, 0, true);
    }

    public static void B(@n0 CharSequence charSequence, int i10) {
        C(charSequence, i10, true);
    }

    public static void C(@n0 CharSequence charSequence, int i10, boolean z10) {
        t(charSequence, s.a(j1.a(), R.drawable.ic_info_outline_white_48dp), f13348c, i10, z10, true);
    }

    public static void D() {
        I("没有更多啦", 0, null, false);
    }

    public static void E(@n0 CharSequence charSequence) {
        I(charSequence, 0, null, false);
    }

    public static void F(@n0 CharSequence charSequence, int i10) {
        I(charSequence, i10, null, false);
    }

    public static void G(@n0 CharSequence charSequence, int i10, int i11) {
        J(charSequence, i10, null, false, i11);
    }

    public static void H(@n0 CharSequence charSequence, int i10, Drawable drawable) {
        I(charSequence, i10, drawable, true);
    }

    public static void I(@n0 CharSequence charSequence, int i10, Drawable drawable, boolean z10) {
        J(charSequence, i10, drawable, z10, -1);
    }

    public static void J(@n0 CharSequence charSequence, int i10, Drawable drawable, boolean z10, int i11) {
        u(charSequence, drawable, f13351f, i10, z10, true, i11);
    }

    public static void K(@n0 CharSequence charSequence, Drawable drawable) {
        I(charSequence, 0, drawable, true);
    }

    public static void L(@n0 CharSequence charSequence) {
        I(charSequence, 1, null, false);
    }

    public static void M(View view, int i10) {
        Object objZ;
        Toast toast = f13356k;
        if (toast != null) {
            toast.cancel();
        }
        Toast toastMakeText = Toast.makeText(j1.a(), "", i10);
        f13356k = toastMakeText;
        toastMakeText.setView(view);
        try {
            Object objZ2 = z(f13356k, "mTN");
            if (objZ2 != null && (objZ = z(objZ2, "mParams")) != null && (objZ instanceof WindowManager.LayoutParams)) {
                WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) objZ;
                layoutParams.flags = 136;
                layoutParams.gravity = 17;
                layoutParams.width = -1;
                layoutParams.height = -2;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        f13356k.show();
    }

    public static void N(@n0 CharSequence charSequence) {
        P(charSequence, 0, true);
    }

    public static void O(@n0 CharSequence charSequence, int i10) {
        P(charSequence, i10, true);
    }

    public static void P(@n0 CharSequence charSequence, int i10, boolean z10) {
        t(charSequence, s.a(j1.a(), R.drawable.ic_check_white_48dp), f13349d, i10, z10, true);
    }

    public static void Q(@n0 CharSequence charSequence) {
        S(charSequence, 0, true);
    }

    public static void R(@n0 CharSequence charSequence, int i10) {
        S(charSequence, i10, true);
    }

    public static void S(@n0 CharSequence charSequence, int i10, boolean z10) {
        t(charSequence, s.a(j1.a(), R.drawable.ic_error_outline_white_48dp), f13350e, i10, z10, true);
    }

    public static void r() {
        Toast toast = f13356k;
        if (toast != null) {
            toast.cancel();
            f13356k = null;
        }
    }

    public static void s(@n0 CharSequence charSequence, @g.v int i10, @g.l int i11, int i12, boolean z10, boolean z11) {
        t(charSequence, s.a(j1.a(), i10), i11, i12, z10, z11);
    }

    public static void t(@n0 CharSequence charSequence, Drawable drawable, @g.l int i10, int i11, boolean z10, boolean z11) {
        u(charSequence, drawable, i10, i11, z10, z11, -1);
    }

    public static void u(@n0 CharSequence charSequence, Drawable drawable, @g.l int i10, int i11, boolean z10, boolean z11, int i12) {
        Toast toast = f13356k;
        if (toast != null) {
            toast.cancel();
        }
        f13356k = Toast.makeText(j1.a(), "", i11);
        View viewInflate = ((LayoutInflater) j1.a().getSystemService("layout_inflater")).inflate(R.layout.toast_layout, (ViewGroup) null);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.toast_icon);
        TextView textView = (TextView) viewInflate.findViewById(R.id.toast_text);
        s.b(viewInflate, z11 ? s.c(j1.a(), i10) : s.a(j1.a(), R.drawable.bg_toast));
        if (!z10) {
            imageView.setVisibility(8);
        } else {
            if (drawable == null) {
                throw new IllegalArgumentException("Avoid passing 'icon' as null if 'withIcon' is set to true");
            }
            if (f13355j) {
                drawable = s.d(drawable, f13346a);
            }
            s.b(imageView, drawable);
        }
        textView.setText(charSequence);
        textView.setTextColor(f13346a);
        textView.setTypeface(f13353h);
        textView.setTextSize(2, f13354i);
        if (i12 != -1) {
            f13356k.setGravity(i12, 0, 0);
        }
        f13356k.setView(viewInflate);
        f13356k.show();
    }

    public static void v(@n0 CharSequence charSequence, Drawable drawable, int i10, boolean z10) {
        t(charSequence, drawable, -1, i10, z10, false);
    }

    public static void w(@n0 CharSequence charSequence) {
        y(charSequence, 0, true);
    }

    public static void x(@n0 CharSequence charSequence, int i10) {
        y(charSequence, i10, true);
    }

    public static void y(@n0 CharSequence charSequence, int i10, boolean z10) {
        t(charSequence, s.a(j1.a(), R.drawable.ic_clear_white_48dp), f13347b, i10, z10, true);
    }

    public static Object z(Object obj, String str) throws IllegalAccessException, NoSuchFieldException {
        Field declaredField = obj.getClass().getDeclaredField(str);
        if (declaredField == null) {
            return null;
        }
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }
}
