package a;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class y00 implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b10 f7936a;

    public y00(b10 b10Var) {
        this.f7936a = b10Var;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        this.f7936a.d((a10) message.obj);
        return true;
    }
}
