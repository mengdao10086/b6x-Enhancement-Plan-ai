package com.flydigi.float_view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.o;
import com.flydigi.float_view.R;
import com.flydigi.float_view.widget.FloatViewKeySetView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import hk.i;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import o5.c;
import w7.g2;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public class FloatViewKeySetView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @k
    public final g2 f15763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public a f15764c;

    public interface a {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewKeySetView(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewKeySetView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ FloatViewKeySetView(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public static final void c(FloatViewKeySetView this$0, View view) {
        f0.p(this$0, "this$0");
        a aVar = this$0.f15764c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static final void d(FloatViewKeySetView this$0, View it2) {
        f0.p(this$0, "this$0");
        this$0.f15763b.f54119b.removeAllViews();
        f0.o(it2, "it");
        c.b(it2, Boolean.FALSE, false, 2, null);
        TextView textView = this$0.f15763b.f54120c;
        f0.o(textView, "viewBinding.btnAdd");
        c.b(textView, Boolean.TRUE, false, 2, null);
    }

    public final View e(int i10, GamepadInfo gamepadInfo) {
        ExpandView expandView = new ExpandView(getContext());
        expandView.setTag(Integer.valueOf(i10));
        expandView.setId(i10);
        expandView.i(i10, gamepadInfo, false);
        expandView.n(getContext().getResources().getDimensionPixelSize(R.dimen.qb_px_24));
        return expandView;
    }

    public final void f() {
        g(-1, new GamepadInfo());
    }

    public final void g(int i10, @k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        this.f15763b.f54119b.removeAllViews();
        if (i10 == -1) {
            TextView textView = this.f15763b.f54121d;
            f0.o(textView, "viewBinding.btnDelete");
            c.b(textView, Boolean.FALSE, false, 2, null);
            TextView textView2 = this.f15763b.f54120c;
            f0.o(textView2, "viewBinding.btnAdd");
            c.b(textView2, Boolean.TRUE, false, 2, null);
            return;
        }
        this.f15763b.f54119b.addView(e(i10, deviceInfo));
        TextView textView3 = this.f15763b.f54121d;
        f0.o(textView3, "viewBinding.btnDelete");
        c.b(textView3, Boolean.TRUE, false, 2, null);
        g2 g2Var = this.f15763b;
        g2Var.f54120c.setVisibility(g2Var.f54119b.getChildCount() == this.f15762a ? 8 : 0);
    }

    @l
    public final a getOnButtonClickListener$float_view_officialRelease() {
        return this.f15764c;
    }

    public final int getValue() {
        if (this.f15763b.f54119b.getChildCount() <= 0) {
            return -1;
        }
        Object tag = this.f15763b.f54119b.getChildAt(0).getTag();
        f0.n(tag, "null cannot be cast to non-null type kotlin.Int");
        return ((Integer) tag).intValue();
    }

    public final void setOnButtonClickListener$float_view_officialRelease(@l a aVar) {
        this.f15764c = aVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewKeySetView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        this.f15762a = 1;
        g2 g2VarD = g2.d(LayoutInflater.from(context), null, false);
        f0.o(g2VarD, "inflate(\n        LayoutI…null,\n        false\n    )");
        this.f15763b = g2VarD;
        addView(g2VarD.getRoot(), new LinearLayout.LayoutParams(-1, -2));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatViewKeySetView);
        f0.o(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…able.FloatViewKeySetView)");
        g2VarD.f54123f.setText(typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewKeySetView_floatview_ksv_title));
        this.f15762a = typedArrayObtainStyledAttributes.getInt(R.styleable.FloatViewKeySetView_floatview_ksv_key_max_count, 1);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewKeySetView_floatview_ksv_desc);
        g2VarD.f54122e.setText(string);
        g2VarD.f54122e.setVisibility(TextUtils.isEmpty(string) ? 8 : 0);
        typedArrayObtainStyledAttributes.recycle();
        o.r(g2VarD.f54120c, new View.OnClickListener() { // from class: o8.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewKeySetView.c(this.f42822a, view);
            }
        });
        o.r(g2VarD.f54121d, new View.OnClickListener() { // from class: o8.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FloatViewKeySetView.d(this.f42819a, view);
            }
        });
        f();
    }
}
