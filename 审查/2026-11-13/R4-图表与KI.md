# R4 — 图表与 KI 分段视图（只读全量审查）

> 审查日期：2026-11-13。范围：曲线子系统（`Chart*`）+ KI 分段倍率表编辑器与曲线（`KiCut*`）+ 相关资源。
> 纪律：未修改任何源码/资源/配置，未编译、未提交、未投放产物。行号以审查时工作树为准。

## 0. 头

### 范围

- 曲线数据链路：`ChartLoader`（读盘/缓存）→ `ChartDataset`（解析/滤波）→ `ChartWindow`（切片/断联）→ `ChartConfig`（口径）→ `ChartView`（定标/路径/标注/触摸）。
- 曲线外壳：`ChartFragment`（1Hz 刷新、档位、图例 5+4 与等比缩放 k、画布拖柄）。
- KI 分段倍率表：`KiCutTable`（纯模型/求值）、`KiCutTableEditor`（簇/点编辑、插入/拆分）、`KiCutChartView`（三轴曲线 + 当前冷值红线）、`KiCutData`（横轴上限与红线取数）。
- 资源：`dimens_chart.xml`、`strings_chart.xml`、`colors.xml`（chart_* 段）、`colors_kicut.xml`、`dimens_kicut.xml`、`strings_kicut.xml`、`fragment_chart.xml`、`item_chart_legend.xml`、`ic_chart_legend_box.xml`；并核对 `values-night/colors.xml` 同名覆盖。

### 实际读取文件清单

白名单（全量逐行）：

| 文件 | 行数 |
|---|---|
| `.../ui/ChartAxis.java` | 182 |
| `.../ui/ChartConfig.java` | 256 |
| `.../ui/ChartDataset.java` | 286 |
| `.../ui/ChartFragment.java` | 848 |
| `.../ui/ChartLoader.java` | 218 |
| `.../ui/ChartSample.java` | 74 |
| `.../ui/ChartSeries.java` | 258 |
| `.../ui/ChartView.java` | 1302 |
| `.../ui/ChartWindow.java` | 72 |
| `.../ui/KiCutChartView.java` | 377 |
| `.../ui/KiCutData.java` | 142 |
| `.../ui/KiCutTable.java` | 541 |
| `.../ui/KiCutTableEditor.java` | 988 |
| `res/values/dimens_chart.xml`、`strings_chart.xml`、`colors.xml`、`colors_kicut.xml`、`dimens_kicut.xml`、`strings_kicut.xml` | 79 / 53 / 86 / 16 / 31 / 25 |
| `res/layout/fragment_chart.xml`、`item_chart_legend.xml` | 135 / 33 |
| `res/drawable/ic_chart_legend_box.xml` | 13 |

越界读取（仅作数据/契约核对，不展开审查）：

| 文件 | 用途 |
|---|---|
| `ui/ConfigKeyRow.java:795-990` | 表型键渲染、KiCut 曲线重算与 1Hz 取数、横轴刻度集合 |
| `core/ConfigStore.java`（read/parse/fingerprint/rawInt/present 段） | 指纹口径、旧键兼容、是否解析期钳位 |
| `core/AppFiles.java`（probe/readTailText/dataFile/coldMaxFile） | 读盘与诊断契约 |
| `res/values-night/colors.xml:48-69` | chart_* / ki_cut_* 深色覆盖完整性 |
| `res/layout/item_ki_cut_point.xml`、`item_ki_cut_cluster.xml` | 编辑器行高/命中层/块内边距 |
| `参数定义/params.def.json`（`PID_CUT` rowFields 段） | 冷值/倍率 min/max 与 allowEmpty |
| `lsp模块/daemon/ki_cut.h`（全文 260 行）、`tempctrl.c`（`WEBUI_ROW_FMT`、`write_webui_data`、`ki_cut_parse_row`、`KI_CUT_MAX_CLUSTERS` 等段） | C 端求值/落盘/列语义对拍 |
| `参数定义/check_params.py:589-640` | golden 用例实际只对 C 侧求值，未覆盖 Java 镜像 |

