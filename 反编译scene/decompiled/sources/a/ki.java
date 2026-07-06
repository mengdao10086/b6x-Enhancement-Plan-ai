package a;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ki {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ji f6609a;

    public ki(Window window, View view) {
        ji fiVar;
        int i = Build.VERSION.SDK_INT;
        if (i >= 30) {
            this.f6609a = new ii(window, this);
            return;
        }
        if (i >= 26) {
            fiVar = new hi(window, view);
        } else if (i >= 23) {
            fiVar = new gi(window, view);
        } else {
            if (i < 20) {
                this.f6609a = new ji();
                return;
            }
            fiVar = new fi(window, view);
        }
        this.f6609a = fiVar;
    }

    public ki(WindowInsetsController windowInsetsController) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f6609a = new ii(windowInsetsController, this);
        } else {
            this.f6609a = new ji();
        }
    }

    public static ki c(WindowInsetsController windowInsetsController) {
        return new ki(windowInsetsController);
    }

    public void a(int i) {
        this.f6609a.a(i);
    }

    public void b(int i) {
        this.f6609a.b(i);
    }
}
