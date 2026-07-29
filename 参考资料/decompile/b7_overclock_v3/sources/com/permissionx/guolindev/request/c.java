package com.permissionx.guolindev.request;

import com.permissionx.guolindev.dialog.RationaleDialogFragment;
import java.util.List;
import kotlin.d0;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J2\u0010\t\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0007J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/permissionx/guolindev/request/c;", "", "", "", "permissions", "message", "positiveText", "negativeText", "Lkotlin/z1;", "d", "Leg/c;", "dialog", "b", "Lcom/permissionx/guolindev/dialog/RationaleDialogFragment;", "dialogFragment", "a", "Lcom/permissionx/guolindev/request/t;", "Lcom/permissionx/guolindev/request/t;", "pb", "Lcom/permissionx/guolindev/request/b;", "Lcom/permissionx/guolindev/request/b;", "chainTask", "<init>", "(Lcom/permissionx/guolindev/request/t;Lcom/permissionx/guolindev/request/b;)V", "permissionx_release"}, k = 1, mv = {1, 7, 1})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final t f22103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final b f22104b;

    public c(@yt.k t pb2, @yt.k b chainTask) {
        f0.p(pb2, "pb");
        f0.p(chainTask, "chainTask");
        this.f22103a = pb2;
        this.f22104b = chainTask;
    }

    public static /* synthetic */ void e(c cVar, List list, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 8) != 0) {
            str3 = null;
        }
        cVar.d(list, str, str2, str3);
    }

    public final void a(@yt.k RationaleDialogFragment dialogFragment) {
        f0.p(dialogFragment, "dialogFragment");
        this.f22103a.K(this.f22104b, true, dialogFragment);
    }

    public final void b(@yt.k eg.c dialog) {
        f0.p(dialog, "dialog");
        this.f22103a.L(this.f22104b, true, dialog);
    }

    @hk.i
    public final void c(@yt.k List<String> permissions, @yt.k String message, @yt.k String positiveText) {
        f0.p(permissions, "permissions");
        f0.p(message, "message");
        f0.p(positiveText, "positiveText");
        e(this, permissions, message, positiveText, null, 8, null);
    }

    @hk.i
    public final void d(@yt.k List<String> permissions, @yt.k String message, @yt.k String positiveText, @yt.l String str) {
        f0.p(permissions, "permissions");
        f0.p(message, "message");
        f0.p(positiveText, "positiveText");
        this.f22103a.M(this.f22104b, true, permissions, message, positiveText, str);
    }
}
