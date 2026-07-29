package com.flydigi.base.widget.action_item;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.o;
import com.flydigi.base.R;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class ActionItemSwitch extends q5.b {
    public ImageView C2;
    public boolean K2;

    public class a extends ThreadUtils.d<Boolean> {
        public a() {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Boolean e() {
            ActionItemSwitch.this.T();
            return null;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public void l(Boolean bool) {
        }
    }

    public interface b {
        void a(boolean z10);
    }

    public ActionItemSwitch(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(b bVar, View view) {
        if (this.K2) {
            return;
        }
        this.C2.setSelected(!r4.isSelected());
        if (bVar != null) {
            this.K2 = true;
            bVar.a(this.C2.isSelected());
        }
        ThreadUtils.S(new a(), 1500L, TimeUnit.MILLISECONDS);
    }

    @Override // q5.b
    public void N(Context context, AttributeSet attributeSet) {
        super.N(context, attributeSet);
        this.C2 = (ImageView) findViewById(R.id.btn_action);
    }

    public final void T() {
        this.K2 = false;
    }

    public void U(boolean z10) {
        if (this.K2) {
            return;
        }
        this.C2.setSelected(z10);
    }

    @Override // q5.b
    public int getLayoutId() {
        return R.layout.base_action_item_switch;
    }

    public void setOnCheckedChangeListener(final b bVar) {
        o.r(this.C2, new View.OnClickListener() { // from class: q5.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f47117a.S(bVar, view);
            }
        });
    }

    public ActionItemSwitch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ActionItemSwitch(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }
}
