package androidx.core.view;

import android.view.ViewParent;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes2.dex */
public /* synthetic */ class ViewKt$ancestors$1 extends FunctionReferenceImpl implements ik.l<ViewParent, ViewParent> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ViewKt$ancestors$1 f4787c = new ViewKt$ancestors$1();

    public ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    @Override // ik.l
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public final ViewParent i(@yt.k ViewParent p02) {
        kotlin.jvm.internal.f0.p(p02, "p0");
        return p02.getParent();
    }
}
