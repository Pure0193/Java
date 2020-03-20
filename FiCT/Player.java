
public class Player {

	public enum PlayerType {Healer, Tank, Samurai, BlackMage, Phoenix, Cherry};

	private PlayerType type; 	//Type of this player. Can be one of either Healer, Tank, Samurai, BlackMage, or Phoenix
	private double maxHP;		//Max HP of this player
	private double currentHP;	//Current HP of this player 
	private double atk;			//Attack power of this player

	private int numSpecialTurns,position,inTurn;
	private boolean sleeping,cursed,taunting;
	private String row,team;
	private Player cursetarget=null;

	/**
	 * Constructor of class Player, which initializes this player's type, maxHP, atk, numSpecialTurns, 
	 * as specified in the given table. It also reset the internal turn count of this player. 
	 * @param _type
	 */
	public Player(PlayerType _type)
	{	
		//INSERT YOUR CODE HERE
		type = _type;
		switch(type) {
		case Healer:
			maxHP=4790;
			currentHP=maxHP;
			atk=238;
			numSpecialTurns=4;
			break;
		case Tank:
			maxHP=5340;
			currentHP=maxHP;
			atk=255;
			numSpecialTurns=4;
			break;
		case Samurai:
			maxHP=4005;
			currentHP=maxHP;
			atk=368;
			numSpecialTurns=3;
			break;
		case BlackMage:
			maxHP=4175;
			currentHP=maxHP;
			atk=303;
			numSpecialTurns=4;
			break;
		case Phoenix:
			maxHP=4175;
			currentHP=maxHP;
			atk=209;
			numSpecialTurns=8;
			break;
		case Cherry:
			maxHP=3560;
			currentHP=maxHP;
			atk=198;
			numSpecialTurns=4;
			break;
		}

		inTurn=0;
		cursed=false;
		taunting=false;
		sleeping=false;
	}

	/**
	 * Returns the current HP of this player
	 * @return
	 */
	public double getCurrentHP()
	{
		//INSERT YOUR CODE HERE
		return currentHP;
	}

	/**
	 * Returns type of this player
	 * @return
	 */
	public Player.PlayerType getType()
	{
		//INSERT YOUR CODE HERE
		return type;
	}

	/**
	 * Returns max HP of this player. 
	 * @return
	 */
	public double getMaxHP()
	{
		//INSERT YOUR CODE HERE
		return maxHP;
	}

	/**
	 * Returns whether this player is sleeping.
	 * @return
	 */
	public boolean isSleeping()
	{
		//INSERT YOUR CODE HERE
		return sleeping;
	}

	/**
	 * Returns whether this player is being cursed.
	 * @return
	 */
	public boolean isCursed()
	{
		//INSERT YOUR CODE HERE
		return cursed;
	}

	/**
	 * Returns whether this player is alive (i.e. current HP > 0).
	 * @return
	 */
	public boolean isAlive()
	{
		//INSERT YOUR CODE HERE
		if(currentHP>0) {
			return true;
		}
		return false;
	}

	/**
	 * Returns whether this player is taunting the other team.
	 * @return
	 */
	public boolean isTaunting()
	{
		//INSERT YOUR CODE HERE
		return taunting;
	}


	public void attack(Player target)
	{	
		//INSERT YOUR CODE HERE
		target.currentHP-=this.atk;
		if(target.currentHP<=0) {
			target.currentHP=0;
			target.inTurn=0;
			target.cursed=false;
			target.sleeping=false;
			target.taunting=false;
		}
	}

	public void useSpecialAbility(Player[][] myTeam, Player[][] theirTeam)
	{	
		//INSERT YOUR CODE HERE
		switch(type) {
		case Healer:
			Player dying=lowHp(myTeam);
			if(dying.getCurrentHP()<dying.getMaxHP() && !dying.isCursed()) {
				dying.currentHP+=dying.getMaxHP()*0.25;
				if(dying.getCurrentHP()>dying.getMaxHP()) {
					dying.currentHP=dying.getMaxHP();
				}
			}
			System.out.println("# "  + this.getTeam() + "[" + this.getRow() + "]" + "[" + this.getPosition() + "]" + " " + "{"
					+ this.type.toString() + "}" + " Heals " + dying.getTeam() + "[" + dying.getRow() + "]"
					+ "[" + dying.getPosition() + "]" + " " + "{" + dying.type.toString() + "}");
			break;

		case Tank:
			this.taunting=true;
			System.out.println("# " + this.getTeam() + "[" + this.getRow() + "]" + "[" + this.getPosition() + "]" + " " + "{" + "" + this.type.toString() + "}" + " is Taunting");
			break;

		case Samurai:
			Player target = target(theirTeam);
			if(target != null) {
				attack(target);
				attack(target);
				System.out.println("# " + this.getTeam() + "[" + this.getRow() + "]" + "[" + this.getPosition() + "]" + " " + "{"
						+ this.type.toString() + "}" + " Double-Slashes " + target.getTeam() + "[" + target.getRow() + "]"
						+ "[" + target.getPosition() + "]" + " " + "{" + target.type.toString() + "}");
			}
			break;

		case BlackMage:
			cursetarget = target(theirTeam);
			if(cursetarget != null) {
				cursetarget.cursed=true;
				System.out.println("# " + this.getTeam() + "[" + this.getRow() + "]" + "[" + this.getPosition() + "]" + " " + "{"
						+ this.type.toString() + "}" + " Curses " + cursetarget.getTeam() + "[" + cursetarget.getRow() + "]"
						+ "[" + cursetarget.getPosition() + "]" + " " + "{" + cursetarget.type.toString() + "}");
			}
			break;

		case Phoenix:
			Player revive = reviving(myTeam);
			if(revive != null) {
				revive.currentHP+=revive.getMaxHP()*0.3;
			}
			break;

		case Cherry:
			for(int i=0;i<theirTeam.length;i++) {
				for(int j=0;j<theirTeam[0].length;j++) {
					if(!theirTeam[i][j].isSleeping() && theirTeam[i][j].isAlive()) {
						theirTeam[i][j].sleeping=true;
						System.out.println("# " + this.getTeam() + "[" + this.getRow() + "]" + "[" + this.getPosition() + "]" + " " + "{"
								+ this.type.toString() + "}" + " " + "Feeds a Fortune Cookie to" + " " + theirTeam[i][j].getTeam() + "[" + theirTeam[i][j].getRow() + "]" + "[" + theirTeam[i][j].getPosition() + "]" + " " + "{"
								+ theirTeam[i][j].type.toString() + "}" );
					}
				}
			}
			break;
		}
	}


