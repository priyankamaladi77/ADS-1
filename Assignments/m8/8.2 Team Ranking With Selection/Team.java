/**
 * Class for team.
 */
class Team implements Comparable<Team> {
    private String teamname;
    private int wins;
    private int losses;
    private int draws;

    Team(String name, int win, int lose, int draw) {
        this.teamname = name;
        this.wins = win;
        this.losses = lose;
        this.draws = draw;
    }
    public String getName() {
        return this.teamname;
    }
    public int getWins() {
        return this.wins;
    }
    public int getLosses() {
        return this.losses;
    }
    public int getDraws() {
        return this.draws;
    }
    public void setName(String nam) {
        this.teamname = nam;
    }
    public void setWins(int won) {
        this.wins = won;
    }
    public void setLosses(int loss) {
        this.losses = loss;
    }
    public void setDraws(int draw) {
        this.draws = draw;
    }
    public String toString() {
        return this.teamname;
    }
    public int compareTo(Team that) {
        if (this.wins > that.wins) return -1;
        if (this.wins < that.wins) return +1;
        if (this.losses < that.losses) return -1;
        if (this.losses > that.losses) return +1;
        if (this.draws > that.draws) return -1;
        if (this.draws < that.draws) return +1;
        return 0;
    }
}
