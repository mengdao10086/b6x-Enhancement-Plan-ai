package a;

import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xf extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ yf f7882a;

    public xf(yf yfVar) {
        this.f7882a = yfVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xf(yf yfVar, Handler handler) {
        super(handler.getLooper());
        this.f7882a = yfVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            yf yfVar = this.f7882a;
            yfVar.f3691a.onShowPress(yfVar.f3692a);
            return;
        }
        if (i == 2) {
            this.f7882a.d();
            return;
        }
        if (i != 3) {
            throw new RuntimeException("Unknown message " + message);
        }
        yf yfVar2 = this.f7882a;
        GestureDetector.OnDoubleTapListener onDoubleTapListener = yfVar2.f3690a;
        if (onDoubleTapListener != null) {
            if (yfVar2.f3694a) {
                yfVar2.f3697b = true;
            } else {
                onDoubleTapListener.onSingleTapConfirmed(yfVar2.f3692a);
            }
        }
    }
}
