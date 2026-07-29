package com.flydigi.float_view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.flydigi.float_view.widget.FloatViewKeySetView;
import com.flydigi.sdk.gamepad.GamepadInfo;
import com.flydigi.sdk.gamepad.extension.config.data.CFGVibrateItem;
import hk.i;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.u;
import w7.n2;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes7.dex */
@t0({"SMAP\nFloatViewVibrateItemView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FloatViewVibrateItemView.kt\ncom/flydigi/float_view/widget/FloatViewVibrateItemView\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,81:1\n13644#2,3:82\n*S KotlinDebug\n*F\n+ 1 FloatViewVibrateItemView.kt\ncom/flydigi/float_view/widget/FloatViewVibrateItemView\n*L\n65#1:82,3\n*E\n"})
public final class FloatViewVibrateItemView extends ConstraintLayout {
    public GamepadInfo C1;

    @l
    public b C2;

    @k
    public CFGVibrateItem K1;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    @k
    public final n2 f15807v2;

    public static final class a implements FloatViewKeySetView.a {
        public a() {
        }

        @Override // com.flydigi.float_view.widget.FloatViewKeySetView.a
        public void a() {
            b onButtonAddClickedListener$float_view_officialRelease = FloatViewVibrateItemView.this.getOnButtonAddClickedListener$float_view_officialRelease();
            if (onButtonAddClickedListener$float_view_officialRelease != null) {
                onButtonAddClickedListener$float_view_officialRelease.a();
            }
        }
    }

    public interface b {
        void a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewVibrateItemView(@k Context context) {
        this(context, null, 0, 6, null);
        f0.p(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewVibrateItemView(@k Context context, @l AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        f0.p(context, "context");
    }

    public /* synthetic */ FloatViewVibrateItemView(Context context, AttributeSet attributeSet, int i10, int i11, u uVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    public final void N(int i10, @k GamepadInfo deviceInfo) {
        f0.p(deviceInfo, "deviceInfo");
        this.f15807v2.f54319b.g(i10, deviceInfo);
    }

    public final void O(@k CFGVibrateItem config, @k GamepadInfo deviceInfo) {
        f0.p(config, "config");
        f0.p(deviceInfo, "deviceInfo");
        this.K1 = config;
        this.C1 = deviceInfo;
        N(config.getKeyId(), deviceInfo);
        FloatViewTwoCheckBoxView floatViewTwoCheckBoxView = this.f15807v2.f54323f;
        Integer triggerType = config.getTriggerType();
        boolean z10 = triggerType != null && triggerType.intValue() == 0;
        Integer triggerType2 = config.getTriggerType();
        floatViewTwoCheckBoxView.q(z10, triggerType2 != null && triggerType2.intValue() == 1);
        FloatViewThreeCheckBoxView floatViewThreeCheckBoxView = this.f15807v2.f54322e;
        Integer position = config.getPosition();
        boolean z11 = position != null && position.intValue() == 0;
        Integer position2 = config.getPosition();
        boolean z12 = position2 != null && position2.intValue() == 1;
        Integer position3 = config.getPosition();
        floatViewThreeCheckBoxView.w(z11, z12, position3 != null && position3.intValue() == 2);
        FloatViewSingleSeekBarView floatViewSingleSeekBarView = this.f15807v2.f54320c;
        Integer period = config.getPeriod();
        floatViewSingleSeekBarView.setValue(period != null ? period.intValue() : 0);
        FloatViewSingleSeekBarView floatViewSingleSeekBarView2 = this.f15807v2.f54321d;
        Integer strong = config.getStrong();
        floatViewSingleSeekBarView2.setValue(strong != null ? strong.intValue() : 0);
    }

    @l
    public final b getOnButtonAddClickedListener$float_view_officialRelease() {
        return this.C2;
    }

    @k
    public final CFGVibrateItem getValue() {
        CFGVibrateItem cFGVibrateItem = this.K1;
        cFGVibrateItem.setKeyId(this.f15807v2.f54319b.getValue());
        int i10 = 0;
        cFGVibrateItem.setTriggerType(this.f15807v2.f54323f.getValue().f().booleanValue() ? 0 : 1);
        cFGVibrateItem.setStrong(Integer.valueOf(this.f15807v2.f54321d.getValue()));
        cFGVibrateItem.setPeriod(Integer.valueOf(this.f15807v2.f54320c.getValue()));
        Boolean[] value = this.f15807v2.f54322e.getValue();
        int length = value.length;
        int i11 = 0;
        while (i10 < length) {
            int i12 = i11 + 1;
            if (value[i10].booleanValue()) {
                cFGVibrateItem.setPosition(Integer.valueOf(i11));
            }
            i10++;
            i11 = i12;
        }
        return cFGVibrateItem;
    }

    public final void setOnButtonAddClickedListener$float_view_officialRelease(@l b bVar) {
        this.C2 = bVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @i
    public FloatViewVibrateItemView(@k Context context, @l AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        f0.p(context, "context");
        this.K1 = new CFGVibrateItem(0, null, null, null, null, 31, null);
        n2 n2VarD = n2.d(LayoutInflater.from(context), null, false);
        f0.o(n2VarD, "inflate(LayoutInflater.from(context), null, false)");
        this.f15807v2 = n2VarD;
        addView(n2VarD.getRoot(), new LinearLayout.LayoutParams(-1, -2));
        n2VarD.f54319b.setOnButtonClickListener$float_view_officialRelease(new a());
    }
}
