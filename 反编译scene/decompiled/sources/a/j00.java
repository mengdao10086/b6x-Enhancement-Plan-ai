package a;

import android.os.Handler;
import android.os.Message;
import com.google.android.material.snackbar.BaseTransientBottomBar;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class j00 implements Handler.Callback {
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            ((BaseTransientBottomBar) message.obj).N();
            return true;
        }
        if (i != 1) {
            return false;
        }
        ((BaseTransientBottomBar) message.obj).D(message.arg1);
        return true;
    }
}
