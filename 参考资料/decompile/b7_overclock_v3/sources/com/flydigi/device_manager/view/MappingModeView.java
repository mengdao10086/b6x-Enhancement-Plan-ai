package com.flydigi.device_manager.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public class MappingModeView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f15509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TextView f15510b;

    public MappingModeView(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        this.f15509a = (TextView) findViewById(R.id.tv_title);
        this.f15510b = (TextView) findViewById(R.id.tv_desc);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MappingModeView);
        if (typedArrayObtainStyledAttributes != null) {
            String string = typedArrayObtainStyledAttributes.getString(R.styleable.MappingModeView_title);
            String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.MappingModeView_desc);
            this.f15509a.setText(string);
            this.f15510b.setText(string2);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void b(@p0 String str, @p0 String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f15509a.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f15510b.setText(str2);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        this.f15509a.setTextColor(getResources().getColor(z10 ? R.color.color_000000_a90 : R.color.color_000000_a10));
        this.f15510b.setTextColor(getResources().getColor(z10 ? R.color.color_000000_a50 : R.color.color_000000_a10));
    }

    @Override // android.view.View
    public void setSelected(boolean z10) {
        super.setSelected(z10);
        if (isEnabled()) {
            this.f15509a.setTextColor(getResources().getColor(z10 ? R.color.colorPrimary : R.color.color_000000_a90));
            this.f15510b.setTextColor(getResources().getColor(z10 ? R.color.colorPrimary : R.color.color_000000_a50));
        }
    }

    public MappingModeView(Context context, @p0 AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MappingModeView(Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        LayoutInflater.from(context).inflate(R.layout.device_item_mapping_mode, (ViewGroup) this, true);
        a(context, attributeSet);
    }
}
