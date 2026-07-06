package a;

import android.os.Handler;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class r60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f7274a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Process f2718a;

    public r60(Handler handler) {
        f92.d(handler, "handler");
        this.f7274a = handler;
    }

    public final void a() {
        try {
            if (this.f2718a != null) {
                Process process = this.f2718a;
                f92.b(process);
                process.getOutputStream().close();
                Process process2 = this.f2718a;
                f92.b(process2);
                process2.destroy();
            }
        } catch (Exception unused) {
        }
    }

    public final r60 b(String str) {
        f92.d(str, "cmd");
        if (this.f2718a == null) {
            e();
        }
        Process process = this.f2718a;
        if (process == null) {
            Handler handler = this.f7274a;
            handler.handleMessage(handler.obtainMessage(-1));
            return this;
        }
        f92.b(process);
        OutputStream outputStream = process.getOutputStream();
        Charset charsetForName = Charset.forName("UTF-8");
        f92.c(charsetForName, "Charset.forName(\"UTF-8\")");
        byte[] bytes = "\n\n".getBytes(charsetForName);
        f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
        outputStream.write(bytes);
        Charset charsetForName2 = Charset.forName("UTF-8");
        f92.c(charsetForName2, "Charset.forName(\"UTF-8\")");
        byte[] bytes2 = str.getBytes(charsetForName2);
        f92.c(bytes2, "(this as java.lang.String).getBytes(charset)");
        outputStream.write(bytes2);
        Charset charsetForName3 = Charset.forName("UTF-8");
        f92.c(charsetForName3, "Charset.forName(\"UTF-8\")");
        byte[] bytes3 = "\n\n".getBytes(charsetForName3);
        f92.c(bytes3, "(this as java.lang.String).getBytes(charset)");
        outputStream.write(bytes3);
        outputStream.flush();
        return this;
    }

    public final Handler c() {
        return this.f7274a;
    }

    public final Process d() {
        return this.f2718a;
    }

    public final r60 e() {
        try {
            if (this.f2718a == null) {
                this.f2718a = a70.g();
            }
            new Thread(new l60(this)).start();
            new Thread(new m60(this)).start();
            this.f7274a.sendMessage(this.f7274a.obtainMessage(0, Boolean.TRUE));
        } catch (Exception unused) {
            Handler handler = this.f7274a;
            handler.sendMessage(handler.obtainMessage(0, Boolean.FALSE));
        }
        return this;
    }

    public final void f() {
        Process process = this.f2718a;
        if (process == null) {
            return;
        }
        f92.b(process);
        OutputStream outputStream = process.getOutputStream();
        f92.c(outputStream, "outputStream");
        Writer outputStreamWriter = new OutputStreamWriter(outputStream, bb2.f5692a);
        BufferedWriter bufferedWriter = outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
        bufferedWriter.write("exit\nexit\nexit\n");
        bufferedWriter.write("\n\n");
        bufferedWriter.flush();
        new Thread(new n60(this)).start();
    }
}
