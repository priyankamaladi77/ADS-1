/**
 * Class for team.
 */
class Team implements Comparable<Team> {
    /**
     * { variable teamname description }.
     */
    private String teamname;
    /**
     * { variable wins description }.
     */
    private int wins;
    /**
     * { variable losses description }.
     */
    private int losses;
    /**
     * { variable draws description }.
     */
    private int draws;
   /**
    * Constructs the object. for team
    *
    * @param      name  The name
    * @param      win   The window
    * @param      lose  The lose
    * @param      draw  The draw
    */
    Team(final String name, final int win,
        final int lose, final int draw) {
        this.teamname = name;
        this.wins = win;
        this.losses = lose;
        this.draws = draw;
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.teamname;
    }
    /**
     * Gets the wins.
     *
     * @return     The wins.
     */
    public int getWins() {
        return this.wins;
    }
    /**
     * Gets the losses.
     *
     * @return     The losses.
     */
    public int getLosses() {
        return this.losses;
    }
    /**
     * Gets the draws.
     *
     * @return     The draws.
     */
    public int getDraws() {
        return this.draws;
    }
    /**
     * Sets the name.
     *
     * @param      nam   The nam
     */
    public void setName(final String nam) {
        this.teamname = nam;
    }
    /**
     * Sets the wins.
     *
     * @param      won   The won
     */
    public void setWins(final int won) {
        this.wins = won;
    }
    /**
     * Sets the losses.
     *
     * @param      loss  The loss
     */
    public void setLosses(final int loss) {
        this.losses = loss;
    }
    /**
     * Sets the draws.
     *
     * @param      draw  The draw
     */
    public void setDraws(final int draw) {
        this.draws = draw;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.teamname;
    }
    /**
     * { compares to objects according to given condition }.
     *
     * @param      that  object
     *
     * @return     { returns -1 if condition satisfies else 1 }
     */
    public int compareTo(final Team that) {
        if (this.wins > that.wins) {
            return -1;
        }
        if (this.wins < that.wins) {
            return +1;
        }
        if (this.losses < that.losses) {
            return -1;
        }
        if (this.losses > that.losses) {
            return +1;
        }
        if (this.draws > that.draws) {
            return -1;
        }
        if (this.draws < that.draws) {
            return +1;
        }
        return 0;
    }
}
