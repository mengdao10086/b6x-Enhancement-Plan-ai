package a;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class r0 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WeakReference<DialogInterface> f7256a;

    public r0(DialogInterface dialogInterface) {
        this.f7256a = new WeakReference<>(dialogInterface);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == -3 || i == -2 || i == -1) {
            ((DialogInterface.OnClickListener) message.obj).onClick(this.f7256a.get(), message.what);
        } else {
            if (i != 1) {
                return;
            }
            ((DialogInterface) message.obj).dismiss();
        }
    }
}
