package a;

import android.text.SpannableString;
import android.view.ViewParent;
import android.widget.ScrollView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class me0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ne0 f6799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SpannableString f1926a;

    public me0(ne0 ne0Var, SpannableString spannableString) {
        this.f6799a = ne0Var;
        this.f1926a = spannableString;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6799a.f2083a.append(this.f1926a);
        ViewParent parent = this.f6799a.f2083a.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.ScrollView");
        }
        ((ScrollView) parent).fullScroll(130);
    }
}
