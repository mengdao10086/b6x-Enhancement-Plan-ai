package a;

import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t31 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f7461a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f2948a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f2949a;

    public t31(Runnable runnable) {
        f92.d(runnable, "onChange");
        this.f2949a = runnable;
        this.f2948a = new Handler(Looper.getMainLooper());
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    public final long b() {
        return this.f7461a;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f7461a = jCurrentTimeMillis;
            this.f2948a.postDelayed(new s31(jCurrentTimeMillis, this), 300L);
        }
    }
}
