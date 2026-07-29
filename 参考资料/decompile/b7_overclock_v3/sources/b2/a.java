package b2;

import androidx.annotation.RestrictTo;
import g.n0;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Lock> f9010e = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f9011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lock f9012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FileChannel f9014d;

    public a(@n0 String str, @n0 File file, boolean z10) {
        File file2 = new File(file, str + ".lck");
        this.f9011a = file2;
        this.f9012b = a(file2.getAbsolutePath());
        this.f9013c = z10;
    }

    public static Lock a(String str) {
        Lock reentrantLock;
        Map<String, Lock> map = f9010e;
        synchronized (map) {
            reentrantLock = map.get(str);
            if (reentrantLock == null) {
                reentrantLock = new ReentrantLock();
                map.put(str, reentrantLock);
            }
        }
        return reentrantLock;
    }

    public void b() {
        this.f9012b.lock();
        if (this.f9013c) {
            try {
                FileChannel channel = new FileOutputStream(this.f9011a).getChannel();
                this.f9014d = channel;
                channel.lock();
            } catch (IOException e10) {
                throw new IllegalStateException("Unable to grab copy lock.", e10);
            }
        }
    }

    public void c() {
        FileChannel fileChannel = this.f9014d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f9012b.unlock();
    }
}
