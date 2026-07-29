package vj;

import bk.f;
import hk.h;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@h(name = "ThreadsKt")
@t0({"SMAP\nThread.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Thread.kt\nkotlin/concurrent/ThreadsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
public final class b {

    public static final class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.a<z1> f53191a;

        public a(ik.a<z1> aVar) {
            this.f53191a = aVar;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f53191a.o();
        }
    }

    @f
    public static final <T> T a(ThreadLocal<T> threadLocal, ik.a<? extends T> aVar) {
        f0.p(threadLocal, "<this>");
        f0.p(aVar, "default");
        T t10 = threadLocal.get();
        if (t10 != null) {
            return t10;
        }
        T tO = aVar.o();
        threadLocal.set(tO);
        return tO;
    }

    @k
    public static final Thread b(boolean z10, boolean z11, @l ClassLoader classLoader, @l String str, int i10, @k ik.a<z1> block) {
        f0.p(block, "block");
        a aVar = new a(block);
        if (z11) {
            aVar.setDaemon(true);
        }
        if (i10 > 0) {
            aVar.setPriority(i10);
        }
        if (str != null) {
            aVar.setName(str);
        }
        if (classLoader != null) {
            aVar.setContextClassLoader(classLoader);
        }
        if (z10) {
            aVar.start();
        }
        return aVar;
    }
}
