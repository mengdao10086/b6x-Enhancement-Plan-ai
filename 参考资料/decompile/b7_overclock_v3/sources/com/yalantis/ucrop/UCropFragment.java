package com.yalantis.ucrop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.transition.q;
import androidx.transition.u;
import com.yalantis.ucrop.a;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.UCropView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import g.d0;
import g.l;
import g.n0;
import g.p0;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import nh.b;

/* JADX INFO: loaded from: classes5.dex */
public class UCropFragment extends Fragment {
    public static final int A8 = 90;
    public static final Bitmap.CompressFormat B8 = Bitmap.CompressFormat.JPEG;
    public static final int C8 = 0;
    public static final int D8 = 1;
    public static final int E8 = 2;
    public static final int F8 = 3;
    public static final String G8 = "UCropFragment";
    public static final long H8 = 50;
    public static final int I8 = 3;
    public static final int J8 = 15000;
    public static final int K8 = 42;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public com.yalantis.ucrop.b f24902c8;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public int f24903d8;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    @l
    public int f24904e8;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public int f24905f8;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public boolean f24906g8;

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public q f24907h8;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public UCropView f24908i8;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public GestureCropImageView f24909j8;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public OverlayView f24910k8;

    /* JADX INFO: renamed from: l8, reason: collision with root package name */
    public ViewGroup f24911l8;

    /* JADX INFO: renamed from: m8, reason: collision with root package name */
    public ViewGroup f24912m8;

    /* JADX INFO: renamed from: n8, reason: collision with root package name */
    public ViewGroup f24913n8;

    /* JADX INFO: renamed from: o8, reason: collision with root package name */
    public ViewGroup f24914o8;

    /* JADX INFO: renamed from: p8, reason: collision with root package name */
    public ViewGroup f24915p8;

    /* JADX INFO: renamed from: q8, reason: collision with root package name */
    public ViewGroup f24916q8;

    /* JADX INFO: renamed from: s8, reason: collision with root package name */
    public TextView f24918s8;

    /* JADX INFO: renamed from: t8, reason: collision with root package name */
    public TextView f24919t8;

    /* JADX INFO: renamed from: u8, reason: collision with root package name */
    public View f24920u8;

    /* JADX INFO: renamed from: r8, reason: collision with root package name */
    public List<ViewGroup> f24917r8 = new ArrayList();

    /* JADX INFO: renamed from: v8, reason: collision with root package name */
    public Bitmap.CompressFormat f24921v8 = B8;

    /* JADX INFO: renamed from: w8, reason: collision with root package name */
    public int f24922w8 = 90;

    /* JADX INFO: renamed from: x8, reason: collision with root package name */
    public int[] f24923x8 = {1, 2, 3};

    /* JADX INFO: renamed from: y8, reason: collision with root package name */
    public b.InterfaceC0475b f24924y8 = new a();

    /* JADX INFO: renamed from: z8, reason: collision with root package name */
    public final View.OnClickListener f24925z8 = new g();

    public class a implements b.InterfaceC0475b {
        public a() {
        }

        @Override // nh.b.InterfaceC0475b
        public void a(float f10) {
            UCropFragment.this.Z5(f10);
        }

        @Override // nh.b.InterfaceC0475b
        public void b() {
            UCropFragment.this.f24908i8.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropFragment.this.f24920u8.setClickable(false);
            UCropFragment.this.f24902c8.b(false);
        }

        @Override // nh.b.InterfaceC0475b
        public void c(@n0 Exception exc) {
            UCropFragment.this.f24902c8.a(UCropFragment.this.R5(exc));
        }

