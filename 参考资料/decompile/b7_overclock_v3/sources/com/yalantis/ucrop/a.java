package com.yalantis.ucrop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.google.common.collect.LinkedHashMultimap;
import com.yalantis.ucrop.model.AspectRatio;
import g.f0;
import g.l;
import g.n0;
import g.p0;
import g.v;
import g.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f24937c = 69;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f24938d = 96;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f24939e = 10;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f24940f = "com.yalantis.ucrop";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f24941g = "com.yalantis.ucrop.InputUri";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f24942h = "com.yalantis.ucrop.OutputUri";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f24943i = "com.yalantis.ucrop.CropAspectRatio";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f24944j = "com.yalantis.ucrop.ImageWidth";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f24945k = "com.yalantis.ucrop.ImageHeight";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f24946l = "com.yalantis.ucrop.OffsetX";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f24947m = "com.yalantis.ucrop.OffsetY";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f24948n = "com.yalantis.ucrop.Error";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f24949o = "com.yalantis.ucrop.AspectRatioX";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f24950p = "com.yalantis.ucrop.AspectRatioY";

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f24951q = "com.yalantis.ucrop.MaxSizeX";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f24952r = "com.yalantis.ucrop.MaxSizeY";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Intent f24953a = new Intent();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f24954b;

    /* JADX INFO: renamed from: com.yalantis.ucrop.a$a, reason: collision with other inner class name */
    public static class C0278a {
        public static final String A = "com.yalantis.ucrop.FreeStyleCrop";
        public static final String B = "com.yalantis.ucrop.AspectRatioSelectedByDefault";
        public static final String C = "com.yalantis.ucrop.AspectRatioOptions";
        public static final String D = "com.yalantis.ucrop.UcropRootViewBackgroundColor";

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f24955b = "com.yalantis.ucrop.CompressionFormatName";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f24956c = "com.yalantis.ucrop.CompressionQuality";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final String f24957d = "com.yalantis.ucrop.AllowedGestures";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final String f24958e = "com.yalantis.ucrop.MaxBitmapSize";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final String f24959f = "com.yalantis.ucrop.MaxScaleMultiplier";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final String f24960g = "com.yalantis.ucrop.ImageToCropBoundsAnimDuration";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final String f24961h = "com.yalantis.ucrop.DimmedLayerColor";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final String f24962i = "com.yalantis.ucrop.CircleDimmedLayer";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final String f24963j = "com.yalantis.ucrop.ShowCropFrame";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final String f24964k = "com.yalantis.ucrop.CropFrameColor";

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static final String f24965l = "com.yalantis.ucrop.CropFrameStrokeWidth";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public static final String f24966m = "com.yalantis.ucrop.ShowCropGrid";

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public static final String f24967n = "com.yalantis.ucrop.CropGridRowCount";

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final String f24968o = "com.yalantis.ucrop.CropGridColumnCount";

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public static final String f24969p = "com.yalantis.ucrop.CropGridColor";

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public static final String f24970q = "com.yalantis.ucrop.CropGridStrokeWidth";

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final String f24971r = "com.yalantis.ucrop.ToolbarColor";

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final String f24972s = "com.yalantis.ucrop.StatusBarColor";

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public static final String f24973t = "com.yalantis.ucrop.UcropColorControlsWidgetActive";

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public static final String f24974u = "com.yalantis.ucrop.UcropToolbarWidgetColor";

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public static final String f24975v = "com.yalantis.ucrop.UcropToolbarTitleText";

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public static final String f24976w = "com.yalantis.ucrop.UcropToolbarCancelDrawable";

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final String f24977x = "com.yalantis.ucrop.UcropToolbarCropDrawable";

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final String f24978y = "com.yalantis.ucrop.UcropLogoColor";

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final String f24979z = "com.yalantis.ucrop.HideBottomControls";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Bundle f24980a = new Bundle();

        public void A(@v int i10) {
            this.f24980a.putInt(f24977x, i10);
        }

        public void B(@p0 String str) {
            this.f24980a.putString(f24975v, str);
        }

        public void C(@l int i10) {
            this.f24980a.putInt(f24974u, i10);
        }

        public void D() {
            this.f24980a.putFloat(a.f24949o, 0.0f);
            this.f24980a.putFloat(a.f24950p, 0.0f);
        }

        public void E(float f10, float f11) {
            this.f24980a.putFloat(a.f24949o, f10);
            this.f24980a.putFloat(a.f24950p, f11);
        }

        public void F(@f0(from = g1.a.f28860g) int i10, @f0(from = g1.a.f28860g) int i11) {
            this.f24980a.putInt(a.f24951q, i10);
            this.f24980a.putInt(a.f24952r, i11);
        }

        @n0
        public Bundle a() {
            return this.f24980a;
        }

        public void b(@l int i10) {
            this.f24980a.putInt(f24973t, i10);
        }

        public void c(int i10, int i11, int i12) {
            this.f24980a.putIntArray(f24957d, new int[]{i10, i11, i12});
        }

        public void d(int i10, AspectRatio... aspectRatioArr) {
            if (i10 >= aspectRatioArr.length) {
                throw new IllegalArgumentException(String.format(Locale.US, "Index [selectedByDefault = %d] (0-based) cannot be higher or equal than aspect ratio options count [count = %d].", Integer.valueOf(i10), Integer.valueOf(aspectRatioArr.length)));
            }
            this.f24980a.putInt(B, i10);
            this.f24980a.putParcelableArrayList(C, new ArrayList<>(Arrays.asList(aspectRatioArr)));
        }

        public void e(boolean z10) {
            this.f24980a.putBoolean(f24962i, z10);
        }

        public void f(@n0 Bitmap.CompressFormat compressFormat) {
            this.f24980a.putString(f24955b, compressFormat.name());
        }

        public void g(@f0(from = 0) int i10) {
            this.f24980a.putInt(f24956c, i10);
        }

        public void h(@l int i10) {
            this.f24980a.putInt(f24964k, i10);
        }

        public void i(@f0(from = 0) int i10) {
            this.f24980a.putInt(f24965l, i10);
        }

        public void j(@l int i10) {
            this.f24980a.putInt(f24969p, i10);
        }

        public void k(@f0(from = 0) int i10) {
            this.f24980a.putInt(f24968o, i10);
        }

        public void l(@f0(from = 0) int i10) {
            this.f24980a.putInt(f24967n, i10);
        }

        public void m(@f0(from = 0) int i10) {
            this.f24980a.putInt(f24970q, i10);
        }

        public void n(@l int i10) {
            this.f24980a.putInt(f24961h, i10);
        }

        public void o(boolean z10) {
            this.f24980a.putBoolean(A, z10);
        }

        public void p(boolean z10) {
            this.f24980a.putBoolean(f24979z, z10);
        }

        public void q(@f0(from = g1.a.f28860g) int i10) {
            this.f24980a.putInt(f24960g, i10);
        }

        public void r(@l int i10) {
            this.f24980a.putInt(f24978y, i10);
        }

        public void s(@f0(from = g1.a.f28860g) int i10) {
            this.f24980a.putInt(f24958e, i10);
        }

        public void t(@x(from = LinkedHashMultimap.VALUE_SET_LOAD_FACTOR, fromInclusive = false) float f10) {
            this.f24980a.putFloat(f24959f, f10);
        }

        public void u(@l int i10) {
            this.f24980a.putInt(D, i10);
        }

        public void v(boolean z10) {
            this.f24980a.putBoolean(f24963j, z10);
        }

        public void w(boolean z10) {
            this.f24980a.putBoolean(f24966m, z10);
        }

        public void x(@l int i10) {
            this.f24980a.putInt(f24972s, i10);
        }

        public void y(@v int i10) {
            this.f24980a.putInt(f24976w, i10);
        }

        public void z(@l int i10) {
            this.f24980a.putInt(f24971r, i10);
        }
    }

    public a(@n0 Uri uri, @n0 Uri uri2) {
        Bundle bundle = new Bundle();
        this.f24954b = bundle;
        bundle.putParcelable(f24941g, uri);
        this.f24954b.putParcelable(f24942h, uri2);
    }

    @p0
    public static Throwable a(@n0 Intent intent) {
        return (Throwable) intent.getSerializableExtra(f24948n);
    }

    @p0
    public static Uri e(@n0 Intent intent) {
        return (Uri) intent.getParcelableExtra(f24942h);
    }

    public static float f(@n0 Intent intent) {
        return intent.getFloatExtra(f24943i, 0.0f);
    }

    public static int g(@n0 Intent intent) {
        return intent.getIntExtra(f24945k, -1);
    }

    public static int h(@n0 Intent intent) {
        return intent.getIntExtra(f24944j, -1);
    }

    public static a i(@n0 Uri uri, @n0 Uri uri2) {
        return new a(uri, uri2);
    }

    public UCropFragment b() {
        return UCropFragment.U5(this.f24954b);
    }

    public UCropFragment c(Bundle bundle) {
        this.f24954b = bundle;
        return b();
    }

    public Intent d(@n0 Context context) {
        this.f24953a.setClass(context, UCropActivity.class);
        this.f24953a.putExtras(this.f24954b);
        return this.f24953a;
    }

    public void j(@n0 Activity activity) {
        k(activity, 69);
    }

    public void k(@n0 Activity activity, int i10) {
        activity.startActivityForResult(d(activity), i10);
    }

    public void l(@n0 Context context, @n0 Fragment fragment) {
        m(context, fragment, 69);
    }

    public void m(@n0 Context context, @n0 Fragment fragment, int i10) {
        fragment.z5(d(context), i10);
    }

    public a n() {
        this.f24954b.putFloat(f24949o, 0.0f);
        this.f24954b.putFloat(f24950p, 0.0f);
        return this;
    }

    public a o(float f10, float f11) {
        this.f24954b.putFloat(f24949o, f10);
        this.f24954b.putFloat(f24950p, f11);
        return this;
    }

    public a p(@f0(from = g1.a.f28860g) int i10, @f0(from = g1.a.f28860g) int i11) {
        if (i10 < 10) {
            i10 = 10;
        }
        if (i11 < 10) {
            i11 = 10;
        }
        this.f24954b.putInt(f24951q, i10);
        this.f24954b.putInt(f24952r, i11);
        return this;
    }

    public a q(@n0 C0278a c0278a) {
        this.f24954b.putAll(c0278a.a());
        return this;
    }
}
