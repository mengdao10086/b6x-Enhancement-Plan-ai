package a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class dc0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hc0 f5882a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ InputStream f545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f546a;

    public dc0(hc0 hc0Var, InputStream inputStream, String str) {
        this.f5882a = hc0Var;
        this.f545a = inputStream;
        this.f546a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.f545a, StandardCharsets.UTF_8));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    return;
                }
                try {
                    g30 g30Var = new g30();
                    g30Var.v("type", 4);
                    g30Var.x("message", line + "\n");
                    this.f5882a.f6300a.f1352a.post(new cc0(this, g30Var));
                } catch (Exception unused) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
