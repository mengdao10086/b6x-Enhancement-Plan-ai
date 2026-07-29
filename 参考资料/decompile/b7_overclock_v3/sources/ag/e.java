package ag;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import g.n0;
import g.p0;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* JADX INFO: loaded from: classes7.dex */
public class e implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @n0
    public final Handler f665a;

    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @n0
        public final String f666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f667b;

        public a(@n0 Looper looper, @n0 String str, int i10) {
            super((Looper) n.a(looper));
            this.f666a = (String) n.a(str);
            this.f667b = i10;
        }

        public final File a(@n0 String str, @n0 String str2) {
            File file;
            n.a(str);
            n.a(str2);
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = null;
            File file4 = new File(file2, String.format("%s_%s.csv", str2, 0));
            int i10 = 0;
            while (true) {
                File file5 = file4;
                file = file3;
                file3 = file5;
                if (!file3.exists()) {
                    break;
                }
                i10++;
                file4 = new File(file2, String.format("%s_%s.csv", str2, Integer.valueOf(i10)));
            }
            return (file == null || file.length() >= ((long) this.f667b)) ? file3 : file;
        }

        public final void b(@n0 FileWriter fileWriter, @n0 String str) throws IOException {
            n.a(fileWriter);
            n.a(str);
            fileWriter.append((CharSequence) str);
        }

        @Override // android.os.Handler
        public void handleMessage(@n0 Message message) {
            FileWriter fileWriter;
            String str = (String) message.obj;
            FileWriter fileWriter2 = null;
            try {
                fileWriter = new FileWriter(a(this.f666a, "logs"), true);
            } catch (IOException unused) {
            }
            try {
                b(fileWriter, str);
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException unused2) {
                fileWriter2 = fileWriter;
                if (fileWriter2 != null) {
                    try {
                        fileWriter2.flush();
                        fileWriter2.close();
                    } catch (IOException unused3) {
                    }
                }
            }
        }
    }

    public e(@n0 Handler handler) {
        this.f665a = (Handler) n.a(handler);
    }

    @Override // ag.h
    public void a(int i10, @p0 String str, @n0 String str2) {
        n.a(str2);
        Handler handler = this.f665a;
        handler.sendMessage(handler.obtainMessage(i10, str2));
    }
}
