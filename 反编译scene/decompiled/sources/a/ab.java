package a;

import android.util.Log;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ab implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f5588a;
    public final /* synthetic */ Object b;

    public ab(Object obj, Object obj2) {
        this.f5588a = obj;
        this.b = obj2;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (cb.f363a != null) {
                cb.f363a.invoke(this.f5588a, this.b, Boolean.FALSE, "AppCompat recreation");
            } else {
                cb.f364b.invoke(this.f5588a, this.b, Boolean.FALSE);
            }
        } catch (RuntimeException e) {
            if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                throw e;
            }
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
        }
    }
}
