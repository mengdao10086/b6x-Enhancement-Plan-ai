package s8;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.e0;
import com.flydigi.game.data.bean.GameCatEntity;
import com.flydigi.game.ui.category.MainGameCatDetailFragment;
import g.p0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class a extends e0 {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List<GameCatEntity> f49523l;

    public a(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f49523l = new ArrayList();
    }

    @Override // androidx.fragment.app.e0
    public Fragment a(int i10) {
        return MainGameCatDetailFragment.s6(this.f49523l.get(i10));
    }

    @Override // k2.a
    public int getCount() {
        return this.f49523l.size();
    }

    @Override // k2.a
    @p0
    public CharSequence getPageTitle(int i10) {
        return this.f49523l.get(i10).title;
    }

    public void setData(List<GameCatEntity> list) {
        this.f49523l = list;
        notifyDataSetChanged();
    }
}
