package a;

import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.omarea.krscript.model.ShellHandlerBase;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ne0 extends ShellHandlerBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6905a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public je0 f2080a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2081a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ProgressBar f2082a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f2083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final StringBuffer f2084a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2085a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2086b;
    public final int c;
    public final int d;
    public int e;

    public ne0(je0 je0Var, TextView textView, ProgressBar progressBar) {
        f92.d(je0Var, "actionEventHandler");
        f92.d(textView, "logView");
        f92.d(progressBar, "shellProgress");
        this.f2080a = je0Var;
        this.f2083a = textView;
        this.f2082a = progressBar;
        this.f2081a = textView.getContext();
        this.f6905a = f(kb0.kr_shell_log_error);
        this.b = f(kb0.kr_shell_log_basic);
        this.c = f(kb0.kr_shell_log_script);
        this.d = f(kb0.kr_shell_log_end);
        this.f2084a = new StringBuffer();
        this.e = -1;
    }

    public final void e() {
        if (this.f2084a.length() > 0) {
            SpannableString spannableString = new SpannableString(this.f2084a);
            spannableString.setSpan(new ForegroundColorSpan(this.e), 0, this.f2084a.length(), 33);
            this.f2083a.post(new ke0(this, spannableString));
            StringBuffer stringBuffer = this.f2084a;
            stringBuffer.delete(0, stringBuffer.length());
        }
    }

    public final int f(int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            Context context = this.f2081a;
            f92.b(context);
            return context.getColor(i);
        }
        Context context2 = this.f2081a;
        f92.b(context2);
        return context2.getResources().getColor(i);
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase, android.os.Handler
    public void handleMessage(Message message) {
        f92.d(message, "msg");
        int i = message.what;
        if (i == -2) {
            onExit(message.obj);
            return;
        }
        if (i == 0) {
            onStart(message.obj);
            return;
        }
        if (i == 2) {
            onReaderMsg(message.obj);
            return;
        }
        if (i == 4) {
            Object obj = message.obj;
            f92.c(obj, "msg.obj");
            onError(obj);
        } else {
            if (i != 6) {
                return;
            }
            Object obj2 = message.obj;
            f92.c(obj2, "msg.obj");
            onWrite(obj2);
        }
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onError(Object obj) {
        f92.d(obj, "msg");
        this.f2085a = true;
        updateLog(obj, this.f6905a);
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onExit(Object obj) {
        this.f2086b = false;
        updateLog(this.f2081a.getString(ob0.kr_shell_completed), this.d);
        e();
        this.f2080a.b();
        if (this.f2085a) {
            return;
        }
        this.f2080a.a();
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onProgress(int i, int i2) {
        if (i == -1) {
            this.f2082a.setVisibility(0);
            this.f2082a.setIndeterminate(true);
        } else {
            if (i == i2) {
                this.f2082a.setVisibility(8);
                return;
            }
            this.f2082a.setVisibility(0);
            this.f2082a.setIndeterminate(false);
            this.f2082a.setMax(i2);
            this.f2082a.setProgress(i);
        }
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onReader(Object obj) {
        f92.d(obj, "msg");
        updateLog(obj, this.b);
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onStart(Object obj) {
        this.f2083a.setText("");
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onStart(Runnable runnable) {
        this.f2080a.c(runnable);
        this.f2086b = true;
        qc2.d(hf2.f6309a, qe2.c(), null, new le0(this, null), 2, null);
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onWrite(Object obj) {
        f92.d(obj, "msg");
        updateLog(obj, this.c);
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void updateLog(SpannableString spannableString) {
        if (spannableString != null) {
            this.f2083a.post(new me0(this, spannableString));
        }
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void updateLog(Object obj, int i) {
        if (obj != null) {
            if (this.e != i) {
                e();
                this.e = i;
            }
            this.f2084a.append(obj.toString());
        }
    }
}
