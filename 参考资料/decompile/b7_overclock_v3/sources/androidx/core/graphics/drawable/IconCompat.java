package androidx.core.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.RestrictTo;
import androidx.core.util.j;
import androidx.core.util.o;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.blankj.utilcode.util.i0;
import g.d0;
import g.i1;
import g.l;
import g.n0;
import g.p0;
import g.u;
import g.v;
import g.v0;
import j0.i;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import l4.f;
import o5.h;
import ya.g;

/* JADX INFO: loaded from: classes2.dex */
public class IconCompat extends CustomVersionedParcelable {

    @i1
    public static final String A = "obj";

    @i1
    public static final String B = "int1";

    @i1
    public static final String C = "int2";

    @i1
    public static final String D = "tint_list";

    @i1
    public static final String E = "tint_mode";

    @i1
    public static final String F = "string1";
    public static final PorterDuff.Mode G = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f4613k = "IconCompat";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f4614l = -1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f4615m = 1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f4616n = 2;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f4617o = 3;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f4618p = 4;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f4619q = 5;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f4620r = 6;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final float f4621s = 0.25f;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final float f4622t = 0.6666667f;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final float f4623u = 0.9166667f;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final float f4624v = 0.010416667f;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final float f4625w = 0.020833334f;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f4626x = 61;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f4627y = 30;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @i1
    public static final String f4628z = "type";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int f4629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f4630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public byte[] f4631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Parcelable f4632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int f4633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int f4634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public ColorStateList f4635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public PorterDuff.Mode f4636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String f4637i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public String f4638j;

    @v0(23)
    public static class a {
        @p0
        public static IconCompat a(@n0 Context context, @n0 Icon icon) {
            int iE = e(icon);
            if (iE == 2) {
                String strD = d(icon);
                try {
                    return IconCompat.y(IconCompat.C(context, strD), strD, c(icon));
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            }
            if (iE == 4) {
                return IconCompat.u(f(icon));
            }
            if (iE == 6) {
                return IconCompat.r(f(icon));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f4630b = icon;
            return iconCompat;
        }

        public static IconCompat b(@n0 Object obj) {
            o.l(obj);
            int iE = e(obj);
            if (iE == 2) {
                return IconCompat.y(null, d(obj), c(obj));
            }
            if (iE == 4) {
                return IconCompat.u(f(obj));
            }
            if (iE == 6) {
                return IconCompat.r(f(obj));
            }
            IconCompat iconCompat = new IconCompat(-1);
            iconCompat.f4630b = obj;
            return iconCompat;
        }

        @d0
        @v
        public static int c(@n0 Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return 0;
            }
        }

        @p0
        public static String d(@n0 Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }

        public static int e(@n0 Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to get icon type ");
                sb2.append(obj);
                return -1;
            } catch (NoSuchMethodException unused2) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unable to get icon type ");
                sb3.append(obj);
                return -1;
            } catch (InvocationTargetException unused3) {
                StringBuilder sb4 = new StringBuilder();
                sb4.append("Unable to get icon type ");
                sb4.append(obj);
                return -1;
            }
        }

