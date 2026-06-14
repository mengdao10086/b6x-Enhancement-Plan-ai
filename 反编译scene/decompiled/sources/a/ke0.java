package a;

import android.text.SpannableString;
import android.view.ViewParent;
import android.widget.ScrollView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ke0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ne0 f6597a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ SpannableString f1621a;

    public ke0(ne0 ne0Var, SpannableString spannableString) {
        this.f6597a = ne0Var;
        this.f1621a = spannableString;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6597a.f2083a.append(this.f1621a);
        ViewParent parent = this.f6597a.f2083a.getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.ScrollView");
        }
        ((ScrollView) parent).fullScroll(130);
    }
}
