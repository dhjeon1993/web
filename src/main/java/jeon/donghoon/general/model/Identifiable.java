package jeon.donghoon.general.model;

import java.io.Serializable;

/**
 * 이 인터페이스를 구현한 클래스의 객체는 식별키로 고유한 객체를 식별할 수 있습니다.
 * 동일한 도메인의 객체는 식별키가 반드시 유일해야 하며 식별키가 같은 경우 동일한 객체로 인식합니다. <p></p>
 *
 * 식별키가 null 인 경우 동일한 객체는 존재할 수 없습니다.
 * @param <T> 아이디로 사용할 타입
 * @author Donghoon Jeon
 */
public interface Identifiable<T> extends Serializable {
    /**
     * 메소드를 호출하여 식별키 값을 얻을 수 있습니다. <p></p>
     *
     * @return 식별키 값을 반환합니다. 식별키가 초기화 되지 않았으면 null 을 반환합니다.
     */
    T getId();

    /**
     * 현재 식별키 값을 확인하여 식별키 값이 null 이면 해당 객체는 초기화 되지 않았다고 판단합니다.
     * null 이 아니라면 해당 객체는 초기화된 객체로 판단합니다.
     *
     * @return 식별키가 null 인 경우 false 를 반환합니다. null 이 아니면 true 를 반환합니다.
     */
    boolean isInitialized();
}
