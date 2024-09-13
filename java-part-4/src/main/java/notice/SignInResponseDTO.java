package notice;

public class SignInResponseDTO {

    private boolean status;
    private String userId;
    private String name;

    public SignInResponseDTO(boolean status, String userId, String name) {
        this.status = status;
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public boolean isStatus() {
        return status;
    }
}
