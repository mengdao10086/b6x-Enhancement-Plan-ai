package a;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class tg2 extends CancellationException implements kd2<tg2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final qf2 f7499a;

    public tg2(String str, qf2 qf2Var) {
        super(str);
        this.f7499a = qf2Var;
    }

    @Override // a.kd2
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public tg2 a() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        tg2 tg2Var = new tg2(message, this.f7499a);
        tg2Var.initCause(this);
        return tg2Var;
    }
}
