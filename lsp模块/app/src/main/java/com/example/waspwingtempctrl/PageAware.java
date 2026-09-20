package com.example.waspwingtempctrl;

/**
 * 页面可见性回调（外壳切页时广播）。
 *
 * <p><b>为什么需要它</b>：外壳改用 ViewPager2 后，页面生命周期不再随切页暂停/恢复——
 * ViewPager2 把非当前页压到 STARTED，而 {@code RESUMED → STARTED} 不派发 {@code onPause}，
 * 也不再走 {@code hide()/show()}（{@code onHiddenChanged} 同样不会来）。于是「离开本页要停
 * 定时器 / 归还软键盘设置」这件事必须由外壳显式告知。
 *
 * <p>只有当前页收 {@code true}，其余页收 {@code false}；页序号由外壳写进 Fragment 的 arguments
 * 后反查，页面自身不需要知道自己是第几页。
 */
public interface PageAware {

    /**
     * @param visible true = 本页成为当前页；false = 本页已不是当前页
     */
    void onPageVisible(boolean visible);
}