必读上下文已读：项目 `CLAUDE.md`、`参数定义/对齐报告.md`、`TECH_DEBT.md`、`待办.md`、`lsp模块/app/逻辑说明.md`（全 1035 行）。

### 总行数

- 白名单 Java：**5,544 行**；白名单资源/布局/drawable：**471 行**；合计 **6,015 行**。
- 上下文 + 越界读取：约 **2,800 行**（`逻辑说明.md` 1035、`对齐报告.md` 320、`TECH_DEBT/待办` 158、`ki_cut.h` 260、`ConfigKeyRow` 约 200、其余 C/资源/定义片段约 800）。

---

## A0. 本包专属重点逐条结论

1. **右轴上限 cHigh 推导链 — 公式成立，但仍有一条“配置变了却不重算”的旁路。** `cHigh = max(config.coldMax, coolActual 窗口峰值)`；`actualPeak` 按 id 遍历 `series` 独立统计，**不受图例开关与 swap 影响**；`top = max(cLow, min(cHigh, peak))`（`ChartView.java:370-402`）。`rebuild` 的四个入口（`setData` / `setSeriesEnabled` / `onSizeChanged` / `refreshThemeColors`）都会走到同一段，窗口切换亦经 `setData`，公式链本身无遗漏。旁路在数据层：配置文件指纹变了但数据文件指纹未变时，`ChartLoader` 的进程缓存会返回旧 cfg 解析的 dataset（S2-2）。
2. **越界点分层绘制与裁剪、触摸命中 — 分层成立，裁剪口径与文档不符。** 越界 rpm 点 `ey = getHeight()`（下半被画布裁掉），并在 `onDraw` 中最后绘制，确实不会被 pid 点或另一条端点盖住（`ChartView.java:743-754, 1247-1260`）。但 `逻辑说明.md` §7.3/§7.4 仍写 `fSeamY = min(绘图区下沿+4dp, 画布下沿−5dp)`、圆点“不许被裁”，与代码的 `h` 及 §7.6 的“只露上半边”三者互相矛盾（S3-3）。触摸只在绘图区命中（`inPlot`，`ChartView.java:878-880`），落在画布下沿的越界点按不到数值面板——与“绘图区才响应”的口径一致，列为 D-6。
3. **窗口重算 — 无整数除法缺陷；空/单点/全 NaN/时间戳回退均已走到明确分支。** 空数据在 `ChartLoader` 转失败文本；单点（`samples.length < 2`）显示“采样中…”；**全 NaN/左轴全无效不是“采样中”，而是右轴可建、左轴不可建 → 画布纯空白**（S2-1）。`winSec` 实际按“行数”近似秒（C 端 1Hz 写行，已文档化）；时间戳回退不判断联、窗口由 `maxLines` 兜底；时间戳前跳只留 1 行、短暂回落“采样中…”后自愈（D-4）。
4. **图例 5+4 的等比 k — 400dp 与极小屏兜底可用。** 400dp 满宽下 k≈0.96（约 13.4sp）、320dp 下 k≈0.74（约 10.3sp），均高于 9sp 下限；约低于 245dp 才进入 9sp + 五列平分 + 尾部省略号兜底，且兜底后第二行（4 项）必然不超宽（`ChartFragment.java:471-548`）。仅“3 轮未收敛”的极端边角会走 `shrinkWidestColumns`，此时未设 ellipsize（D-11）。空格/断行由 `startsLegendRow(pid)` 固定，swap 只换同对两槽，不破坏 5+4。
5. **swapCool/swapRpm 与 emphasized — 单一判定，两对互不影响。** 强调方 = `isActual != swap`（`ChartSeries.java:106-113`）；图例槽位、取色、实/虚样式、末端圆点与数值、按住查看行全部由它派生；旧单值配置按两对同值解析（`ChartConfig.java:126-135`）。未发现分对错配或槽位错位。
6. **KiCut 表与图的对应、编辑后重算 — 求值逐句对齐 C，编辑重算路径齐全；三个边角问题。** `KiCutTable` 的 normalize/lerp/intra/nearer/M 计算顺序与 `ki_cut.h` 逐语句一致（D-9）。TYPING 1s 防抖、STRUCTURAL/COMMIT 立即重算、半截态（冷值空 + 倍率有值）不重算（`ConfigKeyRow.java:845-875, 928-943`）。问题：coldMax 无上界（S1-1）；横轴刻度把占位行 `cold=0` 当成刻度（C-1）；红线在 `target > xMax` 时整条不画（S3-10）。

