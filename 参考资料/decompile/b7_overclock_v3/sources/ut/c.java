package ut;

import android.util.Log;
import java.util.logging.Level;
import tt.f;

/* JADX INFO: loaded from: classes6.dex */
public class c implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f52445a;

    public c(String str) {
        this.f52445a = str;
    }

    @Override // tt.f
    public void a(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(c(level), this.f52445a, str);
        }
    }

    @Override // tt.f
    public void b(Level level, String str, Throwable th2) {
        if (level != Level.OFF) {
            Log.println(c(level), this.f52445a, str + "\n" + Log.getStackTraceString(th2));
        }
    }

    public final int c(Level level) {
        int iIntValue = level.intValue();
        if (iIntValue < 800) {
            return iIntValue < 500 ? 2 : 3;
        }
        if (iIntValue < 900) {
            return 4;
        }
        return iIntValue < 1000 ? 5 : 6;
    }
}
