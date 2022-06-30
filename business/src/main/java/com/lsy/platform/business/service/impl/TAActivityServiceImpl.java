package com.lsy.platform.business.service.impl;

import com.lsy.platform.business.model.TAActivity;
import com.lsy.platform.business.mapper.TAActivityMapper;
import com.lsy.platform.business.service.ITAActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsy.platform.springconfig.config.aop.SysMonitor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;

/**
 * <p>
 * 活动基本信息表 服务实现类
 * </p>
 *
 * @author lsy
 * @since 2022-03-14
 */
@Service("tAActivityServiceImpl")
@Scope(value = "prototype")
public class TAActivityServiceImpl extends ServiceImpl<TAActivityMapper, TAActivity> implements ITAActivityService {

    @Override
    @SysMonitor //Aop注解
    public TAActivity getActivityInfo(int id) {
        return getById(id);
    }

    /**
     * TransactionDefinition.PROPAGATION_REQUIRED：如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。这是默认值。
     * TransactionDefinition.PROPAGATION_REQUIRES_NEW：创建一个新的事务，如果当前存在事务，则把当前事务挂起。
     * TransactionDefinition.PROPAGATION_SUPPORTS：如果当前存在事务，则加入该事务；如果当前没有事务，则以非事务的方式继续运行。
     * TransactionDefinition.PROPAGATION_NOT_SUPPORTED：以非事务方式运行，如果当前存在事务，则把当前事务挂起。
     * TransactionDefinition.PROPAGATION_NEVER：以非事务方式运行，如果当前存在事务，则抛出异常。
     * TransactionDefinition.PROPAGATION_MANDATORY：如果当前存在事务，则加入该事务；如果当前没有事务，则抛出异常。
     * TransactionDefinition.PROPAGATION_NESTED：如果当前存在事务，则创建一个事务作为当前事务的嵌套事务来运行；如果当前没有事务，则该取值等价于TransactionDefinition.PROPAGATION_REQUIRED。
     *
     * @param taActivity
     * @return
     */
    @Override
    //                              发生异常时                           隔离级别                不过时
    @Transactional(propagation = Propagation.REQUIRED, timeout = -1)
    public boolean transUpdateActivityInfo() {
        try {
            TAActivity byId = getById(1);
            byId.setActivityId(1);
            byId.setUTime((int) (System.currentTimeMillis() / 1000));
            byId.setActivityTitle(Thread.currentThread().getName());
            byId.setActivitySubtitle("subTitle");
            if (!updateById(byId)) {
                return false;
            }

            //批量提交
            LinkedList<TAActivity> saveList = new LinkedList<>();
            for (int i = 0; i < 100; i++) {
                TAActivity taActivity = new TAActivity();
                taActivity.setActivityId(i);
                saveList.add(taActivity);
            }
//            if (saveBatch(saveList)) {
//                return false;
//            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
