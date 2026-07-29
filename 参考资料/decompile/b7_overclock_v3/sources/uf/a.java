package uf;

import android.content.DialogInterface;
import android.widget.Toast;
import androidx.appcompat.app.e;
import com.flydigi.base.common.p;
import com.flydigi.cyberfox.R;

/* JADX INFO: loaded from: classes7.dex */
public abstract class a extends p {
    public final String K2 = getClass().getSimpleName();

    /* JADX INFO: renamed from: uf.a$a, reason: collision with other inner class name */
    public class DialogInterfaceOnClickListenerC0600a implements DialogInterface.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DialogInterface.OnClickListener f51993a;

        public DialogInterfaceOnClickListenerC0600a(DialogInterface.OnClickListener onClickListener) {
            this.f51993a = onClickListener;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            DialogInterface.OnClickListener onClickListener = this.f51993a;
            if (onClickListener != null) {
                onClickListener.onClick(dialogInterface, i10);
            }
        }
    }

    public void j4() {
        finish();
    }

    public void k4(int i10, DialogInterface.OnClickListener onClickListener) {
        new e.a(this).k(i10).setPositiveButton(R.string.yes, new DialogInterfaceOnClickListenerC0600a(onClickListener)).setNegativeButton(R.string.f14112no, null).create().show();
    }

    public void l4(int i10) {
        Toast.makeText(this, i10, 0).show();
    }

    public void m4(String str) {
        Toast.makeText(this, str, 0).show();
    }

    @Override // com.flydigi.base.common.c, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        wf.e.g(this.K2, "onBackPressed");
        j4();
    }
}
