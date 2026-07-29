package androidx.activity.contextaware;

import androidx.activity.contextaware.ContextAwareKt;
import e.a;
import ik.l;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nContextAware.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ContextAware.kt\nandroidx/activity/contextaware/ContextAwareKt$withContextAvailable$2$1\n*L\n1#1,93:1\n*E\n"})
public final class ContextAwareKt$withContextAvailable$2$1 extends Lambda implements l<Throwable, z1> {
    public final /* synthetic */ ContextAwareKt.a $listener;
    public final /* synthetic */ a $this_withContextAvailable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContextAwareKt$withContextAvailable$2$1(a aVar, ContextAwareKt.a aVar2) {
        super(1);
        this.$this_withContextAvailable = aVar;
        this.$listener = aVar2;
    }

    public final void b(@yt.l Throwable th2) {
        this.$this_withContextAvailable.T1(this.$listener);
    }

    @Override // ik.l
    public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
        b(th2);
        return z1.f38230a;
    }
}
