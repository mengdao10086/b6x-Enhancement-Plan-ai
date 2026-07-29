package p5;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.TextView;
import com.flydigi.base.R;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes2.dex */
public class r extends androidx.appcompat.app.e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public TextView f46434i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f46435j;

    public r(@n0 Context context, String str) {
        super(context);
        this.f46435j = str;
    }

    public static r A(Context context, String str) {
        return new r(context, str);
    }

    public void B(String str) {
        TextView textView = this.f46434i;
        if (textView != null) {
            textView.setText(str);
            this.f46434i.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        }
    }

    public void C(String str) {
        this.f46434i.setText(str);
    }

    @Override // androidx.appcompat.app.e, androidx.appcompat.app.j, androidx.activity.j, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_dialog_loading);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getContext().getResources().getColor(R.color.color_black_trans)));
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.dimAmount = 0.3f;
            getWindow().setAttributes(attributes);
        }
        this.f46434i = (TextView) findViewById(R.id.tv_title);
        B(this.f46435j);
    }

    public r(@n0 Context context, int i10, String str) {
        super(context, i10);
        this.f46435j = str;
    }

    public r(@n0 Context context, boolean z10, @p0 DialogInterface.OnCancelListener onCancelListener, String str) {
        super(context, z10, onCancelListener);
        this.f46435j = str;
    }
}
