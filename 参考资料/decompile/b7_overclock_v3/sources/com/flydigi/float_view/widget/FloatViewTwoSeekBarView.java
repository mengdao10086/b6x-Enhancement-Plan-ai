package com.flydigi.float_view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.o;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewTwoSeekBarView;
import hk.i;
import java.text.NumberFormat;
import kotlin.Pair;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import w7.m2;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class FloatViewTwoSeekBarView extends ConstraintLayout {

    @k
    public final m2 C1;
    public int C2;

    @l
    public d E7;

    @l
    public c F7;
    public int K1;
    public boolean K2;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public boolean f15794v2;

    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FloatViewTwoSeekBarView f15796b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NumberFormat f15797c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f15798d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f15799e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f15800f;

        public a(int i10, FloatViewTwoSeekBarView floatViewTwoSeekBarView, NumberFormat numberFormat, float f10, boolean z10, String str) {
            this.f15795a = i10;
            this.f15796b = floatViewTwoSeekBarView;
            this.f15797c = numberFormat;
            this.f15798d = f10;
            this.f15799e = z10;
            this.f15800f = str;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@k SeekBar seekBar, int i10, boolean z10) {
            f0.p(seekBar, "seekBar");
            int i11 = this.f15795a;
            if (i10 < i11) {
                i10 = i11;
            }
            this.f15796b.C1.f54290p.setProgress(i10);
            String str = this.f15797c.format(Float.valueOf(i10 * this.f15798d));
            if (!this.f15799e || TextUtils.isEmpty(this.f15800f)) {
                this.f15796b.C1.D.setText(str);
            } else {
                this.f15796b.C1.D.setText(str + this.f15800f);
            }
            if (this.f15796b.C1.f54288n.isSelected()) {
                this.f15796b.C1.f54289o.setProgress(this.f15796b.C1.f54290p.getProgress());
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@k SeekBar seekBar) {
            f0.p(seekBar, "seekBar");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@k SeekBar seekBar) {
            f0.p(seekBar, "seekBar");
        }
    }

    public static final class b implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15801a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FloatViewTwoSeekBarView f15802b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ NumberFormat f15803c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ float f15804d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f15805e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ String f15806f;

        public b(int i10, FloatViewTwoSeekBarView floatViewTwoSeekBarView, NumberFormat numberFormat, float f10, boolean z10, String str) {
            this.f15801a = i10;
            this.f15802b = floatViewTwoSeekBarView;
            this.f15803c = numberFormat;
            this.f15804d = f10;
            this.f15805e = z10;
            this.f15806f = str;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@k SeekBar seekBar, int i10, boolean z10) {
            f0.p(seekBar, "seekBar");
            int i11 = this.f15801a;
            if (i10 < i11) {
                i10 = i11;
            }
            this.f15802b.C1.f54289o.setProgress(i10);
            String str = this.f15803c.format(Float.valueOf(i10 * this.f15804d));
            if (!this.f15805e || TextUtils.isEmpty(this.f15806f)) {
                this.f15802b.C1.C.setText(str);
            } else {
                this.f15802b.C1.C.setText(str + this.f15806f);
            }
            if (this.f15802b.C1.f54288n.isSelected()) {
                this.f15802b.C1.f54290p.setProgress(this.f15802b.C1.f54289o.getProgress());
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@k SeekBar seekBar) {
            f0.p(seekBar, "seekBar");
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@k SeekBar seekBar) {
            f0.p(seekBar, "seekBar");
        }
    }

    public interface c {
        void a(boolean z10);

        void b(boolean z10);
    }

    public interface d {
        void a();

        void b();

        void c();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewTwoSeekBarView(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewTwoSeekBarView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ FloatViewTwoSeekBarView(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public static final void Y(FloatViewTwoSeekBarView this$0, View view) {
        f0.p(this$0, "this$0");
        if (this$0.C1.f54290p.getProgress() < this$0.C1.f54290p.getMax()) {
            SeekBar seekBar = this$0.C1.f54290p;
            seekBar.setProgress(seekBar.getProgress() + 1);
            if (this$0.C1.f54288n.isSelected()) {
                m2 m2Var = this$0.C1;
                m2Var.f54289o.setProgress(m2Var.f54290p.getProgress());
            }
        }
    }

    public static final void Z(FloatViewTwoSeekBarView this$0, int i10, View view) {
        f0.p(this$0, "this$0");
        if (this$0.C1.f54290p.getProgress() > i10) {
            this$0.C1.f54290p.setProgress(r1.getProgress() - 1);
            if (this$0.C1.f54288n.isSelected()) {
                m2 m2Var = this$0.C1;
                m2Var.f54289o.setProgress(m2Var.f54290p.getProgress());
            }
        }
    }

    public static final void a0(FloatViewTwoSeekBarView this$0, View view) {
        f0.p(this$0, "this$0");
        d dVar = this$0.E7;
        if (dVar != null) {
            dVar.c();
        }
    }

    public static final void b0(FloatViewTwoSeekBarView this$0, View view) {
        f0.p(this$0, "this$0");
        if (this$0.C1.f54289o.getProgress() < this$0.C1.f54289o.getMax()) {
            SeekBar seekBar = this$0.C1.f54289o;
            seekBar.setProgress(seekBar.getProgress() + 1);
            if (this$0.C1.f54288n.isSelected()) {
                SeekBar seekBar2 = this$0.C1.f54289o;
                seekBar2.setProgress(seekBar2.getProgress());
            }
        }
    }

    public static final void c0(FloatViewTwoSeekBarView this$0, int i10, View view) {
        f0.p(this$0, "this$0");
        if (this$0.C1.f54289o.getProgress() > i10) {
            this$0.C1.f54289o.setProgress(r1.getProgress() - 1);
            if (this$0.C1.f54288n.isSelected()) {
                SeekBar seekBar = this$0.C1.f54289o;
                seekBar.setProgress(seekBar.getProgress());
            }
        }
    }

    public static final void d0(FloatViewTwoSeekBarView this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.C1.f54288n.setSelected(!r0.isSelected());
    }

    public static final void e0(FloatViewTwoSeekBarView this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.C1.f54285k.performClick();
    }

    public static final void f0(FloatViewTwoSeekBarView this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.C1.f54285k.setSelected(!r2.isSelected());
        c cVar = this$0.F7;
        if (cVar != null) {
            cVar.a(this$0.C1.f54285k.isSelected());
        }
    }

    public static final void g0(FloatViewTwoSeekBarView this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.C1.f54283i.performClick();
    }

    public static final void h0(FloatViewTwoSeekBarView this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.C1.f54283i.setSelected(!r2.isSelected());
        c cVar = this$0.F7;
        if (cVar != null) {
            cVar.b(this$0.C1.f54283i.isSelected());
        }
    }

    public static final void i0(FloatViewTwoSeekBarView this$0, View view) {
        f0.p(this$0, "this$0");
        d dVar = this$0.E7;
        if (dVar != null) {
            dVar.b();
        }
    }

    public static /* synthetic */ void n0(FloatViewTwoSeekBarView floatViewTwoSeekBarView, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            z11 = false;
        }
        floatViewTwoSeekBarView.m0(i10, i11, z10, z11);
    }

    @k
    public final Pair<Boolean, Boolean> getCheckBoxValue() {
        return new Pair<>(Boolean.valueOf(this.C1.f54285k.isSelected()), Boolean.valueOf(this.C1.f54283i.isSelected()));
    }

    @l
    public final c getOnCheckBoxClickListener$float_view_officialRelease() {
        return this.F7;
    }

    @l
    public final d getOnHelpClickListener$float_view_officialRelease() {
        return this.E7;
    }

    @k
    public final Pair<Integer, Integer> getValue() {
        return new Pair<>(Integer.valueOf(this.C1.f54290p.getProgress()), Integer.valueOf(this.C1.f54289o.getProgress()));
    }

    public final void k0() {
        m0(this.K1, this.C2, this.f15794v2, this.K2);
    }

    public final void m0(int i10, int i11, boolean z10, boolean z11) {
        this.C1.f54288n.setSelected(i11 == i10);
        this.C1.f54290p.setProgress(i10);
        this.C1.f54289o.setProgress(i11);
        this.C1.f54285k.setSelected(z10);
        this.C1.f54283i.setSelected(z11);
    }

    public final void o0(@k String nameUp, @k String nameDown) {
        f0.p(nameUp, "nameUp");
        f0.p(nameDown, "nameDown");
        this.C1.f54297w.setText(nameUp);
        this.C1.f54296v.setText(nameDown);
    }

    public final void setOnCheckBoxClickListener$float_view_officialRelease(@l c cVar) {
        this.F7 = cVar;
    }

    public final void setOnHelpClickListener$float_view_officialRelease(@l d dVar) {
        this.E7 = dVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewTwoSeekBarView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        m2 m2VarD = m2.d(LayoutInflater.from(context), null, false);
        f0.o(m2VarD, "inflate(LayoutInflater.from(context), null, false)");
        this.C1 = m2VarD;
        addView(m2VarD.getRoot(), new ConstraintLayout.b(-1, -2));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatViewTwoSeekBarView);
        f0.o(typedArrayObtainStyledAttributes, "context.obtainStyledAttr….FloatViewTwoSeekBarView)");
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_title);
        m2VarD.f54300z.setText(string);
        if (!typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_show_title, false) || TextUtils.isEmpty(string)) {
            TextView textView = m2VarD.f54300z;
            f0.o(textView, "viewBinding.tvTitle");
            o5.c.b(textView, Boolean.FALSE, false, 2, null);
        } else {
            TextView textView2 = m2VarD.f54300z;
            f0.o(textView2, "viewBinding.tvTitle");
            o5.c.b(textView2, Boolean.TRUE, false, 2, null);
        }
        m2VarD.f54297w.setText(typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_name_up));
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_unit_name_up);
        float f10 = typedArrayObtainStyledAttributes.getFloat(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_unit_up, 1.0f);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_show_unit_up, false);
        m2VarD.B.setText(string2);
        if (!z10 || TextUtils.isEmpty(string2)) {
            TextView textView3 = m2VarD.B;
            f0.o(textView3, "viewBinding.tvUnitUp");
            o5.c.b(textView3, Boolean.FALSE, false, 2, null);
        } else {
            TextView textView4 = m2VarD.B;
            f0.o(textView4, "viewBinding.tvUnitUp");
            o5.c.b(textView4, Boolean.TRUE, false, 2, null);
        }
        m2VarD.f54290p.setMax(typedArrayObtainStyledAttributes.getInteger(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_value_up_max, 127));
        this.K1 = typedArrayObtainStyledAttributes.getInteger(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_value_up_default, 0);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_show_hint_up, false);
        String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_hint_min_up);
        string3 = string3 == null ? "" : string3;
        String string4 = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_hint_max_up);
        string4 = string4 == null ? "" : string4;
        m2VarD.f54295u.setText(string3);
        m2VarD.f54299y.setText(string4);
        if (z11) {
            TextView textView5 = m2VarD.f54295u;
            f0.o(textView5, "viewBinding.tvMinusUpHint");
            Boolean bool = Boolean.TRUE;
            o5.c.b(textView5, bool, false, 2, null);
            TextView textView6 = m2VarD.f54299y;
            f0.o(textView6, "viewBinding.tvPlusUpHint");
            o5.c.b(textView6, bool, false, 2, null);
        } else {
            TextView textView7 = m2VarD.f54295u;
            f0.o(textView7, "viewBinding.tvMinusUpHint");
            Boolean bool2 = Boolean.FALSE;
            o5.c.b(textView7, bool2, false, 2, null);
            TextView textView8 = m2VarD.f54299y;
            f0.o(textView8, "viewBinding.tvPlusUpHint");
            o5.c.b(textView8, bool2, false, 2, null);
        }
        m2VarD.f54296v.setText(typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_name_down));
        String string5 = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_unit_name_down);
        boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_show_unit_down, false);
        float f11 = typedArrayObtainStyledAttributes.getFloat(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_unit_down, 1.0f);
        m2VarD.A.setText(string5);
        if (!z12 || TextUtils.isEmpty(string5)) {
            TextView textView9 = m2VarD.A;
            f0.o(textView9, "viewBinding.tvUnitDown");
            o5.c.b(textView9, Boolean.FALSE, false, 2, null);
        } else {
            TextView textView10 = m2VarD.A;
            f0.o(textView10, "viewBinding.tvUnitDown");
            o5.c.b(textView10, Boolean.TRUE, false, 2, null);
        }
        m2VarD.f54289o.setMax(typedArrayObtainStyledAttributes.getInteger(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_value_down_max, 127));
        this.C2 = typedArrayObtainStyledAttributes.getInteger(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_value_down_default, 0);
        boolean z13 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_show_hint_down, false);
        String string6 = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_hint_min_down);
        string6 = string6 == null ? "" : string6;
        String string7 = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_hint_max_down);
        String str = string7 != null ? string7 : "";
        m2VarD.f54294t.setText(string6);
        m2VarD.f54298x.setText(str);
        if (z13) {
            TextView textView11 = m2VarD.f54294t;
            f0.o(textView11, "viewBinding.tvMinusDownHint");
            Boolean bool3 = Boolean.TRUE;
            o5.c.b(textView11, bool3, false, 2, null);
            TextView textView12 = m2VarD.f54298x;
            f0.o(textView12, "viewBinding.tvPlusDownHint");
            o5.c.b(textView12, bool3, false, 2, null);
        } else {
            TextView textView13 = m2VarD.f54294t;
            f0.o(textView13, "viewBinding.tvMinusDownHint");
            Boolean bool4 = Boolean.FALSE;
            o5.c.b(textView13, bool4, false, 2, null);
            TextView textView14 = m2VarD.f54298x;
            f0.o(textView14, "viewBinding.tvPlusDownHint");
            o5.c.b(textView14, bool4, false, 2, null);
        }
        boolean z14 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_show_cb_up, false);
        String string8 = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_cb_name_up);
        if (!z14 || TextUtils.isEmpty(string8)) {
            LinearLayout linearLayout = m2VarD.f54282h;
            f0.o(linearLayout, "viewBinding.cbUp");
            o5.c.b(linearLayout, Boolean.FALSE, false, 2, null);
        } else {
            LinearLayout linearLayout2 = m2VarD.f54282h;
            f0.o(linearLayout2, "viewBinding.cbUp");
            o5.c.b(linearLayout2, Boolean.TRUE, false, 2, null);
            m2VarD.f54293s.setText(string8);
        }
        boolean z15 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_show_cb_down, false);
        String string9 = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_cb_name_down);
        if (!z15 || TextUtils.isEmpty(string9)) {
            LinearLayout linearLayout3 = m2VarD.f54281g;
            f0.o(linearLayout3, "viewBinding.cbDown");
            o5.c.b(linearLayout3, Boolean.FALSE, false, 2, null);
        } else {
            LinearLayout linearLayout4 = m2VarD.f54281g;
            f0.o(linearLayout4, "viewBinding.cbDown");
            o5.c.b(linearLayout4, Boolean.TRUE, false, 2, null);
            m2VarD.f54292r.setText(string9);
        }
        m2VarD.f54286l.setVisibility(typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_show_cb_up_help, false) ? 0 : 8);
        m2VarD.f54284j.setVisibility(typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_show_cb_down_help, false) ? 0 : 8);
        this.f15794v2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_cb_up_default, false);
        this.K2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_cb_down_default, false);
        boolean z16 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_unit_up_inside, false);
        boolean z17 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_unit_down_inside, false);
        int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_value_up_format, 1);
        int integer2 = typedArrayObtainStyledAttributes.getInteger(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_value_down_format, 1);
        NumberFormat.getInstance().setMaximumFractionDigits(integer);
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(integer2);
        final int integer3 = typedArrayObtainStyledAttributes.getInteger(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_value_down_min, 0);
        final int integer4 = typedArrayObtainStyledAttributes.getInteger(R.styleable.FloatViewTwoSeekBarView_floatview_tsb_value_up_min, 0);
        typedArrayObtainStyledAttributes.recycle();
        m2VarD.f54280f.setOnClickListener(new View.OnClickListener() { // from class: o8.k0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoSeekBarView.Y(this.f42842a, view);
            }
        });
        m2VarD.f54278d.setOnClickListener(new View.OnClickListener() { // from class: o8.l0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoSeekBarView.Z(this.f42844a, integer4, view);
            }
        });
        m2VarD.f54279e.setOnClickListener(new View.OnClickListener() { // from class: o8.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoSeekBarView.b0(this.f42831a, view);
            }
        });
        m2VarD.f54277c.setOnClickListener(new View.OnClickListener() { // from class: o8.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoSeekBarView.c0(this.f42820a, integer3, view);
            }
        });
        o.r(m2VarD.f54288n, new View.OnClickListener() { // from class: o8.d0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoSeekBarView.d0(this.f42823a, view);
            }
        });
        m2VarD.f54290p.setOnSeekBarChangeListener(new a(integer4, this, numberFormat, f10, z16, string2));
        m2VarD.f54289o.setOnSeekBarChangeListener(new b(integer3, this, numberFormat, f11, z17, string5));
        o.r(m2VarD.f54282h, new View.OnClickListener() { // from class: o8.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoSeekBarView.e0(this.f42827a, view);
            }
        });
        o.r(m2VarD.f54285k, new View.OnClickListener() { // from class: o8.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoSeekBarView.f0(this.f42840a, view);
            }
        });
        o.r(m2VarD.f54281g, new View.OnClickListener() { // from class: o8.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoSeekBarView.g0(this.f42818a, view);
            }
        });
        o.r(m2VarD.f54283i, new View.OnClickListener() { // from class: o8.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoSeekBarView.h0(this.f42835a, view);
            }
        });
        o.r(m2VarD.f54286l, new View.OnClickListener() { // from class: o8.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoSeekBarView.i0(this.f42829a, view);
            }
        });
        o.r(m2VarD.f54284j, new View.OnClickListener() { // from class: o8.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewTwoSeekBarView.a0(this.f42825a, view);
            }
        });
        k0();
    }
}
