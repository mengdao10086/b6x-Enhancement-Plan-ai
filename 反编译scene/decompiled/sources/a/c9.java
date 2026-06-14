package a;

import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class c9 extends d9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f5768a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExecutorService f359a = Executors.newFixedThreadPool(2, new b9(this));

    @Override // a.d9
    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }
}
