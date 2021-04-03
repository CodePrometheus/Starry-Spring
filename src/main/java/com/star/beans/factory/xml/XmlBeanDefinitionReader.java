package com.star.beans.factory.xml;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.star.beans.BeansException;
import com.star.beans.PropertyValue;
import com.star.beans.factory.config.BeanDefinition;
import com.star.beans.factory.config.BeanReference;
import com.star.beans.factory.support.AbstractBeanDefinitionReader;
import com.star.beans.factory.support.BeanDefinitionRegistry;
import com.star.core.io.Resource;
import com.star.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

/**
 * 读取配置在xml文件中的bean定义信息
 *
 * @Author: zzStar
 * @Date: 03-27-2021 18:57
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {

    public static final String BEAN_ELEMENT = "bean";
    public static final String PROPERTY_ELEMENT = "property";
    public static final String ID_ATTRIBUTE = "id";
    public static final String NAME_ATTRIBUTE = "name";
    public static final String CLASS_ATTRIBUTE = "class";
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String REF_ATTRIBUTE = "ref";
    public static final String INIT_METHOD_ATTRIBUTE = "init-method";
    public static final String DESTROY_METHOD_ATTRIBUTE = "destroy-method";


    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException {
        try {
            InputStream is = resource.getInputStream();

            try {
                doLoadBeanDefinitions(is);
            } finally {
                is.close();
            }
        } catch (IOException e) {
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    /**
     * 根据location加载资源resource
     *
     * @param location
     * @throws BeansException
     */
    @Override
    public void loadBeanDefinitions(String location) throws BeansException {
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    /**
     * 核心方法，根据xml加载bean
     *
     * @param inputStream
     */
    protected void doLoadBeanDefinitions(InputStream inputStream) {
        Document document = XmlUtil.readXML(inputStream);
        Element documentElement = document.getDocumentElement();
        NodeList childNodes = documentElement.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i) instanceof Element) {
                if (BEAN_ELEMENT.equals(childNodes.item(i).getNodeName())) {
                    // 开始解析Bean标签<bean/>
                    Element bean = (Element) childNodes.item(i);
                    // 拿到id
                    String id = bean.getAttribute(ID_ATTRIBUTE);
                    // 拿到class
                    String className = bean.getAttribute(CLASS_ATTRIBUTE);
                    // 拿到name
                    String name = bean.getAttribute(NAME_ATTRIBUTE);

                    String initMethodName = bean.getAttribute(INIT_METHOD_ATTRIBUTE);
                    String destroyMethodName = bean.getAttribute(DESTROY_METHOD_ATTRIBUTE);

                    // 反射拿到Class类信息
                    Class<?> clazz;

                    try {
                        clazz = Class.forName(className);
                    } catch (ClassNotFoundException e) {
                        throw new BeansException("Cannot find class [" + className + "]");
                    }

                    // id优先于name
                    String beanName = StrUtil.isNotEmpty(id) ? id : name;

                    if (StrUtil.isEmpty(beanName)) {
                        // Spring默认类的首字母小写为bean名称
                        beanName = StrUtil.lowerFirst(clazz.getSimpleName());
                    }

                    BeanDefinition definition = new BeanDefinition(clazz);
                    definition.setInitMethodName(initMethodName);
                    definition.setDestroyMethodName(destroyMethodName);

                    // 开始解析<bean></bean>里面的property属性
                    for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                        if (bean.getChildNodes().item(j) instanceof Element) {
                            if (PROPERTY_ELEMENT.equals(bean.getChildNodes().item(j).getNodeName())) {
                                // 解析property标签
                                Element property = (Element) bean.getChildNodes().item(j);
                                String nameAttr = property.getAttribute(NAME_ATTRIBUTE);
                                String valueAttr = property.getAttribute(VALUE_ATTRIBUTE);
                                String refAttr = property.getAttribute(REF_ATTRIBUTE);

                                if (StrUtil.isEmpty(nameAttr)) {
                                    throw new BeansException("The name attribute cannot be null or empty");
                                }

                                Object value = valueAttr;
                                // 处理Bean引用
                                if (StrUtil.isNotEmpty(refAttr)) {
                                    value = new BeanReference(refAttr);
                                }
                                PropertyValue propertyValue = new PropertyValue(nameAttr, value);
                                definition.getPropertyValues().addPropertyValue(propertyValue);
                            }
                        }
                    }
                    if (getRegistry().containsBeanDefinition(beanName)) {
                        // beanName不能重名
                        throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
                    }
                    // 完成注册Bean
                    getRegistry().registerBeanDefinition(beanName, definition);
                }
            }
        }
    }

}
