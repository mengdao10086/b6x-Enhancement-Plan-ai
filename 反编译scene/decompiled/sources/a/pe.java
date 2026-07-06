package a;

import android.os.Handler;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class pe<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hf<T> f7109a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f2421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Callable<T> f2422a;

    public pe(Handler handler, Callable<T> callable, hf<T> hfVar) {
        this.f2422a = callable;
        this.f7109a = hfVar;
        this.f2421a = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        T tCall;
        try {
            tCall = this.f2422a.call();
        } catch (Exception unused) {
            tCall = null;
        }
        this.f2421a.post(new oe(this, this.f7109a, tCall));
    }
}
