package baseball.infrastructure;

import baseball.domain.BallStatus;

import java.util.Map;

/**
 * Result 를 입력받아 결과를 report 합니다.
 */
public class Reporter {
    private Reporter() {
    }

    public static String report(Map<BallStatus, Integer> gameResult) {
        StringBuilder sb = new StringBuilder();

        gameResult.forEach((status, value) -> {
            sb.append(value);
            sb.append(" ");
            sb.append(status.comment());
            sb.append(" ");
        });

        return sb.toString().trim();
    }
}