---

## A. 十条横切判据逐条结论

1. **契约一致性 — 有 4 处不一致（均为文档/语义面）。** 数据行 12 列与 C 端 `WEBUI_ROW_FMT` 一一对应、`COL_COUNT=8` 的旧行兼容成立；KI 表求值镜像与 `ki_cut.h` 一致；`UI_CHART_VIEW`/`UI_CHART_SWAP`/`UI_CURVE_FILTER` 的旧键兼容路径完整。不一致：第 8 列（0 基 7）在 `ChartDataset` 注释里写成“0.1°C、读端不消费”，实际是 `actual_cold` 制冷档位且被 `KiCutData` 消费（S3-5）；§7.4 描述的标注合并算法在代码中不存在（S3-4）；`windowDefaultSec` 未被 ChartFragment 用作初值（S3-1）；§7.3 的 `fSeamY` 不存在（S3-3）。
2. **资源生命周期 — 干净，一处状态未复位。** `ChartView` 的换边动画在 `clearTouch`/`onDetachedFromWindow` 取消；`ChartFragment` 在 `onDestroyView` 清空视图字段并 `removeCallbacksAndMessages(null)`；`TableRenderer` 的 1Hz ticker 与曲线防抖任务随 attach/detach 启停；图例 LayoutChangeListener 在重建前移除。唯一残留：`onDetachedFromWindow` 只复位 `panelPlaced`，不清 `touchActive/touchRowCount`（S3-12）。
3. **静默失败 — 1 个用户可见空白面 + 1 个静默不生效面。** `ChartLoader`/`ChartConfig`/`KiCutData` 的失败都有诊断文本或降级说明，`warmUp` 的吞异常是纯优化（文档已声明）。但“左轴不可建而右轴可建”时画布纯空白且无任何占位文案（S2-1）；配置口径变更在数据文件未变时静默沿用旧值（S2-2）。
4. **并发与竞态 — 未发现可崩溃竞态。** `ChartFragment` 用单 worker + `isAlive` 单飞，所有 UI 写入回主线程；`ChartConfig.cached`、`ChartLoader.cached`、`ConfigStore.memo` 均为 `volatile` 且对象不可变（dataset 只在发布前滤波）；`KiCut` 的 1Hz 取数与编辑重算都在主线程串行。`configStale` 在起线程前消费，若 `ChartConfig.load` 意外抛出将不再触发重读（S3-15，低影响）。
5. **状态机完整性 — 刷新/可见性闭合；触摸态跨 detach 有残留。** `startRefresh/stopRefresh` 幂等，`onPause` 与 `setPageHidden` 两入口一致；失败↔成功切换会正确 `GONE/VISIBLE`；画布拖柄的方向判定用 touch slop 且不抢横向。残留见 S3-12；另外 `rebuild` 在数据变空/尺寸过小时会 `clearTouch`，若此时手指仍按着会顺带解除父容器拦截（低影响，D-12）。
6. **输入边界 — 主链安全，两处外部值不设防。** 窗口/档位/刻度容量（`TICK_CAP`、`ladderIn` 128）、空/单点/NaN、负转速、`ChartAxis` 的 span=0 兜底都成立；`KiCutData` 的 coldMax 与 `KiCutTableEditor` 的每簇点数都不设上界，外部改写配置时可 OOM/卡死（S1-1、S3-13）。
7. **旧键兼容层 — 完整。** `UI_RPM_AXIS_MIN`/`UI_PID_MARK` 按槽回退（`ChartConfig.java:167-175`），`UI_CHART_SWAP` 单值按两对同值、`UI_CURVE_FILTER` 两值按“开关开 + 前两值为系数”解析，均不回写配置；`ConfigStore.rawInt` 专门保留了已从定义删除的旧键原值。
8. **重复与死代码 — 4 处轻量。** `ChartDataset.raw()` 无调用点（S3-9）；`ChartConfig.single()` 只是 `field()` 的别名；`ChartSeries.isRpm()` 等同于 `isRpmPair()`；`strings_chart.xml` 的 `chart_section_file` 无引用（`ConfigDiagnostics` 用的是 `chart_loading`）。
9. **文档偏差 — 6 处，其中 §7.4 是整段失效。** 详见 S3-3/4/5/6/7/8：`fSeamY` 不存在；§7.4 的 `placeSingleAnchors`/合并组/`NEAR_DUP_DP` 全不存在且与 §7.6“最多两条标签”矛盾；第 8 列单位与消费方写错；簇上限写成 32（实际 8）；绘制字号写 sp（实现按 dp）；`ChartFragment` 注释把第二行行首写成冷端/CPU。
10. **测试缺口 — 本包无任何自动化测试，KI 镜像的“已对拍”只覆盖 C。** 工程无 `src/test`/`src/androidTest`；`ChartAxis` 的 ticks/segments 同构、`ChartWindow` 的断联/裁剪、`ChartFragment` 的图例收敛都只有注释保护。`check_params.py` 的 E 断言只编译 `ki_cut.h` 对 golden，`KiCutTable` 这份 Java 镜像未被 CI 校验；`KiCutTableEditor` 的插入/拆分几何与高度不变量也未验证。

