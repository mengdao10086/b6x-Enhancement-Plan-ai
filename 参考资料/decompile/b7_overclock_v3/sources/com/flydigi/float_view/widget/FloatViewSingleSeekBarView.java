package com.flydigi.float_view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.o;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleSeekBarView;
import hk.i;
import java.text.NumberFormat;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import w7.j2;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class FloatViewSingleSeekBarView extends ConstraintLayout {
    public static final int E7 = 0;
    public static final int F7 = 1;
    public static final int G7 = 2;

    @k
    public static final b K2 = new b(null);

    @k
    public final j2 C1;

    @l
    public d C2;
    public int K1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    @l
    public c f15767v2;

    public static final class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FloatViewSingleSeekBarView f15769b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f15770c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f15771d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ NumberFormat f15772e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ float f15773f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f15774g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ String f15775h;

        public a(int i10, FloatViewSingleSeekBarView floatViewSingleSeekBarView, int i11, int i12, NumberFormat numberFormat, float f10, boolean z10, String str) {
            this.f15768a = i10;
            this.f15769b = floatViewSingleSeekBarView;
            this.f15770c = i11;
            this.f15771d = i12;
            this.f15772e = numberFormat;
            this.f15773f = f10;
            this.f15774g = z10;
            this.f15775h = str;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(@k SeekBar seekBar, int i10, boolean z10) {
            String str;
            f0.p(seekBar, "seekBar");
            int i11 = this.f15768a;
            if (i10 < i11) {
                i10 = i11;
            }
            this.f15769b.C1.f54195g.setProgress(i10);
            d onValueChangedListener$float_view_officialRelease = this.f15769b.getOnValueChangedListener$float_view_officialRelease();
            if (onValueChangedListener$float_view_officialRelease != null) {
                onValueChangedListener$float_view_officialRelease.a();
            }
            if (this.f15770c == 1) {
                this.f15769b.C1.f54195g.setTag(Integer.valueOf(nk.d.L0((i10 * 100.0f) / this.f15771d)));
                str = this.f15772e.format(this.f15769b.C1.f54195g.getTag());
            } else {
                str = this.f15772e.format(Float.valueOf(i10 * this.f15773f));
            }
            TextView textView = this.f15769b.C1.f54202n;
            if (this.f15774g && !TextUtils.isEmpty(this.f15775h)) {
                str = str + this.f15775h;
            }
            textView.setText(str);
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

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(u uVar) {
            this();
        }
    }

    public interface c {
        void a();

        void b();
    }

    public interface d {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewSingleSeekBarView(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewSingleSeekBarView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ FloatViewSingleSeekBarView(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public static final void Q(FloatViewSingleSeekBarView this$0, int i10, int i11, View view) {
        f0.p(this$0, "this$0");
        if (this$0.C1.f54195g.getProgress() < i10) {
            if (1 == i11) {
                SeekBar seekBar = this$0.C1.f54195g;
                Object tag = seekBar.getTag();
                f0.n(tag, "null cannot be cast to non-null type kotlin.Int");
                seekBar.setTag(Integer.valueOf(((Integer) tag).intValue() + 1));
                SeekBar seekBar2 = this$0.C1.f54195g;
                Object tag2 = seekBar2.getTag();
                f0.n(tag2, "null cannot be cast to non-null type kotlin.Int");
                seekBar2.setProgress((((Integer) tag2).intValue() * i10) / 100);
            } else {
                SeekBar seekBar3 = this$0.C1.f54195g;
                seekBar3.setProgress(seekBar3.getProgress() + 1);
            }
            d dVar = this$0.C2;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public static final void R(FloatViewSingleSeekBarView this$0, int i10, int i11, int i12, View view) {
        f0.p(this$0, "this$0");
        if (this$0.C1.f54195g.getProgress() > i10) {
            if (1 == i11) {
                SeekBar seekBar = this$0.C1.f54195g;
                Object tag = seekBar.getTag();
                f0.n(tag, "null cannot be cast to non-null type kotlin.Int");
                seekBar.setTag(Integer.valueOf(((Integer) tag).intValue() - 1));
                SeekBar seekBar2 = this$0.C1.f54195g;
                Object tag2 = seekBar2.getTag();
                f0.n(tag2, "null cannot be cast to non-null type kotlin.Int");
                seekBar2.setProgress((((Integer) tag2).intValue() * i12) / 100);
            } else {
                SeekBar seekBar3 = this$0.C1.f54195g;
                seekBar3.setProgress(seekBar3.getProgress() - 1);
            }
            d dVar = this$0.C2;
            if (dVar != null) {
                dVar.a();
            }
        }
    }

    public static final void S(FloatViewSingleSeekBarView this$0, View view) {
        f0.p(this$0, "this$0");
        c cVar = this$0.f15767v2;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void U() {
        setValue(this.K1);
    }

    @l
    public final c getOnHelpClickListener$float_view_officialRelease() {
        return this.f15767v2;
    }

    @l
    public final d getOnValueChangedListener$float_view_officialRelease() {
        return this.C2;
    }

    public final int getValue() {
        return this.C1.f54195g.getProgress();
    }

    public final void setOnHelpClickListener$float_view_officialRelease(@l c cVar) {
        this.f15767v2 = cVar;
    }

    public final void setOnValueChangedListener$float_view_officialRelease(@l d dVar) {
        this.C2 = dVar;
    }

    public final void setValue(int i10) {
        this.C1.f54195g.setProgress(i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewSingleSeekBarView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        j2 j2VarD = j2.d(LayoutInflater.from(context), null, false);
        f0.o(j2VarD, "inflate(LayoutInflater.from(context), null, false)");
        this.C1 = j2VarD;
        addView(j2VarD.getRoot(), new ConstraintLayout.b(-1, -2));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatViewSingleSeekBarView);
        f0.o(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…oatViewSingleSeekBarView)");
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_title);
        j2VarD.f54200l.setText(string);
        if (!typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_show_title, false) || TextUtils.isEmpty(string)) {
            TextView textView = j2VarD.f54200l;
            f0.o(textView, "viewBinding.tvTitle");
            o5.c.b(textView, Boolean.FALSE, false, 2, null);
        } else {
            TextView textView2 = j2VarD.f54200l;
            f0.o(textView2, "viewBinding.tvTitle");
            o5.c.b(textView2, Boolean.TRUE, false, 2, null);
        }
        j2VarD.f54198j.setText(typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_name));
        float f10 = typedArrayObtainStyledAttributes.getFloat(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_unit, 1.0f);
        final int i11 = typedArrayObtainStyledAttributes.getInt(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_unit_type, 0);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_unit_name);
        boolean z10 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_show_unit, false);
        boolean z11 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_unit_inside, false);
        j2VarD.f54201m.setText(string2);
        if (!z10 || TextUtils.isEmpty(string2) || z11) {
            TextView textView3 = j2VarD.f54201m;
            f0.o(textView3, "viewBinding.tvUnit");
            o5.c.b(textView3, Boolean.FALSE, false, 2, null);
        } else {
            TextView textView4 = j2VarD.f54201m;
            f0.o(textView4, "viewBinding.tvUnit");
            o5.c.b(textView4, Boolean.TRUE, false, 2, null);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_show_name_help, false)) {
            ImageView imageView = j2VarD.f54194f;
            f0.o(imageView, "viewBinding.ivNameHelp");
            o5.c.b(imageView, Boolean.TRUE, false, 2, null);
        } else {
            ImageView imageView2 = j2VarD.f54194f;
            f0.o(imageView2, "viewBinding.ivNameHelp");
            o5.c.b(imageView2, Boolean.FALSE, false, 2, null);
        }
        final int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_value_max, 127);
        j2VarD.f54195g.setMax(integer);
        this.K1 = typedArrayObtainStyledAttributes.getInteger(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_value_default, 0);
        boolean z12 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_show_hint, false);
        String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_hint_min);
        string3 = string3 == null ? "" : string3;
        String string4 = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_hint_max);
        String str = string4 != null ? string4 : "";
        j2VarD.f54197i.setText(string3);
        j2VarD.f54199k.setText(str);
        if (z12) {
            TextView textView5 = j2VarD.f54197i;
            f0.o(textView5, "viewBinding.tvMinusHint");
            Boolean bool = Boolean.TRUE;
            o5.c.b(textView5, bool, false, 2, null);
            TextView textView6 = j2VarD.f54199k;
            f0.o(textView6, "viewBinding.tvPlusHint");
            o5.c.b(textView6, bool, false, 2, null);
        } else {
            TextView textView7 = j2VarD.f54197i;
            f0.o(textView7, "viewBinding.tvMinusHint");
            Boolean bool2 = Boolean.FALSE;
            o5.c.b(textView7, bool2, false, 2, null);
            TextView textView8 = j2VarD.f54199k;
            f0.o(textView8, "viewBinding.tvPlusHint");
            o5.c.b(textView8, bool2, false, 2, null);
        }
        if (1 == i11) {
            j2VarD.f54195g.setTag(Integer.valueOf((this.K1 * 100) / integer));
        }
        int integer2 = typedArrayObtainStyledAttributes.getInteger(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_value_format, 1);
        String string5 = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_desc);
        j2VarD.f54196h.setText(string5);
        j2VarD.f54196h.setVisibility(TextUtils.isEmpty(string5) ? 8 : 0);
        final int integer3 = typedArrayObtainStyledAttributes.getInteger(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_value_min, 0);
        j2VarD.f54193e.setOrientation(1 ^ (typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewSingleSeekBarView_floatview_ssb_inline, false) ? 1 : 0));
        typedArrayObtainStyledAttributes.recycle();
        j2VarD.f54192d.setOnClickListener(new View.OnClickListener() { // from class: o8.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewSingleSeekBarView.Q(this.f42832a, integer, i11, view);
            }
        });
        j2VarD.f54191c.setOnClickListener(new View.OnClickListener() { // from class: o8.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewSingleSeekBarView.R(this.f42836a, integer3, i11, integer, view);
            }
        });
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(integer2);
        j2VarD.f54195g.setOnSeekBarChangeListener(new a(integer3, this, i11, integer, numberFormat, f10, z11, string2));
        o.r(j2VarD.f54194f, new View.OnClickListener() { // from class: o8.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewSingleSeekBarView.S(this.f42830a, view);
            }
        });
        U();
    }
}
