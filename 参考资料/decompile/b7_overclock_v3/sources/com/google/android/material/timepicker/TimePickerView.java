package com.google.android.material.timepicker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import g.c1;
import g.n0;
import g.p0;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
class TimePickerView extends ConstraintLayout implements g {
    public static final String I7 = "android.view.View";
    public final Chip C1;
    public final ClockFaceView C2;
    public final View.OnClickListener E7;
    public e F7;
    public f G7;
    public d H7;
    public final Chip K1;
    public final MaterialButtonToggleGroup K2;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public final ClockHandView f21115v2;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TimePickerView.this.G7 != null) {
                TimePickerView.this.G7.h(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            d dVar = TimePickerView.this.H7;
            if (dVar == null) {
                return false;
            }
            dVar.g();
            return true;
        }
    }

    public class c implements View.OnTouchListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GestureDetector f21118a;

        public c(GestureDetector gestureDetector) {
            this.f21118a = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.f21118a.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    public interface d {
        void g();
    }

    public interface e {
        void g(int i10);
    }

    public interface f {
        void h(int i10);
    }

    public TimePickerView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10) {
        e eVar;
        if (z10 && (eVar = this.F7) != null) {
            eVar.g(i10 == R.id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    public void Q(ClockHandView.d dVar) {
        this.f21115v2.b(dVar);
    }

    public void S(boolean z10) {
        this.f21115v2.j(z10);
    }

    public void T(float f10, boolean z10) {
        this.f21115v2.m(f10, z10);
    }

    public void U(androidx.core.view.a aVar) {
        u0.B1(this.C1, aVar);
    }

    public void V(androidx.core.view.a aVar) {
        u0.B1(this.K1, aVar);
    }

    public void W(ClockHandView.c cVar) {
        this.f21115v2.o(cVar);
    }

    public void X(@p0 d dVar) {
        this.H7 = dVar;
    }

    public void Y(e eVar) {
        this.F7 = eVar;
    }

    public void Z(f fVar) {
        this.G7 = fVar;
    }

    @Override // com.google.android.material.timepicker.g
    public void a(int i10) {
        d0(this.C1, i10 == 12);
        d0(this.K1, i10 == 10);
    }

    public final void a0() {
        Chip chip = this.C1;
        int i10 = R.id.selection_type;
        chip.setTag(i10, 12);
        this.K1.setTag(i10, 10);
        this.C1.setOnClickListener(this.E7);
        this.K1.setOnClickListener(this.E7);
        this.C1.setAccessibilityClassName("android.view.View");
        this.K1.setAccessibilityClassName("android.view.View");
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void b0() {
        c cVar = new c(new GestureDetector(getContext(), new b()));
        this.C1.setOnTouchListener(cVar);
        this.K1.setOnTouchListener(cVar);
    }

    @Override // com.google.android.material.timepicker.g
    @SuppressLint({"DefaultLocale"})
    public void c(int i10, int i11, int i12) {
        this.K2.e(i10 == 1 ? R.id.material_clock_period_pm_button : R.id.material_clock_period_am_button);
        Locale locale = getResources().getConfiguration().locale;
        String str = String.format(locale, TimeModel.f21106h, Integer.valueOf(i12));
        String str2 = String.format(locale, TimeModel.f21106h, Integer.valueOf(i11));
        if (!TextUtils.equals(this.C1.getText(), str)) {
            this.C1.setText(str);
        }
        if (TextUtils.equals(this.K1.getText(), str2)) {
            return;
        }
        this.K1.setText(str2);
    }

    public void c0() {
        this.K2.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.g
    public void d(String[] strArr, @c1 int i10) {
        this.C2.d(strArr, i10);
    }

    public final void d0(Chip chip, boolean z10) {
        chip.setChecked(z10);
        u0.D1(chip, z10 ? 2 : 0);
    }

    public final void e0() {
        if (this.K2.getVisibility() == 0) {
            androidx.constraintlayout.widget.d dVar = new androidx.constraintlayout.widget.d();
            dVar.H(this);
            dVar.F(R.id.material_clock_display, u0.Z(this) == 0 ? 2 : 1);
            dVar.r(this);
        }
    }

    @Override // com.google.android.material.timepicker.g
    public void h(float f10) {
        this.f21115v2.l(f10);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e0();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@n0 View view, int i10) {
        super.onVisibilityChanged(view, i10);
        if (view == this && i10 == 0) {
            e0();
        }
    }

    public TimePickerView(Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.E7 = new a();
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.C2 = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.K2 = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new MaterialButtonToggleGroup.d() { // from class: com.google.android.material.timepicker.l
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.d
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i11, boolean z10) {
                this.f21160a.R(materialButtonToggleGroup2, i11, z10);
            }
        });
        this.C1 = (Chip) findViewById(R.id.material_minute_tv);
        this.K1 = (Chip) findViewById(R.id.material_hour_tv);
        this.f21115v2 = (ClockHandView) findViewById(R.id.material_clock_hand);
        b0();
        a0();
    }
}