---

## B. 缺陷清单

### S1（崩溃 / 功能失效 / 数据损坏）

| 文件:行 | 触发条件 | 后果 | 建议（≤30字） |
|---|---|---|---|
| `ui/KiCutData.java:48-53` + `ui/KiCutChartView.java:53-59` | `profile.conf` 的 `PID_COLD_RANGE` 第 2 值或 `tempctrl_coldmax` 的 `COLD_MAX=` 被外部写成极大整数（root 手改/文件损坏），随后打开配置页渲染 KI 表；正常 UI 路径不可达（表单会钳到 255） | `Series.of` 按 `xMax + 1` 分配 3 组 ×3 条曲线的数组，xMax≈2e9 时直接 OOM 崩溃；编辑器文本框到磁盘的往返也失去保护 | 读取后把 coldMax 钳到 ≤255 |

### S2（边界条件下行为与预期不符）

| 文件:行 | 触发条件 | 后果 | 建议（≤30字） |
|---|---|---|---|
| `ui/ChartView.java:632-635, 1160-1162`（`rebuild` 分支 `:404-407`） | 用户在图例中关闭全部左轴系列（电池/实际rpm/热端/冷端/pid/目标rpm/CPU），只保留任一条右轴；或窗口内左轴全无有效值（例如数据行全 -1）而右轴开启 | `buildGrid` 在 `lAxis == null` 时提前返回，`gridY` 恒为 null，`onDraw` 随即整体 return：右轴曲线、圆点、网格、轴标题全不画，画布纯空白且无“采样中/无曲线”占位文案；触摸也不响应 | 无左轴时按右轴建 gridY 并画右轴 |
| `ui/ChartLoader.java:148-156, 170-171` + `ui/ChartFragment.java:341-345` | daemon 停写（数据文件 size:mtime 不变）后修改 `UI_CURVE_FILTER` / `UI_GAP_SEC` / `UI_CHART_VIEW` 并回到曲线页；与启动预热留下的进程缓存命中 | 进程缓存键只有数据文件指纹、不含配置指纹，返回旧 cfg 解析的 dataset（EMA/步长/冷端 0 段判据都是旧值）；下一次刷新又因 `unchanged` 提前返回而不重建窗口，口径一直不生效，直到文件再变 | 缓存键并入配置指纹；unchanged 也重建窗口 |

