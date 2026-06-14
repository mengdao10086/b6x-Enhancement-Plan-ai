package a;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.omarea.krscript.model.NodeInfoBase;
import com.omarea.krscript.model.PageNode;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f7103a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f2412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PageNode f2413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2414a;

    public pc0(Activity activity, String str, PageNode pageNode) {
        f92.d(activity, "activity");
        f92.d(str, "pageConfigSh");
        this.f7103a = activity;
        this.f2414a = str;
        this.f2413a = pageNode;
        this.f2412a = new Handler(Looper.getMainLooper());
    }

    public final ArrayList<NodeInfoBase> b() throws XmlPullParserException, IOException {
        String string;
        String strC = yc0.c(this.f7103a, this.f2414a, this.f2413a);
        if (strC == null) {
            string = null;
        } else {
            if (strC == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
            }
            string = ec2.r0(strC).toString();
        }
        if (string == null) {
            return null;
        }
        if (bc2.o(string, ".xml", false, 2, null)) {
            Activity activity = this.f7103a;
            PageNode pageNode = this.f2413a;
            ArrayList<NodeInfoBase> arrayListI = new mc0(activity, string, pageNode != null ? pageNode.getPageConfigDir() : null).i();
            if (arrayListI != null) {
                return arrayListI;
            }
            c();
            return arrayListI;
        }
        if (bc2.x(string, "<?xml", false, 2, null) && bc2.o(string, ">", false, 2, null)) {
            byte[] bytes = string.getBytes(bb2.f5692a);
            f92.c(bytes, "(this as java.lang.String).getBytes(charset)");
            return new mc0(this.f7103a, new ByteArrayInputStream(bytes)).i();
        }
        if (!(string.length() > 0)) {
            return null;
        }
        d(string);
        return null;
    }

    public final void c() {
        this.f2412a.post(new nc0(this));
    }

    public final void d(String str) {
        this.f2412a.post(new oc0(this, str));
    }
}
