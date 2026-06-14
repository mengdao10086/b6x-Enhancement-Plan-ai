package a;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class l60 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ r60 f6678a;

    public l60(r60 r60Var) {
        this.f6678a = r60Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Process processD = this.f6678a.d();
            f92.b(processD);
            InputStream inputStream = processD.getInputStream();
            f92.c(inputStream, "process!!.inputStream");
            Reader inputStreamReader = new InputStreamReader(inputStream, bb2.f5692a);
            BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            while (true) {
                String line = bufferedReader.readLine();
                f92.c(line, "reader.readLine()");
                if (line == null) {
                    this.f6678a.a();
                    return;
                } else {
                    String string = ec2.r0(line).toString();
                    if (string.length() > 0) {
                        this.f6678a.c().sendMessage(this.f6678a.c().obtainMessage(1, string));
                    }
                }
            }
        } catch (Exception e) {
            System.out.print((Object) e.getMessage());
        }
    }
}
