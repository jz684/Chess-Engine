import javax.swing.*;

public class Account {
    private String username;
    protected String password;
    private int elo;
    private ImageIcon profilePhoto;
    private String email;

    static ImageIcon DEFAULT_PROFILE = new ImageIcon("src/images/DefaultProfile.png");
    static int DEFAULT_ELO = 1000;

    public Account(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.elo = DEFAULT_ELO;
        this.profilePhoto = DEFAULT_PROFILE;
    }

    public boolean authenticateAccount(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public int updateEloForWin(Account opponent) {
        int eloDifference = this.elo - opponent.getElo();
        if (eloDifference >= 30) { // The

        }
    }

    public int updateEloForLoss(Account )

    public int getElo() {
        return elo;
    }

    public String getUsername() {
        return username;
    }

    public ImageIcon getProfilePhoto() {
        return profilePhoto;
    }
}
