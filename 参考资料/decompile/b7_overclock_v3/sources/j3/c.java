package j3;

import android.text.TextUtils;
import com.alibaba.android.arouter.facade.template.ILogger;

/* JADX INFO: loaded from: classes2.dex */
public class c implements ILogger {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f36050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f36051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f36052d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f36053a;

    public c() {
        this.f36053a = b.f36037a;
    }

    public static String a(StackTraceElement stackTraceElement) {
        StringBuilder sb2 = new StringBuilder("[");
        if (f36051c) {
            String name = Thread.currentThread().getName();
            String fileName = stackTraceElement.getFileName();
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            long id2 = Thread.currentThread().getId();
            int lineNumber = stackTraceElement.getLineNumber();
            sb2.append("ThreadId=");
            sb2.append(id2);
            sb2.append(" & ");
            sb2.append("ThreadName=");
            sb2.append(name);
            sb2.append(" & ");
            sb2.append("FileName=");
            sb2.append(fileName);
            sb2.append(" & ");
            sb2.append("ClassName=");
            sb2.append(className);
            sb2.append(" & ");
            sb2.append("MethodName=");
            sb2.append(methodName);
            sb2.append(" & ");
            sb2.append("LineNumber=");
            sb2.append(lineNumber);
        }
        sb2.append(" ] ");
        return sb2.toString();
    }

    public void b(boolean z10) {
        f36052d = z10;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void debug(String str, String str2) {
        if (f36050b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                getDefaultTag();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(a(stackTraceElement));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void error(String str, String str2) {
        if (f36050b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                getDefaultTag();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(a(stackTraceElement));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public String getDefaultTag() {
        return this.f36053a;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void info(String str, String str2) {
        if (f36050b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                getDefaultTag();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(a(stackTraceElement));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public boolean isMonitorMode() {
        return f36052d;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void monitor(String str) {
        if (f36050b && isMonitorMode()) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f36053a);
            sb2.append("::monitor");
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(a(stackTraceElement));
        }
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void showLog(boolean z10) {
        f36050b = z10;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void showStackTrace(boolean z10) {
        f36051c = z10;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void warning(String str, String str2) {
        if (f36050b) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                getDefaultTag();
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(a(stackTraceElement));
        }
    }

    public c(String str) {
        this.f36053a = str;
    }

    @Override // com.alibaba.android.arouter.facade.template.ILogger
    public void error(String str, String str2, Throwable th2) {
        if (f36050b && TextUtils.isEmpty(str)) {
            getDefaultTag();
        }
    }
}
