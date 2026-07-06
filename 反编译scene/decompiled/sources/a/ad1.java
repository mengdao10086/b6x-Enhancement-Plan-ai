package a;

import androidx.recyclerview.widget.RecyclerView;
import com.omarea.vtools.activities.ActivityModules;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ad1 implements rh0<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityModules f5595a;

    public ad1(ActivityModules activityModules) {
        this.f5595a = activityModules;
    }

    @Override // a.rh0
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getValue() {
        return "";
    }

    @Override // a.rh0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void a(String str) {
        f92.d(str, "value");
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        String lowerCase = str.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        RecyclerView recyclerView = (RecyclerView) this.f5595a._$_findCachedViewById(t61.module_list);
        f92.c(recyclerView, "module_list");
        RecyclerView.g adapter = recyclerView.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterModules");
        }
        ((n11) adapter).getFilter().filter(lowerCase);
    }
}
