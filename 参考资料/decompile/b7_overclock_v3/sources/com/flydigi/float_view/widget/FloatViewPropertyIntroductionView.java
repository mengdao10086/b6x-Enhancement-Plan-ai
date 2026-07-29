package com.flydigi.float_view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.flydigi.float_view.R;
import g.c1;
import hk.i;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import w7.h2;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
public final class FloatViewPropertyIntroductionView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final h2 f15765a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewPropertyIntroductionView(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewPropertyIntroductionView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ FloatViewPropertyIntroductionView(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public final void a(@c1 int i10) {
        this.f15765a.f54139b.setText(getContext().getString(i10));
    }

    public final void b(@k String content) {
        f0.p(content, "content");
        this.f15765a.f54139b.setText(content);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewPropertyIntroductionView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        h2 h2VarD = h2.d(LayoutInflater.from(context), null, false);
        f0.o(h2VarD, "inflate(\n        LayoutI…null,\n        false\n    )");
        this.f15765a = h2VarD;
        addView(h2VarD.getRoot(), new LinearLayout.LayoutParams(-1, -2));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatViewPropertyIntroductionView);
        f0.o(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…PropertyIntroductionView)");
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewPropertyIntroductionView_floatview_piv_title);
        string = string == null ? context.getString(R.string.floatview_introduction) : string;
        f0.o(string, "typedArray.getString(\n  …g.floatview_introduction)");
        h2VarD.f54140c.setText(string);
        h2VarD.f54139b.setText(typedArrayObtainStyledAttributes.getString(R.styleable.FloatViewPropertyIntroductionView_floatview_piv_desc));
        typedArrayObtainStyledAttributes.recycle();
    }
}
