package a;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.omarea.Scene;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class l11 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u90 f6664a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public File f1713a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f1714a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1715a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public File[] f1716a;
    public File b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f1712a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1717b = false;
    public boolean c = false;

    public l11(File file, Runnable runnable, u90 u90Var, String str) {
        o(file, runnable, u90Var, str);
    }

    public static l11 a(File file, Runnable runnable, u90 u90Var, String str) {
        l11 l11Var = new l11(file, runnable, u90Var, str);
        l11Var.c = false;
        return l11Var;
    }

    public static l11 b(File file, Runnable runnable, u90 u90Var) {
        l11 l11Var = new l11(file, runnable, u90Var, null);
        l11Var.c = true;
        return l11Var;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f1717b) {
            File[] fileArr = this.f1716a;
            if (fileArr == null) {
                return 1;
            }
            return fileArr.length + 1;
        }
        File[] fileArr2 = this.f1716a;
        if (fileArr2 == null) {
            return 0;
        }
        return fileArr2.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f1717b ? i == 0 ? new File(this.f1713a.getParent()) : this.f1716a[i - 1] : this.f1716a[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        String str;
        if (this.f1717b && i == 0) {
            View viewInflate2 = View.inflate(viewGroup.getContext(), 2131558628, null);
            ((TextView) viewInflate2.findViewById(2131361824)).setText("...");
            viewInflate2.setOnClickListener(new d11(this));
            return viewInflate2;
        }
        File file = (File) getItem(i);
        if (file.isDirectory()) {
            viewInflate = View.inflate(viewGroup.getContext(), 2131558628, null);
            viewInflate.setOnClickListener(new e11(this, file, viewInflate));
            if (this.c) {
                viewInflate.setOnLongClickListener(new h11(this, viewInflate, file));
            }
        } else {
            viewInflate = View.inflate(viewGroup.getContext(), 2131558629, null);
            long length = file.length();
            if (length < 1024) {
                str = length + "B";
            } else {
                str = length < 1048576 ? String.format("%sKB", String.format("%.2f", Double.valueOf(file.length() / 1024.0d))) : length < 1073741824 ? String.format("%sMB", String.format("%.2f", Double.valueOf(file.length() / 1048576.0d))) : String.format("%sGB", String.format("%.2f", Double.valueOf(file.length() / 1.073741824E9d)));
            }
            ((TextView) viewInflate.findViewById(t61.ItemText)).setText(str);
            viewInflate.setOnClickListener(new k11(this, viewInflate, file));
        }
        ((TextView) viewInflate.findViewById(2131361824)).setText(file.getName());
        return viewInflate;
    }

    public File m() {
        return this.b;
    }

    public boolean n() {
        if (!this.f1717b) {
            return false;
        }
        p(new File(this.f1713a.getParent()));
        return true;
    }

    public final void o(File file, Runnable runnable, u90 u90Var, String str) {
        file.getAbsolutePath();
        this.f1714a = runnable;
        this.f6664a = u90Var;
        if (str != null) {
            if (str.startsWith(".")) {
                this.f1715a = str;
            } else {
                this.f1715a = "." + str;
            }
        }
        p(file);
    }

    public final void p(File file) {
        this.f6664a.d(Scene.f4796a.getString(2131887088));
        new Thread(new c11(this, file)).start();
    }
}
