package a;

import android.content.res.Resources;
import java.lang.Thread;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class y0 implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Thread.UncaughtExceptionHandler f7935a;

    public y0(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f7935a = uncaughtExceptionHandler;
    }

    public final boolean a(Throwable th) {
        String message;
        if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
            return false;
        }
        return message.contains("drawable") || message.contains("Drawable");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        if (!a(th)) {
            this.f7935a.uncaughtException(thread, th);
            return;
        }
        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
        notFoundException.initCause(th.getCause());
        notFoundException.setStackTrace(th.getStackTrace());
        this.f7935a.uncaughtException(thread, notFoundException);
    }
}