### S3（一致性 / 可读性 / 运维负担）

| 文件:行 | 触发条件 | 后果 | 建议（≤30字） |
|---|---|---|---|
| `ui/ChartFragment.java:194-198, 334-340` | `params.json` 的 `chart.windowDefaultSec` 被改成 360 以外的档位（仍保留 360 在档位集合内）；或首次进入曲线页 | 首次选档被写死为 `FALLBACK_WINDOW_DEFAULT`(360)，配置到达后因“360 在档位集合内”而不回落 `windowDefaultSec`，`windowDefaultSec` 实际只在不含 360 时生效；单一来源契约被破坏 | 首帧改用 `cfg.windowDefaultSec`（未加载时才用常量） |
| `ui/ChartView.java:990-991` + `res/values/dimens_chart.xml:57` | 九条系列全开、按住查看，且把画布拖到最小高 120dp（或屏幕本身很矮） | 面板高度 = 2×padY + 9×11dp + 分隔 ≈107dp，起点 19dp，末行 baseline 已越过画布下沿；末行被裁、面板底边出界（onDraw 无纵向钳位） | 面板高度按画布可用高压缩或限行 |
| `ui/ChartView.java:743-754` + `lsp模块/app/逻辑说明.md:705, 712, 726` | 阅读/维护标注与越界点口径 | 文档写 `fSeamY = min(绘图区下沿+4dp, 画布下沿−5dp)`、圆点“不许被裁”，代码根本没有 `fSeamY`，实际 `ey = getHeight()` 且“只露上半边”；§7.3 与 §7.6 互相矛盾 | 以 §7.6 为准删改 §7.3/§7.4 |
| `ui/ChartView.java:704-720, 759` + `lsp模块/app/逻辑说明.md:712-722` | 阅读 §7.4 | §7.4 描述的 `placeSingleAnchors`、顺序贪心封组、`NEAR_DUP_DP=8dp`、组盒/传递闭包在 `ChartView` 中全部不存在；代码只给“成对系列的强调方”最多两条标签（与 §7.6 一致），其余 7 条系列没有头部数值 | 按实现重写 §7.4 或补回算法 |
| `ui/ChartDataset.java:34, 41-43` + `ui/KiCutData.java:30-31, 71-76` + `tempctrl.c:4742-4747` | 对照数据行第 8 列（0 基 7） | 注释写“下发目标制冷 0.1°C、读端有意不消费”，C 实际写的是 `actual_cold` 制冷档位（1~255），`KiCutData` 正把它当“当前冷值”消费；单位与“无人消费”两处都错 | 更正为 actual_cold 档位并注明 KiCut 消费 |
| `ui/KiCutTableEditor.java:78` + `lsp模块/app/逻辑说明.md:624` | 阅读 §6.6 或维护上限 | 文档写“上限 32 簇/32 点（与 C KI_CUT_MAX_POINTS 同档）”，C 的 `KI_CUT_MAX_CLUSTERS` 与编辑器都是 8 簇；文档会让读者以为可配 32 簇 | 改为 8 簇 / 32 点 |
| `ui/ChartView.java:69, 185-199` + `lsp模块/app/逻辑说明.md:698` | 系统字体放大（大字体无障碍设置） | `TICK_TEXT_DP` 乘的是 `density`（dp），文档却称 10sp；刻度/轴标题/标注/按住面板不随字体缩放，与图例（sp）不一致 | 改用 `scaledDensity` 或更正文档 |
| `ui/ChartFragment.java:79` | 阅读类注释 | 注释写“冷端℃/CPU℃ 由 setBreakBefore 固定另起第二行”，实际 `startsLegendRow` 只对 pid 为真（第二行行首是 pid℃） | 更正为 pid 起第二行 |
| `ui/ChartDataset.java:151-153`、`ui/ChartConfig.java:196-198`、`ui/ChartSeries.java:93-95` | 代码维护 | `raw()` 无调用点；`single()` 只是 `field()` 别名；`isRpm()` 与 `isRpmPair()` 完全等价且只被 `axisValue` 使用 | 删除/合并 |
| `ui/KiCutChartView.java:272-276` | 设备回显的实际冷值（`actual_cold`）大于 daemon 给的横轴上限（如对齐瞬间回显厂商 app 的 194 而配置上限 190），或上限文件尚未刷新 | `target <= xMax` 才画红线，越界时**整条红线消失**而不是夹到右沿；用户失去“当前冷值”指示 | 越界时夹到 xMax 并换用越界样式 |
| `ui/KiCutData.java:60-80` | daemon 停止/断联后数据文件不再更新 | 红线仍取最后一行 `actual_cold` 永久停留（无时间新鲜度判据），看起来像“当前值”；daemon 未运行时具有误导性 | 末行时间戳超过阈值则不画 |
| `ui/ChartView.java:1136-1141` | 按住查看期间 `ChartView` 被 detach（父容器移除/复用）后重新 attach | `onDetachedFromWindow` 只清 `panelPlaced`，`touchActive/touchRowCount/touchRawX` 保留；重新 attach 后的首帧仍画出旧高亮线与数值面板 | detach 时调 `clearTouch()` |
| `ui/KiCutTableEditor.java:650-668` + `ui/KiCutTable.java:132-171` | 外部（root 手改/旧版本）写入 `PID_CUT_x`：单簇点数远超 32（C 端会截断到 32） | 编辑器按 `cluster.points` 全量 inflate 行视图，数千行会造成明显卡顿甚至 ANR；C 端只认前 32 点，预览与 daemon 也不一致 | 渲染前按 MAX_POINTS 截断并提示 |
| `ui/KiCutTableEditor.java:817-826` + `ui/ConfigKeyRow.java:908-915, 1414-1425` | 外部配置里存在“冷值空 + 至少一个倍率有值”的行（合法占位行在 UI 里会写成全空，此类行只能来自外部） | `hasEmptyCold()` 恒真：曲线不重绘、`read(false)` 恒返回 null，整键永不写盘；失焦 `restoreInputs()` 恢复的仍是同一份半截值，界面无任何提示，只能靠用户自己清空/补齐该行 | 对磁盘来的半截行按下限还原或提示 |
| `ui/ChartFragment.java:291-296` | `configStale` 置真后后台线程在 `ChartConfig.load` 抛异常（非常规路径） | `configStale` 已在起线程前消费，之后不会重读配置，曲线口径停留旧值直到下一次 `onResume` | 失败时把 `configStale` 置回 |
| `审查边界：本包无自动化测试` | 维护/回归 | `ChartAxis`/`ChartWindow`/`ChartView`/`ChartFragment` 无单测；`check_params.py` 的 E 只对 C `ki_cut.h` 与 golden 对拍，`KiCutTable` 的 Java 镜像、图例 k、触摸命中均无自动验证 | 至少把 golden 跑在 Java 镜像上 |

