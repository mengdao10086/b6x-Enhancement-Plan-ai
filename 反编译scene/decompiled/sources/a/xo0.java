package a;

import android.content.Context;
import android.os.Handler;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xo0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7909a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ zo0 f3604a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Context f3605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ Handler f3606a;

    public xo0(zo0 zo0Var, int i, Context context, Handler handler) {
        this.f3604a = zo0Var;
        this.f7909a = i;
        this.f3605a = context;
        this.f3606a = handler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            URLConnection uRLConnectionOpenConnection = new URL("https://vtools.oss-cn-beijing.aliyuncs.com/vi/Scene9.json").openConnection();
            f92.c(uRLConnectionOpenConnection, "connection");
            uRLConnectionOpenConnection.setConnectTimeout(15000);
            uRLConnectionOpenConnection.setReadTimeout(60000);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(uRLConnectionOpenConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                sb.append(line);
                sb.append("\n");
            }
            String string = sb.toString();
            f92.c(string, "stringBuilder.toString()");
            int length = string.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = f92.e(string.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            g30 g30Var = new g30(string.subSequence(i, length + 1).toString());
            if (!g30Var.j("versionCode") || this.f3604a.e(this.f3605a) >= g30Var.e("versionCode")) {
                return;
            }
            this.f3606a.post(new wo0(this, g30Var));
        } catch (Exception unused) {
        }
    }
}
