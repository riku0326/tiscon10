package com.tiscon10.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * 入力値が指定した形式の日付文字列であるかをバリデーションするクラス。
 * <p/>
 * 日付フォーマットのデフォルト値は「yyyy/MM/dd」である。
 *
 * @author TIS Taro
 */
@Documented
@Constraint(validatedBy = YYYYMMDDValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface YYYYMMDD {

    /**
     * グループを取得する。
     *
     * @return グループ
     */
    Class<?>[] groups() default {};

    /**
     * バリデーションエラー発生時に設定するメッセージ。
     *
     * @return メッセージ
     */
    String message() default "{tiscon.YYYYMMDD.message}";

    /**
     * Payloadを取得する。
     *
     * @return Payload
     */
    Class<? extends Payload>[] payload() default {};

    /**
     * 許容するフォーマット
     *
     * @return 指定されたフォーマット
     */
    String allowFormat() default "yyyy/MM/dd";

    /** 複数指定用のアノテーション */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        /**
         * YYYYMMDDの配列を取得する。
         *
         * @return 指定されたYYYYMMDDの配列
         */
        YYYYMMDD[] value();
    }
}
