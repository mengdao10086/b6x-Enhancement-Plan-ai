package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.k;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.d;
import androidx.appcompat.widget.s;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textfield.v;
import g.n0;
import g.p0;
import he.a;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialComponentsViewInflater extends k {
    @Override // androidx.appcompat.app.k
    @n0
    public d c(@n0 Context context, @p0 AttributeSet attributeSet) {
        return new v(context, attributeSet);
    }

    @Override // androidx.appcompat.app.k
    @n0
    public AppCompatButton d(@n0 Context context, @n0 AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.k
    @n0
    public AppCompatCheckBox e(Context context, AttributeSet attributeSet) {
        return new MaterialCheckBox(context, attributeSet);
    }

    @Override // androidx.appcompat.app.k
    @n0
    public s k(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.k
    @n0
    public AppCompatTextView o(Context context, AttributeSet attributeSet) {
        return new oe.a(context, attributeSet);
    }
}
