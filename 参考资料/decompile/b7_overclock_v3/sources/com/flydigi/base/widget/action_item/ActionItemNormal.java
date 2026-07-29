package com.flydigi.base.widget.action_item;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.flydigi.base.R;
import q5.b;

/* JADX INFO: loaded from: classes2.dex */
public class ActionItemNormal extends b {
    public TextView C2;
    public int K2;

    public ActionItemNormal(Context context) {
        this(context, null);
    }

    @Override // q5.b
    public void N(Context context, AttributeSet attributeSet) {
        super.N(context, attributeSet);
        this.C2 = (TextView) findViewById(R.id.tv_state);
        View viewFindViewById = findViewById(R.id.btn_action);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionItemNormal);
        viewFindViewById.setVisibility(typedArrayObtainStyledAttributes.getBoolean(R.styleable.ActionItemNormal_showArrow, true) ? 0 : 8);
        this.C2.setText(typedArrayObtainStyledAttributes.getString(R.styleable.ActionItemNormal_actionText));
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.ActionItemNormal_actionTextColor, getResources().getColor(R.color.color_000000_a50));
        this.K2 = color;
        this.C2.setTextColor(color);
        typedArrayObtainStyledAttributes.recycle();
    }

    public void Q(String str) {
        R(str, 0);
    }

    public void R(String str, int i10) {
        S(str, i10, this.K2);
    }

    public void S(String str, int i10, int i11) {
        if (TextUtils.isEmpty(str)) {
            this.C2.setVisibility(8);
        } else {
            this.C2.setVisibility(0);
            this.C2.setText(str);
        }
        this.C2.setTextColor(i11);
        this.C2.setCompoundDrawablesWithIntrinsicBounds(i10, 0, 0, 0);
    }

    @Override // q5.b
    public int getLayoutId() {
        return R.layout.base_action_item_normal;
    }

    public String getState() {
        return this.C2.getText().toString();
    }

    public ActionItemNormal(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionItemNormal(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
