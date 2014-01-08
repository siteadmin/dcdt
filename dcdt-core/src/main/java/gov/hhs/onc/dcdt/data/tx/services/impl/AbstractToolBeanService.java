package gov.hhs.onc.dcdt.data.tx.services.impl;

import gov.hhs.onc.dcdt.beans.ToolBean;
import gov.hhs.onc.dcdt.data.ToolBeanDataAccessException;
import gov.hhs.onc.dcdt.data.dao.ToolBeanDao;
import gov.hhs.onc.dcdt.data.tx.services.ToolBeanService;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public abstract class AbstractToolBeanService<T extends ToolBean, U extends ToolBeanDao<T>> implements ToolBeanService<T, U> {
    protected AbstractRefreshableApplicationContext appContext;
    protected U beanDao;

    @Override
    @SuppressWarnings({ "unchecked" })
    public boolean containsBeans(Serializable ... beanIdValues) throws ToolBeanDataAccessException {
        return this.beanDao.containsBeans(beanIdValues);
    }

    @Override
    public boolean containsBeans(Iterable<? extends Serializable> beanIdValues) throws ToolBeanDataAccessException {
        return this.beanDao.containsBeans(beanIdValues);
    }

    @Override
    public boolean containsBean(Serializable beanIdValue) throws ToolBeanDataAccessException {
        return this.beanDao.containsBean(beanIdValue);
    }

    @Override
    public List<T> getBeansById(Serializable ... beanIdValues) throws ToolBeanDataAccessException {
        return this.beanDao.getBeansById(beanIdValues);
    }

    @Override
    public List<T> getBeansById(Iterable<? extends Serializable> beanIdValues) throws ToolBeanDataAccessException {
        return this.beanDao.getBeansById(beanIdValues);
    }

    @Override
    public T getBeanById(Serializable beanIdValue) throws ToolBeanDataAccessException {
        return this.beanDao.getBeanById(beanIdValue);
    }

    @Override
    @SuppressWarnings({ "unchecked" })
    public List<T> getBeans(Pair<String, ? extends Serializable> ... beanColumnPairs) throws ToolBeanDataAccessException {
        return this.beanDao.getBeans(beanColumnPairs);
    }

    @Override
    public List<T> getBeans(Iterable<Pair<String, ? extends Serializable>> beanColumnPairs) throws ToolBeanDataAccessException {
        return this.beanDao.getBeans(beanColumnPairs);
    }

    @Override
    @SuppressWarnings({ "unchecked" })
    public T getBean(Pair<String, ? extends Serializable> ... beanColumnPairs) throws ToolBeanDataAccessException {
        return this.beanDao.getBean(beanColumnPairs);
    }

    @Override
    public T getBean(Iterable<Pair<String, ? extends Serializable>> beanColumnPairs) throws ToolBeanDataAccessException {
        return this.beanDao.getBean(beanColumnPairs);
    }

    @SuppressWarnings({ "unchecked" })
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<T> setBeans(T ... beans) throws ToolBeanDataAccessException {
        return this.beanDao.setBeans(beans);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<T> setBeans(Iterable<T> beans) throws ToolBeanDataAccessException {
        return this.beanDao.setBeans(beans);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public T setBean(T bean) throws ToolBeanDataAccessException {
        return this.beanDao.setBean(bean);
    }

    @SuppressWarnings({ "unchecked" })
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<T> addBeans(T ... beans) throws ToolBeanDataAccessException {
        return this.beanDao.addBeans(beans);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<T> addBeans(Iterable<T> beans) throws ToolBeanDataAccessException {
        return this.beanDao.addBeans(beans);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public T addBean(T bean) throws ToolBeanDataAccessException {
        return this.beanDao.addBean(bean);
    }

    @SuppressWarnings({ "unchecked" })
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<T> updateBeans(T ... beans) throws ToolBeanDataAccessException {
        return this.beanDao.updateBeans(beans);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<T> updateBeans(Iterable<T> beans) throws ToolBeanDataAccessException {
        return this.beanDao.updateBeans(beans);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public T updateBean(T bean) throws ToolBeanDataAccessException {
        return this.beanDao.updateBean(bean);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<T> removeBeansById(Serializable ... beanIdValues) throws ToolBeanDataAccessException {
        return this.beanDao.removeBeansById(beanIdValues);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<T> removeBeansById(Iterable<? extends Serializable> beanIdValues) throws ToolBeanDataAccessException {
        return this.beanDao.removeBeansById(beanIdValues);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public T removeBeanById(Serializable beanIdValue) throws ToolBeanDataAccessException {
        return this.beanDao.removeBeanById(beanIdValue);
    }

    @SuppressWarnings({ "unchecked" })
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<T> removeBeans(T ... beans) throws ToolBeanDataAccessException {
        return this.beanDao.removeBeans(beans);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public List<T> removeBeans(Iterable<T> beans) throws ToolBeanDataAccessException {
        return this.beanDao.removeBeans(beans);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public T removeBean(T bean) throws ToolBeanDataAccessException {
        return this.beanDao.removeBean(bean);
    }

    @Override
    public void setApplicationContext(ApplicationContext appContext) throws BeansException {
        this.appContext = (AbstractRefreshableApplicationContext) appContext;
    }

    protected void setBeanDao(U beanDao) {
        this.beanDao = beanDao;
    }
}
