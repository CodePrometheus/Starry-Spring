package com.star.context.support;

import com.star.beans.BeansException;
import com.star.beans.factory.ConfigurableListableBeanFactory;
import com.star.beans.factory.config.BeanFactoryPostProcessor;
import com.star.beans.factory.config.BeanPostProcessor;
import com.star.context.ConfigurableApplicationContext;
import com.star.core.io.DefaultResourceLoader;
import com.star.util.Nullable;

import java.util.Map;

/**
 * AbstractApplicationContext是spring应用继承体系的核心。这个类实现了应用的一般流程，
 * 一方面，它实现了ApplicationContext接口本身的内容，诸如id,displayName之类的描述性信息，
 * 另一方面，它通过或者代理或者继承的方式实现了父接口的内容。
 *
 * @Author: zzStar
 * @Date: 04-02-2021 20:48
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {

    /**
     * 用于"刷新" 和 "销毁" 时的同步监视器（浅显是说就是当做锁）
     */
    private final Object startupShutdownMonitor = new Object();

    /**
     * 如果已注册，则引用JVM关闭链接
     */
    @Nullable
    private Thread shutdownHook;

    /**
     * 重点方法
     *
     * @throws BeansException
     */
    @Override
    public void refresh() throws BeansException {

        synchronized (this.startupShutdownMonitor) {
            // 创建BeanFactory，并加载BeanDefinition
            refreshBeanFactory();
            ConfigurableListableBeanFactory beanFactory = getBeanFactory();

            // 实例化Bean之前，执行BeanFactoryPostProcessor 调用各种beanFactory处理器
            invokeBeanFactoryPostProcessors(beanFactory);

            // BeanPostProcessor需要提前与其他bean实例化之前注册 这里只是注册功能，真正调用的是getBean方法
            registerBeanPostProcessors(beanFactory);

            // 提前实例化单例Bean
            beanFactory.preInstantiateSingletons();
        }
    }

    /**
     * 注册BeanPostProcessor
     *
     * @param beanFactory
     */
    protected void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);

        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }

    }

    /**
     * 在bean实例化之前，执行BeanFactoryPostProcessor
     *
     * @param beanFactory
     */
    protected void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);

        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }

    }


    /**
     * 刷新内部的beanFactory
     * 创建BeanFactory，并加载BeanDefinition
     *
     * @throws BeansException
     */
    protected abstract void refreshBeanFactory() throws BeansException;


    /**
     * getBeanFactory
     *
     * @return
     */
    public abstract ConfigurableListableBeanFactory getBeanFactory();

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return getBeanFactory().getBean(name, requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return getBeanFactory().getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return getBeanFactory().getBeanDefinitionNames();
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return getBeanFactory().getBean(name);
    }

    /**
     * 关闭此应用程序上下文，销毁其bean工厂中的所有bean。
     * 实际关闭过程是委派 doClose()方法。
     * 同时，如果已在JVM注册了关闭链接，也删除其关闭链接，因为它不再需要了。
     *
     * @see #doClose()
     */
    @Override
    public void close() {
        synchronized (this.startupShutdownMonitor) {
            doClose();
            //  如果已在JVM注册了关闭链接，现在我们不再需要它了：我们已经明确地关闭了上下文
            if (this.shutdownHook != null) {
                try {
                    Runtime.getRuntime().removeShutdownHook(this.shutdownHook);
                } catch (IllegalStateException ex) {
                    // 忽略已经关闭的VM
                }
            }
        }
    }

    /**
     * 向JVM运行时注册一个关闭链接，在JVM关闭时关闭这个上下文，除非此时它已经关闭。
     * 委托给 doClose() 方法去关闭，用于实际的关闭过程。
     */
    @Override
    public void registerShutdownHook() {

        if (this.shutdownHook == null) {
            // 尚未注册关机链接
            this.shutdownHook = new Thread(() -> {
                synchronized (startupShutdownMonitor) {
                    doClose();
                }
            });
            Runtime.getRuntime().addShutdownHook(this.shutdownHook);
        }
    }

    /**
     * 实际上执行上下文关闭:
     * 发布ContextClosedEvent山下文关闭事件，并销毁此应用程序上下文的bean工厂中的单例对象。
     * 如果有的话，则调用 close() 方法和一个JVM关闭链接。
     *
     * @see #destroyBeans()
     */
    protected void doClose() {
        destroyBeans();
    }

    /**
     * 模板方法，用于销毁该上下文管理的所有bean。
     * 调用 DisposableBean.destroy() 或 指定的“destroy-method”销毁方法
     * 默认销毁将此实现的上下文中所有缓存的单例对象
     * 可以重写，以在标准单例销毁之前或之后添加上下文特定的bean销毁步骤
     * 同时上下文的BeanFactory仍然处于活动状态
     *
     * @see #getBeanFactory()
     * @see com.star.beans.factory.config.ConfigurableBeanFactory#destroySingletons()
     */
    protected void destroyBeans() {
        getBeanFactory().destroySingletons();
    }


}
