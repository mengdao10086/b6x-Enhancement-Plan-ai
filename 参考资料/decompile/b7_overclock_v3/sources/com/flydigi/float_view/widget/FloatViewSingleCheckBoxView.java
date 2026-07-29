package com.flydigi.float_view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blankj.utilcode.util.o;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewSingleCheckBoxView;
import hk.i;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import w7.i2;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class FloatViewSingleCheckBoxView extends ConstraintLayout {

    @k
    public final i2 C1;

    @l
    public a C2;
    public boolean K1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    @l
    public b f15766v2;

    public interface a {
        void a(boolean z10);
    }

    public interface b {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewSingleCheckBoxView(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewSingleCheckBoxView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ FloatViewSingleCheckBoxView(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public static final void Q(FloatViewSingleCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.C1.f54157b.setSelected(!r2.isSelected());
        a aVar = this$0.C2;
        if (aVar != null) {
            aVar.a(this$0.C1.f54157b.isSelected());
        }
    }

    public static final void R(FloatViewSingleCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        this$0.C1.f54157b.performClick();
    }

    public static final void S(FloatViewSingleCheckBoxView this$0, View view) {
        f0.p(this$0, "this$0");
        b bVar = this$0.f15766v2;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final boolean T() {
        return this.C1.f54157b.isSelected();
    }

    public final void U() {
        setValue(this.K1);
    }

    @l
    public final a getOnCheckBoxClickListener$float_view_officialRelease() {
        return this.C2;
    }

    @l
    public final b getOnHelpClickListener$float_view_officialRelease() {
        return this.f15766v2;
    }

    public final boolean getValue() {
        return T();
    }

    public final void setCheckboxName(@l String str) {
        this.C1.f54159d.setText(str);
    }

    public final void setOnCheckBoxClickListener$float_view_officialRelease(@l a aVar) {
        this.C2 = aVar;
    }

    public final void setOnHelpClickListener$float_view_officialRelease(@l b bVar) {
        this.f15766v2 = bVar;
    }

    public final void setValue(boolean z10) {
        this.C1.f54157b.setSelected(z10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewSingleCheckBoxView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        i2 i2VarD = i2.d(LayoutInflater.from(context), null, false);
        f0.o(i2VarD, "inflate(LayoutInflater.from(context), null, false)");
        this.C1 = i2VarD;
        addView(i2VarD.getRoot(), new ConstraintLayout.b(-1, -2));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatViewSingleCheckBoxView);
        f0.o(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…atViewSingleCheckBoxView)");
        i2VarD.f54159d.setText(typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewSingleCheckBoxView_floatview_scb_checkbox_name));
        i2VarD.f54158c.setVisibility(typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewSingleCheckBoxView_floatview_scb_show_checkbox_help, false) ? 0 : 8);
        this.K1 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatViewSingleCheckBoxView_floatview_scb_checkbox_default, false);
        typedArrayObtainStyledAttributes.recycle();
        o.r(i2VarD.f54157b, new View.OnClickListener() { // from class: o8.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewSingleCheckBoxView.Q(this.f42828a, view);
            }
        });
        o.r(i2VarD.f54159d, new View.OnClickListener() { // from class: o8.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewSingleCheckBoxView.R(this.f42826a, view);
            }
        });
        o.r(i2VarD.f54158c, new View.OnClickListener() { // from class: o8.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewSingleCheckBoxView.S(this.f42824a, view);
            }
        });
        U();
    }
}
