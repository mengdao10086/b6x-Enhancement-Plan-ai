package xh;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.a0;
import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.ui.PreviewItemFragment;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class c extends a0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList<Item> f55333j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public a f55334k;

    public interface a {
        void a(int i10);
    }

    public c(FragmentManager fragmentManager, a aVar) {
        super(fragmentManager);
        this.f55333j = new ArrayList<>();
        this.f55334k = aVar;
    }

    @Override // androidx.fragment.app.a0
    public Fragment a(int i10) {
        return PreviewItemFragment.F5(this.f55333j.get(i10));
    }

    public void d(List<Item> list) {
        this.f55333j.addAll(list);
    }

    public Item e(int i10) {
        return this.f55333j.get(i10);
    }

    @Override // k2.a
    public int getCount() {
        return this.f55333j.size();
    }

    @Override // androidx.fragment.app.a0, k2.a
    public void setPrimaryItem(ViewGroup viewGroup, int i10, Object obj) {
        super.setPrimaryItem(viewGroup, i10, obj);
        a aVar = this.f55334k;
        if (aVar != null) {
            aVar.a(i10);
        }
    }
}
