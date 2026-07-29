package t7;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.flydigi.device_manager.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public class j extends androidx.appcompat.app.e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CheckBox f50912i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f50913j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f50914k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f50915l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public a f50916m;

    public interface a {
        void a(boolean z10);
    }

    public j(@n0 Context context) {
        super(context);
        this.f50913j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(CompoundButton compoundButton, boolean z10) {
        this.f50913j = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(View view) {
        dismiss();
        a aVar = this.f50916m;
        if (aVar != null) {
            aVar.a(this.f50913j);
        }
    }

    public void G(a aVar) {
        this.f50916m = aVar;
    }

    @Override // androidx.appcompat.app.e, androidx.appcompat.app.j, androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.device_dialog_reset_game_center);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(R.color.color_black_trans)));
        }
        this.f50912i = (CheckBox) findViewById(R.id.cb_reset);
        this.f50915l = (TextView) findViewById(R.id.tv_cancel);
        this.f50914k = (TextView) findViewById(R.id.tv_reset);
        this.f50912i.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: t7.i
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                this.f50911a.D(compoundButton, z10);
            }
        });
        this.f50915l.setOnClickListener(new View.OnClickListener() { // from class: t7.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f50910a.E(view);
            }
        });
        this.f50914k.setOnClickListener(new View.OnClickListener() { // from class: t7.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f50909a.F(view);
            }
        });
    }

    public j(@n0 Context context, int i10) {
        super(context, i10);
        this.f50913j = false;
    }

    public j(@n0 Context context, boolean z10, @p0 DialogInterface.OnCancelListener onCancelListener) {
        super(context, z10, onCancelListener);
        this.f50913j = false;
    }
}
