package a;

import android.content.Context;
import com.omarea.krscript.model.ShellHandlerBase;
import java.nio.channels.SocketChannel;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ad0 implements i50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5594a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ShellHandlerBase f61a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f62a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f63a;

    public ad0(Context context, ShellHandlerBase shellHandlerBase, Runnable runnable, boolean z) {
        this.f61a = shellHandlerBase;
        this.f62a = runnable;
        this.f63a = z;
    }

    @Override // a.i50
    public void a(SocketChannel socketChannel) {
        ShellHandlerBase shellHandlerBase = this.f61a;
        shellHandlerBase.sendMessage(shellHandlerBase.obtainMessage(-2, Integer.valueOf(this.f5594a)));
        Runnable runnable = this.f62a;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // a.i50
    public void b(String str, String str2) {
        ShellHandlerBase shellHandlerBase = this.f61a;
        shellHandlerBase.sendMessage(shellHandlerBase.obtainMessage(4, str2 + "\n"));
    }

    @Override // a.i50
    public void c(SocketChannel socketChannel, k50 k50Var) {
        this.f61a.onStart((Runnable) (this.f63a ? new zc0(this, k50Var) : null));
        this.f61a.obtainMessage(0, "shell@daemon:\n");
    }

    @Override // a.i50
    public void d(SocketChannel socketChannel) {
    }

    @Override // a.i50
    public void e(String str, String str2) {
        ShellHandlerBase shellHandlerBase = this.f61a;
        shellHandlerBase.sendMessage(shellHandlerBase.obtainMessage(2, str2 + "\n"));
    }

    @Override // a.i50
    public void f(int i) {
        this.f5594a = i;
    }
}
