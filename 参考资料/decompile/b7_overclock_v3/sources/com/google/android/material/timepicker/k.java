package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.s;
import com.google.android.material.timepicker.TimePickerView;
import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: loaded from: classes7.dex */
public class k implements TimePickerView.f, h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f21143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimeModel f21144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextWatcher f21145c = new a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextWatcher f21146d = new b();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ChipTextInputComboView f21147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ChipTextInputComboView f21148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f21149g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final EditText f21150h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final EditText f21151i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public MaterialButtonToggleGroup f21152j;

    public class a extends s {
        public a() {
        }

        @Override // com.google.android.material.internal.s, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    k.this.f21144b.F(0);
                } else {
                    k.this.f21144b.F(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public class b extends s {
        public b() {
        }

        @Override // com.google.android.material.internal.s, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    k.this.f21144b.z(0);
                } else {
                    k.this.f21144b.z(Integer.parseInt(editable.toString()));
                }
            } catch (NumberFormatException unused) {
            }
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k.this.h(((Integer) view.getTag(R.id.selection_type)).intValue());
        }
    }

    public class d extends com.google.android.material.timepicker.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TimeModel f21156e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, int i10, TimeModel timeModel) {
            super(context, i10);
            this.f21156e = timeModel;
        }

        @Override // com.google.android.material.timepicker.a, androidx.core.view.a
        public void g(View view, a1.d dVar) {
            super.g(view, dVar);
            dVar.f1(view.getResources().getString(R.string.material_hour_suffix, String.valueOf(this.f21156e.e())));
        }
    }

    public class e extends com.google.android.material.timepicker.a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ TimeModel f21158e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context, int i10, TimeModel timeModel) {
            super(context, i10);
            this.f21158e = timeModel;
        }

        @Override // com.google.android.material.timepicker.a, androidx.core.view.a
        public void g(View view, a1.d dVar) {
            super.g(view, dVar);
            dVar.f1(view.getResources().getString(R.string.material_minute_suffix, String.valueOf(this.f21158e.f21112e)));
        }
    }

    public k(LinearLayout linearLayout, TimeModel timeModel) {
        this.f21143a = linearLayout;
        this.f21144b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.f21147e = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.f21148f = chipTextInputComboView2;
        int i10 = R.id.material_label;
        TextView textView = (TextView) chipTextInputComboView.findViewById(i10);
        TextView textView2 = (TextView) chipTextInputComboView2.findViewById(i10);
        textView.setText(resources.getString(R.string.material_timepicker_minute));
        textView2.setText(resources.getString(R.string.material_timepicker_hour));
        int i11 = R.id.selection_type;
        chipTextInputComboView.setTag(i11, 12);
        chipTextInputComboView2.setTag(i11, 10);
        if (timeModel.f21110c == 0) {
            o();
        }
        c cVar = new c();
        chipTextInputComboView2.setOnClickListener(cVar);
        chipTextInputComboView.setOnClickListener(cVar);
        chipTextInputComboView2.c(timeModel.g());
        chipTextInputComboView.c(timeModel.j());
        this.f21150h = chipTextInputComboView2.e().getEditText();
        this.f21151i = chipTextInputComboView.e().getEditText();
        this.f21149g = new i(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.f(new d(linearLayout.getContext(), R.string.material_hour_selection, timeModel));
        chipTextInputComboView.f(new e(linearLayout.getContext(), R.string.material_minute_selection, timeModel));
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(MaterialButtonToggleGroup materialButtonToggleGroup, int i10, boolean z10) {
        if (z10) {
            this.f21144b.M(i10 == R.id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    public static void m(EditText editText, @g.l int i10) {
        try {
            Context context = editText.getContext();
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i11 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable drawableB = i.a.b(context, i11);
            drawableB.setColorFilter(i10, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, new Drawable[]{drawableB, drawableB});
        } catch (Throwable unused) {
        }
    }

    @Override // com.google.android.material.timepicker.h
    public void a() {
        this.f21143a.setVisibility(0);
        h(this.f21144b.f21113f);
    }

    @Override // com.google.android.material.timepicker.h
    public void b() {
        g();
        n(this.f21144b);
        this.f21149g.a();
    }

    @Override // com.google.android.material.timepicker.h
    public void c() {
        View focusedChild = this.f21143a.getFocusedChild();
        if (focusedChild != null) {
            b0.k(focusedChild);
        }
        this.f21143a.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.h
    public void d() {
        n(this.f21144b);
    }

    public final void g() {
        this.f21150h.addTextChangedListener(this.f21146d);
        this.f21151i.addTextChangedListener(this.f21145c);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.f
    public void h(int i10) {
        this.f21144b.f21113f = i10;
        this.f21147e.setChecked(i10 == 12);
        this.f21148f.setChecked(i10 == 10);
        p();
    }

    public void i() {
        this.f21147e.setChecked(false);
        this.f21148f.setChecked(false);
    }

    public final void k() {
        this.f21150h.removeTextChangedListener(this.f21146d);
        this.f21151i.removeTextChangedListener(this.f21145c);
    }

    public void l() {
        this.f21147e.setChecked(this.f21144b.f21113f == 12);
        this.f21148f.setChecked(this.f21144b.f21113f == 10);
    }

    public final void n(TimeModel timeModel) {
        k();
        Locale locale = this.f21143a.getResources().getConfiguration().locale;
        String str = String.format(locale, TimeModel.f21106h, Integer.valueOf(timeModel.f21112e));
        String str2 = String.format(locale, TimeModel.f21106h, Integer.valueOf(timeModel.e()));
        this.f21147e.i(str);
        this.f21148f.i(str2);
        g();
        p();
    }

    public final void o() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f21143a.findViewById(R.id.material_clock_period_toggle);
        this.f21152j = materialButtonToggleGroup;
        materialButtonToggleGroup.b(new MaterialButtonToggleGroup.d() { // from class: com.google.android.material.timepicker.j
            @Override // com.google.android.material.button.MaterialButtonToggleGroup.d
            public final void a(MaterialButtonToggleGroup materialButtonToggleGroup2, int i10, boolean z10) {
                this.f21142a.j(materialButtonToggleGroup2, i10, z10);
            }
        });
        this.f21152j.setVisibility(0);
        p();
    }

    public final void p() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f21152j;
        if (materialButtonToggleGroup == null) {
            return;
        }
        materialButtonToggleGroup.e(this.f21144b.f21114g == 0 ? R.id.material_clock_period_am_button : R.id.material_clock_period_pm_button);
    }
}
