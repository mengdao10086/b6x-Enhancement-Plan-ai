package com.flydigi.game.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.e;
import com.flydigi.game.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public class a extends e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public InterfaceC0164a f16020i;

    /* JADX INFO: renamed from: com.flydigi.game.widget.a$a, reason: collision with other inner class name */
    public interface InterfaceC0164a {
        void a();
    }

    public a(@n0 Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(View view) {
        dismiss();
        InterfaceC0164a interfaceC0164a = this.f16020i;
        if (interfaceC0164a != null) {
            interfaceC0164a.a();
        }
    }

    public void E(InterfaceC0164a interfaceC0164a) {
        this.f16020i = interfaceC0164a;
    }

    @Override // androidx.appcompat.app.e, androidx.appcompat.app.j, androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.game_net_status);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(R.color.color_black_trans)));
        }
        TextView textView = (TextView) findViewById(R.id.tv_cancel);
        TextView textView2 = (TextView) findViewById(R.id.tv_confirm);
        textView.setOnClickListener(new View.OnClickListener() { // from class: z8.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57948a.C(view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: z8.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f57949a.D(view);
            }
        });
    }

    public a(@n0 Context context, int i10) {
        super(context, i10);
    }

    public a(@n0 Context context, boolean z10, @p0 DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
    }
}
