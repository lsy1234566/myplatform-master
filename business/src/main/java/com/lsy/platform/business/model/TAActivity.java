package com.lsy.platform.business.model;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 活动基本信息表
 * </p>
 *
 * @author lsy
 * @since 2022-03-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TAActivity extends Model<TAActivity> {

    private static final long serialVersionUID = 1L;

    /**
     * 活动编号，自增编号
     */
    @TableId(value = "activity_id", type = IdType.AUTO)
    private Integer activityId;

    /**
     * 活动父级编号，关联t_a_activity.activity_id
     */
    private Integer parentId;

    /**
     * 活动模板编号，关联t_a_activity_template.activity_template_id
     */
    private Integer activityTemplateId;

    /**
     * 页面模板编号，管理t_s_template.template_id
     */
    private Integer templateId;

    /**
     * 模板皮肤编号，管理t_s_template_theme.template_theme_id
     */
    private Integer templateThemeId;

    /**
     * 活动类型：1大转盘，2刮刮卡，3红包雨，4九宫格，5扭蛋机，6老虎机，7摇一摇，8摇骰子，9转不停，10砸金蛋，11代金券，12满立减，13随机减，14扫码领券，15开放发券，16附近发券，17支付有礼，18首绑有礼，19API立减金，20自定义活动，21全场立减，22集字，23答题闯关，24照片集赞，25网点派券
     */
    private Integer activityType;

    /**
     * 活动副标题
     */
    private String activitySubtitle;

    /**
     * 活动标题
     */
    private String activityTitle;

    /**
     * 活动说明
     */
    private String activityRemark;

    /**
     * 活动开始时间
     */
    private Integer startTime;

    /**
     * 活动结束时间
     */
    private Integer endTime;

    /**
     * 是否注册，完善会员信息：1启用，2禁用
     */
    private Integer registerEnable;

    /**
     * 注册规则：1玩游戏前注册，2玩游戏后注册；
     */
    private Integer registerRule;

    /**
     * 参与会员限制：0不限制1黑名单 2白名单3黑白名单
     */
    private Integer fansLimit;

    /**
     * 库存是否可分配：1是，2否
     */
    private Integer distributeEnable;

    /**
     * 是否显示在小程序活动列表：1显示，2隐藏
     */
    private Integer showInXcx;

    /**
     * 是否显示在app：1显示，2隐藏
     */
    private Integer showInApp;

    /**
     * 是否显示在广告机：1显示，2隐藏
     */
    private Integer showInAdvert;

    /**
     * 使用场景：1普通，2绿卡权益
     */
    private Integer useScene;

    /**
     * 活动状态：0活动缓存，1活动暂存，2提交审核，3活动未开始，4活动进行中，5活动已结束，6活动已暂停 ,7活动已终止
     */
    private Integer activityState;

    /**
     * 活动地址
     */
    private String activityAddr;

    /**
     * 活动图片
     */
    private String activityPic;

    /**
     * 活动标题图片
     */
    private String titlePic;

    /**
     * 活动总预算
     */
    private BigDecimal maxAmount;

    /**
     * 主办单位
     */
    private String sponsor;

    /**
     * 客服电话
     */
    private String phone;

    /**
     * 审核状态：1未提交，2审核中，3审核通过，4审核驳回
     */
    private Integer examineState;

    /**
     * 审核结果说明
     */
    private String examineRemark;

    /**
     * 审核时间
     */
    private Integer examineTime;

    /**
     * 用于生成二维码的访问地址
     */
    private String qrcodeUrl;

    /**
     * 奖励金发放方式：1表示无奖励金 2实时发放，3活动结束后发放,
     */
    private Integer rewardGrantMode;

    /**
     * 奖励金条件 ，关联t_s_reward_condition.reward_condition_id
     */
    private Integer rewardConditionId;

    /**
     * 条件标志编码，1参与奖励  2中奖确认奖励 3中奖领取奖励 4中奖核销奖励
     */
    private Integer rewardConditionCode;

    /**
     * 是否重复奖励，即叠加奖励：1叠加，2不叠加，实时发放默认叠加奖励
     */
    private Integer rewardRepeat;

    /**
     * 积分奖励规则，具体结构参见：小幺鸡，http://10.100.2.244:8080/doc/XvpDbCR6N
     */
    private String awardIntegralRule;

    /**
     * 奖品概率计算方式：1动态概率，2固定概率，3按排名发放奖品
     */
    private Integer prizeProbabilityMode;

    /**
     * 活动中奖率，取值区间(0,100)
     */
    private BigDecimal maxPrizeProbability;

    /**
     * 核销单位：1机构，2商户
     */
    private Integer cancelUnit;

    /**
     * 活动归属者类型：1机构，2客户经理，3商户
     */
    private Integer ownerType;

    /**
     * 活动归属者编号，与owner_type对应的对象编号
     */
    private Integer ownerId;

    /**
     * 活动归属者的一级机构编号，关联t_g_proxy.proxy_id_1
     */
    @TableField("owner_proxy_id_1")
    private Integer ownerProxyId1;

    /**
     * 活动归属者的二级机构编号，关联t_g_proxy.proxy_id_2
     */
    @TableField("owner_proxy_id_2")
    private Integer ownerProxyId2;

    /**
     * 活动归属者的三级机构编号，关联t_g_proxy.proxy_id_3
     */
    @TableField("owner_proxy_id_3")
    private Integer ownerProxyId3;

    /**
     * 活动归属者的四级机构编号，关联t_g_proxy.proxy_id_4
     */
    @TableField("owner_proxy_id_4")
    private Integer ownerProxyId4;

    /**
     * 归属平台编号，关联t_s_platform.platform_id
     */
    private Integer platformId;

    /**
     * 归属平台类型，关联t_s_platform.platform_type
     */
    private Integer platformType;

    /**
     * 平台归属机构ID，关联t_s_platform.proxy_id
     */
    private Integer platformProxyId;

    /**
     * 创建时间
     */
    private Integer cTime;

    /**
     * 更新时间
     */
    private Integer uTime;


    @Override
    protected Serializable pkVal() {
        return this.activityId;
    }

    @Override
    public String toString() {
        return "TAActivity{" +
                "activityId=" + activityId +
                ", parentId=" + parentId +
                ", activityTemplateId=" + activityTemplateId +
                ", templateId=" + templateId +
                ", templateThemeId=" + templateThemeId +
                ", activityType=" + activityType +
                ", activitySubtitle='" + activitySubtitle + '\'' +
                ", activityTitle='" + activityTitle + '\'' +
                ", activityRemark='" + activityRemark + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", registerEnable=" + registerEnable +
                ", registerRule=" + registerRule +
                ", fansLimit=" + fansLimit +
                ", distributeEnable=" + distributeEnable +
                ", showInXcx=" + showInXcx +
                ", showInApp=" + showInApp +
                ", showInAdvert=" + showInAdvert +
                ", useScene=" + useScene +
                ", activityState=" + activityState +
                ", activityAddr='" + activityAddr + '\'' +
                ", activityPic='" + activityPic + '\'' +
                ", titlePic='" + titlePic + '\'' +
                ", maxAmount=" + maxAmount +
                ", sponsor='" + sponsor + '\'' +
                ", phone='" + phone + '\'' +
                ", examineState=" + examineState +
                ", examineRemark='" + examineRemark + '\'' +
                ", examineTime=" + examineTime +
                ", qrcodeUrl='" + qrcodeUrl + '\'' +
                ", rewardGrantMode=" + rewardGrantMode +
                ", rewardConditionId=" + rewardConditionId +
                ", rewardConditionCode=" + rewardConditionCode +
                ", rewardRepeat=" + rewardRepeat +
                ", awardIntegralRule='" + awardIntegralRule + '\'' +
                ", prizeProbabilityMode=" + prizeProbabilityMode +
                ", maxPrizeProbability=" + maxPrizeProbability +
                ", cancelUnit=" + cancelUnit +
                ", ownerType=" + ownerType +
                ", ownerId=" + ownerId +
                ", ownerProxyId1=" + ownerProxyId1 +
                ", ownerProxyId2=" + ownerProxyId2 +
                ", ownerProxyId3=" + ownerProxyId3 +
                ", ownerProxyId4=" + ownerProxyId4 +
                ", platformId=" + platformId +
                ", platformType=" + platformType +
                ", platformProxyId=" + platformProxyId +
                ", cTime=" + cTime +
                ", uTime=" + uTime +
                '}';
    }
}
