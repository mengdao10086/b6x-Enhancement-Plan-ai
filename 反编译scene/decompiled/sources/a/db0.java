package a;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.SpannableString;
import android.widget.RemoteViews;
import com.omarea.krscript.model.RunnableNode;
import com.omarea.krscript.model.ShellHandlerBase;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class db0 extends ShellHandlerBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final cb0 f525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public NotificationManager f526a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PendingIntent f527a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f528a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RunnableNode f529a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f530a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f531a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<String> f532a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f533a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f534b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f535b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public String f536c;

    public db0(Context context, RunnableNode runnableNode, int i) {
        f92.d(context, "context");
        f92.d(runnableNode, "runnableNode");
        this.f528a = context;
        this.f529a = runnableNode;
        this.c = i;
        Object systemService = context.getSystemService("notification");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
        this.f526a = (NotificationManager) systemService;
        this.f531a = this.f529a.getTitle();
        this.f532a = new ArrayList<>();
        this.f534b = "";
        this.f536c = this.f528a.getPackageName() + ".TaskStop.N" + this.c;
        Context context2 = this.f528a;
        Intent intent = new Intent(this.f536c);
        intent.putExtra("id", this.c);
        m42 m42Var = m42.f6769a;
        this.f527a = PendingIntent.getBroadcast(context2, 0, intent, 134217728);
        this.f525a = new cb0(this);
    }

    public final void c() {
        int i = 8;
        if (this.f532a.size() > 8) {
            synchronized (this.f532a) {
                this.f532a.remove(i52.A(this.f532a));
                this.f533a = true;
                m42 m42Var = m42.f6769a;
            }
        }
        RemoteViews remoteViews = new RemoteViews(this.f528a.getPackageName(), nb0.kr_task_notification);
        remoteViews.setTextViewText(mb0.kr_task_title, this.f531a + "(" + this.c + ")");
        int i2 = mb0.kr_task_log;
        String strH = i52.H(this.f532a, "", this.f533a ? "……\n" : "", null, 0, null, null, 60, null);
        if (strH == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        }
        remoteViews.setTextViewText(i2, ec2.r0(strH).toString());
        int i3 = mb0.kr_task_progress;
        int i4 = this.b;
        remoteViews.setProgressBar(i3, i4, this.f5879a, i4 < 0);
        remoteViews.setViewVisibility(mb0.kr_task_progress, this.b == this.f5879a ? 8 : 0);
        int i5 = mb0.kr_task_stop;
        if ((this.f530a != null || this.f529a.getInterruptable()) && !this.f535b) {
            i = 0;
        }
        remoteViews.setViewVisibility(i5, i);
        if (this.f529a.getInterruptable() && this.f530a != null && !this.f535b) {
            remoteViews.setOnClickPendingIntent(mb0.kr_task_stop, this.f527a);
        }
        Notification.Builder contentTitle = new Notification.Builder(this.f528a).setContentTitle("" + this.f531a + "(" + this.c + ")");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(this.f534b);
        sb.append(" >> ");
        sb.append((String) i52.K(this.f532a));
        Notification.Builder when = contentTitle.setContentText(sb.toString()).setSmallIcon(lb0.kr_run).setAutoCancel(true).setWhen(System.currentTimeMillis());
        int i6 = this.b;
        int i7 = this.f5879a;
        if (i6 != i7) {
            when.setProgress(i6, i7, i6 < 0);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            when.setCustomBigContentView(remoteViews);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (!eb0.b) {
                NotificationChannel notificationChannel = new NotificationChannel(eb0.f717a, this.f528a.getString(ob0.kr_script_task_notification), 3);
                notificationChannel.enableLights(false);
                notificationChannel.enableVibration(false);
                notificationChannel.setSound(null, null);
                this.f526a.createNotificationChannel(notificationChannel);
            }
            eb0.b = true;
            when.setChannelId(eb0.f717a);
        } else {
            when.setSound(null);
            when.setVibrate(null);
        }
        Notification notificationBuild = when.build();
        if (Build.VERSION.SDK_INT < 24) {
            notificationBuild.bigContentView = remoteViews;
        }
        if (!this.f535b) {
            f92.b(notificationBuild);
            notificationBuild.flags = 34;
        }
        this.f526a.notify(this.c, notificationBuild);
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onError(Object obj) {
        String string = this.f528a.getString(ob0.kr_script_task_has_error);
        f92.c(string, "context.getString(R.stri…kr_script_task_has_error)");
        this.f534b = string;
        synchronized (this.f532a) {
            ArrayList<String> arrayList = this.f532a;
            j60 j60Var = new j60(this.f528a);
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(obj != null ? obj.toString() : null);
            arrayList.add(j60.d(j60Var, sb.toString(), false, 2, null));
            c();
            m42 m42Var = m42.f6769a;
        }
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onExit(Object obj) {
        this.f535b = true;
        String string = this.f528a.getString(ob0.kr_script_task_finished);
        f92.c(string, "context.getString(R.stri….kr_script_task_finished)");
        this.f534b = string;
        synchronized (this.f532a) {
            if (f92.a(obj, 0)) {
                this.f532a.add("\n" + this.f528a.getString(ob0.kr_shell_completed));
            } else {
                ArrayList<String> arrayList = this.f532a;
                StringBuilder sb = new StringBuilder();
                sb.append("\n");
                sb.append(this.f528a.getString(ob0.kr_shell_finish_error));
                sb.append(" ");
                sb.append(obj != null ? obj.toString() : null);
                arrayList.add(sb.toString());
            }
            c();
            m42 m42Var = m42.f6769a;
        }
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onProgress(int i, int i2) {
        this.f5879a = i;
        this.b = i2;
        c();
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onReader(Object obj) {
        synchronized (this.f532a) {
            ArrayList<String> arrayList = this.f532a;
            StringBuilder sb = new StringBuilder();
            sb.append("");
            sb.append(obj != null ? obj.toString() : null);
            arrayList.add(sb.toString());
            c();
            m42 m42Var = m42.f6769a;
        }
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onStart(Object obj) {
        String string = this.f528a.getString(ob0.kr_script_task_running);
        f92.c(string, "context.getString(R.string.kr_script_task_running)");
        this.f534b = string;
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onStart(Runnable runnable) {
        this.f530a = runnable;
        this.f528a.registerReceiver(this.f525a, new IntentFilter(this.f536c));
        c();
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void onWrite(Object obj) {
    }

    @Override // com.omarea.krscript.model.ShellHandlerBase
    public void updateLog(SpannableString spannableString) {
    }
}
