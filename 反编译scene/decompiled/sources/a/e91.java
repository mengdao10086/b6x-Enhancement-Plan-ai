package a;

import android.content.SharedPreferences;
import com.omarea.vtools.activities.ActivityAutoClick;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class e91 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SharedPreferences f5980a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityAutoClick.a f707a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ List f708a;

    public e91(ActivityAutoClick.a aVar, List list, SharedPreferences sharedPreferences) {
        this.f707a = aVar;
        this.f708a = list;
        this.f5980a = sharedPreferences;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ActivityAutoClick.k(ActivityAutoClick.this).c();
        new d80(ActivityAutoClick.this.getThemeMode().a(), new ArrayList(this.f708a), true, new d91(this)).B1(ActivityAutoClick.this.getSupportFragmentManager(), "standby_apps");
    }
}
