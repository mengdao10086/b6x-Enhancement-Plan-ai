package com.yalantis.ucrop;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
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
import g.v;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import nh.b;

/* JADX INFO: loaded from: classes5.dex */
public class UCropActivity extends androidx.appcompat.app.f {

    /* JADX INFO: renamed from: a8, reason: collision with root package name */
    public static final int f24880a8 = 90;

    /* JADX INFO: renamed from: b8, reason: collision with root package name */
    public static final Bitmap.CompressFormat f24881b8 = Bitmap.CompressFormat.JPEG;

    /* JADX INFO: renamed from: c8, reason: collision with root package name */
    public static final int f24882c8 = 0;

    /* JADX INFO: renamed from: d8, reason: collision with root package name */
    public static final int f24883d8 = 1;

    /* JADX INFO: renamed from: e8, reason: collision with root package name */
    public static final int f24884e8 = 2;

    /* JADX INFO: renamed from: f8, reason: collision with root package name */
    public static final int f24885f8 = 3;

    /* JADX INFO: renamed from: g8, reason: collision with root package name */
    public static final String f24886g8 = "UCropActivity";

    /* JADX INFO: renamed from: h8, reason: collision with root package name */
    public static final long f24887h8 = 50;

    /* JADX INFO: renamed from: i8, reason: collision with root package name */
    public static final int f24888i8 = 3;

    /* JADX INFO: renamed from: j8, reason: collision with root package name */
    public static final int f24889j8 = 15000;

    /* JADX INFO: renamed from: k8, reason: collision with root package name */
    public static final int f24890k8 = 42;
    public int C1;

    @v
    public int C2;
    public int E7;
    public boolean F7;
    public UCropView H7;
    public GestureCropImageView I7;
    public OverlayView J7;
    public String K0;
    public int K1;

    @v
    public int K2;
    public ViewGroup K7;
    public ViewGroup L7;
    public ViewGroup M7;
    public ViewGroup N7;
    public ViewGroup O7;
    public ViewGroup P7;
    public TextView R7;
    public TextView S7;
    public View T7;
    public q U7;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public int f24891k1;

    /* JADX INFO: renamed from: v1, reason: collision with root package name */
    public int f24892v1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    @l
    public int f24893v2;
    public boolean G7 = true;
    public List<ViewGroup> Q7 = new ArrayList();
    public Bitmap.CompressFormat V7 = f24881b8;
    public int W7 = 90;
    public int[] X7 = {1, 2, 3};
    public b.InterfaceC0475b Y7 = new a();
    public final View.OnClickListener Z7 = new g();

    public class a implements b.InterfaceC0475b {
        public a() {
        }

        @Override // nh.b.InterfaceC0475b
        public void a(float f10) {
            UCropActivity.this.r4(f10);
        }

        @Override // nh.b.InterfaceC0475b
        public void b() {
            UCropActivity.this.H7.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            UCropActivity.this.T7.setClickable(false);
            UCropActivity.this.G7 = false;
            UCropActivity.this.E3();
        }

        @Override // nh.b.InterfaceC0475b
        public void c(@n0 Exception exc) {
            UCropActivity.this.v4(exc);
            UCropActivity.this.finish();
        }

