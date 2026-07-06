package a;

import a.p80;
import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.Timer;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class uh1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ di1 f7598a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Handler f3176a;

    public uh1(di1 di1Var, Handler handler) {
        this.f7598a = di1Var;
        this.f3176a = handler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View viewInflate = LayoutInflater.from(this.f7598a.j()).inflate(2131558493, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(t61.dpi_modify_timeout);
        p80.a aVar = p80.f2403a;
        Activity activityJ = this.f7598a.j();
        f92.c(viewInflate, "view");
        p80.b bVarR = aVar.r(activityJ, viewInflate, false);
        l92 l92Var = new l92();
        l92Var.f6687a = 30;
        new Timer("ModifyDPI").schedule(new rh1(this, l92Var, bVarR, textView), 1000L, 1000L);
        f92.c(textView, "timeoutView");
        textView.setText(String.valueOf(l92Var.f6687a));
        ((Button) viewInflate.findViewById(2131362069)).setOnClickListener(new sh1(this, bVarR));
        ((Button) viewInflate.findViewById(2131362070)).setOnClickListener(new th1(this, bVarR));
        s60.f7366a.c("settings put system pointer_location 1");
    }
}
