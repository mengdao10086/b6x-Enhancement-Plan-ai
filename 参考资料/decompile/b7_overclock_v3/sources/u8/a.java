package u8;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.a0;
import com.flydigi.game.R;
import com.flydigi.game.ui.download.DownloadedFragment;
import com.flydigi.game.ui.download.DownloadingFragment;
import com.flydigi.game.ui.download.UpdateAbleFragment;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public class a extends a0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int[] f51952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Context f51953k;

    public a(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.f51952j = new int[]{R.string.downloading, R.string.game_can_update, R.string.game_downloaded};
        this.f51953k = context;
    }

    @Override // androidx.fragment.app.a0
    public Fragment a(int i10) {
        if (i10 == 0) {
            return DownloadingFragment.h6();
        }
        if (i10 == 1) {
            return UpdateAbleFragment.f6();
        }
        if (i10 == 2) {
            return DownloadedFragment.l6();
        }
        return null;
    }

    @Override // k2.a
    public int getCount() {
        return 3;
    }

    @Override // k2.a
    @p0
    public CharSequence getPageTitle(int i10) {
        return this.f51953k.getString(this.f51952j[i10]);
    }
}
