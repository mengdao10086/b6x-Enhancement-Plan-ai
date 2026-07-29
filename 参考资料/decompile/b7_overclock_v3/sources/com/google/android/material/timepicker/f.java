package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.google.android.material.R;
import com.google.android.material.timepicker.ChipTextInputComboView;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes7.dex */
public class f implements ClockHandView.d, TimePickerView.f, TimePickerView.e, ClockHandView.c, h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String[] f21126f = {Constants.VIA_REPORT_TYPE_SET_AVATAR, "1", "2", "3", "4", "5", "6", "7", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_SHARE_TYPE_MINI_PROGRAM, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String[] f21127g = {ChipTextInputComboView.b.f21060b, "2", "4", "6", Constants.VIA_SHARE_TYPE_PUBLISHVIDEO, Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_SET_AVATAR, Constants.VIA_REPORT_TYPE_MAKE_FRIEND, Constants.VIA_REPORT_TYPE_START_WAP, "18", "20", Constants.VIA_REPORT_TYPE_DATALINE};

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String[] f21128h = {ChipTextInputComboView.b.f21060b, "5", Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, Constants.VIA_REPORT_TYPE_WPA_STATE, "20", Constants.VIA_REPORT_TYPE_CHAT_AUDIO, "30", "35", "40", "45", "50", "55"};

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f21129i = 30;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f21130j = 6;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TimePickerView f21131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeModel f21132b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f21133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f21134d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f21135e = false;

    public class a extends com.google.android.material.timepicker.a {
        public a(Context context, int i10) {
            super(context, i10);
        }

        @Override // com.google.android.material.timepicker.a, androidx.core.view.a
        public void g(View view, a1.d dVar) {
            super.g(view, dVar);
            dVar.f1(view.getResources().getString(R.string.material_hour_suffix, String.valueOf(f.this.f21132b.e())));
        }
    }

    public class b extends com.google.android.material.timepicker.a {
        public b(Context context, int i10) {
            super(context, i10);
        }

        @Override // com.google.android.material.timepicker.a, androidx.core.view.a
        public void g(View view, a1.d dVar) {
            super.g(view, dVar);
            dVar.f1(view.getResources().getString(R.string.material_minute_suffix, String.valueOf(f.this.f21132b.f21112e)));
        }
    }

    public f(TimePickerView timePickerView, TimeModel timeModel) {
        this.f21131a = timePickerView;
        this.f21132b = timeModel;
        b();
    }

    @Override // com.google.android.material.timepicker.h
    public void a() {
        this.f21131a.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.h
    public void b() {
        if (this.f21132b.f21110c == 0) {
            this.f21131a.c0();
        }
        this.f21131a.Q(this);
        this.f21131a.Z(this);
        this.f21131a.Y(this);
        this.f21131a.W(this);
        o();
        d();
    }

    @Override // com.google.android.material.timepicker.h
    public void c() {
        this.f21131a.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.h
    public void d() {
        this.f21134d = this.f21132b.e() * j();
        TimeModel timeModel = this.f21132b;
        this.f21133c = timeModel.f21112e * 6;
        m(timeModel.f21113f, false);
        n();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.d
    public void e(float f10, boolean z10) {
        if (this.f21135e) {
            return;
        }
        TimeModel timeModel = this.f21132b;
        int i10 = timeModel.f21111d;
        int i11 = timeModel.f21112e;
        int iRound = Math.round(f10);
        TimeModel timeModel2 = this.f21132b;
        if (timeModel2.f21113f == 12) {
            timeModel2.F((iRound + 3) / 6);
            this.f21133c = (float) Math.floor(this.f21132b.f21112e * 6);
        } else {
            this.f21132b.z((iRound + (j() / 2)) / j());
            this.f21134d = this.f21132b.e() * j();
        }
        if (z10) {
            return;
        }
        n();
        l(i10, i11);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.c
    public void f(float f10, boolean z10) {
        this.f21135e = true;
        TimeModel timeModel = this.f21132b;
        int i10 = timeModel.f21112e;
        int i11 = timeModel.f21111d;
        if (timeModel.f21113f == 10) {
            this.f21131a.T(this.f21134d, false);
            AccessibilityManager accessibilityManager = (AccessibilityManager) h0.d.o(this.f21131a.getContext(), AccessibilityManager.class);
            if (!(accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled())) {
                m(12, true);
            }
        } else {
            int iRound = Math.round(f10);
            if (!z10) {
                this.f21132b.F(((iRound + 15) / 30) * 5);
                this.f21133c = this.f21132b.f21112e * 6;
            }
            this.f21131a.T(this.f21133c, z10);
        }
        this.f21135e = false;
        n();
        l(i11, i10);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.e
    public void g(int i10) {
        this.f21132b.M(i10);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.f
    public void h(int i10) {
        m(i10, true);
    }

    public final int j() {
        return this.f21132b.f21110c == 1 ? 15 : 30;
    }

    public final String[] k() {
        return this.f21132b.f21110c == 1 ? f21127g : f21126f;
    }

    public final void l(int i10, int i11) {
        TimeModel timeModel = this.f21132b;
        if (timeModel.f21112e == i11 && timeModel.f21111d == i10) {
            return;
        }
        this.f21131a.performHapticFeedback(4);
    }

    public void m(int i10, boolean z10) {
        boolean z11 = i10 == 12;
        this.f21131a.S(z11);
        this.f21132b.f21113f = i10;
        this.f21131a.d(z11 ? f21128h : k(), z11 ? R.string.material_minute_suffix : R.string.material_hour_suffix);
        this.f21131a.T(z11 ? this.f21133c : this.f21134d, z10);
        this.f21131a.a(i10);
        this.f21131a.V(new a(this.f21131a.getContext(), R.string.material_hour_selection));
        this.f21131a.U(new b(this.f21131a.getContext(), R.string.material_minute_selection));
    }

    public final void n() {
        TimePickerView timePickerView = this.f21131a;
        TimeModel timeModel = this.f21132b;
        timePickerView.c(timeModel.f21114g, timeModel.e(), this.f21132b.f21112e);
    }

    public final void o() {
        p(f21126f, TimeModel.f21107i);
        p(f21127g, TimeModel.f21107i);
        p(f21128h, TimeModel.f21106h);
    }

    public final void p(String[] strArr, String str) {
        for (int i10 = 0; i10 < strArr.length; i10++) {
            strArr[i10] = TimeModel.b(this.f21131a.getResources(), strArr[i10], str);
        }
    }
}
