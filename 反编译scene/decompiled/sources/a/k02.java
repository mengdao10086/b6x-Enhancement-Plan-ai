package a;

import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class k02 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l02 f6561a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ n92 f1590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f1591a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1592a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View[] f1593a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ TextView[] f1594a;
    public final /* synthetic */ boolean b;

    public k02(l02 l02Var, n92 n92Var, View[] viewArr, CompoundButton compoundButton, boolean z, String str, TextView[] textViewArr) {
        this.f6561a = l02Var;
        this.f1590a = n92Var;
        this.f1593a = viewArr;
        this.f1591a = compoundButton;
        this.b = z;
        this.f1592a = str;
        this.f1594a = textViewArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        String strN = this.f6561a.n() ? wu0.f3480a.n() : (String) this.f1590a.f6891a;
        View[] viewArr = this.f1593a;
        int length = viewArr.length;
        int i = 0;
        while (true) {
            float f = 0.25f;
            if (i >= length) {
                break;
            }
            View view = viewArr[i];
            f92.c(view, "it");
            Object tag = view.getTag();
            f92.b(tag);
            if (f92.a(tag.toString(), strN)) {
                f = 1.0f;
            } else {
                if (view.getAlpha() != 0.0f) {
                }
                i++;
            }
            view.setAlpha(f);
            i++;
        }
        CompoundButton compoundButton = this.f1591a;
        f92.c(compoundButton, "pedestalSwitch");
        compoundButton.setChecked(this.f6561a.n());
        if (this.b) {
            qc2.d(xd2.a(qe2.b()), null, null, new j02(this, null), 3, null);
            return;
        }
        for (TextView textView : this.f1594a) {
            f92.c(textView, "it");
            textView.setAlpha(0.25f);
        }
    }
}
