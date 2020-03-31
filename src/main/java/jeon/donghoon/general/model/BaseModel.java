package jeon.donghoon.general.model;

import org.springframework.format.annotation.NumberFormat;

/**
 * 이 모듈에서 사용되는 기본 모델 클래스입니다.
 * 기본 모듈 클래스는 {@link Identifiable}을 구현하여 고유 식별키를 사용합니다. <p>
 *
 * 기본 모델 클래스는 식별키를 이용하여 {@link #hashCode()}와 {@link #equals(Object)}를 구현합니다. <p>
 * 동일한 식별키를 가진 객체는 객체의 데이터가 다르더라도 동일한 객체로 인식합니다.
 */
public abstract class BaseModel implements Identifiable<Integer> {
    protected Integer id;

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public boolean isInitialized() {
        return (this.id != null);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        if (this.isInitialized()) {
            hashCode = prime * hashCode + this.id.hashCode();
        }
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        BaseModel that;

        // BaseModel 인지 확인합니다.
        if (obj instanceof BaseModel) {
            that = (BaseModel) obj;
        } else {
            return false; // 다른 타입이면 false 를 반환합니다.
        }

        // 해시코드가 같고 식별키가 모두 초기화된 상태로 같은 값을 가지면 true 를 반환합니다.
        if (this.hashCode() == that.hashCode()) {
            if (this.isInitialized() && that.isInitialized()) {
                return this.id.equals(that.id);
            }
        }

        return false;
    }
}
