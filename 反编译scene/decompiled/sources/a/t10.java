package a;

import android.widget.AutoCompleteTextView;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class t10 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v10 f7452a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AutoCompleteTextView f2939a;

    public t10(v10 v10Var, AutoCompleteTextView autoCompleteTextView) {
        this.f7452a = v10Var;
        this.f2939a = autoCompleteTextView;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zIsPopupShowing = this.f2939a.isPopupShowing();
        this.f7452a.f7648a.C(zIsPopupShowing);
        this.f7452a.f7648a.f649a = zIsPopupShowing;
    }
}
