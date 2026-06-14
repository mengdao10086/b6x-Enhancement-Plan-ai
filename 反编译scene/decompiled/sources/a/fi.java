package a;

import android.R;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class fi extends ji {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f6108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Window f901a;

    public fi(Window window, View view) {
        this.f901a = window;
        this.f6108a = view;
    }

    @Override // a.ji
    public void a(int i) {
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                c(i2);
            }
        }
    }

    @Override // a.ji
    public void b(int i) {
        for (int i2 = 1; i2 <= 256; i2 <<= 1) {
            if ((i & i2) != 0) {
                e(i2);
            }
        }
    }

    public final void c(int i) {
        if (i == 1) {
            d(4);
        } else if (i == 2) {
            d(2);
        } else {
            if (i != 8) {
                return;
            }
            ((InputMethodManager) this.f901a.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f901a.getDecorView().getWindowToken(), 0);
        }
    }

    public void d(int i) {
        View decorView = this.f901a.getDecorView();
        decorView.setSystemUiVisibility(i | decorView.getSystemUiVisibility());
    }

    public final void e(int i) {
        if (i == 1) {
            f(4);
            g(1024);
            return;
        }
        if (i == 2) {
            f(2);
            return;
        }
        if (i != 8) {
            return;
        }
        View currentFocus = this.f6108a;
        if (currentFocus == null || !(currentFocus.isInEditMode() || currentFocus.onCheckIsTextEditor())) {
            currentFocus = this.f901a.getCurrentFocus();
        } else {
            currentFocus.requestFocus();
        }
        if (currentFocus == null) {
            currentFocus = this.f901a.findViewById(R.id.content);
        }
        if (currentFocus == null || !currentFocus.hasWindowFocus()) {
            return;
        }
        currentFocus.post(new ei(this, currentFocus));
    }

    public void f(int i) {
        View decorView = this.f901a.getDecorView();
        decorView.setSystemUiVisibility((~i) & decorView.getSystemUiVisibility());
    }

    public void g(int i) {
        this.f901a.clearFlags(i);
    }
}
