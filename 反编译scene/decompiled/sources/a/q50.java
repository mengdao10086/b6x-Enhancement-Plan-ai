package a;

import java.io.IOException;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class q50<V> implements Callable<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g30 f7180a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ r50 f2548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f2549a;

    public q50(r50 r50Var, String str, g30 g30Var) {
        this.f2548a = r50Var;
        this.f2549a = str;
        this.f7180a = g30Var;
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String call() throws IOException {
        String strL = this.f2548a.l(this.f2549a, this.f7180a);
        if (strL == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        String string = ec2.r0(strL).toString();
        if (string.length() > 0) {
            return string;
        }
        return null;
    }
}