---

## C. 越界发现（归属其他包）

1. **归属 配置表单/表型渲染包（`ui/ConfigKeyRow`）**：`ConfigKeyRow.java:952-959` 的 `xTicksOf` 把每条 `Point.cold` 都加进横轴刻度，**包括冷值留空的占位行（`cold=0`）**；注释明确写“不补 0”，但插入一条空行后图上仍会出现 0 刻度。建议只对 `hasCold` 为真的点取刻度。
2. **归属 配置表单/表型渲染包（`ui/ConfigKeyRow.TableRenderer`）**：`ConfigKeyRow.java:821-826, 980-989` 的 1Hz tick 只轮询 `KiCutData.targetCold`，横轴上限 `coldMax` 只在 `redrawChart()` 时重读；设备切换导致 `tempctrl_coldmax` 变化但最后一行目标冷值恰好不变时，横轴刻度会停留在旧上限。建议 tick 里一并比较 coldMax。
3. **归属 配置表单/表型渲染包（`ui/ConfigKeyRow.TableRenderer`）**：`redrawChart()`（`ConfigKeyRow.java:929-943`）在主线程顺序执行 `KiCutData.coldMax`（读 ConfigStore + 64 字节文件）与 `KiCutData.targetCold`（读 ConfigStore + 4KB 尾读），每次失焦 COMMIT 也各多一轮同步 I/O；文件小、有 memo，暂列观察项而非缺陷。
4. **归属 配置表单包（`ui/ConfigKeyRow`）**：`hasEmptyCold()` 的写盘闸门（`:909`）配合 `restoreInputs()`（`:1417-1419`）对“磁盘来的半截行”无法自愈——见 S3 表最后第二条，根因跨本包与配置包，修复建议落在编辑器侧。

