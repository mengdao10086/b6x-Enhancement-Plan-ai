package com.permissionx.guolindev.request;

import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\tR\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\t¨\u0006\r"}, d2 = {"Lcom/permissionx/guolindev/request/w;", "", "Lcom/permissionx/guolindev/request/a;", "task", "Lkotlin/z1;", "a", "(Lcom/permissionx/guolindev/request/a;)V", "b", "()V", "Lcom/permissionx/guolindev/request/a;", "headTask", "tailTask", "<init>", "permissionx_release"}, k = 1, mv = {1, 7, 1})
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.l
    public a f22158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public a f22159b;

    public final void a(@yt.k a task) {
        f0.p(task, "task");
        if (this.f22158a == null) {
            this.f22158a = task;
        }
        a aVar = this.f22159b;
        if (aVar != null) {
            aVar.f22100b = task;
        }
        this.f22159b = task;
    }

    public final void b() {
        a aVar = this.f22158a;
        if (aVar != null) {
            aVar.T();
        }
    }
}
