package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.u0;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.b0;
import com.google.android.material.internal.s;
import com.google.android.material.textfield.TextInputLayout;
import g.n0;
import g.p0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes7.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Chip f21055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextInputLayout f21056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EditText f21057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextWatcher f21058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public TextView f21059e;

    public class b extends s {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f21060b = "00";

        public b() {
        }

        @Override // com.google.android.material.internal.s, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f21055a.setText(ChipTextInputComboView.this.d(f21060b));
            } else {
                ChipTextInputComboView.this.f21055a.setText(ChipTextInputComboView.this.d(editable));
            }
        }
    }

    public ChipTextInputComboView(@n0 Context context) {
        this(context, null);
    }

    public void c(InputFilter inputFilter) {
        InputFilter[] filters = this.f21057c.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.f21057c.setFilters(inputFilterArr);
    }

    public final String d(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    public TextInputLayout e() {
        return this.f21056b;
    }

    public void f(androidx.core.view.a aVar) {
        u0.B1(this.f21055a, aVar);
    }

    public void g(boolean z10) {
        this.f21057c.setCursorVisible(z10);
    }

    public void h(CharSequence charSequence) {
        this.f21059e.setText(charSequence);
    }

    public void i(CharSequence charSequence) {
        this.f21055a.setText(d(charSequence));
        if (TextUtils.isEmpty(this.f21057c.getText())) {
            return;
        }
        this.f21057c.removeTextChangedListener(this.f21058d);
        this.f21057c.setText((CharSequence) null);
        this.f21057c.addTextChangedListener(this.f21058d);
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f21055a.isChecked();
    }

    public final void j() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f21057c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        j();
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        this.f21055a.setChecked(z10);
        this.f21057c.setVisibility(z10 ? 0 : 4);
        this.f21055a.setVisibility(z10 ? 8 : 0);
        if (isChecked()) {
            b0.q(this.f21057c);
            if (TextUtils.isEmpty(this.f21057c.getText())) {
                return;
            }
            EditText editText = this.f21057c;
            editText.setSelection(editText.getText().length());
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@p0 View.OnClickListener onClickListener) {
        this.f21055a.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i10, Object obj) {
        this.f21055a.setTag(i10, obj);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.f21055a.toggle();
    }

    public ChipTextInputComboView(@n0 Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
        Chip chip = (Chip) layoutInflaterFrom.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.f21055a = chip;
        chip.setAccessibilityClassName("android.view.View");
        TextInputLayout textInputLayout = (TextInputLayout) layoutInflaterFrom.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        this.f21056b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f21057c = editText;
        editText.setVisibility(4);
        b bVar = new b();
        this.f21058d = bVar;
        editText.addTextChangedListener(bVar);
        j();
        addView(chip);
        addView(textInputLayout);
        this.f21059e = (TextView) findViewById(R.id.material_label);
        editText.setId(u0.D());
        u0.U1(this.f21059e, editText.getId());
        editText.setSaveEnabled(false);
        editText.setLongClickable(false);
    }
}
