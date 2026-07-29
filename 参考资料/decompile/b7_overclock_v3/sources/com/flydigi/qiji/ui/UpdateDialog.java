package com.flydigi.qiji.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.e;
import androidx.appcompat.app.j;
import com.fdg.flashplay.farsef.R;
import g.n0;
import g.p0;
import java.io.Serializable;

/* JADX INFO: loaded from: classes3.dex */
public class UpdateDialog extends e {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f16033s = "dialog_params";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f16034i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LinearLayout f16035j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f16036k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f16037l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LinearLayout f16038m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f16039n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public UpdateDialogAction f16040o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public UpdateDialogAction f16041p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public UpdateDialogAction f16042q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final DialogParams f16043r;

    public static class DialogParams implements Serializable {
        public UpdateDialogAction actionCancel;
        public UpdateDialogAction actionConfirm;
        public UpdateDialogAction actionOk;
        public String content;
        public boolean cancelAble = true;
        public boolean forceUpdate = false;
    }

    public interface UpdateDialogAction extends Serializable {
        void F(j jVar);
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DialogParams f16044a = new DialogParams();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public UpdateDialog f16045b;

        public UpdateDialog a(Context context) {
            UpdateDialog updateDialog = new UpdateDialog(context, this.f16044a);
            this.f16045b = updateDialog;
            return updateDialog;
        }

        public a b(Boolean bool) {
            this.f16044a.cancelAble = bool.booleanValue();
            return this;
        }

        public a c(UpdateDialogAction updateDialogAction) {
            this.f16044a.actionCancel = updateDialogAction;
            return this;
        }

        public a d(UpdateDialogAction updateDialogAction) {
            this.f16044a.actionConfirm = updateDialogAction;
            return this;
        }

        public a e(String str) {
            this.f16044a.content = str;
            return this;
        }

        public a f(boolean z10) {
            this.f16044a.forceUpdate = z10;
            return this;
        }

        public a g(UpdateDialogAction updateDialogAction) {
            this.f16044a.actionOk = updateDialogAction;
            return this;
        }

        public void h() {
            this.f16045b.show();
        }
    }

    public UpdateDialog(@n0 Context context, DialogParams dialogParams) {
        super(context);
        this.f16043r = dialogParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void G(View view) {
        UpdateDialogAction updateDialogAction = this.f16041p;
        if (updateDialogAction != null) {
            updateDialogAction.F(D());
            com.flydigi.userBehavior.a.a().b(getContext(), "点击立即更新");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(View view) {
        UpdateDialogAction updateDialogAction = this.f16040o;
        if (updateDialogAction != null) {
            updateDialogAction.F(D());
            com.flydigi.userBehavior.a.a().b(getContext(), "点击下次再说");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(View view) {
        UpdateDialogAction updateDialogAction = this.f16042q;
        if (updateDialogAction != null) {
            updateDialogAction.F(D());
            com.flydigi.userBehavior.a.a().b(getContext(), "点击立即更新");
        }
    }

    public final j D() {
        return this;
    }

    public final void E() {
        this.f16037l.setOnClickListener(new View.OnClickListener() { // from class: c9.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10672a.G(view);
            }
        });
        this.f16036k.setOnClickListener(new View.OnClickListener() { // from class: c9.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10673a.H(view);
            }
        });
        this.f16039n.setOnClickListener(new View.OnClickListener() { // from class: c9.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f10674a.I(view);
            }
        });
    }

    public final void F() {
        setCancelable(this.f16043r.cancelAble);
        if (this.f16043r.forceUpdate) {
            this.f16035j.setVisibility(8);
            this.f16038m.setVisibility(0);
            this.f16039n.setText(R.string.app_update_right_now);
            L(this.f16043r.actionOk);
        } else {
            this.f16035j.setVisibility(0);
            this.f16038m.setVisibility(8);
            this.f16036k.setText(R.string.app_next_time);
            this.f16037l.setText(R.string.app_update_right_now);
            J(this.f16043r.actionCancel);
            K(this.f16043r.actionConfirm);
        }
        this.f16034i.setText(this.f16043r.content);
    }

    public final void J(UpdateDialogAction updateDialogAction) {
        this.f16040o = updateDialogAction;
    }

    public final void K(UpdateDialogAction updateDialogAction) {
        this.f16041p = updateDialogAction;
    }

    public final void L(UpdateDialogAction updateDialogAction) {
        this.f16042q = updateDialogAction;
    }

    @Override // androidx.appcompat.app.e, androidx.appcompat.app.j, androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main_layout_dialog_update);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(R.color.color_black_trans)));
        }
        this.f16034i = (TextView) findViewById(R.id.tv_content);
        this.f16035j = (LinearLayout) findViewById(R.id.ll_double);
        this.f16036k = (TextView) findViewById(R.id.tv_cancel);
        this.f16037l = (TextView) findViewById(R.id.tv_confirm);
        this.f16038m = (LinearLayout) findViewById(R.id.ll_ok);
        this.f16039n = (TextView) findViewById(R.id.tv_ok);
        E();
        F();
        com.flydigi.userBehavior.a.a().b(getContext(), "显示更新弹框");
    }

    public UpdateDialog(@n0 Context context, int i10, DialogParams dialogParams) {
        super(context, i10);
        this.f16043r = dialogParams;
    }

    public UpdateDialog(@n0 Context context, boolean z10, @p0 DialogInterface.OnCancelListener onCancelListener, DialogParams dialogParams) {
        super(context, z10, onCancelListener);
        this.f16043r = dialogParams;
    }
}
