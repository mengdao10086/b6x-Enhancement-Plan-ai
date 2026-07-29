package w6;

import androidx.room.e1;
import androidx.room.l0;
import androidx.room.p1;
import com.flydigi.data.bean.CommunitySearchHistoryBean;
import java.util.List;
import xi.j;
import yt.k;

/* JADX INFO: loaded from: classes7.dex */
@l0
public interface c {
    @e1(onConflict = 1)
    @k
    xi.a a(@k CommunitySearchHistoryBean... communitySearchHistoryBeanArr);

    @p1("DELETE FROM community_search_history")
    @k
    xi.a b();

    @p1("SELECT * FROM community_search_history ORDER BY timestamp desc")
    @k
    j<List<CommunitySearchHistoryBean>> getAll();
}
