package beans;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class otputil {
    public static boolean isOTPExpired(LocalDateTime otpGenerationTime) {
        LocalDateTime currentTime = LocalDateTime.now();
        // Check if more than 10 minutes have passed since OTP generation
        return ChronoUnit.MINUTES.between(otpGenerationTime, currentTime) > 1;
    }
}

