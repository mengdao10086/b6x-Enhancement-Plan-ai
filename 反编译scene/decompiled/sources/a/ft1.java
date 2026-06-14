package a;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import com.omarea.Scene;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ft1 implements AdapterView.OnItemSelectedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Runnable f6138a;

    public ft1(Runnable runnable) {
        f92.d(runnable, "runnable");
        this.f6138a = runnable;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    @SuppressLint({"ApplySharedPref"})
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        String strG = wu0.f3480a.g();
        if (i == 0) {
            strG = wu0.f3480a.p();
        } else if (i == 1) {
            strG = wu0.f3480a.c();
        } else if (i == 2) {
            strG = wu0.f3480a.o();
        } else if (i == 3) {
            strG = wu0.f3480a.i();
        } else if (i == 4) {
            strG = wu0.f3480a.j();
        }
        SharedPreferences sharedPreferences = Scene.f4798a.c().getSharedPreferences(hz0.f1282a.l0(), 0);
        if (true ^ f92.a(sharedPreferences.getString("*", wu0.f3480a.c()), strG)) {
            sharedPreferences.edit().putString("*", strG).apply();
            this.f6138a.run();
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
