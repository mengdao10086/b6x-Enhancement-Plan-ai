package a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class ac0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hc0 f5591a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ InputStream f56a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f57a;

    public ac0(hc0 hc0Var, InputStream inputStream, String str) {
        this.f5591a = hc0Var;
        this.f56a = inputStream;
        this.f57a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f56a, StandardCharsets.UTF_8));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return;
                }
                try {
                    g30 g30Var = new g30();
                    g30Var.v("type", 2);
                    g30Var.x("message", line + "\n");
                    this.f5591a.f6300a.f1352a.post(new zb0(this, g30Var));
                } catch (Exception unused) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