---

## D. 已核实无害（可疑但查证不成立）

1. **cHigh 公式与所有重算路径**：`actualPeak` 按 id 独立统计、不看图例开关与 swap（`ChartView.java:382-396`）；`top` 的三层 clamp 不会产生 NaN 或除零（`ChartAxis.range` 对 `max <= min` 抬到 `min+1`，`ChartAxis.java:34-39`）；窗口/图例/尺寸/主题四条重建入口都复算。唯一例外是 S2-2 的数据层缓存，不属于公式链。
2. **swap 与 emphasized 的分对判定**：`emphasized` 是唯一判定，`displayOrder` 的两对交换互不干扰（cool 对下标 1/6、rpm 对 2/7，swap 只动自己的两个位置）；参考方不画点/不标数值；旧单值 `UI_CHART_SWAP` 兼容正确。无“制冷交换把风扇对也换掉”的问题。
3. **ChartAxis 的 ticksOf/segmentsOf 同构**：两处逐句同形（首刻度补点、`1e-9`/`1e-6` 容差、`TICK_CAP` 护栏、非整档补 `hi`）；`segmentsOf` 只计数不落数组，容量上限与 `ticksOf` 的 256 一致；`pickStep` 的候选区间与 `3~5` 段过滤不会选到 0 步长。
4. **窗口的空/单点/时间戳回退**：空数据转失败文本；单点显示“采样中…”是有意行为；时间戳回退（dt<0）不判断联且 `u` 仍单调（按行号 + 累计 gap），窗口由 `maxLines` 兜底；时间戳前跳会暂时只剩 1 行、2 秒内自愈。`winSec` 按行数近似秒与 C 端 1Hz 写入一致，非整数除法缺陷。
5. **图例 k 的数值**：按 14sp/16dp/4dp/18dp 基准与常见中文标签宽估算，400dp 下 k≈0.96、320dp 下 k≈0.74，均未触发 9sp 下限；兜底分支的 `each = (rowLimit - cols*gap)/cols` 取整只会更窄，第二行 4 项必然放得下。`cols` 由 pid 固定为 5、9 项满足 `5 < 9 <= 10`，不会走“行结构变了”的早退。
6. **越界点分层**：`overflow` 点在 `onDraw` 的第一轮跳过、第二轮最后画，确实在 pid 点与普通端点之上；越界点位于绘图区外，触摸按不到是“只有绘图区响应”的既定口径，不是遗漏。
7. **rpm 下限过滤的退回**：`extent(left,...,true)` 返回 null 时用不过滤再求一次范围（`ChartView.java:361-369`），不会因全部转速低于下限而没有左轴；此时低速段画到图外是有意行为。
8. **目标制冷超过右轴上限**：`top` 只保证 `actualPeak`，target 可能越出绘图区上沿并在画布顶被裁（`ChartView.java:399-401`）；文档明确只保证“实际制冷点不无故越界”，属有意取舍，非缺陷。
9. **KiCut 求值镜像**：逐语句比对 `ki_cut.h` 的 `ki_cut_normalize`（稳定升序、同冷值保留先出现）、`ki_cut_lerp`（端点平推、留空剔除）、`ki_cut_axis_intra`（梯形 + 公共端点减一次、不按跨度迭代）、`ki_cut_axis_eval`（M 的求和顺序、`nearer` 的相等取小、单候选直通），Java 侧顺序与边界一致，未发现数值分叉；`Curve.of` 的 32 点截断也与 C 的 token 上限一致。
10. **KiCutChartView 的边界**：`gridX` 对 `xMax >= 1` 做守卫、x 越界钳到两端；`Series` 长度恒 `xMax+1`；`axis == null` 时 onDraw 直接返回；虚线段端点按 `shadow == value` 相接，贴边端点改用生效值，不会悬空。
11. **图例 3 轮收敛后的削宽**：只有 `k >= minK` 且三轮仍溢出时才 `shrinkWidestColumns`，实际溢出通常只剩几像素；未设 ellipsize 的裁剪风险未在可实现范围内成立（列入 E 观察）。
12. **`clearTouch()` 的父容器解锁**：`requestDisallowInterceptTouchEvent(false)` 即使在未按下时调用也无副作用（下一次 DOWN 各 ViewGroup 会重置拦截位），不构成手势故障。
13. **`ChartLoader.tailForParse` 的差一**：`contentEnd` 先跳过尾部换行，`lines` 计的是行间分隔符；触发截尾时仍按“自尾数第 cap 个换行”取尾，解析器再按 `cap` 环形保留，最终保留行数正确，仅触发阈值有 1 行误差。
14. **深色配色完整性**：`values-night/colors.xml:48-69` 覆盖了全部 9 个 `chart_series_*`、`chart_axis` 与 5 个 `ki_cut_*`；曲线页/图例/KI 曲线都按主题现取，无缺失回退。
15. **`KiCutTableEditor.MAX_CLUSTERS=8`**：与 `tempctrl.c:269` 的 `KI_CUT_MAX_CLUSTERS 8` 一致（文档的 32 是错的，见 S3-6）。

