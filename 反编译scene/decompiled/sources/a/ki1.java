package a;

import a.p80;
import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.omarea.Scene;
import com.omarea.vtools.activities.ActivityApplications;
import java.nio.channels.SocketChannel;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ki1 implements i50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6611a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public p80.b f1641a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1642a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ProgressBar f1643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f1644a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ActivityApplications.a f1645a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public StringBuilder f1646a;

    public ki1(Context context, View view, p80.b bVar, ActivityApplications.a aVar) {
        f92.d(context, "context");
        f92.d(view, "dialog");
        f92.d(bVar, "alert");
        f92.d(aVar, "handler");
        this.f1642a = context;
        this.f1641a = bVar;
        this.f1645a = aVar;
        View viewFindViewById = view.findViewById(2131362341);
        f92.c(viewFindViewById, "dialog.findViewById(R.id.dialog_text)");
        this.f1644a = (TextView) viewFindViewById;
        View viewFindViewById2 = view.findViewById(2131362329);
        f92.c(viewFindViewById2, "dialog.findViewById(R.id…log_app_details_progress)");
        this.f1643a = (ProgressBar) viewFindViewById2;
        this.f1646a = new StringBuilder();
        this.f6611a = -1;
        this.f1644a.setText("正在获取权限");
    }

    @Override // a.i50
    public void a(SocketChannel socketChannel) {
        String string;
        f92.d(socketChannel, "socketChannel");
        if (this.f6611a == 0) {
            string = this.f1642a.getString(u61.apps_op_completed);
            f92.c(string, "context.getString(R.string.apps_op_completed)");
        } else {
            string = this.f1642a.getString(u61.apps_op_fail) + this.f6611a;
        }
        k(string);
        Scene.f4798a.j(new hi1(this), 2000L);
    }

    @Override // a.i50
    public void b(String str, String str2) {
        f92.d(str, "type");
        f92.d(str2, "error");
        this.f1646a.append(str2);
        this.f1646a.append("\n");
    }

    @Override // a.i50
    public void c(SocketChannel socketChannel, k50 k50Var) {
        f92.d(socketChannel, "socketChannel");
        f92.d(k50Var, "command");
        String string = this.f1642a.getString(u61.apps_op_ongoing);
        f92.c(string, "context.getString(R.string.apps_op_ongoing)");
        k(string);
    }

    @Override // a.i50
    public void d(SocketChannel socketChannel) {
        f92.d(socketChannel, "socketChannel");
    }

    @Override // a.i50
    public void e(String str, String str2) {
        f92.d(str, "type");
        f92.d(str2, "message");
        if (!ec2.C(str2, "[operation completed]", false, 2, null)) {
            k(str2);
            return;
        }
        this.f1643a.setProgress(100);
        Scene.f4798a.j(new ii1(this), 1200L);
        this.f1645a.a();
    }

    @Override // a.i50
    public void f(int i) {
        this.f6611a = i;
    }

    public final void k(String str) {
        this.f1644a.post(new ji1(this, str));
    }
}
