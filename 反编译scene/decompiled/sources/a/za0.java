package a;

import android.content.Context;
import com.omarea.krscript.model.PageNode;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class za0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static HashMap<String, String> f8052a;

    public final String a() {
        HashMap<String, String> map = f8052a;
        return (map == null || !map.containsKey("executor_core")) ? "file:///android_asset/kr-script/executor.sh" : f8052a.get("executor_core");
    }

    public PageNode b() {
        if (f8052a == null) {
            return null;
        }
        PageNode pageNode = new PageNode("");
        if (f8052a.containsKey("page_list_config_sh")) {
            pageNode.setPageConfigSh(f8052a.get("page_list_config_sh"));
        }
        if (f8052a.containsKey("page_list_config")) {
            pageNode.setPageConfigPath(f8052a.get("page_list_config"));
        }
        return pageNode;
    }

    public final String c() {
        HashMap<String, String> map = f8052a;
        return (map == null || !map.containsKey("toolkit_dir")) ? "file:///android_asset/kr-script/toolkit" : f8052a.get("toolkit_dir");
    }

    public za0 d(Context context) {
        if (f8052a == null) {
            HashMap<String, String> map = new HashMap<>();
            f8052a = map;
            map.put("executor_core", "file:///android_asset/kr-script/executor.sh");
            f8052a.put("page_list_config", "file:///android_asset/kr-script/pages/more.xml");
            f8052a.put("favorite_config", "file:///android_asset/kr-script/pages/favorites.xml");
            f8052a.put("allow_home_page", "1");
            f8052a.put("toolkit_dir", "file:///android_asset/kr-script/toolkit");
            f8052a.put("before_start_sh", "");
            try {
                InputStream inputStreamOpen = context.getAssets().open("kr-script.conf");
                byte[] bArr = new byte[inputStreamOpen.available()];
                inputStreamOpen.read(bArr);
                for (String str : new String(bArr, Charset.defaultCharset()).split("\n")) {
                    String strTrim = str.trim();
                    if (!strTrim.startsWith("#") && strTrim.contains("=")) {
                        int iIndexOf = strTrim.indexOf("=");
                        String strTrim2 = strTrim.substring(0, iIndexOf).trim();
                        String strTrim3 = strTrim.substring(iIndexOf + 2, strTrim.length() - 1).trim();
                        f8052a.remove(strTrim2);
                        f8052a.put(strTrim2, strTrim3);
                    }
                }
            } catch (Exception unused) {
            }
            yc0.l(context, a(), c());
        }
        return this;
    }
}
