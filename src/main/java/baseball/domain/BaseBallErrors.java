package baseball.domain;

import static baseball.domain.BusinessConstant.*;

public enum BaseBallErrors {
    NOT_NUMBER_CASTING("지원하지 않는 숫자 형태입니다. " + MIN_BALL_VALUE + " 부터 " + MAX_BALL_VALUE + "까지 숫자를 입력해주세요."),
    OUT_OF_BOUNDARY_VALUE(MIN_BALL_VALUE + " 부터 " + MAX_BALL_VALUE + "까지 숫자를 입력해주세요."),
    OUT_OF_BOUNDARY_POSITION(MIN_BALL_POSITION + " 부터 " + MAX_BALL_POSITION + "에 위치할 수 있습니다."),
    INVALID_LENGTH_BALLS(MIN_BALL_POSITION + "자리의 숫자를 입력 해 주세요"),
    DUPLICATE_NUMBER("중복된 숫자가 있습니다. 중복없이 " + MIN_BALL_POSITION + "자리 숫자를 입력 해 주세요.");
    private String exceptionMessage;

    BaseBallErrors(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }
}