        @Override // nh.b.InterfaceC0475b
        public void d(float f10) {
            UCropActivity.this.x4(f10);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.I7.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).k(view.isSelected()));
            UCropActivity.this.I7.C();
            if (view.isSelected()) {
                return;
            }
            for (ViewGroup viewGroup : UCropActivity.this.Q7) {
                viewGroup.setSelected(viewGroup == view);
            }
        }
    }

    public class c implements HorizontalProgressWheelView.a {
        public c() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropActivity.this.I7.C();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b(float f10, float f11) {
            UCropActivity.this.I7.A(f10 / 42.0f);
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void c() {
            UCropActivity.this.I7.w();
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.o4();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UCropActivity.this.p4(90);
        }
    }

    public class f implements HorizontalProgressWheelView.a {
        public f() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void a() {
            UCropActivity.this.I7.C();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void b(float f10, float f11) {
            if (f10 > 0.0f) {
                UCropActivity.this.I7.F(UCropActivity.this.I7.getCurrentScale() + (f10 * ((UCropActivity.this.I7.getMaxScale() - UCropActivity.this.I7.getMinScale()) / 15000.0f)));
            } else {
                UCropActivity.this.I7.H(UCropActivity.this.I7.getCurrentScale() + (f10 * ((UCropActivity.this.I7.getMaxScale() - UCropActivity.this.I7.getMinScale()) / 15000.0f)));
            }
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.a
        public void c() {
            UCropActivity.this.I7.w();
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
            UCropActivity.this.A4(view.getId());
        }
    }

    public class h implements jh.a {
        public h() {
        }

        @Override // jh.a
        public void a(@n0 Uri uri, int i10, int i11, int i12, int i13) {
            UCropActivity uCropActivity = UCropActivity.this;
            uCropActivity.w4(uri, uCropActivity.I7.getTargetAspectRatio(), i10, i11, i12, i13);
            UCropActivity.this.finish();
        }

        @Override // jh.a
        public void b(@n0 Throwable th2) {
            UCropActivity.this.v4(th2);
            UCropActivity.this.finish();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface i {
    }

    static {
        androidx.appcompat.app.h.J(true);
    }

    public final void A4(@d0 int i10) {
        if (this.F7) {
            ViewGroup viewGroup = this.K7;
            int i11 = R.id.state_aspect_ratio;
            viewGroup.setSelected(i10 == i11);
            ViewGroup viewGroup2 = this.L7;
            int i12 = R.id.state_rotate;
            viewGroup2.setSelected(i10 == i12);
            ViewGroup viewGroup3 = this.M7;
            int i13 = R.id.state_scale;
            viewGroup3.setSelected(i10 == i13);
            this.N7.setVisibility(i10 == i11 ? 0 : 8);
            this.O7.setVisibility(i10 == i12 ? 0 : 8);
            this.P7.setVisibility(i10 == i13 ? 0 : 8);
            k4(i10);
            if (i10 == i13) {
                q4(0);
            } else if (i10 == i12) {
                q4(1);
            } else {
                q4(2);
            }
        }
    }

    public final void B4() {
        z4(this.f24892v1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(this.f24891k1);
        toolbar.setTitleTextColor(this.K1);
        TextView textView = (TextView) toolbar.findViewById(R.id.toolbar_title);
        textView.setTextColor(this.K1);
        textView.setText(this.K0);
        Drawable drawableMutate = h0.d.i(this, this.C2).mutate();
        drawableMutate.setColorFilter(this.K1, PorterDuff.Mode.SRC_ATOP);
        toolbar.setNavigationIcon(drawableMutate);
        Q3(toolbar);
        androidx.appcompat.app.a aVarI3 = I3();
        if (aVarI3 != null) {
            aVarI3.d0(false);
        }
    }

    public final void C4(@n0 Intent intent) {
        int intExtra = intent.getIntExtra(a.C0278a.B, 0);
        ArrayList<AspectRatio> parcelableArrayListExtra = intent.getParcelableArrayListExtra(a.C0278a.C);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            intExtra = 2;
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        for (AspectRatio aspectRatio : parcelableArrayListExtra) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.C1);
            aspectRatioTextView.setAspectRatio(aspectRatio);
            linearLayout.addView(frameLayout);
            this.Q7.add(frameLayout);
        }
        this.Q7.get(intExtra).setSelected(true);
        Iterator<ViewGroup> it2 = this.Q7.iterator();
        while (it2.hasNext()) {
            it2.next().setOnClickListener(new b());
        }
    }

    public final void D4() {
        this.R7 = (TextView) findViewById(R.id.text_view_rotate);
        int i10 = R.id.rotate_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i10)).setScrollingListener(new c());
        ((HorizontalProgressWheelView) findViewById(i10)).setMiddleLineColor(this.C1);
        findViewById(R.id.wrapper_reset_rotate).setOnClickListener(new d());
        findViewById(R.id.wrapper_rotate_by_angle).setOnClickListener(new e());
        s4(this.C1);
    }

    public final void E4() {
        this.S7 = (TextView) findViewById(R.id.text_view_scale);
        int i10 = R.id.scale_scroll_wheel;
        ((HorizontalProgressWheelView) findViewById(i10)).setScrollingListener(new f());
        ((HorizontalProgressWheelView) findViewById(i10)).setMiddleLineColor(this.C1);
        y4(this.C1);
    }

    public final void F4() {
        ImageView imageView = (ImageView) findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new mh.i(imageView.getDrawable(), this.C1));
        imageView2.setImageDrawable(new mh.i(imageView2.getDrawable(), this.C1));
        imageView3.setImageDrawable(new mh.i(imageView3.getDrawable(), this.C1));
    }

    public final void G4(@n0 Intent intent) {
        this.f24892v1 = intent.getIntExtra(a.C0278a.f24972s, h0.d.f(this, R.color.ucrop_color_statusbar));
        this.f24891k1 = intent.getIntExtra(a.C0278a.f24971r, h0.d.f(this, R.color.ucrop_color_toolbar));
        this.C1 = intent.getIntExtra(a.C0278a.f24973t, h0.d.f(this, R.color.ucrop_color_active_controls_color));
        this.K1 = intent.getIntExtra(a.C0278a.f24974u, h0.d.f(this, R.color.ucrop_color_toolbar_widget));
        this.C2 = intent.getIntExtra(a.C0278a.f24976w, R.drawable.ucrop_ic_cross);
        this.K2 = intent.getIntExtra(a.C0278a.f24977x, R.drawable.ucrop_ic_done);
        String stringExtra = intent.getStringExtra(a.C0278a.f24975v);
        this.K0 = stringExtra;
        if (stringExtra == null) {
            stringExtra = getResources().getString(R.string.ucrop_label_edit_photo);
        }
        this.K0 = stringExtra;
        this.E7 = intent.getIntExtra(a.C0278a.f24978y, h0.d.f(this, R.color.ucrop_color_default_logo));
        this.F7 = !intent.getBooleanExtra(a.C0278a.f24979z, false);
        this.f24893v2 = intent.getIntExtra(a.C0278a.D, h0.d.f(this, R.color.ucrop_color_crop_background));
        B4();
        m4();
        if (this.F7) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(R.id.ucrop_photobox)).findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            LayoutInflater.from(this).inflate(R.layout.ucrop_controls, viewGroup, true);
            g2.a aVar = new g2.a();
            this.U7 = aVar;
            aVar.y0(50L);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.state_aspect_ratio);
            this.K7 = viewGroup2;
            viewGroup2.setOnClickListener(this.Z7);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.state_rotate);
            this.L7 = viewGroup3;
            viewGroup3.setOnClickListener(this.Z7);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(R.id.state_scale);
            this.M7 = viewGroup4;
            viewGroup4.setOnClickListener(this.Z7);
            this.N7 = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
            this.O7 = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
            this.P7 = (ViewGroup) findViewById(R.id.layout_scale_wheel);
            C4(intent);
            D4();
            E4();
            F4();
        }
    }

    public final void j4() {
        if (this.T7 == null) {
            this.T7 = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.toolbar);
            this.T7.setLayoutParams(layoutParams);
            this.T7.setClickable(true);
        }
        ((RelativeLayout) findViewById(R.id.ucrop_photobox)).addView(this.T7);
    }

    public final void k4(int i10) {
        u.b((ViewGroup) findViewById(R.id.ucrop_photobox), this.U7);
        this.M7.findViewById(R.id.text_view_scale).setVisibility(i10 == R.id.state_scale ? 0 : 8);
        this.K7.findViewById(R.id.text_view_crop).setVisibility(i10 == R.id.state_aspect_ratio ? 0 : 8);
        this.L7.findViewById(R.id.text_view_rotate).setVisibility(i10 != R.id.state_rotate ? 8 : 0);
    }

    public void l4() {
        this.T7.setClickable(true);
        this.G7 = true;
        E3();
        this.I7.x(this.V7, this.W7, new h());
    }

    public final void m4() {
        UCropView uCropView = (UCropView) findViewById(R.id.ucrop);
        this.H7 = uCropView;
        this.I7 = uCropView.getCropImageView();
        this.J7 = this.H7.getOverlayView();
        this.I7.setTransformImageListener(this.Y7);
        ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.E7, PorterDuff.Mode.SRC_ATOP);
        int i10 = R.id.ucrop_frame;
        findViewById(i10).setBackgroundColor(this.f24893v2);
        if (this.F7) {
            return;
        }
        ((RelativeLayout.LayoutParams) findViewById(i10).getLayoutParams()).bottomMargin = 0;
        findViewById(i10).requestLayout();
    }

    public final void n4(@n0 Intent intent) {
        String stringExtra = intent.getStringExtra(a.C0278a.f24955b);
        Bitmap.CompressFormat compressFormatValueOf = !TextUtils.isEmpty(stringExtra) ? Bitmap.CompressFormat.valueOf(stringExtra) : null;
        if (compressFormatValueOf == null) {
            compressFormatValueOf = f24881b8;
        }
        this.V7 = compressFormatValueOf;
        this.W7 = intent.getIntExtra(a.C0278a.f24956c, 90);
        int[] intArrayExtra = intent.getIntArrayExtra(a.C0278a.f24957d);
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.X7 = intArrayExtra;
        }
        this.I7.setMaxBitmapSize(intent.getIntExtra(a.C0278a.f24958e, 0));
        this.I7.setMaxScaleMultiplier(intent.getFloatExtra(a.C0278a.f24959f, 10.0f));
        this.I7.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra(a.C0278a.f24960g, 500));
        this.J7.setFreestyleCropEnabled(intent.getBooleanExtra(a.C0278a.A, false));
        this.J7.setDimmedColor(intent.getIntExtra(a.C0278a.f24961h, getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.J7.setCircleDimmedLayer(intent.getBooleanExtra(a.C0278a.f24962i, false));
        this.J7.setShowCropFrame(intent.getBooleanExtra(a.C0278a.f24963j, true));
        this.J7.setCropFrameColor(intent.getIntExtra(a.C0278a.f24964k, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.J7.setCropFrameStrokeWidth(intent.getIntExtra(a.C0278a.f24965l, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.J7.setShowCropGrid(intent.getBooleanExtra(a.C0278a.f24966m, true));
        this.J7.setCropGridRowCount(intent.getIntExtra(a.C0278a.f24967n, 2));
        this.J7.setCropGridColumnCount(intent.getIntExtra(a.C0278a.f24968o, 2));
        this.J7.setCropGridColor(intent.getIntExtra(a.C0278a.f24969p, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.J7.setCropGridStrokeWidth(intent.getIntExtra(a.C0278a.f24970q, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra(com.yalantis.ucrop.a.f24949o, -1.0f);
        float floatExtra2 = intent.getFloatExtra(com.yalantis.ucrop.a.f24950p, -1.0f);
        int intExtra = intent.getIntExtra(a.C0278a.B, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(a.C0278a.C);
        if (floatExtra >= 0.0f && floatExtra2 >= 0.0f) {
            ViewGroup viewGroup = this.K7;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            float f10 = floatExtra / floatExtra2;
            this.I7.setTargetAspectRatio(Float.isNaN(f10) ? 0.0f : f10);
        } else if (parcelableArrayListExtra == null || intExtra >= parcelableArrayListExtra.size()) {
            this.I7.setTargetAspectRatio(0.0f);
        } else {
            float fB = ((AspectRatio) parcelableArrayListExtra.get(intExtra)).b() / ((AspectRatio) parcelableArrayListExtra.get(intExtra)).e();
            this.I7.setTargetAspectRatio(Float.isNaN(fB) ? 0.0f : fB);
        }
        int intExtra2 = intent.getIntExtra(com.yalantis.ucrop.a.f24951q, 0);
        int intExtra3 = intent.getIntExtra(com.yalantis.ucrop.a.f24952r, 0);
        if (intExtra2 <= 0 || intExtra3 <= 0) {
            return;
        }
        this.I7.setMaxResultImageSizeX(intExtra2);
        this.I7.setMaxResultImageSizeY(intExtra3);
    }

    public final void o4() {
        GestureCropImageView gestureCropImageView = this.I7;
        gestureCropImageView.A(-gestureCropImageView.getCurrentAngle());
        this.I7.C();
    }

    @Override // androidx.fragment.app.g, androidx.activity.ComponentActivity, f0.l, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ucrop_activity_photobox);
        Intent intent = getIntent();
        G4(intent);
        t4(intent);
        u4();
        j4();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ucrop_menu_activity, menu);
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_loader);
        Drawable icon = menuItemFindItem.getIcon();
        if (icon != null) {
            try {
                icon.mutate();
                icon.setColorFilter(this.K1, PorterDuff.Mode.SRC_ATOP);
                menuItemFindItem.setIcon(icon);
            } catch (IllegalStateException e10) {
                String.format("%s - %s", e10.getMessage(), getString(R.string.ucrop_mutate_exception_hint));
            }
            ((Animatable) menuItemFindItem.getIcon()).start();
        }
        MenuItem menuItemFindItem2 = menu.findItem(R.id.menu_crop);
        Drawable drawableI = h0.d.i(this, this.K2);
        if (drawableI != null) {
            drawableI.mutate();
            drawableI.setColorFilter(this.K1, PorterDuff.Mode.SRC_ATOP);
            menuItemFindItem2.setIcon(drawableI);
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.menu_crop) {
            l4();
            return true;
        }
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.menu_crop).setVisible(!this.G7);
        menu.findItem(R.id.menu_loader).setVisible(this.G7);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.appcompat.app.f, androidx.fragment.app.g, android.app.Activity
    public void onStop() {
        super.onStop();
        GestureCropImageView gestureCropImageView = this.I7;
        if (gestureCropImageView != null) {
            gestureCropImageView.w();
        }
    }

    public final void p4(int i10) {
        this.I7.A(i10);
        this.I7.C();
    }

    public final void q4(int i10) {
        GestureCropImageView gestureCropImageView = this.I7;
        int[] iArr = this.X7;
        gestureCropImageView.setScaleEnabled(iArr[i10] == 3 || iArr[i10] == 1);
        GestureCropImageView gestureCropImageView2 = this.I7;
        int[] iArr2 = this.X7;
        gestureCropImageView2.setRotateEnabled(iArr2[i10] == 3 || iArr2[i10] == 2);
    }

    public final void r4(float f10) {
        TextView textView = this.R7;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f10)));
        }
    }

    public final void s4(int i10) {
        TextView textView = this.R7;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    public final void t4(@n0 Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra(com.yalantis.ucrop.a.f24941g);
        Uri uri2 = (Uri) intent.getParcelableExtra(com.yalantis.ucrop.a.f24942h);
        n4(intent);
        if (uri == null || uri2 == null) {
            v4(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent)));
            finish();
            return;
        }
        try {
            this.I7.q(uri, uri2);
        } catch (Exception e10) {
            v4(e10);
            finish();
        }
    }

    public final void u4() {
        if (!this.F7) {
            q4(0);
        } else if (this.K7.getVisibility() == 0) {
            A4(R.id.state_aspect_ratio);
        } else {
            A4(R.id.state_scale);
        }
    }

    public void v4(Throwable th2) {
        setResult(96, new Intent().putExtra(com.yalantis.ucrop.a.f24948n, th2));
    }

    public void w4(Uri uri, float f10, int i10, int i11, int i12, int i13) {
        setResult(-1, new Intent().putExtra(com.yalantis.ucrop.a.f24942h, uri).putExtra(com.yalantis.ucrop.a.f24943i, f10).putExtra(com.yalantis.ucrop.a.f24944j, i12).putExtra(com.yalantis.ucrop.a.f24945k, i13).putExtra(com.yalantis.ucrop.a.f24946l, i10).putExtra(com.yalantis.ucrop.a.f24947m, i11));
    }

    public final void x4(float f10) {
        TextView textView = this.S7;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f10 * 100.0f))));
        }
    }

    public final void y4(int i10) {
        TextView textView = this.S7;
        if (textView != null) {
            textView.setTextColor(i10);
        }
    }

    @TargetApi(21)
    public final void z4(@l int i10) {
        Window window = getWindow();
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(i10);
        }
    }
}
