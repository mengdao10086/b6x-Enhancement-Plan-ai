package com.flydigi.base.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.d1;
import com.flydigi.base.R;
import com.flydigi.base.common.i;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
public class OperateView extends i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ImageView f13519c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public TextView f13520d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ImageView f13521e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f13522f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f13523g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ImageView f13524h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f13525i;

    public OperateView(@n0 Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View.OnClickListener onClickListener, View view) {
        if (onClickListener == null || System.currentTimeMillis() - this.f13525i < 500) {
            return;
        }
        this.f13525i = System.currentTimeMillis();
        onClickListener.onClick(view);
    }

    @Override // com.flydigi.base.common.i
    public void f(AttributeSet attributeSet) {
        this.f13519c = (ImageView) findViewById(R.id.iv_icon);
        this.f13520d = (TextView) findViewById(R.id.tv_title);
        this.f13521e = (ImageView) findViewById(R.id.iv_notice);
        this.f13522f = (TextView) findViewById(R.id.tv_notice_num);
        this.f13523g = (TextView) findViewById(R.id.tv_notice);
        this.f13524h = (ImageView) findViewById(R.id.iv_arrow);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.OperateView);
        if (typedArrayObtainStyledAttributes != null) {
            j(typedArrayObtainStyledAttributes.getResourceId(R.styleable.OperateView_ov_icon, -1), typedArrayObtainStyledAttributes.getString(R.styleable.OperateView_ov_title), typedArrayObtainStyledAttributes.getString(R.styleable.OperateView_ov_notice), typedArrayObtainStyledAttributes.getBoolean(R.styleable.OperateView_ov_showArrow, true));
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // com.flydigi.base.common.i
    public int getLayoutId() {
        return R.layout.main_layout_view_operate;
    }

    public final void j(int i10, String str, String str2, boolean z10) {
        if (i10 != -1) {
            this.f13519c.setVisibility(0);
            this.f13519c.setImageResource(i10);
        }
        if (!d1.g(str)) {
            this.f13520d.setVisibility(0);
            this.f13520d.setText(str);
        }
        if (!d1.g(str2)) {
            this.f13523g.setVisibility(0);
            this.f13523g.setText(str2);
        }
        if (z10) {
            this.f13524h.setVisibility(0);
        } else {
            this.f13524h.setVisibility(8);
        }
    }

    public void l(boolean z10) {
        if (z10) {
            this.f13521e.setVisibility(0);
        } else {
            this.f13521e.setVisibility(8);
        }
    }

    public void setMessageNotice(int i10) {
        if (i10 <= 0) {
            this.f13522f.setVisibility(8);
            return;
        }
        if (i10 > 99) {
            i10 = 99;
        }
        this.f13522f.setText(String.valueOf(i10));
        this.f13522f.setVisibility(0);
    }

    public void setNotice(String str) {
        this.f13523g.setVisibility(0);
        this.f13523g.setText(str);
    }

    @Override // android.view.View
    public void setOnClickListener(@p0 final View.OnClickListener onClickListener) {
        super.setOnClickListener(new View.OnClickListener() { // from class: p5.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f46436a.k(onClickListener, view);
            }
        });
    }

    public OperateView(@n0 Context context, @p0 AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OperateView(@n0 Context context, @p0 AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    @v0(api = 21)
    public OperateView(@n0 Context context, @p0 AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
