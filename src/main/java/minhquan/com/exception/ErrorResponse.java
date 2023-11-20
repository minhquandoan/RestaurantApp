package minhquan.com.exception;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter @Setter
@ToString
public class ErrorResponse {
    private int code;
    private String description;
    private LocalDateTime time;

    public ErrorResponse(int code, String description, LocalDateTime time) {
        this.code = code;
        this.description = description;
        this.time = time;
    }

    public static ErrorResponseBuilder builder() {return new ErrorResponseBuilder();}

    public static class ErrorResponseBuilder {
        private int code;
        private String description;
        private LocalDateTime time;

        public ErrorResponseBuilder(){}

        public ErrorResponseBuilder code(int code) {
            this.code = code;
            return this;
        }

        public ErrorResponseBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ErrorResponseBuilder time(LocalDateTime time) {
            this.time = time;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this.code, this.description, this.time);
        }

        public String toString() {
            return "ErrorResponse.ErrorResponseBuilder(errorCode=" + this.code + "description=" + this.description + ", errorTime=" + String.valueOf(this.time) + ")";
        }
    }
}
