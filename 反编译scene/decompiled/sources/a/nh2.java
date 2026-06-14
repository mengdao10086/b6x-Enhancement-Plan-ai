package a;

import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class nh2 extends g92 implements g82<Throwable, Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Constructor f6916a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nh2(Constructor constructor) {
        super(1);
        this.f6916a = constructor;
    }

    @Override // a.g82
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Throwable f(Throwable th) {
        Object objA;
        Object objNewInstance;
        try {
            e42 e42Var = g42.f6169a;
            objNewInstance = this.f6916a.newInstance(th);
        } catch (Throwable th2) {
            e42 e42Var2 = g42.f6169a;
            objA = h42.a(th2);
            g42.a(objA);
        }
        if (objNewInstance == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
        objA = (Throwable) objNewInstance;
        g42.a(objA);
        if (g42.c(objA)) {
            objA = null;
        }
        return (Throwable) objA;
    }
}