---

## E. 未覆盖 / 待真机

1. **越界点与触摸**：画布下沿的“只露半边”点、8dp 拖柄触控带与系统手势导航的边缘占用，需真机确认可按区与视觉裁切。
2. **图例 k 的真实测量**：`measure(UNSPECIFIED, UNSPECIFIED)` 与真实布局在 OEM 字体度量下可能有差异；9sp 兜底后的省略号/触控尺寸（minWidth=0 使触控变小）需真机在 320dp/400dp + 字体 1.3× 下验证。
3. **1Hz 重建的流畅性**：`rebuild` 每秒为 9 条系列重建 `Path` 与标注文本，低端机上与 ViewPager2 滑动/页面滚动的叠加开销未测。
4. **按住面板**：9 条全开 + 画布最小高时末行被裁（S3-2 已按代码推算），需真机截图确认；换边 140ms 动画的实际手感未测。
5. **KiCut 编辑器几何**：插入/拆分态“整表总高恒等于常态”的 6dp 补偿、横线负 margin（首条 topMargin=-2dp、中间 bottomMargin=-4dp）在真机 LinearLayout 下的落点与触控命中未验证。
6. **KiCut 取数通路**：`tempctrl_coldmax` 在 SELinux 下的可读性、daemon 未部署时回落 190 导致 B7X 横轴偏窄——与 §10 既有未验证项一致。
7. **红线新鲜度**：daemon 停止后最后一行 `actual_cold` 的停留行为是否可接受，属产品口径，需确认。
8. **窗口档位持久化**：`windowSec` 不落盘，旋转/进程重建后回默认 360；是否应记忆需产品确认。
9. **无自动化测试**：`ChartAxis`/`ChartWindow`/`ChartView`/`ChartFragment`/`KiCutTableEditor` 无 JVM 或 instrumentation 用例；`KiCutTable` 的 golden 对拍只编译 C。
10. **外部越界配置**：S1-1 与 S3-13 的触发值（极大 coldMax、超 32 点/簇）未做防御性测试，也未验证修复后的内存上界。
