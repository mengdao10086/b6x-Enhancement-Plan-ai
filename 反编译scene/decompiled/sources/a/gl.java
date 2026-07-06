package a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class gl<E> extends dl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final yl f6217a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Activity f1030a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f1032a;

    public gl(cl clVar) {
        this(clVar, clVar, new Handler(), 0);
    }

    public gl(Activity activity, Context context, Handler handler, int i) {
        this.f6217a = new yl();
        this.f1030a = activity;
        pf.c(context, "context == null");
        this.f1031a = context;
        pf.c(handler, "handler == null");
        this.f1032a = handler;
    }

    public Activity d() {
        return this.f1030a;
    }

    public Context e() {
        return this.f1031a;
    }

    public Handler f() {
        return this.f1032a;
    }

    public abstract void g(Fragment fragment);

    public abstract void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract E i();

    public abstract LayoutInflater j();

    public abstract int k();

    public abstract boolean l();

    public abstract boolean m(Fragment fragment);

    public abstract void n(Fragment fragment, @SuppressLint({"UnknownNullness"}) Intent intent, int i, Bundle bundle);

    public abstract void o();
}