        @Override // nh.b.InterfaceC0475b
        public void d(float f10) {
            UCropFragment.this.e6(f10);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropFragment.this.f24909j8.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).k(view.isSelected()));
            UCropFragment.this.f24909j8.C();
            if (view.isSelected()) {
                return;
            }
            for (ViewGroup viewGroup : UCropFragment.this.f24917r8) {
                viewGroup.setSelected(viewGroup == view);
            }
        }
    }

    public class c implements HorizontalProgressWheelView.a {
        public c() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropFragment.this.f24909j8.C();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b(float f10, float f11) {
            UCropFragment.this.f24909j8.A(f10 / 42.0f);
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void c() {
            UCropFragment.this.f24909j8.w();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropFragment.this.W5();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropFragment.this.X5(90);
        }
    }

    public class f implements HorizontalProgressWheelView.a {
        public f() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropFragment.this.f24909j8.C();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b(float f10, float f11) {
            if (f10 > 0.0f) {
                UCropFragment.this.f24909j8.F(UCropFragment.this.f24909j8.getCurrentScale() + (f10 * ((UCropFragment.this.f24909j8.getMaxScale() - UCropFragment.this.f24909j8.getMinScale()) / 15000.0f)));
            } else {
                UCropFragment.this.f24909j8.H(UCropFragment.this.f24909j8.getCurrentScale() + (f10 * ((UCropFragment.this.f24909j8.getMaxScale() - UCropFragment.this.f24909j8.getMinScale()) / 15000.0f)));
            }
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void c() {
            UCropFragment.this.f24909j8.w();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            UCropFragment.this.g6(view.getId());
        }
    }

    public class h implements jh.a {
        public h() {
        }

        @Override // jh.a
        public void a(@n0 Uri uri, int i10, int i11, int i12, int i13) {
            com.yalantis.ucrop.b bVar = UCropFragment.this.f24902c8;
            UCropFragment uCropFragment = UCropFragment.this;
            bVar.a(uCropFragment.S5(uri, uCropFragment.f24909j8.getTargetAspectRatio(), i10, i11, i12, i13));
            UCropFragment.this.f24902c8.b(false);
        }

        @Override // jh.a
        public void b(@n0 Throwable th2) {
            UCropFragment.this.f24902c8.a(UCropFragment.this.R5(th2));
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface i {
    }

    public class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Intent f24935b;

        public j(int i10, Intent intent) {
            this.f24934a = i10;
            this.f24935b = intent;
        }
    }

    static {
        androidx.appcompat.app.h.J(true);
    }

    public static UCropFragment U5(Bundle bundle) {
        UCropFragment uCropFragment = new UCropFragment();
        uCropFragment.c5(bundle);
        return uCropFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void H3(Context context) {
        super.H3(context);
        if (J2() instanceof com.yalantis.ucrop.b) {
            this.f24902c8 = (com.yalantis.ucrop.b) J2();
        } else {
            if (context instanceof com.yalantis.ucrop.b) {
                this.f24902c8 = (com.yalantis.ucrop.b) context;
                return;
            }
            throw new IllegalArgumentException(context.toString() + " must implement UCropFragmentCallback");
        }
    }

    @Override // androidx.fragment.app.Fragment
    @p0
    public View O3(@n0 LayoutInflater layoutInflater, @p0 ViewGroup viewGroup, @p0 Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.ucrop_fragment_photobox, viewGroup, false);
        Bundle bundleT1 = T1();
        l6(viewInflate, bundleT1);
        c6(bundleT1);
        d6();
        O5(viewInflate);
        return viewInflate;
    }

    public final void O5(View view) {
        if (this.f24920u8 == null) {
            this.f24920u8 = new View(X1());
            this.f24920u8.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
            this.f24920u8.setClickable(true);
        }
        ((RelativeLayout) view.findViewById(R.id.ucrop_photobox)).addView(this.f24920u8);
    }

    public final void P5(int i10) {
        if (k3() != null) {
            u.b((ViewGroup) k3().findViewById(R.id.ucrop_photobox), this.f24907h8);
        }
        this.f24913n8.findViewById(R.id.text_view_scale).setVisibility(i10 == R.id.state_scale ? 0 : 8);
        this.f24911l8.findViewById(R.id.text_view_crop).setVisibility(i10 == R.id.state_aspect_ratio ? 0 : 8);
        this.f24912m8.findViewById(R.id.text_view_rotate).setVisibility(i10 != R.id.state_rotate ? 8 : 0);
    }

    public void Q5() {
        this.f24920u8.setClickable(true);
        this.f24902c8.b(true);
        this.f24909j8.x(this.f24921v8, this.f24922w8, new h());
    }

    public j R5(Throwable th2) {
        return new j(96, new Intent().putExtra(com.yalantis.ucrop.a.f24948n, th2));
    }

    public j S5(Uri uri, float f10, int i10, int i11, int i12, int i13) {
        return new j(-1, new Intent().putExtra(com.yalantis.ucrop.a.f24942h, uri).putExtra(com.yalantis.ucrop.a.f24943i, f10).putExtra(com.yalantis.ucrop.a.f24944j, i12).putExtra(com.yalantis.ucrop.a.f24945k, i13).putExtra(com.yalantis.ucrop.a.f24946l, i10).putExtra(com.yalantis.ucrop.a.f24947m, i11));
    }

    public final void T5(View view) {
        UCropView uCropView = (UCropView) view.findViewById(R.id.ucrop);
        this.f24908i8 = uCropView;
        this.f24909j8 = uCropView.getCropImageView();
        this.f24910k8 = this.f24908i8.getOverlayView();
        this.f24909j8.setTransformImageListener(this.f24924y8);
        ((ImageView) view.findViewById(R.id.image_view_logo)).setColorFilter(this.f24905f8, PorterDuff.Mode.SRC_ATOP);
        view.findViewById(R.id.ucrop_frame).setBackgroundColor(this.f24904e8);
    }

    public final void V5(@n0 Bundle bundle) {
        String string = bundle.getString(a.C0278a.f24955b);
        Bitmap.CompressFormat compressFormatValueOf = !TextUtils.isEmpty(string) ? Bitmap.CompressFormat.valueOf(string) : null;
        if (compressFormatValueOf == null) {
            compressFormatValueOf = B8;
        }
        this.f24921v8 = compressFormatValueOf;
        this.f24922w8 = bundle.getInt(a.C0278a.f24956c, 90);
        int[] intArray = bundle.getIntArray(a.C0278a.f24957d);
        if (intArray != null && intArray.length == 3) {
            this.f24923x8 = intArray;
        }
        this.f24909j8.setMaxBitmapSize(bundle.getInt(a.C0278a.f24958e, 0));
        this.f24909j8.setMaxScaleMultiplier(bundle.getFloat(a.C0278a.f24959f, 10.0f));
        this.f24909j8.setImageToWrapCropBoundsAnimDuration(bundle.getInt(a.C0278a.f24960g, 500));
        this.f24910k8.setFreestyleCropEnabled(bundle.getBoolean(a.C0278a.A, false));
        this.f24910k8.setDimmedColor(bundle.getInt(a.C0278a.f24961h, V2().getColor(R.color.ucrop_color_default_dimmed)));
        this.f24910k8.setCircleDimmedLayer(bundle.getBoolean(a.C0278a.f24962i, false));
        this.f24910k8.setShowCropFrame(bundle.getBoolean(a.C0278a.f24963j, true));
        this.f24910k8.setCropFrameColor(bundle.getInt(a.C0278a.f24964k, V2().getColor(R.color.ucrop_color_default_crop_frame)));
        this.f24910k8.setCropFrameStrokeWidth(bundle.getInt(a.C0278a.f24965l, V2().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.f24910k8.setShowCropGrid(bundle.getBoolean(a.C0278a.f24966m, true));
        this.f24910k8.setCropGridRowCount(bundle.getInt(a.C0278a.f24967n, 2));
        this.f24910k8.setCropGridColumnCount(bundle.getInt(a.C0278a.f24968o, 2));
        this.f24910k8.setCropGridColor(bundle.getInt(a.C0278a.f24969p, V2().getColor(R.color.ucrop_color_default_crop_grid)));
        this.f24910k8.setCropGridStrokeWidth(bundle.getInt(a.C0278a.f24970q, V2().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float f10 = bundle.getFloat(com.yalantis.ucrop.a.f24949o, -1.0f);
        float f11 = bundle.getFloat(com.yalantis.ucrop.a.f24950p, -1.0f);
        int i10 = bundle.getInt(a.C0278a.B, 0);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(a.C0278a.C);
        if (f10 >= 0.0f && f11 >= 0.0f) {
            ViewGroup viewGroup = this.f24911l8;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            float f12 = f10 / f11;
            this.f24909j8.setTargetAspectRatio(Float.isNaN(f12) ? 0.0f : f12);
        } else if (parcelableArrayList == null || i10 >= parcelableArrayList.size()) {
            this.f24909j8.setTargetAspectRatio(0.0f);
        } else {
            float fB = ((AspectRatio) parcelableArrayList.get(i10)).b() / ((AspectRatio) parcelableArrayList.get(i10)).e();
            this.f24909j8.setTargetAspectRatio(Float.isNaN(fB) ? 0.0f : fB);
        }
        int i11 = bundle.getInt(com.yalantis.ucrop.a.f24951q, 0);
        int i12 = bundle.getInt(com.yalantis.ucrop.a.f24952r, 0);
        if (i11 <= 0 || i12 <= 0) {
            return;
        }
        this.f24909j8.setMaxResultImageSizeX(i11);
        this.f24909j8.setMaxResultImageSizeY(i12);
    }

    public final void W5() {
        GestureCropImageView gestureCropImageView = this.f24909j8;
        gestureCropImageView.A(-gestureCropImageView.getCurrentAngle());
        this.f24909j8.C();
    }

    public final void X5(int i10) {
        this.f24909j8.A(i10);
        this.f24909j8.C();
    }

    public final void Y5(int i10) {
        GestureCropImageView gestureCropImageView = this.f24909j8;
        int[] iArr = this.f24923x8;
        gestureCropImageView.setScaleEnabled(iArr[i10] == 3 || iArr[i10] == 1);
        GestureCropImageView gestureCropImageView2 = this.f24909j8;
        int[] iArr2 = this.f24923x8;
        gestureCropImageView2.setRotateEnabled(iArr2[i10] == 3 || iArr2[i10] == 2);
    }

    public final void Z5(float f10) {
        TextView textView = this.f24918s8;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f10)));
        }
    }

    public final void a6(int i10) {
        TextView textView = this.f24918s8;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    public void b6(com.yalantis.ucrop.b bVar) {
        this.f24902c8 = bVar;
    }

    public final void c6(@n0 Bundle bundle) {
        Uri uri = (Uri) bundle.getParcelable(com.yalantis.ucrop.a.f24941g);
        Uri uri2 = (Uri) bundle.getParcelable(com.yalantis.ucrop.a.f24942h);
        V5(bundle);
        if (uri == null || uri2 == null) {
            this.f24902c8.a(R5(new NullPointerException(c3(R.string.ucrop_error_input_data_is_absent))));
            return;
        }
        try {
            this.f24909j8.q(uri, uri2);
        } catch (Exception e10) {
            this.f24902c8.a(R5(e10));
        }
    }

    public final void d6() {
        if (!this.f24906g8) {
            Y5(0);
        } else if (this.f24911l8.getVisibility() == 0) {
            g6(R.id.state_aspect_ratio);
        } else {
            g6(R.id.state_scale);
        }
    }

    public final void e6(float f10) {
        TextView textView = this.f24919t8;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f10 * 100.0f))));
        }
    }

    public final void f6(int i10) {
        TextView textView = this.f24919t8;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    public final void g6(@d0 int i10) {
        if (this.f24906g8) {
            ViewGroup viewGroup = this.f24911l8;
            int i11 = R.id.state_aspect_ratio;
            viewGroup.setSelected(i10 == i11);
            ViewGroup viewGroup2 = this.f24912m8;
            int i12 = R.id.state_rotate;
            viewGroup2.setSelected(i10 == i12);
            ViewGroup viewGroup3 = this.f24913n8;
            int i13 = R.id.state_scale;
            viewGroup3.setSelected(i10 == i13);
            this.f24914o8.setVisibility(i10 == i11 ? 0 : 8);
            this.f24915p8.setVisibility(i10 == i12 ? 0 : 8);
            this.f24916q8.setVisibility(i10 == i13 ? 0 : 8);
            P5(i10);
            if (i10 == i13) {
                Y5(0);
            } else if (i10 == i12) {
                Y5(1);
            } else {
                Y5(2);
            }
        }
    }

    public final void h6(@n0 Bundle bundle, View view) {
        int i10 = bundle.getInt(a.C0278a.B, 0);
        ArrayList<AspectRatio> parcelableArrayList = bundle.getParcelableArrayList(a.C0278a.C);
        if (parcelableArrayList == null || parcelableArrayList.isEmpty()) {
            i10 = 2;
            parcelableArrayList = new ArrayList();
            parcelableArrayList.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayList.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayList.add(new AspectRatio(c3(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayList.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayList.add(new AspectRatio(null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        for (AspectRatio aspectRatio : parcelableArrayList) {
            FrameLayout frameLayout = (FrameLayout) w2().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.f24903d8);
            aspectRatioTextView.setAspectRatio(aspectRatio);
            linearLayout.addView(frameLayout);
            this.f24917r8.add(frameLayout);
        }
        this.f24917r8.get(i10).setSelected(true);
        Iterator<ViewGroup> it2 = this.f24917r8.iterator();
        while (it2.hasNext()) {
            it2.next().setOnClickListener(new b());
        }
    }

    public final void i6(View view) {
        this.f24918s8 = (TextView) view.findViewById(R.id.text_view_rotate);
        int i10 = R.id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) view.findViewById(i10)).setScrollingListener(new c());
        ((HorizontalProgressWheelView) view.findViewById(i10)).setMiddleLineColor(this.f24903d8);
        view.findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new d());
        view.findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new e());
        a6(this.f24903d8);
    }

    public final void j6(View view) {
        this.f24919t8 = (TextView) view.findViewById(R.id.text_view_scale);
        int i10 = R.id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) view.findViewById(i10)).setScrollingListener(new f());
        ((HorizontalProgressWheelView) view.findViewById(i10)).setMiddleLineColor(this.f24903d8);
        f6(this.f24903d8);
    }

    public final void k6(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new mh.i(imageView.getDrawable(), this.f24903d8));
        imageView2.setImageDrawable(new mh.i(imageView2.getDrawable(), this.f24903d8));
        imageView3.setImageDrawable(new mh.i(imageView3.getDrawable(), this.f24903d8));
    }

    public void l6(View view, Bundle bundle) {
        this.f24903d8 = bundle.getInt(a.C0278a.f24973t, h0.d.f(X1(), R.color.ucrop_color_widget_active));
        this.f24905f8 = bundle.getInt(a.C0278a.f24978y, h0.d.f(X1(), R.color.ucrop_color_default_logo));
        this.f24906g8 = !bundle.getBoolean(a.C0278a.f24979z, false);
        this.f24904e8 = bundle.getInt(a.C0278a.D, h0.d.f(X1(), R.color.ucrop_color_crop_background));
        T5(view);
        this.f24902c8.b(true);
        if (!this.f24906g8) {
            int i10 = R.id.ucrop_frame;
            ((RelativeLayout.LayoutParams) view.findViewById(i10).getLayoutParams()).bottomMargin = 0;
            view.findViewById(i10).requestLayout();
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.controls_wrapper);
        viewGroup.setVisibility(0);
        LayoutInflater.from(X1()).inflate(R.layout.ucrop_controls, viewGroup, true);
        g2.a aVar = new g2.a();
        this.f24907h8 = aVar;
        aVar.y0(50L);
        ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.state_aspect_ratio);
        this.f24911l8 = viewGroup2;
        viewGroup2.setOnClickListener(this.f24925z8);
        ViewGroup viewGroup3 = (ViewGroup) view.findViewById(R.id.state_rotate);
        this.f24912m8 = viewGroup3;
        viewGroup3.setOnClickListener(this.f24925z8);
        ViewGroup viewGroup4 = (ViewGroup) view.findViewById(R.id.state_scale);
        this.f24913n8 = viewGroup4;
        viewGroup4.setOnClickListener(this.f24925z8);
        this.f24914o8 = (ViewGroup) view.findViewById(R.id.layout_aspect_ratio);
        this.f24915p8 = (ViewGroup) view.findViewById(R.id.layout_rotate_wheel);
        this.f24916q8 = (ViewGroup) view.findViewById(R.id.layout_scale_wheel);
        h6(bundle, view);
        i6(view);
        j6(view);
        k6(view);
    }
}
