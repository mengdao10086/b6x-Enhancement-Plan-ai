package a;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ei implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f6006a;

    public ei(fi fiVar, View view) {
        this.f6006a = view;
    }

    @Override // java.lang.Runnable
    public void run() {
        ((InputMethodManager) this.f6006a.getContext().getSystemService("input_method")).showSoftInput(this.f6006a, 0);
    }
}
