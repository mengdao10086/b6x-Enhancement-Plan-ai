package a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t60 extends z60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BufferedWriter f7471a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Process f2971a;

    static {
        new HashMap();
    }

    public t60(Context context, boolean z) {
        new Handler(Looper.getMainLooper());
        new ReentrantLock();
    }

    public /* synthetic */ t60(Context context, boolean z, int i, b92 b92Var) {
        this(context, (i & 2) != 0 ? true : z);
    }

    public final void a() {
        try {
            if (this.f7471a != null) {
                BufferedWriter bufferedWriter = this.f7471a;
                f92.b(bufferedWriter);
                bufferedWriter.close();
            }
            this.f7471a = null;
        } catch (Exception unused) {
        }
        this.f7471a = null;
        try {
            Process process = this.f2971a;
            f92.b(process);
            process.destroy();
        } catch (Exception unused2) {
        }
        this.f2971a = null;
    }
}