        @u
        @p0
        public static Uri f(@n0 Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return null;
            }
        }

        @u
        public static Drawable g(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        @u
        public static Icon h(IconCompat iconCompat, Context context) {
            Icon iconCreateWithBitmap;
            switch (iconCompat.f4629a) {
                case -1:
                    return (Icon) iconCompat.f4630b;
                case 0:
                default:
                    throw new IllegalArgumentException("Unknown type");
                case 1:
                    iconCreateWithBitmap = Icon.createWithBitmap((Bitmap) iconCompat.f4630b);
                    break;
                case 2:
                    iconCreateWithBitmap = Icon.createWithResource(iconCompat.B(), iconCompat.f4633e);
                    break;
                case 3:
                    iconCreateWithBitmap = Icon.createWithData((byte[]) iconCompat.f4630b, iconCompat.f4633e, iconCompat.f4634f);
                    break;
                case 4:
                    iconCreateWithBitmap = Icon.createWithContentUri((String) iconCompat.f4630b);
                    break;
                case 5:
                    iconCreateWithBitmap = Build.VERSION.SDK_INT < 26 ? Icon.createWithBitmap(IconCompat.p((Bitmap) iconCompat.f4630b, false)) : b.b((Bitmap) iconCompat.f4630b);
                    break;
                case 6:
                    int i10 = Build.VERSION.SDK_INT;
                    if (i10 >= 30) {
                        iconCreateWithBitmap = d.a(iconCompat.E());
                    } else {
                        if (context == null) {
                            throw new IllegalArgumentException("Context is required to resolve the file uri of the icon: " + iconCompat.E());
                        }
                        InputStream inputStreamF = iconCompat.F(context);
                        if (inputStreamF == null) {
                            throw new IllegalStateException("Cannot load adaptive icon from uri: " + iconCompat.E());
                        }
                        if (i10 < 26) {
                            iconCreateWithBitmap = Icon.createWithBitmap(IconCompat.p(BitmapFactory.decodeStream(inputStreamF), false));
                        } else {
                            iconCreateWithBitmap = b.b(BitmapFactory.decodeStream(inputStreamF));
                        }
                    }
                    break;
            }
            ColorStateList colorStateList = iconCompat.f4635g;
            if (colorStateList != null) {
                iconCreateWithBitmap.setTintList(colorStateList);
            }
            PorterDuff.Mode mode = iconCompat.f4636h;
            if (mode != IconCompat.G) {
                iconCreateWithBitmap.setTintMode(mode);
            }
            return iconCreateWithBitmap;
        }
    }

    @v0(26)
    public static class b {
        @u
        public static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        @u
        public static Icon b(Bitmap bitmap) {
            return Icon.createWithAdaptiveBitmap(bitmap);
        }
    }

    @v0(28)
    public static class c {
        @u
        public static int a(Object obj) {
            return ((Icon) obj).getResId();
        }

        @u
        public static String b(Object obj) {
            return ((Icon) obj).getResPackage();
        }

        @u
        public static int c(Object obj) {
            return ((Icon) obj).getType();
        }

        @u
        public static Uri d(Object obj) {
            return ((Icon) obj).getUri();
        }
    }

    @v0(30)
    public static class d {
        @u
        public static Icon a(Uri uri) {
            return Icon.createWithAdaptiveBitmapContentUri(uri);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public @interface e {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public IconCompat() {
        this.f4629a = -1;
        this.f4631c = null;
        this.f4632d = null;
        this.f4633e = 0;
        this.f4634f = 0;
        this.f4635g = null;
        this.f4636h = G;
        this.f4637i = null;
    }

    public static Resources C(Context context, String str) {
        if (f.f39447b.equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 8192);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            String.format("Unable to find pkg=%s for icon", str);
            return null;
        }
    }

    public static String O(int i10) {
        switch (i10) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return h.f42757n;
        }
    }

    @p0
    public static IconCompat l(@n0 Bundle bundle) {
        int i10 = bundle.getInt("type");
        IconCompat iconCompat = new IconCompat(i10);
        iconCompat.f4633e = bundle.getInt(B);
        iconCompat.f4634f = bundle.getInt(C);
        iconCompat.f4638j = bundle.getString(F);
        if (bundle.containsKey(D)) {
            iconCompat.f4635g = (ColorStateList) bundle.getParcelable(D);
        }
        if (bundle.containsKey(E)) {
            iconCompat.f4636h = PorterDuff.Mode.valueOf(bundle.getString(E));
        }
        switch (i10) {
            case -1:
            case 1:
            case 5:
                iconCompat.f4630b = bundle.getParcelable("obj");
                return iconCompat;
            case 0:
            default:
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unknown type ");
                sb2.append(i10);
                return null;
            case 2:
            case 4:
            case 6:
                iconCompat.f4630b = bundle.getString("obj");
                return iconCompat;
            case 3:
                iconCompat.f4630b = bundle.getByteArray("obj");
                return iconCompat;
        }
    }

    @p0
    @v0(23)
    public static IconCompat m(@n0 Context context, @n0 Icon icon) {
        o.l(icon);
        return a.a(context, icon);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @v0(23)
    public static IconCompat n(@n0 Icon icon) {
        return a.b(icon);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @v0(23)
    public static IconCompat o(@n0 Icon icon) {
        if (a.e(icon) == 2 && a.c(icon) == 0) {
            return null;
        }
        return a.b(icon);
    }

    @i1
    public static Bitmap p(Bitmap bitmap, boolean z10) {
        int iMin = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(3);
        float f10 = iMin;
        float f11 = 0.5f * f10;
        float f12 = 0.9166667f * f11;
        if (z10) {
            float f13 = 0.010416667f * f10;
            paint.setColor(0);
            paint.setShadowLayer(f13, 0.0f, f10 * 0.020833334f, androidx.swiperefreshlayout.widget.a.f7730e);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.setShadowLayer(f13, 0.0f, 0.0f, androidx.swiperefreshlayout.widget.a.f7731f);
            canvas.drawCircle(f11, f11, f12, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - iMin)) / 2.0f, (-(bitmap.getHeight() - iMin)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f11, f11, f12, paint);
        canvas.setBitmap(null);
        return bitmapCreateBitmap;
    }

    @n0
    public static IconCompat q(@n0 Bitmap bitmap) {
        j.d(bitmap);
        IconCompat iconCompat = new IconCompat(5);
        iconCompat.f4630b = bitmap;
        return iconCompat;
    }

    @n0
    public static IconCompat r(@n0 Uri uri) {
        j.d(uri);
        return s(uri.toString());
    }

    @n0
    public static IconCompat s(@n0 String str) {
        j.d(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f4630b = str;
        return iconCompat;
    }

    @n0
    public static IconCompat t(@n0 Bitmap bitmap) {
        j.d(bitmap);
        IconCompat iconCompat = new IconCompat(1);
        iconCompat.f4630b = bitmap;
        return iconCompat;
    }

    @n0
    public static IconCompat u(@n0 Uri uri) {
        j.d(uri);
        return v(uri.toString());
    }

    @n0
    public static IconCompat v(@n0 String str) {
        j.d(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f4630b = str;
        return iconCompat;
    }

    @n0
    public static IconCompat w(@n0 byte[] bArr, int i10, int i11) {
        j.d(bArr);
        IconCompat iconCompat = new IconCompat(3);
        iconCompat.f4630b = bArr;
        iconCompat.f4633e = i10;
        iconCompat.f4634f = i11;
        return iconCompat;
    }

    @n0
    public static IconCompat x(@n0 Context context, @v int i10) {
        j.d(context);
        return y(context.getResources(), context.getPackageName(), i10);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @n0
    public static IconCompat y(@p0 Resources resources, @n0 String str, @v int i10) {
        j.d(str);
        if (i10 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f4633e = i10;
        if (resources != null) {
            try {
                iconCompat.f4630b = resources.getResourceName(i10);
            } catch (Resources.NotFoundException unused) {
                throw new IllegalArgumentException("Icon resource cannot be found");
            }
        } else {
            iconCompat.f4630b = str;
        }
        iconCompat.f4638j = str;
        return iconCompat;
    }

    @v
    public int A() {
        int i10 = this.f4629a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.c(this.f4630b);
        }
        if (i10 == 2) {
            return this.f4633e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    @n0
    public String B() {
        int i10 = this.f4629a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.d(this.f4630b);
        }
        if (i10 == 2) {
            String str = this.f4638j;
            return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f4630b).split(":", -1)[0] : this.f4638j;
        }
        throw new IllegalStateException("called getResPackage() on " + this);
    }

    public int D() {
        int i10 = this.f4629a;
        return (i10 != -1 || Build.VERSION.SDK_INT < 23) ? i10 : a.e(this.f4630b);
    }

    @n0
    public Uri E() {
        int i10 = this.f4629a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            return a.f(this.f4630b);
        }
        if (i10 == 4 || i10 == 6) {
            return Uri.parse((String) this.f4630b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public InputStream F(@n0 Context context) {
        Uri uriE = E();
        String scheme = uriE.getScheme();
        if ("content".equals(scheme) || m7.a.f40702b.equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(uriE);
            } catch (Exception unused) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unable to load image from URI: ");
                sb2.append(uriE);
                return null;
            }
        }
        try {
            return new FileInputStream(new File((String) this.f4630b));
        } catch (FileNotFoundException unused2) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Unable to load image from path: ");
            sb3.append(uriE);
            return null;
        }
    }

    @p0
    public Drawable G(@n0 Context context) {
        k(context);
        if (Build.VERSION.SDK_INT >= 23) {
            return a.g(N(context), context);
        }
        Drawable drawableH = H(context);
        if (drawableH != null && (this.f4635g != null || this.f4636h != G)) {
            drawableH.mutate();
            n0.c.o(drawableH, this.f4635g);
            n0.c.p(drawableH, this.f4636h);
        }
        return drawableH;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final Drawable H(Context context) {
        switch (this.f4629a) {
            case 1:
                return new BitmapDrawable(context.getResources(), (Bitmap) this.f4630b);
            case 2:
                String strB = B();
                if (TextUtils.isEmpty(strB)) {
                    strB = context.getPackageName();
                }
                try {
                    return i.g(C(context, strB), this.f4633e, context.getTheme());
                } catch (RuntimeException unused) {
                    String.format("Unable to load resource 0x%08x from pkg=%s", Integer.valueOf(this.f4633e), this.f4630b);
                }
                break;
            case 3:
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) this.f4630b, this.f4633e, this.f4634f));
            case 4:
                InputStream inputStreamF = F(context);
                if (inputStreamF != null) {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(inputStreamF));
                }
                return null;
            case 5:
                return new BitmapDrawable(context.getResources(), p((Bitmap) this.f4630b, false));
            case 6:
                InputStream inputStreamF2 = F(context);
                if (inputStreamF2 != null) {
                    return Build.VERSION.SDK_INT >= 26 ? b.a(null, new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(inputStreamF2))) : new BitmapDrawable(context.getResources(), p(BitmapFactory.decodeStream(inputStreamF2), false));
                }
                return null;
            default:
                return null;
        }
    }

    @n0
    public IconCompat I(@l int i10) {
        return J(ColorStateList.valueOf(i10));
    }

    @n0
    public IconCompat J(@p0 ColorStateList colorStateList) {
        this.f4635g = colorStateList;
        return this;
    }

    @n0
    public IconCompat K(@p0 PorterDuff.Mode mode) {
        this.f4636h = mode;
        return this;
    }

    @n0
    public Bundle L() {
        Bundle bundle = new Bundle();
        switch (this.f4629a) {
            case -1:
                bundle.putParcelable("obj", (Parcelable) this.f4630b);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                bundle.putParcelable("obj", (Bitmap) this.f4630b);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f4630b);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f4630b);
                break;
        }
        bundle.putInt("type", this.f4629a);
        bundle.putInt(B, this.f4633e);
        bundle.putInt(C, this.f4634f);
        bundle.putString(F, this.f4638j);
        ColorStateList colorStateList = this.f4635g;
        if (colorStateList != null) {
            bundle.putParcelable(D, colorStateList);
        }
        PorterDuff.Mode mode = this.f4636h;
        if (mode != G) {
            bundle.putString(E, mode.name());
        }
        return bundle;
    }

    @n0
    @v0(23)
    @Deprecated
    public Icon M() {
        return N(null);
    }

    @n0
    @v0(23)
    public Icon N(@p0 Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.h(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void h() {
        this.f4636h = PorterDuff.Mode.valueOf(this.f4637i);
        switch (this.f4629a) {
            case -1:
                Parcelable parcelable = this.f4632d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                this.f4630b = parcelable;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.f4632d;
                if (parcelable2 != null) {
                    this.f4630b = parcelable2;
                    return;
                }
                byte[] bArr = this.f4631c;
                this.f4630b = bArr;
                this.f4629a = 3;
                this.f4633e = 0;
                this.f4634f = bArr.length;
                return;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f4631c, Charset.forName(g.f56719p));
                this.f4630b = str;
                if (this.f4629a == 2 && this.f4638j == null) {
                    this.f4638j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f4630b = this.f4631c;
                return;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void i(boolean z10) {
        this.f4637i = this.f4636h.name();
        switch (this.f4629a) {
            case -1:
                if (z10) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                this.f4632d = (Parcelable) this.f4630b;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z10) {
                    this.f4632d = (Parcelable) this.f4630b;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.f4630b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                this.f4631c = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.f4631c = ((String) this.f4630b).getBytes(Charset.forName(g.f56719p));
                return;
            case 3:
                this.f4631c = (byte[]) this.f4630b;
                return;
            case 4:
            case 6:
                this.f4631c = this.f4630b.toString().getBytes(Charset.forName(g.f56719p));
                return;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void j(@n0 Intent intent, @p0 Drawable drawable, @n0 Context context) {
        Bitmap bitmapCopy;
        k(context);
        int i10 = this.f4629a;
        if (i10 == 1) {
            bitmapCopy = (Bitmap) this.f4630b;
            if (drawable != null) {
                bitmapCopy = bitmapCopy.copy(bitmapCopy.getConfig(), true);
            }
        } else if (i10 == 2) {
            try {
                Context contextCreatePackageContext = context.createPackageContext(B(), 0);
                if (drawable == null) {
                    intent.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", Intent.ShortcutIconResource.fromContext(contextCreatePackageContext, this.f4633e));
                    return;
                }
                Drawable drawableI = h0.d.i(contextCreatePackageContext, this.f4633e);
                if (drawableI.getIntrinsicWidth() <= 0 || drawableI.getIntrinsicHeight() <= 0) {
                    int launcherLargeIconSize = ((ActivityManager) contextCreatePackageContext.getSystemService(androidx.appcompat.widget.c.f2369r)).getLauncherLargeIconSize();
                    bitmapCopy = Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, Bitmap.Config.ARGB_8888);
                } else {
                    bitmapCopy = Bitmap.createBitmap(drawableI.getIntrinsicWidth(), drawableI.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                }
                drawableI.setBounds(0, 0, bitmapCopy.getWidth(), bitmapCopy.getHeight());
                drawableI.draw(new Canvas(bitmapCopy));
            } catch (PackageManager.NameNotFoundException e10) {
                throw new IllegalArgumentException("Can't find package " + this.f4630b, e10);
            }
        } else {
            if (i10 != 5) {
                throw new IllegalArgumentException("Icon type not supported for intent shortcuts");
            }
            bitmapCopy = p((Bitmap) this.f4630b, true);
        }
        if (drawable != null) {
            int width = bitmapCopy.getWidth();
            int height = bitmapCopy.getHeight();
            drawable.setBounds(width / 2, height / 2, width, height);
            drawable.draw(new Canvas(bitmapCopy));
        }
        intent.putExtra("android.intent.extra.shortcut.ICON", bitmapCopy);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void k(@n0 Context context) {
        Object obj;
        if (this.f4629a != 2 || (obj = this.f4630b) == null) {
            return;
        }
        String str = (String) obj;
        if (str.contains(":")) {
            String str2 = str.split(":", -1)[1];
            String str3 = str2.split(fh.a.f28350w, -1)[0];
            String str4 = str2.split(fh.a.f28350w, -1)[1];
            String str5 = str.split(":", -1)[0];
            if ("0_resource_name_obfuscated".equals(str4)) {
                return;
            }
            String strB = B();
            int identifier = C(context, strB).getIdentifier(str4, str3, str5);
            if (this.f4633e != identifier) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Id has changed for ");
                sb2.append(strB);
                sb2.append(i0.f11861z);
                sb2.append(str);
                this.f4633e = identifier;
            }
        }
    }

    @n0
    public String toString() {
        if (this.f4629a == -1) {
            return String.valueOf(this.f4630b);
        }
        StringBuilder sb2 = new StringBuilder("Icon(typ=");
        sb2.append(O(this.f4629a));
        switch (this.f4629a) {
            case 1:
            case 5:
                sb2.append(" size=");
                sb2.append(((Bitmap) this.f4630b).getWidth());
                sb2.append("x");
                sb2.append(((Bitmap) this.f4630b).getHeight());
                break;
            case 2:
                sb2.append(" pkg=");
                sb2.append(this.f4638j);
                sb2.append(" id=");
                sb2.append(String.format("0x%08x", Integer.valueOf(A())));
                break;
            case 3:
                sb2.append(" len=");
                sb2.append(this.f4633e);
                if (this.f4634f != 0) {
                    sb2.append(" off=");
                    sb2.append(this.f4634f);
                }
                break;
            case 4:
            case 6:
                sb2.append(" uri=");
                sb2.append(this.f4630b);
                break;
        }
        if (this.f4635g != null) {
            sb2.append(" tint=");
            sb2.append(this.f4635g);
        }
        if (this.f4636h != G) {
            sb2.append(" mode=");
            sb2.append(this.f4636h);
        }
        sb2.append(ee.a.f26979d);
        return sb2.toString();
    }

    @p0
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Bitmap z() {
        int i10 = this.f4629a;
        if (i10 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f4630b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        }
        if (i10 == 1) {
            return (Bitmap) this.f4630b;
        }
        if (i10 == 5) {
            return p((Bitmap) this.f4630b, true);
        }
        throw new IllegalStateException("called getBitmap() on " + this);
    }

    public IconCompat(int i10) {
        this.f4631c = null;
        this.f4632d = null;
        this.f4633e = 0;
        this.f4634f = 0;
        this.f4635g = null;
        this.f4636h = G;
        this.f4637i = null;
        this.f4629a = i10;
    }
}
