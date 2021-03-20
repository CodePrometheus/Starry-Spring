package com.star.util;

import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierNickname;
import javax.annotation.meta.When;
import java.lang.annotation.*;

/**
 * 可以标注在方法、字段、参数之上，表示对应的值可以为空
 *
 * @Author: zzStar
 * @Date: 03-20-2021 12:26
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Nonnull(when = When.MAYBE)
@TypeQualifierNickname
public @interface Nullable {

    /**
     *  @TypeQualifierNickname 用于注解其他注解，并把它标注的注解标记为限定符别称，把@TypeQualifierNickname 所注解的注解X 应用到元素Y 上时，相当于把 注解 X上的注解（除去@TypeQualifierNickname） 都应用到元素Y 上了,
     *  因此叫做注解X上除去 @TypeQualifierNickname 以外所有其他注解的别称，即类型限定符别称.
     *  也就是说，@Nullable有该TypeQualifierNickname的存在，当使用@Nullable时就和直接使用@Nonnull一样了，@Nullable只是一个别名
     */
}
