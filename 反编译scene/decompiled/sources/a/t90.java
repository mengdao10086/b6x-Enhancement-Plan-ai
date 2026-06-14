package a;

import a.p80;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t90 extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p80.b f7479a;

    /* JADX WARN: Illegal instructions before constructor call */
    public t90(p80.b bVar) {
        Looper looperMyLooper = Looper.myLooper();
        f92.b(looperMyLooper);
        super(looperMyLooper);
        this.f7479a = bVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Context contextD;
        int i;
        Toast toastMakeText;
        f92.d(message, "msg");
        super.handleMessage(message);
        try {
            if (this.f7479a == null) {
                return;
            }
            if (message.what == 10) {
                p80.b bVar = this.f7479a;
                f92.b(bVar);
                bVar.c();
                if (f92.a(message.obj, Boolean.TRUE)) {
                    p80.b bVar2 = this.f7479a;
                    f92.b(bVar2);
                    toastMakeText = Toast.makeText(bVar2.d(), z20.execute_success, 0);
                    toastMakeText.show();
                }
                p80.b bVar3 = this.f7479a;
                f92.b(bVar3);
                contextD = bVar3.d();
                i = z20.execute_fail;
            } else if (message.what == -1) {
                p80.b bVar4 = this.f7479a;
                f92.b(bVar4);
                contextD = bVar4.d();
                i = z20.execute_fail;
            } else {
                if (message.what != 0 || !f92.a(message.obj, Boolean.FALSE)) {
                    return;
                }
                p80.b bVar5 = this.f7479a;
                f92.b(bVar5);
                bVar5.c();
                p80.b bVar6 = this.f7479a;
                f92.b(bVar6);
                contextD = bVar6.d();
                i = z20.execute_fail;
            }
            toastMakeText = Toast.makeText(contextD, i, 1);
            toastMakeText.show();
        } catch (Exception unused) {
        }
    }
}
