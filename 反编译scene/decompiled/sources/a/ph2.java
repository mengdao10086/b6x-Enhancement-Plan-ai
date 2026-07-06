package a;

import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ph2 extends g92 implements g82<Throwable, Throwable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Constructor f7120a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ph2(Constructor constructor) {
        super(1);
        this.f7120a = constructor;
    }

    @Override // a.g82
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Throwable f(Throwable th) {
        Object obj;
        Object objNewInstance;
        try {
            e42 e42Var = g42.f6169a;
            objNewInstance = this.f7120a.newInstance(new Object[0]);
        } catch (Throwable th2) {
            e42 e42Var2 = g42.f6169a;
            Object objA = h42.a(th2);
            g42.a(objA);
            obj = objA;
        }
        if (objNewInstance == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Throwable");
        }
        Throwable th3 = (Throwable) objNewInstance;
        th3.initCause(th);
        g42.a(th3);
        obj = th3;
        boolean zC = g42.c(obj);
        Object obj2 = obj;
        if (zC) {
            obj2 = null;
        }
        return (Throwable) obj2;
    }
}