	/**
	 * This method is called by Arena when it is this player's turn to take an action. 
	 * By default, the player simply just "attack(target)". However, once this player has 
	 * fought for "numSpecialTurns" rounds, this player must perform "useSpecialAbility(myTeam, theirTeam)"
	 * where each player type performs his own special move. 
	 * @param arena
	 */
	public void takeAction(Arena arena)
	{	
		//INSERT YOUR CODE HERE
		if(type == PlayerType.BlackMage && cursetarget!=null){
			cursetarget.cursed = false;
		}
		if (this.isSleeping()){
			this.sleeping = false;
			if(isTaunting()){
				taunting = false;
			}
		}else if(this.isAlive() && !this.isSleeping()) {
			inTurn++;
			if(isTaunting()) {
				taunting=false;
			}

			if(inTurn%numSpecialTurns==0){
				if(arena.isMemberOf(this, Arena.Team.A)){
					useSpecialAbility(arena.getTeamA(), arena.getTeamB() );
				}else{
					useSpecialAbility(arena.getTeamB(), arena.getTeamA() );
				}

			}else{
				Player target = null;
				if(arena.isMemberOf(this, Arena.Team.A)) {
					target = target(arena.getTeamB());
				}else {
					target = target(arena.getTeamA());
				}

				if(target != null && target.isAlive()){
					attack(target);
					System.out.println("# " + this.getTeam() + "[" + this.getRow() + "]" + "[" + this.getPosition() + "]" + " " + "{"
							+ this.type.toString() + "}" + " Attacks " + target.getTeam() + "[" + target.getRow() + "]"
							+ "[" + target.getPosition() + "]" + " " + "{" + target.type.toString() + "}");
				}

			}
		}
	}

	/**
	 * This method overrides the default Object's toString() and is already implemented for you. 
	 */
	@Override
	public String toString()
	{
		return "["+this.type.toString()+" HP:"+this.currentHP+"/"+this.maxHP+" ATK:"+this.atk+"]["
				+((this.isCursed())?"C":"")
				+((this.isTaunting())?"T":"")
				+((this.isSleeping())?"S":"")
				+"]";
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setRow(String row) {
		this.row = row;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public Player lowHp(Player[][] team) {
		Player lowHp;
		lowHp=null;
		double min=9999;
		for(int i=0;i<team.length;i++) {
			for(int j=0;j<team[i].length;j++) {
				if(min>team[i][j].getCurrentHP()/team[i][j].getMaxHP() && team[i][j].isAlive()) {
					lowHp=team[i][j];
					min=team[i][j].getCurrentHP()/team[i][j].getMaxHP();
				}
			}
		}
		return lowHp;
	}

	public Player target(Player enemy[][]) {
		Player target=null;
		boolean atk=false;
		double min=9999;
		for(int i=0;i<enemy.length;i++) {
			for(int j=0;j<enemy[i].length;j++) {
				if(enemy[i][j].isTaunting() && enemy[i][j].isAlive()) {
					return enemy[i][j];
				}
			}
		}

		for(int i=0; i < enemy.length; i++){
			for(int j=0; j < enemy[i].length;  j++){
				if(enemy[i][j].getCurrentHP() > 0 && enemy[i][j].getCurrentHP() < min ){
					min = enemy[i][j].getCurrentHP();
					target = enemy[i][j];
					atk = true;
				}
			}

			if(atk){
				break;
			}
		}
		return target;
	}

	public Player reviving(Player team[][]) {
		for(int i=0;i<team.length;i++) {
			for(int j=0;j<team[i].length;j++) {
				if(!team[i][j].isAlive()) {
					return team[i][j];
				}
			}
		}
		return null;
	}

	public int getPosition() {
		return position;
	}

	public String getRow() {
		return row;
	}

	public String getTeam() {
		return team;
	}
}
