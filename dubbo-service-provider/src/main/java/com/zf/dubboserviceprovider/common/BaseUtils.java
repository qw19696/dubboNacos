package com.zf.dubboserviceprovider.common;

import cn.hutool.core.collection.CollectionUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by zf on 2022/4/27.
 * 基础的工具类
 */
public class BaseUtils {

    /**
     * 获取值列表
     * @param parents
     * @param pickFunc
     * @param <T>
     * @param <R>
     * @return
     */
    public static <T, R> List<R> pickList(List<T> parents, Function<T, R> pickFunc) {
        return parents.stream().map(pickFunc::apply).collect(Collectors.toList());
    }

    public static void doNotNullVoid(Object param, VoidFunction func) {
        if (validParam(param)) {
            func.execute();
        }
    }

    public static <T> void doNotNull(T param, Consumer<T> func) {
        if (validParam(param)) {
            func.accept(param);
        }
    }

    private static boolean validParam(Object param) {
        return !(param == null || (param instanceof String && StringUtils.isBlank((String) param))
                || (param instanceof Collection && CollectionUtil.isEmpty((Collection) param)));
    }

    /**
     * 组装树结构
     * @param subKeyFunc 与子对象关联值获取方法，比如xx.getId
     * @param ttlList 对象列表
     * @param topFunc 顶级对象的判断方法 如xx.istop()
     * @param parentKeyFunc 元素父id，如xx.getParentId
     * @param setChildFunc 识别出子元素后进行的操作，如xx.setChildren(list)
     * @param <T> 元素值
     * @param <K> 关联的key
     * @return
     */
    public static <T, K> List<T> buildTreeList(Function<T, K> subKeyFunc, List<T> ttlList,
                                               Function<T, Boolean> topFunc, Function<T, K> parentKeyFunc, BiConsumer<T, List<T>> setChildFunc) {
        if (CollectionUtil.isEmpty(ttlList)) {
            return new ArrayList<T>();
        }
        List<T> topList = ttlList.stream().filter(topFunc::apply).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(topList)) {
            return new ArrayList<T>();
        }
        ttlList.removeAll(topList);

        Map<K, List<T>> children = ttlList.stream().collect(Collectors.groupingBy(parentKeyFunc));

        topList.forEach(item -> fillChildren(subKeyFunc, item, children, setChildFunc));
        return topList;
    }

    /**
     * 两级树组装结构
     * @param subKeyFunc 与子对象关联值获取方法，比如xx.getId
     * @param topList 顶级列表
     * @param ttlList 子对象列表
     * @param parentKeyFunc 元素父id，如xx.getParentId
     * @param setChildFunc 识别出子元素后进行的操作，如xx.setChildren(list)
     * @param <T> 元素值
     * @param <K> 关联的key
     * @return
     */
    public static <T, K> List<T> buildTreeList(Function<T, K> subKeyFunc, List<T> topList, List<T> ttlList,
                                               Function<T, K> parentKeyFunc, BiConsumer<T, List<T>> setChildFunc) {
        if (CollectionUtil.isEmpty(topList) || CollectionUtil.isEmpty(ttlList)) {
            return new ArrayList<T>();
        }

        Map<K, List<T>> children = ttlList.stream().collect(Collectors.groupingBy(parentKeyFunc));
        topList.forEach(item -> setChildFunc.accept(item, children.get(subKeyFunc.apply(item))));

        return topList;
    }


    private static <T, K> void fillChildren(Function<T, K> subKeyFunc, T parent, Map<K, List<T>> children, BiConsumer<T, List<T>> setChildFunc) {
        List<T> subList = children.get(subKeyFunc.apply(parent));
        if (CollectionUtil.isEmpty(subList)) {
            return;
        }
        setChildFunc.accept(parent, subList);
        subList.forEach(sub -> fillChildren(subKeyFunc, sub, children, setChildFunc));
    }


    public static void main(String[] args) {
        doNotNull("string", System.out::println);
    }
}
