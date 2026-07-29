package t7;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.flydigi.data.bean.FirmwareInfoBean;
import com.flydigi.device_manager.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public class f extends androidx.appcompat.app.e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final FirmwareInfoBean f50904i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f50905j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f50906k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f50907l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f50908m;

    public f(@n0 Context context, FirmwareInfoBean firmwareInfoBean) {
        super(context);
        this.f50904i = firmwareInfoBean;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(View view) {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(View view) {
        dismiss();
    }

    @Override // androidx.appcompat.app.e, androidx.appcompat.app.j, androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.device_layout_dialog_firmware_info);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(R.color.color_black_trans)));
        }
        this.f50908m = (ImageView) findViewById(R.id.iv_close);
        this.f50905j = (TextView) findViewById(R.id.tv_title);
        this.f50906k = (TextView) findViewById(R.id.tv_info);
        this.f50907l = (TextView) findViewById(R.id.tv_confirm);
        this.f50905j.setText(this.f50904i.title);
        this.f50906k.setText(this.f50904i.desc);
        this.f50908m.setOnClickListener(new View.OnClickListener() { // from class: t7.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f50902a.C(view);
            }
        });
        this.f50907l.setOnClickListener(new View.OnClickListener() { // from class: t7.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f50903a.D(view);
            }
        });
    }

    public f(@n0 Context context, int i10, FirmwareInfoBean firmwareInfoBean) {
        super(context, i10);
        this.f50904i = firmwareInfoBean;
    }

    public f(@n0 Context context, boolean z10, @p0 DialogInterface.OnCancelListener onCancelListener, FirmwareInfoBean firmwareInfoBean) {
        super(context, z10, onCancelListener);
        this.f50904i = firmwareInfoBean;
    }
}
